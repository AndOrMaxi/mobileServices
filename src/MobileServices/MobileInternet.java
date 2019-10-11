/*
 * Ergasia 3 - Programmatismos ypologistwn me Java
 * 
 * Akadhmaiko etos: 2012-2013
 * 
 * Ismahl Fatma 			3060209
 * Papantwnhs Dionysios 	3120142
 * Toumanidou Andromaxh 	3040185
 * 
 */

package MobileServices;

public class MobileInternet extends MobileService
{
	//Instance metablhtes
	protected float freeDataVolume; //Dwrean ogkos dedomenwn (se MB)
	protected float surfingCharge; //Xrewsh meta to dwrean ogko dedomenwn (eyrw/MB)
	
	
	//Constructors
	public MobileInternet() //Default constructor
	{
		
	}//MobileInternet
	
	
	
	public MobileInternet(float freeMB, float MBCharge, String name, float tarrif)
	{
		super(name, tarrif); //Klhsh tou kataskeyasth ths MobileService
		super.programType = "Mobile Internet";
		this.freeDataVolume = freeMB;
		this.surfingCharge = MBCharge;
	}//MobileInternet
	
	
	//Setters
	public void setFreeDataVolume(float freeMB)
	{
		this.freeDataVolume = freeMB;
	}//setFreeDataVolume
	
	
	
	public void setSurfingCharge(float MBcharge)
	{
		this.surfingCharge = MBcharge;
	}//setSurfingCharge
	
	
	//Getters
	public float getFreeDataVolume()
	{
		return this.freeDataVolume;
	}//getFreeDataVolume
	
	
	
	public float getSurfingCharge()
	{
		return this.surfingCharge;
	}//getSurfingCharge
	
	
	
	public float discount()//epistrefei to poso ths ekptwshs(ylopoiei thn abstract me8odo ths MobileService)
	{
		return 0.30f;
	}//discount
	
	
	
	public String toString()//kanei override sthn toString() ths MobileService
	{
		return String.format("%s%n %23s %.2f%s%n %23s %.4f%s%n%n%n%n", super.toString(), "Dwrean MB:", this.freeDataVolume, "MB", "Extra xrewsh:", this.surfingCharge, "\u20AC/MB");
	}//toString
}//MobileInternet
