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

public class CostControlPlan extends MobilePlan
{
	//Instance metablhtes
	protected float remainingUnits; //Arxiko mhniaio dia8esimo ypoloipo (meiwnetai meta th xrhsh twn dwrean paroxwn)
	
	
	//Constructors
	public CostControlPlan() //Default constructor
	{
		
	}//CostControlPlan
	
	
	
	public CostControlPlan(float units, int freeSecs, int freesms, float timeCharge,float smscharge, String name, float tarrif)
	{
		super(freeSecs, freesms, timeCharge, smscharge, name, tarrif); //Klhsh tou kataskeyasth ths MobilePlan
		super.programType = "Kartosymbolaio";
		this.remainingUnits = units;
	}//CostControlPlan
	
	
	
	//Setters
	public void setRemainingUnits(float units)
	{
		this.remainingUnits = units;
	}//setRemainingUnits
	
	
	
	//Getters
	public float getRemainingUnits()
	{
		return this.remainingUnits;
	}//getRemainingUnits
	
	
	
	public float discount() //kanei override sthn discount() ths MobilePlan
	{
		return 0.25f;
	}//discount
	
	
	
	public String toString()//kanei override sthn toString() ths MobilePlan
	{
		return String.format("%s%n %25s %-4.2f %s", super.toString(), "(Ypoloipo xrhshs:", this.remainingUnits, "\u20AC)");
	}//toString
}//CostControlPlan
