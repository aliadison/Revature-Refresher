package org.example.data;

import java.util.ArrayList;
import java.util.List;

import org.example.model.Zoid;
import org.example.util.HibernateUtil;

public class ZoidDAO{

    private HibernateUtil hu;

    // CRUD operations using Save, Update, Delete
    public Zoid insert(Zoid zoid) {
        try {
            hu = new HibernateUtil();
            hu.beginTransaction();
            hu.getSession().save(zoid);
            hu.closeTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zoid;
    }
    
    public Zoid update(Zoid zoid) {
        try {
            hu = new HibernateUtil();
            hu.beginTransaction();
            hu.getSession().update(zoid);
            hu.closeTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zoid;
    }

	public List<Zoid> getAll() {
		try {
			hu = new HibernateUtil();
			hu.beginTransaction();
			List<Zoid> zoids = hu.getSession().createQuery("SELECT a FROM Zoid a", Zoid.class).getResultList();
			;
			hu.closeTransaction();
			return zoids;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return new ArrayList<>();
   }
	
	public Zoid getById(long id) {
		try {
			hu = new HibernateUtil();
			hu.beginTransaction();
			Zoid zoid = (Zoid) hu.getSession().get(Zoid.class, id);
			hu.closeTransaction();
			return zoid;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return null;
   }
	
	public void deleteById(long id) {
		try {
			hu = new HibernateUtil();
			hu.beginTransaction();
			Zoid zoid = (Zoid)  hu.getSession().load(Zoid.class, id);
			hu.getSession().delete(zoid);
			hu.closeTransaction();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
   }
    // Exercise, fill out the rest of the CRUD methods (update, getById, getAll, delete)
    // Also create a service and CommandLine/Servlet layer that lets us interact with the program and choose different operations

}
