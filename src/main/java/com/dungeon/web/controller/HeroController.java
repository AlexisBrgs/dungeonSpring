package com.dungeon.web.controller;

import com.dungeon.dao.HeroDao;
import com.dungeon.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HeroController {

    @Autowired
    private HeroDao heroDao;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Hero> listOfHeroes() {
        return heroDao.findAll();
    }


    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Optional<Hero>> getHero(@PathVariable int id) {
        ResponseEntity<Optional<Hero>>res;
        Optional<Hero> hero = heroDao.findById(id);
        if (hero.isEmpty()) {
            res = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            res = new ResponseEntity<>(hero, HttpStatus.OK);
        }
        return res;
    }


    @PostMapping(value = "/list")
    public void addHero(@RequestBody Hero hero) {
        heroDao.save(hero);
    }

    @DeleteMapping(value = "/list/{id}")
    private void deleteHero(@PathVariable int id) {
        heroDao.deleteById(id);
    }

    @PatchMapping(value = "list/{id}")
    public void updateHero(@RequestBody Hero hero) {

        heroDao.save(hero);
    }
}



