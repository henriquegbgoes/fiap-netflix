-- --------------------------------------------------------
-- Servidor:                     db4free.net
-- Versão do servidor:           8.0.21 - MySQL Community Server - GPL
-- OS do Servidor:               Linux
-- HeidiSQL Versão:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para tcdnetflix
CREATE DATABASE IF NOT EXISTS `tcdnetflix` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tcdnetflix`;

-- Copiando estrutura para tabela tcdnetflix.tb_assistido
CREATE TABLE IF NOT EXISTS `tb_assistido` (
  `idAssistir` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int NOT NULL,
  `idTitulo` int NOT NULL,
  `tipo` int NOT NULL DEFAULT '1' COMMENT '1 - Assistido, 2 - Assistir no futuro',
  PRIMARY KEY (`idAssistir`) USING BTREE,
  KEY `FK_tb_assistir_tb_usuario` (`idUsuario`) USING BTREE,
  KEY `FK_tb_assistir_tb_titulo` (`idTitulo`) USING BTREE,
  CONSTRAINT `FK_tb_assistir_tb_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `tb_usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Filmes/séries assistidos ou marcados para assistir no futuro';

-- Copiando dados para a tabela tcdnetflix.tb_assistido: ~32 rows (aproximadamente)
DELETE FROM `tb_assistido`;
/*!40000 ALTER TABLE `tb_assistido` DISABLE KEYS */;
INSERT INTO `tb_assistido` (`idAssistir`, `idUsuario`, `idTitulo`, `tipo`) VALUES
	(2, 1, 15, 1),
	(3, 2, 15, 1),
	(4, 4, 15, 1),
	(5, 5, 15, 1),
	(6, 2, 11, 1),
	(7, 3, 11, 1),
	(8, 3, 17, 1),
	(9, 1, 17, 2),
	(10, 2, 25, 1),
	(11, 5, 25, 1),
	(12, 2, 14, 1),
	(13, 3, 14, 1),
	(14, 5, 14, 1),
	(15, 4, 22, 1),
	(16, 5, 22, 1),
	(17, 1, 22, 1),
	(18, 3, 9, 1),
	(19, 2, 20, 1),
	(20, 1, 19, 1),
	(21, 4, 19, 1),
	(22, 2, 19, 1),
	(23, 3, 3, 1),
	(24, 5, 3, 1),
	(25, 2, 3, 1),
	(26, 4, 3, 1),
	(27, 5, 13, 1),
	(28, 2, 13, 1),
	(29, 4, 13, 1),
	(30, 1, 13, 1),
	(31, 1, 3, 1),
	(32, 2, 35, 1),
	(33, 5, 9, 1),
	(34, 3, 29, 1),
	(35, 2, 20, 1),
	(36, 2, 19, 2);
/*!40000 ALTER TABLE `tb_assistido` ENABLE KEYS */;

-- Copiando estrutura para tabela tcdnetflix.tb_genero
CREATE TABLE IF NOT EXISTS `tb_genero` (
  `idGenero` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela tcdnetflix.tb_genero: ~17 rows (aproximadamente)
DELETE FROM `tb_genero`;
/*!40000 ALTER TABLE `tb_genero` DISABLE KEYS */;
INSERT INTO `tb_genero` (`idGenero`, `nome`) VALUES
	(1, 'Ação'),
	(2, 'Animação'),
	(3, 'Aventura'),
	(4, 'Comédia'),
	(5, 'Documentário'),
	(6, 'Fantasia'),
	(7, 'Faroeste / Western'),
	(8, 'Ficção científica'),
	(9, 'Guerra'),
	(10, 'Musical'),
	(11, 'Erótico / Pornográfico'),
	(12, 'Romance'),
	(13, 'Suspense'),
	(14, 'Terror'),
	(15, 'Drama / Tragédia'),
	(16, 'Policial'),
	(17, 'Anime'),
	(18, 'Clássico'),
	(19, 'Esportes'),
	(20, 'Fé e espiritualidade'),
	(21, 'Originais Netflix');
/*!40000 ALTER TABLE `tb_genero` ENABLE KEYS */;

-- Copiando estrutura para tabela tcdnetflix.tb_suporte
CREATE TABLE IF NOT EXISTS `tb_suporte` (
  `idSuporte` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int NOT NULL,
  `idTitulo` int NOT NULL,
  `dataInicio` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dataFim` datetime DEFAULT NULL,
  `tipoProblema` tinyint NOT NULL COMMENT '1 - Erro no título ou descrição\r\n2 - Problemas de vídeo\r\n3 - Problemas de audio\r\n4 - Problemas de legendagem/CC\r\n5 - Problema de conexao ou buffering\r\n',
  `tipoDispositivo` tinyint NOT NULL COMMENT '1 - Smartphone/Tablet Android\r\n2 - Smartphone/Tablet iOS\r\n3 - Televisão\r\n4 - Videogame\r\n5 - Outros\r\n',
  `nomeDispositivo` varchar(50) DEFAULT NULL,
  `descricao` mediumtext,
  `situacao` tinyint NOT NULL DEFAULT '1' COMMENT '1 - Suporte aberto, 2 - Suporte em análise, 3 - Suporte solucionado',
  PRIMARY KEY (`idSuporte`) USING BTREE,
  KEY `FK_tb_suporte_tb_usuario` (`idUsuario`) USING BTREE,
  KEY `FK_tb_suporte_tb_titulo` (`idTitulo`) USING BTREE,
  CONSTRAINT `FK_tb_suporte_tb_titulo` FOREIGN KEY (`idTitulo`) REFERENCES `tb_titulo` (`idTitulo`),
  CONSTRAINT `FK_tb_suporte_tb_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `tb_usuario` (`idUsuario`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Suporte - Possibilidade de abrir um chamado técnico de algum problema que está acontecendo';

-- Copiando dados para a tabela tcdnetflix.tb_suporte: ~9 rows (aproximadamente)
DELETE FROM `tb_suporte`;
/*!40000 ALTER TABLE `tb_suporte` DISABLE KEYS */;
INSERT INTO `tb_suporte` (`idSuporte`, `idUsuario`, `idTitulo`, `dataInicio`, `dataFim`, `tipoProblema`, `tipoDispositivo`, `nomeDispositivo`, `descricao`, `situacao`) VALUES
	(2, 3, 13, '2020-09-11 05:50:08', NULL, 0, 0, 'Celular Android qualquer', 'Não consigo ligar meu aparelho', 1),
	(8, 3, 4, '2020-09-12 13:48:55', NULL, 0, 0, 'TV', 'chamado teste', 1),
	(9, 3, 5, '2020-09-12 16:00:06', NULL, 0, 0, 'TV', 'chamado teste 2', 1),
	(10, 2, 5, '2020-09-12 16:00:32', NULL, 0, 0, 'IPAD', 'chamado teste 2', 1),
	(11, 2, 5, '2020-09-12 17:51:35', NULL, 0, 0, 'IPAD', 'chamado teste 2', 1),
	(12, 2, 5, '2020-09-12 18:03:05', NULL, 0, 0, 'IPAD', 'chamado teste 2', 1),
	(13, 2, 5, '2020-09-12 18:05:48', NULL, 0, 0, 'IPAD', 'chamado teste Kafka', 1),
	(14, 2, 5, '2020-09-12 18:08:38', NULL, 0, 0, 'IPAD', 'chamado teste Kafka', 1),
	(15, 2, 5, '2020-09-12 18:09:25', NULL, 0, 0, 'IPAD', 'chamado teste Kafka', 1),
	(16, 2, 5, '2020-09-12 18:21:22', NULL, 0, 0, 'IPAD', 'chamado teste Kafka', 1),
	(17, 2, 5, '2020-09-12 19:06:08', NULL, 0, 0, 'IPAD', 'chamado teste Kafka', 1);
/*!40000 ALTER TABLE `tb_suporte` ENABLE KEYS */;

-- Copiando estrutura para tabela tcdnetflix.tb_titulo
CREATE TABLE IF NOT EXISTS `tb_titulo` (
  `idTitulo` int NOT NULL AUTO_INCREMENT,
  `tipo` char(1) NOT NULL DEFAULT 'F' COMMENT 'F - Filme, S - Série',
  `nome` varchar(200) NOT NULL,
  `resumo` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `atores` varchar(200) DEFAULT NULL,
  `classificacaoEtaria` tinyint DEFAULT '0' COMMENT '0 - Livre\r\n1 - Maiores 10 anos\r\n2 - Maiores de 12 anos\r\n3 - Maiores de 14 anos\r\n4 - Maiores de 16 anos\r\n5 - Maiores de 18 anos',
  `ano` year NOT NULL,
  `palavraChave` text,
  `temporada` tinyint DEFAULT NULL,
  PRIMARY KEY (`idTitulo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela tcdnetflix.tb_titulo: ~35 rows (aproximadamente)
DELETE FROM `tb_titulo`;
/*!40000 ALTER TABLE `tb_titulo` DISABLE KEYS */;
INSERT INTO `tb_titulo` (`idTitulo`, `tipo`, `nome`, `resumo`, `atores`, `classificacaoEtaria`, `ano`, `palavraChave`, `temporada`) VALUES
	(1, 'F', 'The Old Guard', 'Eles são guerreiros milenares que lutam para proteger a humanidade. Mas nem mesmo a imortalidade está livre de ameaças.', 'Charlize Theron, KiKi Layne, Marwan Kenzari', 4, '2020', 'guerreiro, violência, imortal, imortalidade, proteger, humanidade, ameaça', NULL),
	(2, 'F', 'No Coração do Mar', 'Nesta história real que inspirou Moby Dick, a tripulação de um navio baleeiro luta desesperadamente para sobreviver ao ataque de uma baleia gigante.', 'Chris Hemsworth,Benjamin Walker,Cillian Murphy', 3, '2015', 'vida real, mar, história, época, moby dick, drama, livro, aventura', NULL),
	(3, 'F', 'A Barraca do Beijo 2', 'Em seu último ano na escola, Elle terá que lidar com o namoro à distância com Noah, mudanças na amizade com Lee e um crush inesperado.', 'Joey King,Joel Courtney,Jacob Elordi', 2, '2020', 'escola, comédia, teen, crush, namoro, romance', NULL),
	(4, 'S', 'Cobra Kai', 'Décadas depois da competição que mudou suas vidas, a rivalidade entre Johnny e Daniel está de volta nesta sequência da trilogia Karatê Kid.', 'Ralph Macchio, William Zabka, Xolo Maridueña', 2, '2020', 'karatê, empolgante, luta, rivalidade', 2),
	(5, 'S', 'Naruto', 'Guiado pelo espírito demoníaco dentro dele, o órfão Naruto aprende a controlar seus poderes como um ninja nesta série de aventura anime.', 'Junko Takeuchi, Chie Nakamura, Noriaki Sugiyama', 1, '2006', 'órfão, anime, aventura, ninja, desenho, mangá', 9),
	(6, 'F', 'The Emoji Movie', 'Em Textópolis, uma cidade onde os emojis devem expressar uma emoção só, Gene é emotivo demais. A solução dele? Dar um jeito de ser "normal".', 'T.J. Miller, James Corden, Anna Faris', 0, '2017', 'emoji, emoção, empolgante, comédia, desenho, família', NULL),
	(7, 'S', 'Os Mais Procurados do Mundo', 'Saiba quem são alguns dos suspeitos mais procurados do mundo, que continuam à solta mesmo com recompensas milionárias e investigações internacionais.', NULL, 4, '2020', 'documentário, crimes, reais, francesa, investigações, suspeito, recompensa', 1),
	(8, 'F', 'Amador', 'Ao ser recrutado para uma escola preparatória de elite, um fenômeno do basquete de apenas 14 anos se depara com o ambiente corrupto e ganancioso do esporte amador.', 'Michael Rainey Jr., Josh Charles, Brian White', 3, '2018', 'basquete, amador, esporte, escola, corrupto, ganancioso, elite', NULL),
	(9, 'F', 'Terror em Sillent Hill', 'O desespero de Rose para salvar sua filha de uma doença terminal as leva à Silent Hill, um mundo de trevas que logo consome a menina.', 'Radha Mitchell, Sean Bean, Laurie Holden', 5, '2006', 'desespero, doença, trevas, sobrenatural, suspense', NULL),
	(10, 'F', 'Comer Rezar Amar', 'Liz decide recomeçar sua vida depois do divórcio e viaja pelo mundo em busca de boa comida, espiritualidade e amor verdadeiro.', 'Julia Roberts, James Franco, Javier Bardem', 2, '2010', 'divórcio, recomeçar, viagem, comida, espiritualidade, amor, livro, vida, real', NULL),
	(11, 'F', 'Forrest Gump', 'Tom Hanks estrela como Forrest Gump, um homem ingênuo que se vê envolvido em quase todos os principais eventos das décadas de 60 e 70.', 'Tom Hanks, Robin Wright, Gary Sinise', 3, '1994', 'oscar, eventos, década, ingênuo, corra, forrest, clássico', NULL),
	(12, 'S', 'Lucifer', 'Entediado com a vida nas trevas, o diabo se muda para Los Angeles, abre um piano-bar e empresta sua sabedoria a uma investigadora de assassinatos.', 'Tom Ellis, Lauren German, Kevin Alejandro', 4, '2020', 'fantasia, série, diabo, trevas, assassinato, hq', 5),
	(13, 'S', 'Bob Esponja', 'Bob Esponja e Patrick caem em uma caverna e são aprisionados. / Lula Molusco causa uma erupção vulcânica.', NULL, 1, '2013', 'infantil, besteirol, desenho, divertido, comédia', 3),
	(14, 'S', 'The Walking Dead', 'Zumbis dominam o mundo dos vivos, e os sobreviventes unem forças para manter viva a raça humana.', 'Andrew Lincoln, Steven Yeun, Norman Reedus', 4, '2018', 'hq, terror, zumbi, sobrevivente, sinistro, assustador, sombrio', 9),
	(15, 'S', 'Breaking Bad', 'Ao saber que tem câncer, um professor passa a fabricar metanfetamina pelo futuro da família, mudando o destino de todos.', 'Bryan Cranston, Aaron Paul, Anna Gunn', 5, '2013', 'violento, sombrio, realista, cancer, metanfetamina, professor', 5),
	(16, 'S', 'House of Cards', 'Com Frank fora da jogada, Claire Underwood pode exercer todo o seu poder como a primeira presidente mulher dos Estados Unidos. Mas poderosos inimigos estão à espreita.', 'Robin Wright, Michael Kelly, Diane Lane', 5, '2018', 'política, suspense, dramática, sombrio, complexo, presidente', 6),
	(17, 'S', 'La Casa de Papel', 'Um homem conhecido como O Professor recruta uma jovem assaltante e outros sete criminosos para um grande roubo. O alvo é a Casa da Moeda da Espanha.', 'Úrsula Corberó, Álvaro Morte, Pedro Alonso, Miguel Herrán', 4, '2020', 'espanhola, assalto, roubo, moeda, suspense, berlim, professor, dinheiro', 4),
	(18, 'S', 'The Umbrella Academy', 'Desconfiados de que sua mãe esteja escondendo algo, Luther e Allison convocam uma reunião de família. Cha-Cha e Hazel fazem avanços na sua busca por Cinco.', 'Ellen Page, Tom Hopper, David Castañeda', 4, '2020', 'ação, aventura, hq, ficção, científica, excêntrica, alternativa', 2),
	(19, 'S', 'Friends', 'Esta série de enorme sucesso acompanha as aventuras de seis amigos que enfrentam as armadilhas da vida, do trabalho e do amor nos anos 1990.', 'Jennifer Aniston, Courteney Cox, Lisa Kudrow', 2, '2003', 'comédia, série, sitcom, espirituoso, amor', 10),
	(20, 'S', 'Stranger Things', 'No caminho de volta para casa, Will é aterrorizado por alguma coisa. Não longe dali, um laboratório secreto guarda um segredo sinistro.', 'Winona Ryder, David Harbour, Millie Bobby Brown', 4, '2019', 'sinistro, assustador, teen, terror, ficção, científica', 3),
	(21, 'F', 'Annabelle A Criação do Mal', 'Anos após a morte da filha, um artesão de bonecas e sua esposa decidem acolher crianças órfãs em sua casa. Mas uma força do mal logo começa a atormentar a vida de todos.', 'Stephanie Sigman, Talitha Eliana Bateman, Lulu Wilson', 3, '2017', 'terror, assustador, sinistro, arrepiante, órfã, morte', NULL),
	(22, 'F', 'Harry Potter e a Câmara Secreta', 'Dobby aconselha Harry a não retornar a Hogwarts, mas ele não ouve e se une a Rony e Hermione para investigar uma série de misteriosos assassinatos.', 'Daniel Radcliffe, Rupert Grint, Emma Watson', 0, '2002', 'hongwarts, aventura, família, vassoura, quadribol, magia, investigação', NULL),
	(23, 'F', 'Tropa de Elite', 'Um capitão de polícia do Rio de Janeiro está esgotado e prestes a se aposentar, mas precisa encontrar um sucessor para liderar uma perigosa missão.', 'Wagner Moura, André Ramiro, Caio Junqueira', 4, '2007', 'polícia, tropa, elite, soldado, capitão, missão, policial, corrupção', NULL),
	(24, 'F', 'Maldita Sorte', 'Sempre que Chuck termina com uma namorada, ela fica noiva do próximo namorado. As mulheres logo passam a namorá-lo na esperança de achar o homem certo.', 'Dane Cook, Jessica Alba, Dan Fogler', 5, '2007', 'comédia, romance, apimentado, noiva, namorado', NULL),
	(25, 'F', 'Meu Malvado Favorito 2', 'O adorado vilão Gru e suas três órfãs retornam em novas aventuras nesta animação maluca dublada por alguns dos maiores astros de Hollywood.', 'Steve Carell, Kristen Wiig, Benjamin Bratt', 0, '2013', 'humor, animação, desenho, minions, gru, família', NULL),
	(26, 'F', 'Dois Papas', 'Num momento decisivo para a Igreja Católica, o Papa Bento XVI forma uma amizade surpreendente com o futuro Papa Francisco. Baseado em fatos reais.', 'Anthony Hopkins, Jonathan Pryce, Juan Minujín', 3, '2019', 'igreja, papa, fé, espiritualidade, amizade, vida, real', NULL),
	(27, 'F', 'Let´s Dance', 'Hip-hop ou balé, não importa. Eles só querem dançar. Mas antes precisam encontrar o seu lugar.', 'Rayane Bensetti, Alexia Giordano, Guillaume de Tonquédec', 2, '2019', 'dança, hip-hop, balé, música, drama, francês, romântico, musical', NULL),
	(28, 'F', 'A Fantástica Fábrica de Chocolate', 'Charlie é um dos cinco felizardos contemplados com uma visita à fábrica de chocolate de Willy Wonka nesta versão do clássico infantil dirigida por Tim Burton.', 'Johnny Depp, Freddie Highmore, David Kelly', 0, '2005', 'musical, família, willy, wonka, burton, chocolate, aventura, infantil, livro', NULL),
	(29, 'F', 'Guerra Mundial Z', 'Um ex-funcionário da ONU corre contra o tempo e desafia o destino, viajando ao redor do mundo tentando impedir que uma pandemia zumbi se espalhe.', 'Brad Pitt, Mireille Enos, Daniella Kertesz', 3, '2013', 'zumbi, pandemia, guerra, violento, assustador, ação, livro, sombrio', NULL),
	(30, 'F', 'Privacidade Hackeada', 'Entenda como a empresa de análise de dados Cambridge Analytica se tornou o símbolo do lado sombrio das redes sociais após a eleição presidencial de 2016 nos EUA.', NULL, 3, '2019', 'documentário, investigação, rede social, polêmica, privacidade, hacker, dados, controverso, eleição', 1),
	(31, 'S', 'Desejo Sombrio', 'Uma professora de direito escuta uma conversa suspeita do marido ao telefone. Mais tarde, ela vai a uma balada com uma amiga recém-divorciada.', 'Maite Perroni, Alejandro Speitzer, María Fernanda Yepes', 4, '2020', 'suspense, mistério, caliente, sexo, pornográfico, mexicana, mistério', NULL),
	(32, 'F', 'Gladiador', 'Um general romano é indicado ao trono após a morte do imperador, mas acaba condenado à morte pelo ambicioso filho do falecido monarca.', 'Russell Crowe, Joaq, Connie Nielsenuin Phoenix', 3, '2000', 'roma, guerra, gladiadores, imperador, monarca, oscar', NULL),
	(33, 'F', 'Era Uma Vez no Oeste', 'Este clássico de Sergio Leone traz Henry Fonda como um pistoleiro contratado pelo dono de um conglomerado ferroviário para matar os opositores do projeto.', 'Claudia Cardinale, Henry Fonda, Jason Robards, Charles Bronson', 3, '1968', 'faroeste, western, bang, oeste, tiroteio, clássico, pistoleiro', NULL),
	(34, 'F', 'One Punch Man', 'O super-herói mais forte do mundo pode matar qualquer um com um só golpe. Mas, com uma vida sem desafios, ele sofre com o tédio e a depressão.', 'Makoto Furukawa, Kaito Ishikawa, Yuki Kaji', 2, '2015', 'anime, herói, luta, manga, humor', 1),
	(35, 'F', 'Aggretsuko', 'Frustrada com o emprego, Retsuko, a panda vermelha, encara a luta diária cantando heavy metal em um karaokê depois do expediente.', 'Kaolip, Komegumi Koiwasaki, Maki Tsuruta', 2, '2020', 'anime, heavy, humor, metal, karaokê', 3);
/*!40000 ALTER TABLE `tb_titulo` ENABLE KEYS */;

-- Copiando estrutura para tabela tcdnetflix.tb_titulo_genero
CREATE TABLE IF NOT EXISTS `tb_titulo_genero` (
  `idTitulo` int NOT NULL,
  `idGenero` int NOT NULL,
  KEY `idTitulo` (`idTitulo`) USING BTREE,
  KEY `idGenero` (`idGenero`) USING BTREE,
  CONSTRAINT `FK_tb_titulo_genero_tb_genero` FOREIGN KEY (`idGenero`) REFERENCES `tb_genero` (`idGenero`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_tb_titulo_genero_tb_titulo` FOREIGN KEY (`idTitulo`) REFERENCES `tb_titulo` (`idTitulo`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Relacionamento entre os títulos e os gêneros';

-- Copiando dados para a tabela tcdnetflix.tb_titulo_genero: ~84 rows (aproximadamente)
DELETE FROM `tb_titulo_genero`;
/*!40000 ALTER TABLE `tb_titulo_genero` DISABLE KEYS */;
INSERT INTO `tb_titulo_genero` (`idTitulo`, `idGenero`) VALUES
	(1, 1),
	(1, 8),
	(2, 1),
	(2, 3),
	(2, 15),
	(3, 4),
	(3, 12),
	(4, 1),
	(4, 3),
	(4, 15),
	(5, 2),
	(5, 3),
	(5, 17),
	(6, 2),
	(6, 4),
	(7, 5),
	(7, 16),
	(7, 21),
	(8, 15),
	(8, 19),
	(9, 13),
	(9, 14),
	(10, 12),
	(10, 20),
	(11, 3),
	(11, 4),
	(11, 18),
	(12, 6),
	(12, 21),
	(13, 2),
	(13, 3),
	(13, 4),
	(14, 1),
	(14, 13),
	(14, 14),
	(15, 1),
	(15, 15),
	(16, 1),
	(16, 15),
	(16, 21),
	(17, 1),
	(17, 13),
	(17, 21),
	(18, 6),
	(18, 8),
	(18, 21),
	(19, 4),
	(19, 12),
	(19, 20),
	(20, 6),
	(20, 8),
	(20, 13),
	(20, 21),
	(21, 13),
	(21, 14),
	(22, 3),
	(22, 6),
	(23, 15),
	(23, 16),
	(24, 4),
	(24, 18),
	(25, 2),
	(25, 4),
	(26, 20),
	(26, 21),
	(27, 10),
	(27, 21),
	(28, 3),
	(28, 6),
	(28, 10),
	(29, 1),
	(29, 8),
	(29, 9),
	(30, 5),
	(30, 21),
	(31, 11),
	(31, 12),
	(31, 16),
	(32, 1),
	(32, 9),
	(32, 18),
	(33, 7),
	(33, 18),
	(34, 3),
	(34, 4),
	(34, 17),
	(35, 2),
	(35, 4),
	(35, 17);
/*!40000 ALTER TABLE `tb_titulo_genero` ENABLE KEYS */;

-- Copiando estrutura para tabela tcdnetflix.tb_usuario
CREATE TABLE IF NOT EXISTS `tb_usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `dataCadastro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `senha` varchar(50) NOT NULL,
  `plano` tinyint NOT NULL DEFAULT '2' COMMENT '1 - Básico, 2 - Padrão, 3 - Premium',
  `assinaturaAtivada` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela tcdnetflix.tb_usuario: ~4 rows (aproximadamente)
DELETE FROM `tb_usuario`;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` (`idUsuario`, `dataCadastro`, `nome`, `email`, `telefone`, `senha`, `plano`, `assinaturaAtivada`) VALUES
	(1, '2020-08-24 10:41:14', 'Pedro Lima', 'pedro.lima@email.com', '1122224455', 'pedr@l1mx', 2, b'1'),
	(2, '2020-08-26 20:09:37', 'Mariana Almeida', 'mary_alma@email.com', NULL, 'm@ryy19', 3, b'1'),
	(3, '2020-09-02 16:45:00', 'Paulo Guedes', 'paulog@gov.br', NULL, 'newcpmf', 1, b'1'),
	(4, '2020-09-04 07:13:15', 'João Luis Borges', 'joao.borges@email.com', '21999988770', 'PWx%nfx', 2, b'1'),
	(5, '2020-09-05 23:19:18', 'Luciana Medeiros', 'lumedeiros34@mail.com', '317539510', 'L34W#784kf', 3, b'1');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;

-- Copiando estrutura para tabela tcdnetflix.tb_votacao
CREATE TABLE IF NOT EXISTS `tb_votacao` (
  `idVotar` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int NOT NULL,
  `idTitulo` int NOT NULL,
  `dataVotacao` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `votacao` int NOT NULL DEFAULT '1' COMMENT '1 - gostei, 0 - não gostei',
  PRIMARY KEY (`idVotar`) USING BTREE,
  KEY `FK_tb_votar_tb_usuario` (`idUsuario`) USING BTREE,
  KEY `FK_tb_votar_tb_titulo` (`idTitulo`) USING BTREE,
  CONSTRAINT `FK_tb_votar_tb_titulo` FOREIGN KEY (`idTitulo`) REFERENCES `tb_titulo` (`idTitulo`),
  CONSTRAINT `FK_tb_votar_tb_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `tb_usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Possibilidade de votar nos filmes que mais gostei e não gostei';

-- Copiando dados para a tabela tcdnetflix.tb_votacao: ~14 rows (aproximadamente)
DELETE FROM `tb_votacao`;
/*!40000 ALTER TABLE `tb_votacao` DISABLE KEYS */;
INSERT INTO `tb_votacao` (`idVotar`, `idUsuario`, `idTitulo`, `dataVotacao`, `votacao`) VALUES
	(2, 1, 14, '2020-08-29 12:21:02', 1),
	(3, 2, 22, '2020-08-18 08:10:32', 1),
	(4, 5, 16, '2020-06-03 21:22:39', 1),
	(5, 3, 4, '2020-09-06 18:23:37', 1),
	(6, 4, 29, '2020-05-12 23:25:00', 1),
	(7, 5, 3, '2020-09-09 05:31:22', 1),
	(8, 3, 29, '2020-09-10 05:42:43', 1),
	(9, 3, 29, '2020-09-10 05:54:21', 1),
	(10, 3, 29, '2020-09-10 06:00:08', 0),
	(11, 3, 29, '2020-09-10 06:00:44', 0),
	(12, 3, 29, '2020-09-10 06:06:05', 0),
	(13, 3, 29, '2020-09-10 06:10:06', 0),
	(14, 3, 29, '2020-09-10 06:12:53', 0),
	(15, 3, 29, '2020-09-10 06:16:07', 0);
/*!40000 ALTER TABLE `tb_votacao` ENABLE KEYS */;

-- Copiando estrutura para procedure tcdnetflix.sp_datahora
DELIMITER //
CREATE PROCEDURE `sp_datahora`()
BEGIN
	SELECT NOW() 'DataHora';
END//
DELIMITER ;

-- Copiando estrutura para procedure tcdnetflix.sp_incluir_suporte
DELIMITER //
CREATE PROCEDURE `sp_incluir_suporte`(
	IN `in_idUsuario` INT,
	IN `in_idTitulo` INT,
	IN `in_tipoProblema` INT,
	IN `in_tipoDispositivo` TINYINT,
	IN `in_nomeDispositivo` VARCHAR(50),
	IN `in_descricao` MEDIUMTEXT
)
BEGIN
	INSERT INTO tb_suporte 
		(idUsuario, idTitulo, tipoProblema, tipoDispositivo, nomeDispositivo, descricao) 
	VALUES 
		(in_idUsuario, in_idTitulo, in_tipoProblema, in_tipoDispositivo, in_nomeDispositivo, in_descricao);
END//
DELIMITER ;

-- Copiando estrutura para procedure tcdnetflix.sp_incluir_titulo_assistido
DELIMITER //
CREATE PROCEDURE `sp_incluir_titulo_assistido`(
	IN `in_idUsuario` INT,
	IN `in_idTitulo` INT,
	IN `in_tipo` INT
)
BEGIN
	INSERT INTO tb_assistido (idUsuario, idTitulo, tipo) VALUES (in_idUsuario, in_idTitulo, in_tipo);
END//
DELIMITER ;

-- Copiando estrutura para procedure tcdnetflix.sp_incluir_titulo_votacao
DELIMITER //
CREATE PROCEDURE `sp_incluir_titulo_votacao`(
	IN `in_idUsuario` INT,
	IN `in_idTitulo` INT,
	IN `in_votacao` INT
)
BEGIN
	INSERT INTO tb_votacao (idUsuario, idTitulo, votacao) VALUES (in_idUsuario, in_idTitulo, in_votacao);
END//
DELIMITER ;

-- Copiando estrutura para procedure tcdnetflix.sp_maisassistidos_genero
DELIMITER //
CREATE PROCEDURE `sp_maisassistidos_genero`(
	IN `in_genero` VARCHAR(50)
)
BEGIN
	SELECT 
		t.idTitulo, t.tipo, t.nome, t.resumo, fc_classificacao_etaria(t.classificacaoEtaria) 'classificacaoEtaria', t.temporada,
		(SELECT COUNT(1) FROM tb_assistido a WHERE a.idTitulo = t.idTitulo AND a.tipo = 1) AS qtdAssistidos
	FROM
		tb_titulo t
	INNER JOIN tb_titulo_genero tg ON t.idTitulo = tg.idTitulo
	INNER JOIN tb_genero g ON g.idGenero = tg.idGenero
	WHERE g.nome LIKE CONCAT('%',in_genero,'%')
	AND (SELECT COUNT(1) FROM tb_assistido a WHERE a.idTitulo = t.idTitulo AND a.tipo = 1) > 0
	ORDER BY QtdAssistidos DESC LIMIT 3;
END//
DELIMITER ;

-- Copiando estrutura para procedure tcdnetflix.sp_qtdtitulos_genero
DELIMITER //
CREATE PROCEDURE `sp_qtdtitulos_genero`()
BEGIN
	SELECT
		g.nome,
		(SELECT COUNT(1) FROM tb_titulo_genero tg WHERE tg.idGenero = g.idGenero) AS qtdTitulos
	FROM
		tb_genero g
	ORDER BY
		g.nome ASC;
END//
DELIMITER ;

-- Copiando estrutura para procedure tcdnetflix.sp_titulo_assistido
DELIMITER //
CREATE PROCEDURE `sp_titulo_assistido`(
	IN `in_idUsuario` INT,
	IN `in_tipo` INT
)
BEGIN
	SELECT
		t.idTitulo, t.tipo, t.nome, t.resumo, fc_classificacao_etaria(t.classificacaoEtaria) 'classificacaoEtaria', t.temporada, g.nome 'gênero'
	FROM
		tb_titulo t
	INNER JOIN
		tb_titulo_genero tg ON tg.idTitulo = t.idTitulo
	INNER JOIN
		tb_genero g ON g.idGenero = tg.idGenero
	INNER JOIN
		tb_assistido a ON a.idTitulo = t.idTitulo
	WHERE
		a.idUsuario = in_idUsuario
	AND
		a.tipo = in_tipo
	ORDER BY
		t.nome ASC;
END//
DELIMITER ;

-- Copiando estrutura para procedure tcdnetflix.sp_titulo_detalhes
DELIMITER //
CREATE PROCEDURE `sp_titulo_detalhes`()
BEGIN
	SELECT
		t.idTitulo, t.tipo, t.nome, t.resumo, t.atores, fc_classificacao_etaria(t.classificacaoEtaria) 'classificacaoEtaria', t.ano, t.palavraChave, t.temporada 
	FROM
		tb_titulo t;
END//
DELIMITER ;

-- Copiando estrutura para procedure tcdnetflix.sp_titulo_genero
DELIMITER //
CREATE PROCEDURE `sp_titulo_genero`(
	IN `in_genero` VARCHAR(100)
)
BEGIN
	SELECT
		t.idTitulo, t.tipo, t.nome, t.resumo, fc_classificacao_etaria(t.classificacaoEtaria) 'classificacaoEtaria', t.temporada 
	FROM
		tb_titulo t
	INNER JOIN tb_titulo_genero tg ON t.idTitulo = tg.idTitulo
	INNER JOIN tb_genero g ON g.idGenero = tg.idGenero
	WHERE g.nome LIKE CONCAT('%',in_genero,'%');
END//
DELIMITER ;

-- Copiando estrutura para procedure tcdnetflix.sp_titulo_palavrachave
DELIMITER //
CREATE PROCEDURE `sp_titulo_palavrachave`(
	IN `in_palavrachave` VARCHAR(100)
)
BEGIN
	SELECT
		t.idTitulo, t.tipo, t.nome, t.resumo, fc_classificacao_etaria(t.classificacaoEtaria) 'classificacaoEtaria', t.palavraChave, t.temporada 
	FROM
		tb_titulo t
	WHERE t.palavraChave LIKE CONCAT('%',in_palavrachave,'%');
END//
DELIMITER ;

-- Copiando estrutura para função tcdnetflix.fc_classificacao_etaria
DELIMITER //
CREATE FUNCTION `fc_classificacao_etaria`(
	`in_classificacaoEtaria` TINYINT(3)
) RETURNS varchar(30) CHARSET utf8mb4
    DETERMINISTIC
BEGIN

   DECLARE classificacao VARCHAR(30);

	CASE in_classificacaoEtaria
		WHEN '5' THEN SET classificacao = 'Maiores de 18 anos';
		WHEN '4' THEN SET classificacao = 'Maiores de 16 anos';
		WHEN '3' THEN SET classificacao = 'Maiores de 14 anos';
		WHEN '2' THEN SET classificacao = 'Maiores de 12 anos';
		WHEN '1' THEN SET classificacao = 'Maiores de 10 anos';
		ELSE SET classificacao = 'Livre';
	END CASE;

   RETURN classificacao;

END//
DELIMITER ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
