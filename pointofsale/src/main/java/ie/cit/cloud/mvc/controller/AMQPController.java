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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Handles requests for the application home page.
 */



@Controller
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
	@RequestMapping(value = "/basket")
	@ResponseStatus(value = HttpStatus.OK)
	public void registerBasket() {
		for (int count = 0; count < 1000; count++)
			
			/*
			 * 
			 * 
			 * 
			 * 
			 * 
			 *					int transactionID;
								long loyaltyCardID;
								int	storeID;
								String 	transctionDateTime;
								int	totalTransactionAmount;
								int	totalDiscountAmount;
								int	totalItemLevelDiscount;
								int	tillID;
								int	cashierID;
								int channelID;
							1234567890+count,1234567890123456789L,12345,"21/01/2012",99999.9999,99999.9999,99999.9999,123,123,123));
		
							
			The following example shows other ways you can use the underscore in numeric literals:

				long creditCardNumber = 1234_5678_9012_3456L;
				long socialSecurityNumber = 999_99_9999L;
				float pi =  3.14_15F;
				long hexBytes = 0xFF_EC_DE_5E;
				long hexWords = 0xCAFE_BABE;
				long maxLong = 0x7fff_ffff_ffff_ffffL;
				byte nybbles = 0b0010_0101;
				long bytes = 0b11010010_01101001_10010100_10010010;
				You can place underscores only between digits; you cannot place underscores in the following places:

				At the beginning or end of a number
				Adjacent to a decimal point in a floating point literal
				Prior to an F or L suffix
				In positions where a string of digits is expected
				
				 */
			//1234567890,1234567890123456789,12345,"23/01/2012",99999.99,99999.99,99999.99,12345,12345,12345
			//tmpl.convertAndSend(toRabbit, count);
			tmpl.convertAndSend(toRabbit, new TransactionBasket(1234567890+count,1234567890123456789L,12345,"21/01/2012",99999.9999,99999.9999,99999.9999,123,123,123));
		
	
		
		
		
		logger.info("Sending to RabbitMQ exchange using SI outbound adapter");
	}
}