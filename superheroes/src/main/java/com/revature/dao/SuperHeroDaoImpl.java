package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.Superhero;
import com.revature.util.ConnectionFactory;

public class SuperHeroDaoImpl implements SuperHeroDao{

    Connection connection;

    public SuperHeroDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public Superhero save(Superhero superhero) {
        // Use prepared statement to prevent SQL injection
        String sql = "insert into superhero values(default, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, superhero.getSuperhero_name());
            preparedStatement.setString(2, superhero.getSuper_power());
            preparedStatement.setInt(3, superhero.getStrength());
            preparedStatement.setString(4, superhero.getWeakness());
            preparedStatement.setString(5, superhero.getFranchise());
            preparedStatement.setString(6, superhero.getWorld());

            // this will actually execute the statement
            int count = preparedStatement.executeUpdate();

            // if count is 1, that means success, we've updated the table:
            if(count == 1) {
                return superhero;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public Superhero getById(int id) {
		String sql = "select * from superhero where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet set = preparedStatement.executeQuery();
            if(set.next()) {
            	int newid = set.getInt(1);
            	String name = set.getString(2);
            	String power = set.getString(3);
            	int strength = set.getInt(4);
            	String weakness = set.getString(5);
            	String franchise = set.getString(6);
            	String world = set.getString(7);
            	
               	Superhero superhero = new Superhero(newid,name,power,strength,weakness,franchise,world);
                return superhero;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public ArrayList<Superhero> getAll() {
		String sql = "select * from superhero;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet set = preparedStatement.executeQuery();
            
            ArrayList<Superhero> superheroes = new ArrayList<Superhero>();
            while(set.next()) {
            	int id = set.getInt(1);
            	String name = set.getString(2);
            	String power = set.getString(3);
            	int strength = set.getInt(4);
            	String weakness = set.getString(5);
            	String franchise = set.getString(6);
            	String world = set.getString(7);
            	
               	Superhero superhero = new Superhero(id,name,power,strength,weakness,franchise,world);
                superheroes.add(superhero);
            }
            return superheroes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public void updatePower(String power, int id) {
		String sql = "update superhero set super_power = ? where id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, power);
			preparedStatement.setInt(2, id);

	        preparedStatement.execute();
	        
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteHero(int id) {
		String sql = "delete from superhero where id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

	        preparedStatement.execute();
	        
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    
    
    // Exercise: Fill out 4 other CRUD methods (GetById, GetAll, Update, Delete)
    // Make some more fun queries like get by power, strength, etc.
    // Alter the save method so that it retrieves the id from the database and store it in the superhero object that you return (Recommend doing online research)
}
