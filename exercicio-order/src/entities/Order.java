package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> itens = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		this.itens.add(item);
	}
	
	public void remove(OrderItem item) {
		this.itens.remove(item);
	}
	
	public Double total() {
		Double sum = 0.0;
		for (OrderItem orderItem : itens) {
			sum += orderItem.subtotal();
		}
		return sum;
	}
	
	public void scrollThrough_list() {
		for (OrderItem orderItem : itens) {
			System.out.println(orderItem);
		}
	}

}
