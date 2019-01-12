CREATE DATABASE IF NOT EXISTS pdf;

INSERT INTO question_type (`id`,`name`,`description`) values (1,"C","C was originally developed by Dennis Ritchie between 1969 and 1973 at AT&T Bell Labs,[5] and used to re-implement the Unix operating system.");
INSERT INTO question_type (`id`,`name`,`description`) values (2,"C++","It was designed with a bias toward system programming and embedded, resource-constrained and large systems, with performance, efficiency and flexibility of use as its design highlights.[3]");
INSERT INTO question_type (`id`,`name`,`description`) values (3,"Spring","The Spring Framework is an application framework and inversion of control container for the Java platform. The framework's core features can be used by any Java application, but there are extensions for building web applications on top of the Java EE platform. ");
INSERT INTO question_type (`id`,`name`,`description`) values (4,"Javascript","Despite some naming, syntactic, and standard library similarities, JavaScript and Java are otherwise unrelated and have very different semantics. ");

INSERT INTO `profile`(`id`, `address`, `dateOfBirth`, `firstName`, `gender`, `lastName`, `occupation`) VALUES (1,"Iowa,USA",'1993-11-15 22:14:54',"Yogen","M","Rai","Engineer");
INSERT INTO `user` (`id`, `username`, `password`, `email`,`dateCreated`, `role`,`profile_id`) VALUES (1,'ironman','$2a$10$jXlure/BaO7K9WSQ8AMiOu3Ih3Am3kmmnVkWWHZEcQryZ8QPO3FgC','ironman@gmail.com','2015-11-15 22:14:54','admin',1);

INSERT INTO `profile`(`id`, `address`, `dateOfBirth`, `firstName`, `gender`, `lastName`, `occupation`) VALUES (2,"Kathmandu,Nepal",'1992-11-15 22:14:54',"Rabi","M","Maharjan","Student");
INSERT INTO `user` (`id`, `username`, `password`, `email`,`dateCreated`, `role`,`profile_id`) VALUES (2,'rabi','$2a$10$0tFJKcOV/Io6I3vWs9/Tju8OySoyMTpGAyO0zaAOCswMbpfma0BSK','rabi@gmail.com','2015-10-15 22:14:54','general',2);

INSERT INTO `profile`(`id`, `address`, `dateOfBirth`, `firstName`, `gender`, `lastName`, `occupation`) VALUES (3,"Indonesia",'1992-11-15 22:14:54',"John","M","Rockie","Teacher");
INSERT INTO `user` (`id`, `username`, `password`, `email`,`dateCreated`, `role`,`profile_id`) VALUES (3,'rockie','$2a$10$WILylGNCM9SxeOKL2wKT9ukUlt3XEjeo1ULn/qB66duZokcOGT.G.','rockie92@gmail.com','2015-10-16 22:14:54','general',3);

INSERT INTO `profile`(`id`, `address`, `dateOfBirth`, `firstName`, `gender`, `lastName`, `occupation`) VALUES (4,"Mumbai, India",'1990-11-15 22:14:54',"Rita","F","Khaling","Engineer");
INSERT INTO `user` (`id`, `username`, `password`, `email`,`dateCreated`, `role`,`profile_id`) VALUES (4,'rita','$2a$10$ANuESyLFe1PgzWQkq1Y1IeoWWYEtDa/47bmmig1di6CVZOwe7MGh6','khaling.rita.92@gmail.com','2015-10-12 22:14:54','admin',4);

INSERT INTO `profile`(`id`, `address`, `dateOfBirth`, `firstName`, `gender`, `lastName`, `occupation`) VALUES (5,"NULL",'1992-11-15 22:14:54',"NULL","M","NULL","NULL");
INSERT INTO `user` (`id`, `username`, `password`, `email`,`dateCreated`, `role`,`profile_id`) VALUES (5,'manish','$2a$10$jr7iN4WedV/gW7FD.jov.OrpfhBpxsPMiss3R4ZmGjNqLJgR.2ZRC','manish@gmail.com','2015-10-13 22:14:54','general',5);

INSERT INTO `question`(`id`, `dateCreated`, `heading`, `questionContent`, `question_type_id`, `user_id`) VALUES (1,"2015-10-15 22:14:54","Getting Null Pointer exception","While doing depedency injection, I'm getting null pointer exception. What could be the reason?",3,3);

INSERT INTO `question`(`id`, `dateCreated`, `heading`, `questionContent`, `question_type_id`, `user_id`) VALUES (2,"2015-10-17 22:14:54","Eliminate The Need For Casting","I am busy writing an API which modifies a graph. To control what I am exposing to the users of the API I am using interfaces. The interfaces exposing the methods which will be used are as follows. ",3,2);

INSERT INTO `question`(`id`, `dateCreated`, `heading`, `questionContent`, `question_type_id`, `user_id`) VALUES (3,"2015-8-15 22:14:54","Swapping two rows in a matrix","I am having a problem in swapping two rows in a matrix that is a 2D-dynamic array. I wanted to know if there is a function to use directly or if there is none I would like to know how to make one. Thanks in advance.",2,1);
INSERT INTO `question`(`id`, `dateCreated`, `heading`, `questionContent`, `question_type_id`, `user_id`) VALUES (4,"2015-10-18 22:14:54","Exception thrown when serializing Hibernate object to JSON","Well I am using Hibernate to load a tiny database to some classes representing the tables and interact with the database. All fine, and I can really see all results... And I don't have any null field, all of them are been used.",4,1);

INSERT INTO `answer`(`id`, `answerContent`, `dateCreated`, `question_id`, `user_id`) VALUES (1,"Can you can try with @JsonIgnoreProperties({hibernateLazyInitializer, handler})Or a rather simple approach is to annotate each getter manually with @JsonProperty","2015-10-18 22:14:54",4,4);

INSERT INTO `answer`(`id`, `answerContent`, `dateCreated`, `question_id`, `user_id`) VALUES (2,"As Christophe L above mentioned, use the Hibernate module: https://github.com/FasterXML/jackson-datatype-hibernate -- otherwise Jackson has no way of knowing how to handle types specific to a third-party library.","2015-10-18 23:14:54",4,3);

INSERT INTO `answer`(`id`, `answerContent`, `dateCreated`, `question_id`, `user_id`) VALUES (3,"Add the function addEdge(AbstractNode) to the AbstractNode interface. The implementation of this function can be getVertex().addEdge(that.getVertex) or whatever is appropriate to the implementing class.","2015-10-19 12:14:54",2,4);