CREATE TABLE room(
  number INT NOT NULL,
  floor VARCHAR2(1) NOT NULL,
  category VARCHAR2(10) NOT NULL,
  capacity INT NOT NULL,
  PRIMARY KEY(number)
);

CREATE TABLE booking(
  id INT NOT NULL,
  room INT NOT NULL,
  startDate DATE NOT NULL,
  endDate DATE NOT NULL,
  price FLOAT NOT NULL,
  guest VARCHAR(100) NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(room) REFERENCES room(number)
);
