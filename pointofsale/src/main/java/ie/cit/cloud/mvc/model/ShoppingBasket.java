package ie.cit.cloud.mvc.model;

public class ShoppingBasket {
	String title;
	Integer ammount;

	// .. add more fields as needed

	public ShoppingBasket(String title, Integer ammount) {
		this.title = title;
		this.ammount = ammount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAmmount() {
		return ammount;
	}

	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}

}
