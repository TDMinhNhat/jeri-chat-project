-- V2: Update group_members table

-- Add constraint default the column "role" to 'MEMBER' if not set
ALTER TABLE group_members
    ALTER COLUMN role SET DEFAULT 'MEMBER';

-- Add new column "status" to indicate the membership status
ALTER TABLE group_members
    ADD COLUMN status VARCHAR(100) DEFAULT 'JOINING' NOT NULL;