--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-10-16 10:03:16

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
-- TOC entry 209 (class 1259 OID 73887)
-- Name: additional_information; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.additional_information (
    id integer NOT NULL,
    parentid integer NOT NULL,
    description character varying
);


ALTER TABLE public.additional_information OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 73910)
-- Name: additional_information_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.additional_information ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.additional_information_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2727 (class 2606 OID 73894)
-- Name: additional_information additional_information_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.additional_information
    ADD CONSTRAINT additional_information_pkey PRIMARY KEY (id);


--
-- TOC entry 2728 (class 2606 OID 73895)
-- Name: additional_information regions_fk_additional_information; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.additional_information
    ADD CONSTRAINT regions_fk_additional_information FOREIGN KEY (parentid) REFERENCES public.regions(id);


-- Completed on 2020-10-16 10:03:17

--
-- PostgreSQL database dump complete
--

