-- V1__create-tables.sql

-- Creación de la tabla usuarios
CREATE TABLE usuarios (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL unique,
  contrasena VARCHAR(255) NOT NULL
);

-- Creación de la tabla cursos
CREATE TABLE cursos (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  categoria VARCHAR(255) NOT NULL
);

-- Creación de la tabla topicos
CREATE TABLE topicos (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  titulo VARCHAR(150) NOT NULL unique,
  mensaje VARCHAR(255) NOT NULL unique,
  fecha_creacion DATETIME NOT NULL,
  status VARCHAR(255) NOT NULL,
  autor_id BIGINT,
  curso_id BIGINT,
  CONSTRAINT fk_topicos_autor
    FOREIGN KEY (autor_id)
    REFERENCES usuarios (id),
  CONSTRAINT fk_topicos_curso
    FOREIGN KEY (curso_id)
    REFERENCES cursos (id)
);

-- Creación de la tabla respuestas
CREATE TABLE respuestas (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  mensaje VARCHAR(255) NOT NULL unique,
  topico_id BIGINT NOT NULL,
  fecha_creacion DATETIME NOT NULL,
  autor_id BIGINT,
  solucion BOOLEAN NOT NULL,
  CONSTRAINT fk_respuestas_topico
    FOREIGN KEY (topico_id)
    REFERENCES topicos (id),
  CONSTRAINT fk_respuestas_autor
    FOREIGN KEY (autor_id)
    REFERENCES usuarios (id)
);
