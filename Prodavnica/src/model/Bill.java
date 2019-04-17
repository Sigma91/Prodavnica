package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Bill {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int IdBill;
@OneToOne
private User user;
@OneToMany
private List <Product> ListOfProducts = new ArrayList<Product>();
private double totalPrice;
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public List<Product> getListOfProducts() {
	return ListOfProducts;
}
public void setListOfProducts(List<Product> listOfProducts) {
	ListOfProducts = listOfProducts;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}
public int getIdBill() {
	return IdBill;
}
public void setIdBill(int idBill) {
	IdBill = idBill;
}


}
