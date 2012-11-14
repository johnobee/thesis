package ie.cit.cloud.mvc.service;

import ie.cit.cloud.mvc.model.TransactionBasket;


import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("transactionService")
public class TransactionService {

	protected static Logger translogger = Logger.getLogger("service");
	
	// In-memory list
	private List<TransactionBasket> transactionBaskets = new ArrayList<TransactionBasket>();
	
	public TransactionService() {
		translogger.debug("Init trasnacitondatabase");
		
		/*
		int transactionID;
		long loyaltyCardID;
		int	storeID;
		String 	transctionDateTime;
		int	totalTransactionAmount;
		int	totalDiscountAmount;
		int	totalItemLevelDiscount;
		int	tillID;
		int	cashierID;
		int channelID;
		*/
		
		//2147483648 1234567890,1234567890123456789,12345,"23/01/2012",99999.99,99999.99,99999.99,12345,12345,12345

		
	
			
		// Create in-memory list
		TransactionBasket basket1 = new TransactionBasket();
		basket1.setTransactionID(1234567890);
		basket1.setLoyaltyCardID(123456789023456789L);
		basket1.setStoreID(12345);
		basket1.setTransctionDateTime("23/01/2012");
		basket1.setTotalTransactionAmount(99999.9999);
		basket1.setTotalDiscountAmount(99999.9999);
		basket1.setTotalItemLevelDiscount(99999.9999);
		basket1.setTillID(12345);
		basket1.setCashierID(12345);
		basket1.setChannelID(12345);
		
		TransactionBasket basket2 = new TransactionBasket();
		basket2.setTransactionID(1234567891);
		basket2.setLoyaltyCardID(123456789023456789L);
		basket2.setStoreID(12345);
		basket2.setTransctionDateTime("23/01/2012");
		basket2.setTotalTransactionAmount(99999.9999);
		basket2.setTotalDiscountAmount(99999.9999);
		basket2.setTotalItemLevelDiscount(99999.9999);
		basket2.setTillID(12345);
		basket2.setCashierID(12345);
		basket2.setChannelID(12345);
		
		TransactionBasket basket3 = new TransactionBasket();
		basket3.setTransactionID(1234567892);
		basket3.setLoyaltyCardID(123456789023456789L);
		basket3.setStoreID(12345);
		basket3.setTransctionDateTime("23/01/2012");
		basket3.setTotalTransactionAmount(99999.9999);
		basket3.setTotalDiscountAmount(99999.9999);
		basket3.setTotalItemLevelDiscount(99999.9999);
		basket3.setTillID(12345);
		basket3.setCashierID(12345);
		basket3.setChannelID(12345);
	
		transactionBaskets.add(basket1);
		transactionBaskets.add(basket2);
		transactionBaskets.add(basket3);
	}
	
	/**
	 * Retrieves all persons
	 */
	public List<TransactionBasket> getAll() {
		translogger.debug("Retrieving all baskets");
		
		return transactionBaskets;
	}
	
	/**
	 * Retrieves a single person
	 */
	public TransactionBasket get( int id ) {
		translogger.debug("Retrieving basket with id: " + id);
		
		for (TransactionBasket transactionBasket:transactionBaskets) {
			if (transactionBasket.getTransactionID() == id) {
				translogger.debug("Found record");
				return transactionBasket;
			}
		}
		
		translogger.debug("No records found");
		return null;
	}
	
	/**
	 * Adds a new person
	 */
	public TransactionBasket add(TransactionBasket transactionBasket) {
		translogger.debug("Adding new basket");
		
		try {
			// Find suitable id
			int newId = 0;
			Boolean hasFoundSuitableId = false;
			while(hasFoundSuitableId == false) {
				for (int i=0; i <transactionBaskets.size(); i++) {
					if (transactionBaskets.get(i).getTransactionID() == newId) {
						newId++;
						break;
					}
					
					// Exit while loop
					if(i==transactionBaskets.size()-1) {
						translogger.debug("Assigning id: " + newId);
						hasFoundSuitableId = true;
					}
				}
			}
			
			// Assign new id
			transactionBasket.setTransactionID(newId);
			// Add to list
			transactionBaskets.add(transactionBasket);
			
			translogger.debug("Added new bakset");
			return transactionBasket;
		} catch (Exception e) {
			translogger.error(e);
			return null;
		}
	}
	
	/**
	 * Deletes an existing person
	 */
	/*
	public Boolean delete(Long id) {
		logger.debug("Deleting person with id: " + id);
		
		try {
			for (Person person:persons) {
				if (person.getId().longValue() == id.longValue()) {
					logger.debug("Found record");
					persons.remove(person);
					return true;
				}
			}
			
			logger.debug("No records found");
			return false;
			
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	*/
	
	/**
	 * Edits an existing person
	 */
	/*
	public Boolean edit(Person person) {
		logger.debug("Editing person with id: " + person.getId());
		
		try {
			for (Person p:persons) {
				if (p.getId().longValue() == person.getId().longValue()) {
					logger.debug("Found record");
					persons.remove(p);
					persons.add(person);
					return true;
				}
			}
			
			logger.debug("No records found");
			return false;
			
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	*/
	
}
