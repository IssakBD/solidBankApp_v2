package com.example.solidbankapp.dao;

import com.example.solidbankapp.entity.UserEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByLogin(String login);

    @Modifying
    @Query("insert into user_entity (login, password, role)  values(:login, :password, :role )")
    void insertUser(String login, String password, String role);

    Optional<UserEntity> findUserEntityByLogin(String login);
}