-- Music Store Initial Data
-- H2 Database

-- Categoria Data
INSERT INTO CATEGORIA(NOME) VALUES ('Áudio e Tecnologia');
INSERT INTO CATEGORIA(NOME) VALUES ('Estúdio');
INSERT INTO CATEGORIA(NOME) VALUES ('Percussão');
INSERT INTO CATEGORIA(NOME) VALUES ('Cordas');
INSERT INTO CATEGORIA(NOME) VALUES ('Acessórios');

-- Subcategoria Data
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Controladoras e Mesas de Som');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Fone de Ouvido');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Microfones');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Caixa Acústica');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Amplificadores');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Monitores de Áudio');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Bateria');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Caixas');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Pratos e Ferragens');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Percursão');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Violão');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Guitarra');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Contra-baixo');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Pedais e Pedaleiras');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Suporte');
INSERT INTO SUBCATEGORIA(NOME) VALUES ('Geral');

-- Usuario Data
INSERT INTO USUARIO(NOME, CPF, NASCIMENTO, TELEFONE, CEP, RUA, NUMERO, BAIRRO, CIDADE, ESTADO, EMAIL, SENHA)
VALUES('Arthur Hardman Borges', 44444444480, 03021991, 11981032927, '04696000', 'Av. Eng. Eusébio Stevaux', 823, 'Santo Amaro', 'São Paulo', 'SP', 'arthur@hardman.com.br', 'admin123');

-- Produto Data
-- produto 1
INSERT INTO PRODUTO(CODIGOID, MODELO, ESTILO, DESCRICAO, ESPECIFICACOES, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO)
VALUES ('GTR-01', 'EC-1000', 'Les Paul', 'Modelo EC-1000, corpo e braço em Mogno, escala em Ébano com 24 trastes, captação ativa EMG e tarraxas ESP Locking. Construída com corpo e braço em Mogno (colado), escala 24,75 em Ébano para as cores SSB e VB, e Rosewood para as MGO e BLK com 24 trastes extra jumbo. A ponte TonePros locking tailpiece a mantém sempre afinada. As guitarras ESP LTD Deluxe EC-1000 estão equipadas com um par de captadores ativos EMG 60/81 exceto o modelo com a cor MGO que possui captadores Seymour Duncan Alnico II Pro (Braço e Ponte).', 'Corpo | Braço: Mogno | Mogno', 6500.00, 7000.00, 10, CURRENT_TIMESTAMP);

-- produto 2
INSERT INTO PRODUTO(CODIGOID, MODELO, ESTILO, DESCRICAO, ESPECIFICACOES, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO)
VALUES ('BXO-01', 'LTJ-123', 'Explorer', 'Epiphone apresenta a Explorer Custom Lee Malia Artisan Outfit Ltd. Ed. Walnut, projetado por Lee Malia, do Bring Me the Horizon. Apresentando o clássico perfil da Explorer com acabamento Walnut e assinatura de Lee Malia com um Gibson USA.', 'Corpo | Braço: Mogno | Ebano', 6500.00, 7400.00, 5, CURRENT_TIMESTAMP);

-- produto 3
INSERT INTO PRODUTO(CODIGOID, MODELO, ESTILO, DESCRICAO, ESPECIFICACOES, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO)
VALUES ('GTR-02', 'RR1', 'Flying V Randy Rhoads', 'guitarra jackson RR1 ano 1994 ontario pré fender, escudo customizado para 1 knob de volume o original vai junto com a guitarra.', 'Corpo | Braço: Mogno | Mogno', 3000.00, 3500.00, 3, CURRENT_TIMESTAMP);

-- produto 4
INSERT INTO PRODUTO(CODIGOID, MODELO, ESTILO, DESCRICAO, ESPECIFICACOES, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO)
VALUES ('ACS-01', '65/35', 'Encordamento Violao', 'Encordoamento Violão Aço 009 Giannini Acústico 65/35.', '65/35', 18.00, 23.00, 50, CURRENT_TIMESTAMP);

-- produto 5
INSERT INTO PRODUTO(CODIGOID, MODELO, ESTILO, DESCRICAO, ESPECIFICACOES, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO)
VALUES ('AUD-01', 'p120', 'Microfone Condensador', 'O AKG Perception 120 é um microfone condensador de construção sólida, o que garante um melhor desempenho e durabilidade. Possui um diafragma de alta qualidade proporcionando um som mais claro e preciso.', 'Condensador com diafragma de 2/3 polegadas', 644.00, 800.00, 15, CURRENT_TIMESTAMP);

-- produto 6
INSERT INTO PRODUTO(CODIGOID, MODELO, ESTILO, DESCRICAO, ESPECIFICACOES, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO)
VALUES ('EST-01', 'R1000T4', 'Monitor Edifier', 'Material com fibra de Madeira 100% (MDF), este monitor de áudio é construído para resistir à ressonância.', '24Watts RMS (12Wx2)', 480.00, 750.00, 20, CURRENT_TIMESTAMP);

-- produto 7
INSERT INTO PRODUTO(CODIGOID, MODELO, ESTILO, DESCRICAO, ESPECIFICACOES, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO)
VALUES ('AUD-02', 'Super 55 Shure', 'Dinamico Deluxe', 'O Microfone Super 55 da Shure apresenta design vintage de um icônico microfone vocal com resposta de frequência ajustada para vocais de som natural e fala!', '60Hz-17kHz', 2600.00, 2799.00, 8, CURRENT_TIMESTAMP);

-- produto 8
INSERT INTO PRODUTO(CODIGOID, MODELO, ESTILO, DESCRICAO, ESPECIFICACOES, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO)
VALUES ('EST-02', 'DSL 40cr', 'Amplificador Marshall', 'A série Marshall DSL atualizada chegou! Esses amplificadores DSL estão carregados com tom Marshall, características e funcionalidades para iniciantes, bem como profissionais que atuam nas maiores etapas do mundo', 'Potência: 40W (tubo)', 3800.00, 4200.00, 6, CURRENT_TIMESTAMP);

-- produto 9
INSERT INTO PRODUTO(CODIGOID, MODELO, ESTILO, DESCRICAO, ESPECIFICACOES, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO)
VALUES ('VLO-01', 'dr-100', 'Violao Epiphone', 'O Violão Aço Folk DR-100 tem a aparência, som e qualidade de construção que os violonistas amadores e profissionais esperam encontrar quando tocam um Epiphone.', 'Select Spruce', 800.00, 1099.00, 12, CURRENT_TIMESTAMP);

-- produto 10
INSERT INTO PRODUTO(CODIGOID, MODELO, ESTILO, DESCRICAO, ESPECIFICACOES, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO)
VALUES ('EST-03', 'Orange', 'Amplificador Orange', 'Caixa Amplificada Orange Crush CR20RT 20W 1x8 para Guitarra', '20RT | 20W', 1500.00, 1800.00, 7, CURRENT_TIMESTAMP);

-- Carrinho Data
INSERT INTO CARRINHO(TOTAL_ITEM, VALOR_TOTAL, FRETE, VALOR_COMPRA)
VALUES(4, 15000, 30, 15030);

-- Venda Data
INSERT INTO VENDA(USUARIO, TOTAL_ITEM, VALOR_TOTAL, FRETE, VALOR_COMPRA)
VALUES('Julie Farias', 2, 120000, 30, 120000);

