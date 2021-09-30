package model;

import java.time.LocalDate;

public class ItemWarehouse {
	private Material material;
	private int quantity;
	private LocalDate date;
	public ItemWarehouse(Material material, int quantity, LocalDate date) {
		this.material = material;
		this.quantity = quantity;
		this.date = date;
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ItemWarehouse [material=" + material + ", quantity=" + quantity + ", date=" + date + "]";
	}

	
}
