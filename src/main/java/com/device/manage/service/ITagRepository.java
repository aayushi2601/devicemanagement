package com.device.manage.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.device.manage.model.Tag;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Integer>{

}
