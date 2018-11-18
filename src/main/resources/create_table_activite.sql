USE `sportlib`;

CREATE TABLE `activite` (
    id INT NOT NULL AUTO_INCREMENT,
    etablissement VARCHAR(80),
    nom VARCHAR(100),
    adresse VARCHAR(80),
    ville VARCHAR(80),
    codepostal VARCHAR(5),
    telephone VARCHAR(20),
    jour_1 VARCHAR(60),
    jour_2 VARCHAR(60),
    jour_3 VARCHAR(60),
    jour_4 VARCHAR(60),
    jour_5 VARCHAR(60),
    jour_6 VARCHAR(60),
    jour_7 VARCHAR(60),
    image VARCHAR(255),
    ref_discipline INT,
    PRIMARY KEY ( id )
);
