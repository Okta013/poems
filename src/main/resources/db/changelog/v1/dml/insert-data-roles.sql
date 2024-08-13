--liquibase formatted sql
--changeset ananan:insert-data-roles

insert into roles (name) values ('ROLE_AUTHOR');
insert into roles (name) values ('ROLE_READER');
insert into roles (name) values ('ROLE_ADMIN');