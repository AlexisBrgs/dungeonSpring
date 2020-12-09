package com.dungeon.dao;

import com.dungeon.model.Hero;
import java.util.List;

public interface HeroDao {
    public List<Hero>findAll();
    public Hero findById(int id);
    public Hero save(Hero hero);
    public Boolean deleteById(int id);
}