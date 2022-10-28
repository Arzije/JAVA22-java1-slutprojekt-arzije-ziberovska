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
		JFrame frame = new JFrame();
		frame.setTitle("Arzijes kalender");
		frame.setSize(1500, 700);
		frame.setLayout(new GridLayout(1,7,10,10));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		 
		String[] daysOfWeek = {"","Monday", "Tuesday", "Wendsday", "Thursday", "Friday", "Saturday", "Sunday"};

		for (int i=1; i<=7; i++) {
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(36,1));
			panel.setBackground(new Color(225, 211, 227));
			
			JLabel label = new JLabel("" + daysOfWeek[i]);
			JLabel label1 = new JLabel("" + (String.valueOf((LocalDate.now().minusDays
											(LocalDate.now().getDayOfWeek().getValue() - (i))))));
			panel.add(label1);
			panel.add(label);

				if (LocalDate.now().getDayOfWeek().getValue() - (i) == 0) {
					panel.setBackground(new Color(171, 158, 173));	
				}
			
			hoursOfDay(panel);			
			frame.add(panel);
		}	
	}

	static void hoursOfDay(JPanel container) {
		JTextField textField = new JTextField();
		container.add(textField);
		
			for (int j=1; j <11; j++) {
				JLabel label = new JLabel("" + LocalTime.parse("07:00").plusHours(j));
				JLabel label1 = new JLabel("" );
				
				JButton button = new JButton("ADD");
				button.addActionListener(
				(e)		-> label1.setText(textField.getText()));
				
				container.add(button);
				container.add(label);
				container.add(label1);
			}	
	}

}
