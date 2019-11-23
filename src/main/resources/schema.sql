DROP TABLE IF EXISTS orgao;

CREATE TABLE orgao (
     id        SERIAL PRIMARY KEY,
     nome      UNIQUE VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS estacao;

CREATE TABLE estacao (
     id         SERIAL PRIMARY KEY,
     nome       VARCHAR(255) NOT NULL,
     latitude   decimal,
     longitude  decimal,
     orgao_id   SERIAL
);

ALTER TABLE estacao ADD CONSTRAINT fk_estacao_orgao FOREIGN KEY (orgao_id) REFERENCES orgao;