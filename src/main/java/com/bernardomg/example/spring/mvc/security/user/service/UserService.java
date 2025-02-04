/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2017-2020 the original author or authors.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.bernardomg.example.spring.mvc.security.user.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

import com.bernardomg.example.spring.mvc.security.user.model.Role;
import com.bernardomg.example.spring.mvc.security.user.model.User;
import com.bernardomg.example.spring.mvc.security.user.model.form.UserForm;
import com.bernardomg.example.spring.mvc.security.user.model.form.UserRolesForm;

/**
 * Service for handling user data.
 * 
 * 
 *
 */
@Transactional
public interface UserService {

    /**
     * Persists the received user. If it already exists then the user is
     * invalid.
     * 
     * @param user
     *            user to create
     */
    @PreAuthorize("hasAuthority('CREATE_USER')")
    public void create(final UserForm user);

    /**
     * Returns all the roles in the application.
     * 
     * @return all the roles
     */
    @PreAuthorize("hasAuthority('READ_USER')")
    public Iterable<? extends Role> getAllRoles();

    /**
     * Returns all the users in the application.
     * 
     * @return all the users
     */
    @PreAuthorize("hasAuthority('READ_USER')")
    public Iterable<? extends User> getAllUsers();

    /**
     * Returns the user with the received username.
     * 
     * @param username
     *            username of the user to search
     * @return user for the received username
     */
    @PreAuthorize("hasAuthority('READ_USER')")
    public User getUser(final String username);

    /**
     * Updates the received user. The user is only valid if it doesn't exist
     * already.
     * 
     * @param user
     *            user to update
     */
    @PreAuthorize("hasAuthority('UPDATE_USER')")
    public void update(final UserForm user);

    /**
     * Updates the roles for the received user.
     * 
     * @param userRoles
     *            user and roles to update
     */
    @PreAuthorize("hasAuthority('UPDATE_USER')")
    public void updateRoles(final UserRolesForm userRoles);

}
