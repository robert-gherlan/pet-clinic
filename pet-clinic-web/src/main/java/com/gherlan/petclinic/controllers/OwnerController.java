package com.gherlan.petclinic.controllers;

import com.gherlan.petclinic.model.Owner;
import com.gherlan.petclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping({"/"})
    public String findOwners(Owner owner, BindingResult bindingResult, Model model) {
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        Collection<Owner> owners = ownerService.findByLastNameContaining(owner.getLastName());
        if (owners.isEmpty()) {
            bindingResult.rejectValue("lastName", "owners.not_found", "No owners were found.");
            return "owners/findOwners";
        } else if (owners.size() == 1) {
            return "redirect:/owners/" + owners.iterator().next().getId();
        } else {
            model.addAttribute("owners", owners);
            return "owners/index";
        }
    }

    @GetMapping({"/new"})
    public String newOwner(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/createOrUpdateOwner";
    }

    @PostMapping("/new")
    public String processCreationForm(@Validated Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return "owners/createOrUpdateOwner";
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
        Owner owner = ownerService.findById(ownerId);
        model.addAttribute("owner", owner);
        return "owners/createOrUpdateOwner";
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Validated Owner owner, BindingResult result, @PathVariable Long ownerId) {
        if (result.hasErrors()) {
            return "owners/createOrUpdateOwner";
        } else {
            owner.setId(ownerId);
            ownerService.save(owner);
            return "redirect:/owners/" + ownerId;
        }
    }
}
