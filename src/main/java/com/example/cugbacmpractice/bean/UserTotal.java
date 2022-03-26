package com.example.cugbacmpractice.bean;

//import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class UserTotal {
    @Autowired
    public User user;
    @Autowired
    public VjData vjData;
    @Autowired
    public CfData cfData;

}
