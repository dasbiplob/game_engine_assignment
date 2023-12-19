CREATE TABLE customers (
    id VARCHAR(50) PRIMARY KEY,
    account_balance FLOAT(53)
);


CREATE TABLE game_events (
    event_id VARCHAR(100) PRIMARY KEY,
    time_stamp timestamp(6),
    player_id VARCHAR(100),
    event_type VARCHAR(50),
    amount FLOAT(53)

);

CREATE TABLE game_accounts
(
    customer_id VARCHAR(100),
    player_id   VARCHAR(100)
)
;


INSERT INTO customers (id, account_balance)
VALUES
  ('customer1', 1000.50),
  ('customer2', 500.75),
  ('customer3', 1200.25);


INSERT INTO game_events (event_id, time_stamp, player_id, event_type, amount)
VALUES
  ('event1', '2023-01-01 12:30:00', 'player1', 'login', 0),
  ('event2', '2023-01-02 15:45:00', 'player2', 'logout', 10.5),
  ('event3', '2023-01-03 18:00:00', 'player3', 'purchase', 25.75);


INSERT INTO game_accounts (customer_id, player_id)
VALUES
  ('customer1', 'player1'),
  ('customer2', 'player2'),
  ('customer3', 'player3');
