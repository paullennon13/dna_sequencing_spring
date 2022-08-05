package com.example.dna_sequencing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sequencing.Sequencer;

@Controller
@RequestMapping("/matches")
public class MatchesController {

    @PostMapping
    public String matches(Model model, @RequestParam(name = "DNASequence") String DNASequence, @RequestParam(name = "DNAToMatch") String DNAToMatch){

        Sequencer s = new Sequencer(DNASequence, DNAToMatch);
        String topMatches = s.toString();

        model.addAttribute("DNASequence", DNASequence);
        model.addAttribute("DNAToMatch", DNAToMatch);
        model.addAttribute("topMatches", topMatches);

        return "matches";
    }
}
