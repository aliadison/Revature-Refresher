package org.example;

import org.example.data.ZoidDAO;
import org.example.model.Zoid;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Zoid zoid = new Zoid("T-rex", "Dino", "Gray", 40.5, 20);
        ZoidDAO zoidDAO = new ZoidDAO();
        
//        zoidDAO.insert(zoid);
//         check if the id was generated
//        System.out.println(zoid);
        
//			get all zoids
//        System.out.println(zoidDAO.getAll());
//        
        
//			get zoid by id
//        System.out.println(zoidDAO.getById(2));
        
//			delete zoid by id
//        zoidDAO.deleteById(2);
        
//			update zoid by id
        Zoid zoidUpdate = new Zoid((long) 3 ,"T-rex", "Dino", "Gray", 50, 40);
        
        zoidDAO.update(zoidUpdate);
        
    }
}
