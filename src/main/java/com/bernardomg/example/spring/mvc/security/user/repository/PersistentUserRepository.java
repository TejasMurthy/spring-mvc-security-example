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

package com.bernardomg.example.spring.mvc.security.user.repository;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bernardomg.example.spring.mvc.security.user.model.persistence.PersistentUser;

/**
 * Repository for users.
 * 
 * 
 *
 */
public interface PersistentUserRepository
        extends JpaRepository<PersistentUser, Long> {

    /**
     * Returns the user details for the received email.
     * 
     * @param email
     *            email to search for
     * @return the user details for the received email
     */
    public Optional<PersistentUser> findOneByEmail(final String email);

    /**
     * Returns the user details for the received username.
     * 
     * @param username
     *            username to search for
     * @return the user details for the received username
     */
    public Optional<PersistentUser> findOneByUsername(final String username);

    @Override
    @CacheEvict(cacheNames = { "user", "users", "roles" }, allEntries = true)
    public <S extends PersistentUser> S save(S entity);

}
