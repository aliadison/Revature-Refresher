package com.revature.dao;

import java.util.ArrayList;

import com.revature.model.Superhero;

public class SuperHeroDaoDummyImpl implements SuperHeroDao {

    @Override
    public Superhero save(Superhero superhero) {
        // simulate the auto_increment with some arbitrary id value:
        superhero.setId(45);
        return superhero;
    }

	@Override
	public Superhero getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Superhero> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePower(String power, int id) {
		
	}

	@Override
	public void deleteHero(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Superhero> strengthOver(int strength) {
		// TODO Auto-generated method stub
		return null;
	}
}
