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
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import ie.cit.cloud.mvc.model.testBasket;

/**
 * Handles requests for the application home page.
 */


@Controller
@RequestMapping("amqprest")
public class AMQPController {

	private static final Logger logger = LoggerFactory
			.getLogger(AMQPController.class);

	@Autowired
	@Qualifier("toRabbit")
	MessageChannel toRabbit;
	
	private MessagingTemplate tmpl = new MessagingTemplate();

	@RequestMapping(value = "/")
	public String home(Model model) {
		return "redirect:registerbasket";
	}

	//  curl -i http://localhost:8080/basket/registerbasket
	@RequestMapping(value = "/basket", 
					method = RequestMethod.POST, 
					headers="Accept=application/xml, application/json")
	@ResponseStatus(value = HttpStatus.OK)
//	public void registerBasket(@RequestBody TransactionBasket transactionBasket){
	//	for (int count = 0; count < 1000; count++)
	
	public void registerBasket(@RequestBody TransactionBasket transactionBasket){
			
		
		//	tmpl.convertAndSend(toRabbit, new TransactionBasket(1234567890+count,1234567890123456789L,12345,"21/01/2012",99999.9999,99999.9999,99999.9999,123,123,123));
			tmpl.convertAndSend(toRabbit, transactionBasket);
			logger.info("Sending to RabbitMQ exchange using SI outbound adapter");
	}
}