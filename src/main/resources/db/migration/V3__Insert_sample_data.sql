-- Data insertion script for testing
-- Run this after migrations to populate sample data

-- Insert sample authors
INSERT INTO authors (name, email, country, birth_date) VALUES ('J.K. Rowling', 'jk@example.com', 'United Kingdom', DATE '1965-07-31');
INSERT INTO authors (name, email, country, birth_date) VALUES ('George R.R. Martin', 'george@example.com', 'United States', DATE '1948-09-20');
INSERT INTO authors (name, email, country, birth_date) VALUES ('J.R.R. Tolkien', 'jrr@example.com', 'United Kingdom', DATE '1892-01-03');
INSERT INTO authors (name, email, country, birth_date) VALUES ('Stephen King', 'stephen@example.com', 'United States', DATE '1947-09-21');
INSERT INTO authors (name, email, country, birth_date) VALUES ('Agatha Christie', 'agatha@example.com', 'United Kingdom', DATE '1890-01-15');

-- Insert sample books
INSERT INTO books (title, author, author_id, isbn, published_date, pages) VALUES ('Harry Potter and the Philosophers Stone', 'J.K. Rowling', 1, '978-0747532699', DATE '1997-06-26', 309);
INSERT INTO books (title, author, author_id, isbn, published_date, pages) VALUES ('A Game of Thrones', 'George R.R. Martin', 2, '978-0553103540', DATE '1996-08-06', 694);
INSERT INTO books (title, author, author_id, isbn, published_date, pages) VALUES ('The Fellowship of the Ring', 'J.R.R. Tolkien', 3, '978-0544003415', DATE '1954-07-29', 423);
INSERT INTO books (title, author, author_id, isbn, published_date, pages) VALUES ('The Shining', 'Stephen King', 4, '978-0385333312', DATE '1977-01-28', 447);
INSERT INTO books (title, author, author_id, isbn, published_date, pages) VALUES ('Murder on the Orient Express', 'Agatha Christie', 5, '978-0062693976', DATE '1934-01-01', 256);
INSERT INTO books (title, author, author_id, isbn, published_date, pages) VALUES ('Harry Potter and the Chamber of Secrets', 'J.K. Rowling', 1, '978-0747538494', DATE '1998-07-02', 341);
INSERT INTO books (title, author, author_id, isbn, published_date, pages) VALUES ('The Two Towers', 'J.R.R. Tolkien', 3, '978-0544003422', DATE '1954-11-11', 352);
INSERT INTO books (title, author, author_id, isbn, published_date, pages) VALUES ('It', 'Stephen King', 4, '978-1501156717', DATE '1986-09-15', 1138);


