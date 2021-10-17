package com.java017.tripblog.repository;

import com.java017.tripblog.entity.InitializationVector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YuCheng
 * @date 2021/9/27 - 上午 01:31
 */

@Repository
public interface InitializationVectorRepository extends JpaRepository<InitializationVector, Long> {
}
