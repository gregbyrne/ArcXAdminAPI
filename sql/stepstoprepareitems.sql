--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-10-16 10:05:39

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
-- TOC entry 214 (class 1259 OID 73914)
-- Name: steps_to_help_prepare_items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.steps_to_help_prepare_items (
    id integer NOT NULL,
    parentid integer NOT NULL,
    name character varying NOT NULL,
    content character varying
);


ALTER TABLE public.steps_to_help_prepare_items OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 73927)
-- Name: steps_to_help_prepare_items_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.steps_to_help_prepare_items ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.steps_to_help_prepare_items_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2727 (class 2606 OID 73921)
-- Name: steps_to_help_prepare_items steps_to_help_prepare_items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.steps_to_help_prepare_items
    ADD CONSTRAINT steps_to_help_prepare_items_pkey PRIMARY KEY (id);


--
-- TOC entry 2728 (class 2606 OID 73922)
-- Name: steps_to_help_prepare_items steps_to_help_prepare_fk_items; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.steps_to_help_prepare_items
    ADD CONSTRAINT steps_to_help_prepare_fk_items FOREIGN KEY (parentid) REFERENCES public.steps_to_help_prepare(id);


-- Completed on 2020-10-16 10:05:39

--
-- PostgreSQL database dump complete
--

