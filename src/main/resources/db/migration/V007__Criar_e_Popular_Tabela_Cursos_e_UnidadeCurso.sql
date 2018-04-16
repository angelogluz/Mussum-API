CREATE TABLE curso(
  id INT AUTO_INCREMENT,
  nome VARCHAR(45),
  data_fundacao DATE,
  PRIMARY KEY (id)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

  CREATE TABLE unidade_curso(
    curso_id INTEGER,
    unidade_id INTEGER,
    FOREIGN KEY (curso_id) REFERENCES curso(id),
    FOREIGN KEY (unidade_id) REFERENCES unidade(id)
  )ENGINE =innoDB DEFAULT CHARSET =utf8;

INSERT INTO curso (nome, data_fundacao)
    VALUES ("Análise e Desenvolvimento de Sistemas", "2003-03-01");

INSERT INTO curso (nome, data_fundacao)
VALUES ("Redes de Computadores", "2006-03-01");

INSERT INTO unidade_curso(unidade_id,curso_id)
    VALUES (2,2);
