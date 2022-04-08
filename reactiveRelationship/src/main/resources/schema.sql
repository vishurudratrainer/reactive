CREATE TABLE if not exists author
(
    id uuid NOT NULL default gen_random_uuid(),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT author_pkey PRIMARY KEY (id)
);
CREATE TABLE if not exists book
(
    id uuid NOT NULL default gen_random_uuid(),
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    author uuid NOT NULL,
    date_of_partition timestamp without time zone NOT NULL,
    CONSTRAINT book_pkey PRIMARY KEY (id),
    CONSTRAINT "book_to_author_FK" FOREIGN KEY (author)
    REFERENCES public.author (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);


CREATE TABLE if not exists department
(
    id serial,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT department_pkey PRIMARY KEY (id)

);

CREATE TABLE if not exists student
(
    id serial,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    age numeric,
	  department_id bigint,
    CONSTRAINT student_pkey PRIMARY KEY (id),
    CONSTRAINT "student_to_department_FK" FOREIGN KEY (department_id)
    REFERENCES public.department (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);

CREATE TABLE if not exists orders
(
    id serial,
    description character varying(255) COLLATE pg_catalog."default" NOT NULL,
    amount numeric,
    customer_id bigint,
    CONSTRAINT orders_pkey PRIMARY KEY (id)
);

CREATE TABLE if not exists customer
(
    id serial,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
	  order_id bigint
);

create table if not exists customer_order(
order_id bigint,
customer_id bigint,
    CONSTRAINT customer_pkey PRIMARY KEY (id),
    CONSTRAINT "customer_to_orders_FK" FOREIGN KEY (order_id)
    REFERENCES public.orders (id) MATCH SIMPLE,
     CONSTRAINT "orders_to_customer_FK" FOREIGN KEY (customer_id)
    REFERENCES public.customer (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,

    CONSTRAINT customer_order_pkey PRIMARY KEY (order_id,customer_id)
);



