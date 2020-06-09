package com.bruceking.elasticsearchapi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int age;
}
