package com.learn.spring.security.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource {

    private List<Todo> todosList;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public TodoResource() {
        todosList = new ArrayList<>(Arrays.asList(new Todo("sai", "Java"), new Todo("Pb", "Angular")));
        // todosList.addAll(Arrays.asList(new Todo("sai", "Java"), new Todo("Pb",
        // "Angular")));
        todosList.add(new Todo("manda", "support"));
    }

    @GetMapping("/todos")
    public List<Todo> retriveAllTodos() {
        return todosList;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        //hardCoding without the logic.
        return todosList.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("Create {} for {}", todo, username);
    }
}
 