package com.mozanta.taskmanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api")
@CrossOrigin
public class Controller {

    @Autowired
    private Repository Repository;

    @GetMapping("/")
    public List<Tasks> GetTasks() {
        return Repository.findAll();
    }
    @GetMapping("/{id}")
    public Tasks GetTasks(@PathVariable String id) {
        return Repository.findById(id).orElse(null);
    }
    @PostMapping("/")
    public Tasks postMethodName(@RequestBody Tasks tasks) {
    
        
        return Repository.save(tasks);
    }
 
    @PutMapping("/")
    public Tasks PutMapping(@RequestBody Tasks newTasks) {
    
        
        Tasks oldTasks = Repository.findById(newTasks.getId()).orElse(null);
        oldTasks.setTasks(newTasks.getTasks());
        Repository.save(oldTasks);
      
        return oldTasks;
    }

    @DeleteMapping("/{id}")
    public String DeleteTask(@PathVariable String id) {
        Repository.deleteById(id);
        return id;
        
    }


}