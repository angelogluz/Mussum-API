ALTER TABLE aula ADD created_at DATE AFTER id;
ALTER TABLE unidade ADD created_at DATE AFTER id;
ALTER TABLE conteudo ADD created_at DATE AFTER id;
ALTER TABLE curso ADD created_at DATE AFTER id;
ALTER TABLE usuario ADD created_at DATE AFTER id;

UPDATE usuario
SET created_at = '2017-06-11'
WHERE email='angelogl@gmail.com';

UPDATE usuario
SET created_at = '2018-04-11'
WHERE email='aluno@gmail.com';
