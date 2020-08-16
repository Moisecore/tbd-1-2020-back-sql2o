package com.example.tbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tbd.model.Requisito;
import com.example.tbd.service.RequisitoService;

@Controller
public class RequisitoController {

    @Autowired
    private RequisitoService requisitoService;

    @RequestMapping("/requisito")
    public String index(Model model) {
        model.addAttribute("list", requisitoService.getAll());
        return "req.index";
    }

    @GetMapping("/requisito/edit/{id}")
    public String showSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("requisito", requisitoService.get(id));
        }else{
            model.addAttribute("requisito", new Requisito());
        }
        return "req.save";
    }

    @PostMapping("/requisito/save")
    public String save(Requisito requisito, Model model) {
        requisitoService.save(requisito);
        return "redirect:/requisito";
        
    }

    @GetMapping("/requisito/softdelete/{id}")
    public String deleteSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("requisito", requisitoService.get(id));
        }else{
            model.addAttribute("requisito", new Requisito());
        }
        
        return "req.softdelete";
    }
    
    @GetMapping("/requisito/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        requisitoService.delete(id);
        return "redirect:/requisito";
    }
}