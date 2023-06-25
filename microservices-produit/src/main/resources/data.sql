CREATE TABLE Produit (
  id INT PRIMARY KEY AUTO_INCREMENT,
  libelle VARCHAR(255) NOT NULL,
  numeroProduit BIGINT
);

INSERT INTO Produit (libelle, numeroProduit) VALUES ('Assurance Auto', 1001);
INSERT INTO Produit (libelle, numeroProduit) VALUES ('Assurance Habitation', 1002);
INSERT INTO Produit (libelle, numeroProduit) VALUES ('Assurance Santé', 1003);
INSERT INTO Produit (libelle, numeroProduit) VALUES ('Assurance Vie', 1004);
INSERT INTO Produit (libelle, numeroProduit) VALUES ('Assurance Voyage', 1005);
INSERT INTO Produit (libelle, numeroProduit) VALUES ('Assurance Responsabilité Civile', 1006);
INSERT INTO Produit (libelle, numeroProduit) VALUES ('Assurance Moto', 1007);
INSERT INTO Produit (libelle, numeroProduit) VALUES ('Assurance Entreprise', 1008);
INSERT INTO Produit (libelle, numeroProduit) VALUES ('Assurance Invalidité', 1009);
INSERT INTO Produit (libelle, numeroProduit) VALUES ('Assurance Animaux', 1010);
