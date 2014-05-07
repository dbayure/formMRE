-- BEGIN TABLE ciudad
CREATE TABLE ciudad
(
   id       BIGINT         NOT NULL,
   nombre   VARCHAR(255),
   pais_id  BIGINT         NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE ciudad
   ADD CONSTRAINT pk_ciudad PRIMARY KEY (id);

CREATE INDEX `FKAEEE1C58CB8ADA5B`
   ON ciudad (pais_id ASC);

-- END TABLE ciudad

-- BEGIN TABLE cobertura_salud
CREATE TABLE cobertura_salud
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE cobertura_salud
   ADD CONSTRAINT pk_cobertura_salud PRIMARY KEY (id);
-- END TABLE cobertura_salud

-- BEGIN TABLE condicion_residencia
CREATE TABLE condicion_residencia
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE condicion_residencia
   ADD CONSTRAINT pk_condicion_residencia PRIMARY KEY (id);
-- END TABLE condicion_residencia

-- BEGIN TABLE demanda_inicial
CREATE TABLE demanda_inicial
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE demanda_inicial
   ADD CONSTRAINT pk_demanda_inicial PRIMARY KEY (id);
-- END TABLE demanda_inicial

-- BEGIN TABLE documento
CREATE TABLE documento
(
   id                 BIGINT         NOT NULL,
   documento          VARCHAR(255),
   fecha_emision      DATE,
   fecha_expiracion   DATE,
   fecha_nacimiento   DATE,
   ciudad_id          BIGINT         NOT NULL,
   pais_emisor_id     BIGINT         NOT NULL,
   tipo_documento_id  BIGINT         NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE documento
   ADD CONSTRAINT pk_documento PRIMARY KEY (id);

CREATE UNIQUE INDEX ciudad_id
   ON documento (ciudad_id ASC);

CREATE INDEX `FK383D52B4176070FB`
   ON documento (ciudad_id ASC);

CREATE UNIQUE INDEX pais_emisor_id
   ON documento (pais_emisor_id ASC);

CREATE UNIQUE INDEX tipo_documento_id
   ON documento (tipo_documento_id ASC);

CREATE INDEX `FK383D52B414B23D5D`
   ON documento (pais_emisor_id ASC);

CREATE INDEX `FK383D52B476293E30`
   ON documento (tipo_documento_id ASC);

-- END TABLE documento

-- BEGIN TABLE enseres_vehiculos
CREATE TABLE enseres_vehiculos
(
   id           BIGINT         NOT NULL,
   descripcion  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE enseres_vehiculos
   ADD CONSTRAINT pk_enseres_vehiculos PRIMARY KEY (id);
-- END TABLE enseres_vehiculos

-- BEGIN TABLE estado_civil
CREATE TABLE estado_civil
(
   id      BIGINT         NOT NULL,
   estado  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE estado_civil
   ADD CONSTRAINT pk_estado_civil PRIMARY KEY (id);
-- END TABLE estado_civil

-- BEGIN TABLE forma_retorno
CREATE TABLE forma_retorno
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE forma_retorno
   ADD CONSTRAINT pk_forma_retorno PRIMARY KEY (id);
-- END TABLE forma_retorno

-- BEGIN TABLE formulario
CREATE TABLE formulario
(
   id                  BIGINT         NOT NULL,
   estado              VARCHAR(255),
   fecha_entrevista    DATETIME,
   fecha_modificacion  DATETIME,
   observaciones       LONGTEXT,
   funcionario_id      BIGINT
)
ENGINE=InnoDB;

ALTER TABLE formulario
   ADD CONSTRAINT pk_formulario PRIMARY KEY (id);

CREATE INDEX `FK350325F263612239`
   ON formulario (funcionario_id ASC);

-- END TABLE formulario

-- BEGIN TABLE funcionario
CREATE TABLE funcionario
(
   id        BIGINT         NOT NULL,
   correo    VARCHAR(255),
   nombre    VARCHAR(255),
   password  VARCHAR(255),
   telefono  INT,
   usuario   VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE funcionario
   ADD CONSTRAINT pk_funcionario PRIMARY KEY (id);
-- END TABLE funcionario

-- BEGIN TABLE hibernate_sequence
CREATE TABLE hibernate_sequence
(
   next_val  BIGINT
)
ENGINE=InnoDB;
-- END TABLE hibernate_sequence

-- BEGIN TABLE motivo_partida
CREATE TABLE motivo_partida
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE motivo_partida
   ADD CONSTRAINT pk_motivo_partida PRIMARY KEY (id);
-- END TABLE motivo_partida

-- BEGIN TABLE motivo_retorno
CREATE TABLE motivo_retorno
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE motivo_retorno
   ADD CONSTRAINT pk_motivo_retorno PRIMARY KEY (id);
-- END TABLE motivo_retorno

-- BEGIN TABLE nacionalidad
CREATE TABLE nacionalidad
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE nacionalidad
   ADD CONSTRAINT pk_nacionalidad PRIMARY KEY (id);
-- END TABLE nacionalidad

-- BEGIN TABLE nacionalidad_persona
CREATE TABLE nacionalidad_persona
(
   nacionalidad_id  BIGINT   NOT NULL,
   persona_id       BIGINT   NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE nacionalidad_persona
   ADD CONSTRAINT pk_nacionalidad_persona PRIMARY KEY (nacionalidad_id, persona_id);

CREATE INDEX `FK5DE7FD8E8E5C8C19`
   ON nacionalidad_persona (persona_id ASC);

CREATE INDEX `FK5DE7FD8E6EA07B9B`
   ON nacionalidad_persona (nacionalidad_id ASC);

-- END TABLE nacionalidad_persona

-- BEGIN TABLE nivel_educativo
CREATE TABLE nivel_educativo
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE nivel_educativo
   ADD CONSTRAINT pk_nivel_educativo PRIMARY KEY (id);
-- END TABLE nivel_educativo

-- BEGIN TABLE nivel_educativo_exterior
CREATE TABLE nivel_educativo_exterior
(
   nivel_educativo_persona_id  BIGINT,
   persona_id                  BIGINT   NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE nivel_educativo_exterior
   ADD CONSTRAINT pk_nivel_educativo_exterior PRIMARY KEY (persona_id);

CREATE INDEX `FK99546538D74B4B13`
   ON nivel_educativo_exterior (nivel_educativo_persona_id ASC);

-- END TABLE nivel_educativo_exterior

-- BEGIN TABLE nivel_educativo_persona
CREATE TABLE nivel_educativo_persona
(
   id                  BIGINT   NOT NULL,
   finalizado          BIT,
   nivel_educativo_id  BIGINT
)
ENGINE=InnoDB;

ALTER TABLE nivel_educativo_persona
   ADD CONSTRAINT pk_nivel_educativo_persona PRIMARY KEY (id);

CREATE INDEX `FK852B85F293CFFEF6`
   ON nivel_educativo_persona (nivel_educativo_id ASC);

-- END TABLE nivel_educativo_persona

-- BEGIN TABLE nivel_educativo_uruguay
CREATE TABLE nivel_educativo_uruguay
(
   nivel_educativo_persona_id  BIGINT,
   persona_id                  BIGINT   NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE nivel_educativo_uruguay
   ADD CONSTRAINT pk_nivel_educativo_uruguay PRIMARY KEY (persona_id);

CREATE INDEX `FKA3FE9564D74B4B13`
   ON nivel_educativo_uruguay (nivel_educativo_persona_id ASC);

-- END TABLE nivel_educativo_uruguay

-- BEGIN TABLE ocupacion
CREATE TABLE ocupacion
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE ocupacion
   ADD CONSTRAINT pk_ocupacion PRIMARY KEY (id);
-- END TABLE ocupacion

-- BEGIN TABLE ocupacion_exterior
CREATE TABLE ocupacion_exterior
(
   ocupacion_exterior_id  BIGINT,
   persona_id             BIGINT   NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE ocupacion_exterior
   ADD CONSTRAINT pk_ocupacion_exterior PRIMARY KEY (persona_id);

CREATE INDEX `FKEDC32766578D6D4A`
   ON ocupacion_exterior (ocupacion_exterior_id ASC);

-- END TABLE ocupacion_exterior

-- BEGIN TABLE ocupacion_uruguay
CREATE TABLE ocupacion_uruguay
(
   ocupacion_uruguay_id  BIGINT,
   persona_id            BIGINT   NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE ocupacion_uruguay
   ADD CONSTRAINT pk_ocupacion_uruguay PRIMARY KEY (persona_id);

CREATE INDEX `FKA6B7D576D939453A`
   ON ocupacion_uruguay (ocupacion_uruguay_id ASC);

-- END TABLE ocupacion_uruguay

-- BEGIN TABLE oficio
CREATE TABLE oficio
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE oficio
   ADD CONSTRAINT pk_oficio PRIMARY KEY (id);
-- END TABLE oficio

-- BEGIN TABLE oficio_exterior
CREATE TABLE oficio_exterior
(
   oficio_exterior_id  BIGINT,
   persona_id          BIGINT   NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE oficio_exterior
   ADD CONSTRAINT pk_oficio_exterior PRIMARY KEY (persona_id);

CREATE INDEX `FK5875E7E69D4BBC6C`
   ON oficio_exterior (oficio_exterior_id ASC);

-- END TABLE oficio_exterior

-- BEGIN TABLE oficio_uruguay
CREATE TABLE oficio_uruguay
(
   oficio_uruguay_id  BIGINT,
   persona_id         BIGINT   NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE oficio_uruguay
   ADD CONSTRAINT pk_oficio_uruguay PRIMARY KEY (persona_id);

CREATE INDEX `FKB26B04F6106CC55C`
   ON oficio_uruguay (oficio_uruguay_id ASC);

-- END TABLE oficio_uruguay

-- BEGIN TABLE pais
CREATE TABLE pais
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE pais
   ADD CONSTRAINT pk_pais PRIMARY KEY (id);
-- END TABLE pais

-- BEGIN TABLE pais_persona
CREATE TABLE pais_persona
(
   pais_id      BIGINT   NOT NULL,
   personas_id  BIGINT   NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE pais_persona
   ADD CONSTRAINT pk_pais_persona PRIMARY KEY (pais_id, personas_id);

CREATE INDEX `FKF95CCE48CB8ADA5B`
   ON pais_persona (pais_id ASC);

CREATE INDEX `FKF95CCE484CA0EB9E`
   ON pais_persona (personas_id ASC);

-- END TABLE pais_persona

-- BEGIN TABLE pais_residencia
CREATE TABLE pais_residencia
(
   id           BIGINT         NOT NULL,
   condiciones  VARCHAR(255),
   residencia   BIT,
   pais_id      BIGINT         NOT NULL,
   persona_id   BIGINT
)
ENGINE=InnoDB;

ALTER TABLE pais_residencia
   ADD CONSTRAINT pk_pais_residencia PRIMARY KEY (id);

CREATE INDEX `FKC322327B8E5C8C19`
   ON pais_residencia (persona_id ASC);

CREATE INDEX `FKC322327BCB8ADA5B`
   ON pais_residencia (pais_id ASC);

CREATE UNIQUE INDEX pais_id
   ON pais_residencia (pais_id ASC);

-- END TABLE pais_residencia

-- BEGIN TABLE pais_visitado
CREATE TABLE pais_visitado
(
   id       BIGINT   NOT NULL,
   pais_id  BIGINT   NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE pais_visitado
   ADD CONSTRAINT pk_pais_visitado PRIMARY KEY (id);

CREATE INDEX `FK7646F865CB8ADA5B`
   ON pais_visitado (pais_id ASC);

CREATE UNIQUE INDEX pais_id
   ON pais_visitado (pais_id ASC);

-- END TABLE pais_visitado

-- BEGIN TABLE parentezco
CREATE TABLE parentezco
(
   id           BIGINT         NOT NULL,
   descripcion  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE parentezco
   ADD CONSTRAINT pk_parentezco PRIMARY KEY (id);
-- END TABLE parentezco

-- BEGIN TABLE persona
CREATE TABLE persona
(
   id                                BIGINT         NOT NULL,
   apellido                          VARCHAR(255),
   cantidad_hijos                    INT,
   correo                            VARCHAR(255),
   direccion                         VARCHAR(255),
   fecha_partida                     DATE,
   nombre                            VARCHAR(255),
   telefono_fijo                     VARCHAR(255),
   telefono_movil                    VARCHAR(255),
   cobertura_salud_id                BIGINT         NOT NULL,
   demanda_inicial_id                BIGINT         NOT NULL,
   documento_id                      BIGINT         NOT NULL,
   enseres_vehiculos_id              BIGINT         NOT NULL,
   estado_civil_id                   BIGINT         NOT NULL,
   forma_retorno_id                  BIGINT,
   formulario_id                     BIGINT,
   motivo_partida_id                 BIGINT,
   motivo_retorno_id                 BIGINT,
   parentezco_id                     BIGINT         NOT NULL,
   sexo_id                           BIGINT         NOT NULL,
   situacion_habitacional_actual_id  BIGINT         NOT NULL,
   situacion_laboral_id              BIGINT         NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE persona
   ADD CONSTRAINT pk_persona PRIMARY KEY (id);

CREATE INDEX `FKD78FCFAC27225359`
   ON persona (documento_id ASC);

CREATE UNIQUE INDEX demanda_inicial_id
   ON persona (demanda_inicial_id ASC);

CREATE INDEX `FKD78FCFACD456D6EE`
   ON persona (demanda_inicial_id ASC);

CREATE UNIQUE INDEX estado_civil_id
   ON persona (estado_civil_id ASC);

CREATE INDEX `FKD78FCFACDCC2CA3B`
   ON persona (formulario_id ASC);

CREATE UNIQUE INDEX documento_id
   ON persona (documento_id ASC);

CREATE INDEX `FKD78FCFACAF8F2E98`
   ON persona (motivo_retorno_id ASC);

CREATE INDEX `FKD78FCFAC71E3EB9B`
   ON persona (sexo_id ASC);

CREATE INDEX `FKD78FCFAC3CFD07A0`
   ON persona (forma_retorno_id ASC);

CREATE UNIQUE INDEX situacion_laboral_id
   ON persona (situacion_laboral_id ASC);

CREATE UNIQUE INDEX enseres_vehiculos_id
   ON persona (enseres_vehiculos_id ASC);

CREATE INDEX `FKD78FCFAC5EA77734`
   ON persona (cobertura_salud_id ASC);

CREATE INDEX `FKD78FCFAC2DFE93D8`
   ON persona (motivo_partida_id ASC);

CREATE INDEX `FKD78FCFACEE63379B`
   ON persona (parentezco_id ASC);

CREATE INDEX `FKD78FCFACA6458BC`
   ON persona (situacion_laboral_id ASC);

CREATE INDEX `FKD78FCFACE348EF70`
   ON persona (enseres_vehiculos_id ASC);

CREATE UNIQUE INDEX sexo_id
   ON persona (sexo_id ASC);

CREATE INDEX `FKD78FCFAC295605E5`
   ON persona (situacion_habitacional_actual_id ASC);

CREATE UNIQUE INDEX parentezco_id
   ON persona (parentezco_id ASC);

CREATE INDEX `FKD78FCFAC5FE17C2C`
   ON persona (estado_civil_id ASC);

CREATE UNIQUE INDEX cobertura_salud_id
   ON persona (cobertura_salud_id ASC);

CREATE UNIQUE INDEX situacion_habitacional_actual_id
   ON persona (situacion_habitacional_actual_id ASC);

-- END TABLE persona

-- BEGIN TABLE persona_nacionalidad
CREATE TABLE persona_nacionalidad
(
   persona_id         BIGINT   NOT NULL,
   nacionalidades_id  BIGINT   NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE persona_nacionalidad
   ADD CONSTRAINT pk_persona_nacionalidad PRIMARY KEY (persona_id, nacionalidades_id);

CREATE INDEX `FK3529A9D4C612F46D`
   ON persona_nacionalidad (nacionalidades_id ASC);

CREATE INDEX `FK3529A9D48E5C8C19`
   ON persona_nacionalidad (persona_id ASC);

-- END TABLE persona_nacionalidad

-- BEGIN TABLE persona_titulo_exterior
CREATE TABLE persona_titulo_exterior
(
   persona_id                   BIGINT   NOT NULL,
   titulo_obtenido_exterior_id  BIGINT   NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE persona_titulo_exterior
   ADD CONSTRAINT pk_persona_titulo_exterior PRIMARY KEY (persona_id, titulo_obtenido_exterior_id);

CREATE INDEX `FK6379A5F18E5C8C19`
   ON persona_titulo_exterior (persona_id ASC);

CREATE INDEX `FK6379A5F18B64DD47`
   ON persona_titulo_exterior (titulo_obtenido_exterior_id ASC);

-- END TABLE persona_titulo_exterior

-- BEGIN TABLE persona_titulo_uruguay
CREATE TABLE persona_titulo_uruguay
(
   persona_id                  BIGINT   NOT NULL,
   titulo_obtenido_uruguay_id  BIGINT   NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE persona_titulo_uruguay
   ADD CONSTRAINT pk_persona_titulo_uruguay PRIMARY KEY (persona_id, titulo_obtenido_uruguay_id);

CREATE INDEX `FKA241D98B8E5C8C19`
   ON persona_titulo_uruguay (persona_id ASC);

CREATE INDEX `FKA241D98BEEFE64A5`
   ON persona_titulo_uruguay (titulo_obtenido_uruguay_id ASC);

-- END TABLE persona_titulo_uruguay

-- BEGIN TABLE sexo
CREATE TABLE sexo
(
   id    BIGINT         NOT NULL,
   sexo  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE sexo
   ADD CONSTRAINT pk_sexo PRIMARY KEY (id);
-- END TABLE sexo

-- BEGIN TABLE situacion_habitacional
CREATE TABLE situacion_habitacional
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE situacion_habitacional
   ADD CONSTRAINT pk_situacion_habitacional PRIMARY KEY (id);
-- END TABLE situacion_habitacional

-- BEGIN TABLE situacion_laboral
CREATE TABLE situacion_laboral
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE situacion_laboral
   ADD CONSTRAINT pk_situacion_laboral PRIMARY KEY (id);
-- END TABLE situacion_laboral

-- BEGIN TABLE tipo_documento
CREATE TABLE tipo_documento
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE tipo_documento
   ADD CONSTRAINT pk_tipo_documento PRIMARY KEY (id);
-- END TABLE tipo_documento

-- BEGIN TABLE titulo
CREATE TABLE titulo
(
   id      BIGINT         NOT NULL,
   nombre  VARCHAR(255)
)
ENGINE=InnoDB;

ALTER TABLE titulo
   ADD CONSTRAINT pk_titulo PRIMARY KEY (id);
-- END TABLE titulo

-- BEGIN TABLE titulo_persona
CREATE TABLE titulo_persona
(
   titulo_id    BIGINT   NOT NULL,
   personas_id  BIGINT   NOT NULL
)
ENGINE=InnoDB;

ALTER TABLE titulo_persona
   ADD CONSTRAINT pk_titulo_persona PRIMARY KEY (titulo_id, personas_id);

CREATE INDEX `FK7208F926F5AA295B`
   ON titulo_persona (titulo_id ASC);

CREATE INDEX `FK7208F9264CA0EB9E`
   ON titulo_persona (personas_id ASC);

-- END TABLE titulo_persona

-- BEGIN FOREIGN KEYS --
ALTER TABLE ciudad
  ADD CONSTRAINT FKAEEE1C58CB8ADA5B FOREIGN KEY (pais_id)
  REFERENCES pais (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE documento
  ADD CONSTRAINT FK383D52B4176070FB FOREIGN KEY (ciudad_id)
  REFERENCES ciudad (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE documento
  ADD CONSTRAINT FK383D52B414B23D5D FOREIGN KEY (pais_emisor_id)
  REFERENCES pais (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE documento
  ADD CONSTRAINT FK383D52B476293E30 FOREIGN KEY (tipo_documento_id)
  REFERENCES tipo_documento (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE formulario
  ADD CONSTRAINT FK350325F263612239 FOREIGN KEY (funcionario_id)
  REFERENCES funcionario (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE nacionalidad_persona
  ADD CONSTRAINT FK5DE7FD8E8E5C8C19 FOREIGN KEY (persona_id)
  REFERENCES persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE nacionalidad_persona
  ADD CONSTRAINT FK5DE7FD8E6EA07B9B FOREIGN KEY (nacionalidad_id)
  REFERENCES nacionalidad (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE nivel_educativo_exterior
  ADD CONSTRAINT FK995465388E5C8C19 FOREIGN KEY (persona_id)
  REFERENCES persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE nivel_educativo_exterior
  ADD CONSTRAINT FK99546538D74B4B13 FOREIGN KEY (nivel_educativo_persona_id)
  REFERENCES nivel_educativo_persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE nivel_educativo_persona
  ADD CONSTRAINT FK852B85F293CFFEF6 FOREIGN KEY (nivel_educativo_id)
  REFERENCES nivel_educativo (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE nivel_educativo_uruguay
  ADD CONSTRAINT FKA3FE95648E5C8C19 FOREIGN KEY (persona_id)
  REFERENCES persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE nivel_educativo_uruguay
  ADD CONSTRAINT FKA3FE9564D74B4B13 FOREIGN KEY (nivel_educativo_persona_id)
  REFERENCES nivel_educativo_persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE ocupacion_exterior
  ADD CONSTRAINT FKEDC327668E5C8C19 FOREIGN KEY (persona_id)
  REFERENCES persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE ocupacion_exterior
  ADD CONSTRAINT FKEDC32766578D6D4A FOREIGN KEY (ocupacion_exterior_id)
  REFERENCES ocupacion (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE ocupacion_uruguay
  ADD CONSTRAINT FKA6B7D5768E5C8C19 FOREIGN KEY (persona_id)
  REFERENCES persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE ocupacion_uruguay
  ADD CONSTRAINT FKA6B7D576D939453A FOREIGN KEY (ocupacion_uruguay_id)
  REFERENCES ocupacion (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE oficio_exterior
  ADD CONSTRAINT FK5875E7E68E5C8C19 FOREIGN KEY (persona_id)
  REFERENCES persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE oficio_exterior
  ADD CONSTRAINT FK5875E7E69D4BBC6C FOREIGN KEY (oficio_exterior_id)
  REFERENCES oficio (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE oficio_uruguay
  ADD CONSTRAINT FKB26B04F68E5C8C19 FOREIGN KEY (persona_id)
  REFERENCES persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE oficio_uruguay
  ADD CONSTRAINT FKB26B04F6106CC55C FOREIGN KEY (oficio_uruguay_id)
  REFERENCES oficio (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE pais_persona
  ADD CONSTRAINT FKF95CCE48CB8ADA5B FOREIGN KEY (pais_id)
  REFERENCES pais (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE pais_persona
  ADD CONSTRAINT FKF95CCE484CA0EB9E FOREIGN KEY (personas_id)
  REFERENCES persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE pais_residencia
  ADD CONSTRAINT FKC322327B8E5C8C19 FOREIGN KEY (persona_id)
  REFERENCES persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE pais_residencia
  ADD CONSTRAINT FKC322327BCB8ADA5B FOREIGN KEY (pais_id)
  REFERENCES pais (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE pais_visitado
  ADD CONSTRAINT FK7646F865CB8ADA5B FOREIGN KEY (pais_id)
  REFERENCES pais (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE persona
  ADD CONSTRAINT FKD78FCFACA6458BC FOREIGN KEY (situacion_laboral_id)
  REFERENCES situacion_laboral (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona
  ADD CONSTRAINT FKD78FCFAC2DFE93D8 FOREIGN KEY (motivo_partida_id)
  REFERENCES motivo_partida (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona
  ADD CONSTRAINT FKD78FCFACEE63379B FOREIGN KEY (parentezco_id)
  REFERENCES parentezco (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona
  ADD CONSTRAINT FKD78FCFACD456D6EE FOREIGN KEY (demanda_inicial_id)
  REFERENCES demanda_inicial (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona
  ADD CONSTRAINT FKD78FCFAC27225359 FOREIGN KEY (documento_id)
  REFERENCES documento (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona
  ADD CONSTRAINT FKD78FCFACE348EF70 FOREIGN KEY (enseres_vehiculos_id)
  REFERENCES enseres_vehiculos (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona
  ADD CONSTRAINT FKD78FCFAC295605E5 FOREIGN KEY (situacion_habitacional_actual_id)
  REFERENCES situacion_habitacional (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona
  ADD CONSTRAINT FKD78FCFACDCC2CA3B FOREIGN KEY (formulario_id)
  REFERENCES formulario (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona
  ADD CONSTRAINT FKD78FCFACAF8F2E98 FOREIGN KEY (motivo_retorno_id)
  REFERENCES motivo_retorno (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona
  ADD CONSTRAINT FKD78FCFAC71E3EB9B FOREIGN KEY (sexo_id)
  REFERENCES sexo (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona
  ADD CONSTRAINT FKD78FCFAC5FE17C2C FOREIGN KEY (estado_civil_id)
  REFERENCES estado_civil (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona
  ADD CONSTRAINT FKD78FCFAC3CFD07A0 FOREIGN KEY (forma_retorno_id)
  REFERENCES forma_retorno (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona
  ADD CONSTRAINT FKD78FCFAC5EA77734 FOREIGN KEY (cobertura_salud_id)
  REFERENCES cobertura_salud (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE persona_nacionalidad
  ADD CONSTRAINT FK3529A9D4C612F46D FOREIGN KEY (nacionalidades_id)
  REFERENCES nacionalidad (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona_nacionalidad
  ADD CONSTRAINT FK3529A9D48E5C8C19 FOREIGN KEY (persona_id)
  REFERENCES persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE persona_titulo_exterior
  ADD CONSTRAINT FK6379A5F18E5C8C19 FOREIGN KEY (persona_id)
  REFERENCES persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona_titulo_exterior
  ADD CONSTRAINT FK6379A5F18B64DD47 FOREIGN KEY (titulo_obtenido_exterior_id)
  REFERENCES titulo (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE persona_titulo_uruguay
  ADD CONSTRAINT FKA241D98B8E5C8C19 FOREIGN KEY (persona_id)
  REFERENCES persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE persona_titulo_uruguay
  ADD CONSTRAINT FKA241D98BEEFE64A5 FOREIGN KEY (titulo_obtenido_uruguay_id)
  REFERENCES titulo (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
ALTER TABLE titulo_persona
  ADD CONSTRAINT FK7208F926F5AA295B FOREIGN KEY (titulo_id)
  REFERENCES titulo (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;

ALTER TABLE titulo_persona
  ADD CONSTRAINT FK7208F9264CA0EB9E FOREIGN KEY (personas_id)
  REFERENCES persona (id)
  ON UPDATE NO ACTION
  ON DELETE NO ACTION;
-- END FOREIGN KEYS --

