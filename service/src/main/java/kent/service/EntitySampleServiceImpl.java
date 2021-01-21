/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.service;

import java.util.List;
import kent.service.api.EntitySampleService;
import kent.service.api.EntitySample;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.osgi.service.component.annotations.Component;

/**
 *
 * @author kent_chen
 */
//@Component(service = EntitySampleService.class)
@Transactional
@Path("EntitySample")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EntitySampleServiceImpl implements EntitySampleService {
    
    @PersistenceContext(unitName = "myPU")
    private EntityManager em;
    
    @Override
    @GET
    public List<EntitySample> getAll() {
        List<EntitySample> result = em.createQuery(
                "FROM EntitySample",
                EntitySample.class)
                .getResultList();
        
        return result;
    }
    
    @Override
    @GET
    @Path("/{id}")
    public EntitySample get(@PathParam("id") Long id) {
        EntitySample esFound = em.find(EntitySample.class, id);
        
        return esFound;
    }

    @Override
    @POST
    public Response add(EntitySample es) {
        em.persist(es);
        
        return Response.status(Response.Status.CREATED)
                .entity(getAll())
                .build();
    }

    @Override
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, EntitySample es) {
        EntitySample esFound = em.find(EntitySample.class, id);
        esFound.setVal1(es.getVal1());
        
        return Response.status(Response.Status.OK)
                .entity(esFound)
                .build();
    }

    @Override
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        EntitySample esFound = em.find(EntitySample.class, id);
        em.remove(esFound);
        
        return Response.status(Response.Status.OK)
                .entity(getAll())
                .build();
    }
    
}
