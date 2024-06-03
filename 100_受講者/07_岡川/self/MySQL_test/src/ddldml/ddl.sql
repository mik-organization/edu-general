DROP schema sample;
CREATE schema sample;

use sample;
CREATE TABLE vegetable(
    id int comment 'ID',
    name varchar(10) comment '名前',
    price int comment '値段'
);
