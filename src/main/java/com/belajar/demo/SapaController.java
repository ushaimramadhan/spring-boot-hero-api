package com.belajar.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/heroes")
public class SapaController {
    
    @Autowired
    private HeroService heroService;

    @GetMapping
    public List<Hero> getAllHeroes() {
        return heroService.findAll();
    }

    @GetMapping("/{id}")
    public Hero getHeroById(@PathVariable Long id) {
        return heroService.findById(id);
    }

    @PostMapping
    public Hero createHero(@RequestBody @Valid HeroRequest request) {
        return heroService.createHero(request);
    }

    @PutMapping("/{id}") 
    public Hero updateHero(@PathVariable Long id, @RequestBody Hero hero) {
        return heroService.updateHero(id, hero);
    }

    @DeleteMapping("/{id}")
    public String deleteHero(@PathVariable Long id) {
        heroService.deleteHero(id);
        return "Hero berhasil dihapus (via Service).";
    }
}