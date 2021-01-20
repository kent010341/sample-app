/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.service.whiteboard;

import org.osgi.service.component.annotations.Component;

/**
 *
 * @author kent_chen
 */
@Component(service = ExampleResource.class, 
           property = {"osgi.http.whiteboard.resource.pattern=/example/*", 
               "osgi.http.whiteboard.resource.prefix=/resources"})

public class ExampleResource {
}
