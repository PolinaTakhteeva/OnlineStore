CREATE TABLE orders
(
  orderid integer NOT NULL DEFAULT nextval('order_orderid_seq'::regclass),
  customerid integer,
  date timestamp without time zone,
  status character varying(15),
  payment boolean,
  CONSTRAINT order_pkey PRIMARY KEY (orderid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE orders
  OWNER TO postgres;
