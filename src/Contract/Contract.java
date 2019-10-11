
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

import MobileServices.*;
import java.text.SimpleDateFormat;
import java.util.Date; 

public class Contract<Type> //parametrikh dhlwsh me Generics (me mia parametro)
{
	//Class metablhtes
	private static int numberOfContracts = 0;
	
	
	//Instance metablhtes
	private Type statistics; //mhniaia statistika symbolaiou
	private int contractID; //kwdikos symbolaiou
	private MobileService service; //yphresia
	private String fullName; //Onomatepwnymo pelath
	private String mobileNumber; //Thlefwno pelath
	private Date activationDate; //Hmeromhnia enrgopoihshs tou symbolaiou
	private String paymentMethod; //Tropos plhrwmhs (den elegxetai, ena aplo String)
	private float additionalDiscount; //Pi8anh epipleon ekptwsh
		
	
	//Constructors
	public Contract() //Default constructor
	{
		
	}//Contract
	
	
	
	public Contract(MobileService service, String name, String number, String payment, float discount, Type s, Date date)
	{
		numberOfContracts++; //ayksanetai kata 1 ka8e fora pou kataskeyazetai ena neo antikeimeno-symbolaio
		
		this.contractID = numberOfContracts; //Arxikopoieitai me thn trexousa timh ths statikhs metablhths (etsi pote den prokyptoun dyo symbolaia me ton idio kwdiko)
		this.service = service;
		this.fullName = name;
		this.mobileNumber = number; 
		this.activationDate = date; //Pairnei thn trexousa hmeromhnia kai wra th xronikh stigmh pou dhmiourgeitai to symbolaio 
		this.paymentMethod = payment;
		this.additionalDiscount = discount;
		this.statistics = s;
	}//Contract
	
	
	//Setters
	public void setContractID(int ID)
	{
		this.contractID = ID;
	}//setContractID
	
	
	
	public void setName(String name )
	{
		this.fullName = name;
	}//setName
	
	
	
	public void setService(MobileService service)
	{
		this.service = service;
	}//setService
	
	
	
	public void setMobileNumber(String number)
	{
		this.mobileNumber = number;
	}//setMobileNumber
	
	
	
	public void setPaymentMethod(String payment)
	{
		this.paymentMethod = payment;
	}//setPaymentMethod
	
	
	
	public void setAdditionalDiscount(float discount)
	{
		this.additionalDiscount = discount;
	}//setAdditionalDiscount
	
	
	
	public void setStatistics(Type stats)
	{
		this.statistics = stats;
	}//setStatistics
	
	
	//Getters
	public int getContractID()
	{
		return this.contractID;
	}//getContractID
	
	
	
	public MobileService getService()
	{
		return this.service;
	}//getService
	
	
	
	public String getName()
	{
		return this.fullName;
	}//getName
	
	
	
	public String getMobileNumber()
	{
		return this.mobileNumber;
	}//getMobileNumber
	
	
	
	public String getActivationDate()
	{
		return new SimpleDateFormat("dd/MM/yyyy").format(activationDate);
	}//getActivationDate
	
	
	
	public String getPaymentMethod()
	{
		return this.paymentMethod;
	}//getPaymentMethod
	
	
	
	public float getAdditionalDiscount()
	{
		return this.additionalDiscount;
	}//getAdditionalDiscount
	
	
	
	public Type getStatistics()
	{
		return this.statistics;
	}//getStatistics
	
	
	
	public strictfp float discount() //Epistrefei th synolikh ekptwsh
	{
		return (service.discount() + this.additionalDiscount);
	}//discount
	
	
	
	public float totalCostOrUnits() //Ypologizei to mhniaio kostos gia ta programmata symbolaiou thlefwnias kai kinhtou internet h to dia8esimo mhniaio ypoloipo gia ta kartosymbolaia
	{
		if (this.service instanceof MobileInternet) //An prokeitai gia symbolaio kinhtou internet
    	{
			if(((InternetStats)this.statistics).getDataVolume() > ((MobileInternet)this.service).getFreeDataVolume())
			{
				return ((((InternetStats)this.statistics).getDataVolume() - ((MobileInternet)this.service).getFreeDataVolume())*((MobileInternet)this.service).getSurfingCharge()+this.service.getMonthlyTarrif())*(1.0f-this.discount());
			}//if
    		else
    			return (this.service.getMonthlyTarrif()*(1.0f-this.discount()));
    	}//if
		else 
		{
			float cost;
			{
				if((((MobilePlanStats)this.statistics).getTimeToMobileNetworks()+(((MobilePlanStats)this.statistics).getTimeToNationalFixed())) > (((MobilePlan)this.service).getFreeTime()))
				{
					cost = ((((MobilePlanStats)this.statistics).getTimeToMobileNetworks()+(((MobilePlanStats)this.statistics).getTimeToNationalFixed())) - (((MobilePlan)this.service).getFreeTime()))*(((MobilePlan)this.service).getTalkTimeCharge());
				}//if
				else 
				{
					cost = 0.0f;
				}//else
				if((((MobilePlanStats)this.statistics).getNumberOfSMS()) > (((MobilePlan)this.service).getFreeSMS()))
				{
					cost += ((((MobilePlanStats)this.statistics).getNumberOfSMS()) - (((MobilePlan)this.service).getFreeSMS()))*(((MobilePlan)this.service).getSMSCharge());
				}//if
				else 
				{
					cost += 0.0f;
				}//else
			}
			if (this.service instanceof CostControlPlan) //An prokeitai gia kartosymbolaio 
			{	if (((CostControlPlan) this.service).getRemainingUnits()> cost)
					return (((CostControlPlan) this.service).getRemainingUnits() - cost*(1.0f-this.discount())); 
				else
					return 0.0f;
			}//if
			else //An prokeitai gia programma symbolaiou thlefwnias
			{
				return (cost+this.service.getMonthlyTarrif())*(1.0f-this.discount());
			}//else
		}//else
	}//totalCostOrUnits
	
	
	
	public String toString() //Kanei override sthn toString() ths Object
	{
		return String.format("%n%s%n%32s%s%n%s%n %25s %s%n %14s %s%n %17s %s%n %17s %s%n %15s %s%n %24s %s%s%s%n",
				"----------------------------------------------------------------", 
				"Symbolaio no", this.contractID, 
				"----------------------------------------------------------------", 
				"Yphresia:", this.service.getServiceName(), 
				"Onomatepwnymo:", this.fullName, 
				"Ari8mos kinhnou:", this.mobileNumber, 
				"Hm/nia ener/shs:", new SimpleDateFormat("dd/MM/yyyy").format(this.activationDate), 
				"Tropos plhrwmhs:", this.paymentMethod, 
				"Ekptwsh:",(int)(this.discount()*100),"%", 
				this.getStatistics().toString());		
	}//toString
}//Contract
