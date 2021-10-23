DROP SCHEMA IF EXISTS hotel_morro CASCADE;
CREATE SCHEMA hotel_morro;

set search_path = "hotel_morro";


CREATE TABLE PESSOA (
    idPessoa INTEGER PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) UNIQUE NOT NULL,
    telefone VARCHAR(20)
);

CREATE TABLE USUARIO (
    idPessoa INTEGER NOT NULL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    FOREIGN KEY (idPessoa) REFERENCES PESSOA(idPessoa)
);

CREATE TABLE CARTAO(
    titular VARCHAR(255) NOT NULL,
    numeroCartao VARCHAR(16) NOT NULL PRIMARY KEY,
    vencimento VARCHAR(255) NOT NULL,
    codigoSeguranca INTEGER NOT NULL
);

CREATE TABLE USUARIOHOSPEDE (
    idPessoa INTEGER NOT NULL PRIMARY KEY,
    numeroCartao VARCHAR(16) NOT NULL UNIQUE,
    FOREIGN KEY (idPessoa) REFERENCES USUARIO(idPessoa),
    FOREIGN KEY (numeroCartao) REFERENCES CARTAO(numeroCartao)
);

CREATE TABLE USUARIOPROPRIETARIO (
    idPessoa INTEGER NOT NULL PRIMARY KEY,
    FOREIGN KEY (idPessoa) REFERENCES USUARIO(idPessoa)
);

CREATE TABLE HOSPEDE (
    idPessoa INTEGER NOT NULL PRIMARY KEY,
    rua VARCHAR(255) NOT NULL,
    numeroCasa INTEGER NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    pais VARCHAR(255) NOT NULL,
    FOREIGN KEY (idPessoa) REFERENCES PESSOA(idPessoa)
);

CREATE TABLE HOTEL(
    idHotel INTEGER PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    quantidadeEstrela INTEGER NOT NULL,
    descricao VARCHAR(1000) NULL,
    telefone VARCHAR(255) NOT NULL,
    rua VARCHAR(255) NOT NULL,
    numeroHotel INTEGER NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    pais VARCHAR(255) NOT NULL,
    idProprietario INTEGER NOT NULL,
    FOREIGN KEY (idProprietario) REFERENCES USUARIOPROPRIETARIO(idPessoa)
);

CREATE TABLE CATEGORIA(
    idCategoria INTEGER PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL
);

CREATE TABLE ACOMODACAO(
    idHotel INTEGER NOT NULL,
    idAcomodacao INTEGER PRIMARY KEY,
    idCategoria INTEGER,
    descricao VARCHAR(255) NOT NULL,
    valor FLOAT NOT NULL,
    FOREIGN KEY (idHotel) REFERENCES HOTEL(idHotel),
    FOREIGN KEY (idCategoria) REFERENCES CATEGORIA(idCategoria)
);

CREATE TABLE RESERVA(
    idReserva INTEGER PRIMARY KEY,
    idUsuarioHospede INTEGER NOT NULL,
    FOREIGN KEY (idUsuarioHospede) REFERENCES HOSPEDE(idPessoa)
);

CREATE TABLE ITEMRESERVA(
    idReserva INTEGER,
    idItemReserva INTEGER,
    idHospede INTEGER NOT NULL,
    idAcomodacao INTEGER NOT NULL,
    dataInicial DATE NOT NULL,
    dataFinal DATE NOT NULL,
    valor FLOAT NOT NULL,
    PRIMARY KEY (idReserva, idItemReserva),
    FOREIGN KEY (idReserva) REFERENCES RESERVA(idReserva),
    FOREIGN KEY (idHospede) REFERENCES HOSPEDE(idPessoa),
    FOREIGN KEY (idAcomodacao) REFERENCES ACOMODACAO(idAcomodacao)
);
