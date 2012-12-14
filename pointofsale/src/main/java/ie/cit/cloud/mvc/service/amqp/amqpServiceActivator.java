package ie.cit.cloud.mvc.service.amqp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessagingTemplate;

//@Service("amqpServiceActivator")
@MessageEndpoint
public class  amqpServiceActivator {

	protected static Logger amqplogger = Logger.getLogger("amqpservice");
	@Autowired
	@Qualifier("fromRabbit")
	MessageChannel fromRabbit;

	private MessagingTemplate tmpl = new MessagingTemplate(fromRabbit);
	
	@ServiceActivator
    public void amqpServiceActivatorMethod(String param) {
    	tmpl.receiveAndConvert("si.test.queue1");
      amqplogger.info("serviceMethod received Q1: " + param + tmpl.receiveAndConvert("si.test.queue1"));
      amqplogger.info("serviceMethod received:Q2: " + param + tmpl.receiveAndConvert("si.test.queue2"));
      amqplogger.info("serviceMethod received:Q3: " + param + tmpl.receiveAndConvert("si.test.queue3"));
    //return "hello, " + param;
    }
}