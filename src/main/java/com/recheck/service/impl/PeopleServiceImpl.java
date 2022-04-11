package com.recheck.service.impl;

import com.recheck.entity.People;
import com.recheck.mapper.PeopleMapper;
import com.recheck.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    public PeopleMapper peopleMapper;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public void addPeople(People people) {
        String password = people.getPassword();
        String encode = passwordEncoder.encode(password);
        people.setPassword(encode);
        peopleMapper.addPeople(people);
    }
}
