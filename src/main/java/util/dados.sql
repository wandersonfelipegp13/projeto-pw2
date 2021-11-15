DROP DATABASE IF EXISTS dados;

CREATE DATABASE dados;

USE dados;

CREATE TABLE legislatura (
	idLegislatura INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	uri VARCHAR(100) NOT NULL,
	dataInicio VARCHAR(10) NOT NULL,
	dataFim VARCHAR(10) NOT NULL,
	anoEleicao INT NOT NULL
);

CREATE TABLE urlRedeSocial (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	url VARCHAR(800) NOT NULL,
	id_deputado INT NOT NULL,
	
	CONSTRAINT fk_idDeputado FOREIGN KEY (id_deputado) REFERENCES deputado(id)
	
);

CREATE TABLE urlWebsite (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	url VARCHAR(800) NOT NULL,
	id_deputado INT NOT NULL,
	
	CONSTRAINT fk_idDeputado FOREIGN KEY (id_deputado) REFERENCES deputado(id)
	
);

CREATE TABLE deputado (
	
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	uri VARCHAR(100) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    idLegislaturaInicial INT NOT NULL, 
    idLegislaturaFinal INT NOT NULL,
    nomeCivil VARCHAR(100) NOT NULL,
    cpf VARCHAR(20),
    siglaSexo CHAR(1) NOT NULL,
    dataNascimento VARCHAR(10),
    dataFalecimento VARCHAR(10),
    ufNascimento CHAR(2),
    municipioNascimento VARCHAR(100),
	
    CONSTRAINT fk_LegislaturaInicial FOREIGN KEY (idLegislaturaInicial) REFERENCES Legislatura (idLegislatura),
    CONSTRAINT fk_LegislaturaFinal FOREIGN KEY (idLegislaturaFinal) REFERENCES Legislatura (idLegislatura)
    
);

CREATE TABLE ocupacao (
	
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_deputado INT NOT NULL,
	uri VARCHAR(800) NOT NULL,
	titulo VARCHAR(300),
	entidade VARCHAR(800),
	entidade_uf CHAR(2),
	entidade_pais VARCHAR(100),
	ano_inicio VARCHAR(10),
	ano_fim VARCHAR(10),
	
	CONSTRAINT fk_deputado_ocupacao FOREIGN KEY (id_deputado) REFERENCES deputado (id)
	
);

CREATE TABLE profissao (
	
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	uri VARCHAR(800) NOT NULL,
	data_hora VARCHAR(800),
	cod_tipo_profissao INT NOT NULL,
	titulo VARCHAR(800),
	
	id_deputado INT NOT NULL,
	CONSTRAINT fk_deputado_profissao FOREIGN KEY (id_deputado) REFERENCES deputado (id)
	
);

-- ENGINE=InnoDb charset=utf8 COLLATE utf8_unicode_ci;
