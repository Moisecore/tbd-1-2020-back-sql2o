package com.example.tbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tbd.model.Voluntario;
import com.example.tbd.service.VoluntarioService;

@Controller
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    @RequestMapping("/voluntario")
    public String index(Model model) {
        model.addAttribute("list", voluntarioService.getAll());
        return "volu.index";
    }

    @GetMapping("/voluntario/edit/{id}")
    public String showSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("voluntario", voluntarioService.get(id));
        }else{
            model.addAttribute("voluntario", new Voluntario());
        }
        return "volu.save";
    }

    @PostMapping("/voluntario/save")
    public String save(Voluntario voluntario, Model model) {
        voluntarioService.save(voluntario);
        return "redirect:/voluntario";
        
    }

    @GetMapping("/voluntario/softdelete/{id}")
    public String deleteSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("voluntario", voluntarioService.get(id));
        }else{
            model.addAttribute("voluntario", new Voluntario());
        }
        
        return "volu.softdelete";
    }
    
    @GetMapping("/voluntario/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        voluntarioService.delete(id);
        return "redirect:/voluntario";
    }
}