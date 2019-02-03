package com.device.manage.service;

import java.util.List;
import java.util.Map;
import com.device.manage.model.Device;
import com.device.manage.model.Protocol;
import com.device.manage.model.Tag;
import com.device.manage.model.User;

public interface DeviceService {
	public void savedevice(Device d);
	public List<Protocol> returnProtocols();
	public List<Tag> returnTags();
	public void saveUser(User u);
	public List<Device> returnDevices();
	public List<User> getAllUsers();
}
