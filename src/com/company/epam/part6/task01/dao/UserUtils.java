package com.company.epam.part6.task01.dao;

import com.company.epam.part6.task01.entity.user.Role;
import com.company.epam.part6.task01.entity.user.User;
import com.company.epam.part6.task01.entity.user.UserBuilder;

import java.util.Iterator;
import java.util.List;

public class UserUtils {

	private static List<User> users;

	static {
		users = UserFileHandler.loadUsers();
	}

	public static List<User> getUsers() {
		return users;
	}

	/**
	 * Get user by provided username and password.
	 *
	 * @param username the username of user.
	 * @param password the password of user.
	 * @return the user or throw IllegalArgumentException if user doesn't exist with provided username
	 * and password.
	 */
	public static User login(String username, String password) {

		for (User user : users) {
			if (user.getUsername()
			        .equalsIgnoreCase(username) && PasswordUtils.verifyUserPassword(password, new String(user.getPassword()), user
					.getSalt())) {
				return user;
			}
		}

		throw new IllegalArgumentException("The current user doesn't exists!");
	}

	/**
	 * Add user to the user list.
	 *
	 * @param username the username of the user
	 * @param password the password of the user
	 * @return false if user exists with provided username, true otherwise.
	 */
	public static boolean addUser(String username, String password) {
		if (isUserExist(username)) {
			System.out.println("The user with \"" + username + "\" is exist!");
			return false;
		} else {
			String salt = PasswordUtils.getSalt();
			String securePassword = PasswordUtils.generateSecurePassword(password, salt);
			User user = new UserBuilder(username, securePassword).setSalt(salt).build();
			users.add(user);
			UserFileHandler.saveUserList(users);
			return true;
		}
	}

	/**
	 * Remove user from the user list.
	 *
	 * @param username the username of the user
	 * @param password the password of the user
	 * @return false if user not exists with provided username, true otherwise.
	 */
	public static boolean removeUser(String username, String password) {
		if (!isUserExist(username)) {
			System.out.println("The user with \"" + username + "\" isn't exist!");
			return false;
		} else {
			Iterator<User> iterator = users.iterator();
			while (iterator.hasNext()) {
				User user = iterator.next();
				if (username.equalsIgnoreCase(user.getUsername())){
					String salt = user.getSalt();
					String securedPassword = PasswordUtils.generateSecurePassword(password, salt);
					if (securedPassword.equalsIgnoreCase(new String(user.getPassword()))){
						iterator.remove();
					}
				}
			}
			UserFileHandler.saveUserList(users);
			return true;
		}
	}

	/**
	 * Checks if user exist with provided username.
	 *
	 * @param username the username.
	 * @return true if user exist with provided username, false otherwise.
	 */
	private static boolean isUserExist(String username) {
		return users.stream().anyMatch(u -> u.getUsername().equalsIgnoreCase(username));
	}

	/**
	 * Checks if user has admin role.
	 *
	 * @param user the user is a possible admin.
	 * @return true if the provided user has admin role.
	 */
	public static boolean isAdmin(User user) {
		return user.getRole() == Role.ADMIN;
	}
}
