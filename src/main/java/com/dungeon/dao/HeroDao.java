package com.dungeon.dao;

import com.dungeon.model.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroDao {
    List<Hero> findAll();

    Optional<Hero> findById(int id);

    Hero save(Hero hero);

    Boolean deleteById(int id);
}