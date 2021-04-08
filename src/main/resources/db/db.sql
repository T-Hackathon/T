DELETE FROM user;
INSERT INTO user(ID, CREATIONTIME, UPDATETIME, VERSION, USERNAME, PASSWORD, AGE , CITY, EMAIL, PHONE) VALUES
(1, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'hsduarte', 'atuacota', '21', 'Porto', 'hugo@gmail.com','9380123123');

DELETE FROM challenge;
INSERT INTO challenge(ID, NAME, LOCATION, VIDEO, BALANCE, CUSTOMER_ID) VALUES
('CheckingAccount', 7, TIMESTAMP '2017-10-10 14:30:37.769', TIMESTAMP '2017-10-10 14:30:43.042', 1, 20.5, NULL );

DELETE FROM recipient;
INSERT INTO recipient(ID, CREATIONTIME, UPDATETIME, VERSION, ACCOUNTNUMBER, NAME, EMAIL, DESCRIPTION, PHONE, CUSTOMER_ID) VALUES
(1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1, 3, 'Sergio Gouveia', 'sergio@gmail.com', 'My colleague Sergio from A/C', '777888', 1),
(2, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 1, 5, 'Bruno Ferreira', 'bruno@gmail.com', 'My colelague Bruno from A/C', '777888', 1);

