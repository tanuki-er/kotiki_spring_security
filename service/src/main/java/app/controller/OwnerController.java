package app.controller;

import app.entity.OwnerEntity;
import app.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    public OwnerController() {

    }

    @PostMapping
    public OwnerEntity saveOwner(@RequestBody OwnerEntity owner) {
        ownerService.saveOwner(owner);
        return owner;
    }

    @DeleteMapping
    public String deleteOwner(@RequestParam String name) {
        ownerService.deleteOwner(name);
        return "Deleted";
    }

    @GetMapping
    public OwnerEntity findByName(@RequestParam String name) {
        return ownerService.findByName(name);
    }

    @GetMapping("/all")
    public List<OwnerEntity> getOwners() {
        return ownerService.getAllOwners();
    }
}