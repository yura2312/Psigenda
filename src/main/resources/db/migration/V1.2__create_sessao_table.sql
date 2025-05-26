CREATE TABLE IF NOT EXISTS sessao(
    id SERIAL PRIMARY KEY,
    comeco_sessao TIMESTAMP NOT NULL,
    fim_sessao TIMESTAMP NOT NULL,
    descricao TEXT,
    paciente_id INTEGER NOT NULL
    REFERENCES paciente(id)
    ON DELETE CASCADE,
    psicologo_id INTEGER NOT NULL
    REFERENCES psicologo(id)
    ON DELETE CASCADE
    )