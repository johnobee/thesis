package ie.cit.cloud.mvc.service.amqp;

import ie.cit.cloud.pointofsale.SalesTransactionRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;

//@Service("amqpServiceActivator")
@MessageEndpoint
public class  amqpServiceActivator {

	protected static Logger amqplogger = Logger.getLogger("amqpservice");
	@Autowired
	@Qualifier("fromRabbit.epos.loyalty")
	MessageChannel fromRabbit;

	@Autowired
	@Qualifier("toRabbit")
	MessageChannel toRabbit;

	

	
	private MessagingTemplate tmpl = new MessagingTemplate(fromRabbit);
	
	@ServiceActivator
    public void amqpServiceActivatorMethod(String param) {
		tmpl.convertAndSend("fromRabbit");
      amqplogger.info("serviceMethod received Q1: " + param + tmpl.receiveAndConvert("fromRabbit"));
      amqplogger.info("serviceMethod received:Q2: " + param + tmpl.receiveAndConvert("fromRabbit"));
      amqplogger.info("serviceMethod received:Q3: " + param + tmpl.receiveAndConvert("fromRabbit"));
    //return "hello, " + param;
    }
}