--liquibase formatted sql
--changeset ananan:insert-data-favourites

insert into favourites (user_id, poem_id) values (3, 1);
insert into favourites (user_id, poem_id) values (3, 6);
insert into favourites (user_id, poem_id) values (5, 1);
insert into favourites (user_id, poem_id) values (5, 2);
insert into favourites (user_id, poem_id) values (5, 5);
insert into favourites (user_id, poem_id) values (2, 4);
insert into favourites (user_id, poem_id) values (2, 6);