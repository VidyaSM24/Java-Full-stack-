package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.User;
import com.capgemini.bookmydoctor.exception.UserException;

@SpringBootTest
class UserDaoImplTest {

	@Autowired
	UserDao userDao;

	@Test
	void testAddUser() {
		User user = new User();
		user.setUserName("user");
		user.setUserEmail("user@gmail.com");
		user.setUserPassword("user123");
		user.setRole("user");

		try {
			boolean status = userDao.addUser(user);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(UserException.class, () -> {
				userDao.addUser(user);
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
		User user=new User();
		user.setUserEmail("user@gmail.com");
		user.setUserPassword("user123");
	}

	@Test
	void testDeleteUser() {
		String userEmail = "user@gmail.com";
		try {
			boolean status = userDao.deleteUser(userEmail);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(UserException.class, () -> {
				userDao.deleteUser(userEmail);
			});
		}
	}

	@Test
	void testGetAllUser() {
		List<User> userList=userDao.getAllUser();
		assertNotNull(userList);
		
	}

//	@Test
//	void testSearchUser() {
//		int userId=24;
//          userDao.searchUser(userId);
//     try {
//	User user=userDao.searchUser(userId);
//	assertEquals(user!= null, false);
//    }catch(Exception e) {
//	assertThrows(UserException.class, () ->{
//		userDao.searchUser(userId);
//		
//	});
//
//}
//}
	}
