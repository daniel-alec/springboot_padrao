DROP TABLE IF EXISTS estacao;
DROP TABLE IF EXISTS orgao;

CREATE TABLE orgao (
     id        SERIAL PRIMARY KEY,
     nome      VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE estacao (
     id         SERIAL PRIMARY KEY,
     nome       VARCHAR(255) NOT NULL,
     latitude   decimal,
     longitude  decimal,
     orgao_id   SERIAL
);

ALTER TABLE estacao ADD CONSTRAINT fk_estacao_orgao FOREIGN KEY (orgao_id) REFERENCES orgao;