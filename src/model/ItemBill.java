package model;

import java.time.LocalDate;

public class ItemBill {
	private Material material;
	private int quantity;//so luong
	public ItemBill(Material material, int quantity) {
		this.material = material;
		this.quantity = quantity;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
