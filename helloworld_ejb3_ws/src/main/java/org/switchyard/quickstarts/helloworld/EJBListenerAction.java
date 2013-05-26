package org.switchyard.quickstarts.helloworld;

//import org.jboss.soa.esb.actions.AbstractActionLifecycle;
//import org.jboss.soa.esb.helpers.ConfigTree;
//import org.jboss.soa.esb.message.Message;

public class EJBListenerAction // extends AbstractActionLifecycle
{

    /*
     * protected ConfigTree _config;
     * 
     * public EJBListenerAction(ConfigTree config) { _config = config; }
     */
    public String displayMessage(String message) throws Exception {

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("EJBListenerAction: " + message);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        return message;

    }

}