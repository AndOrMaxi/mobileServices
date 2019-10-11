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

import Contract.*;
import Lists.*;
import java.util.*;
import MobileServices.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class ContractFrame  extends JFrame implements ActionListener 
{
	private JPanel contract;
	private JButton updateStats;
	private JButton showCost;
	private JPanel buttons;
	private JTextPane details;
	private Contract<? extends Statistics> frameContract;

	
	public ContractFrame(Contract<? extends Statistics> c)
	{
		this.frameContract = c;
		setTitle("Στοιχεία συμβολαίου");
		drawFrame();
		updateStats.addActionListener(this);
		showCost.addActionListener(this);
		setResizable(false); 
		setVisible(true);
	}
    
	
    
    public void actionPerformed(ActionEvent e) 
	{
    	if (e.getSource() == updateStats)//otan path8ei to koumpi "Enhmerwsh statistikwn"
		{
    		
        	if ( frameContract.getStatistics() instanceof InternetStats)
        	{
        		String vol = (String)JOptionPane.showInputDialog(this, "Όγκος δεδομένων (MB)");
            	float ch = Float.parseFloat(vol);
        		((InternetStats)  frameContract.getStatistics()).setDataVolume(ch);
        		JOptionPane.showMessageDialog(this,"Τα στατιστικά του μήνα ενημερώθηκαν!","Επιβεβαίωση", JOptionPane.INFORMATION_MESSAGE);
				
        		details.setText(frameContract.toString()+"\n\n\n\n\n");
        	}//if
        	else
        	{
        		String tm = (String)JOptionPane.showInputDialog(this, "Χρόνος ομιλίας σε κινητά δίκτυα (sec)");
            	int tmob = Integer.parseInt(tm);
            	((MobilePlanStats) frameContract.getStatistics()).setTimeToMobileNetworks(tmob);
            	String tf = (String)JOptionPane.showInputDialog(this, "Χρόνος ομιλίας σε σταθερά δίκτυα (sec)");
            	int tfixed = Integer.parseInt(tf);
            	((MobilePlanStats)  frameContract.getStatistics()).setTimeToNationalFixed(tfixed);
            	String s = (String)JOptionPane.showInputDialog(this, "Αριθμός απεσταλμένων SMS");
            	int sms = Integer.parseInt(s);
        		((MobilePlanStats)  frameContract.getStatistics()).setNumberOfSMS(sms);
        		JOptionPane.showMessageDialog(this,"Τα στατιστικά του μήνα ενημερώθηκαν!","Επιβεβαίωση", JOptionPane.INFORMATION_MESSAGE);
				details.setText(frameContract.toString());
        	}//else
		}//if
    	else if (e.getSource() == showCost)//otan path8ei to koumpi "Ypologismos kostous" h "Emfanish ypoloipou"
    	{
    		if (frameContract.getService() instanceof CostControlPlan)
        	{
        		JOptionPane.showMessageDialog(this,String.format("%.2f%s", frameContract.totalCostOrUnits(),"\u20AC"),"Μηνιαίο διαθέσιμο υπόλοιπο", JOptionPane.INFORMATION_MESSAGE);
        	}//if
        	else
        	{
        		JOptionPane.showMessageDialog(this,String.format("%.2f%s", frameContract.totalCostOrUnits(),"\u20AC"),"Μηνιαίο κόστος", JOptionPane.INFORMATION_MESSAGE);
            	
        	}//else	
    	}//else if
	}//actionPerformed
    
    
	
	private void drawFrame()//sxediash para8yrou
	{
		setBounds(300, 300, 270, 410);
		contract = new JPanel();
		contract.setLayout(new BorderLayout());
		details = new JTextPane();
		details.setEditable(false);
		updateStats = new JButton("Ενημέρωση στατιστικών");
		if(frameContract.getService() instanceof CostControlPlan)
		{
			showCost = new JButton("Εμφάνιση υπολοίπου");
		}//if
		else
		{
			showCost = new JButton("Υπολογισμός κόστους");
		}//else
		if (frameContract.getService() instanceof MobileInternet)
			details.setText(frameContract.toString()+"\n\n\n\n\n");
		else
			details.setText(frameContract.toString());
		
		
		contract.add(details, BorderLayout.NORTH);
		JPanel buttons = new JPanel();
		buttons.setVisible(true);
		contract.add(updateStats, BorderLayout.CENTER);
		contract.add(showCost, BorderLayout.SOUTH);
		contract.setVisible(true);
		Container cp = getContentPane();
		cp.add(contract);
	}//drawFrame
}//ContractFrame

