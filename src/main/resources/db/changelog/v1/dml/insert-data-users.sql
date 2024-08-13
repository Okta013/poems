--liquibase formatted sql
--changeset ananan:insert-data-users

insert into users (username, password, full_name, email)
VALUES ('Goraciy', '$2a$12$MMRdPC14mTdmc8rMqjU7WOAKvb662YEeEnC3J7PbJWni7av7YBXeC', 'Konstantin Gorchakov', 'gorac@gmail.com');
insert into users (username, password, full_name, email)
VALUES ('Borovichok', '$2a$12$MMRdPC14mTdmc8rMqjU7WOAKvb662YEeEnC3J7PbJWni7av7YBXeC', 'Innokentiy Orlov', 'kesha007@yandex.ru');
insert into users (username, password, full_name, email)
VALUES ('Cirilla', '$2a$12$MMRdPC14mTdmc8rMqjU7WOAKvb662YEeEnC3J7PbJWni7av7YBXeC', 'Karina Menshova', 'lioncubfromcintra@gmail.com');
insert into users (username, password, full_name, email)
VALUES ('Skald', '$2a$12$MMRdPC14mTdmc8rMqjU7WOAKvb662YEeEnC3J7PbJWni7av7YBXeC', 'Igor Brown', 'igorbrown@yandex.ru');
insert into users (username, password, full_name, email)
VALUES ('Agnessa', '$2a$12$MMRdPC14mTdmc8rMqjU7WOAKvb662YEeEnC3J7PbJWni7av7YBXeC', 'Elena Akimova', 'agness@mail.ru');
insert into users (username, password, full_name, email)
VALUES ('Bear', '$2a$12$MMRdPC14mTdmc8rMqjU7WOAKvb662YEeEnC3J7PbJWni7av7YBXeC', 'Roman Ovechkin', 'bearbrother@yandex.ru');