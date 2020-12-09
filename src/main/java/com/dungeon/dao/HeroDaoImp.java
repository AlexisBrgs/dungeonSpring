package com.dungeon.dao;

import com.dungeon.model.Hero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


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
    public Hero findById(int id) {
        for (Hero hero : heroes) {
            if (hero.getId() == id) {
                return hero;
            }
        }
        return null;
    }

    @Override
    public Hero save(Hero hero) {

        //creer condition try catch ou objet optionnel de hero

       Hero heroToUpdate = findById(hero.getId());
       if (heroToUpdate != null){
           heroes.set(heroes.indexOf(heroToUpdate),hero);
       }
        heroes.add(hero);
        return hero;
    }

    @Override
    public Boolean deleteById(int id) {
        Hero heroToDestroy = findById(id);
        if ( heroToDestroy != null) {
            heroes.remove( heroToDestroy);
            return true;
        }
        return false;
    }

}