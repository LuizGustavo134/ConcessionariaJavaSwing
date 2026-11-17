create database concessionaria;
drop database concessionaria;
use concessionaria;
  create table cliente(
    cliente_id int auto_increment primary key,
    nome varchar (50),
    contato varchar(100)
    );
    
    select*from cliente,veiculo,ordemServico;
    
    SELECT
    os.codigo_deServico,
    os.servico,
    os.pagamento,
    c.cliente_id,
    c.nome,
    c.contato,
    v.veiculo_id,
    v.marca,
    v.ano
FROM ordemServico os
INNER JOIN cliente c
    ON os.cliente_id = c.cliente_id
INNER JOIN veiculo v
    ON os.veiculo_id = v.veiculo_id;
    
	create table veiculo(
	veiculo_id int auto_increment primary key,
	marca varchar (100),
	ano int
    );
    
    create table ordemServico(
	codigo_deServico int auto_increment primary key,
	servico varchar (100),
	Pagamento varchar (100), 
    cliente_id int ,
    veiculo_id int,
    FOREIGN KEY (cliente_Id)
	REFERENCES cliente(cliente_id),
	
    FOREIGN KEY (veiculo_Id)
	REFERENCES veiculo(veiculo_id)
            );
        
     select*from ordemServico;
  
    
    select*from veiculo;
	select*from carros where ano < 2000 and preco < 5000;
    
    create table Adms(
    id int auto_increment primary key,
    nome varchar (50),
    senha varchar(50)
    );	
    drop table Adms;
    insert into Adms values(null,"jose","Adm123");
    select* from Adms;
    select* from Adms where nome = "jose" and senha = "Adm123";
    