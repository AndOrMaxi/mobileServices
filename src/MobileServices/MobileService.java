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

public abstract class MobileService //Orizetai ws abstract giati den kataskeyazetai antikeimeno typou MobileService, alla mono twn apogonwn ths
{
	//Instance metablhtes
	protected String programType; //Apo8hkeyetai o typos ths yphresias (xrhsimopoieitai sthn toString())
	protected String serviceName; //To onoma ths yphresias
	protected float monthlyTarrif; //To mhniaio pagio
	
	
	//Constructors
	public MobileService() //Default constructor(den kanei tipota)
	{
		
	}//MobileService
	
	
	
	public MobileService(String name, float tarrif) //Constructor me 2 orismata(arxikopoiei tis metablhtes klashs)
	{
		this.serviceName = name;
		this.monthlyTarrif = tarrif;
	}//MobileService
	
	
	//Setters
	public void setServiceName(String name)
	{
		this.serviceName = name;
	}//setServiceName
	
	
	
	public void setMonthlyTarrif(float tarrif)
	{
		this.monthlyTarrif = tarrif;
	}//setMonthlyTarrif
	
	
	//Getters
	public String getServiceName()
	{
		return this.serviceName;
	}//getServiceName
	
	
	
	public float getMonthlyTarrif()
	{
		return this.monthlyTarrif;
	}//getMonthlyTarrif
	
	
	
	public String getProgramType()
	{
		return this.programType;
	}//getProgramType
	
	
	
	public abstract float discount(); //epistrefei to poso ths ekptwshs(ylopoieitai stous apogonous) 
	
	
	
	public String toString() //Kanei override sthn toString() ths Object
	{
		return String.format("%n%s%n%25s%s %s%n%s%n%n  %27s %-4.2f%-1s", 
				"-------------------------------------------------------", 
				this.programType, ":", this.serviceName, 
				"-------------------------------------------------------", 
				"Mhniaio pagio:", this.monthlyTarrif, "\u20AC");
	}//toString
}//MobileService
