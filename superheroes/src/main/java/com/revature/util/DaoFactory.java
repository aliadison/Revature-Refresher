package com.revature.util;


import com.revature.dao.SuperHeroDao;
import com.revature.dao.SuperHeroDaoDummyImpl;
import com.revature.dao.SuperHeroDaoImpl;

public class DaoFactory {
    
    private static SuperHeroDao superHeroDao = null;
    private static SuperHeroDao superHeroDaoDummy = null;

    
    public static SuperHeroDao getSuperHeroDao() {
        if(superHeroDao == null) {
            superHeroDao = new SuperHeroDaoImpl();
        }
        return superHeroDao;
    }

    public static SuperHeroDao getSuperHeroDaoDummy() {
        if(superHeroDaoDummy == null) {
            superHeroDaoDummy = new SuperHeroDaoDummyImpl();
        }
        return superHeroDaoDummy;
    }

}
