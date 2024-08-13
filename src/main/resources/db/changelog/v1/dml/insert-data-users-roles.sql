--liquibase formatted sql
--changeset ananan:insert-data-users-roles

insert into users_roles values (2, 1);
insert into users_roles values (4, 1);
insert into users_roles values (6, 1);
insert into users_roles values (1, 3);
insert into users_roles values (1, 1);
insert into users_roles values (3, 2);
insert into users_roles values (5, 2);