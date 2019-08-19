package com.ljj.springdatajpa.dao;

import com.ljj.springdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2019/5/21 21:31
 * @Description:
 */
@Transactional
public interface UserJPA extends JpaRepository<User, Integer>, JpaSpecificationExecutor, Serializable {

    @Query(value = "select * from user where age > ?1", nativeQuery = true)
    public List<User> findByAge(int age);

    //@Modifying配合@Query注解一共使用，则可以完成数据的删除、添加、更新操作
    @Modifying
    @Query(value = "delete from user where id = ?1", nativeQuery = true)
    public void deleteUserOne(int id);
}
