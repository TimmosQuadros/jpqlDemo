/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author TimmosQuadros
 */
public class Facade {
    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public void createStudent(Student s) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
    
    public Student addStudyPoints(Student st, Studypoint sp)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Student s = em.find(Student.class, st.getId());
            if(s != null)
            {
                s = st;
                s.addStudyPoint(sp);
                em.merge(s);
                em.getTransaction().commit();
                return s;
            }
        }
        finally
        {
            em.close();
        }  
        
        return null;
    }
    
    public Student findPerson(int key) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student s = em.find(Student.class, key);
        em.getTransaction().commit();
        em.close();
        return s;
    }
    
    
}
