package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Warehouse implements IWareHouse{
	private String nameWarehouse;
	//map nhap
	private ArrayList<ItemWarehouse> inMaterials;
	//map xuat
	private ArrayList<ItemWarehouse> outMaterials;
	
	private ArrayList<ItemWarehouse> availables;
	public Warehouse(String nameWarehouse) {
		this.nameWarehouse = nameWarehouse;
		inMaterials = new ArrayList<ItemWarehouse>();
		outMaterials = new ArrayList<ItemWarehouse>();
		availables = new ArrayList<ItemWarehouse>();
	}
	@Override
	public void inWareHouse(Material material, int quantity) {
//		String uniqueID = UUID.randomUUID().toString();
		LocalDate date = LocalDate.now();
		ItemWarehouse item = new ItemWarehouse( material, quantity, date);
		inMaterials.add(item);
		availables.add(item);
	}
	@Override
	public boolean outWareHouse(Material material, int quantity) {
		
		int count =0;
		for (int i = 0; i < availables.size(); i++) {
			ItemWarehouse itemWarehouse = availables.get(i);
			if (material.equals(itemWarehouse.getMaterial())) {
				count+=itemWarehouse.getQuantity();
			}
			if (count>= quantity) {
				break;
			}
		}
		if (count <quantity) {
			return false;
		}
		LocalDate date = LocalDate.now();
		ItemWarehouse item = new ItemWarehouse( material, quantity, date);
		outMaterials.add(item);
		removeOut(material, quantity);
		// TODO Auto-generated method stub
		return true;
	}
	private void removeOut(Material material, int quantity) {
		for (int i = 0; i < availables.size(); i++) {
			ItemWarehouse itemWarehouse = availables.get(i);
			if (material.equals(itemWarehouse.getMaterial())) {
				if (itemWarehouse.getQuantity() > quantity) {
					itemWarehouse.setQuantity(itemWarehouse.getQuantity()-quantity);
					return;
				}
				if (itemWarehouse.getQuantity() <= quantity) {
					quantity -= itemWarehouse.getQuantity();
					availables.remove(i);
				}
			}
		}
	}
	
	// hien thi view
	public Map<Material, Integer> displayData() {
		Map<Material, Integer> result = new HashMap<>();
		for (int i = 0; i < availables.size(); i++) {
			ItemWarehouse itemWarehouse = availables.get(i);
			if (result.containsKey(itemWarehouse.getMaterial())) {
				int sum = result.get(itemWarehouse.getMaterial())+itemWarehouse.getQuantity();
				result.put(itemWarehouse.getMaterial(), sum);

			}else {
				result.put(itemWarehouse.getMaterial(), itemWarehouse.getQuantity());
			}
		}
		return result;
		
	}
	public String getNameWarehouse() {
		return nameWarehouse;
	}
	public void setNameWarehouse(String nameWarehouse) {
		this.nameWarehouse = nameWarehouse;
	}
	public ArrayList<ItemWarehouse> getInMaterials() {
		return inMaterials;
	}
	public void setInMaterials(ArrayList<ItemWarehouse> inMaterials) {
		this.inMaterials = inMaterials;
	}
	public ArrayList<ItemWarehouse> getOutMaterials() {
		return outMaterials;
	}
	public void setOutMaterials(ArrayList<ItemWarehouse> outMaterials) {
		this.outMaterials = outMaterials;
	}
	public ArrayList<ItemWarehouse> getAvailables() {
		return availables;
	}
	public void setAvailables(ArrayList<ItemWarehouse> availables) {
		this.availables = availables;
	}
	
	public static void main(String[] args) {
		Warehouse w = new Warehouse("s1");
		Material i1 = new Material("sp1", 2.3, "xi mang", "ct1", "/");
		Material i2 = new Material("sp2", 2.3, "xi mang", "ct1", "/");
		Material i3 = new Material("sp1", 2.3, "xi mang", "ct1", "/");
		w.inWareHouse(i1,4);
		w.inWareHouse(i2,4);
		w.inWareHouse(i1,3);
		System.out.println(w.getInMaterials().toString());
		System.out.println(w.getOutMaterials().toString());
		System.out.println(w.getAvailables().toString());
		System.out.println("-----------------");
//		System.out.println(w.outWareHouse(i1, 8));
//		System.out.println(w.getAvailables().toString());
//		System.out.println(w.getOutMaterials().toString());
		System.out.println(w.displayData());
	}
}
