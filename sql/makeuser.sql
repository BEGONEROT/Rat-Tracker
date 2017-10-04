CREATE USER IF NOT EXISTS 'tracker'@'localhost' IDENTIFIED BY '123';
GRANT ALL PRIVILEGES ON begone_rot.* TO 'tracker'@'localhost';
FLUSH PRIVILEGES;
