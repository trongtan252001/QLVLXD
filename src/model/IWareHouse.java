package model;

public interface IWareHouse {
	// nhap bat lieu + soluong

	public void inWareHouse(Material material, int quantity);
	
	// xuat bat lieu + soluong
	public boolean outWareHouse(Material material, int quantity);

}
