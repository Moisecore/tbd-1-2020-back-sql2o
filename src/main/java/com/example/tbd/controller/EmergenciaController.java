package com.example.tbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tbd.model.Emergencia;
import com.example.tbd.service.EmergenciaService;

@Controller
public class EmergenciaController {

    @Autowired
    private EmergenciaService emergenciaService;

    @RequestMapping("/emergencia")
    public String indexg(Model model) {
        model.addAttribute("list", emergenciaService.getAll());
        return "emer.index";
    }

    @GetMapping("/emergencia/edit/{id}")
    public String showSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("emergencia", emergenciaService.get(id));
        }else{
            model.addAttribute("emergencia", new Emergencia());
        }
        return "emer.save";
    }

    @PostMapping("/emergencia/save")
    public String saveg(Emergencia emergencia, Model model) {
        emergenciaService.save(emergencia);
        return "redirect:/emergencia";
        
    }

    @GetMapping("/emergencia/softdelete/{id}")
    public String deleteSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("emergencia", emergenciaService.get(id));
        }else{
            model.addAttribute("emergencia", new Emergencia());
        }
        
        return "emer.softdelete";
    }
    
    @GetMapping("/emergencia/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        emergenciaService.delete(id);
        return "redirect:/emergencia";
    }
}