
package org.jboss.soa.esb.samples.quickstart.helloworld.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-04/11/2011 03:11 PM(mockbuild)-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "HelloWorldEjbWS", targetNamespace = "http://helloworld.quickstart.samples.esb.soa.jboss.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWorldEjbWS {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://helloworld.quickstart.samples.esb.soa.jboss.org/", className = "org.jboss.soa.esb.samples.quickstart.helloworld.client.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://helloworld.quickstart.samples.esb.soa.jboss.org/", className = "org.jboss.soa.esb.samples.quickstart.helloworld.client.SayHelloResponse")
    public void sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
