package com.project.chatconnect.applications.services.users;

/**
 * The interface User service.
 * Auhtor: Huy Dang
 */
public interface IUserService {

    /**
     * Login string.
     *
     * @param userName the username
     * @param password the password
     * @return the string
     */
    String login(String userName, String password);

}
