package com.example.cugbacmpractice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class CfData {
    private int id;
    private String sid;
    private String profileName;
    private int rank;
    private int allSolved;
    private int monthSolved;
    private Timestamp recordDate;
}
