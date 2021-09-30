package model;

public interface IBill {
	public double calcBill();
	public double calcDiscount(double sum);
	public int calcBeforeDiscount();
	public void addItemBill(ItemBill item);
}
