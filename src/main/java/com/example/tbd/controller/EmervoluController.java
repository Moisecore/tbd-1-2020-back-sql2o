package com.example.tbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tbd.model.Emervolu;
import com.example.tbd.service.EmervoluService;

@Controller
public class EmervoluController {

    @Autowired
    private EmervoluService emervoluService;

    @RequestMapping("/emervolu")
    public String index(Model model) {
        model.addAttribute("list", emervoluService.getAll());
        return "emer-volu.index";
    }

    @GetMapping("/emervolu/edit/{id}")
    public String showSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("emervolu", emervoluService.get(id));
        }else{
            model.addAttribute("emervolu", new Emervolu());
        }
        return "emer-volu.save";
    }

    @PostMapping("/emervolu/save")
    public String save(Emervolu emervolu, Model model) {
        emervoluService.save(emervolu);
        return "redirect:/emervolu";
        
    }

    @GetMapping("/emervolu/softdelete/{id}")
    public String deleteSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("emervolu", emervoluService.get(id));
        }else{
            model.addAttribute("emervolu", new Emervolu());
        }
        
        return "emer-volu.softdelete";
    }
    
    @GetMapping("/emervolu/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        emervoluService.delete(id);
        return "redirect:/emervolu";
    }
}