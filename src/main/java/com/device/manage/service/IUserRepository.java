package com.device.manage.service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.device.manage.model.Device;
import com.device.manage.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

}
