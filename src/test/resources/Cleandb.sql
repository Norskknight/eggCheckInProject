SET foreign_key_checks = 0;
DELETE FROM Role;
DELETE FROM User;
DELETE FROM Eggs;
TRUNCATE TABLE Role;
TRUNCATE TABLE EggCheckerTest.User;
TRUNCATE TABLE Eggs;
SET foreign_key_checks = 1;