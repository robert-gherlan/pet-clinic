package com.gherlan.petclinic.controllers;

import com.gherlan.petclinic.model.Owner;
import com.gherlan.petclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @InitBinder
    void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/{ownerId}")
    public String getOwnerById(@PathVariable Long ownerId, Model model) {
        model.addAttribute("owner", ownerService.findById(ownerId));
        return "owners/owner";
    }

    @GetMapping({"/find"})
    public String findOwners(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @PostMapping({"/"})
    public String findOwners(Owner owner, BindingResult bindingResult, Model model) {
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        Collection<Owner> owners = ownerService.findByLastName(owner.getLastName());
        if (owners.isEmpty()) {
            bindingResult.rejectValue("lastName", "Not found");
            return "owners/findOwners";
        } else if (owners.size() == 1) {
            return "redirect:/owners/" + owners.iterator().next().getId();
        } else {
            model.addAttribute("owners", owners);
            return "owners/index";
        }
    }
}
