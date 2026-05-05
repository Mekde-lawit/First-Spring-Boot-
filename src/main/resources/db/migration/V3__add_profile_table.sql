CREATE table profiles (
    id BIGINT PRIMARY KEY,
    bio TEXT,
    phone_number VARCHAR(20),
    date_of_birth DATE,
    loyality_points INT UNSIGNED DEFAULT 0,
    FOREIGN KEY (id) REFERENCES users(id)
);