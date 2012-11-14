package ie.cit.cloud.mvc.model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="transactionBaskets")
public class TransactionBasketList {

	private List<TransactionBasket> data;


	public List<TransactionBasket> getData() {
		return data;
	}

	public void setData(List<TransactionBasket> data) {
		this.data = data;
	}
}
