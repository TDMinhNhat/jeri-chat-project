-- V1: Create some tables for group-service

CREATE TABLE groups
(
    id          BIGSERIAL PRIMARY KEY,
    deleted     BOOLEAN   DEFAULT FALSE             NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at  TIMESTAMP,
    version     BIGINT    DEFAULT 0                 NOT NULL,
    title       VARCHAR(200)                        NOT NULL,
    description VARCHAR(300)                        NOT NULL,
    avatar      TEXT,
    link_group  TEXT,
    join_type   VARCHAR(200)                        NOT NULL
);

CREATE TABLE group_members
(
    id            BIGSERIAL PRIMARY KEY,
    deleted       BOOLEAN      DEFAULT FALSE             NOT NULL,
    created_at    TIMESTAMP    DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at    TIMESTAMP,
    version       BIGINT       DEFAULT 0                 NOT NULL,
    group_id      BIGINT                                 NOT NULL,
    user_id       BIGINT                                 NOT NULL,
    role          VARCHAR(100) DEFAULT 'MEMBER'          NOT NULL,
    user_approval BIGINT
);

ALTER TABLE group_members
    ADD CONSTRAINT FK__group_id__group_members FOREIGN KEY (group_id) REFERENCES groups (id);