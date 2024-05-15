CREATE DATABASE livros;

USE livros;

CREATE TABLE livros.livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    isbn VARCHAR(20),
    data_lancamento DATE,
    genero VARCHAR(50),
    data_emprestimo DATE,
    data_devolucao DATE
);

CREATE TABLE livros.usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(50),
    senha VARCHAR(50),
    status VARCHAR(20),
    tipo VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS livros.usuarios_livros (
      id BIGINT NOT NULL AUTO_INCREMENT,
	  idU BIGINT NOT NULL,
	  idL BIGINT NOT NULL,
	  obs VARCHAR(255),
	  primary key (id)
);
DROP TABLE usuario_livros;

INSERT INTO livros.livros (id, titulo, isbn, data_lancamento, genero, data_emprestimo, data_devolucao)
VALUES ('1', 'O Senhor dos Anéis: A Sociedade do Anel', '9780345339706', '1954-07-29', 'Fantasia', '2024-02-23', '2024-03-23'),
       ('2', 'Harry Potter e a Pedra Filosofal', '9788532530631', '1997-06-26', 'Fantasia', '2024-02-22', '2024-03-22'),
       ('3', 'A Revolução dos Bichos', '9780451526342', '1945-08-17', 'Fábula', '2024-02-20', '2024-03-20'),
       ('4', '1984', '9780451524935', '1949-06-08', 'Ficção Distópica', '2024-02-21', '2024-03-23');

INSERT INTO livros.usuarios (login, senha, status, tipo)
VALUES ('usuario1', 'senha123', 'ativo', 'comum'),
       ('admin', 'admin123', 'ativo', 'administrador');



INSERT INTO livros.usuarios_livros (id, id_usuario, id_livro, data_emprestimo, data_devolucao) VALUES
(1, 1, 1, '2024-03-01', '2024-03-15'),
(2, 2, 2, '2024-03-05', '2024-03-20'),
(3, 1, 3, '2024-03-10', '2024-03-25');
