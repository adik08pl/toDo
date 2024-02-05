package com.stempien.toDo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
class ToDoService {
    @Value("${max}")
    private Integer max;


    private final TaskRepository taskRepository;

    ToDoService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    String getTasks() {

        List<Tasks> answer = (List<Tasks>) taskRepository.findAll();

       return answer.stream()
                .map(elem -> String.format("%s %s do wykonania do %s", elem.name, elem.description, elem.deadline))
                .collect(Collectors.joining("<br>"));
    }

    void addTask(String nazwa, String opis, LocalDate termin) {
        if (taskRepository.count() > max)
            throw new ArrayIndexOutOfBoundsException("przekroczono max");

        Tasks task = new Tasks(nazwa, opis, termin);
        taskRepository.save(task);
    }
}
