--liquibase formatted sql

--changeset pulsarmn:create_chat_members_table
CREATE TABLE chat_members
(
    chat_id UUID REFERENCES chats (id) ON DELETE CASCADE,
    user_id UUID        NOT NULL,
    role    VARCHAR(32) NOT NULL,
    joined_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT pk_chat_members PRIMARY KEY (chat_id, user_id)
);

--rollback DROP TABLE chat_members;
