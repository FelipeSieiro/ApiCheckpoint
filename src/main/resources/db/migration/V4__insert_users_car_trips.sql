INSERT INTO users (name, email, password, created_at, updated_at) 
VALUES 
('John Doe', 'john.doe@example.com', 'hashed_password_123', NOW(), NOW()),
('Jane Smith', 'jane.smith@example.com', 'hashed_password_456', NOW(), NOW());

-- Inserção de dados na tabela car
INSERT INTO car (user_id, valor_car) 
VALUES 
(1, 1500.50),  -- Associa o carrinho ao usuário 'John Doe' (id 1)
(2, 2200.75);  -- Associa o carrinho ao usuário 'Jane Smith' (id 2)

-- Inserção de dados na tabela trip
INSERT INTO trip (name_local, valor, fotourl, user_id, car_id)
VALUES
('Trip to Paris', 1200.00, 'paris_photo.jpg', 1, 1),  -- Viagem de 'John Doe' com carrinho 1
('Trip to Tokyo', 2000.00, 'tokyo_photo.jpg', 2, 2),  -- Viagem de 'Jane Smith' com carrinho 2
('Trip to New York', 1800.00, 'ny_photo.jpg', 1, 1);  -- Outra viagem de 'John Doe' com o mesmo carrinho