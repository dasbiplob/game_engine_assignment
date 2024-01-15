# Game Account (Wallet Service) Documentation

## Introduction

This project aims to develop a simple game account (wallet service) that integrates with game engines for purchasing games and handling wins. 
The game account operates as a server, providing an HTTP API for game engines and managing customer account balances. 
This document outlines the design, implementation, and testing of the system.

## HTTP API Design

### Charging a Game

- Endpoint: `/api/accounts/event`
- Method: POST
- Payload:
  ```json
  {
    "account_balance": 1000.50,
    "event_id": "event1",
    "time_stamp": "2023-01-01T12:30:00.000+00:00",
    "player_id": "player1",
    "event_type": "WIN",
    "amount": 10.5,
    "customer_id": "customer1"
  }
# Response:
{
  "new_balance": 990.00
}

### Winning a Game

- Endpoint: /api/accounts/event
- Method: POST
- Payload:
  ```json
  {
  "account_balance": 1000.50,
  "event_id": "event1",
  "time_stamp": "2023-01-01T12:30:00.000+00:00",
  "player_id": "player1",
  "event_type": "PURCHASE",
  "amount": 10.5,
  "customer_id": "customer1"
}
# Response:
{
  "new_balance": 1011.00
}

## Running the System
# Postman
- Make a POST request to: http://localhost:8083/api/accounts/event
- Use the payload mentioned above for both winning and purchasing events.

## Swagger
- Access the URL: http://localhost:8083/swagger-ui/index.html
- Execute the API calls with the provided payloads.


