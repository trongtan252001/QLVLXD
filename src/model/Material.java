package model;

import java.time.LocalDate;

public class Material {
	private String name;
	private double price;
	private String type;
	private String nameCompany;
	private String urlImg;

	public Material( String name, double price, String type, String nameCompany, String urlImg) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.nameCompany = nameCompany;
		this.urlImg = urlImg;
	}
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nameCompany == null) ? 0 : nameCompany.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((urlImg == null) ? 0 : urlImg.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nameCompany == null) {
			if (other.nameCompany != null)
				return false;
		} else if (!nameCompany.equals(other.nameCompany))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (urlImg == null) {
			if (other.urlImg != null)
				return false;
		} else if (!urlImg.equals(other.urlImg))
			return false;
		return true;
	}




	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNameCompany() {
		return nameCompany;
	}
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}


	@Override
	public String toString() {
		return "Material [name=" + name + ", price=" + price + ", type=" + type + ", nameCompany=" + nameCompany
				+ ", urlImg=" + urlImg + "]";
	}
	
	
}
