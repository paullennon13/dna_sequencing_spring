package com.example.dna_sequencing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sequencing.Sequencer;
import java.util.List;

@Controller
@RequestMapping("/matches")
public class MatchesController {

    @PostMapping
    public String matches(Model model, String DNASequence, String DNAToMatch){

        Sequencer s = new Sequencer(DNASequence, DNAToMatch);
        List<String> topMatches = s.toList();

        model.addAttribute("DNASequence", DNASequence);
        model.addAttribute("DNAToMatch", DNAToMatch);
        model.addAttribute("topMatches", topMatches);

        return "matches";
    }
}
