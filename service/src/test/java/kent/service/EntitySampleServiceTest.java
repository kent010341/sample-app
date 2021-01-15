/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.service;

import kent.service.api.EntitySample;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author kent_chen
 */
public class EntitySampleServiceTest {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("myTestPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void createTest() {
        EntitySample es = new EntitySample();
        es.setVal1("TEST-val1");
        
        em.getTransaction().begin();
        em.persist(es);
        em.getTransaction().commit();
    }
    
}
