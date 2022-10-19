CREATE ROLE professores NOCREATEDB NOCREATEROLE INHERIT NOLOGIN NOBYPASSRLS CONNECTION LIMIT 10;
ALTER ROLE professores PASSWORD '123';

-- CREATE ROLE thierry LOGIN PASSWORD '123';
DROP ROLE thierry;
-- CREATE ROLE thierry LOGIN PASSWORD '123' IN ROLE professores; -- thierry faz parte de professores
--  CREATE ROLE thierry LOGIN PASSWORD '123' ROLE professores; -- professores faz parte de thierry
 
 CREATE TABLE teste (nome varchar);
 GRANT ALL ON TABLE teste TO professores; -- dando todos os privilegios na tabela teste para a ROLE professores
 CREATE ROLE thierry LOGIN PASSWORD '123';
 CREATE ROLE thierry INHERIT LOGIN PASSWORD '123' IN ROLE professores; --thierry agora faz parte da role professores e herda as permissoes
 
 REVOKE professores FROM thierry; -- removi thierry das permissoes de professores