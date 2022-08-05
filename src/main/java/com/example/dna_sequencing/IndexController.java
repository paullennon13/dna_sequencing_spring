package com.example.dna_sequencing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sequencing.*;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(Model model){

        model.addAttribute("DNASequence", "Empty");
        model.addAttribute("DNAToMatch", "Empty");
        return "index";
    }

    @PostMapping
    public String postIndex(Model model, @RequestParam(name = "DNASequence") String DNASequence, @RequestParam(name = "DNAToMatch") String DNAToMatch){

        Sequencer s = new Sequencer(DNASequence, DNAToMatch);
        String topMatches = s.toString();

        model.addAttribute("DNASequence", DNASequence);
        model.addAttribute("DNAToMatch", DNAToMatch);
        model.addAttribute("topMatches", topMatches);
        return "index";
    }

}
