CREATE OR REPLACE FUNCTION func_somar(INTEGER, INTEGER)
RETURNS INTEGER
SECURITY DEFINER
-- RETURNS NULL ON NULL INPUT -- RETORNA NULL CASO A ENTRADA SEJA NULA
CALLED ON NULL INPUT          -- CHAMA UMA FUNÇÃO PRA TRATAR O NULO
LANGUAGE SQL
AS 
$$
	SELECT COALESCE($1, 0) + COALESCE($2, 0);
$$;

SELECT func_somar(5,5);
-----------------------------------------------------

CREATE OR REPLACE FUNCTION bancos_add(p_numero INTEGER, p_nome VARCHAR, p_ativo BOOLEAN)
RETURNS INTEGER
SECURITY INVOKER
LANGUAGE PLPGSQL
CALLED ON NULL INPUT   
AS 
$$
	DECLARE var_id INTEGER;
	BEGIN
		IF p_numero IS NULL OR p_nome IS NULL OR p_ativo IS NULL THEN
			RETURN 0;
		END IF;
		
		SELECT INTO var_id numero FROM banco WHERE numero = p_numero;
		
		IF var_id IS NULL THEN
			INSERT INTO banco(numero, nome, ativo) VALUES (p_numero, p_nome, p_ativo);
		ELSE
			RETURN var_id;
		END IF;
		
		SELECT INTO var_id numero FROM banco WHERE numero = p_numero;
		
		RETURN var_id;
	END;
$$;

SELECT bancos_add(5433, 'Banco Novo', true);
SELECT numero, nome, ativo from banco where numero = 5433;