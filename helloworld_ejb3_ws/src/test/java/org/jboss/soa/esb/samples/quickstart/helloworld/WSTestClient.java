package org.jboss.soa.esb.samples.quickstart.helloworld;

import javax.xml.ws.Endpoint;

import org.jboss.soa.esb.samples.quickstart.helloworld.client.HelloWorldWS;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.camel.model.RouteScanner;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.component.test.mixins.hornetq.HornetQMixIn;
import org.switchyard.component.test.mixins.http.HTTPMixIn;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = {
        CDIMixIn.class, HornetQMixIn.class }, scanners = RouteScanner.class)
public class WSTestClient {
//Quickstart_helloworld_ejb3_ws/HelloWorldEjbWSBean?wsdl
    private static final String WEB_SERVICE = "http://localhost:8080/Quickstart_helloworld_ejb3_ws/HelloWorldEjbWSBean?wsdl";
    private static final String QUEUE_NAME = "quickstart_webservice_consumer1_Request";
    private static final String TEST_MESSAGE = "Jimbo";
    
    private static Endpoint _endpoint;
    
    private HornetQMixIn _hornetQMixIn;
    private HTTPMixIn _httpMixIn;
    
    @BeforeClass
    public static void startWebService() throws Exception {
        _endpoint = Endpoint.publish(WEB_SERVICE, new HelloWorldWS());
    }
    
    @AfterClass
    public static void stopWebService() throws Exception {
        _endpoint.stop();
    }
    
    @Test
    public void testWebService() throws Exception {
        _httpMixIn.postResourceAndTestXML(WEB_SERVICE, "/xml/soap-request.xml", "/xml/soap-response.xml");
    }
    
    // public static void main(String[] args) throws Exception {
    //@Test
    public void sendMessage() throws Exception {
        HelloWorldWS service = new HelloWorldWS();
        service.getHelloWorldEjbWSBeanPort().sayHello("ENTER NAME HERE ;-)");
    }

    public static void main(String[] args) throws Exception {
          HelloWorldWS service = new HelloWorldWS();
            service.getHelloWorldEjbWSBeanPort().sayHello("ENTER NAME HERE ;-)");
        }
}
