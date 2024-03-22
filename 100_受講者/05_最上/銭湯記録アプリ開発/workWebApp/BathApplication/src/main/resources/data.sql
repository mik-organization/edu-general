
--BathInfo(銭湯情報)--
--INSERT INTO bathInfo(
--	bathName, address, openTime, closeTime, price, tel, roten, sauna)
--	VALUES('札幌ホテル', '札幌市中央区１条１丁目', 10, 21, 1000, 01122223333, false, true);

--Genre(ジャンル)--
INSERT INTO genre(genreName)VALUES
('旅館'),('ホテル'),('銭湯'),('スーパー銭湯'),('秘湯');

--Area(地域)--
INSERT INTO area(areaName)VALUES
('札幌市内'),('道央'),('道北'),('道東'),('道南'),('北海道外');

--Area(地域)--
INSERT INTO review(reviewValue)VALUES
(0.0),(0.5),(1.0),(1.5),(2.0),(2.5),(3.0),(3.5),(4.0),(4.5),(5.0);

--Bath(銭湯一覧)--
--INSERT INTO bath(bathInfoId, genreId, areaId, reviewAverage)
--	VALUES(1, 2, 1, 4.0);

--BathIntegrationEntitiy(銭湯情報全体)--
--INSERT INTO bathIntegrationEntitiy(
--	bathInfoId, bathName, address, openTime, closeTime, price, tel, roten, sauna, bathId, genreId, areaId, comments)
--	VALUES(1,'札幌ホテル', '札幌市中央区１条１丁目', 10, 21, 1000, 01122223333, false, true, 1,  2, 1, '露天風呂が広くて開放感があった');

--Comment(感想一覧)--
--INSERT INTO comment(
--	comment, reviewId, bathInfoId, recordDate)
--	VALUES('露天風呂が広くて開放感があった', 9, 1, '2020-07-07');

--SearchWord(検索ワード)--
--INSERT INTO searchWord(searchWord)VALUES('広い');