--liquibase formatted sql
--changeset ananan:change-data-for-users

UPDATE users SET is_active = true;