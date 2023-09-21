-- Alterar la columna 'contrasena' para aceptar 300 caracteres
ALTER TABLE usuarios
MODIFY COLUMN contrasena VARCHAR(300) NOT NULL;

-- Añadir restricción de unicidad a la columna 'nombre'
ALTER TABLE usuarios
ADD CONSTRAINT unique_nombre UNIQUE (nombre);
