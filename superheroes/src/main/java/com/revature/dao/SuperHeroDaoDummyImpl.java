package com.revature.dao;

import com.revature.model.Superhero;

public class SuperHeroDaoDummyImpl implements SuperHeroDao {

    @Override
    public Superhero save(Superhero superhero) {
        // simulate the auto_increment with some arbitrary id value:
        superhero.setId(45);
        return superhero;
    }
}
