package com.revature.dao;

import java.util.ArrayList;

import com.revature.model.Superhero;

public interface SuperHeroDao {
    // CRUD:
    Superhero save(Superhero superhero);
    
    Superhero getById(int id);
    
    ArrayList<Superhero> getAll();
    
    void updatePower(String power, int id);
    
    void deleteHero(int id);
}
