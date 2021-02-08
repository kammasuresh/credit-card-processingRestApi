DROP TABLE IF EXISTS Creditcard;

CREATE TABLE Creditcard (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  fullName VARCHAR(250) NOT NULL,
  cardNumber VARCHAR(250),
  cardLimit INT
);

INSERT INTO Creditcard (fullName, cardNumber, cardLimit) VALUES
  ('Aliko', '49927398716', '100000');
