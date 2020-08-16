package com.example.tbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tbd.model.Coordinador;
import com.example.tbd.service.CoordinadorService;

@Controller
public class CoordinadorController {

    @Autowired
    private CoordinadorService coordinadorService;

    @RequestMapping("/coordinador")
    public String index(Model model) {
        model.addAttribute("list", coordinadorService.getAll());
        return "coord.index";
    }

    @GetMapping("/coordinador/edit/{id}")
    public String showSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("coordinador", coordinadorService.get(id));
        }else{
            model.addAttribute("coordinador", new Coordinador());
        }
        return "coord.save";
    }

    @PostMapping("/coordinador/save")
    public String save(Coordinador coordinador, Model model) {
        coordinadorService.save(coordinador);
        return "redirect:/coordinador";
        
    }

    @GetMapping("/coordinador/softdelete/{id}")
    public String deleteSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("coordinador", coordinadorService.get(id));
        }else{
            model.addAttribute("coordinador", new Coordinador());
        }
        
        return "coord.softdelete";
    }
    
    @GetMapping("/coordinador/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        coordinadorService.delete(id);
        return "redirect:/coordinador";
    }
}