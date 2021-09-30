package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
//commit nnnnnnnnnnnnnn
// commit oaaaaa
public class Bill implements IBill{
	private String id;
	private Customer customer;
	private ArrayList<ItemBill> listItemBill ;
	private LocalDate dateBill;
	public Bill(Customer customer) {
		String uniqueID = UUID.randomUUID().toString();
		this.id = uniqueID;
		this.customer = customer;
		this.listItemBill = new ArrayList<ItemBill>();
		this.dateBill = LocalDate.now();
	}
	@Override
	public double calcBill() {
		// TODO Auto-generated method stub
		double result = 0;
		for (int i = 0; i < listItemBill.size(); i++) {
			ItemBill item = listItemBill.get(i);
			result += (item.getQuantity() * item.getMaterial().getPrice());
		}
		return result;
	}
	//calcTax tinh theo don vi %
	// tren 10 trieu 4% tren 5trieu 2% tren 50 trieu 8% tren 150 trieu 12%
	@Override
	public double calcDiscount(double sum) {
		if (sum > 150000000) {
			return 12;
		}
		if (sum > 50000000) {
			return 8;
		}
		if (sum >10000000) {
			return 4;
		}
		if (sum > 5000000) {
			return 2;
		}
		return 0;
	}
	@Override
	public int calcBeforeDiscount() {
		// TODO Auto-generated method stub
		double sumBill = calcBill();
		double discount = calcDiscount(sumBill);
		return (int) (sumBill-sumBill*discount/100);
	}
	public static void main(String[] args) {
		Material i1 = new Material("sp1", 200000, "xi mang", "ct1", "/");
		Material i2 = new Material("sp2", 100000, "xi mang", "ct1", "/");
		ItemBill ib = new ItemBill(i1,20);
		ItemBill ib2 = new ItemBill(i2,12);
		Bill b = new Bill(new Customer("q", "e", "t", "a"));
		b.addItemBill(ib);
		b.addItemBill(ib2);
		System.out.println(b.calcBill());

		System.out.println(b.calcBeforeDiscount());
	}
	@Override
	public void addItemBill(ItemBill item) {
		// TODO Auto-generated method stub
		listItemBill.add(item);
	}
}
