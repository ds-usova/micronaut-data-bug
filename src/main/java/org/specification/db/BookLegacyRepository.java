package org.specification.db;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.hibernate.reactive.repository.jpa.ReactorJpaSpecificationExecutor;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookLegacyRepository extends ReactorPageableRepository<Book, Long>, ReactorJpaSpecificationExecutor<Book> {

    Flux<Book> findByAuthor(String author);

    Mono<Book> findByIsbn(String isbn);
}

