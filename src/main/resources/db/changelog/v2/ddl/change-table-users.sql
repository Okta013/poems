--liquibase formatted sql
--changeset ananan:change-table-users

ALTER TABLE users ADD is_active boolean;