-- You can use this file to load seed data into the database using SQL statements;
--insert into Registrant (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212'); 

INSERT INTO pais
(
  id,
  nombre
)
VALUES
(
  1,
  'Uruguay'
);

INSERT INTO ciudad
(
  id,
  nombre,
  pais_id
)
VALUES
(
  1,
  'Montevideo',
  1
);

INSERT INTO cobertura_salud
(
  id,
  nombre
)
VALUES
(
  1,
  'Mutualista'
);


INSERT INTO estado_civil
(
  id,
  estado
)
VALUES
(
  1,
  'Soltero/a'
);

INSERT INTO estado_civil
(
  id,
  estado
)
VALUES
(
  2,
  'Casado/a'
);

INSERT INTO estado_civil
(
  id,
  estado
)
VALUES
(
  3,
  'Divorciado/a'
);

INSERT INTO estado_civil
(
  id,
  estado
)
VALUES
(
  4,
  'Viudo/a'
);

INSERT INTO nacionalidad
(
  id,
  nombre
)
VALUES
(
  1,
  'Uruguayo'
);

INSERT INTO nivel_educativo
(
  id,
  nombre
)
VALUES
(
  1,
  'Primaria'
);

INSERT INTO nivel_educativo
(
  id,
  nombre
)
VALUES
(
  2,
  'Secundaria'
);

INSERT INTO nivel_educativo
(
  id,
  nombre
)
VALUES
(
  3,
  'Terciario'
);

INSERT INTO nivel_educativo
(
  id,
  nombre
)
VALUES
(
  4,
  'Universitario'
);



INSERT INTO sexo
(
  id,
  sexo
)
VALUES
(
  1,
  'Masculino'
);

INSERT INTO sexo
(
  id,
  sexo
)
VALUES
(
  2,
  'Femenino'
);

INSERT INTO tipo_documento
(
  id,
  nombre
)
VALUES
(
  1,
  'C.I. Uruguay'
);

INSERT INTO titulo
(
  id,
  nombre
)
VALUES
(
  1,
  'Titulo 1'
);

INSERT INTO funcionario
(
  id,
  correo,
  nombre,
  password,
  telefono,
  usuario
)
VALUES
(
  1,
  's@s.com',
  'seba',
  'seba',
  1234567890,
  'seba'
);

INSERT INTO demanda_inicial
(
  id,
  nombre
)
VALUES
(
  1,
  'Ninguna'
);

INSERT INTO enseres_vehiculos
(
  id,
  descripcion
)
VALUES
(
  1,
  'Ninguno'
);

INSERT INTO forma_retorno
(
  id,
  nombre
)
VALUES
(
  1,
  'Forma 1'
);

INSERT INTO parentezco
(
  id,
  descripcion
)
VALUES
(
  1,
  'Ninguno'
);


INSERT INTO titulo
(
  id,
  nombre
)
VALUES
(
  2,
  'Ninguno'
);

INSERT INTO motivo_partida
(
  id,
  nombre
)
VALUES
(
  1,
  'Motivo 1'
);

INSERT INTO motivo_retorno
(
  id,
  nombre
)
VALUES
(
  1,
  'Motivo 1'
);

INSERT INTO situacion_habitacional
(
  id,
  nombre
)
VALUES
(
  1,
  'Vivienda propia'
);

INSERT INTO situacion_laboral
(
  id,
  nombre
)
VALUES
(
  1,
  'Desempleado'
);

INSERT INTO oficio
(
  id,
  nombre
)
VALUES
(
  1,
  'Oficio 1'
);

INSERT INTO ocupacion
(
  id,
  nombre
)
VALUES
(
  1,
  'Ocupacion 1'
);




commit;