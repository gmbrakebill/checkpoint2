--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

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

ALTER TABLE ONLY public.countries DROP CONSTRAINT countries_pkey;
ALTER TABLE public.countries ALTER COLUMN id DROP DEFAULT;
DROP SEQUENCE public.countries_id_seq;
DROP TABLE public.countries;
SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: countries; Type: TABLE; Schema: public; Owner: dummy
--

CREATE TABLE public.countries (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.countries OWNER TO dummy;

--
-- Name: countries_id_seq; Type: SEQUENCE; Schema: public; Owner: dummy
--

CREATE SEQUENCE public.countries_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.countries_id_seq OWNER TO dummy;

--
-- Name: countries_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dummy
--

ALTER SEQUENCE public.countries_id_seq OWNED BY public.countries.id;


--
-- Name: countries id; Type: DEFAULT; Schema: public; Owner: dummy
--

ALTER TABLE ONLY public.countries ALTER COLUMN id SET DEFAULT nextval('public.countries_id_seq'::regclass);


--
-- Data for Name: countries; Type: TABLE DATA; Schema: public; Owner: dummy
--

COPY public.countries (id, name) FROM stdin;
1	Peterland
2	Belgium
3	China
4	India
5	Pakistan
6	Chile
7	Montenegro
8	Ghana
9	Chad
\.


--
-- Name: countries_id_seq; Type: SEQUENCE SET; Schema: public; Owner: dummy
--

SELECT pg_catalog.setval('public.countries_id_seq', 9, true);


--
-- Name: countries countries_pkey; Type: CONSTRAINT; Schema: public; Owner: dummy
--

ALTER TABLE ONLY public.countries
    ADD CONSTRAINT countries_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

