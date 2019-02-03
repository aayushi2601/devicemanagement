package com.device.manage.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.device.manage.model.Device;
import com.device.manage.model.Protocol;
import com.device.manage.model.Tag;
import com.device.manage.model.Tag.IsActive;
import com.device.manage.model.User;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService{
	
	@Autowired
	IDeviceRepository repo;
	
	@Autowired
	IProtocolRepository repo1;
	
	@Autowired
	ITagRepository repo2;
	
	@Autowired
	IUserRepository repo3;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void savedevice(Device d)
	{
		for(Protocol p: d.getDevice_protocols())
		{
			jdbcTemplate.update(
	                "update protocol set is_taken = ? where protocol_id = ?", 1, p.getProtocol_id());
		}	
		repo.save(d);
	}
	
	@Override
	public List<Protocol> returnProtocols()
	{
			final String sql = "select * from protocol where is_taken = 0 && effectivity_date <= ?";
			final List<Protocol> prots = new ArrayList<Protocol>();
			final List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,new Date());

			for (Map<String, Object> row : rows) {
				Protocol p = new Protocol();
				p.setProtocol_id((Integer) row.get("protocol_id"));
				p.setTitle((String) row.get("title"));
				p.setCreated_on((Date) row.get("created_on"));
				p.setEffectivity_date((Date) row.get("effectivity_date"));
				prots.add(p);
		}
			return prots;
	}
	
	@Override
	public List<Tag> returnTags()
	{
		final String sql = "select * from tag where taken = 0";
		final List<Tag> ts = new ArrayList<Tag>();
		final List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> row : rows) {
			Tag p = new Tag();
			p.setTag_id((Integer) row.get("tag_id"));
			p.setDescription((String) row.get("description"));
			p.setCreated_on((Date) row.get("created_on"));
			p.setIs_active(IsActive.values()[(Integer)row.get("is_active")]);
			ts.add(p);
	}
		return ts;
	}
	
	@Override
	public void saveUser(User u)
	{
		jdbcTemplate.update(
                "update tag set taken = ? where tag_id = ?", 1, u.getTag_id());
		repo3.save(u);
	}

	@Override
	public List<Device> returnDevices() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repo3.findAll();
	}
}
