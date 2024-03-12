

create table if not exists genre
(
	genreId INT NOT NULL AUTO_INCREMENT,
	genreName VARCHAR(20) NOT NULL,
	PRIMARY KEY(genreId)
);


create table if not exists area
(
	areaId  INT NOT NULL AUTO_INCREMENT,
	areaName VARCHAR(20) NOT NULL,
	PRIMARY KEY(areaId)
);