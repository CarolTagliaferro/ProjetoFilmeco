-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 03/12/2024 às 13:37
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `filmeco`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `filmes`
--

CREATE TABLE `filmes` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `duracao` int(11) NOT NULL,
  `descricao` text DEFAULT NULL,
  `ano` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT current_timestamp(),
  `filme` text NOT NULL,
  `capa` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `filmes`
--

INSERT INTO `filmes` (`id`, `titulo`, `duracao`, `descricao`, `ano`, `data`, `filme`, `capa`) VALUES
(3, 'Missão: Impossível – Sentença Mortal – Parte Um', 163, 'Ethan Hunt e sua equipe enfrentam um novo inimigo, enquanto tentam impedir um desastre global envolvendo tecnologia de inteligência artificial.', 2023, '2024-11-30 22:52:58', 'f-1', 'images/Capa/missaoimpossivel.png'),
(4, 'John Wick: Capítulo 4', 169, 'John Wick busca vingança contra aqueles que o traíram, enquanto enfrenta novos inimigos em uma batalha mortal.', 2023, '2024-11-30 22:52:58', 'f-2', 'images/Capa/johnwick4-01.png'),
(5, 'Spider-Man: Sem Volta Para Casa', 148, 'Peter Parker busca ajuda de Doutor Estranho para lidar com as consequências de sua identidade secreta revelada, enfrentando vilões de outros universos.', 2021, '2024-11-30 22:52:58', 'f-3', 'images/Capa/homem aranha sem volta.png'),
(6, 'The Batman', 155, 'Batman investiga um assassino conhecido como \"Charada\", enquanto lida com a corrupção em Gotham City e suas próprias questões pessoais.', 2022, '2024-11-30 22:52:58', 'f-4', 'images/Capa/the batman.png'),
(7, 'Vingadores: Ultimato', 181, 'Os Vingadores, após a perda devastadora para Thanos, tentam reverter o desastre e restaurar o universo.', 2019, '2024-11-30 22:52:58', 'f-5', 'images/Capa/ultimato.png'),
(8, 'Indiana Jones e os Caçadores da Arca Perdida', 115, 'O arqueólogo Indiana Jones parte em uma missão para encontrar a Arca da Aliança, enfrentando nazistas e vários perigos.', 1981, '2024-11-30 22:52:58', 'f1', 'images/Capa/indiana jones.png'),
(9, 'O Senhor dos Anéis: A Sociedade do Anel', 178, 'Um grupo de heróis improváveis se reúne para destruir um anel mágico que pode trazer a destruição ao mundo.', 2001, '2024-11-30 22:52:58', 'f2', 'images/Capa/senhor dos aneis.png'),
(10, 'Jurassic Park', 127, 'Uma visita a um parque de dinossauros geneticamente recriados se transforma em um pesadelo quando os dinossauros escapam.', 1993, '2024-11-30 22:52:58', 'f3', 'images/Capa/jurassicpark-01.png'),
(12, 'As Aventuras de Tintim', 107, 'Tintim, um jornalista aventureiro, parte em uma jornada para desvendar um mistério envolvendo um navio perdido.', 2011, '2024-11-30 22:52:58', 'f5', 'images/Capa/tintin.png'),
(13, 'A Viagem de Chihiro', 125, 'Uma jovem garota é forçada a trabalhar em um misterioso balneário de um mundo mágico para salvar seus pais.', 2001, '2024-11-30 22:52:58', 'f11', 'images/Capa/a viagem de chihiro.png'),
(14, 'Toy Story - Um Mundo de Aventuras', 81, 'Woody, o cowboy, e Buzz Lightyear, o astronauta, são dois brinquedos que vivem aventuras em um quarto de criança.', 1995, '2024-11-30 22:52:58', 'f12', 'images/Capa/toy story.png'),
(15, 'Coraline e o Mundo Secreto', 100, 'Uma garota encontra uma versão alternativa de sua vida, onde tudo parece perfeito, mas logo descobre que há um grande perigo.', 2009, '2024-11-30 22:52:58', 'f13', 'images/Capa/coraline-01.png'),
(16, 'Kung Fu Panda', 92, 'Um panda desajeitado se vê escolhido para ser o maior mestre de kung fu e deve lutar contra um inimigo ameaçador.', 2008, '2024-11-30 22:52:58', 'f14', 'images/Capa/kungfupanda-01.png'),
(17, 'Homem-Aranha no Aranhaverso', 117, 'Miles Morales, um adolescente de Nova York, descobre o multiverso e se junta a outras versões do Homem-Aranha para combater um vilão.', 2018, '2024-11-30 22:52:58', 'f15', 'images/Capa/aranhaverso-01.png'),
(18, 'As Branquelas', 129, 'Dois policiais disfarçados de mulheres ricas precisam resolver um sequestro, enquanto tentam manter suas identidades secretas.', 2004, '2024-11-30 22:52:58', 'f16', 'images/Capa/as branquelas.png'),
(19, 'O Amor é Cego', 117, 'Um homem vaidoso e superficial sofre um acidente e, após a recuperação, vê as mulheres de forma diferente, desafiando suas crenças sobre o amor.', 2001, '2024-11-30 22:52:58', 'f17', 'images/Capa/amorcego.png'),
(20, 'A Morte de Stalin', 107, 'Uma comédia política satírica sobre a luta pelo poder após a morte de Stalin, cheia de humor negro e intrigas.', 2017, '2024-11-30 22:52:58', 'f18', 'images/Capa/a morte de stalin.png'),
(21, 'O Ditador', 83, 'O ditador de Wadiya, um país fictício, viaja para os Estados Unidos para enfrentar o desafio de governar uma nação democrática.', 2012, '2024-11-30 22:52:58', 'f19', 'images/Capa/o ditador.png'),
(22, 'O Grande Lebowski', 117, 'Um homem tranquilo é confundido com um milionário e se vê envolvido em um mistério de sequestro.', 1998, '2024-11-30 22:52:58', 'f20', 'images/Capa/lebowski.png'),
(23, 'O Jardim Secreto', 101, 'Uma jovem garota e seu primo descobrem um jardim abandonado e começam a restaurá-lo enquanto lidam com suas próprias perdas.', 1993, '2024-11-30 22:52:58', 'f1', 'images/Capa/o jardim secreto-01.png'),
(24, 'A Espera de um Milagre', 189, 'A história de um guarda prisional que desenvolve uma amizade com um prisioneiro condenado à morte por um crime que ele pode não ter cometido.', 1999, '2024-11-30 22:52:58', 'f2', 'images/Capa/greenmile-01.png'),
(25, 'Clube da Luta', 139, 'Um homem em crise de identidade funda um clube secreto de luta que rapidamente sai de controle e começa a afetar sua vida.', 1999, '2024-11-30 22:52:58', 'f3', 'images/Capa/clube da luta-01.png'),
(26, 'A Vida é Bela', 116, 'Durante a Segunda Guerra Mundial, um homem judeu usa seu otimismo e imaginação para proteger seu filho do horror do campo de concentração.', 1997, '2024-11-30 22:52:58', 'f4', 'images/Capa/vidabela.png'),
(27, 'Os Intocáveis', 112, 'Um aristocrata tetraplégico e seu assistente de classe baixa formam uma amizade improvável que muda suas vidas.', 2011, '2024-11-30 22:52:58', 'f5', 'images/Capa/os intocaveis.png'),
(28, 'O Iluminado', 144, 'Jack Torrance se isola com sua família em um hotel nas montanhas, onde começa a enlouquecer sob a influência de forças sobrenaturais.', 1980, '2024-11-30 22:52:58', 'f26', 'images/Capa/o iluminado.png'),
(29, 'Psicose', 109, 'Uma mulher foge após roubar uma grande quantia de dinheiro e encontra refúgio em um motel administrado por Norman Bates, onde eventos aterrorizantes se desenrolam.', 1960, '2024-11-30 22:52:58', 'f27', 'images/Capa/psicose.png'),
(30, 'O Exorcista', 122, 'Uma jovem é possuída por uma entidade demoníaca, e um padre tenta realizar um exorcismo para salvá-la.', 1973, '2024-11-30 22:52:58', 'f28', 'images/Capa/exorcista.png'),
(31, 'O Massacre da Serra Elétrica', 83, 'Um grupo de amigos visita uma casa no interior e é aterrorizado por uma família de psicopatas, incluindo o infame Leatherface.', 1974, '2024-11-30 22:52:58', 'f29', 'images/Capa/serra eletrica.png'),
(32, 'Hereditário', 127, 'Após a morte de sua mãe, uma família começa a descobrir segredos aterrorizantes sobre suas origens e um destino sombrio que os aguarda.', 2018, '2024-11-30 22:52:58', 'f30', 'images/Capa/hereditario-01.png'),
(38, '2001: Uma Odisseia no Espaço', 149, 'A jornada de uma missão espacial rumo a Júpiter, enquanto a tripulação enfrenta eventos misteriosos e desconhecidos.', 1968, '2024-11-30 22:52:58', 'f36', 'images/Capa/2001.png'),
(39, 'A Origem', 148, 'Um ladrão especializado em furtar segredos corporativos por meio do uso de sonhos precisa realizar uma tarefa impossível para limpar seu nome.', 2010, '2024-11-30 22:52:58', 'f37', 'images/Capa/a origem-01.png'),
(40, 'Interestelar', 169, 'Em um futuro distópico, um grupo de astronautas viaja por um buraco de minhoca para garantir a sobrevivência da humanidade.', 2014, '2024-11-30 22:52:58', 'f38', 'images/Capa/interstellar-01.png'),
(41, 'Blade Runner: O Caçador de Andróides', 117, 'Em um futuro distópico, um caçador de andróides é encarregado de eliminar replicantes fugidos que são indistinguíveis dos humanos.', 1982, '2024-11-30 22:52:58', 'f39', 'images/Capa/bladerunner2049.png'),
(42, 'A Chegada', 116, 'Uma linguista é chamada para ajudar a decifrar a linguagem de alienígenas que chegaram à Terra, enquanto o mundo entra em pânico.', 2016, '2024-11-30 22:52:58', 'f40', 'images/Capa/A chegada.png'),
(44, 'Harry Potter e a Pedra Filosofal', 152, 'Um garoto descobre que é um bruxo e inicia sua jornada em uma escola mágica cheia de mistérios e perigos.', 2001, '2024-11-30 22:52:58', 'f42', 'images/Capa/HP e a pedra filosofal.png'),
(45, 'As Crônicas de Nárnia: O Leão, a Feiticeira e o Guarda-Roupa', 143, 'Quatro irmãos descobrem um mundo mágico onde precisam lutar contra a Feiticeira Branca para libertar o reino.', 2005, '2024-11-30 22:52:58', 'f43', 'images/Capa/narnia-01.png'),
(46, 'O Labirinto', 101, 'Uma adolescente tenta resgatar seu irmão, que foi levado para um reino de fantasias e criaturas estranhas.', 1986, '2024-11-30 22:52:58', 'f44', 'images/Capa/o labirinto.png'),
(47, 'Stardust - O Mistério da Estrela', 127, 'Um jovem viaja para um reino mágico para capturar uma estrela cadente e acaba se envolvendo em uma aventura cheia de surpresas.', 2007, '2024-11-30 22:52:58', 'f45', 'images/Capa/stardust.png'),
(48, 'O Diário de uma Paixão', 123, 'Um jovem casal se apaixona perdidamente, mas os obstáculos da vida e do tempo testam sua relação.', 2004, '2024-11-30 22:52:58', 'f46', 'images/Capa/notebook.png'),
(49, 'Como Eu Era Antes de Você', 110, 'Uma jovem cuida de um homem tetraplégico e acaba se apaixonando por ele, enquanto ele tenta redescobrir o sentido da vida.', 2016, '2024-11-30 22:52:58', 'f47', 'images/Capa/como eu era antes de voce-01.png'),
(50, 'Titanic', 195, 'O romance entre Jack e Rose a bordo do Titanic se torna um dos maiores amores trágicos da história.', 1997, '2024-11-30 22:52:58', 'f48', 'images/Capa/titanic.png'),
(51, 'Antes que Eu Vá', 115, 'Uma jovem mulher revive o mesmo dia várias vezes, tentando entender suas escolhas e como mudar seu destino.', 2017, '2024-11-30 22:52:58', 'f49', 'images/Capa/Antes que eu va-01.png'),
(52, 'A Culpa é das Estrelas', 126, 'Dois adolescentes com câncer se apaixonam, enquanto enfrentam a vida com humor e amor, apesar das adversidades.', 2014, '2024-11-30 22:52:58', 'f50', 'images/Capa/aCulpaDasEstrelas.png'),
(53, 'Silêncio dos Inocentes', 118, 'Uma jovem agente do FBI busca a ajuda de um brilhante, mas perigoso, psiquiatra e assassino para capturar outro criminoso.', 1991, '2024-12-01 18:21:40', 'f31', 'images/Capa/coraline-01.png'),
(54, 'O Sexto Sentido', 107, 'Um jovem garoto atormentado por visões de espíritos busca ajuda de um psicólogo infantil para lidar com sua habilidade assustadora.', 1999, '2024-12-01 18:21:40', 'f32', 'images/Capa/mentiras e mascaras.png'),
(55, 'Os Outros', 104, 'Uma mulher começa a suspeitar que sua casa é assombrada, enquanto lida com o mistério em torno de sua família.', 2001, '2024-12-01 18:21:40', 'f33', 'images/Capa/hereditario-01.png'),
(56, 'Prisioneiros', 153, 'Um pai desesperado toma medidas extremas para encontrar sua filha desaparecida enquanto a polícia investiga o caso.', 2013, '2024-12-01 18:21:40', 'f34', 'images/Capa/segredo obscuro.png'),
(57, 'Cisne Negro', 108, 'Uma bailarina enfrenta pressões psicológicas e físicas enquanto se prepara para um papel desafiador em O Lago dos Cisnes.', 2010, '2024-12-01 18:21:40', 'f35', 'images/Capa/codigosecreto.png');

-- --------------------------------------------------------

--
-- Estrutura para tabela `filme_genero`
--

CREATE TABLE `filme_genero` (
  `filme_id` int(11) NOT NULL,
  `genero_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `filme_genero`
--

INSERT INTO `filme_genero` (`filme_id`, `genero_id`) VALUES
(3, 1),
(3, 2),
(4, 1),
(4, 14),
(5, 1),
(5, 2),
(5, 8),
(6, 1),
(6, 13),
(6, 14),
(7, 1),
(7, 2),
(7, 8),
(8, 1),
(8, 2),
(8, 11),
(9, 1),
(9, 2),
(9, 5),
(9, 9),
(10, 2),
(10, 8),
(10, 14),
(12, 1),
(12, 2),
(12, 11),
(13, 2),
(13, 5),
(13, 9),
(14, 2),
(14, 3),
(15, 2),
(15, 3),
(15, 6),
(15, 9),
(16, 2),
(16, 3),
(16, 4),
(17, 1),
(17, 2),
(17, 3),
(17, 8),
(18, 4),
(18, 11),
(18, 13),
(19, 4),
(19, 10),
(20, 4),
(20, 5),
(20, 15),
(21, 4),
(22, 4),
(22, 13),
(23, 5),
(23, 9),
(23, 18),
(24, 5),
(24, 13),
(25, 4),
(25, 5),
(25, 14),
(26, 4),
(26, 5),
(27, 4),
(27, 5),
(27, 13),
(28, 5),
(28, 6),
(28, 7),
(29, 6),
(29, 7),
(29, 11),
(30, 5),
(30, 6),
(30, 7),
(31, 6),
(31, 14),
(32, 5),
(32, 6),
(32, 7),
(38, 5),
(38, 8),
(39, 1),
(39, 7),
(39, 8),
(40, 5),
(40, 8),
(41, 8),
(41, 14),
(42, 5),
(42, 8),
(44, 2),
(44, 9),
(44, 18),
(45, 2),
(45, 9),
(45, 18),
(46, 2),
(46, 9),
(46, 17),
(47, 2),
(47, 9),
(47, 10),
(48, 5),
(48, 10),
(49, 5),
(49, 10),
(50, 5),
(50, 10),
(51, 5),
(51, 10),
(52, 5),
(52, 10),
(53, 7),
(53, 13),
(54, 6),
(54, 7),
(55, 6),
(55, 7),
(56, 7),
(56, 13),
(57, 5),
(57, 7);

-- --------------------------------------------------------

--
-- Estrutura para tabela `genero`
--

CREATE TABLE `genero` (
  `id` int(11) NOT NULL,
  `genero` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `genero`
--

INSERT INTO `genero` (`id`, `genero`) VALUES
(1, 'Ação'),
(2, 'Aventura'),
(3, 'Animação'),
(4, 'Comédia'),
(5, 'Drama'),
(6, 'Terror'),
(7, 'Suspense'),
(8, 'Ficção científica'),
(9, 'Fantasia'),
(10, 'Romance'),
(11, 'Mistério'),
(12, 'Documentário'),
(13, 'Crime'),
(14, 'Thriller'),
(15, 'Histórico'),
(16, 'Guerra'),
(17, 'Musical'),
(18, 'Família'),
(19, 'Esporte'),
(20, 'Western (Faroeste)');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `rg` varchar(20) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `filmes`
--
ALTER TABLE `filmes`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `filme_genero`
--
ALTER TABLE `filme_genero`
  ADD PRIMARY KEY (`filme_id`,`genero_id`),
  ADD KEY `genero_id` (`genero_id`);

--
-- Índices de tabela `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `filmes`
--
ALTER TABLE `filmes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT de tabela `genero`
--
ALTER TABLE `genero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `filme_genero`
--
ALTER TABLE `filme_genero`
  ADD CONSTRAINT `filme_genero_ibfk_1` FOREIGN KEY (`filme_id`) REFERENCES `filmes` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `filme_genero_ibfk_2` FOREIGN KEY (`genero_id`) REFERENCES `genero` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
