package com.tk1.view.client1;

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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.tk1.controller.Controller;
import com.tk1.controller.Util;
import com.tk1.jms.FlyInfo;



public class Client1Gui extends javax.swing.JPanel
{
	private static final long serialVersionUID = -1820544553554843204L;
	private Controller controller ;
	
	private int round  = 1;
    private JButton btnStart;
    private JButton btnLogout;
    private JLabel enterNameLabel;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JLabel unameLabel;
    private JLabel userNameLabel;
    private JTextField userNameTextField;
    private JLabel flyImage;
    private List<JLabel> flies;
    private String clientId;
    private Integer score ;
    ImageIcon flyImg;
    Map<String,Integer> scoreMap;
    
    /** Creates new form MainPanel 
     * @throws InterruptedException */
    public Client1Gui(String clientId) 
    {
    	this.clientId = clientId;
    	this.scoreMap = new HashMap<String,Integer>();
    	scoreMap.put("Faisal", 0);
    	scoreMap.put("Hamza", 0);
    	this.score = 0;
    	
    	controller= new Controller(this);
        initComponents();
        
 
        enterNameLabel.setText("Player Name : Faisal ");
		
        unameLabel.setText(" Score Board ");
        unameLabel.setVisible(true);
       
        userNameLabel.setVisible(true);
        btnLogout.setVisible(false);
        
        enterNameLabel.setVisible(true);
        userNameTextField.setVisible(true);
        userNameTextField.setText("Round "+round);
        userNameTextField.setEnabled(false);
        btnStart.setVisible(true);
       
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
     	//Random random = new Random();
        flyImg = new ImageIcon(logo);
    	flies = new ArrayList<JLabel>();

    	
        
        jPanel1 = new javax.swing.JPanel();
       
        btnStart = new javax.swing.JButton();
        userNameTextField = new javax.swing.JTextField();
        btnLogout = new javax.swing.JButton();
        enterNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        unameLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
       // setFlyPosition(fly.getxPosition(),fly.getyPostiion());
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jPanel1.setBackground(Color.WHITE);
//        jPanel1.addMouseListener(mouseListener);
        
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

        btnStart.setText("Start Game");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               start();
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
                        .addComponent(btnStart))
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
                        .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
				
				Util.println("Fly Removed ....");
			}
		}
    		if (isRemoved) {
    			flies.remove(flyToRemove);
			}
    	  this.scoreMap.put("Hamza", flyInfo.getScore());
    		
      	  this.updateTable(this.scoreMap);
    	 
    	  jPanel1.repaint();
    	  jPanel1.validate();
    	  Util.println("list size after remove ... "+flies.size());
    	  if (flies.isEmpty() || flies.size()<=0) {
				this.generateFlies(++round, false);
			}
    
    }

  
	public void updateFlise(FlyInfo flyInfo) {
		Util.println("updateFlise in Client 1 Gui .....");
		
		for (FlyInfo f : flyInfo.getFlyList()) {
			 if (null!=f) {
				 JLabel flyy = new JLabel(flyImg);
				 flyy.setName(f.getFlyId());
				 
				 flyy.addMouseListener(mouseListener);
		    		flyy.setBounds(f.getxPosition(), f.getyPostiion(),flyImg.getIconWidth(), flyImg.getIconHeight() - 5);
		    		Util.println("Added in list ...."+flyy.getName());
		    		jPanel1.add(flyy);
		    		 this.flies.add(flyy);
		    		 jPanel1.repaint();
		    		 jPanel1.validate();
			}
			
		}
		 
		 

		Util.println("Number of flies  -- " + flies.size());
	}
    
    public void setFlyPosition(int x, int y)
 {
		Util.println("updating fly positions and numbers .....");
		for (JLabel fly : flies) {

			if (null != fly) {
				fly.setBounds(x, y, flyImg.getIconWidth(),flyImg.getIconHeight() - 5);
				jPanel1.add(fly);
			}
		}
	}
    	
    	
       
    	 public void killFly(String flyId)
    	    {
    	    	Util.println("updating fly positions and numbers .....");
    	    	for (JLabel fly : flies) {

    				if (null!=fly && fly.getName().equalsIgnoreCase(flyId)) {
    					flies.remove(fly);
    				
    					// fly.setBounds(x, y, flyImg.getIconWidth(), flyImg.getIconHeight()-5);
    					 //jPanel1.add(fly);
    				}

    			}
       

    }
    	 private void btnStartActionPerformed(java.awt.event.ActionEvent evt)                                         
    	    { 
    	    	
    	        start();  
    	       
    	      
    	    }  
    	 
    	 private void start(){
    		 generateFlies(round,true);
    		 btnStart.setEnabled(false);
    		 
    	 }
    private MouseListener mouseListener = new MouseAdapter()
    {
        public void mouseClicked(MouseEvent e)
        {
        	if(e.getButton() == MouseEvent.BUTTON1)
        	{
        		JLabel fly =(JLabel)e.getSource();
        	
        	//	Util.println(" ["+fly.getName()+"] hit by Client 1 ...");
        	       
        		huntFly(fly);
        	}
        }
    };
    
    private void huntFly(JLabel flyId){
    	Util.println("Hunt Fly client 1 : "+flyId.getName());
    FlyInfo fly = new FlyInfo();
    fly.setFlyId(flyId.getName());
    fly.setOperation("REMOVE");
    
    		this.flies.remove(flyId);
    		jPanel1.remove(flyId);
    		
    		
			this.scoreMap.put("Faisal",++score );
			
    		this.updateTable(scoreMap);
    	    fly.setScore(score);
    		controller.huntFly(fly);
    		jPanel1.repaint();
    		jPanel1.validate();
    		if (this.flies.size() <=0) {
				generateFlies(++round,false);
			}
    		
    	
    	
    }
    
    private void generateFlies(int round,boolean isStart){
    	Util.println("generateFlies round ["+round+"]");
    	this.flies = new ArrayList<JLabel>();
    	FlyInfo f=  new FlyInfo();
    	if (isStart) {
    		f.setOperation("START");
		}else 	f.setOperation("UPDATE");
    	
    	Random random = new Random();
    	ArrayList<FlyInfo>list = new ArrayList<FlyInfo>();
    	f.setRound(round);
    	f.setFlyId("Fly-"+random.nextInt(800));
    	
    	for (int i = 0; i < round; i++) {
    		
    		JLabel flyy = new JLabel(flyImg);
    		flyy.setName("Fly-"+random.nextInt(500000));
    	    
	    	flyy.addMouseListener(mouseListener);
	    		
	    		FlyInfo fly =  new FlyInfo();
	        	fly.setFlyId(flyy.getName());
	        	
	        	
	        	fly.setxPosition(random.nextInt(500));
	        	fly.setyPostiion(random.nextInt(400));
	        	list.add(fly);
	    		flyy.setBounds(fly.getxPosition(), fly.getyPostiion(),flyImg.getIconWidth(), flyImg.getIconHeight());
	    		jPanel1.add(flyy);
	    		this.flies.add(flyy);
	    		
	    		Util.println("Generated and Added in list ...."+flyy.getName());
	    		
			
		}
    	userNameTextField.setText("Round  "+round);
    	jPanel1.repaint();
		jPanel1.validate();
    	f.setFlyList(list);
    	controller.updateClient2Flies(f);
    	
    	
		
        
	
    }
    
    
}
