package com.dungeon.dao;

import com.dungeon.model.Hero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class HeroDaoImp implements HeroDao {

    public static List<Hero> heroes = new ArrayList<>();

    static {
        heroes.add(new Hero(1, "Toto", "Warrior"));
        heroes.add(new Hero(2, "Tata", "Mage"));
        heroes.add(new Hero(3, "Titi", "Enculay de voleur"));
    }

    @Override
    public List<Hero> findAll() {
        return heroes;
    }

    @Override
    public Optional<Hero> findById(int id) {
        Optional<Hero> heroOptional = Optional.empty();
        for (Hero hero : heroes) {
            if (hero.getId() == id) {
                heroOptional = Optional.of(hero);
            }
        }
        return heroOptional;
    }

    @Override
    public Hero save(Hero hero) {
        Optional<Hero> heroToUpdate = findById(hero.getId());
        heroToUpdate.ifPresent(value -> heroes.set(heroes.indexOf(value), hero));
        heroes.add(hero);
        return hero;
    }

    @Override
    public Boolean deleteById(int id) {
        Optional<Hero> heroToDestroy = findById(id);

        if (heroToDestroy.isPresent()) {
            heroes.remove(heroToDestroy.get());
            return true;
        }
        return false;
    }
}