CREATE DATABASE if not exists `toolsRentalDB`;

use toolsRentalDB; 

drop table if exists rentalComments; 
drop table if exists toolsRented; 
drop table if exists toolsInventory;
drop table if exists users; 

create table users( 
	userId int(12) not null auto_increment,
	username varchar(50) not null,
	email varchar(255) not null, 
	password varchar(255) not null,
	first_name varchar(25),
	last_name varchar(25),
	primary key(userId)
);

create table toolsInventory(
	toolId int(12) not null auto_increment,
	tool_name varchar(50) not null,
	tool_type varchar(50) not null,
	rental_cost decimal(4,2) not null,
	needs_repaired boolean not null default 0,
	primary key(toolId)
);

create table toolsRented(
	rentalId int(12) not null auto_increment,
	userId int(12) not null,
	toolId INT(12) not null,
	date_rented DATETIME default Current_Timestamp,
	date_returned DATETIME,
	primary key(rentalId),
	foreign key(userId) references users(userId),
	foreign key(toolId) references toolsInventory(toolId)
); 

create table rentalComments(
	commentId INT(6) not null auto_increment,
	rentalId INT(12) not null,
	comment text not null,
	date_made DateTime default Current_Timestamp,
	needs_repaired boolean not null default 0,
	primary key (commentId),
	foreign key(rentalId) references toolsRented(rentalId)
);