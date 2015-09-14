package tu.edu.tk1;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tu.edu.tk1.MainPanel;



public class HuntClient {
	
	public HuntClient() {
		 System.out.println("New Client....");
		 initGUI();
	 }

	 private void initGUI(){
		GUI gui= new GUI();
		gui.setVisible(true);
	 }
	
	    public static void main(String[] args) {
	    	MainPanel gui = new MainPanel() ;
	    	JFrame mainFrame = new JFrame();            
	            
	        mainFrame.setResizable(false);
	        mainFrame.setLayout(new BorderLayout());
	        mainFrame.add(gui, BorderLayout.CENTER);
	        mainFrame.pack();
	        mainFrame.setVisible(true); 
		
		
	    }
	
	    
	    
}
