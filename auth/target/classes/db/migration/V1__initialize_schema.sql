CREATE TABLE IF NOT EXISTS `user` (
	`id` varchar(50) NOT NULL PRIMARY KEY, 
	`username` varchar(100) not null, 
	`password` varchar(100) not null, 
	`roles` varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8; 
