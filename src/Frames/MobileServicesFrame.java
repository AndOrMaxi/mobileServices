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

package Frames;

import java.util.*;
import Contract.*;
import Lists.*;
import MobileServices.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;


public class MobileServicesFrame extends JFrame implements ActionListener, MouseListener 
{
	//menu components
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem loadServices;
	private JMenuItem loadContracts;
	private JMenuItem saveContracts;
	
	//tabs container
	private JTabbedPane tabs;
	
	//tab1 components
	private JPanel services;
	private JToolBar barServices;
	private JButton mobilePlan1;
	private JButton costControl1;
	private JButton mobileInternet1;
	private JPanel servicesContents;
	private JScrollPane scroll1;
	private JList listServices;
	private DefaultListModel listModel1;
	private JScrollPane scroll2;
	private JTextArea serviceDetails;
	
	//tab2 components
	private JPanel contracts;
	private JToolBar barContracts;
	private JButton all;
	private JButton mobilePlan2;
	private JButton costControl2;
	private JButton mobileInternet2;
	private JPanel contractsContents;
	private JScrollPane scroll3;
	private JList listContracts;
	private DefaultListModel listModel2;
	private JScrollPane scroll4;
	private JTextArea contractDetails;
	
	//static fields
	protected static ServiceList availableServices = new ServiceList(); //Dhmiourgia ths listas gia tis dia8esimes yphresies
	protected static ContractList mobileContracts = new ContractList(); //Dhmiourgia ths listas gia ta energa symbolaia


	public MobileServicesFrame()
	{
		setTitle("Κινητή τηλεφωνία");
		drawFrame();
		loadServices.addActionListener(this);
		loadContracts.addActionListener(this);
		saveContracts.addActionListener(this);
		mobilePlan1.addMouseListener(this);
		costControl1.addMouseListener(this);
		mobileInternet1.addMouseListener(this);
		all.addMouseListener(this);
		mobilePlan2.addMouseListener(this);
		costControl2.addMouseListener(this);
		mobileInternet2.addMouseListener(this);
		listServices.addMouseListener(this);
		listContracts.addMouseListener(this);
		setResizable(false); 
		setVisible(true);
	}//MobileServicesFrame
	
    
    
    public void actionPerformed(ActionEvent e) 
	{
    	
    	if (e.getSource() == loadServices)//Otan path8ei sto menu to anoigma dia8esimwn yphresiwn
		{
    		if(availableServices.numberOfServices() == 0)
    		{
    			JFileChooser ch = new JFileChooser();
    			ch.setCurrentDirectory(new File("."));
    			ch.setFileSelectionMode(JFileChooser.FILES_ONLY);
    			ch.showOpenDialog(null);
    			File file = ch.getSelectedFile();
    			
	    		availableServices.loadServices(file.getAbsolutePath());
	    		for (int i=0; i <availableServices.numberOfServices();i++)
	    		{
	    			listModel1.addElement(availableServices.getService(i).getServiceName());
	    			
	    		}//for
    		}//if
		}//if
    	else if (e.getSource() == loadContracts)//Otan path8ei sto menu to anoigma energwn symbolaiwn
		{
    		if(mobileContracts.numberOfContracts() == 0)
    		{

    			JFileChooser ch = new JFileChooser();
    			ch.setCurrentDirectory(new File("."));
    			ch.setFileSelectionMode(JFileChooser.FILES_ONLY);
    			ch.showOpenDialog(null);
    			File file = ch.getSelectedFile();
	    		mobileContracts.loadContracts(file.getAbsolutePath(), availableServices);  
	    		for (int i=0; i <mobileContracts.numberOfContracts();i++)
	    		{
	    			listModel2.addElement(mobileContracts.getContract(i).getName());
	    		}//for	    		
    		}//if
		}//else if
    	else if (e.getSource() == saveContracts)//Otan path8ei sto menu h apo8hkeysh energwn symbolaiwn
		{
    		if(mobileContracts.numberOfContracts() != 0)
    		{
	    		mobileContracts.saveContracts("Contracts.txt"); 
	    		JOptionPane.showMessageDialog(this,"Η αποθήκευση ολοκληρώθηκε!","Επιβεβαίωση", JOptionPane.INFORMATION_MESSAGE);
			
    		}//if
		}//else if
	}//actionPerformed
    
    
    
    public void mouseClicked(MouseEvent e) 
	{
    	if (e.getSource() == mobilePlan1)//diplo klik sto "Symbolaia kinhths" tou tab "Dia8esimes yphresies" 
		{
    		 if (e.getClickCount() == 2)
    		 {
    			 listModel1.clear();
    			for (int i=0; i <availableServices.numberOfServices();i++)
    			{
    				if ((availableServices.getService(i) instanceof MobilePlan) && !(availableServices.getService(i) instanceof CostControlPlan))
    				{
    					listModel1.addElement(availableServices.getService(i).getServiceName());
    				}//if
    			}//for
    		}//if
		}//if
    	else if (e.getSource() == costControl1)//diplo klik sto "Kartosymbolaia" tou tab "Dia8esimes yphresies"
		{
    		if (e.getClickCount() == 2)
    		{
   			 	listModel1.clear();
    			for (int i=0; i <availableServices.numberOfServices();i++)
    			{
    				if (availableServices.getService(i) instanceof CostControlPlan)
    				{
    					listModel1.addElement(availableServices.getService(i).getServiceName());
    				}//if
    			}//for
    		}//if
		}//else if
    	else if (e.getSource() == mobileInternet1)//diplo klik sto "Mobile Internet" tou tab "Dia8esimes yphresies"
		{
    		if (e.getClickCount() == 2)
    		{
   			 	listModel1.clear();
    			for (int i=0; i <availableServices.numberOfServices();i++)
    			{
    				if (availableServices.getService(i) instanceof MobileInternet)
    				{
    					listModel1.addElement(availableServices.getService(i).getServiceName());
    				}//if
    			}//for
    		}//if
		}//else if    	
    	else if (e.getSource() == all)//diplo klik sto "Ola" tou tab "Energa symbolaia"
		{
    		if (e.getClickCount() == 2)
				{
    			listModel2.clear();
    			for (int i=0; i <mobileContracts.numberOfContracts();i++)
    			{
    				listModel2.addElement(mobileContracts.getContract(i).getName());
    			}//for
    		}//if
		}//else if
    	else if (e.getSource() == mobilePlan2)//diplo klik sto "Symbolaia kinhths" tou tab "Energa symbolaia"
		{
    		if (e.getClickCount() == 2)
    		{
    			listModel2.clear();
    			for (int i=0; i <mobileContracts.numberOfContracts();i++)
    			{
    				//System.out.println("Yes "+mobileContracts.getContract(i).getService().getServiceName());
    				if ((mobileContracts.getContract(i).getService() instanceof MobilePlan) && !(mobileContracts.getContract(i).getService() instanceof CostControlPlan))
    				{
    					//System.out.println("Yes "+mobileContracts.getContract(i).getService().getServiceName());
    					listModel2.addElement(mobileContracts.getContract(i).getName());
    				}//if
    			}//for
    		}//if
		}//else if
    	else if (e.getSource() == costControl2)//diplo klik sto "Kartosymbolaia" tou tab "Energa symbolaia"
		{
    		if (e.getClickCount() == 2)
    		{
    			listModel2.clear();
	    		for (int i=0; i <mobileContracts.numberOfContracts();i++)
	    		{
	    			if (mobileContracts.getContract(i).getService() instanceof CostControlPlan)
	    			{
	    				listModel2.addElement(mobileContracts.getContract(i).getName());
	    			}//if
	    			
	    		}//for
    		}//if
		}//else if
    	else if (e.getSource() == mobileInternet2)//diplo klik sto "Mobile Internet tou tab "Energa symbolaia"
		{
    		if (e.getClickCount() == 2)
    		{
    			listModel2.clear();
	        	for (int i=0; i <mobileContracts.numberOfContracts();i++)
	        	{
	        		if (mobileContracts.getContract(i).getService() instanceof MobileInternet)
	        		{
	        			listModel2.addElement(mobileContracts.getContract(i).getName());
	        		}//if
	        	}//for
    		}//if
		}//else if
    	else if (e.getSource() == listContracts)//klik sth lista symbolaiwn
		{
    		String sel=(String)listContracts.getSelectedValue();
    		
    		if(e.getClickCount() == 2) //diplo
    		{
    			new ContractFrame(mobileContracts.getContract(sel));
    	    }//if
    		else if(e.getClickCount() == 1 ) //mono
    		{
	    	     String outputText =  mobileContracts.getContract(sel).getService().getProgramType()+" "+ mobileContracts.getContract(sel).getService().getServiceName()+"\n"+mobileContracts.getContract(sel).getMobileNumber();
	    	     contractDetails.setText(outputText);    	   
    		}//else if
		}//else if
    	else if (e.getSource() == listServices)//klik sth lista yphresiwn
    	{
    		String sel=(String)listServices.getSelectedValue();
    		
    	   if(e.getClickCount () == 2) //diplo
    	   {
    	     new ServiceFrame(availableServices.getService(sel));
    	   }//if
    	   else if (e.getClickCount() == 1 ) //mono
    	   {
				String outputText = availableServices.getService(sel).getProgramType()+"\n"+"Pagio: "+availableServices.getService(sel).getMonthlyTarrif()+"\u20AC";
				serviceDetails.setText(outputText);    	  
    	   }//else if
    	}//else if

	}//mouseClicked
    
    
    
    public void mouseExited(MouseEvent event)
	{
		
	}//mouseExited
	
    
    
	public void mouseEntered(MouseEvent event)
	{
		
	}//mouseEntered
	
	
	
	public void mouseReleased(MouseEvent event)
	{
		
	}//mouseReleased
	
	
	
	public void mousePressed(MouseEvent event)
	{
		
	}//mousePressed
	
	
	
	private void drawFrame()//sexdiash kyriou para8yrou efarmoghs
	{

		setBounds(300, 300, 150, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon mp = new ImageIcon("Images/1.png");
		ImageIcon ccp = new ImageIcon("Images/2.png");
		ImageIcon mi = new ImageIcon("Images/3.png");
		
		
		menu = new JMenu("Αρχείο");
		menuBar = new JMenuBar();
		loadServices = new JMenuItem("’νοιγμα διαθέσιμων υπηρεσιών");
		loadContracts = new JMenuItem("’νοιγμα ενεργών συμβολαίων");
		saveContracts = new JMenuItem("Αποθήκευση ενεργών συμβολαίων");
		menu.add(loadServices);
		menu.add(loadContracts);
		menu.addSeparator();
		menu.add(saveContracts);
		menuBar.add(menu);
		
		
		tabs = new JTabbedPane();
		
		services = new JPanel();
		
		services.setLayout(new BorderLayout());
		
		barServices = new JToolBar();
		barServices.setLayout(new BorderLayout());
		mobilePlan1 = new JButton("  Συμβόλαια Κινητής",mp);
		mobilePlan1.setPreferredSize(new Dimension(160, 40));
		costControl1 = new JButton("  Καρτοσυμβόλαια",ccp);
		mobileInternet1 = new JButton("  Mobile Internet",mi);
		mobileInternet1.setPreferredSize(new Dimension(150, 40));
		barServices.add(mobilePlan1,BorderLayout.WEST);
		barServices.add(costControl1, BorderLayout.CENTER);
		barServices.add(mobileInternet1, BorderLayout.EAST);
		barServices.setFloatable(false);
		
		servicesContents = new JPanel();
		
		servicesContents.setLayout(new BoxLayout(servicesContents, BoxLayout.X_AXIS));
		listModel1 = new DefaultListModel();
		for (int i=0; i <availableServices.numberOfServices();i++)
		{
			listModel1.addElement(availableServices.getService(i).getServiceName());
		}
		listServices = new JList(listModel1);
		listServices.setSelectedIndex(0);
		scroll1 = new JScrollPane(listServices);
		
		serviceDetails = new JTextArea(" Double-click on a service \n to see details.",10,20);
		serviceDetails.setEditable(false);
		scroll2 = new JScrollPane(serviceDetails);
		servicesContents.add(scroll1, BorderLayout.WEST);
		servicesContents.add(scroll2, BorderLayout.EAST);
		

		services.add(barServices, BorderLayout.NORTH);
		services.add(servicesContents, BorderLayout.SOUTH);
		
		
		contracts = new JPanel();
		
		contracts.setLayout(new BorderLayout());
		
		barContracts = new JToolBar();
		
		all = new JButton("Όλα");
		all.setMinimumSize(new Dimension(80, 50));
		all.setMaximumSize(new Dimension(80, 50));
		mobilePlan2 = new JButton("Συμβόλαια Κινητής",mp);
		mobilePlan2.setMinimumSize(new Dimension(140, 50));
		mobilePlan2.setMaximumSize(new Dimension(140, 50));
		costControl2 = new JButton("Καρτοσυμβόλαια",ccp);
		costControl2.setMinimumSize(new Dimension(140, 50));
		costControl2.setMaximumSize(new Dimension(140, 50));
		mobileInternet2 = new JButton("Mobile Internet",mi);
		mobileInternet2.setMinimumSize(new Dimension(135, 50));
		mobileInternet2.setMaximumSize(new Dimension(135, 50));
		barContracts.add(all);
		barContracts.add(mobilePlan2);
		barContracts.add(costControl2);
		barContracts.add(mobileInternet2);
		barContracts.setFloatable(false);
		contracts.add(barContracts, BorderLayout.NORTH);
		
		contractsContents = new JPanel();
		
		contractsContents.setLayout(new BoxLayout(contractsContents, BoxLayout.X_AXIS));

		listModel2 = new DefaultListModel();
		for (int i=0; i <mobileContracts.numberOfContracts();i++)
		{
			listModel2.addElement(mobileContracts.getContract(i).getName());
		}
		listContracts = new JList(listModel2);
		listContracts.setSelectedIndex(0);
		scroll3 = new JScrollPane(listContracts);
		
		contractDetails = new JTextArea(" Double-click on a contract \n to see details.",10,20);
		contractDetails.setEditable(false);
		scroll4 = new JScrollPane(contractDetails);
		contractsContents.add(scroll3, BorderLayout.WEST);
		contractsContents.add(scroll4, BorderLayout.EAST);
		

		contracts.add(barContracts, BorderLayout.NORTH);
		contracts.add(contractsContents, BorderLayout.SOUTH);
		tabs.add("Διαθέσιμες υπηρεσίες", services);
		tabs.add("Ενεργά συμβόλαια", contracts);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(menuBar,BorderLayout.NORTH);
		cp.add(tabs,BorderLayout.CENTER);
		
		pack();	
	}//drawFrame
	
	
	
	public static void main(String args[])
	{	
		new MobileServicesFrame();
	}//main
}
