package com.prac.demorestseervices.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prac.demorestseervices.model.User;

@Component
public class UserDaoServcie {

	private static List<User> users = new ArrayList<>();
	private static int userCount = 5;

	static {
		users.add(new User(1, "Infosys1", new Date()));
		users.add(new User(2, "Infosys2", new Date()));
		users.add(new User(3, "Infosys3", new Date()));
		users.add(new User(4, "Infosys4", new Date()));
		users.add(new User(5, "Infosys5", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User Save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User getUserById(int id) {

		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteUserById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}

			
		}

		return null;
	}

}
