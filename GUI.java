package Slutprojekt;

import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class GUI {
	
	static void createAndDisplay() {
		JFrame frameOfCalendar = new JFrame();
		frameOfCalendar.setTitle("Arzijes kalender");
		frameOfCalendar.setSize(1500, 1200);
		frameOfCalendar.setLayout(new GridLayout(1,7,10,10));
		frameOfCalendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		String[] daysOfWeek = {"","Monday", "Tuesday", "Wendsday", "Thursday", "Friday", "Saturday", "Sunday"};

		for (int i=1; i<=7; i++) {
			JPanel panelOfDays = new JPanel();  
			panelOfDays.setLayout(new GridLayout(36,1));
			panelOfDays.setSize(200, 1400);;
			panelOfDays.setBackground(new Color(225, 211, 227));
			
			JLabel labelOfDays = new JLabel("" + daysOfWeek[i]); 
			JLabel labelOfDate = new JLabel("" + (String.valueOf((LocalDate.now().minusDays
											(LocalDate.now().getDayOfWeek().getValue() - (i)))))); 
			panelOfDays.add(labelOfDate);
			panelOfDays.add(labelOfDays);

				if (LocalDate.now().getDayOfWeek().getValue() - (i) == 0) {
					panelOfDays.setBackground(new Color(171, 158, 173));	
				}
			
			hoursOfDay(panelOfDays);			
			frameOfCalendar.add(panelOfDays);
		}	
		frameOfCalendar.setVisible(true);
	}

	static void hoursOfDay(JPanel container) {
		JTextField textOfActivities = new JTextField(); 
		container.add(textOfActivities);
		
			for (int j=1; j <11; j++) {
				JLabel labelOfTime = new JLabel("" + LocalTime.parse("07:00").plusHours(j)); 
				JLabel labelOfActivities = new JLabel("" );
				
				JButton buttonForAddingActivities = new JButton("ADD");
				buttonForAddingActivities.addActionListener(
				(e)		-> labelOfActivities.setText(textOfActivities.getText()));
				
				container.add(buttonForAddingActivities);
				container.add(labelOfTime);
				container.add(labelOfActivities);
				

			}	
	}

}
