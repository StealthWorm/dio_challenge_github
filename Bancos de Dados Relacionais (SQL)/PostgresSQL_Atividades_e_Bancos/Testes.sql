INSERT INTO cliente (nome, email) VALUES ('Thierry Santos','ThierryPitela@hotmail.com');
INSERT INTO conta_corrente (banco_numero,agencia_numero,numero,digito,cliente_numero) VALUES (1,2,187511463,1,501);
INSERT INTO cliente_transacoes (banco_numero,agencia_numero,conta_corrente_numero,conta_corrente_digito,cliente_numero,tipo_transacao_id,valor) VALUES (1,2,187511463,1,501,3, 0.10);


select * from cliente order by cliente.nome;
select * from cliente where cliente.nome LIKE '%Santos';
select * from conta_corrente where conta_corrente.cliente_numero = 501;
select * from cliente_transacoes where cliente_transacoes.cliente_numero = 501;

-- lista as colunas de uma tabela
select * from information_schema.columns where table_name = 'banco';

select numero, nome, ativo from banco;

-- AVG
select AVG(valor) from cliente_transacoes;

--COUNT
select COUNT(numero), email from cliente where email like '%hotmail.com' group by email;
select COUNT(id), tipo_transacao_id from cliente_transacoes group by tipo_transacao_id HAVING count(id) > 150;

--MAX / MIN
select max(valor) from cliente_transacoes;
select min(valor), tipo_transacao_id from cliente_transacoes group by tipo_transacao_id;

--SUM
select SUM(valor), tipo_transacao_id from cliente_transacoes group by tipo_transacao_id order by tipo_transacao_id desc;

-------------------------------------------------------------------------------

select count(1) from banco; --151
select count(1) from agencia; -- 296

--296
select banco.numero, banco.nome, agencia.numero, agencia.nome from banco 
inner join
agencia
on agencia.banco_numero = banco.numero;

-- count(distinct) funciona como o group by
select count(distinct banco.numero) from banco 
inner join
agencia
on agencia.banco_numero = banco.numero;

--438
select banco.numero, banco.nome, agencia.numero, agencia.nome from banco 
left join agencia on agencia.banco_numero = banco.numero;

-- todas as agencias possuem um banco, porem nem todos os bancos possuem um agencia
select agencia.numero, agencia.nome, banco.numero, banco.nome from agencia 
left join banco on banco.numero = agencia.banco_numero;

--iria trazer mais agencias se houvesse alguma sem banco
select banco.numero, banco.nome, agencia.numero, agencia.nome from banco 
right join agencia on agencia.banco_numero = banco.numero;

select banco.numero, banco.nome, agencia.numero, agencia.nome from banco 
full join agencia on agencia.banco_numero = banco.numero;

--44696 registros
select banco.numero, agencia.numero from banco 
cross join agencia;

select banco.nome, 
       agencia.nome, 
	   conta_corrente.numero, 
	   conta_corrente.digito,
	   tipo_transacao_id,
	   cliente.nome
  from banco 
   inner join agencia on agencia.banco_numero = banco.numero
   inner join conta_corrente on conta_corrente.banco_numero = banco.numero --poderia ser agencia.banco_numero tambem
     and conta_corrente.agencia_numero = agencia.numero
   inner join cliente on cliente.numero = conta_corrente.cliente_numero
   inner join cliente_transacoes on cliente_transacoes.banco_numero = banco.numero
     and cliente_transacoes.agencia_numero = agencia.numero
	
   order by cliente.nome;

