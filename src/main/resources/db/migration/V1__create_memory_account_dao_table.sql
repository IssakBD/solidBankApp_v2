CREATE TABLE Account
(
    account_id BIGINT NOT NULL AUTO_INCREMENT,
    account_type NVARCHAR(40)  NOT NULL,
    client_id BIGINT  NOT NULL,
    balance DOUBLE PRECISION NOT NULL,
    withdraw_allowed BIT NOT NULL,
    full_account_id NVARCHAR(40),
    CONSTRAINT PK_ACCOUNT PRIMARY KEY (account_id)
);

-- CREATE TABLE Transactions
-- (
--     transaction_id BIGINT NOT NULL AUTO_INCREMENT,
--     name_of_transaction NVARCHAR(40)  NOT NULL,
--     amount DOUBLE PRECISION NOT NULL NOT NULL,
--     full_account_id NVARCHAR(40),
--     client_id INT NOT NULL,
--     transaction_status BIT NOT NULL,
--     CONSTRAINT PK_TRANSACTIONS PRIMARY KEY (transaction_id)
-- );