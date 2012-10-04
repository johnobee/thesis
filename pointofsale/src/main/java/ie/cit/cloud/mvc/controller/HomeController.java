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

import ie.cit.cloud.mvc.model.ShoppingBasket;

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
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	@Qualifier("toRabbit")
	MessageChannel toRabbit;

	private MessagingTemplate tmpl = new MessagingTemplate();

	@RequestMapping(value = "/")
	public String home(Model model) {
		return "redirect:registerbasket";
	}

	//  curl -i http://localhost:8080/basket/registerbasket
	@RequestMapping(value = "/registerbasket")
	@ResponseStatus(value = HttpStatus.OK)
	public void registerBasket() {
		for (int count = 0; count < 10; count++)
			tmpl.convertAndSend(toRabbit, new ShoppingBasket("Basket 1", count));
		logger.info("Sending to RabbitMQ exchange using SI outbound adapter");
	}
}