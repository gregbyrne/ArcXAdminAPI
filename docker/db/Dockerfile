FROM postgres:latest

ENV POSTGRES_ROOT_PASSWORD Powell88
ENV POSTGRES_PASSWORD=Powell88
ENV POSTGRES_USER=postgres
ENV POSTGRES_DB=arcx

EXPOSE 5432
VOLUME  ["/etc/postgresql", "/var/log/postgresql", "/var/lib/postgresql"]
COPY ./sql/arcxsql-final.sql /docker-entrypoint-initdb.d/
