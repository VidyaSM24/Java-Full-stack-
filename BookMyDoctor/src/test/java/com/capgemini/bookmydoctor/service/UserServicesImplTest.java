package com.capgemini.bookmydoctor.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.User;
import com.capgemini.bookmydoctor.exception.UserException;

@SpringBootTest
class UserServicesImplTest {

	@Autowired
	UserServices userServices;

	@Test
	void testAddUser() {
		User user = new User();
		user.setUserName("admin");
		user.setUserEmail("admin123@gmail.com");
		user.setUserPassword("admin123");
		user.setRole("admin");

		try {
			boolean status = userServices.addUser(user);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(UserException.class, () -> {
				userServices.addUser(user);
			});
		}
	}

	@Test
	void testUpdateUser() {
		User user = new User();
		user.setUserName("Vidya Malnad");
		user.setUserPassword("vidyasm");
		user.setUserEmail("malnadvidya@gmail.com");
		user.setRole("admin");
	}

	@Test
	void testLoginUser() {
		User user = new User();
		user.setUserEmail("admin@gmail.com");
		user.setUserPassword("admin123");
	}

	@Test
	void testDeleteUser() {
		String userEmail = "admin@gmail.com";
		try {
			boolean status = userServices.deleteUser(userEmail);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(UserException.class, () -> {
				userServices.deleteUser(userEmail);
			});
		}
	}

	@Test
	void testGetAllUser() {
		List<User> userList = userServices.getAllUser();
		assertNotNull(userList);

	}

//	@Test
//	void testSearchUser() {
////		User user= new User();
//		String userEmail="surajkhan@gmail.com";
//          userDao.searchUser(userEmail);
//     try {
//	User user=userDao.searchUser(user);
//	assertEquals(user != null, true);
//    }catch(Exception e) {
//	assertThrows(UserException.class, () ->{
//		userDao.searchUser(userEmail);
//		
//	});
//
//}
//}
}
