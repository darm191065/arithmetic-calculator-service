INSERT INTO AUTHORIZATION.ROLES(description, name)
VALUES('user role', 'USER');

INSERT INTO AUTHORIZATION.ROLES(description, name)
VALUES('admin role', 'ADMIN');

INSERT INTO AUTHORIZATION.ROLES(description, name)
VALUES('Super user role', 'SUPER_USER');

-- pass: asdf
-- INSERT INTO AUTHORIZATION.USERS ( id, email, name, password, username )
-- VALUES (1, 'doe.admin@b.com', 'John Doe', '$2a$12$EJQWrLsLtWF1WbywbGOhvObnykyMBeRi58aZnjIekiwzcBiIkAksG', 'johndoe123');
--
-- INSERT INTO AUTHORIZATION.USERS ( id, email, name, password, username )
-- VALUES (2, 'doe.user@b.com', 'John Doe', '$2a$12$EJQWrLsLtWF1WbywbGOhvObnykyMBeRi58aZnjIekiwzcBiIkAksG', 'user');
--
-- INSERT INTO AUTHORIZATION.USERS_ROLES
-- VALUES (1, 1);
--
-- INSERT INTO AUTHORIZATION.USERS_ROLES
-- VALUES (2, 1);
--
-- INSERT INTO AUTHORIZATION.USERS_ROLES
-- VALUES (1, 2);