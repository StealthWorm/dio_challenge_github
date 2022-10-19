SELECT numero, nome FROM banco;
SELECT banco_numero, numero, nome FROM agencia;

--tabela temporária
WITH tbl_tmp_banco AS (
	SELECT numero, nome
	FROM banco
)
SELECT numero, nome FROM tbl_tmp_banco

WITH params AS(
	SELECT 213 AS banco_numero	
), tbl_tmp_banco AS (
	SELECT numero, nome
	FROM banco
	INNER JOIN params ON params.banco_numero = banco.numero
)
SELECT numero, nome FROM tbl_tmp_banco


WITH params_name AS(
	SELECT 'Thierry Santos' AS cliente_nome	
), tbl_tmp_banco AS (
	SELECT nome
	FROM cliente
	INNER JOIN params_name ON params_name.cliente_nome = cliente.nome
)
SELECT nome FROM tbl_tmp_banco

WITH clientes_e_transac AS(
	SELECT cliente.nome as cliente_nome,
	       tipo_transacao.nome as tipo_transacao_nome,
		   cliente_transacoes.valor as tipo_transacao_valor
	FROM cliente_transacoes
	INNER JOIN cliente ON cliente.numero = cliente_transacoes.cliente_numero
	INNER JOIN tipo_transacao ON tipo_transacao.id = cliente_transacoes.tipo_transacao_id
	INNER JOIN banco ON banco.numero = cliente_transacoes.banco_numero
		AND cliente.nome LIKE '%Thierry%'
)
SELECT cliente_nome, tipo_transacao_nome, tipo_transacao_valor FROM clientes_e_transac;

-- funciona com subselects tambem



