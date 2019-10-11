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

public class MobilePlan extends MobileService
{
	//Instance metablhtes
	protected int freeTime; //O dwrean xronos omilias pros kinhta kai sta8era diktya (se seconds)
	protected int freeSMS; //Dwrean SMS
	protected float talkTimeCharge; //Xrewsh pros kinhta kai sta8era diktya meta ton dwrean xrono (eyrw/second)
	protected float SMSCharge; //Xrewsh SMS meta ta dwrean SMS (eyrw/SMS)
	
	
	//Constructors
	public MobilePlan() //Default constructor
	{
		
	}//MobilePlan
	
	
	
	public MobilePlan(int freeSecs, int freesms, float timeCharge,float smscharge, String name, float tarrif)
	{
		super(name,tarrif); //Klhsh tou kataskeyasth ths MobileService
		super.programType = "Programma symbolaiou";
		this.freeTime = freeSecs;
		this.freeSMS = freesms;
		this.talkTimeCharge = timeCharge;
		this.SMSCharge = smscharge;
	}//MobilePlan
	
	
	//Setters
	public void setFreeTime(int freeSecs)
	{
		this.freeTime = freeSecs;
	}//setFreeTime
	
	
	
	public void setFreeSMS(int freeSMS)
	{
		this.freeSMS = freeSMS;
	}//setFreeSMS
	
	
	
	public void setTalkTimeCharge(float timeCharge)
	{
		this.talkTimeCharge = timeCharge;
	}//setTalkTimeCharge
	
	
	
	public void setSMSCharge(float smscharge)
	{
		this.SMSCharge = smscharge;
	}//setSMSCharge
	
	
	//Getters
	public int getFreeTime()
	{
		return this.freeTime;
	}//getFreeTime
	
	
	
	public int getFreeSMS()
	{
		return this.freeSMS;
	}//getFreeSMS
	
	
	
	public float getTalkTimeCharge()
	{
		return this.talkTimeCharge;
	}//getTalkTimeCharge
	
	
	
	public float getSMSCharge()
	{
		return this.SMSCharge;
	}//getSMSCharge
	
	
	
	public float discount()//epistrefei to poso ths ekptwshs(ylopoiei thn abstract me8odo ths MobileService)
	{
		return 0.20f;
	}//discount
	
	
	
	public String toString()//kanei override sthn toString() ths MobileService
	{
		return String.format("%s%n %26s %d%s%n %27s %s%n %28s %.4f%s%n %47.4f%s%n",  
				super.toString(), 
				"Dwrean xronos:", this.freeTime/60, "min", 
				"Dwrean SMS:", this.freeSMS, 
				"Extra xrewseis:", this.talkTimeCharge, "\u20AC/sec, ", this.SMSCharge, "\u20AC/SMS");
	}//toString
}//MobilePlan
