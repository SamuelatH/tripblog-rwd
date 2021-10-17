package com.java017.tripblog.repository;

import com.java017.tripblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YuCheng
 * @date 2021/9/27 - 上午 01:30
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByAccount(String account);

    User findByAccountAndPassword(String account, String password);

}
