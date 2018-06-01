ALTER TABLE aula ADD created_at TIMESTAMP AFTER id;
ALTER TABLE unidade ADD created_at TIMESTAMP AFTER id;
ALTER TABLE conteudo ADD created_at TIMESTAMP AFTER id;
ALTER TABLE curso ADD created_at TIMESTAMP AFTER id;
ALTER TABLE usuario ADD created_at TIMESTAMP AFTER id;