package com.example.tbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tbd.model.Requisitoeme;
import com.example.tbd.service.RequisitoemeService;

@Controller
public class RequisitoemeController {

    @Autowired
    private RequisitoemeService requisitoemeService;

    @RequestMapping("/requisitoeme")
    public String index(Model model) {
        model.addAttribute("list", requisitoemeService.getAll());
        return "req-eme.index";
    }

    @GetMapping("/requisitoeme/edit/{id}")
    public String showSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("requisitoeme", requisitoemeService.get(id));
        }else{
            model.addAttribute("requisitoeme", new Requisitoeme());
        }
        return "req-eme.save";
    }

    @PostMapping("/requisitoeme/save")
    public String save(Requisitoeme requisitoeme, Model model) {
        requisitoemeService.save(requisitoeme);
        return "redirect:/requisitoeme";
        
    }

    @GetMapping("/requisitoeme/softdelete/{id}")
    public String deleteSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("requisitoeme", requisitoemeService.get(id));
        }else{
            model.addAttribute("requisitoeme", new Requisitoeme());
        }
        
        return "req-eme.softdelete";
    }
    
    @GetMapping("/requisitoeme/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        requisitoemeService.delete(id);
        return "redirect:/requisitoeme";
    }
}