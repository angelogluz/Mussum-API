ALTER TABLE curso ADD coordenador VARCHAR(255) AFTER nome;

UPDATE curso
SET coordenador="Angelo"
WHERE id=1;

UPDATE curso
SET coordenador="Angelo"
WHERE id=2;