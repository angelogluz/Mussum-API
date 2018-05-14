CREATE TABLE usuario (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
	id INT AUTO_INCREMENT PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao (
	id_usuario INT NOT NULL,
	id_permissao INT NOT NULL,
	PRIMARY KEY (id_usuario, id_permissao),
	FOREIGN KEY (id_usuario) REFERENCES usuario(id),
	FOREIGN KEY (id_permissao) REFERENCES permissao(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (id, nome, email, senha) values (1, 'Administrador', 'angelogl@gmail.com', '{bcrypt}$2a$10$8Pc1KGsm3tR1x9vHpolQLuk8iGaNUzvNoubnt1mA7x4OPabXipaOW');
INSERT INTO usuario (id, nome, email, senha) values (2, 'aluno', 'aluno@gmail.com', 'aluno');

INSERT INTO permissao (id,descricao) values (1,'ROLE_CADASTRAR_AULA');
INSERT INTO permissao (id,descricao) values (2,'ROLE_PESQUISAR_AULA');

INSERT INTO permissao (id,descricao) values (3,'ROLE_CADASTRAR_CONTEUDO');
INSERT INTO permissao (id,descricao) values (4,'ROLE_REMOVER_CONTEUDO');
INSERT INTO permissao (id,descricao) values (5,'ROLE_PESQUISAR_CONTEUDO');

INSERT INTO permissao (id,descricao) values (6,'ROLE_CADASTRAR_CURSO');
INSERT INTO permissao (id,descricao) values (7,'ROLE_REMOVER_CURSO');
INSERT INTO permissao (id,descricao) values (8,'ROLE_PESQUISAR_CURSO');

INSERT INTO permissao (id,descricao) values (9,'ROLE_CADASTRAR_UNIDADE');
INSERT INTO permissao (id,descricao) values (10,'ROLE_REMOVER_UNIDADE');
INSERT INTO permissao (id,descricao) values (11,'ROLE_PESQUISAR_UNIDADE');

-- angelogl@gmail.com
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 1);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 2);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 3);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 4);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 5);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 6);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 7);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 8);

-- aluno@gmail.com
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (2, 2);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (2, 5);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (2, 8);