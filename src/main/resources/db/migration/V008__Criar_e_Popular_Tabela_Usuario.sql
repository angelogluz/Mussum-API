CREATE TABLE usuario(
  id INT AUTO_INCREMENT,
  nome VARCHAR(30),
  username VARCHAR(30),
  password VARCHAR(30),
  PRIMARY KEY (id)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (nome, username, password) VALUES
("Angelo", "angeloz", "123456"),
("Gladimir", "glad", "123456"),
("Edecio", "edecio", "123456"),
("Carlos Vinicios", "cv", "123456"),
("Dartaschnhannegger", "dart", "123456");