--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-10-16 10:04:20

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
-- TOC entry 204 (class 1259 OID 73849)
-- Name: area_of_interest_items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.area_of_interest_items (
    id integer NOT NULL,
    parentid integer NOT NULL,
    name character varying NOT NULL,
    value character varying
);


ALTER TABLE public.area_of_interest_items OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 73875)
-- Name: area_of_interest_items_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.area_of_interest_items ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.area_of_interest_items_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2727 (class 2606 OID 73856)
-- Name: area_of_interest_items area_of_interest_items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.area_of_interest_items
    ADD CONSTRAINT area_of_interest_items_pkey PRIMARY KEY (id);


--
-- TOC entry 2728 (class 2606 OID 73857)
-- Name: area_of_interest_items parent_id_fk_constraint; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.area_of_interest_items
    ADD CONSTRAINT parent_id_fk_constraint FOREIGN KEY (parentid) REFERENCES public.area_of_interest(id);


-- Completed on 2020-10-16 10:04:20

--
-- PostgreSQL database dump complete
--

