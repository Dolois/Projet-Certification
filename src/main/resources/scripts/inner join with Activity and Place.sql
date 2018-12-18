USE `sportlib`;

SELECT place.name, place.address, activity.activity 
FROM `sportlib`.`place`
inner join `sportlib`.`activity` on activity.place_id = place.id;