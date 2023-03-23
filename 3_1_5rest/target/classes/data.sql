-- This is for performing tests
-- ROLE_ADMIN.id = 1
-- ROLE_USER.id = 2
INSERT INTO role (authority)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER');

-- admin.password == "12345"
-- user.password == "12345"
INSERT INTO user (first_name, last_name, age, email, password)
VALUES ('admin', 'admin', 35, 'admin@mail.ru', '$2a$12$sLPj3voKe6MlgEzzOsSEz.tnZtXuHoJDeWlzNK98eoSs8gjAf6GaG'),
       ('user', 'user', 30, 'user@mail.ru', '$2a$12$sLPj3voKe6MlgEzzOsSEz.tnZtXuHoJDeWlzNK98eoSs8gjAf6GaG');

-- admin.role == ROLE_ADMIN, ROLE_USER
-- user.role == ROLE_USER
INSERT INTO user_role (user_id, role_id)
VALUES (1, 1), -- These id values' will be only if database was created initially
       (1, 2),
       (2, 2);


-- add other users for test
-- passwords still the same ("12345")
INSERT INTO user (first_name, last_name, age, username, password, email)
VALUES ('Иван', 'Иванов', 25, 'user1', '$2a$12$sLPj3voKe6MlgEzzOsSEz.tnZtXuHoJDeWlzNK98eoSs8gjAf6GaG', 'user1@mail.ru'),
       ('Николай', 'Сидоров', 19, 'user2', '$2a$12$sLPj3voKe6MlgEzzOsSEz.tnZtXuHoJDeWlzNK98eoSs8gjAf6GaG',
        'user2@mail.ru'),
       ('Мария', 'Сергеева', 31, 'user3', '$2a$12$sLPj3voKe6MlgEzzOsSEz.tnZtXuHoJDeWlzNK98eoSs8gjAf6GaG',
        'user3@mail.ru'),
       ('Charlene', 'Austin', 42, 'user4', '$2a$12$sLPj3voKe6MlgEzzOsSEz.tnZtXuHoJDeWlzNK98eoSs8gjAf6GaG',
        'user4@mail.ru'),
       ('Terrence', 'Hicks', 36, 'user5', '$2a$12$sLPj3voKe6MlgEzzOsSEz.tnZtXuHoJDeWlzNK98eoSs8gjAf6GaG',
        'user5@mail.ru'),
       ('Alexa', 'Lawson', 45, 'user6', '$2a$12$sLPj3voKe6MlgEzzOsSEz.tnZtXuHoJDeWlzNK98eoSs8gjAf6GaG',
        'user6@mail.ru'),
       ('Aaron', 'Lee', 55, 'user7', '$2a$12$sLPj3voKe6MlgEzzOsSEz.tnZtXuHoJDeWlzNK98eoSs8gjAf6GaG', 'user7@mail.ru');



-- give roles to these users
INSERT INTO user_role (user_id, role_id)
VALUES (3, 1),
       (3, 2),
       (4, 2),
       (5, 2),
       (6, 2),
       (7, 2),
       (8, 1),
       (8, 2),
       (9, 2);