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

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ie.cit.cloud.model.TwitterMessage;
import ie.cit.cloud.service.TwitterService;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;




/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private TwitterService twitterService;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value="/")
    public String home(Model model, @RequestParam(required=false) String startTwitter,
                                    @RequestParam(required=false) String stopTwitter) {

        if (startTwitter != null) {
            twitterService.startTwitterAdapter();
            return "redirect:/";
        }

        if (stopTwitter != null) {
            twitterService.stopTwitterAdapter();
            return "redirect:/";
        }

        final Collection<TwitterMessage> twitterMessages = twitterService.getTwitterMessages();

        logger.info("Retrieved {} Twitter messages.", twitterMessages.size());

        model.addAttribute("twitterMessages", twitterMessages);

        return "home";
    }

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value="/ajax")
    public String ajaxCall(Model model) {

        final Collection<TwitterMessage> twitterMessages = twitterService.getTwitterMessages();

        logger.info("Retrieved {} Twitter messages.", twitterMessages.size());
        model.addAttribute("twitterMessages", twitterMessages);

        return "twitterMessages";

    }
    
    @RequestMapping(value="/registerbasket")
    public String registerBasket(Model model) {

      
        ApplicationContext context = new GenericXmlApplicationContext("META-INF/spring/integration/spring-integration-context.xml");
        AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
        		
        int count = 0;
        while (count < 10) {
        	 amqpTemplate.convertAndSend("si.test.queue", "Hello World:" + count + ": timestamp:");
        	 count++;
        };
    		
       
   
        logger.info("Sending to SI quere using amqpTemplate");
        //model.addAttribute("basketResults", twitterMessages);

        return "basketResults";

    }
    
   
}

