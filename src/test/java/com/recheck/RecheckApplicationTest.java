package com.recheck;

import com.recheck.entity.People;
import com.recheck.service.PeopleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecheckApplicationTest {

    @Autowired
    private PeopleService peopleService;

    @Test
    public void People(){
        peopleService.addPeople(new People(null ,"wangwu","wangwu"));
    }
}
