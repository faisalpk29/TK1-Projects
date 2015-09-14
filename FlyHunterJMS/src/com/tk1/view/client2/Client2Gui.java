package com.tk1.view.client2;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.tk1.controller.ControllerClient2;
import com.tk1.controller.Util;
import com.tk1.jms.FlyInfo;



public class Client2Gui extends javax.swing.JPanel
{
	

	private static final long serialVersionUID = -7755677777707676222L;
	private ControllerClient2 controller ;
	//private FlyInfo flyInfo = null;
	private int round  = 1;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel enterNameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel unameLabel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    private JLabel flyImage;
    private List<JLabel> flies;
    private String clientId;
    ImageIcon flyImg;
    Map<String,Integer> scoreMap;
    private int score;
    
    /** Creates new form MainPanel 
     * @throws InterruptedException */
    public Client2Gui() 
    {
    	
    	controller= new ControllerClient2(this);
    	this.scoreMap = new HashMap<String,Integer>();
    	scoreMap.put("Faisal", 0);
    	scoreMap.put("Hamza", 0);
    	this.score = 0;
        initComponents();
        
        
		enterNameLabel.setText("Player Name : Hamza ");
		
        unameLabel.setText(" Score Board ");
        unameLabel.setVisible(true);
       
        userNameLabel.setVisible(true);
        btnLogout.setVisible(false);
        
        enterNameLabel.setVisible(true);
        userNameTextField.setVisible(true);
        userNameTextField.setEnabled(false);
        btnLogin.setVisible(false);
       
        Util.println("Connection established ....");
       
			
		
		
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {
    	 InputStream input = ClassLoader.getSystemResourceAsStream("a.jpg") ;
         Image logo = null;
         
         try {
				logo = ImageIO.read(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
//     	Random random = new Random();
        flyImg = new ImageIcon(logo);
    	flies = new ArrayList<JLabel>();
//    	flyImage = new JLabel(flyImg);
//    	

        
        jPanel1 = new javax.swing.JPanel()
        {
        	
//            protected void paintComponent(Graphics g)
//            {
//                super.paintComponent(g);
////                g.setColor(Color.red);
//                InputStream input = ClassLoader.getSystemResourceAsStream("a.jpg") ;
//                Image logo = null;
//                try {
//					logo = ImageIO.read(input);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//               
//                g.drawImage(logo, x-2, y-2, Color.RED, null);
//                jPanel1.repaint();
//                jPanel1.validate();
//            }
//        
       };
        btnLogin = new javax.swing.JButton();
        userNameTextField = new javax.swing.JTextField();
        btnLogout = new javax.swing.JButton();
        enterNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        unameLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        //setFlyPosition(fly.getxPosition(),fly.getyPostiion());
        //controller.updateClient1Flies(fly);
        
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jPanel1.setBackground(Color.WHITE);
//        jPanel1.addMouseListener(mouseListener);
        //controller.updateFlies(fly);
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
            }
        });

        btnLogout.setVisible(false);
        btnLogout.setText("Logout");
        btnLogout.setOpaque(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              
            }
        });

        enterNameLabel.setText("Enter Name:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {{"",0}},
            new String [] {
                "User Name", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        unameLabel.setVisible(false);
        unameLabel.setText("User Name:");

        userNameLabel.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogin))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(unameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(btnLogout)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(unameLabel))
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(enterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>

      
    
   
   
    public void updateTable(Map<String,Integer> scoreMap)
    {
    	
    	
    	DefaultTableModel defaultModel = (DefaultTableModel)jTable1.getModel();
    	defaultModel.setRowCount(0);
    	Util.println("map size ---"+scoreMap.size());
    	 	
    	 
    	int i= 0;
    		   
    		   	for(Iterator<String> it = scoreMap.keySet().iterator(); it.hasNext();) {
    		   		
    		   		Util.println("Inner iteration number ---"+i);
    	             String key = it.next();
    	             Integer value = scoreMap.get(key);
    	           
    	   			defaultModel.addRow(new Object[]{key,value});
    	   			Util.println( key+"----"+value);
    	             
    	             i++;
    	             
    	         }

    		
    	}
  
    public void removeFly(FlyInfo flyInfo){
    	Util.println("removeFly in Client 2 Gui .....");
    	JLabel flyToRemove = null;
    	boolean isRemoved = false;
    	for (JLabel fly : flies) {

			if (null != fly && fly.getName().equals(flyInfo.getFlyId())) {
				jPanel1.remove(fly);
				flyToRemove = fly;
				isRemoved = true;
				//fly.setBounds(x, y, flyImg.getIconWidth(),flyImg.getIconHeight() - 5);
				//jPanel1.add(fly);
			}
		}
    		if (isRemoved) {
    			flies.remove(flyToRemove);
			}
    		
    		
    	  this.scoreMap.put("Faisal", flyInfo.getScore());
    		
    	  this.updateTable(this.scoreMap);
    	  jPanel1.repaint();
    	  jPanel1.validate();
    	 
    	  if (flies.isEmpty() || flies.size()<=0){
    		  Util.println("list is empty now going to generate ....");
  			this.generateFlies(++round);
			}
    
    }

	public void updateFlise(FlyInfo flyInfo) {
		try {
			
		
		Util.println("updateFlise in Client 2 Gui .....");
	
		 for (FlyInfo f : flyInfo.getFlyList()) {
			 if (null!=f) {
				 JLabel flyy = new JLabel(flyImg);
				 flyy.setName(f.getFlyId());
				 
				
				 flyy.addMouseListener(mouseListener);
		    		flyy.setBounds(f.getxPosition(), f.getyPostiion(),flyImg.getIconWidth(), flyImg.getIconHeight());
		    		Util.println("Added in list ...."+flyy.getName());
		    		 this.flies.add(flyy);
		    		 
		    		 jPanel1.add(flyy);
		    		 jPanel1.repaint();
		    		 jPanel1.validate();
			}
			
		}
		 
		 if (flyInfo.getOperation().equals("START")) {
			 Util.println("Start operation generating flies");
				this.generateFlies(flyInfo.getRound());
			}
		Util.println("Number of flies  -- " + flies.size());
	}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void setFlyPosition(int x, int y)
 {
		Util.println("updating fly positions and numbers client 2 .....");
		for (JLabel fly : flies) {

			if (null != fly) {
				fly.setBounds(x, y, flyImg.getIconWidth(),flyImg.getIconHeight() - 5);
				jPanel1.add(fly);
			}
		}
	}
    	
    	
       
    	 public void killFly(String flyId)
    	    {
    	    	
    	    	for (JLabel fly : flies) {

    				if (null!=fly && fly.getName().equalsIgnoreCase(flyId)) {
    					flies.remove(fly);
    				
    					// fly.setBounds(x, y, flyImg.getIconWidth(), flyImg.getIconHeight()-5);
    					 //jPanel1.add(fly);
    				}

    			}
       

    }
    
    private MouseListener mouseListener = new MouseAdapter()
    {
        public void mouseClicked(MouseEvent e)
        {
        	if(e.getButton() == MouseEvent.BUTTON1)
        	{
        		JLabel lbl =(JLabel)e.getSource();
        		Util.println(" ["+lbl.getName()+"] hit by Client 2 ...");
        	       
        		huntFly(lbl);
        	}
        }
    };
    
	private void huntFly(JLabel flyId) {
		Util.println("Hunt Fly client 2 : " + flyId.getName());
		FlyInfo fly = new FlyInfo();
		fly.setFlyId(flyId.getName());
		fly.setOperation("REMOVE");
		

		this.flies.remove(flyId);
		jPanel1.remove(flyId);
		
		
		this.scoreMap.put("Hamza",++score );
		
		this.updateTable(scoreMap);
		jPanel1.repaint();
		jPanel1.validate();
	    fly.setScore(score);
		controller.huntFly(fly);
		if (this.flies.size() <=0) {
			generateFlies(++round);
		}
		

	}
    	
    	
	 private void generateFlies(int round){
		 try {
			
		
	    	Util.println("client 2 generateFlies round ["+round+"]");
	    	Random random = new Random();
	    	
	    	FlyInfo f=  new FlyInfo();
	    	 	f.setOperation("UPDATE");
	    	
	    	ArrayList<FlyInfo>list = new ArrayList<FlyInfo>();
	    	f.setRound(round);
	    	f.setFlyId("Fly-"+random.nextInt(80000));
	    	for (int i = 0; i < round; i++) {
	    		
	    		JLabel flyy = new JLabel(flyImg);
	    		flyy.setName("Fly-"+random.nextInt(80000));
	    	    
		    		
		    		flyy.addMouseListener(mouseListener);
		    		
		    		FlyInfo fly =  new FlyInfo();
		        	fly.setFlyId(flyy.getName());
		        	fly.setOperation("UPDATE");
		        	fly.setxPosition(random.nextInt(500));
		        	fly.setyPostiion(random.nextInt(400));
		    		flyy.setBounds(fly.getxPosition(), fly.getyPostiion(),flyImg.getIconWidth(), flyImg.getIconHeight() - 5);
		    		this.flies.add(flyy);
		    		list.add(fly);
		    		jPanel1.add(flyy);
		    		
		    		Util.println("Generated and Added in list ...."+flyy.getName());
		    		
				
			}
	    	
	    	jPanel1.repaint();
			jPanel1.validate();
			userNameTextField.setText("Round : "+round);
	    	f.setFlyList(list);
	    	controller.updateClient1Flies(f);
	    	
		 } catch (Exception e) {
				e.printStackTrace();
			}
		
	    }
    
    
    
}
