package com.example.demo2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
//不序列化的话，直接传入对象会报错
public class User implements Serializable {
    private String name;
    private int age;
}
