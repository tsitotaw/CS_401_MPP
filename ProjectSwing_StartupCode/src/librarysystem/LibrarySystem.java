package librarysystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import business.ControllerInterface;
import business.SystemController;

public class LibrarySystem extends JFrame implements LibWindow {
	ControllerInterface ci = new SystemController();
	public final static LibrarySystem INSTANCE = new LibrarySystem();
	JPanel mainPanel;
	JMenuBar menuBar;
	JMenuBar menuBar2;
	JMenu options;
	JMenu addMenu;
	JMenu helpMenu;
	JMenuItem allBookIds, allMemberIds;
	JMenuItem newBook, newMember;
	JMenuItem aboutMenuItem, logoutMenuItem;
	
	String pathToImage;
	private boolean isInitialized = false;

	private static LibWindow[] allWindows = { 
			LibrarySystem.INSTANCE,
			AddNewBookWindow.INSTANCE,
			AllMemberIdsWindow.INSTANCE, 
			AllBookIdsWindow.INSTANCE 
	};

	public static void hideAllWindows() {

//		for (LibWindow frame : allWindows) {
//			frame.setVisible(false);
//			LibrarySystem.INSTANCE.dispose();
//		}
	}

	private LibrarySystem() {
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
	}

	public void init() {
		formatContentPane();
		setPathToImage();
		insertSplashImage();

		createMenus();
		// pack();
		//setSize(1200, 1080);
		isInitialized = true;
	}

	private void formatContentPane() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 1));
		getContentPane().add(mainPanel);
	}

	private void setPathToImage() {
		String currDirectory = System.getProperty("user.dir");
		pathToImage = currDirectory + "/src/librarysystem/library-big.jpg";
	}

	private void insertSplashImage() {
		ImageIcon image = new ImageIcon(pathToImage);
		mainPanel.add(new JLabel(image));
	}

	private void createMenus() {

		menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createRaisedBevelBorder());
		addNewMenuItems();
		addViewMenuItems();
		addHelpMenuItems();
		setJMenuBar(menuBar);
	}

	private void addViewMenuItems() {
		options = new JMenu("View");
		menuBar.add(options);

		allBookIds = new JMenuItem("Existing Books");
		allBookIds.addActionListener(new AllBookIdsListener());
		allMemberIds = new JMenuItem("Existing Members");
		allMemberIds.addActionListener(new AllMemberIdsListener());

		options.add(allBookIds);
		options.add(allMemberIds);
	}
	private void addHelpMenuItems() {
		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.addActionListener(new AllBookIdsListener());
		logoutMenuItem = new JMenuItem("Log out");
		logoutMenuItem.addActionListener(new AllMemberIdsListener());

		helpMenu.add(aboutMenuItem);
		helpMenu.add(logoutMenuItem);
	}

	private void addNewMenuItems() {
		addMenu = new JMenu("Add");
		menuBar.add(addMenu);
		newBook = new JMenuItem("New Book");
		newBook.addActionListener(new AddNewBookListener());
		newMember = new JMenuItem("New Member");
		newMember.addActionListener(new AllMemberIdsListener());
		addMenu.add(newBook);
		addMenu.add(newMember);
	}

	class AddNewBookListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();

			AddNewBookWindow.INSTANCE.init();

			List<String> ids = ci.allBookIds();
			Collections.sort(ids);
			StringBuilder sb = new StringBuilder();
			for (String s : ids) {
				sb.append(s + "\n");
			}
			System.out.println(sb.toString());
			//AllBookIdsWindow.INSTANCE.setData(sb.toString());
			AddNewBookWindow.INSTANCE.pack();
			// AllBookIdsWindow.INSTANCE.setSize(660,500);
			Util.centerFrameOnDesktop(AddNewBookWindow.INSTANCE);
			AddNewBookWindow.INSTANCE.setVisible(true);

		}

	}

	class AllBookIdsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();

			AllBookIdsWindow.INSTANCE.init();

			List<String> ids = ci.allBookIds();
			Collections.sort(ids);
			StringBuilder sb = new StringBuilder();
			for (String s : ids) {
				sb.append(s + "\n");
			}
			System.out.println(sb.toString());
			AllBookIdsWindow.INSTANCE.setData(sb.toString());
			AllBookIdsWindow.INSTANCE.pack();
			// AllBookIdsWindow.INSTANCE.setSize(660,500);
			Util.centerFrameOnDesktop(AllBookIdsWindow.INSTANCE);
			AllBookIdsWindow.INSTANCE.setVisible(true);

		}

	}

	class AllMemberIdsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			AllMemberIdsWindow.INSTANCE.init();
			AllMemberIdsWindow.INSTANCE.pack();
			AllMemberIdsWindow.INSTANCE.setVisible(true);

			LibrarySystem.hideAllWindows();
			AllBookIdsWindow.INSTANCE.init();

			List<String> ids = ci.allMemberIds();
			Collections.sort(ids);
			StringBuilder sb = new StringBuilder();
			for (String s : ids) {
				sb.append(s + "\n");
			}
			System.out.println(sb.toString());
			AllMemberIdsWindow.INSTANCE.setData(sb.toString());
			AllMemberIdsWindow.INSTANCE.pack();
			// AllMemberIdsWindow.INSTANCE.setSize(660,500);
			Util.centerFrameOnDesktop(AllMemberIdsWindow.INSTANCE);
			AllMemberIdsWindow.INSTANCE.setVisible(true);

		}

	}

	@Override
	public boolean isInitialized() {
		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		isInitialized = val;

	}

}
