/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.service;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 *
 * @author kent_chen
 */
//@Component
@Command(scope = "myservice", name = "add", description = "description: myservice/add")
@Service
public class AddCommand implements Action {
    
//    @Reference
//    private EntitySampleService ess;
    
    @Argument(index = 0, name = "val1", description = "val1 of EntitySameple", 
            required = true, multiValued = false)
    String val1;
    
    @Override
    public Object execute() throws Exception {
//        ess.add(val1);
        System.out.println(val1);
        return null;
    }
    
}
