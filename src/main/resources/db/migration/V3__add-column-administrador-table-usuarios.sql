-- Agregar columna 'administrador' a la tabla 'usuarios'
ALTER TABLE usuarios
ADD COLUMN administrador BOOLEAN NOT NULL DEFAULT false;
