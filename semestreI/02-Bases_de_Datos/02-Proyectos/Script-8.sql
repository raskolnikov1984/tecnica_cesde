CREATE DATABASE Procedures;

USE Procedures;

CREATE TABLE tblUsers (
	id INT PRIMARY KEY IDENTITY,
	userName VARCHAR(30),
	fullName VARCHAR(30),
	email VARCHAR(30),
	telephone VARCHAR(15),
);



CREATE TABLE tblLogin (
	id INT PRIMARY KEY IDENTITY,
	userId INT,
	password VARCHAR(30),
	lastLogin TIMESTAMP,
	
	FOREIGN KEY (userId) REFERENCES tblUsers(id),
)

CREATE PROCEDURE uspAddLogin
	@userName VARCHAR(30),
	@password VARCHAR(30),
	@lastLogin DATETIME, 
	@userId int
AS
BEGIN
	IF exists (SELECT id FROM tblUsers WHERE id = @userId)
		INSERT INTO tblLogin (userId, password, lastLogin)
		VALUES (@userId, @password, @lastLogin)
	ELSE
		SELECT 'User Id Dont Exist';

END

drop procedure uspAddLogin

exec uspAddLogin 'juanfer', 'perezperezpepito123', NULL, 10