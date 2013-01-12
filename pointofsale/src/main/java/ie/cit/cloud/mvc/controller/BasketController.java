/*
 * Copyright 2002-2010 the original author or authors
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package ie.cit.cloud.mvc.controller;

import java.util.List;
import ie.cit.cloud.pointofsale.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;

//import org.springframework.amqp.core.Message;

import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.core.PollableChannel;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import ie.cit.cloud.mvc.model.LogEntry;
import ie.cit.cloud.mvc.service.jdbc.LogEntryService;

/**
 * Handles requests for the application home page.
 */

@Controller
public class BasketController {

	private static final Logger logger = LoggerFactory
			.getLogger(BasketController.class);

	@Autowired
	@Qualifier("webSevicesInputChannel")
	MessageChannel input;
	
	@Autowired
	@Qualifier("toRabbit")
	MessageChannel toRabbit;

	private MessagingTemplate tmpl = new MessagingTemplate();

	@Resource(name = "logEntryService")
	private LogEntryService logEntryService;

	/**
	 * Handles and retrieves all persons and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/log", method = RequestMethod.GET)
	public ModelAndView getLogEntries(ModelAndView model) {

		logger.debug("Received request to show all log entries");

		// Retrieve all logentries by delegating the call to LogEntryService
		List<LogEntry> logentries = logEntryService.getAll();

		// Attach logentries to the Model
		model.addObject("logentries", logentries);

		// This will resolve to /WEB-INF/jsp/logpage.jsp
		return model;
	}

	/*
	 * AMQP Controller Elements
	 */

	/*
	 * curl -X POST -H "Content-Type: text/xml" -d @salesTransactionRequest.xml
	 * http://localhost:8080/pointofsale/amqp/1
	 */

	@RequestMapping(value = "/amqp/{testid}", method = RequestMethod.POST, headers = "Accept=text/xml, application/xml, text/plain")
	@ResponseStatus(value = HttpStatus.OK)
	public void registerBasketAMQP(@RequestBody String transactionBasket,
			@PathVariable("testid") String testid) {

		Message<String> message = MessageBuilder.withPayload(transactionBasket)
				.setHeader("message_source", "AMQP")
				.setHeader("message_service", "AMQP")
				.setHeader("message_starttime", java.lang.System.currentTimeMillis())
				.setHeader("message_test_id", testid)
				.build();

		logger.info("************************************");
		logger.info("ABOUT TO SEND FROM AMQP CONTROLLER");
		logger.info("************************************");

		tmpl.convertAndSend(toRabbit, message);
		
		logger.info(message.getPayload().toString());
		logger.info("************************************");
		logger.info("BACK TO THE AMQP CONTROLLER");
		logger.info("************************************");
	}
	
	/*
	 * WS Controller Elements
	 */

	/*
	 * curl -X POST - H "Content-Type: text/xml" -d @salesTransactionRequest.xml 
	 * http://localhost:8080/pointofsale/ws/1
	 */

	@RequestMapping(value = "/ws/{testid}", method = RequestMethod.POST, headers = "Accept=text/xml, application/xml, text/plain")
	@ResponseStatus(value = HttpStatus.OK)
	public void registerBasketWS(
			@RequestBody SalesTransactionRequest transactionBasket,
			@PathVariable("testid") String testid) {

		Message<SalesTransactionRequest> message = MessageBuilder
				.withPayload(transactionBasket)
				.setHeader("message_source", "WS")
				.setHeader("message_service", "loyalty")
				.setHeader("message_starttime", java.lang.System.currentTimeMillis())
				.setHeader("message_test_id", testid)
				.build();

		logger.info("************************************");
		logger.info("ABOUT TO SEND LOYALY FROM WS CONTROLLER");
		logger.info("************************************");

		tmpl.convertAndSend(input, message);// (input, message);

		logger.info("************************************");
		logger.info("BACK TO THE LOYALTY WS CONTROLLER");
		logger.info("************************************");

		/*
		 *  Send to CreditCard Web service
		 *  
	*/

		message = MessageBuilder.withPayload(transactionBasket)
				.setHeader("message_source", "WS")
				.setHeader("message_service", "creditcard")
				.setHeader("message_starttime", java.lang.System.currentTimeMillis())
				.setHeader("message_test_id", testid)
				.build();

		logger.info("************************************");
		logger.info("ABOUT TO SEND TO CREDIT CARD WS FROM WS CONTROLLER");
		logger.info("************************************");

		tmpl.convertAndSend(input, message);

		logger.info("************************************");
		logger.info("BACK TO THE WS CONTROLLER");
		logger.info("************************************");

		
		
		
		/*
		 *  Send to Promtion Web service
		 *  
		 *  	 
		 */
		 
		
		
		message = MessageBuilder.withPayload(transactionBasket)
				.setHeader("message_source", "WS")
				.setHeader("message_service", "promotion")
				.setHeader("message_starttime", java.lang.System.currentTimeMillis())
				.setHeader("message_test_id", testid).build();

		logger.info("************************************");
		logger.info("ABOUT TO SEND PROMOTION FROM WS CONTROLLER");
		logger.info("************************************");

		
		tmpl.convertAndSend(input, message);// (input, message);

		logger.info("************************************");
		logger.info("BACK TO THE WS CONTROLLER");
		logger.info("************************************");

	
	
		
		/*
		 *  Send to voucher Web service
		 */
		
		
		
		message = MessageBuilder.withPayload(transactionBasket)
				.setHeader("message_source", "WS")
				.setHeader("message_service", "voucher")
				.setHeader("message_starttime", java.lang.System.currentTimeMillis())
				.setHeader("message_test_id", testid).build();

		logger.info("************************************");
		logger.info("ABOUT TO SEND VOUCHER FROM WS CONTROLLER");
		logger.info("************************************");

		tmpl.convertAndSend(input, message);
		tmpl.convertAndSend(input, message);// (input, message);

		logger.info("************************************");
		logger.info("BACK TO THE VOUCHER WS CONTROLLER");
		logger.info("************************************");
  
		
	}
}