package com.revature.service;


import java.util.ArrayList;

import com.revature.dao.SuperHeroDao;
import com.revature.dao.SuperHeroDaoImpl;
import com.revature.model.Superhero;
import com.revature.util.DaoFactory;

public class SuperheroService {
    private SuperHeroDao superHeroDao;

    // pass in a particular implementation of the super hero dao:
    public SuperheroService(SuperHeroDao superHeroDao) {
        // do the creation of the dao:
        this.superHeroDao = superHeroDao;
    }

    public Superhero save(Superhero superhero) {
        // invoking the methods from the DAO:
        // we need an instance of the DAO implementation class:
        this.superHeroDao.save(superhero);
        return superhero;
    }
    
    public ArrayList<Superhero> getAll(){
    	return this.superHeroDao.getAll();
    }

    public Superhero getById(int id) {
    	return this.superHeroDao.getById(id);

    }
    
    public void updatePower(String power, int id) {
    	this.superHeroDao.updatePower(power, id);
    }

    public void deleteHero(int id) {
    	this.superHeroDao.deleteHero(id);
    }
    
    public ArrayList<Superhero> strengthOver(int strength){
    	return this.superHeroDao.strengthOver(strength);
    }
}
