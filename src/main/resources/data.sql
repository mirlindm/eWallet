INSERT INTO E_WALLET (ID, BALANCE)
        VALUES (1, 20.00), (2, 10.00), (3, 0);

INSERT INTO TRANSACTION (ID, AMOUNT, TIMESTAMP, TYPE, WALLET_ID)
        VALUES (1, 20.00, '20.03.2021', 'EUR', 1), (2, 10.00, '20.03.2021', 'EUR', 2),
                (3, 5.00, '20.03.2021', 'EUR', 3);