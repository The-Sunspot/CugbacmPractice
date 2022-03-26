package com.example.cugbacmpractice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class DataserviceTest {

    @Autowired
    Dataservice dataservice;
    //@Test
    void insertCfData() {
        dataservice.insertCfData("1004196120");
    }

    //@Test
    void insertVjData() {
        dataservice.insertVjData("1004196120");
    }
}