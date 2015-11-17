INSERT INTO questionType (`id`,`name`,`description`) values (1,"C","Machine Level Programming")
INSERT INTO questionType (`id`,`name`,`description`) values (2,"C++","Object Oriented Programming")
INSERT INTO questionType (`id`,`name`,`description`) values (3,"Spring","Web applicaton development framework Object Oriented Programming")
INSERT INTO `profile`(`id`, `address`, `dateOfBirth`, `firstName`, `gender`, `lastName`, `occupation`) VALUES (1,"NULL",'2015-11-15 22:14:54',"NULL","NULL","NULL","NULL")
INSERT INTO `user` (`id`, `username`, `password`, `email`,`dateCreated`, `role`,`profile_id`) VALUES (1,'ironman','ironman','ironman@gmail.com','2015-11-15 22:14:54','admin',1);

INSERT INTO `profile`(`id`, `address`, `dateOfBirth`, `firstName`, `gender`, `lastName`, `occupation`) VALUES (3,"NULL",'1992-11-15 22:14:54',"NULL","NULL","NULL","NULL")
INSERT INTO `user` (`id`, `username`, `password`, `email`,`dateCreated`, `role`,`profile_id`) VALUES (3,'rabi','rabi','rabi@gmail.com','2015-10-15 22:14:54','general',3);


INSERT INTO `question`(`id`, `dateCreated`, `heading`, `questionContent`, `questionType_id`, `user_id`) VALUES (1,"2015-10-15 22:14:54","Getting Null Pointer exception","While doing depedency injection, I'm getting null pointer exception. What could be the reason?",3,3)

INSERT INTO `question`(`id`, `dateCreated`, `heading`, `questionContent`, `questionType_id`, `user_id`) VALUES (2,"2015-8-15 22:14:54","Swapping two rows in a matrix","I am having a problem in swapping two rows in a matrix that is a 2D-dynamic array. I wanted to know if there is a function to use directly or if there is none I would like to know how to make one. Thanks in advance.",2,1)