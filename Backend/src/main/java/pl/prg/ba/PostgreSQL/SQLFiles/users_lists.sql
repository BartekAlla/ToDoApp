CREATE TABLE IF NOT EXISTS users_lists (
    userID INT,
    listID INT,
    userRole VARCHAR(255),
    CONSTRAINT fk_users
        FOREIGN KEY (userID)
        REFERENCES users (id),
    CONSTRAINT fk_lists
        FOREIGN KEY (listID)
        REFERENCES lists (id)
);