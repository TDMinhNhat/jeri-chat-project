-- V1: Create friends table

CREATE TABLE friends
(
    id              BIGSERIAL PRIMARY KEY,
    sender_id       BIGINT       NOT NULL,
    receiver_id     BIGINT       NOT NULL,
    message_request VARCHAR(200) NOT NULL,
    status          VARCHAR(50)  NOT NULL,
    deleted         BOOLEAN      NOT NULL DEFAULT FALSE,
    created_at      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP,
    version         INTEGER      NOT NULL DEFAULT 0
)