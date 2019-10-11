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

public abstract class Statistics//Orizetai ws abstract giati den kataskeyazetai antikeimeno typou MobileService, alla mono twn apogonwn ths 
{
	public String toString() //Kanei override sthn toString() ths Object
	{
		return String.format("%n%s%n%36s %n%s%n",
				"----------------------------------------------------------------", 
				"Mhniaia Statistika", 
				"----------------------------------------------------------------");
	}//toString
}//Statistics
