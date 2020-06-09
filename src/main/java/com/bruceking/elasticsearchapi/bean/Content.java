package com.bruceking.elasticsearchapi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private String title;
    private String img;
    private float price;
}
