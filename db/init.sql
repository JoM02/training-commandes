-- =========================
-- CLEAN
-- =========================
DROP TABLE IF EXISTS order_product;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS client;

-- =========================
-- TABLE CLIENT
-- =========================
CREATE TABLE client (
    id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    CONSTRAINT pk_client PRIMARY KEY (id)
);

-- =========================
-- TABLE PRODUCT
-- =========================
CREATE TABLE product (
    id BIGINT NOT NULL,
    name VARCHAR(150) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

-- =========================
-- TABLE ORDERS
-- =========================
CREATE TABLE orders (
    id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    client_id BIGINT NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id),
    CONSTRAINT fk_orders_client
        FOREIGN KEY (client_id)
        REFERENCES client(id)
);

-- =========================
-- TABLE ORDER_PRODUCT
-- =========================
CREATE TABLE order_product (
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    CONSTRAINT pk_order_product PRIMARY KEY (order_id, product_id),
    CONSTRAINT fk_op_order
        FOREIGN KEY (order_id)
        REFERENCES orders(id),
    CONSTRAINT fk_op_product
        FOREIGN KEY (product_id)
        REFERENCES product(id)
);




-- =========================
-- TABLE CLIENT
-- =========================
INSERT INTO client (id, name, email) VALUES
(1, 'Alice Martin', 'alice.martin@mail.com'),
(2, 'Bob Dupont', 'bob.dupont@mail.com'),
(3, 'Charlie Bernard', 'charlie.bernard@mail.com');

-- =========================
-- TABLE PRODUCT
-- =========================
INSERT INTO product (id, name, price) VALUES
(1, 'Ordinateur portable', 899.99),
(2, 'Souris sans fil', 29.90),
(3, 'Clavier mécanique', 109.50),
(4, 'Écran 27 pouces', 249.99);

-- =========================
-- TABLE ORDERS
-- =========================
INSERT INTO orders (id, created_at, status, client_id) VALUES
(1, '2025-01-10 10:15:00', 'CREATED', 1),
(2, '2025-01-11 14:30:00', 'PAID', 1),
(3, '2025-01-12 09:00:00', 'CREATED', 2);

-- =========================
-- TABLE ORDER_PRODUCT
-- =========================
INSERT INTO order_product (order_id, product_id) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 3),
(3, 4);