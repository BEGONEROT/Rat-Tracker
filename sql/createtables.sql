CREATE DATABASE IF NOT EXISTS begone_rot;

USE begone_rot;

CREATE TABLE IF NOT EXISTS App_User (
    username varchar(50) NOT NULL,
    password integer NOT NULL,
    date_joined timestamp,
    is_admin boolean NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE IF NOT EXISTS Sighting (
    unique_key INT UNSIGNED NOT NULL AUTO_INCREMENT,
    date_created timestamp,
    location_type varchar(100) NOT NULL,
    incident_zip char(5) NOT NULL,
    incident_address varchar(100),
    city varchar(50) NOT NULL,
    borough varchar(50),
    latitude DOUBLE(16,13) NOT NULL,
    longitude DOUBLE(16,13) NOT NULL,
    PRIMARY KEY (unique_key)
);
