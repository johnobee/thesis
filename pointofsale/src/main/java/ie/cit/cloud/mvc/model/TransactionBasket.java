package ie.cit.cloud.mvc.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="transactionBaskets")





public class TransactionBasket{
	//String title;
	//Integer ammount;
	// .. add more fields as needed
	
	/* Java numeric type to apply to the shopping basket.
	Char, Boolean, double, float, long, int, short, byte
	BYTE: 8 bits, -128 to 127 inclusive
	SHORT: 16 bits, -32,768 to 32767 inclusive
	INT: 32 bits, -2,147,483,648 to 2,145,783,647
	LONG: 64 bits,  -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
	*/
	
	int transactionID;
	long loyaltyCardID;
	int	storeID;
	String 	transctionDateTime;
	double totalTransactionAmount;
	double	totalDiscountAmount;
	double	totalItemLevelDiscount;
	int	tillID;
	int	cashierID;
	int channelID;
	
	//2147483648 1234567890,1234567890123456789,12345,"23/01/2012",99999.99,99999.99,99999.99,12345,12345,12345

	

	public TransactionBasket(
							int transactionID,
							long loyaltyCardID,
							int	storeID,
							String 	transctionDateTime,
							double	totalTransactionAmount,
							double	totalDiscountAmount,
							double	totalItemLevelDiscount,
							int	tillID,
							int	cashierID,
							int channelID) 
	
	{
		
		
		this.transactionID = transactionID;
		this.loyaltyCardID = loyaltyCardID;
		this.storeID		= storeID;
		this.transctionDateTime = transctionDateTime;
		this.totalTransactionAmount = totalTransactionAmount;
		this.totalDiscountAmount = totalDiscountAmount;
		this.totalItemLevelDiscount = totalItemLevelDiscount;
		this.tillID = tillID;
		this.cashierID = cashierID;
		this.channelID = channelID;
	}
	
	public TransactionBasket() {
	}
	
	
	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public long getLoyaltyCardID() {
		return loyaltyCardID;
	}

	public void setLoyaltyCardID(long loyaltyCardID) {
		this.loyaltyCardID = loyaltyCardID;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public String getTransctionDateTime() {
		return transctionDateTime;
	}

	public void setTransctionDateTime(String transctionDateTime) {
		this.transctionDateTime = transctionDateTime;
	}

	public double getTotalTransactionAmount() {
		return totalTransactionAmount;
	}

	public void setTotalTransactionAmount(double totalTransactionAmount) {
		this.totalTransactionAmount = totalTransactionAmount;
	}

	public double getTotalDiscountAmount() {
		return totalDiscountAmount;
	}

	public void setTotalDiscountAmount(double totalDiscountAmount) {
		this.totalDiscountAmount = totalDiscountAmount;
	}

	public double getTotalItemLevelDiscount() {
		return totalItemLevelDiscount;
	}

	public void setTotalItemLevelDiscount(double totalItemLevelDiscount) {
		this.totalItemLevelDiscount = totalItemLevelDiscount;
	}

	public int getTillID() {
		return tillID;
	}

	public void setTillID(int tillID) {
		this.tillID = tillID;
	}

	public int getCashierID() {
		return cashierID;
	}

	public void setCashierID(int cashierID) {
		this.cashierID = cashierID;
	}

	public int getChannelID() {
		return channelID;
	}

	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}


	
}
