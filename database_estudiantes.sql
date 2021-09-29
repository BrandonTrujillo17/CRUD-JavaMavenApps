--
-- PostgreSQL database dump
--

-- Dumped from database version 12.8 (Ubuntu 12.8-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.8 (Ubuntu 12.8-0ubuntu0.20.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: colegio; Type: TABLE; Schema: public; Owner: capistran
--

CREATE TABLE public.colegio (
    tipo character varying,
    idcolegio integer NOT NULL,
    nombre_colegio character varying
);


ALTER TABLE public.colegio OWNER TO capistran;

--
-- Name: colegio_idcolegio_seq; Type: SEQUENCE; Schema: public; Owner: capistran
--

CREATE SEQUENCE public.colegio_idcolegio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.colegio_idcolegio_seq OWNER TO capistran;

--
-- Name: colegio_idcolegio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: capistran
--

ALTER SEQUENCE public.colegio_idcolegio_seq OWNED BY public.colegio.idcolegio;


--
-- Name: estudiante; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estudiante (
    idestudiante integer NOT NULL,
    primer_nom character varying(50),
    primer_ape character varying(50),
    seg_nom character varying(50),
    seg_ape character varying(50),
    estado boolean DEFAULT false NOT NULL,
    idcolegio integer
);


ALTER TABLE public.estudiante OWNER TO postgres;

--
-- Name: estudiante_idestudiante_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estudiante_idestudiante_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estudiante_idestudiante_seq OWNER TO postgres;

--
-- Name: estudiante_idestudiante_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estudiante_idestudiante_seq OWNED BY public.estudiante.idestudiante;


--
-- Name: historia_academica; Type: TABLE; Schema: public; Owner: capistran
--

CREATE TABLE public.historia_academica (
    estudiante_idestudiante integer NOT NULL,
    antiguedad character varying,
    "año" character varying,
    "sección" character varying,
    idhistoria_academica integer NOT NULL
);


ALTER TABLE public.historia_academica OWNER TO capistran;

--
-- Name: historia_academica_idhistoria_academica_seq; Type: SEQUENCE; Schema: public; Owner: capistran
--

CREATE SEQUENCE public.historia_academica_idhistoria_academica_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.historia_academica_idhistoria_academica_seq OWNER TO capistran;

--
-- Name: historia_academica_idhistoria_academica_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: capistran
--

ALTER SEQUENCE public.historia_academica_idhistoria_academica_seq OWNED BY public.historia_academica.idhistoria_academica;


--
-- Name: inf_salud; Type: TABLE; Schema: public; Owner: capistran
--

CREATE TABLE public.inf_salud (
    estudiante_idestudiante integer NOT NULL,
    numero_seguro character varying,
    tipo_seguro character varying,
    grupo_sanguineo character varying,
    idinfo_salud integer NOT NULL
);


ALTER TABLE public.inf_salud OWNER TO capistran;

--
-- Name: inf_salud_idinfo_salud_seq; Type: SEQUENCE; Schema: public; Owner: capistran
--

CREATE SEQUENCE public.inf_salud_idinfo_salud_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.inf_salud_idinfo_salud_seq OWNER TO capistran;

--
-- Name: inf_salud_idinfo_salud_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: capistran
--

ALTER SEQUENCE public.inf_salud_idinfo_salud_seq OWNED BY public.inf_salud.idinfo_salud;


--
-- Name: origen; Type: TABLE; Schema: public; Owner: capistran
--

CREATE TABLE public.origen (
    estudiante_idestudiante integer NOT NULL,
    estado character varying,
    ciudad character varying,
    colonia character varying,
    calle_numero character varying,
    idorigen integer NOT NULL
);


ALTER TABLE public.origen OWNER TO capistran;

--
-- Name: origen_idorigen_seq; Type: SEQUENCE; Schema: public; Owner: capistran
--

CREATE SEQUENCE public.origen_idorigen_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.origen_idorigen_seq OWNER TO capistran;

--
-- Name: origen_idorigen_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: capistran
--

ALTER SEQUENCE public.origen_idorigen_seq OWNED BY public.origen.idorigen;


--
-- Name: telefonos; Type: TABLE; Schema: public; Owner: capistran
--

CREATE TABLE public.telefonos (
    acudiente_idtutor integer NOT NULL,
    fijo character varying,
    celular character varying,
    idtelefonos integer NOT NULL,
    idtutor integer NOT NULL
);


ALTER TABLE public.telefonos OWNER TO capistran;

--
-- Name: telefonos_idtelefonos_seq; Type: SEQUENCE; Schema: public; Owner: capistran
--

CREATE SEQUENCE public.telefonos_idtelefonos_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.telefonos_idtelefonos_seq OWNER TO capistran;

--
-- Name: telefonos_idtelefonos_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: capistran
--

ALTER SEQUENCE public.telefonos_idtelefonos_seq OWNED BY public.telefonos.idtelefonos;


--
-- Name: tutor; Type: TABLE; Schema: public; Owner: capistran
--

CREATE TABLE public.tutor (
    estudiante_idestudiante integer NOT NULL,
    nombre_tutor character varying,
    apellido_paterno character varying,
    apellido_materno character varying,
    direccion_tutor character varying,
    idtutor integer NOT NULL
);


ALTER TABLE public.tutor OWNER TO capistran;

--
-- Name: tutor_idtutor_seq; Type: SEQUENCE; Schema: public; Owner: capistran
--

CREATE SEQUENCE public.tutor_idtutor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tutor_idtutor_seq OWNER TO capistran;

--
-- Name: tutor_idtutor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: capistran
--

ALTER SEQUENCE public.tutor_idtutor_seq OWNED BY public.tutor.idtutor;


--
-- Name: colegio idcolegio; Type: DEFAULT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.colegio ALTER COLUMN idcolegio SET DEFAULT nextval('public.colegio_idcolegio_seq'::regclass);


--
-- Name: estudiante idestudiante; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estudiante ALTER COLUMN idestudiante SET DEFAULT nextval('public.estudiante_idestudiante_seq'::regclass);


--
-- Name: historia_academica idhistoria_academica; Type: DEFAULT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.historia_academica ALTER COLUMN idhistoria_academica SET DEFAULT nextval('public.historia_academica_idhistoria_academica_seq'::regclass);


--
-- Name: inf_salud idinfo_salud; Type: DEFAULT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.inf_salud ALTER COLUMN idinfo_salud SET DEFAULT nextval('public.inf_salud_idinfo_salud_seq'::regclass);


--
-- Name: origen idorigen; Type: DEFAULT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.origen ALTER COLUMN idorigen SET DEFAULT nextval('public.origen_idorigen_seq'::regclass);


--
-- Name: telefonos idtelefonos; Type: DEFAULT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.telefonos ALTER COLUMN idtelefonos SET DEFAULT nextval('public.telefonos_idtelefonos_seq'::regclass);


--
-- Name: tutor idtutor; Type: DEFAULT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.tutor ALTER COLUMN idtutor SET DEFAULT nextval('public.tutor_idtutor_seq'::regclass);


--
-- Data for Name: colegio; Type: TABLE DATA; Schema: public; Owner: capistran
--

COPY public.colegio (tipo, idcolegio, nombre_colegio) FROM stdin;
\.


--
-- Data for Name: estudiante; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estudiante (idestudiante, primer_nom, primer_ape, seg_nom, seg_ape, estado, idcolegio) FROM stdin;
2	Josue	Capistran	\N	Garcia	f	\N
4	Maria	Rodriguez	Fernanda	Fernanda	t	\N
1	Gabriel	Garcia	Eduardo	Eduardo	t	\N
5	Diego	Martinez	\N	Perez	t	\N
7	Mario	Dorantes	\N	Hernandez	f	\N
6	Mario	Dorantes			f	\N
3	Fernando	Martinez	Francisco	Leon	t	\N
8	Pedrito	Fernandez	Francisco	Garcia	f	\N
\.


--
-- Data for Name: historia_academica; Type: TABLE DATA; Schema: public; Owner: capistran
--

COPY public.historia_academica (estudiante_idestudiante, antiguedad, "año", "sección", idhistoria_academica) FROM stdin;
\.


--
-- Data for Name: inf_salud; Type: TABLE DATA; Schema: public; Owner: capistran
--

COPY public.inf_salud (estudiante_idestudiante, numero_seguro, tipo_seguro, grupo_sanguineo, idinfo_salud) FROM stdin;
\.


--
-- Data for Name: origen; Type: TABLE DATA; Schema: public; Owner: capistran
--

COPY public.origen (estudiante_idestudiante, estado, ciudad, colonia, calle_numero, idorigen) FROM stdin;
\.


--
-- Data for Name: telefonos; Type: TABLE DATA; Schema: public; Owner: capistran
--

COPY public.telefonos (acudiente_idtutor, fijo, celular, idtelefonos, idtutor) FROM stdin;
\.


--
-- Data for Name: tutor; Type: TABLE DATA; Schema: public; Owner: capistran
--

COPY public.tutor (estudiante_idestudiante, nombre_tutor, apellido_paterno, apellido_materno, direccion_tutor, idtutor) FROM stdin;
\.


--
-- Name: colegio_idcolegio_seq; Type: SEQUENCE SET; Schema: public; Owner: capistran
--

SELECT pg_catalog.setval('public.colegio_idcolegio_seq', 1, false);


--
-- Name: estudiante_idestudiante_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estudiante_idestudiante_seq', 8, true);


--
-- Name: historia_academica_idhistoria_academica_seq; Type: SEQUENCE SET; Schema: public; Owner: capistran
--

SELECT pg_catalog.setval('public.historia_academica_idhistoria_academica_seq', 1, false);


--
-- Name: inf_salud_idinfo_salud_seq; Type: SEQUENCE SET; Schema: public; Owner: capistran
--

SELECT pg_catalog.setval('public.inf_salud_idinfo_salud_seq', 1, false);


--
-- Name: origen_idorigen_seq; Type: SEQUENCE SET; Schema: public; Owner: capistran
--

SELECT pg_catalog.setval('public.origen_idorigen_seq', 1, false);


--
-- Name: telefonos_idtelefonos_seq; Type: SEQUENCE SET; Schema: public; Owner: capistran
--

SELECT pg_catalog.setval('public.telefonos_idtelefonos_seq', 1, false);


--
-- Name: tutor_idtutor_seq; Type: SEQUENCE SET; Schema: public; Owner: capistran
--

SELECT pg_catalog.setval('public.tutor_idtutor_seq', 1, false);


--
-- Name: colegio colegio_pkey; Type: CONSTRAINT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.colegio
    ADD CONSTRAINT colegio_pkey PRIMARY KEY (idcolegio);


--
-- Name: estudiante estudiante_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT estudiante_pkey PRIMARY KEY (idestudiante);


--
-- Name: historia_academica historia_academica_pkey; Type: CONSTRAINT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.historia_academica
    ADD CONSTRAINT historia_academica_pkey PRIMARY KEY (idhistoria_academica);


--
-- Name: inf_salud inf_salud_pkey; Type: CONSTRAINT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.inf_salud
    ADD CONSTRAINT inf_salud_pkey PRIMARY KEY (idinfo_salud);


--
-- Name: origen origen_pkey; Type: CONSTRAINT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.origen
    ADD CONSTRAINT origen_pkey PRIMARY KEY (idorigen);


--
-- Name: telefonos telefonos_pkey; Type: CONSTRAINT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.telefonos
    ADD CONSTRAINT telefonos_pkey PRIMARY KEY (idtelefonos);


--
-- Name: tutor tutor_pkey; Type: CONSTRAINT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.tutor
    ADD CONSTRAINT tutor_pkey PRIMARY KEY (idtutor);


--
-- Name: estudiante fk_idcolegio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT fk_idcolegio FOREIGN KEY (idcolegio) REFERENCES public.colegio(idcolegio);


--
-- Name: historia_academica historia_academica_fk; Type: FK CONSTRAINT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.historia_academica
    ADD CONSTRAINT historia_academica_fk FOREIGN KEY (estudiante_idestudiante) REFERENCES public.estudiante(idestudiante);


--
-- Name: inf_salud inf_salud_fk; Type: FK CONSTRAINT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.inf_salud
    ADD CONSTRAINT inf_salud_fk FOREIGN KEY (estudiante_idestudiante) REFERENCES public.estudiante(idestudiante);


--
-- Name: origen origen_fk; Type: FK CONSTRAINT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.origen
    ADD CONSTRAINT origen_fk FOREIGN KEY (estudiante_idestudiante) REFERENCES public.estudiante(idestudiante);


--
-- Name: telefonos telefonos_fk; Type: FK CONSTRAINT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.telefonos
    ADD CONSTRAINT telefonos_fk FOREIGN KEY (idtutor) REFERENCES public.tutor(idtutor);


--
-- Name: tutor tutor_fk; Type: FK CONSTRAINT; Schema: public; Owner: capistran
--

ALTER TABLE ONLY public.tutor
    ADD CONSTRAINT tutor_fk FOREIGN KEY (estudiante_idestudiante) REFERENCES public.estudiante(idestudiante);


--
-- Name: TABLE estudiante; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.estudiante TO capistran;


--
-- Name: SEQUENCE estudiante_idestudiante_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.estudiante_idestudiante_seq TO capistran;


--
-- PostgreSQL database dump complete
--

