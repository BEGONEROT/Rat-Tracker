CREATE USER IF NOT EXISTS 'monty'@'localhost' IDENTIFIED BY 'some_pass';
GRANT ALL PRIVILEGES ON mydb.* TO 'monty'@'localhost';
FLUSH PRIVILEGES;
