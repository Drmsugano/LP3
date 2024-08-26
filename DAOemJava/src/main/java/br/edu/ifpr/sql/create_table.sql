

CREATE DATABASE ifpr;
use ifpr;

CREATE TABLE IF NOT EXISTS categoria (
    id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS produto (
    id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(45) NOT NULL,
    categoria_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (categoria_id)
        REFERENCES categoria(id)
        ON DELETE CASCADE
);
