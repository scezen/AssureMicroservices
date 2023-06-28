CREATE TABLE Produit (
  id INT PRIMARY KEY AUTO_INCREMENT,
  libelle VARCHAR(255) NOT NULL,
  numero_Produit BIGINT
);

INSERT INTO Produit (libelle, numero_Produit) VALUES ('Assurance Auto', 1001);
INSERT INTO Produit (libelle, numero_Produit) VALUES ('Assurance Habitation', 1002);
INSERT INTO Produit (libelle, numero_Produit) VALUES ('Assurance Santé', 1003);
INSERT INTO Produit (libelle, numero_Produit) VALUES ('Assurance Vie', 1004);
INSERT INTO Produit (libelle, numero_Produit) VALUES ('Assurance Voyage', 1005);
INSERT INTO Produit (libelle, numero_Produit) VALUES ('Assurance Responsabilité Civile', 1006);
INSERT INTO Produit (libelle, numero_Produit) VALUES ('Assurance Moto', 1007);
INSERT INTO Produit (libelle, numero_Produit) VALUES ('Assurance Entreprise', 1008);
INSERT INTO Produit (libelle, numero_Produit) VALUES ('Assurance Invalidité', 1009);
INSERT INTO Produit (libelle, numero_Produit) VALUES ('Assurance Animaux', 1010);
