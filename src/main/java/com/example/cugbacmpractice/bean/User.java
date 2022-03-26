package com.example.cugbacmpractice.bean;


//import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    //@NotNull
    private String studentId;
    //@NotNull
    private String name;
    //@NotNull
    private String password;
    //@NotNull
    private int grade;
    private String cfProfileName;
    private String vjProfileName;
    private boolean isActive;

}
