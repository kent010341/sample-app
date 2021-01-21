/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.service.api;

import java.util.List;

/**
 *
 * @author kent_chen
 */
public interface EntitySampleService {
    
    List<EntitySample> getAll();
    
    EntitySample get(Long id);
    
    void add(EntitySample es);
    
    void update(Long id, EntitySample es);
    
    void delete(Long id);
    
}
