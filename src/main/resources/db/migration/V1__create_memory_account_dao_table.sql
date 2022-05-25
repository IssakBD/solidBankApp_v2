CREATE TABLE MemoryAccountDAO
(
    account_id INTEGER  NOT NULL,
    first_name NVARCHAR(40)  NOT NULL,
    last_name NVARCHAR(20)  NOT NULL,
    company NVARCHAR(80),
    address NVARCHAR(70),
    city NVARCHAR(40),
    state NVARCHAR(40),
    country NVARCHAR(40),
    postal_code NVARCHAR(10),
    phone NVARCHAR(24),
    fax NVARCHAR(24),
    email NVARCHAR(60)  NOT NULL,
    CONSTRAINT PK_Customer PRIMARY KEY  (customer_id)
);

CREATE TABLE Invoice
(
    invoice_id INTEGER  NOT NULL,
    customer_id INTEGER  NOT NULL,
    invoice_date DATETIME  NOT NULL,
    billing_address NVARCHAR(70),
    billing_city NVARCHAR(40),
    billing_state NVARCHAR(40),
    billing_country NVARCHAR(40),
    billing_postal_code NVARCHAR(10),
    total NUMERIC(10,2)  NOT NULL,
    CONSTRAINT PK_Invoice PRIMARY KEY  (invoice_id),
    FOREIGN KEY (customer_id) REFERENCES Customer (customer_id)
);
