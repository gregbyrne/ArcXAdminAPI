--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-10-16 10:04:43

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
-- TOC entry 205 (class 1259 OID 73862)
-- Name: area_of_interest_sub_items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.area_of_interest_sub_items (
    id integer NOT NULL,
    parentid integer NOT NULL,
    name character varying NOT NULL,
    value character varying
);


ALTER TABLE public.area_of_interest_sub_items OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 73877)
-- Name: area_of_interest_sub_items_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.area_of_interest_sub_items ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.area_of_interest_sub_items_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2727 (class 2606 OID 73869)
-- Name: area_of_interest_sub_items area_of_interest_items_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.area_of_interest_sub_items
    ADD CONSTRAINT area_of_interest_items_pk PRIMARY KEY (id);


--
-- TOC entry 2728 (class 2606 OID 73870)
-- Name: area_of_interest_sub_items area_of_interest_items_fk_sub; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.area_of_interest_sub_items
    ADD CONSTRAINT area_of_interest_items_fk_sub FOREIGN KEY (parentid) REFERENCES public.area_of_interest_items(id);


-- Completed on 2020-10-16 10:04:43

--
-- PostgreSQL database dump complete
--

