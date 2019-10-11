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
package Lists;

import java.io.*;
import java.util.*;
import MobileServices.*;

public class ServiceList 
{
	//Instance metablhtes
	private ArrayList<MobileService> services = new ArrayList<MobileService>(); //Mia ArrayList gia tis dia8esimes yphresies
	
	
	//Constructors
	public ServiceList() //Default constructor
	{
		
	}//ServiceList
	
	
	
	public void addService (MobileService service) //Pros8hkh mias yphresias sth lista
    {
    	services.add(service);
    }//addService
	
	

    public int numberOfServices() //Epistrefei to plh8os twn yphresiwn ths listas
    {
        return services.size();
    }//numberOfService
    
    

    public void printServices() //Emfanizei tis yphresies ths listas
    {
    	for(MobileService service:services)
    		System.out.println(service.toString());    	
    }//printServices
    
    
    
    public void printMenuServices() //Emfanizei menu me tis dia8esimes yphresies ths listas
    {
    	int counter = 1;
    	for(MobileService service:services)
    		System.out.println(" "+(counter++)+". "+service.getServiceName());
    }//printMenuServices
    
    
    
    public MobileService getService(int index) //Epistrefei thn yphresia se mia sygkekrimenh 8esh ths listas
    {
    	return services.get(index);
    }//getService
    
    
    
    public MobileService getService(String name) //Epistrefei thn yphresia me sygkekrimeno onoma
    {
    	MobileService s=null;
    	for(MobileService service:services)
    	{
    		if(service.getServiceName().equals(name))
    		{
    			s=service;
    			break;
    		}
    	}
    	return s;
    	
    }//getService
    
    
    
    public void removeService(MobileService service) //Diagrafei mia sygkekrimenh yphresia
    {
    	services.remove(service);
    }//removeService
    
    
    
    public void removeService(int index) //Diagrafei mia sygkekrimenh yphresia
    {
    	services.remove(index);
    }//removeService
    
    
    
    public void clearServiceList() //Ka8arizei th lista yphresiwn
    {
    	services.clear();
    	System.out.println("Oi dia8esimes yphresies diagrafhkan.");
    }//clearServiceList
   
    
	    
	public void loadServices (String path)
	{
		//arxikopoihsh metavlitwn -->
		
		String temp_NAME = "-" ; 
		String temp_TYPE = "-" ;
		String temp_PAGIO = "-" ;
		String temp_f1 = "NOT FOUND" ;
		String temp_f2 = "NOT FOUND" ;
		String temp_f3 = "NOT FOUND";
		String temp_f4 = "NOT FOUND" ;
		String temp_f5 = "NOT FOUND" ;
		String temp_f6 = "NOT FOUND" ;
		String temp_f7 = "NOT FOUND" ;
		
		int f1 = 0 ;
		int f2 = 0 ;
		float f3 = 0.00f ;
		float f4 = 0.00f ;
		float f5 = 0.00f ;
		float f6 = 0.00f ;
		float f7 = 0.00f ;
		float pagio = 0.00f ;
	
	
		boolean checker_final = false ;
		boolean [] checker = new boolean [3] ;
		
		for (int y = 0 ; y <= 2 ; y++) 
		{
			checker[y] = false ;
		}//for
		
		File f = null;
		BufferedReader reader = null;
		String line;
		
		//reading tou arxeiou--->
		try 
		{
			f = new File(path);
		}//try
		catch (NullPointerException e) 
		{
			System.err.println("File not found.");
		}//catch
		
		try 
		{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		}//try
		catch (FileNotFoundException e)
		{
			System.err.println("Error opening file.");
		}//catch
		
		//---------------------->
		
		try
		{
			line = reader.readLine();
			if (!line.trim().equals(" "))
			{
	            if (line.trim().equals("SERVICE_LIST"))
				{
					line = reader.readLine();
					//Stamataei na eisagei teleiws ta services molis vrei kenh grammh\
					if (line.trim().equals("{"))
					{
						while (line !=null)
						{
							line = reader.readLine();
							if (line != null)
							{
								if (line.trim().equals("SERVICE"))
								{
									line = reader.readLine();
									if (line.trim().equals("{"))
									{
										while (!line.trim().equals("}"))
										{
											line = reader.readLine ();
											//Epeksergasia dedomenwn gia opoiadhpote yphresia.
											if (line.trim().startsWith("SERVICE_NAME "))
											{
												temp_NAME = line.trim().substring(13) ;
												checker [0] = true ;
											}//if										
											else if (line.trim().startsWith("TYPE "))
											{
												temp_TYPE = line.trim().substring(5) ;
												checker [1] = true ;
											}//else if
											else if (line.trim().startsWith("MONTHLY_PRICE "))
											{
												temp_PAGIO = line.trim().substring(14);
												checker [2] = true ;
											}//else if		//Epeksergasia dedomenwn gia programmata symbolaiou.
											else if (line.trim().startsWith("FREE_MINUTES ")) 
											{
												temp_f1=line.trim().substring(13);
											}//else if
											else if (line.trim().startsWith("FREE_SMS "))
											{
												temp_f2 = line.trim().substring(9);
											}//else if
											else if (line.trim().startsWith("TIME_CHARGE "))
											{
												temp_f3 =line.trim().substring(12);
											}//else if
											else if (line.trim().startsWith("SMS_CHARGE "))
											{
												temp_f4 = line.trim().substring(11);
											}//else if		//Epeksergasia dedomenwn gia programmata kinitou internet.
											else if (line.trim().startsWith("FREE_GB "))
											{
												temp_f5 = line.trim().substring(8);
											}//else if
											else if (line.trim().startsWith("MB_CHARGE "))
											{
												temp_f6 = line.trim().substring(10) ;
											}//else if		//Epeksergasia epipleon dedomenwn gia programmata kartokinitou
											else if (line.trim().startsWith("UNITS "))
											{
												temp_f7 = line.trim().substring(6);
											}//else if
										}//while
										
										checker_final = checker [0] == checker [1] == checker [2] == true ;
										
										if ( checker_final == false )
										{
											System.out.println(" Some vital information was missing. ");
										}//if
										else
										{
											//Edw prwta dhmiourgoume to antikeimeno programmatos symvolaiou/internet me tis 'temp' metavlites , kai meta to eisagoume sto telos ths listas MobilePlan/MobileInternet antoistixa. ----->
											if (temp_TYPE.equals("Programma symbolaiou"))
											{
												try
												{
													if (!temp_f1.equals("NOT FOUND"))
													{
														f1 = (Integer.parseInt(temp_f1))*60 ; //free secs
													}//if
													else
													{
														f1 = 0 ;
													}//else
													
													if(!temp_f2.equals("NOT FOUND"))
													{
														f2 = Integer.parseInt(temp_f2); //free sms
													}//if
													else 
													{
														f2 = 0 ;
													}//else
													if(!temp_f3.equals("NOT FOUND"))
													{
														f3 = Float.parseFloat(temp_f3); //time_charge
													}//if
													else
													{
														f3 = 0.006f ;
													}//else
													if(!temp_f4.equals("NOT FOUND"))
													{
														f4 = Float.parseFloat(temp_f4); //SMS_charge
													}//if
													else
													{
														f4 = 0.15f ;
													}//else
													
													pagio = Float.parseFloat(temp_PAGIO);
												}//try
												catch (NumberFormatException nfe)
												{
													System.out.println("NumberFormatException");
												}//catch
												
												MobilePlan temp_mp = new MobilePlan( f1, f2 , f3 , f4 , temp_NAME , pagio );
												this.services.add(temp_mp);
											}//if
											else if (temp_TYPE.equals("Mobile Internet"))
											{
												try
												{
													if(!temp_f5.equals("NOT FOUND"))
													{
														f5 = (Float.parseFloat(temp_f5))*1024 ;
													}//if
													else
													{
														f5 = 0.006f ;
													}//else
													
													if(!temp_f6.equals("NOT FOUND"))
													{
														f6 = Float.parseFloat(temp_f6) ;
													}//if
													else
													{
														f6 = 0.0f ;
													}//else
													
													pagio = Float.parseFloat(temp_PAGIO);
												}//try
												catch (NumberFormatException nfe)
												{
													System.err.println("NumberFormatException2");
												}//catch
												
												MobileInternet temp_mi = new MobileInternet ( f5 , f6 , temp_NAME , pagio );
												this.services.add(temp_mi);
											}//else if
											else if(temp_TYPE.equals("Kartosymbolaio"))
											{
												try
												{
													if(!temp_f7.equals("NOT FOUND"))
													{
														f7 = Float.parseFloat(temp_f7);
													}//if
													else
													{
														f7 = 2 ;
													}//else
													
													if (!temp_f1.equals("NOT FOUND"))
													{
														f1 =  (Integer.parseInt(temp_f1))*60;
													}//if
													else
													{
														f1 = 0 ;
													}//else
													
													if(!temp_f2.equals("NOT FOUND"))
													{
														f2 = Integer.parseInt(temp_f2);
													}//if
													else 
													{
														f2 = 0 ;
													}//else
													
													if(!temp_f3.equals("NOT FOUND"))
													{
														f3 = Float.parseFloat(temp_f3);
													}//if
													else
													{
														f3 = 0.006f ;
													}//else
													
													if(!temp_f4.equals("NOT FOUND"))
													{
														f4 = Float.parseFloat(temp_f4);
													}//if
													else
													{
														f4 = 0.15f ;
													}//else
													
													pagio = Float.parseFloat(temp_PAGIO);
												}
												catch (NumberFormatException nfe)
												{
													System.out.println("NumberFormatException");
												}//catch
												CostControlPlan temp_mk = new CostControlPlan( f7 , f1 , f2 , f3 , f4 , temp_NAME , pagio );
												this.services.add(temp_mk);
											}//else if
										}//else
										
										
										//reset twn timwn gia tin epomenh ekxwrhsh arxeiou ---->
										temp_NAME = "-" ; 
										temp_TYPE = "-" ;
										temp_PAGIO = "-" ;
										temp_f1 = "NOT FOUND" ;
										temp_f2 = "NOT FOUND" ;
										temp_f3 = "NOT FOUND";
										temp_f4 = "NOT FOUND" ;
										temp_f5 = "NOT FOUND" ;
										temp_f6 = "NOT FOUND" ;
										temp_f7 = "NOT FOUND" ;
										
										for (int y = 0 ; y <= 2 ; y++)
										{
											checker[y] = false ;
										}//for										
									}//if
								}//if
							}//if
						}//while
					}//if
				}//if
			}//if
		}//try
		catch (IOException e)
		{
			System.out.println(" Error: Sudden end . ");
	    }//catch
		
	    try
		{
	        reader.close();
	    }//try
		catch (IOException e)
		{
	        System.err.println("Error closing file.");
	    }//catch
	}//loadServices
		
	
	
	public void saveServices (String path) 
	{
		File f = null;
		BufferedWriter bw = null;
		float temp1 = 0.00f;
		int temp2 = 0;
	
		try
		{
			f = new File(path);
		}//try	
		catch (NullPointerException e)
		{
			System.err.println ("File not found.");
		}//catch
	
		try
		{
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		}//try
		catch (FileNotFoundException e)
		{
			System.err.println("Error opening file for writing!");
		}//catch
		
		String prologue = new String();
		prologue = "SERVICE_LIST"+"\n"+"{"  ;
		
		try
		{
			bw.write (prologue);
		}//try
		catch (IOException e)
		{
			System.err.println("Write error!");
		}//catch
		for (MobileService s:services)
		{
			
			String serviceInfo = new String();
			
			if (s instanceof MobilePlan)
			{
				temp2 = ((MobilePlan) s).getFreeTime();
				temp2 = temp2/60 ; //metatroph se minutes
				serviceInfo ="\n"+ "\t"+"SERVICE"+"\n"+"\t"+"{"+"\n"+"\t"+"\t"+"SERVICE_NAME"+ " " +s.getServiceName() + "\n"+"\t"+"\t"+ "TYPE" + " " + "Programma symbolaiou" +"\n"+"\t"+"\t" + "MONTHLY_PRICE" + " " +s.getMonthlyTarrif() +
				 "\n"+"\t"+"\t" + "FREE_MINUTES" + " " + temp2 + "\n" + "\t" + "\t" + "FREE_SMS" + " " + ((MobilePlan) s).getFreeSMS() + "\n" + "\t" + "\t" + "TIME_CHARGE" + " " + ((MobilePlan) s).getTalkTimeCharge() +
				 "\n"+"\t"+"\t" + "SMS_CHARGE" + " " + ((MobilePlan) s).getSMSCharge() + "\n" + "\t" + "}" ;
				
			}//if
			else if (s instanceof CostControlPlan)
			{
				temp2 = ((CostControlPlan)s).getFreeTime();
				temp2 = temp2/60 ; //metatroph se minutes
				
				serviceInfo ="\n"+ "\t"+"SERVICE"+"\n"+"\t"+"{"+"\n"+"\t"+"\t"+"SERVICE_NAME"+ " " +s.getServiceName() + "\n"+"\t"+"\t"+ "TYPE" + " " + "Kartosymbolaio" +"\n"+"\t"+"\t" + "MONTHLY_PRICE" + " " +s.getMonthlyTarrif() +
				"\n"+"\t"+"\t" + "FREE_MINUTES" + " " + temp2 + "\n" + "\t" + "\t" + "FREE_SMS" + " " + ((CostControlPlan)s).getFreeSMS() + "\n" + "\t" + "\t" + "TIME_CHARGE" + " " + ((CostControlPlan)s).getTalkTimeCharge() +
				"\n"+"\t"+"\t" + "SMS_CHARGE" + " " + ((CostControlPlan)s).getSMSCharge() + "UNITS" + " " + ((CostControlPlan)s).getRemainingUnits() + "\n" + "\t" + "}" ;
				
			}//else if
			else if (s instanceof MobileInternet)
			{
				temp1 = ((MobileInternet) s).getFreeDataVolume();
				temp1 = temp2/1024 ; //metatroph se GB
				
				serviceInfo ="\n"+ "\t"+"SERVICE"+"\n"+"\t"+"{"+"\n"+"\t"+"\t"+"SERVICE_NAME"+ " " +s.getServiceName() + "\n"+"\t"+"\t"+ "TYPE" + " " + "Mobile Internet" +"\n"+"\t"+"\t" + "MONTHLY_PRICE" + " " +s.getMonthlyTarrif() +
				"\n"+"\t"+"\t"+"FREE_GB" + " " + temp1 + "\n"+"\t"+"\t" + "MB_CHARGE" + " " +((MobileInternet) s).getSurfingCharge() + "\n"+"\t" + "}" ;
			}//else if
			
			try
			{
				bw.write(serviceInfo);
			}//try
			catch (IOException e)
			{
				System.err.println("Write error!");
			}//catch
		}//for
		
		String epilogue = new String();
		epilogue = "\n"+"}" ;
		
		try
		{
			bw.write (epilogue);
		}//try
		catch (IOException e)
		{
			System.err.println("Write error!");
		}//catch
	
		try
		{
			bw.close();
		}//try
		catch (IOException e)
		{	
			System.err.println("Error closing file.");
		}//catch			
	}//saveServices
}//ServiceList
