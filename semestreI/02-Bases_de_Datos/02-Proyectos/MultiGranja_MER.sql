
CREATE DATABASE multigranja

/*
 * USE master
 * DROP DATABASE multigranja
 * */

USE multigranja


CREATE TABLE tblParties (
	id INT PRIMARY KEY IDENTITY,
	name VARCHAR(30)
)

CREATE TABLE tblFarms (
	id INT PRIMARY KEY IDENTITY,
	name VARCHAR(30),
	party INT,
	total_area DECIMAL(16, 2),

	FOREIGN KEY (party) REFERENCES tblParties(id)
)

CREATE TABLE tblLocations (
	id INT PRIMARY KEY IDENTITY,
	farm INT,
	
	FOREIGN KEY (farm) REFERENCES tblFarms(id)
)

CREATE TABLE tblGroups (
	id INT PRIMARY KEY IDENTITY,
	name VARCHAR(30)
)

CREATE TABLE tblSpecies (
	id INT PRIMARY KEY IDENTITY,
	name VARCHAR(30)
)

CREATE TABLE tblBreeds (
	id INT PRIMARY KEY IDENTITY,
	name VARCHAR(30),
	specie INT,
	origin VARCHAR(30),
	average_weight_female DECIMAL(4,2),
	average_weight_male DECIMAL(4,2),
	
	FOREIGN KEY (specie) REFERENCES tblSpecies(id),
)

CREATE TABLE tblAnimals (
	id INT PRIMARY KEY IDENTITY,
	location INT,
	identifier VARCHAR(30),
	nickname VARCHAR(30),
	breed INT,
	weight DECIMAL(4,2),
	birth_date DATE,
	animal_group INT,
	sex CHAR,
	age INT,
	active BIT NOT NULL DEFAULT 1,
	type VARCHAR(10),
	state VARCHAR(10),
	
	FOREIGN KEY (location) REFERENCES tblLocations(id),
	FOREIGN KEY (breed) REFERENCES tblBreeds(id),
	FOREIGN KEY (animal_group) REFERENCES tblGroups(id)
)

CREATE TABLE tblWeights (
	id INT,
	animal INT,
	weight DECIMAL(4,2),
	date DATE,
	
	FOREIGN KEY (animal) REFERENCES tblAnimals(id)
)

DROP TABLE tblFarms
DROP TABLE tblPropietaries

DROP TABLE tblGroups
DROP TABLE tblSpecies
DROP TABLE tblBreeds
DROP TABLE tblAnimals
DROP TABLE tblWeights