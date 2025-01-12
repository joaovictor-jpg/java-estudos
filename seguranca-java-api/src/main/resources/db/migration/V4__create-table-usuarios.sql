CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    nome_usuario VARCHAR(100) NOT NULL,
    mini_biografia VARCHAR(30),
    biografia TEXT
);