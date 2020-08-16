package com.example.tbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tbd.model.Institucion;
import com.example.tbd.service.InstitucionService;

@Controller
public class InstitucionController {

    @Autowired
    private InstitucionService institucionService;

    @RequestMapping("/institucion")
    public String index(Model model) {
        model.addAttribute("list", institucionService.getAll());
        return "inst.index";
    }

    @GetMapping("/institucion/edit/{id}")
    public String showSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("institucion", institucionService.get(id));
        }else{
            model.addAttribute("institucion", new Institucion());
        }
        return "inst.save";
    }

    @PostMapping("/institucion/save")
    public String save(Institucion institucion, Model model) {
        institucionService.save(institucion);
        return "redirect:/institucion";
        
    }

    @GetMapping("/institucion/softdelete/{id}")
    public String deleteSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("institucion", institucionService.get(id));
        }else{
            model.addAttribute("institucion", new Institucion());
        }
        
        return "inst.softdelete";
    }
    
    @GetMapping("/institucion/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        institucionService.delete(id);
        return "redirect:/institucion";
    }
}