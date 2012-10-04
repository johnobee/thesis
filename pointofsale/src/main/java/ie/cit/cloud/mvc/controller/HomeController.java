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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value="/")
    public String home(Model model) {
        return "redirect:registerbasket";
    }

    
    @RequestMapping(value="/registerbasket")
    public String registerBasket(Model model) {
        int count = 0;
        while (count < 10) {
        	 amqpTemplate.convertAndSend("si.test.queue", "Hello World:" + count + ": timestamp:");
        	 count++;
        };
   
        logger.info("Sending to SI quere using amqpTemplate");
        return "basketResults";

    }
    
   
}

