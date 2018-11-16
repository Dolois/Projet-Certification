CREATE DATABASE `sportlib`;
USE `sportlib`;

CREATE TABLE `activite` (
	id INT NOT NULL AUTO_INCREMENT,
    structure VARCHAR(80),
    nom VARCHAR(100),
    adresse VARCHAR(80),
    ville VARCHAR(80),
    codepostal VARCHAR(5),
    telephone VARCHAR(20),
	horaire_lundi VARCHAR(60),
    horaire_mardi VARCHAR(60),
    horaire_mercredi VARCHAR(60),
    horaire_jeudi VARCHAR(60),
    horaire_vendredi VARCHAR(60),
    horaire_samedi VARCHAR(60),
    horaire_dimanche VARCHAR(60),
	image LONGTEXT,
    ref_discipline INT,
    PRIMARY KEY ( id )
);

INSERT INTO `activite` (structure, nom, adresse, ville, codepostal, telephone, horaire_lundi, horaire_mardi, horaire_mercredi, horaire_jeudi, horaire_vendredi, horaire_samedi, horaire_dimanche, image, ref_discipline)
VALUES (
'Stade',
'Nautique de Pessac',
'13 Avenue des Aciéries',
'Pessac',
'33600',
'05 56 07 35 84',
'12h00 à 14h00 et de 17h00 à 19h30',
'12h00 à 14h00 et de 17h00 à 21h00',
'10H00 à 19h30',
'12h00 à 14h00 et de 17h00 à 21h00',
'12h00 à 14h00 et de 17h00 à 19h30',
'11h00 à 19h00',
'10H00 à 19h00',
'https://www.bing.com/th?id=A%2boclkcL9kFxWEQ480x360&pid=Local',
1
);

INSERT INTO `activite` (structure, nom, adresse, ville, codepostal, telephone, horaire_lundi, horaire_mardi, horaire_mercredi, horaire_jeudi, horaire_vendredi, horaire_samedi, horaire_dimanche, image, ref_discipline)
VALUES (
'Piscine',
'Georges Vallerey',
'140 Avenue Gambetta',
'Paris',
'75020',
'01 40 31 15 20',
'11h45 à 13h30',
'11h45 à 13h30 et de 17h15 à 22h00',
'07H00 à 08h30 et de 12h30 à 19h00',
'11h45 à 13h30 et de 17h15 à 22h00',
'07h00 à 18h00',
'11h00 à 19h00',
'11H00 à 19h00',
'https://www.guide-piscine.fr/medias/image/piscine_georges_vallerey_a_paris_20e_-2543-300-0.jpg',
1
);

INSERT INTO `activite` (structure, nom, adresse, ville, codepostal, telephone, horaire_lundi, horaire_mardi, horaire_mercredi, horaire_jeudi, horaire_vendredi, horaire_samedi, horaire_dimanche, image, ref_discipline)
VALUES (
'Stade',
'InfraStructure sports et loisirs',
'30 rue Louis Lumière',
'Paris',
'75020',
'01 43 70 86 32',
'18h00 à 22h00',
'18h00 à 22h00',
'18h30 à 22h00',
'Fermeture',
'19h30 à 22h00',
'Fermeture',
'Fermeture',
'http://www.ethic-etapes.com/images/upload/portfolio_img/rip_301275987391.jpg',
1
);

INSERT INTO `activite` (structure, nom, adresse, ville, codepostal, telephone, horaire_lundi, horaire_mardi, horaire_mercredi, horaire_jeudi, horaire_vendredi, horaire_samedi, horaire_dimanche, image, ref_discipline)
VALUES (
'Salle',
'Club de Gymnastique',
'39 rue des Amandiers',
'Paris',
'75020',
'06 83 46 68 96',
'11h00 à 21h00',
'11h00 à 21h00',
'11h00 à 21h00',
'11h00 à 21h00',
'11h00 à 21h00',
'11h00 à 21h00',
'Fermeture',
'https://s3-eu-west-1.amazonaws.com/g4l-images/551ac363e4b0c9516e4b4dc6/2999b36ff6562a6f0782213232feb6fc',
1
);



 