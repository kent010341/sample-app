/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.service;

import kent.service.api.EntitySampleService;
import kent.service.api.EntitySample;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author kent_chen
 */
@Transactional
public class EntitySampleServiceImpl implements EntitySampleService {
    
    @PersistenceContext(unitName = "myPU")
    private EntityManager em;
    
    @Override
    public EntitySample get(Long id) {
        return null;
    }

    @Override
    public void add(String val1) {
        EntitySample es = new EntitySample();
        es.setVal1(val1);
        em.persist(es);
    }
    
}
