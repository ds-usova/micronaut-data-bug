package org.specification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.specification.OracleContainer.ORACLE;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.jpa.repository.criteria.Specification;
import io.micronaut.data.repository.jpa.criteria.QuerySpecification;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.test.support.TestPropertyProvider;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.specification.db.Book;
import org.specification.db.BookLegacyRepository;
import org.specification.db.BookRepository;
import org.testcontainers.junit.jupiter.Testcontainers;

@Slf4j
@Testcontainers(disabledWithoutDocker = true)
@MicronautTest(propertySources = "classpath:application-test.properties", transactional = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookRepositoryTest implements TestPropertyProvider {

    @Inject
    BookLegacyRepository bookLegacyRepository;

    @Inject
    BookRepository bookRepository;

    static {
        log.info("Oracle Container is running: {}", ORACLE.isRunning());
    }

    @Override
    public @NonNull Map<String, String> getProperties() {
        return Map.of(
                "datasources.default.url", ORACLE.getJdbcUrl(),
                "datasources.default.username", ORACLE.getUsername(),
                "datasources.default.password", ORACLE.getPassword(),
                "jpa.default.properties.hibernate.connection.url", ORACLE.getJdbcUrl(),
                "jpa.default.properties.hibernate.connection.username", ORACLE.getUsername(),
                "jpa.default.properties.hibernate.connection.password", ORACLE.getPassword(),
                "flyway.datasources.default.url", ORACLE.getJdbcUrl(),
                "flyway.datasources.default.username", ORACLE.getUsername(),
                "flyway.datasources.default.password", ORACLE.getPassword()
        );
    }

    @Test
    void findByAuthorReturnsExpectedRows() {
        List<Book> books = bookLegacyRepository.findByAuthor("J.K. Rowling").collectList().block();

        assertNotNull(books);
        assertEquals(2, books.size());
        assertTrue(books.stream().allMatch(book -> "J.K. Rowling".equals(book.getAuthor())));
    }

    @Test
    void legacy_findAllBySpecificationFiltersCorrectly() {
        Specification<Book> authorSpec = (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("author"), "J.K. Rowling");

        List<Book> books = bookLegacyRepository.findAll(authorSpec).collectList().block();

        assertNotNull(books);
        assertFalse(books.isEmpty());
        assertEquals(2, books.size());
        assertTrue(books.stream().allMatch(book -> "J.K. Rowling".equals(book.getAuthor())));
    }

    @Test
    void findAllBySpecificationFiltersCorrectly() {
        QuerySpecification<Book> authorSpec = (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("author"), "J.K. Rowling");

        List<Book> books = bookRepository.findAll(authorSpec).collectList().block();

        assertNotNull(books);
        assertFalse(books.isEmpty());
        assertEquals(2, books.size());
        assertTrue(books.stream().allMatch(book -> "J.K. Rowling".equals(book.getAuthor())));
    }

}

