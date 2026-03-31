# demo-data

Minimal Micronaut sample for reproducing a repository bug with Oracle, Flyway, and Testcontainers.

## Stack

- Java 21
- Micronaut 4.10.10
- Micronaut Data JPA / Hibernate Reactive
- Oracle
- Flyway
- JUnit 5
- Testcontainers

## Purpose

This project demonstrates a bug where `BookRepositoryTest.findAllBySpecificationFiltersCorrectly()` fails.

It provides a small comparison between:

- `BookLegacyRepository` — legacy specification path
- `BookRepository` — newer reactive JPA specification executor path

The intended contrast in `BookRepositoryTest` is:

- `findByAuthorReturnsExpectedRows()` passes
- `legacy_findAllBySpecificationFiltersCorrectly()` passes
- `findAllBySpecificationFiltersCorrectly()` fails