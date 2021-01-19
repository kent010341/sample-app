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
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class EntitySampleServiceImpl implements EntitySampleService {
    
    @PersistenceContext(unitName = "myPU")
    private EntityManager em;
    
    @GET
    public Response getTest(@QueryParam("param") String val) {
        return Response.status(Response.Status.FOUND)
                .entity(val)
                .build();
    }
    
    @Override
    @GET
    @Path("/{id}")
    public EntitySample get(@PathParam("id") Long id) {
        System.out.println(id);
        return null;
    }

    @Override
    @POST
    @Path("/{val1}")
    public void add(@PathParam("val1") String val1) {
        EntitySample es = new EntitySample();
        es.setVal1(val1);
        
        em.persist(es);
    }
    
}
