/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.service;

import kent.service.api.EntitySample;
import kent.service.api.EntitySampleService;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.blueprint.container.BlueprintContainer;
import org.osgi.service.component.annotations.Reference;

/**
 *
 * @author kent_chen
 */

@Service
@Command(scope = "myservice", name = "add", description = "description: myservice/add")
public class AddCommand implements Action {
    
    @Argument(index = 0, name = "val1", description = "val1 of EntitySameple", 
            required = true, multiValued = false)
    String val1;
    
    @Override
    public Object execute() throws Exception {
        BlueprintContainer container;
        Bundle bundle = FrameworkUtil.getBundle(this.getClass());
        BundleContext bundleContext = bundle.getBundleContext();
        String symbolicname = (String) bundle.getHeaders().get("Bundle-SymbolicName");
        ServiceReference[] refs = bundleContext.getServiceReferences(
                BlueprintContainer.class.getName(),
                "(osgi.blueprint.container.symbolicname=" + symbolicname + ")");
        container = (BlueprintContainer) bundleContext.getService(refs[0]);
        
        EntitySampleService ess = (EntitySampleService)container.getComponentInstance("entitySampleService");
        
        EntitySample es = new EntitySample();
        es.setVal1(val1);
        ess.add(es);
        System.out.println(val1);
        return null;
    }
    
}
