package com.stempien.toDo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class ToDoController {
    private final ToDoService toDoService;

    ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/show")
    @ResponseBody()
    String showTasks(){
        return toDoService.getTasks();
    }

    @PostMapping("/add")
    @ResponseBody()
    void addTask(@RequestBody NewTask newTask){
        toDoService.addTask(newTask.getName(), newTask.getDescription(), newTask.getDeadline());
    }

    @GetMapping("/show")
    @ResponseBody()
    String getOneTasks(@RequestParam int id){
        return toDoService.getOne(id);
    }
}
