package com.gherlan.petclinic.controllers;

import com.gherlan.petclinic.model.Vet;
import com.gherlan.petclinic.services.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequiredArgsConstructor
@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    @GetMapping({"/", "/index", "/index.html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

    @GetMapping("/api/v1/vets")
    public ResponseEntity<Set<Vet>> getVets() {
        return ResponseEntity.ok(vetService.findAll());
    }
}
