package gmail;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main {

	public Main() {
		
	}

	public static void main(String[] args) {
		//create frame
		JFrame frame=new JFrame();
		frame.setTitle("Login Page");
		frame.setLocation(0,0);
		frame.setLayout(new BorderLayout());
		frame.setResizable(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //full secreen frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//another method give path of photo as a parameter
		frame.setIconImage(new ImageIcon("Images/gmail.png").getImage());//create icone for frame 
		
		//create panel
		JPanel panel=new JPanel();
		//panel has default layout
		panel.setLayout(null);
		panel.setSize(1000, 600);
		panel.setLocation(200, 100);
		panel.setBackground(Color.WHITE);
		panel.setVisible(true);

		//create field
		JTextField textfield=new JTextField();
		textfield.setBounds(550,300, 250, 20);
		panel.add(textfield);
		//create label for field
		JLabel labeltext=new JLabel("Username :");
		labeltext.setBounds(450,295, 200, 30);
		panel.add(labeltext);
		
	    //create field
		JPasswordField passwordfield=new JPasswordField();
		passwordfield.setBounds(550,360, 250, 20);
     	panel.add(passwordfield);
		//create label for field
		JLabel labelpass =new JLabel("Password :");
		labelpass.setBounds(450,355, 200, 30);
		panel.add(labelpass); 
		//change the border around the field
		textfield.setBorder(BorderFactory.createLineBorder(Color.GRAY));//prameter the color of lineborder
		passwordfield.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		//create check box 
		JCheckBox checkbox=new JCheckBox("Save Password");
		checkbox.setBounds(450,420, 200, 30);
		checkbox.setOpaque(false);//remove the beckground of text (without it->the default backgroung (gray))
		panel.add(checkbox);
		
		//create button
		JButton button=new JButton("Login");
		button.setBounds(600,480, 100, 30);
		panel.add(button);
		
		//create label
		JLabel label1=new JLabel("Forget Password ?");
		label1.setBounds(600, 530,200, 30);
		label1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(label1);
		
		//create list
		String [] themes={"Light","Dark","System"};
		//list take array as a parameter
		JList list=new JList(themes);
		list.setBounds(1200, 20, 70, 60);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.add(list);
		// Handle selection
		
		//list.addListSelectionListener(new  ListSelectionListener(){
		list.addListSelectionListener(event->{
            //override
			//public void valueChanged(ListSelectionEvent event) {
			
			//getSelectedValue()->return object represent the selection so we do casting
		    String selected = (String) list.getSelectedValue();

		    if(selected.equals("Light")){
		        panel.setBackground(Color.WHITE);
		       //setForeground change the text color
		        labeltext.setForeground(Color.BLACK);
		        labelpass.setForeground(Color.BLACK);
		        checkbox.setForeground(Color.BLACK);
		        label1.setForeground(Color.BLACK);
		    }

		    else if(selected.equals("Dark")){
		        panel.setBackground(Color.BLACK);
		        labeltext.setForeground(Color.WHITE);
		        labelpass.setForeground(Color.WHITE);
		        checkbox.setForeground(Color.WHITE);
		        label1.setForeground(Color.WHITE);
		    }
		    else if(selected.equals("System")){
		        panel.setBackground(null);
		        labeltext.setForeground(null);
		        labelpass.setForeground(null);
		        checkbox.setForeground(null);
		        label1.setForeground(null);
		    }
			//}
	      }
		);
		
		label1.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mousePressed(java.awt.event.MouseEvent e) {
		        label1.setForeground(Color.GRAY); 
		    }

		    @Override
		    public void mouseReleased(java.awt.event.MouseEvent e) {
		        label1.setForeground(Color.BLACK); 
		    }
		});
		
		String []role= {"Admin","Student","Instructor"};
		JComboBox combobox=new JComboBox(role);
		combobox.setBounds(10, 35, 90, 20);
		panel.add(combobox);
		
		//put image in panel 
		//ImageIcon use as a compont we cannot edit it
		//Image the acutally Image which has pixels we can edit it
		ImageIcon icon=new ImageIcon("Images/gmail.png");
		//get image from component
		Image img=icon.getImage();
		//change demintions of orignal photo
		//SCALE_SMOOTH static attribute called with the class name direcly
		Image newimg=img.getScaledInstance(100, 100,Image.SCALE_SMOOTH);//third paramter for quality
		//transform image into component again to use it
		ImageIcon scaledimg=new ImageIcon(newimg);
		JLabel image= new JLabel(scaledimg);
		image.setBounds(600, 150, 100, 100);
		panel.add(image);
		frame.add(panel);
		
	
		frame.setVisible(true);
	}

}
