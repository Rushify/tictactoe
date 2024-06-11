CREATE DATABASE tic_tac_toe;

USE tic_tac_toe;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL
);

CREATE TABLE scores (
    score_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    score INT,
    completed_games INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
