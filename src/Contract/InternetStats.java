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

public class InternetStats extends Statistics
{
	//Instance metablhtes
	private float dataVolume; //Ogkos kinhshs pou metado8hke
	
	
	//Constructors
	public InternetStats() //Default constructor
	{
		this.dataVolume = 0.0f;
	}//InternetStats
	
	
	
	public InternetStats(float dv)
	{
		this.dataVolume = dv;
	}//InternetStats
	
	
	//Setters
	public void setDataVolume(float mb)
	{
		this.dataVolume = mb;
	}//setDataVolume
		
	
	//Getters
	public float getDataVolume()
	{
		return this.dataVolume;
	}//getDataVolume
	
	
	
	public String toString() //Kanei override sthn toString() ths Statistics
	{
		return String.format("%s%22s %.2f%s", super.toString(), "Ogkos dedomenwn:", this.dataVolume, "MB");
	}//toString
}//InternetStats