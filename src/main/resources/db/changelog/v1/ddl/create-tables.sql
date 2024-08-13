--liquibase formatted sql
--changeset ananan:create-tables

create table users (
                       id serial primary key,
                       username varchar not null unique,
                       password varchar not null,
                       full_name varchar,
                       email varchar
);

create table poems (
                       id serial primary key,
                       name varchar,
                       content varchar,
                       author_id int,
                       foreign key (author_id) references users(id)
);

create table roles (
                       id serial primary key,
                       name varchar not null
);

create table users_roles (
                             user_id int not null,
                             role_id int not null,
                             primary key (user_id, role_id),
                             foreign key (user_id) references users (id),
                             foreign key (role_id) references roles (id)
);

create table favourites (
                             id serial primary key,
                             user_id int not null,
                             poem_id int not null,
                             foreign key (user_id) references users (id),
                             foreign key (poem_id) references poems (id)
)