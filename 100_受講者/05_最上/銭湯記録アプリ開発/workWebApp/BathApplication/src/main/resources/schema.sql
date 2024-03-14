--BathInfo(銭湯情報)--
create table if not exists bathInfo
(
	bathInfoId INT NOT NULL AUTO_INCREMENT,
	bathName VARCHAR(20) NOT NULL,
	address VARCHAR(100) NOT NULL,
	openTime INT,
	closeTime  INT,
	price INT,
	tel INT,
	roten BOOLEAN,
	sauna BOOLEAN,
	PRIMARY KEY(bathInfoId)
);
--Genre(ジャンル)--
create table if not exists genre
(
	genreId INT NOT NULL AUTO_INCREMENT,
	genreName VARCHAR(20) NOT NULL,
	PRIMARY KEY(genreId)
);	
	
--Area(地域)--
create table if not exists area
(
	areaId  INT NOT NULL AUTO_INCREMENT,
	areaName VARCHAR(20) NOT NULL,
	PRIMARY KEY(areaId)
);

--Review(評価)--
create table if not exists review
(
	reviewId INT NOT NULL AUTO_INCREMENT,
	reviewValue DOUBLE NOT NULL,
	PRIMARY KEY(reviewId)
);

--Bath(銭湯一覧)--
create table if not exists bath
(
	bathId INT NOT NULL AUTO_INCREMENT,
	bathInfoId INT NOT NULL,
	genreId INT NOT NULL,--
	areaId INT NOT NULL,
	reviewAverage DOUBLE NOT NULL,
	PRIMARY KEY(bathId),
	FOREIGN KEY(bathInfoId) REFERENCES bathInfo(bathInfoId),
	FOREIGN KEY(genreId) REFERENCES genre(genreId),
	FOREIGN KEY(areaId) REFERENCES area(areaId)
);

--BathIntegrationEntitiy(銭湯情報全体)--
create table if not exists bathIntegrationEntitiy
(
	bathIntegrationEntitiyId INT NOT NULL AUTO_INCREMENT,
	bathInfoId INT NOT NULL,
	bathName VARCHAR(20) NOT NULL,
	address VARCHAR(100) NOT NULL,
	openTime INT,
	closeTime  INT,
	price INT,
	tel INT,
	roten BOOLEAN,
	sauna BOOLEAN,
	bathId INT NOT NULL,
	genreId INT NOT NULL,
	areaId INT NOT NULL,
	comments VARCHAR(500),
	PRIMARY KEY(bathIntegrationEntitiyId),
	FOREIGN KEY(bathInfoId) REFERENCES bathInfo(bathInfoId),
	FOREIGN KEY(bathId) REFERENCES bath(bathId),
	FOREIGN KEY(genreId) REFERENCES genre(genreId),
	FOREIGN KEY(areaId) REFERENCES area(areaId)
);

--Comment(感想一覧)--
create table if not exists comment
(
	commentId INT NOT NULL AUTO_INCREMENT,
	comment VARCHAR(500) NOT NULL,
	reviewId INT NOT NULL,
	bathInfoId INT NOT NULL,
	recordDate DATE,
	PRIMARY KEY(commentId),
	FOREIGN KEY(reviewId) REFERENCES review(reviewId),
	FOREIGN KEY(bathInfoId) REFERENCES bathInfo(bathInfoId)
);

--SearchWord(検索ワード)--
create table if not exists searchWord
(
	searchWordId INT NOT NULL AUTO_INCREMENT,
	searchWord VARCHAR(100) NOT NULL
	PRIMARY KEY(searchWordId)
)