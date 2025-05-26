CREATE TABLE IF NOT EXISTS paciente (
    id SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    sobrenome TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    plano_de_saude BOOLEAN
    )