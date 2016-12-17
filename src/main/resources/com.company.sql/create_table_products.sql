CREATE TABLE products
(
  id integer NOT NULL DEFAULT nextval('"products_product_id_seq"'::regclass),
  name character varying(100),
  author character varying(100),
  CONSTRAINT pk_product_id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE products
  OWNER TO postgres;