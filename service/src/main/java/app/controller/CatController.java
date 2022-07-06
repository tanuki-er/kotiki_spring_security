package app.controller;

import app.entity.CatEntity;
import app.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {
    @Autowired
    private CatService catService;

    public CatController() {

    }

    @GetMapping("/all")
    public List<CatEntity> getAllCats() {
        return catService.getAllCats();
    }

    @GetMapping()
    public CatEntity findByName(@RequestParam String name) {
        return catService.findByName(name);
    }

    @PostMapping
    public CatEntity saveCat(@RequestBody CatEntity cat) {
        catService.saveCat(cat);
        return cat;
    }

    @DeleteMapping
    public String deleteCat(@RequestParam String name) {
        catService.deleteCat(name);
        return "deleted";
    }

}
