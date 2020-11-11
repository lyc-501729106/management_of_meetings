package com.etc.managemeetings.mapper;

import com.etc.managemeetings.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Author 吕译辰
 * @Date 2020/11/10 - 16:29
 */
@Repository
public interface UserMapper {
    User login(User user);
}
