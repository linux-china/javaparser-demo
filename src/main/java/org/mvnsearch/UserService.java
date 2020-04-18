package org.mvnsearch;

import org.jetbrains.annotations.Nullable;

/**
 * User Service
 *
 * @author linux_china
 */
public interface UserService {
    @Nullable
    User findUserById(Integer id);
}
