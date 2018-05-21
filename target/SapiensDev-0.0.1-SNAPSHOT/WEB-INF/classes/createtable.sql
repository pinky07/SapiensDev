CREATE TABLE customersapiensdev ( 
        id INT(64) NOT NULL AUTO_INCREMENT, 
        firstname VARCHAR(20),
		 lastname VARCHAR(20),
		  email LONGBLOB,
		   comments VARCHAR(150),
		    recommendations VARCHAR(150),
			 createdate DATE(2),
		
        
 PRIMARY KEY (`id`));