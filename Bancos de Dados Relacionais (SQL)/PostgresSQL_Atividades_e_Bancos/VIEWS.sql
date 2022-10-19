select numero, nome, ativo from banco;

create or replace view vw_bancos as (
	select numero, nome, ativo
	from banco
);
select numero, nome, ativo from vw_bancos;

create or replace view vw_bancos_2 (banco_numero, banco_nome, banco_ativo) as (
	select numero, nome, ativo
	from banco
);
select banco_numero, banco_nome, banco_ativo from vw_bancos_2;

insert into vw_bancos_2(banco_numero, banco_nome, banco_ativo) values(51, 'Banco Teste View', TRUE);
select banco_numero, banco_nome, banco_ativo from vw_bancos_2 where banco_numero = 51;

-- a view estabelece uma ponte com a tabela, dai o insert na view registra os mesmos dados na tabela de origem
select numero, nome, ativo from banco where numero = 51; 

update vw_bancos_2 set banco_ativo = FALSE where banco_numero = 51;

delete from vw_bancos_2 where banco_numero = 51;

-- TEMPORARY VIEW -- se vc abrir um outro ary Tool a view não existira mais lá, pois esta como temporária aqui
create or replace TEMPORARY view vw_agencia as (
	select nome
	from agencia
);
select nome from vw_agencia;


-- WITH OPTIONS
create or replace view vw_bancos_ativos as (
	select numero, nome, ativo
	from banco
	where ativo is TRUE
);

-- esse insert falha pois não corresponde ao CHECK OPTION da View, que diz que Ativo precisa ser TRUE
insert into vw_bancos_ativos(numero, nome, ativo) values(51, 'Banco Teste View', FALSE);

create or replace view vw_bancos_com_a as (
	select numero, nome, ativo
	from vw_bancos_ativos
	where nome ILIKE 'a%'
) WITH CASCADED CHECK OPTION;

select numero, nome, ativo from vw_bancos_com_a;

-- esse insert falha pois não corresponde ao CHECK OPTION que diz que precisa começar com "a"
insert into vw_bancos_com_a(numero, nome, ativo) values(333, 'Beta Plus', true);

insert into vw_bancos_com_a(numero, nome, ativo) values(333, 'Alfa Plus', true);

-- o CHECK OPTION do vw_bancos_ativos diz que precisa ser ativo = true, e como vw_bancos_com_a referencia essa tabela ele da erro
-- removendo o CHECK OPTION do vw_bancos_ativos e atualizando a view ele da certo o Insert
insert into vw_bancos_com_a(numero, nome, ativo) values(331, 'Alfa Gama', false);


--Ao remover o Check Option de vw_bancos_ativos e adiconar o CASCADED na vw_bancos_com_a ele vai avaliar as options da view atual
-- e de todas as que ela faz referencia, no caso ele volta a funcionar a validação do ativo
insert into vw_bancos_com_a(numero, nome, ativo) values(332, 'Alfa Gama plus', false);


-------VIEW RECURSIVA-------
CREATE TABLE IF NOT EXISTS funcionarios (
	id SERIAL,
	nome VARCHAR(50),
	gerente INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY (gerente) REFERENCES funcionarios(id)
);

insert into funcionarios(nome, gerente) values ('Juca', null);
insert into funcionarios(nome, gerente) values ('Ana', 1);
insert into funcionarios(nome, gerente) values ('Mario', 1);
insert into funcionarios(nome, gerente) values ('Luigi', 2);
insert into funcionarios(nome, gerente) values ('Yoshi', 4);

select id, nome, gerente from funcionarios where gerente is null
UNION ALL
select id, nome, gerente from funcionarios where id = 999; -- APENAS PARA EXEMPLIFICAR

create or replace RECURSIVE view vw_func(id, gerente, nome) as (
	select id
	     , gerente
	     , nome
	from funcionarios
	where gerente IS NULL
	
	UNION ALL
	
	select funcionarios.id
	     , funcionarios.gerente
	     , funcionarios.nome
	from funcionarios
	INNER JOIN vw_func ON vw_func.id = funcionarios.gerente
);

select id, gerente, funcionario from  vw_func;


select id, nome, gerente from funcionarios where gerente is null
UNION ALL
select id, nome, gerente from funcionarios where id = 999;


create or replace RECURSIVE view vw_func_2(id, gerente_nome, nome) as (
	select id
	     , (select f.nome from funcionarios f where f.id = funcionarios.gerente) as gerente_nome
	     , nome
	from funcionarios
	where gerente IS NULL
	
	UNION ALL
	
	select funcionarios.id
	     , (select f.nome from funcionarios f where f.id = funcionarios.gerente) as gerente_nome
	     , funcionarios.nome
	from funcionarios
	INNER JOIN vw_func ON vw_func.id = funcionarios.gerente
);

select id, gerente_nome, nome from  vw_func_2;



