set search_path="hotel_morro";

INSERT INTO PESSOA VALUES(1, 'Gabriel Colman', '11122233344', '992144971');
INSERT INTO PESSOA VALUES(2, 'Joaozindo da vila', '55566677788', '996525832');
INSERT INTO PESSOA VALUES(3, 'Maria Trindade', '12345678900', '91234553459');

INSERT INTO USUARIO VALUES (1, 'gabrielcolman7@gmail.com', 'Gabriel123');
INSERT INTO USUARIO VALUES (2, 'Joaozindo@gmail.com', 'Joaozindo123');
INSERT INTO USUARIO VALUES (3, 'maria@gmail.com', 'Maria123');

INSERT INTO CARTAO VALUES('Gabriel Colman', '3456876534562456', '03/24', '782');
INSERT INTO CARTAO VALUES('Joaozindo da vila', '3453856534762152', '12/22', '393');
INSERT INTO CARTAO VALUES('Maria Trindade', '2153566590763052', '09/26', '787');

INSERT INTO USUARIOHOSPEDE VALUES (1, '3456876534562456');
INSERT INTO USUARIOHOSPEDE VALUES (2, '3453856534762152');
INSERT INTO USUARIOHOSPEDE VALUES (3, '2153566590763052');

INSERT INTO USUARIOPROPRIETARIO VALUES(4);

INSERT INTO HOTEL VALUES(1, 'Beira Serra', 5, 'Hotel Clube' ,'3241-3131', 'Rua da Saudade', 25, 'Aquidauana', 4);
INSERT INTO HOTEL VALUES(2, 'Pousada Sol Amarelo', 4, 'Hotel Pousada' ,'3241-2020', 'Rua 13 de Julho', 113, 'Aquidauana', 1);
INSERT INTO HOTEL VALUES(3, 'Pousada Ze Maria', 5,  'Hotel Fazenda' ,'3241-4917', 'Rua Rui Barbosa', 1, 'Aquidauana', 3);


INSERT INTO CATEGORIA VALUES(1, 'De luxo');
INSERT INTO CATEGORIA VALUES(2, 'Muito confortavel');
INSERT INTO CATEGORIA VALUES(3, 'Confortavel');
INSERT INTO CATEGORIA VALUES(4, 'Simples');
INSERT INTO CATEGORIA VALUES(5, 'Sem classificação');

INSERT INTO ACOMODACAO VALUES(1, 1, 1, 'Quarto simples unico', 150.00);
INSERT INTO ACOMODACAO VALUES(1, 2, 1, 'Quarto Duplo, acomoda duas pessoas', 250.00);
INSERT INTO ACOMODACAO VALUES(1, 3, 2, 'Quarto Duplo com Suite', 300.00);
INSERT INTO ACOMODACAO VALUES(2, 5, 2, 'Casa completa', 400.00);
INSERT INTO ACOMODACAO VALUES(2, 6, 1, 'Casa completa com garagem perto', 450.00);

INSERT INTO HOSPEDE VALUES(1, 'Rua Carlos Ferreira Bandeira', 123, 'Aquidauana', 'MS', 'Brasil');
INSERT INTO HOSPEDE VALUES(2, 'Rua Figueiredo', 213, 'Campo Grande', 'MS', 'Brasil');
INSERT INTO HOSPEDE VALUES(3, 'Rua Guanady', 313, 'Dourados', 'MS', 'Brasil');

--INSERT INTO RESERVA VALUES (1, 1); --Reserva em nome de Gabriel Colman >> ele é proprietario
INSERT INTO RESERVA VALUES (2, 2); --Reserva em nome de Joaozindo da vila--
INSERT INTO RESERVA VALUES (3, 3); --Reserva em nome de Maria Trindade-- 

INSERT INTO ITEMRESERVA VALUES(1, 1, 1, 1, '2018-12-31', '2019-01-07', 5600);
INSERT INTO ITEMRESERVA VALUES(2, 2, 2, 2, '2019-10-25', '2019-10-27', 1360);
INSERT INTO ITEMRESERVA VALUES(3, 3, 3, 3, '2018-11-30', '2019-02-04', 51188);

