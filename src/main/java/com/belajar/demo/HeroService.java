package com.belajar.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public Hero createHero(HeroRequest request) {

        Hero heroBaru = new Hero();
        heroBaru.setName(request.getName());
        heroBaru.setLevel(request.getLevel()); 

        if (heroBaru.getLevel() > 50) {
            heroBaru.setRole("Sepuh");
        } else {
            heroBaru.setRole("Pemula");
        }

        return heroRepository.save(heroBaru);
    }

    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    public Hero findById(Long id) {
        return heroRepository.findById(id).orElse(null);
    }

    public Hero updateHero(Long id, Hero heroBaru) {
        Hero heroLama = heroRepository.findById(id).orElse(null);
        if (heroLama != null) {
            heroLama.setName(heroBaru.getName());
            heroLama.setLevel(heroBaru.getLevel());

            if (heroBaru.getLevel() > 50) {
                heroLama.setRole("Sepuh");
            } else {
                heroLama.setRole("Pemula");
            }
            return heroRepository.save(heroLama);
        }
        return null;
    }

    public void deleteHero(Long id) {
        heroRepository.deleteById(id);
    }
}
