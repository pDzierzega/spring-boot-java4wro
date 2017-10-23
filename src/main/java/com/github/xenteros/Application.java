package com.github.xenteros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(method = RequestMethod.GET,
                    value = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-name/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello-param")
    public String helloParam(@RequestParam(name = "name", required = false) String name) {
        return "Hello " + name + " via param";
    }

    @PostMapping("/hello-body")
    public String helloBody(@RequestBody String name) {
        return "Hello " + name;
    }
}
