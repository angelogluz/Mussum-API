CREATE TABLE faculdade(
  id INT AUTO_INCREMENT,
  nome VARCHAR(45),
  cnpj VARCHAR(45),
  PRIMARY KEY (id)
) ENGINE=innoDB DEFAULT CHARSET=utf8;

  CREATE TABLE unidade_faculdade(
    faculdade_id INTEGER,
    unidade_id INTEGER,
    FOREIGN KEY (faculdade_id) REFERENCES faculdade(id),
    FOREIGN KEY (unidade_id) REFERENCES unidade(id)
  )ENGINE =innoDB DEFAULT CHARSET =utf8;

INSERT INTO faculdade (nome, cnpj)
    VALUES ("FATEC", "123123123");

INSERT INTO faculdade (nome, cnpj)
VALUES ("FSPOA", "1233393123");

INSERT INTO unidade_faculdade(faculdade_id, unidade_id)
    VALUES (1,1);

INSERT INTO unidade_faculdade(faculdade_id, unidade_id)
VALUES (1,2);