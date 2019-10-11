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
import java.text.*;
import java.util.*;
import Contract.*;
import MobileServices.*;

public class ContractList 
{
	//Instance metablhtes
	private ArrayList<Contract<? extends Statistics>> contracts = new ArrayList<Contract<? extends Statistics>>(); //Mia ArrayList gia ta energa symbolaia(h parametros mporei na einai eite MobilePlanStats eite InternetStats
	
	
	//Constructors
	public ContractList()
	{
		
	}//ContractList()
	
	
	
	public void addContract(Contract<? extends Statistics> contract) //Pros8etei ena symbolaio sth lista
	{
		contracts.add(contract);
	}//addContract
	
	
	
	public int numberOfContracts() //Epistrefei to plh8os twn energwn symbolaiwn
	{
		return contracts.size();
	}//numberOfContracts()
	
	
	
	public void printContracts() //Emfanizei ola ta energa symbolaia
	{
		System.out.printf("%n%30s%n", "---------------------------------------", "Energa symbolaia","---------------------------------------");
		for(Contract<? extends Statistics> contract:contracts)
    		System.out.println(contract.toString());
	}//printContracts()
	
	
	
	public void printContracts(int type) //Emfanizei ta ererga symbolaia gia sygkekrimeno typo yphresias
	{
		if (type == 1)
		{
			for(Contract<? extends Statistics> contract:contracts)
			{
				if ((contract.getService() instanceof MobileServices.MobilePlan) && !(contract.getService() instanceof MobileServices.CostControlPlan))
					System.out.println(contract.toString());	
			}//for
		}//if
		else if(type == 2)
		{
			for(Contract<? extends Statistics> contract:contracts)
			{
				if (contract.getService() instanceof MobileServices.CostControlPlan)
					System.out.println(contract.toString());
			}//for
		}//else if
		else
		{
			for(Contract<? extends Statistics> contract:contracts)
			{
			if (contract.getService() instanceof MobileServices.MobileInternet)
				System.out.println(contract.toString());
			}//for
		}//else
	}//printContracts
	
	
	
	public float totalCostOrUnits(int type) //Ypologismos mhniaiou kostous h dia8esimou ypoloipou gia sygkekrimeno typo symbolaiwn
	{
		float cost = 0.0f;
		
		if (type == 1)
		{
			for(Contract<? extends Statistics> contract:contracts)
			{
				if ((contract.getService() instanceof MobileServices.MobilePlan) && !(contract.getService() instanceof MobileServices.CostControlPlan))
					cost += contract.totalCostOrUnits();
			}//for
		}//if
		else if(type == 2)
		{
			for(Contract<? extends Statistics> contract:contracts)
			{
				if (contract.getService() instanceof MobileServices.CostControlPlan)
					cost += contract.totalCostOrUnits();
			}//for
		}//else if
		else
		{
			for(Contract<? extends Statistics> contract:contracts)
			{
				if (contract.getService() instanceof MobileServices.MobileInternet)
					cost += contract.totalCostOrUnits();
			}//for
		}//else
		return cost;
	}//totalCostOrUnits
	
	
	
	public Contract<? extends Statistics> getContract(int index) //Epistrefei ena symbolaio se sygkekrimenh 8esh sth lista
	{
		return contracts.get(index);
	}
	
	
	
	public Contract<? extends Statistics> getContract(String name) //Epistrefei ena symbolaio gia sygkekrimeno pelath
	{
		Contract<? extends Statistics> c=null;
		for(Contract<? extends Statistics> contract:contracts)
		{
			
			if (contract.getName().equals(name))
			{
				c = contract;
				break;
			}//if
		}
		return c;
	}
	
	
	
	public void removeContract(Contract<? extends Statistics> contract) //Diagrafei ena sygkekrimeno symbolaio
	{
		contracts.remove(contract);
	}
	
	
	
	public void loadContracts (String path, ServiceList list)
	{
		//arxikopoihsh metavlitwn -->
		
		String temp_NAME = "-" ; 
		String temp_TYPE = "-" ;
		String temp_CONTRACT_NUMBER = "-" ;
		String temp_CUSTOMER = "-" ;
		String temp_PHONE_NUMBER = "-" ;
		String temp_ACTIVATION_DATE = "-" ;
		String temp_f1 = "NOT FOUND" ;
		String temp_f2 = "NOT FOUND" ;
		String temp_f3 = "NOT FOUND";
		String temp_f4 = "NOT FOUND" ;
		String temp_f5 = "NOT FOUND" ;
		String temp_f6 = "NOT FOUND" ;
		
		String f1 = "" ;
		float f2 = 0.0f;
		int f3 = 0;
		int f4 = 0;
		int f5 = 0;
		float f6 = 0.00f ;
		MobileService temp_ms = null;

		boolean checker_final = false ;
		boolean [] checker = new boolean [6] ;
		
		for (int y = 0 ; y <= 5 ; y++) 
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
			System.err.println("De bre8hke to arxeio!");
		}//catch
		
		try 
		{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		}//try
		catch (FileNotFoundException e)
		{
			System.err.println("Synebh sfalma kata to anoigma tou arxeiou!");
		}//catch
		
		try
		{
			line = reader.readLine();
			if (!line.trim().equals(" "))
			{
	            if (line.trim().equals("CONTRACT_LIST"))
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
								if (line.trim().equals("CONTRACT"))
								{
									line = reader.readLine();

									if (line.trim().equals("{"))
									{
										outer:
										while (!line.trim().equals("}"))
										{
											line = reader.readLine ();

											if (line.trim().startsWith("SERVICE_NAME "))
											{
												temp_NAME = line.trim().substring(13) ;
												checker[0] = true ;

												for(int i=0;i<list.numberOfServices();i++)
												{
													if (temp_NAME.equals(list.getService(i).getServiceName()))
													{
														temp_ms = list.getService(i);
														break;
													}//if
												}//for
												if(temp_ms == null)
												{
													System.out.println("Den einai dia8esimh ayth h yphresia. To symbolaio agnoeitai.");
													break outer;
												}//if
											}//if										
											else if (line.trim().startsWith("CONTRACT_NUMBER "))
											{
												temp_CONTRACT_NUMBER = line.trim().substring(16) ;
												checker [1] = true ;

											}
											else if (line.trim().startsWith("CUSTOMER "))
											{
												temp_CUSTOMER = line.trim().substring(9);
												checker [2] = true ;

											}//else if		
											else if (line.trim().startsWith("TYPE "))
											{
												temp_TYPE = line.trim().substring(5) ;
												checker [3] = true ;

											}//else if
											else if (line.trim().startsWith("PHONE_NUMBER "))
											{
												temp_PHONE_NUMBER = line.trim().substring(13) ;
												checker [4] = true ;

											}//else if
											else if (line.trim().startsWith("ACTIVATION_DATE "))
											{
												temp_ACTIVATION_DATE = line.trim().substring(16) ;
												checker [5] = true ;

											}//else if
											else if (line.trim().startsWith("PAYMENT ")) 
											{
												temp_f1=line.trim().substring(8);

											}//else if
											else if (line.trim().startsWith("DISCOUNT "))
											{
												temp_f2 = line.trim().substring(9);

											}//else if
											else if (line.trim().equals("MONTHLY_USAGE"))
											{
												line = reader.readLine();

												if (line.trim().equals("{"))
												{
													while (!line.trim().equals("}"))
													{
														line = reader.readLine ();

														if (line.trim().startsWith("MOBILE "))
														{
															temp_f3 =line.trim().substring(7);

														}//if
														else if (line.trim().startsWith("FIXED "))
														{
															temp_f4 = line.trim().substring(6);

														}//else if
														else if (line.trim().startsWith("SMS "))
														{
															temp_f5 = line.trim().substring(4) ;

														}//else if
														else if (line.trim().startsWith("DATA "))
														{
															temp_f6 = line.trim().substring(5);

														}//else if
													}//while
												}//if
											}//else if
										}//while
									
										checker_final = checker [0] == checker [1] == checker [2] == checker [3] == checker [4] == checker [5] == true ;
										
										if ( checker_final == false )
										{
											System.out.println(" Some vital information was missing. ");
										}//if
										else
										{
											try
											{
												if (!temp_f1.equals("NOT FOUND"))
												{
													f1 = temp_f1; //PAYMENT

												}//if
												else
												{
													f1 = "Metrhta(se katasthma)" ;
												}//else
												
												if(!temp_f2.equals("NOT FOUND"))
												{
													f2 = (Float.parseFloat(temp_f2))/100; //DISCOUNT


												}//if
												else 
												{
													f2 = 0.0f ;
												}//else
												
												if(!temp_f3.equals("NOT FOUND"))
												{
													f3 = Integer.parseInt(temp_f3); //MOBILE

												}//if
												else
												{
													f3 = 0 ;
												}//else
												
												if(!temp_f4.equals("NOT FOUND"))
												{
													f4 = Integer.parseInt(temp_f4); //FIXED

												}//if
												else
												{
													f4 = 0 ;
												}//else
												
												if(!temp_f5.equals("NOT FOUND"))
												{
													f5 = Integer.parseInt(temp_f5); //SMS


												}//if
												else
												{
													f5 = 0;
												}//else
												
												if(!temp_f6.equals("NOT FOUND"))
												{
													f6 = Float.parseFloat(temp_f6); //DATA


												}//if
												else
												{
													f6 = 0.0f ;
												}//else
												
												
											}//try
											catch (NumberFormatException nfe)
											{
												System.out.println("NumberFormatException");
											}//catch
											
											Date d = new Date();
											
											if(temp_ACTIVATION_DATE != null)
											{
												try 
												{
													d = new SimpleDateFormat("dd/MM/yyyy").parse(temp_ACTIVATION_DATE);
												}//try
												catch (ParseException e) 
												{
													e.printStackTrace();
												}//catch
											}//if
											
											if (temp_TYPE.equals("Mobile Internet"))
											{
												Contract<InternetStats> temp_contract = new  Contract<InternetStats>( temp_ms, temp_CUSTOMER, temp_PHONE_NUMBER, f1, f2 , new InternetStats(f6), d );
												temp_contract.setContractID(Integer.parseInt(temp_CONTRACT_NUMBER));
													this.contracts.add(temp_contract);
												
											}//if
											else if((temp_TYPE.equals("Programma symbolaiou")) || (temp_TYPE.equals("Kartosymbolaio")))
											{
												 Contract<MobilePlanStats> temp_contract = new  Contract<MobilePlanStats>( temp_ms, temp_CUSTOMER, temp_PHONE_NUMBER, f1, f2 , new MobilePlanStats(f3, f4, f5) , d);
												 temp_contract.setContractID(Integer.parseInt(temp_CONTRACT_NUMBER));
											 	 this.contracts.add(temp_contract);
											}//else if
										}//else
										
										//reset twn timwn gia tin epomenh ekxwrhsh arxeiou ---->
										temp_NAME = "-" ; 
										temp_TYPE = "-" ;
										temp_CONTRACT_NUMBER = "-" ;
										temp_CUSTOMER = "-" ;
										temp_PHONE_NUMBER = "-" ;
										temp_ACTIVATION_DATE = "-" ;
										temp_f1 = "NOT FOUND" ;
										temp_f2 = "NOT FOUND" ;
										temp_f3 = "NOT FOUND";
										temp_f4 = "NOT FOUND" ;
										temp_f5 = "NOT FOUND" ;
										temp_f6 = "NOT FOUND" ;
										
										for (int y = 0 ; y <= 5 ; y++)
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
			System.out.println("Sfalma!");
	    }//catch
		
	    try
		{
	        reader.close();
	    }//try
		catch (IOException e)
		{
	        System.err.println("Sfalma kata to kleisimo!");
	    }//catch
	}//loadContracts

	
	
	public void saveContracts (String path) 
	{
		File f = null;
		BufferedWriter bw = null;

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
		prologue = "CONTRACT_LIST"+"\n"+"{" ;
		
		try
		{
			bw.write (prologue);
		}//try
		catch (IOException e)
		{
			System.err.println("Write error!");
		}//catch
		
		for ( Contract<? extends Statistics> c:contracts)
		{
			
			String contractInfo = new String();
			
			if (c.getStatistics() instanceof MobilePlanStats)
			{
				contractInfo ="\n"+ "\t"+"CONTRACT"+"\n"+"\t"+"{"+"\n" + "\t" + "\t" +"CONTRACT_NUMBER"+ " " +c.getContractID() + "\n"+"\t"+"\t"+ "SERVICE_NAME" + " " + c.getService().getServiceName() +"\n"+"\t"+"\t" + "TYPE" + " " + c.getService().getProgramType() +
				 "\n"+"\t"+"\t" + "CUSTOMER" + " " + c.getName() + "\n" + "\t" + "\t" + "PHONE_NUMBER" + " " + c.getMobileNumber() + "\n" + "\t" + "\t" + "ACTIVATION_DATE" + " " + c.getActivationDate() +
				 "\n"+"\t"+"\t" + "DISCOUNT" + " " + c.getAdditionalDiscount() + "\n" + "\t" + "\t" + "MONTHLY_USAGE"+ "\n" + "\t" + "\t" + "{" +"\n"+ "\t" + "\t" + "\t" + "MOBILE" + " " + ((MobilePlanStats)(c.getStatistics())).getTimeToMobileNetworks() + "\n" + "\t" + "\t" + "\t"  + "FIXED" + " " + ((MobilePlanStats)(c.getStatistics())).getTimeToNationalFixed() + "\n" + "\t" + "\t" + "\t"  + "SMS" + " " + ((MobilePlanStats)(c.getStatistics())).getNumberOfSMS() + "\n" + "\t" + "\t" + "}" + "\n" + "\t" +"}" ;
			}//if
			else if (c.getStatistics() instanceof InternetStats)
			{
				contractInfo ="\n"+"\t"+"CONTRACT"+"\n"+"\t"+"{"+"\n" + "\t" + "\t" +"CONTRACT_NUMBER"+ " " +c.getContractID() + "\n"+"\t"+"\t"+ "SERVICE_NAME" + " " + c.getService().getServiceName() +"\n"+"\t"+"\t" + "TYPE" + " " + c.getService().getProgramType() +
				 "\n"+"\t"+"\t" + "CUSTOMER" + " " + c.getName() + "\n" + "\t" + "\t" + "PHONE_NUMBER" + " " + c.getMobileNumber() + "\n" + "\t" + "\t" + "ACTIVATION_DATE" + " " + c.getActivationDate() +
				 "\n"+"\t"+"\t" + "DISCOUNT" + " " + c.getAdditionalDiscount() + "\n" + "\t" + "\t" + "MONTHLY_USAGE"+ "\n" + "\t" + "\t" + "{" +"\n"+ "\t" + "\t" + "\t"  + "DATA" + " " + ((InternetStats)(c.getStatistics())).getDataVolume() + "\n" + "\t" + "\t" + "}" + "\n" + "\t" +"}" ;
			}//else if
			
			try
			{
				bw.write(contractInfo);
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
		
	}//saveContracts
}//ContractList
