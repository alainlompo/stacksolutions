package stack.commons.telecoms;

import java.util.Scanner;

class Cellphone {

	private String brand;
	private long serialNumber;
	private double Price;

	public Cellphone (String br, long sN, double Pr)
	{
	    brand= br;
	    serialNumber = sN;
	    Price = Pr;
	}
	public Cellphone(Cellphone cellphone) {
		// TODO Auto-generated constructor stub
		this.brand = cellphone.brand;
		this.serialNumber = cellphone.serialNumber;
		this.Price = cellphone.Price;
	}
	public boolean equals(Cellphone phone)
	{
	    if (Price == phone.Price  && brand.equals(phone))
	        return true;
	    else
	        return false;}
	public boolean equals2(Cellphone phone)
	{ 
		if (Price == phone.Price)
			return true;
		else
			return false; 
	}
	
	public boolean equals3(Cellphone phone)
	{ 
		if (brand.equals(phone));
	    	return true;
	}

}