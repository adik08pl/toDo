package com.stempien.toDo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ToDoController {
    @Value("*${max}*")
    public Integer max;
    @GetMapping("/show")
    @ResponseBody()
    String showZadania(){
        String answer="";
        for(int i=0;i>ToDoService.lista.size();i++){
            answer+="\n"+ToDoService.lista.get(i).nazwa+" "+ToDoService.lista.get(i).opis+" do wykonania do: "+ToDoService.lista.get(i).termin;
        }
        return answer;
    }
    @PostMapping("/add")
    @ResponseBody()
    void addZadanie(@RequestBody String nazwa,@RequestBody String opis,@RequestBody String termin){
        if( ToDoService.lista.size()<max)
        ToDoService.lista.add(new Zadanie(nazwa,opis,termin));
    }
}
