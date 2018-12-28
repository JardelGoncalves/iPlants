# iPlants
Uma Aplicação para gerenciar e catalogar plantas


## Esquema do Banco de Dados
```
CREATE TABLE usuarios(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	email VARCHAR(200) NOT NULL UNIQUE,
	senha VARCHAR(100) NOT NULL,
	created DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE plantas(
	id SERIAL PRIMARY KEY,
	usuario_id INTEGER,
	nome VARCHAR(100) NOT NULL,
	descricao TEXT NOT NULL,
	foto VARCHAR(100) NOT NULL,
	created DATE NOT NULL DEFAULT CURRENT_DATE,
	CONSTRAINT fk_usuarios_plantas FOREIGN KEY (usuario_id)
	REFERENCES usuarios (id)
);
```
