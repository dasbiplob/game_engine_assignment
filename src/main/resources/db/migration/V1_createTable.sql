CREATE TABLE customers (
    id VARCHAR(50) PRIMARY KEY,
    accountBalanace DECIMAL(10, 2)
);


CREATE TABLE game_events (
    eventId VARCHAR(100) PRIMARY KEY,
    timestamp DATE,
    playerId VARCHAR(100),
    eventType VARCHAR(50),
    amount DECIMAL(10, 2)

);

CREATE TABLE game_accounts
(
    customerId VARCHAR(100),
    playerId   VARCHAR(100)
);
