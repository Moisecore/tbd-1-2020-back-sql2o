package com.example.tbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tbd.model.Volureq;
import com.example.tbd.service.VolureqService;

@Controller
public class VolureqController {

    @Autowired
    private VolureqService volureqService;

    @RequestMapping("/volureq")
    public String index(Model model) {
        model.addAttribute("list", volureqService.getAll());
        return "volu-req.index";
    }

    @GetMapping("/volureq/edit/{id}")
    public String showSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("volureq", volureqService.get(id));
        }else{
            model.addAttribute("volureq", new Volureq());
        }
        return "volu-req.save";
    }

    @PostMapping("/volureq/save")
    public String save(Volureq volureq, Model model) {
        volureqService.save(volureq);
        return "redirect:/volureq";
        
    }

    @GetMapping("/volureq/softdelete/{id}")
    public String deleteSave(@PathVariable("id") Long id, Model model){
        if (id != null && id != 0) {
            model.addAttribute("volureq", volureqService.get(id));
        }else{
            model.addAttribute("volureq", new Volureq());
        }
        
        return "volu-req.softdelete";
    }
    
    @GetMapping("/volureq/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        volureqService.delete(id);
        return "redirect:/volureq";
    }
}