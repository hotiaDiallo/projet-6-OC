
-- ================================== TABLES =================================== --
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS work;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS loan;
DROP TABLE IF EXISTS library;


CREATE TABLE author (
                id INT AUTO_INCREMENT NOT NULL,
                first_name VARCHAR(50) NOT NULL,
                last_name VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);


CREATE TABLE work (
                id INT AUTO_INCREMENT NOT NULL,
                author_id INT NOT NULL,
                title VARCHAR(100) NOT NULL,
                summary VARCHAR(100) NOT NULL,
                release_date DATETIME NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE library (
                id INT NOT NULL,
                name VARCHAR(50) NOT NULL,
                work_id INT NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE book (
                id INT AUTO_INCREMENT NOT NULL,
                work_id INT NOT NULL,
                isbn VARCHAR(50) NOT NULL,
                book_status BOOLEAN NOT NULL,
PRIMARY KEY (id)
);


CREATE TABLE user (
                id INT AUTO_INCREMENT NOT NULL,
                first_name VARCHAR(100) NOT NULL,
                last_name VARCHAR(100) NOT NULL,
                birth_date DATETIME,
                local_adress VARCHAR(100),
                postal_code INT,
                city VARCHAR(50),
                email VARCHAR(50) NOT NULL,
                password VARCHAR(50) NOT NULL,
                phone_number VARCHAR(50),
PRIMARY KEY (id)
);

CREATE TABLE loan (
                id INT NOT NULL,
                user_id INT NOT NULL,
                work_id INT NOT NULL,
                borrowing_date DATETIME NOT NULL,
                returning_date DATETIME NOT NULL,
                loan_status VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);


ALTER TABLE work ADD CONSTRAINT author_work_fk
FOREIGN KEY (author_id)
REFERENCES author (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE book ADD CONSTRAINT work_book_fk
FOREIGN KEY (work_id)
REFERENCES work (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE library ADD CONSTRAINT work_library_fk
FOREIGN KEY (work_id)
REFERENCES work (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE loan ADD CONSTRAINT work_loan_fk
FOREIGN KEY (work_id)
REFERENCES work (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE loan ADD CONSTRAINT user_loan_fk
FOREIGN KEY (user_id)
REFERENCES user (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- ========================================================================== --

