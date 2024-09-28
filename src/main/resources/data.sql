INSERT INTO AUTHORIZATION.USERS (username, password, name, role )
VALUES ('user1', '$2a$10$vWEI5QMKoRRuwcVa.wW6TOvL72fOE6abMbi3viK0kS30o9BbKm7Yq', 'Nombre 1', 'USER'); --pass 123456

INSERT INTO AUTHORIZATION.USERS (username, password, name, role )
VALUES ( 'admin1', '$2a$10$4i5eN04E2eaVjeiIWYfb..iwo9b.gGzbXm7uyIjSbM.4shoZTncai', 'Nombre 2', 'ADMIN'); --pass asdfgh

-- INSERT INTO AUTHORIZATION.ROLES(description, name)
-- VALUES('user role', 'USER');6
--
-- INSERT INTO AUTHORIZATION.ROLES(description, name)
-- VALUES('admin role', 'ADMIN');
--
-- INSERT INTO AUTHORIZATION.ROLES(description, name)
-- VALUES('Super user role', 'SUPER_USER');

-- pass: asdf

--
-- INSERT INTO AUTHORIZATION.USERS_ROLES
-- VALUES (1, 1);
--
-- INSERT INTO AUTHORIZATION.USERS_ROLES
-- VALUES (2, 1);
--
-- INSERT INTO AUTHORIZATION.USERS_ROLES
-- VALUES (1, 2);