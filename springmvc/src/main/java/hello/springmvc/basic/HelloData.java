package hello.springmvc.basic;

import lombok.Data;

import java.util.List;

@Data
public class HelloData {

    private String username;
    private int age;

    private String[] arr;
    private List<String> arrList;
}
