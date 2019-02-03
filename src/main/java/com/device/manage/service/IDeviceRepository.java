package com.device.manage.service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.device.manage.model.Device;

@Repository
public interface IDeviceRepository extends JpaRepository<Device, Integer>{

}
