package org.specification.db;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.jpa.reactive.ReactorJpaSpecificationExecutor;

@Repository
public interface BookRepository extends ReactorJpaSpecificationExecutor<Book> {

}

