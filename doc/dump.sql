-- create database gestao_tcc;

CREATE TABLE tipo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(255)
);

CREATE TABLE usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo INT,
    matricula VARCHAR(100) UNIQUE,
    senha VARCHAR(255),
    FOREIGN KEY (tipo) REFERENCES tipo(id)
);

alter table usuario add column nome text;

CREATE TABLE user_token (
    id_token INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    token VARCHAR(255) NOT NULL,
    data_insercao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_validade TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    unique (id_usuario)
);

CREATE TABLE projeto (
    id_projeto INT PRIMARY KEY AUTO_INCREMENT,
    id_aluno INT,
    id_orientador INT,
    nome VARCHAR(255),
    descricao TEXT,
    data_inicio DATE,
    data_fim DATE,
    FOREIGN KEY (id_aluno) REFERENCES usuario(id),
    FOREIGN KEY (id_orientador) REFERENCES usuario(id)
);

CREATE TABLE tipo_documento (
    id_tipo_documento INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(255),
    prazo_final DATE
);

CREATE TABLE documento (
    id_documento INT PRIMARY KEY AUTO_INCREMENT,
    tipo_documento INT,
    id_projeto INT,
    data_envio DATE,
    prazo_final DATE,
    FOREIGN KEY (tipo_documento) REFERENCES tipo_documento(id_tipo_documento),
    FOREIGN KEY (id_projeto) REFERENCES projeto(id_projeto)
);

CREATE TABLE status (
    id_status INT PRIMARY KEY AUTO_INCREMENT,
    cod_status VARCHAR(50)
);

CREATE TABLE arquivo (
    id_arquivo INT PRIMARY KEY AUTO_INCREMENT,
    arquivo LONGBLOB,
    data_envio DATE,
    id_documento INT,
    FOREIGN KEY (id_documento) REFERENCES documento(id_documento)
);

CREATE TABLE reuniao (
    id_reuniao INT PRIMARY KEY AUTO_INCREMENT,
    id_documento INT,
    data_hora DATETIME,
    descricao TEXT,
    FOREIGN KEY (id_documento) REFERENCES documento(id_documento)
);

CREATE TABLE reuniao_arquivo (
    id_reuniao_arquivo INT PRIMARY KEY AUTO_INCREMENT,
    id_reuniao INT,
    id_arquivo INT,
    id_usuario INT,
    FOREIGN KEY (id_reuniao) REFERENCES reuniao(id_reuniao),
    FOREIGN KEY (id_arquivo) REFERENCES arquivo(id_arquivo),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

CREATE TABLE banca (
    id_banca INT PRIMARY KEY AUTO_INCREMENT,
    id_coordenador INT,
    FOREIGN KEY (id_coordenador) REFERENCES usuario(id)
);

CREATE TABLE banca_professor (
    id_banca_professor INT PRIMARY KEY AUTO_INCREMENT,
    id_banca INT,
    id_professor INT,
    FOREIGN KEY (id_banca) REFERENCES banca(id_banca),
    FOREIGN KEY (id_professor) REFERENCES usuario(id)
);

CREATE TABLE banca_professor_projeto (
    id_banca_professor_projeto INT PRIMARY KEY AUTO_INCREMENT,
    id_banca_professor INT,
    id_projeto INT,
    nota DECIMAL(5, 2),
    FOREIGN KEY (id_banca_professor) REFERENCES banca_professor(id_banca_professor),
    FOREIGN KEY (id_projeto) REFERENCES projeto(id_projeto)
);

CREATE TABLE comentario (
    id_comentario INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT,
    id_projeto INT,
    descricao TEXT,
    data_hora_insercao timestamp,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_projeto) REFERENCES projeto(id_projeto)
);

CREATE TABLE aluno_orientador (
    id_aluno_orientador INT AUTO_INCREMENT PRIMARY KEY,
    id_aluno INT NOT NULL,
    id_orientador INT NOT NULL,
    FOREIGN KEY (id_aluno) REFERENCES usuario(id),
    FOREIGN KEY (id_orientador) REFERENCES usuario(id)
);

ALTER TABLE documento 
ADD COLUMN status INT,
ADD CONSTRAINT fk_documento_status FOREIGN KEY (status) REFERENCES status(id_status);
