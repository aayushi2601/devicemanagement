package com.device.manage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.device.manage.model.Device;
import com.device.manage.model.User;
import com.device.manage.service.DeviceService;

@Controller
public class WebController {
	
	@Autowired
	DeviceService ser;
	
	@RequestMapping(value="/device/add", method = RequestMethod.GET)
    public String deviceGet(Model model){
		model.addAttribute("device",new Device());
		model.addAttribute("protocols",ser.returnProtocols());
		model.addAttribute("device_users",ser.getAllUsers());
        return "adddevice";
    }
	@RequestMapping(value="/device/add", method = RequestMethod.POST)
    public String devicePost(@ModelAttribute @Valid Device d, BindingResult result){
		ser.savedevice(d);
		return "index";
    }
	@RequestMapping(value="/user/add", method = RequestMethod.GET)
    public String userGet(Model model){
		model.addAttribute("user",new User());
		model.addAttribute("tags",ser.returnTags());
		model.addAttribute("user_devices",ser.returnDevices());
        return "adduser";
    }
	@RequestMapping(value="/user/add", method = RequestMethod.POST)
    public String userPost(@ModelAttribute User u){
		ser.saveUser(u);
		return "index";
    }

}
