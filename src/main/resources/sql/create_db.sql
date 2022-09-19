DROP TABLE IF EXISTS personal_accounts CASCADE;
CREATE TABLE personal_accounts
(
    client_id     SERIAL PRIMARY KEY,
    type_of_clint varchar(50) NOT NULL,
    name          text        NOT NULL,
    surname       text        NULL,
    middle_name   text        NULL,
    email         text        NOT NULL
);

COPY personal_accounts (type_of_clint, name, surname, middle_name, email)
    FROM '/home/vera/Documents/msu/6Sem/web/Web-prak/src/main/resources/sql/personal_accounts.csv'
    csv HEADER;

DROP TABLE IF EXISTS mobile_accounts CASCADE;
CREATE TABLE mobile_accounts
(
    client_id        integer REFERENCES personal_accounts,
    telephone_number bigint PRIMARY KEY,
    balance          integer NOT NULL
);

COPY mobile_accounts (client_id, telephone_number, balance)
    FROM '/home/vera/Documents/msu/6Sem/web/Web-prak/src/main/resources/sql/mobile_accounts.csv'
    csv HEADER;


DROP TABLE IF EXISTS transactions CASCADE;
CREATE TABLE transactions
(
    transaction_id      SERIAL PRIMARY KEY,
    type_of_transaction integer NOT NULL,
    mobile_account      bigint REFERENCES mobile_accounts,
    amount              integer     NOT NULL,
    date_of_transaction date        NOT NULL
);

COPY transactions (type_of_transaction, mobile_account, amount, date_of_transaction)
    FROM '/home/vera/Documents/msu/6Sem/web/Web-prak/src/main/resources/sql/transactions.csv'
    csv HEADER;

DROP TABLE IF EXISTS service CASCADE;
CREATE TABLE service
(
    service_id        SERIAL PRIMARY KEY,
    name_service      text          NOT NULL,
    number_of_devices integer       NOT NULL,
    minutes           real          NOT NULL,
    sms               integer       NOT NULL,
    internet          real          NOT NULL,
    unlimited_apps    varchar(50) NULL,
    tariff_fee        integer       NOT NULL
);

COPY service (name_service, number_of_devices, minutes, sms, internet, tariff_fee, unlimited_apps)
    FROM '/home/vera/Documents/msu/6Sem/web/Web-prak/src/main/resources/sql/service.csv'
    csv HEADER;

DROP TABLE IF EXISTS contract_history CASCADE;
CREATE TABLE contract_history
(
    contract_id       SERIAL PRIMARY KEY,
    mobile_account    bigint  REFERENCES mobile_accounts,
    service_id        integer REFERENCES service,
    telephone_numbers varchar(15)[] NOT NULL,
    date_start        date          NOT NULL,
    date_stop         date          NOT NULL
);

COPY contract_history (mobile_account, service_id, telephone_numbers, date_start, date_stop)
    FROM '/home/vera/Documents/msu/6Sem/web/Web-prak/src/main/resources/sql/contract_history.csv'
    csv HEADER;

