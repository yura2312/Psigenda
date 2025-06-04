ALTER TABLE paciente
    ADD COLUMN psicologo_id INTEGER REFERENCES psicologo(id),
    ALTER COLUMN cpf TYPE VARCHAR(14);


ALTER TABLE paciente
    ADD CONSTRAINT fk_paciente_psicologo
        FOREIGN KEY (psicologo_id)
            REFERENCES psicologo (id)
            ON DELETE SET NULL; -- Ou ON DELETE RESTRICT, etc.