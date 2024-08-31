/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Aluno
 * Created: 22 de ago. de 2024
 */
CREATE DATABASE ifpr;
USE IFPR;

CREATE TABLE IF NOT EXISTS categoria (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS produto(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL,
    valor FLOAT,
    categoria_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);


