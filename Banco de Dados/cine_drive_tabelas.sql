
-- Tabela de usuários
-- dependencias: nenhuma
CREATE TABLE usuario (
	id int not null auto_increment,
    email varchar(30) not null unique,
    senha varchar(15) not null,
    nome varchar(15) not null,
    primary key (id),
    check(char_length(senha) >= 8)
);
-- insert into filme (titulo, ano, imagem_url, nota, tempo, sinopse) values ('filme 4', '2025', 'https://escolaeducacao.com.br/wp-content/uploads/2019/04/boneco-do-mal.jpg', 5.0, 150, 'sinopse do filme 4');
-- Tabela de filmes
-- dependencias: nenhuma
CREATE TABLE filme ( -- adicionar atributo nota
	id int not null auto_increment,
    titulo varchar(50) not null,
    ano int not null,
    imagem_url text,
    nota float,
    tempo int,
    sinopse text,
    primary key (id)
);

-- Tabela de genero 
-- dependencias: nenhuma
-- guarda um genero e seu id
CREATE TABLE genero (
	id int not null auto_increment,
    nome varchar(30) unique not null,
    primary key (id)
);

-- Tabela de generos dos filmes
-- dependencias: filme e genero
-- guarda o id de um genero e associa ele a um filme
CREATE TABLE generos_filme (
	id_genero int not null,
    id_filme int not null,
	foreign key (id_genero) references genero(id),
    foreign key (id_filme) references filme(id) on delete cascade
);

-- tabela de uploads
-- dependencias: filme e usuario
CREATE TABLE upload (
	id_usuario int,
    id_filme int unique,
    video_path text not null,
	data_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    foreign key (id_filme) references filme(id) on delete cascade,
    foreign key (id_usuario) references usuario(id) on delete cascade
);

-- taabela de avaliaçao
-- dependencias: filme e usuario
-- garda nota dada por um usuário para um filme
CREATE TABLE avaliacao (
	id_filme int,
	id_usuario int,
    nota int,
    data_avaliaca timestamp default current_timestamp,
    foreign key (id_filme) references filme(id) on delete cascade,
    foreign key (id_usuario) references usuario(id),
    unique key (id_filme, id_usuario)
);

-- tabela de comentários
-- dependencias: filme e usuário
-- garda o comentário feito a um filme por um usuário em expecifico 
CREATE TABLE comentario (
	id_filme int,
    id_usuario int, 
    comentario text, 
    data_comentario timestamp default current_timestamp,
    foreign key (id_filme) references filme(id) on delete cascade,
    foreign key (id_usuario) references usuario(id) 
);

-- Tabela de downloads
-- dependências: filme e usuário
CREATE TABLE download (
    id_usuario int,
    id_filme int,
    data_download TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    foreign key (id_filme) references filme(id) on delete cascade,
    foreign key (id_usuario) references usuario(id) on delete cascade
);


-- Procedimento para a inserção de generos para um filme
DELIMITER //
CREATE PROCEDURE InserirGenerosParaFilme (
    IN filme_id INT,
    IN genero_nomes VARCHAR(300) -- Uma string contendo nomes de gêneros separados por vírgula
)
BEGIN
    -- Declaração de variáveis
    DECLARE genero_nome VARCHAR(30);
    DECLARE genero_id INT;
    DECLARE done INT DEFAULT 0;
    DECLARE generos_cursor CURSOR FOR
        SELECT id FROM genero WHERE FIND_IN_SET(nome, genero_nomes);
    
    -- Manipulador de exceções
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    
    -- Verifica se o filme existe
    IF NOT EXISTS (SELECT 1 FROM filme WHERE id = filme_id) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'O filme especificado não existe.';
    END IF;
    
    -- Loop para inserir os gêneros
    OPEN generos_cursor;
    read_loop: LOOP
        FETCH generos_cursor INTO genero_id;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        -- Insere o registro na tabela generos_filme
        INSERT INTO generos_filme (id_genero, id_filme) VALUES (genero_id, filme_id);
    END LOOP;
    
    CLOSE generos_cursor;
END;
//
DELIMITER ;

-- Fazer triguer para atualizar a nota do filme a cada avaliação
DELIMITER //
CREATE TRIGGER AtualizarNotaFilmeInsert
AFTER INSERT ON avaliacao
FOR EACH ROW
BEGIN
    DECLARE totalNotas INT;
    DECLARE mediaNota FLOAT;

    -- Calcula o total de notas e a média
    SELECT COUNT(*), AVG(nota)
    INTO totalNotas, mediaNota
    FROM avaliacao
    WHERE id_filme = NEW.id_filme;

    -- Atualiza a nota do filme
    UPDATE filme
    SET nota = mediaNota
    WHERE id = NEW.id_filme;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER AtualizarNotaFilmeUpdate
AFTER UPDATE ON avaliacao
FOR EACH ROW
BEGIN
    DECLARE totalNotas INT;
    DECLARE mediaNota FLOAT;

    -- Calcula o total de notas e a média
    SELECT COUNT(*), AVG(nota)
    INTO totalNotas, mediaNota
    FROM avaliacao
    WHERE id_filme = NEW.id_filme;

    -- Atualiza a nota do filme
    UPDATE filme
    SET nota = mediaNota
    WHERE id = NEW.id_filme;
END;
//
DELIMITER ;


-- Procedimento que insere ou atualiza uma avaliação caso elea exista
DELIMITER //
CREATE PROCEDURE inserir_ou_atualizar_avaliacao(
    IN p_id_filme INT,
    IN p_id_usuario INT,
    IN p_nota INT
)
BEGIN
    DECLARE v_id_avaliacao INT;

    -- Verifica se a avaliação já existe para o filme e usuário especificados
    SELECT id_filme INTO v_id_avaliacao
    FROM avaliacao
    WHERE id_filme = p_id_filme AND id_usuario = p_id_usuario;

    IF v_id_avaliacao IS NOT NULL THEN
        -- Avaliação já existe, atualiza a nota
        UPDATE avaliacao
        SET nota = p_nota
        WHERE id_filme = p_id_filme AND id_usuario = p_id_usuario;
    ELSE
        -- Avaliação não existe, insere uma nova
        INSERT INTO avaliacao (id_filme, id_usuario, nota)
        VALUES (p_id_filme, p_id_usuario, p_nota);
    END IF;
END//
DELIMITER ;


-- CALL InserirGenerosParaFilme(1, 'Ação,Drama,Comédia');

SELECT u.nome AS nome_usuario, COUNT(up.id_usuario) AS numero_uploads
FROM usuario u
LEFT JOIN uploads up ON u.id = up.id_usuario
GROUP BY u.nome
ORDER BY numero_uploads DESC
LIMIT 10;

