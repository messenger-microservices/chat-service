--liquibase formatted sql

--changeset pulsarmn:create_chats_table
CREATE TABLE chats
(
    id         UUID PRIMARY KEY,
    type       VARCHAR(32) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

--rollback DROP TABLE chats:
