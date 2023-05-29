BEGIN;
/*
-- Tablas a usar para entrega de laboratorio 1

CREATE TABLE IF NOT EXISTS voluntario
(
    id_voluntario serial NOT NULL,
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    fecha_registro date NOT NULL,
    coordinador boolean NOT NULL,
    CONSTRAINT id_voluntario PRIMARY KEY (id_voluntario)
);

CREATE TABLE IF NOT EXISTS habilidad
(
    id_habilidad serial NOT NULL,
    codigo character varying(10) COLLATE pg_catalog."default" NOT NULL,
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT id_habilidad PRIMARY KEY (id_habilidad)
);

CREATE TABLE IF NOT EXISTS estado_tarea
(
    id_estado_tarea serial NOT NULL,
    completada boolean NOT NULL,
    CONSTRAINT id_estado_tarea PRIMARY KEY (id_estado_tarea)

);

CREATE TABLE IF NOT EXISTS vol_habilidad
(
    id_vol_habilidad serial NOT NULL,
    id_voluntario integer NOT NULL,
    id_habilidad integer NOT NULL,
    CONSTRAINT id_vol_habilidad PRIMARY KEY (id_vol_habilidad)
);

CREATE TABLE IF NOT EXISTS ranking
(
    id_ranking serial NOT NULL,
    id_voluntario integer NOT NULL,
    id_tarea integer NOT NULL,
    CONSTRAINT id_ranking PRIMARY KEY (id_ranking)
);

CREATE TABLE IF NOT EXISTS tarea
(
    id_tarea serial NOT NULL,
    id_emergencia integer NOT NULL,
    id_estado_tarea integer NOT NULL,
    CONSTRAINT id_tarea PRIMARY KEY (id_tarea)
);

CREATE TABLE IF NOT EXISTS eme_habilidad
(
    id_eme_habilidad serial NOT NULL,
    id_emergencia integer NOT NULL,
    id_habilidad integer NOT NULL,
    CONSTRAINT id_eme_habilidad PRIMARY KEY (id_eme_habilidad)
);

CREATE TABLE IF NOT EXISTS institucion
(
    id_institucion serial NOT NULL,
    nombre character varying(20) COLLATE pg_catalog."default" NOT NULL,
    direccion character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT id_institucion PRIMARY KEY (id_institucion)
);

*/
-- Mientras tanto...
DROP TABLE IF EXISTS emergencia;
CREATE TABLE emergencia
(
    id_emergencia serial NOT NULL,
    asunto character varying(30) COLLATE pg_catalog."default" NOT NULL,
    descripcion character varying(500) COLLATE pg_catalog."default" NOT NULL,
    fecha date NOT NULL,
    activa boolean NOT NULL,
    CONSTRAINT id_emergencia PRIMARY KEY (id_emergencia)
);

END;