CREATE TABLE IF NOT EXISTS car (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    valor_car FLOAT NOT NULL,
    CONSTRAINT fk_user_car FOREIGN KEY (user_id) REFERENCES users(id)
);