Create Database RRS
GO
USE RRS
GO
Create table Video
(
	id BigInt IDENTITY(1,1) not null primary key,
	seri BigInt not null,
	name nvarchar(255) not null,
	price float not null ,
	quantity int not null,
	director nvarchar(255) not null,
	time int not null,
	nation nvarchar(255) not null,
)

go
Create table Furniture
(
	id BigInt IDENTITY(1,1) not null primary key,
	seri BigInt not null,
	name nvarchar(255) not null,
	price float not null ,
	quantity int not null,
	color nvarchar(255) not null,
	material nvarchar(255) not null,
	width int not null,
	height int not null,
)

go

Create table BookOnTape
(
	id BigInt IDENTITY(1,1) not null primary key ,
	seri BigInt not null,
	name nvarchar(255) not null,
	price float not null ,
	quantity int not null,
	author nvarchar(255) not null,
	category nvarchar(255) not null,
	numberOfPages int not null,
)
--Video
insert into Video(seri, name, price, quantity, director, time, nation ) values(11111, N'Spirited Away', 320, 100, N'Hayao Miyazaki', 125, 'Japan')
insert into Video(seri, name, price, quantity, director, time, nation ) values(12121, N'Howl’s Moving Castle', 500, 110, N'Miyazaki Hayao', 119, 'Japan')
insert into Video(seri, name, price, quantity, director, time, nation ) values(100101, N'Tonari no Totoro', 230, 300, N'Hayao Miyazaki', 86, 'Japan')

--Furniture
insert into Furniture(seri, name, price, quantity, color, material, width, height ) values(010110, N'Lift chair', 1000, 110, 'white', 'cowhide', 80, 100)
insert into Furniture(seri, name, price, quantity, color, material, width, height ) values(012342, N'Chaise longue', 500, 1110, 'Brown', 'felt', 60, 150)
insert into Furniture(seri, name, price, quantity, color, material, width, height ) values(235455, N'Stool', 150, 2000, 'Brown', 'wood', 40, 60)

--BookOnTape
insert into BookOnTape(seri, name, price, quantity, author, category, numberOfPages ) values(323212, N'Think And Grow Rick', 130, 1000, N'Napoleon Hill', 'economy', 123)
insert into BookOnTape(seri, name, price, quantity, author, category, numberOfPages ) values(12342, N'Life without limits', 90, 5000, N'Nick Vujic', 'self growth', 100)
insert into BookOnTape(seri, name, price, quantity, author, category, numberOfPages ) values(33452, N'The 7 Habits of Highly Effective People', 130, 1000, N'Covey ', 'self growth', 123)




