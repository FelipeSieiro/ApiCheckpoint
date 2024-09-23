CREATE TABLE IF NOT EXISTS trip (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_local VARCHAR(255) NOT NULL,
    valor FLOAT NOT NULL,
    fotourl VARCHAR(255),
    user_id BIGINT,
    car_id BIGINT,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_car FOREIGN KEY (car_id) REFERENCES car(id)
);