CREATE TABLE vehiculos(
  placa VARCHAR(10) PRIMARY KEY,
  marca VARCHAR(50) NOT NULL,
  modelo VARCHAR(50) NOT NULL,
  anio INT NOT NULL,
  precio double precision NOT NULL,
  color VARCHAR(30),
  disponible BOOLEAN NOT NULL
);