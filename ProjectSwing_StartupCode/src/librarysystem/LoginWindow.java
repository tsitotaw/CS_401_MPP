package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

import business.ControllerInterface;
import business.LoginException;
import business.SystemController;
import dataaccess.Auth;


public class LoginWindow extends JFrame implements LibWindow {
    public static final LoginWindow INSTANCE = new LoginWindow();
	
	private boolean isInitialized = false;
	
	private JPanel mainPanel;
	private JPanel upperHalf;
	private JPanel middleHalf;
	private JPanel lowerHalf;
	private JPanel container;
	
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	private JPanel leftTextPanel;
	private JPanel rightTextPanel;
	
	private JTextField username;
	private JTextField password;
	private JLabel label;
	private JButton loginButton;
	private JButton logoutButton;
	String pathToImage;
	JLabel lblLoginStatus;
	JLabel lblNullLoginStatus;
	private SystemController sysCtrl;
	
	public boolean isInitialized() {
		return isInitialized;
	}
	public void isInitialized(boolean val) {
		isInitialized = val;
	}
	private JTextField messageBar = new JTextField();
	public void clear() {
		messageBar.setText("");
	}
	
	/* This class is a singleton */
    private LoginWindow () {}
    
    public void init() {     		
    		mainPanel = new JPanel();
    		setPathToImage();
    		//insertSplashImage();
    		defineUpperHalf();
    		defineMiddleHalf();
    		defineLowerHalf();
    		BorderLayout bl = new BorderLayout();
    		//bl.setVgap(30);
    		mainPanel.setLayout(bl);
    		
    		mainPanel.add(upperHalf, BorderLayout.NORTH);
    		mainPanel.add(middleHalf, BorderLayout.CENTER);
    		mainPanel.add(lowerHalf, BorderLayout.SOUTH);
    		getContentPane().add(mainPanel);
    		isInitialized(true);
    		pack();
    		setSize(260, 450);

    	
    }
    private void setPathToImage() {
    	String currDirectory = System.getProperty("user.dir");
    	pathToImage = currDirectory+"/src/librarysystem/login.jpg";
    }
    
    private void defineUpperHalf() {
    		
    		upperHalf = new JPanel();
    		upperHalf.setLayout(new BorderLayout());
    		defineTopPanel();
    		defineMiddlePanel();
    		defineLowerPanel();    		
    		upperHalf.add(topPanel, BorderLayout.NORTH);
    		upperHalf.add(middlePanel, BorderLayout.CENTER);
    		upperHalf.add(lowerPanel, BorderLayout.SOUTH);
    		
    	}
    	private void defineMiddleHalf() {
    		middleHalf = new JPanel();
    		middleHalf.setLayout(new BorderLayout());
    		JSeparator s = new JSeparator();
    		s.setOrientation(SwingConstants.HORIZONTAL);
    		//middleHalf.add(Box.createRigidArea(new Dimension(0,50)));
    		middleHalf.add(s, BorderLayout.SOUTH);
    		
    	}
    	private void defineLowerHalf() {

    		lowerHalf = new JPanel();
    		lowerHalf.setLayout(new FlowLayout(FlowLayout.LEFT));
    		
    		lblLoginStatus = new JLabel("Invalid Username or Password");
    		lblLoginStatus.setFont(Util.makeLargeFont(label.getFont()));
    		lblLoginStatus.setForeground(Color.RED.darker());
    		lblLoginStatus.setVisible(false);
//    		JButton backButton = new JButton("<= Back to Main");
//    		addBackButtonListener(backButton);
    		lowerHalf.add(lblLoginStatus);
    		
    	}
    	private void defineTopPanel() {
    		topPanel = new JPanel();
    		
    		JPanel intPanel = new JPanel(new BorderLayout());
    		intPanel.add(Box.createRigidArea(new Dimension(0,20)), BorderLayout.NORTH);
    		ImageIcon image = new ImageIcon(pathToImage);    		
    		//topPanel.add(new JLabel(image));
//    		JLabel loginLabel = new JLabel("Login");
//    		Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
    		lblNullLoginStatus = new JLabel("both username and password are required");
    		lblNullLoginStatus.setFont(Util.makeSmallFont(lblNullLoginStatus.getFont()));
    		lblNullLoginStatus.setForeground(Color.RED.darker());
    		lblNullLoginStatus.setVisible(false);
    		
    		intPanel.add(new JLabel(image), BorderLayout.CENTER);
    		intPanel.add(lblNullLoginStatus, BorderLayout.SOUTH);
    		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    		topPanel.add(intPanel);
    	}
    	
    	
    	
    	private void defineMiddlePanel() {
    		middlePanel=new JPanel();
    		middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    		defineLeftTextPanel();
    		defineRightTextPanel();
    		middlePanel.add(leftTextPanel);
    		middlePanel.add(rightTextPanel);
    	}
    	private void defineLowerPanel() {
    		lowerPanel = new JPanel();
    		loginButton = new JButton("Login");
    		addLoginButtonListener(loginButton);
    		lowerPanel.add(loginButton);
    	}

    	private void defineLeftTextPanel() {
    		JPanel topText = new JPanel();
    		JPanel bottomText = new JPanel();
    		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
    		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
        		
    		username = new JTextField(10);
    		username.setText("101");
    		label = new JLabel("Username");
    		label.setFont(Util.makeSmallFont(label.getFont()));
    		
    		topText.add(username);
    		bottomText.add(label);
    		
    		leftTextPanel = new JPanel();
    		leftTextPanel.setLayout(new BorderLayout());
    		
    		leftTextPanel.add(topText,BorderLayout.NORTH);
    		leftTextPanel.add(bottomText,BorderLayout.CENTER);
    	}
    	private void defineRightTextPanel() {
    		
    		JPanel topText = new JPanel();
    		JPanel bottomText = new JPanel();
    		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
    		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
    		
    		password = new JPasswordField(10);
    		password.setText("xyz");
    		label = new JLabel("Password");
    		label.setFont(Util.makeSmallFont(label.getFont()));
    		topText.add(password);
    		bottomText.add(label);
    		
    		rightTextPanel = new JPanel();
    		rightTextPanel.setLayout(new BorderLayout());
    		rightTextPanel.add(topText,BorderLayout.NORTH);
    		rightTextPanel.add(bottomText,BorderLayout.CENTER);
    	}
    	
    	private void addBackButtonListener(JButton butn) {
    		butn.addActionListener(evt -> {
    			LibrarySystem.hideAllWindows();
    			LibrarySystem.INSTANCE.setVisible(true);
    		});
    	}
    	
    	private void addLoginButtonListener(JButton butn) {
    		butn.addActionListener(evt -> {
    			if(this.username.getText().equals("") || this.password.getText().equals("")) {
    				this.lblNullLoginStatus.setVisible(true);
    			}
    			else {
    				this.lblNullLoginStatus.setVisible(false);
    				sysCtrl = new SystemController();
    				try {
    					sysCtrl.login(this.username.getText(), this.password.getText());
    				}catch(LoginException ex) {
    					
    				}
    				
    				if(SystemController.currentAuth == null) {
    					this.lblLoginStatus.setVisible(true);
    				}
    				else {
    					//JOptionPane.showMessageDialog(this,"Successful Login");
    	    			LibrarySystem.hideAllWindows();
    	    			
    	    			//LibrarySystem.INSTANCE.setVisible(true);
    	    			//LibrarySystem.INSTANCE.setTitle("Sample Library Application");
    		            LibrarySystem.INSTANCE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//	            
    		            LibrarySystem.INSTANCE.init();
    		            Util.centerFrameOnDesktop(LibrarySystem.INSTANCE);
    		            LibrarySystem.INSTANCE.setVisible(true);
    		            LoginWindow.INSTANCE.dispose();
    				}
	    			
    			}
    		});
    	}
	
        
    
}
