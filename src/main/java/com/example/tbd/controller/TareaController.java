package com.example.tbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tbd.model.Tarea;
import com.example.tbd.service.TareaService;

@Controller
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @RequestMapping("/tarea")
    public String index(Model model) {
        model.addAttribute("list", tareaService.getAll());
        return "tarea.index";
    }

    @RequestMapping("/tarea/emergencia/{emer}")
    public String emergency(@PathVariable("emer") Long emer, Model model) {
        model.addAttribute("list", tareaService.getAll());
        return "query1";
    }

    @GetMapping("/tarea/edit/{id}")
    public String showSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("tarea", tareaService.get(id));
        }else{
            model.addAttribute("tarea", new Tarea());
        }
        return "tarea.save";
    }

    @PostMapping("/tarea/save")
    public String save(Tarea tarea, Model model) {
        tareaService.save(tarea);
        return "redirect:/tarea";
        
    }

    @GetMapping("/tarea/softdelete/{id}")
    public String deleteSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("tarea", tareaService.get(id));
        }else{
            model.addAttribute("tarea", new Tarea());
        }
        
        return "tarea.softdelete";
    }
    
    @GetMapping("/tarea/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        tareaService.delete(id);
        return "redirect:/tarea";
    }
}