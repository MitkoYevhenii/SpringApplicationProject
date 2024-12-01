CREATE TABLE users (
                       username VARCHAR(500) PRIMARY KEY,
                       password VARCHAR(1000) NOT NULL,
                       enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
                             username VARCHAR(500) NOT NULL,
                             authority VARCHAR(500) NOT NULL,
                             FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO users (username, password, enabled)
VALUES ('user', '{noop}jdbcDefault', TRUE);

INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER');

