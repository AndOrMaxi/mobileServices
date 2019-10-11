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

import java.text.*;
import java.util.*;
import Contract.*;
import Lists.*;
import MobileServices.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class ServiceFrame  extends JFrame implements ActionListener 
{
	private JPanel service;
	private JButton newContract;
	private JTextPane details;
	private MobileService frameService;
	
	
	public ServiceFrame (MobileService s)
	{
		this.frameService =s;
		setTitle("�������� ���������");
		drawFrame();
		newContract.addActionListener(this);
		setResizable(false); 
		setVisible(true);
	}//ServiceFrame
    
    
	
    public void actionPerformed(ActionEvent e) 
	{
    	if (e.getSource() == newContract)//Otan path8ei to koumpi "Neo symbolaio"
		{
    		String name = (String)JOptionPane.showInputDialog(this, "������������� ������");
    		
    		if (name != null)
    		{
	    		String phone = (String)JOptionPane.showInputDialog(this, "����������� �������");
	    		
	    		if (phone != null)
	    		{
		    		String[] possibleValues = {"����������� (�� ���������)", "�������(�� ���������)", "��������(���� ������ ���������� �������)"};
	    		
	    			String payment = (String)JOptionPane.showInputDialog(this, "������ ��������", "��� ���������", JOptionPane.QUESTION_MESSAGE,null, possibleValues,possibleValues[0]);
	    			
	    			if (payment != null)
	        		{
	    				String date=(String)JOptionPane.showInputDialog(this, "���������� �������������",new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
	    				if (date!=null)
	    				{
					    	String d = (String)JOptionPane.showInputDialog(this, "�������� ������� (0-100%)");
							float discount = (Float.parseFloat(d))/100;
							Date dat=null;
							try 
							{
								dat = new SimpleDateFormat("dd/MM/yyyy").parse(date);
							}//try
							catch (ParseException e1) 
							{
								e1.printStackTrace();
							}//catch
							if (frameService instanceof MobileInternet)
							{
								Contract<InternetStats> c = new Contract<InternetStats>(frameService,name,phone,payment,discount, new InternetStats(),dat);
								MobileServicesFrame.mobileContracts.addContract(c);
								JOptionPane.showMessageDialog(this,"������������� ��� ��������� \n�� ������ "+c.getContractID(),"�����������", JOptionPane.INFORMATION_MESSAGE);
							}//if
							else
							{
								Contract<MobilePlanStats> c = new Contract<MobilePlanStats>(frameService,name,phone,payment,discount, new MobilePlanStats(),dat);
								MobileServicesFrame.mobileContracts.addContract(c);
								JOptionPane.showMessageDialog(this,"������������� ��� ��������� \n�� ������ "+c.getContractID(),"�����������", JOptionPane.INFORMATION_MESSAGE);
							}//else
	    				}//if
	        		}//if
	    		}//if
    		}//if
		}//if
	}//actionPerformed
		
	    
	
	private void drawFrame()//sxediash para8yrou
	{

		setBounds(300, 300, 230, 270);
		service = new JPanel();
		service.setLayout(new BorderLayout());
		details = new JTextPane();
		details.setEditable(false);
		newContract = new JButton("��� ���������");
		
		if ((frameService instanceof MobilePlan)&& !(frameService instanceof CostControlPlan))
			details.setText(frameService.toString()+"\n\n");
		else
			details.setText(frameService.toString()+"\n");
		
		service.add(details, BorderLayout.NORTH);
		service.add(newContract, BorderLayout.SOUTH);
		service.setVisible(true);
		Container cp = getContentPane();
		cp.add(service);
	}//drawFrame
}//ServiceFrame
