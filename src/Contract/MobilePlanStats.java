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
package Contract;

public class MobilePlanStats extends Statistics
{
	//Instance metablhtes
	private int timeToMobileNetworks; //Xronos omilias pros kinhta diktya
	private int timeToNationalFixed; //Xronos omilias pros sta8era diktya
	private int numberOfSMS; //Ari8mos mhnymatwn SMS pou stal8hkan
	
	
	//Constructors
	public MobilePlanStats() //Default constructor
	{
		this.timeToMobileNetworks = 0;
		this.timeToNationalFixed = 0;
		this.numberOfSMS = 0;
	}//MobilePlanStats
	
	
	
	public MobilePlanStats(int tm, int tn, int noSMS)
	{
		this.timeToMobileNetworks = tm;
		this.timeToNationalFixed = tn;
		this.numberOfSMS = noSMS;
	}//MobilePlanStats
	
	
	//Setters
	public void setTimeToMobileNetworks(int time)
	{
		this.timeToMobileNetworks = time;
	}//setTimeToMobileNetworks
	
	
	
	public void setTimeToNationalFixed(int time)
	{
		this.timeToNationalFixed = time;
	}//setTimeToNationalFixed
	
	
	
	public void setNumberOfSMS(int sms)
	{
		this.numberOfSMS = sms;
	}//setNumberOfSMS
	
	
	//Getters
	public int getTimeToMobileNetworks()
	{
		return this.timeToMobileNetworks;
	}//getTimeToMobileNetworks
	
	
	
	public int getTimeToNationalFixed()
	{
		return this.timeToNationalFixed;
	}//getTimeToNationalFixed
	
	
	
	public int getNumberOfSMS()
	{
		return this.numberOfSMS;
	}//getNumberOfSMS
	
	
	
	public String toString() //Kanei override sthn toString() ths Statistics
	{
		return String.format("%s%38s%n%30d%s%n%38s%n%30d%s%n%33s%n%33d",
				super.toString(), 
				"Xronos omilias (kinhta diktya):",
				this.timeToMobileNetworks,"sec",
				"Xronos omilias (sta8era diktya):", 
				this.timeToNationalFixed, "sec", 
				"Ari8mos mhnymatwn SMS:",
				this.numberOfSMS);
	}//toString
}//MobilePlanStats
