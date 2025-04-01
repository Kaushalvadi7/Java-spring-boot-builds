package com.springboot.SpringBootProject3JdbcCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.SpringBootProject3JdbcCrud.dao.UserDao;

@SpringBootApplication
public class SpringBootProject3JdbcCrudApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject3JdbcCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Insertion--------
		/*User user1 = new User("Kaushal", "kaushal7777@gmail.com", "male", "Jamnagar");  
		User user2 = new User("Karan", "karan9999@gmail.com", "male", "Jamnagar"); 
		boolean status = userDao.insertUser(user2);
		if(status) {
			System.out.println("User inserted successfully!");
		}else {
			System.out.println("User insertion failed!");
		}	
		*/

		//updation
		// User user = new User("Kaushal", "kaushal7777@gmail.com",  "Male", "Rajkot");
		// boolean status = userDao.updateUser(user);
		// if(status) {
		// 	System.out.println("User updated successfully!");
		// }else {	
		// 	System.out.println("User updation failed!");
		// }


		//deletion
		boolean status = userDao.deleteUserByEmail("karan9999@gmail.com");
		if(status) {
			System.out.println("User deleted successfully!");
		}else {
			System.out.println("User deletion failed!");
		}

		

	}
}
