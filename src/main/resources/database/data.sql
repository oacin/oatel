INSERT INTO room(floor, type, capacity)
VALUES('T', 'Single', 1),
('1', 'Double', 2),
('2', 'Single', 1),
('3', 'Queen', 4),
('4', 'King', 5)

INSERT INTO booking(room, startDate, endDate, price, guest)
VALUES(1, DATE '2020-09-27', DATE '2020-09-29', 270.60, 'Oacin'),
(5, DATE '2020-10-05', DATE '2020-10-16', 999.99, 'Tex'),
(3, DATE '2020-12-25', DATE '2020-12-26', 1682, 'Jonas')
