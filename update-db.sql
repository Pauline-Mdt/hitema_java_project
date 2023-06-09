CREATE TABLE city_picture (
    id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT ,
    name VARCHAR(50) NOT NULL ,
    type VARCHAR(25) NOT NULL ,
    size VARCHAR(25) NOT NULL ,
    file LONGBLOB NOT NULL ,
    city_id SMALLINT UNSIGNED NOT NULL,
    last_update TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (city_id) REFERENCES city(city_id)
)
