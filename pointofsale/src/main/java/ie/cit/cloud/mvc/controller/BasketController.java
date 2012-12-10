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


import ie.cit.cloud.mvc.model.TransactionBasket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Handles requests for the application home page.
 */


@Controller
public class BasketController {

	private static final Logger logger = LoggerFactory
			.getLogger(BasketController.class);

	@Autowired
	@Qualifier("toRabbit")
	MessageChannel toRabbit;
	
	private MessagingTemplate tmpl = new MessagingTemplate();

	/* 
	 * 	AMQP Controller Elements
	 */

	
	@RequestMapping(value = "/amqp", 
					method = RequestMethod.POST, 
					headers="Accept=application/xml, application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public void registerBasketAMQP(@RequestBody TransactionBasket transactionBasket){
			
		Message<TransactionBasket> message = MessageBuilder.withPayload(transactionBasket)
		        .setHeader("message_source", "AMQP")
		       // .setHeader("message_service", "AMQP")
		        .build();
		
			logger.info("************************************");
			logger.info("ABOUT TO SEND FROM AMQP CONTROLLER");
			logger.info("************************************");
			
			
			tmpl.convertAndSend(toRabbit, message);
			
			
			logger.info("************************************");
			logger.info("BACK TO THE AMQP CONTROLLER");
			logger.info("************************************");
			
	}
	
	
	/* 
	 * 	WS Controller Elements
	 */

	
	@RequestMapping(value = "/ws/{resource}", 
					method = RequestMethod.POST, 
					headers="Accept=application/xml, application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public void registerBasketWS(@RequestBody TransactionBasket transactionBasket, 
			@PathVariable("resource") String resource)
	{
			
		Message<TransactionBasket> message = MessageBuilder.withPayload(transactionBasket)
		        .setHeader("message_source", "WS")
		        .setHeader("message_service", resource)
		        .build();
		
				
			logger.info("************************************");
			logger.info("ABOUT TO SEND FROM WS CONTROLLER");
			logger.info("************************************");
			
			
			//tmpl.convertAndSend(toRabbit, message);
			
			tmpl.convertAndSend(toRabbit, message);
			
			
			logger.info("************************************");
			logger.info("BACK TO THE WS CONTROLLER");
			logger.info("************************************");
			
	}
}