SELECT numero, nome, ativo from banco ORDER BY numero;

UPDATE banco SET ativo = false WHERE numero = 0;

-- COMANDO PARA INICIAR TRANSAÇÃO. O ROLLBACK indica o ponto de retorno ao estado anterior
BEGIN;
UPDATE banco SET ativo = true WHERE numero = 0;
SELECT numero, nome, ativo from banco WHERE numero = 0;
ROLLBACK;

BEGIN;
UPDATE banco SET ativo = true WHERE numero = 0;
COMMIT;

SELECT id, gerente, nome from funcionarios;

BEGIN;
UPDATE funcionarios SET gerente = 2 WHERE id = 3;
SAVEPOINT sf_func;
UPDATE funcionarios SET gerente = null;
ROLLBACK TO sf_func;
UPDATE funcionarios SET gerente = 3 WHERE id = 5;
COMMIT;
