INSERT INTO room(floor, type, capacity, isLocked)
VALUES('T', 'Single', 1, 0),
('1', 'Double', 2, 0),
('2', 'Single', 1, 0),
('3', 'Queen', 4, 0),
('4', 'King', 5, 1);

INSERT INTO booking(room, startDate, endDate, price, guest)
VALUES(1, DATE '2020-09-27', DATE '2020-09-29', 270.60, 'Oacin'),
(5, DATE '2020-10-05', DATE '2020-10-16', 999.99, 'Tex'),
(3, DATE '2020-12-25', DATE '2020-12-26', 1682, 'Jonas');
