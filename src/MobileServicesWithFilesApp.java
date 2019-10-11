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

import java.util.Date;
import java.util.Scanner;
import Contract.*;
import Lists.*;
import MobileServices.*;

public class MobileServicesWithFilesApp
{
	public static void main(String args[])
	{	
		ServiceList availableServices = new ServiceList(); //Dhmiourgia ths listas gia tis dia8esimes yphresies
		ContractList mobileContracts = new ContractList(); //Dhmiourgia ths listas gia ta energa symbolaia
		
		availableServices.loadServices("Services.txt");
		mobileContracts.loadContracts("Contracts.txt", availableServices);
		
		String line = "---------------------------------------";
		String prompt = " > ";
        Scanner in = new Scanner(System.in);
        boolean done = false;
        String answer;
        while (!done)
        {
        	System.out.printf("%n%s%n%30s%n%s%n", line, "Mobile services menu", line);
            System.out.println(" 1. Emfanish dia8esimwn yphresiwn");
            System.out.println(" 2. Dhmiourgia neou symbolaiou");
            System.out.println(" 3. Emfanish energwn symbolaiwn");
            System.out.println(" 4. Enhmerwsh statistikwn symbolaiou");
            System.out.println(" 5. Mhniaio kostos h dia8esimo ypoloipo");
            System.out.println(" 0. exit");
            System.out.println(line);
            System.out.print(prompt);
            answer = in.nextLine();
            
            if(answer.equals("1"))
            {
                System.out.printf("%n%24s %d", "Dia8esimes yphresies:", availableServices.numberOfServices());
                availableServices.printServices();
            }
            else if(answer.equals("2"))
            {
            	System.out.println("Dhmiourgia neou symbolaiou");
            	System.out.println(line);
				System.out.println("Epilekste yphresia:");
				availableServices.printMenuServices();
				System.out.println(line);
				System.out.print(prompt);
				int choice = Integer.parseInt(in.nextLine());
				
				if(choice <= availableServices.numberOfServices())
				{
					MobileService ms = availableServices.getService(choice-1);
					System.out.println("Onomatepwnymo:");
					System.out.print(prompt);
					String name = in.nextLine();
					System.out.println("Ari8mos kinhtou thlefwnou:");
					System.out.print(prompt);
					String phone = in.nextLine();
					System.out.println("Tropos plhrwmhs:");
					System.out.print(prompt);
					String payment = in.nextLine();
					System.out.println("Epipleon ekptwsh?(0-100%):");
					System.out.print(prompt);
					float discount = (Float.parseFloat(in.nextLine()))/100;
					if (ms instanceof MobileInternet)
					{
						Contract<InternetStats> c = new Contract<InternetStats>(ms,name,phone,payment,discount, new InternetStats(),new Date());
						mobileContracts.addContract(c);
						System.out.println("Dhmiourgh8hke neo symbolaio me kwdiko "+c.getContractID());
						System.out.println(c.toString());
					}//if
					else
					{
						Contract<MobilePlanStats> c = new Contract<MobilePlanStats>(ms,name,phone,payment,discount, new MobilePlanStats(),new Date());
						mobileContracts.addContract(c);
						System.out.println("Dhmiourgh8hke neo symbolaio me kwdiko "+c.getContractID());
						System.out.println(c.toString());
					}//else
				}//if
				else
				{
					System.out.println("La8os epilogh");
				}//else
            }
            else if(answer.equals("3"))
            {
            	System.out.println(" Epilekste typo yphresias:");
            	System.out.println(" 1. Programma symbolaiou");
                System.out.println(" 2. Kartosymbolaio");
                System.out.println(" 3. Mobile internet");
                System.out.println(line);
				System.out.print(prompt);
				int choice = Integer.parseInt(in.nextLine());
				if(choice == 1 || choice == 2 || choice == 3)
				{
					mobileContracts.printContracts(choice);	
				}//if
				else
					System.out.println("Lo8os epilogh!");
            }//else if
            else if(answer.equals("4"))
            {
            	System.out.printf("%n%30s%n",line, "Eisagwgh mhniaiwn statistikwn", line);
            	mobileContracts.printContracts();	
            	System.out.println("Eisagete ton kwdiko symbolaiou:");
            	System.out.print(prompt);
            	int choice = Integer.parseInt(in.nextLine());
            	if (mobileContracts.getContract(choice-1).getStatistics() instanceof InternetStats)
            	{
            		System.out.println("Ogkos dedomenwn(se MB):");
            		System.out.print(prompt);
                	float ch = Float.parseFloat(in.nextLine());
            		((InternetStats) mobileContracts.getContract(choice-1).getStatistics()).setDataVolume(ch);
            		System.out.println("Ta mhniaia statistika enhmerw8hkan!");
            	}//if
            	else
            	{
            		System.out.println( "Xronos omilias se kinhta diktya(se sec):");
            		System.out.print(prompt);
                	int ch = Integer.parseInt(in.nextLine());
                	((MobilePlanStats) mobileContracts.getContract(choice-1).getStatistics()).setTimeToMobileNetworks(ch);
                	System.out.println( "Xronos omilias se sta8era diktya(se sec):");
            		System.out.print(prompt);
                	ch = Integer.parseInt(in.nextLine());
                	((MobilePlanStats) mobileContracts.getContract(choice-1).getStatistics()).setTimeToNationalFixed(ch);
                	System.out.println( "Ari8mos apestalmenwn SMS:");
            		System.out.print(prompt);
                	ch = Integer.parseInt(in.nextLine());
            		((MobilePlanStats) mobileContracts.getContract(choice-1).getStatistics()).setNumberOfSMS(ch);
            		System.out.println("Ta mhniaia statistika enhmerw8hkan!");
            	}//else
            }//else if
            else if(answer.equals("5"))
            {
            	System.out.println(" Epilekste:");
                System.out.println(" 1. Sygkekrimeno symbolaio");
                System.out.println(" 2. Symbolaia idiou typou");
                System.out.println(line);
				System.out.print(prompt);
				int choice = Integer.parseInt(in.nextLine());
				if (choice == 1)
				{
					mobileContracts.printContracts();	
	            	System.out.println("Eisagete ton kwdiko symbolaiou:");
	            	System.out.print(prompt);
	            	choice = Integer.parseInt(in.nextLine());
	            	if (mobileContracts.getContract(choice-1).getService() instanceof CostControlPlan)
	            	{
	            		System.out.println("Mhniaio dia8esimo ypoloipo:");
	            		System.out.printf("%.2f%s", mobileContracts.getContract(choice-1).totalCostOrUnits(),"\u20AC");
	            	}//if
	            	else
	            	{
	            		System.out.println("Mhniaio kostos:");
	            		System.out.printf("%.2f%s", mobileContracts.getContract(choice-1).totalCostOrUnits(),"\u20AC");
	            	}//else
				}//if
				else if (choice == 2)
				{
					System.out.println(" Epilekste typo yphresias:");
	            	System.out.println(" 1. Programma symbolaiou");
	                System.out.println(" 2. Kartosymbolaio");
	                System.out.println(" 3. Mobile internet");
	                System.out.println(line);
					System.out.print(prompt);
					int ch = Integer.parseInt(in.nextLine());
					if(ch == 1 || ch == 2 || ch == 3)
					{
						if(ch == 2)
							System.out.println("Mhniaio dia8esimo ypoloipo gia ola ta kartosymbolaia:");
						else if(ch == 3)
							System.out.println("Mhniaio kostos gia ola ta Mobile Internet:");
						else if(ch == 1)
							System.out.println("Mhniaio kostos gia ola ta programmata symbolaiou:");
					
						System.out.printf("%.2f%s",mobileContracts.totalCostOrUnits(ch),"\u20AC");
					}//if
					else
						System.out.println("Lo8os epilogh!");
				}//else if
				else
					System.out.println("Lo8os epilogh!");
            }//else if
            else if(answer.equals("0"))
            {
            	availableServices.saveServices("Services.txt");
            	mobileContracts.saveContracts("Contracts.txt");
                done = true;
                
            }//else if
            else
            	System.out.println("Parakalw eisagete mia apo tis epiloges pou parexei to menu!\n");
        }//while
        in.close();
	}//main
}//MobileServicesApp

