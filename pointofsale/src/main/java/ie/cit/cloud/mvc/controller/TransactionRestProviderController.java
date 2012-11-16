package ie.cit.cloud.mvc.controller;

import ie.cit.cloud.mvc.service.TransactionService;


import org.apache.log4j.Logger;


import ie.cit.cloud.mvc.model.TransactionBasket;
import ie.cit.cloud.mvc.model.TransactionBasketList;


import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

/**
 * REST service provider
 * 
 * Only GET and POST will return values
 * PUT and DELETE will not.
 */
@Controller
@RequestMapping("wsrest")
public class TransactionRestProviderController {

	protected static Logger translogger = Logger.getLogger("controller");
	
	@Resource(name="transactionService")
	private TransactionService transactionService;
	
	//http://localhost:8080/wsrest/baskets
	
	
	@RequestMapping(value = "/baskets", 
								method = RequestMethod.GET, 
								headers="Accept=application/xml, application/json")
	public @ResponseBody TransactionBasketList getBasket() {
		translogger.debug("Provider has received request to get all baskets");
		
		// Call service here
		TransactionBasketList result = new TransactionBasketList();
		result.setData(transactionService.getAll());
		
		return result;
	}
	
	//http://localhost:8080/wsrest/basket/1234567890
	
    @RequestMapping(value = "/basket/{id}", 
    							method = RequestMethod.GET, 
    							headers="Accept=application/xml, application/json")
	public @ResponseBody TransactionBasket getBasket(@PathVariable("id") int id) {
    	translogger.debug("Provider has received request to get bakset with id: " + id);
    	
    	// Call service here
		return transactionService.get(id);
    }
    
    @RequestMapping(value = "/basket", 
    							method = RequestMethod.POST, 
    							headers="Accept=application/xml, application/json")
	public @ResponseBody TransactionBasket addBasket(@RequestBody TransactionBasket transactionBasket) {
    	translogger.debug("Provider has received request to add new basket");
    	
    	// Call service to here
    	return transactionService.add(transactionBasket);
    }
    
    
   
    
    
    
   
}
