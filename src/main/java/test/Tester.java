/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Facade;
import entity.Student;
import entity.Studypoint;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author TimmosQuadros
 */
public class Tester {

    public static void main(String[] args) {
        //HashMap<String, Object> puproperties = new HashMap<>();

        
        //Persistence.generateSchema("jpqlDemo", puproperties);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jpqlDemo" );
        
        Facade f = new Facade(emf);
        
        Student s = f.findPerson(1);
        
        f.addStudyPoints(s, new Studypoint("Abe", 4, 2, s));
        
    }
}
