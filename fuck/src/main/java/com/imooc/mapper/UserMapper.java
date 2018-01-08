package com.imooc.mapper;

import java.util.List;

import com.imooc.dto.User;

public interface UserMapper {
	
	List <User> getAll();
    public User getOne(int id);
    public void insert (User user);
    public void delete (int id);
    public User getUserbyName(String name);
    
}
