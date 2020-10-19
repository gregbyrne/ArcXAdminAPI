--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-10-16 10:03:50

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
-- TOC entry 202 (class 1259 OID 73842)
-- Name: area_of_interest; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.area_of_interest (
    id integer NOT NULL,
    name character varying(200) NOT NULL
);


ALTER TABLE public.area_of_interest OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 73847)
-- Name: area_of_interest_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.area_of_interest ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.area_of_interest_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2727 (class 2606 OID 73846)
-- Name: area_of_interest area_of_interest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.area_of_interest
    ADD CONSTRAINT area_of_interest_pkey PRIMARY KEY (id);


-- Completed on 2020-10-16 10:03:50

--
-- PostgreSQL database dump complete
--

