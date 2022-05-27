DROP TABLE IF EXISTS client CASCADE;
CREATE TABLE client
(
    client_id        SERIAL PRIMARY KEY,
    type_of_clint    varchar(50) NOT NULL,
    name_cliet       text        NOT NULL,
    surname          text        NULL,
    middle_name      text        NULL,
    telephone_number varchar(15) NOT NULL,
    email            text        NOT NULL,
    balance          integer     NOT NULL,
    credit_limit     integer     NOT NULL
);



COPY client (type_of_clint, name_cliet, surname, middle_name, telephone_number, email, balance, credit_limit)
    FROM '/home/vera/Documents/msu/6Sem/web/Web-prak/src/main/resources/sql/client.csv'
    csv HEADER;


DROP TABLE IF EXISTS debit CASCADE;
CREATE TABLE debit
(
    debit_id            SERIAL PRIMARY KEY,
    contract_id         integer REFERENCES contract_history,
    amount              integer                             NOT NULL,
    date_of_transaction date                                NOT NULL
);

COPY debit (contract_id, amount, date_of_transaction)
    FROM '/home/vera/Documents/msu/6Sem/web/Web-prak/src/main/resources/sql/debit.csv'
    csv HEADER;

DROP TABLE IF EXISTS deposit CASCADE;
CREATE TABLE deposit
(
    deposit_id          SERIAL PRIMARY KEY,
    client_id           integer REFERENCES client,
    amount              integer NOT NULL,
    date_of_transaction date    NOT NULL
);

COPY deposit (client_id, amount, date_of_transaction)
    FROM '/home/vera/Documents/msu/6Sem/web/Web-prak/src/main/resources/sql/deposit.csv'
    csv HEADER;

DROP TABLE IF EXISTS service CASCADE;
CREATE TABLE service
(
    service_id        SERIAL PRIMARY KEY,
    name_service      text        NOT NULL,
    number_of_devices integer     NOT NULL,
    minutes           real        NOT NULL,
    sms               integer     NOT NULL,
    internet          real        NOT NULL,
    tariff_fee        integer     NOT NULL,
    billing_period    varchar(10) NOT NULL -- month, year
);

COPY service (name_service, number_of_devices, minutes, sms, internet, tariff_fee, billing_period)
    FROM '/home/vera/Documents/msu/6Sem/web/Web-prak/src/main/resources/sql/service.csv'
    csv HEADER;

DROP TABLE IF EXISTS contract_history CASCADE;
CREATE TABLE contract_history
(
    contract_id       SERIAL PRIMARY KEY,
    client_id         integer REFERENCES client,
    service_id        integer REFERENCES service,
    telephone_numbers varchar(15)[] NOT NULL,
    date_start        date          NOT NULL,
    date_stop         date          NOT NULL
);

COPY contract_history (client_id, service_id, telephone_numbers, date_start, date_stop)
    FROM '/home/vera/Documents/msu/6Sem/web/Web-prak/src/main/resources/sql/contract_history.csv'
    csv HEADER;