CREATE TABLE IF NOT EXISTS CLIENTE(
    CPF VARCHAR(45) PRIMARY KEY,
    NOME VARCHAR(45) NOT NULL,
    SEXO VARCHAR(5),
    ENDERECO VARCHAR(150),
    TELEFONE VARCHAR(20),
    SENHA VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS FUNCIONARIO (
    CPF VARCHAR(45) PRIMARY KEY,
    NOME VARCHAR(45) NOT NULL,
    SEXO VARCHAR(5),
    ENDERECO VARCHAR(150),
    TELEFONE VARCHAR(20),
    SENHA VARCHAR(45) NOT NULL,
    SALARIO DOUBLE NOT NULL
);
