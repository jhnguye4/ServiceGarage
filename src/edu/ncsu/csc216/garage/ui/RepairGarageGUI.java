package edu.ncsu.csc216.garage.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
//
////
////import java.awt.BorderLayout;
////import java.awt.CardLayout;
////import java.awt.Container;
////import java.awt.Dimension;
////import java.awt.GridLayout;
////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////import java.io.File;
////import java.io.FileNotFoundException;
////import java.util.Scanner;
////
////import javax.swing.JButton;
////import javax.swing.JFrame;
////import javax.swing.JLabel;
////import javax.swing.JMenu;
////import javax.swing.JMenuBar;
////import javax.swing.JMenuItem;
////import javax.swing.JPanel;
////import javax.swing.JScrollPane;
////import javax.swing.JTable;
////import javax.swing.JTextArea;
////import javax.swing.JTextField;
////import javax.swing.ListSelectionModel;
////import javax.swing.table.AbstractTableModel;
////import javax.swing.table.DefaultTableModel;
////
////import edu.ncsu.csc216.garage.model.dealer.Manageable;
////import edu.ncsu.csc216.garage.model.dealer.ServiceManager;
////import edu.ncsu.csc216.garage.model.vehicle.Vehicle;
//
//
///**
// * The graphical user interface for the program.
// * @author jhnguye4
// *
// */
public class RepairGarageGUI extends JFrame implements ActionListener {


//	private String file = "test-files/cars.txt";
//	private Manageable serviceMgr = new ServiceManager();
	/** ID number used for object serialization. */
	private static final long serialVersionUID = 1L;
//	/** Panel that will contain different views for the application. */
//	private JPanel panel;
//	/** Menu bar for the GUI that contains Menus. */
//	private JMenuBar menuBar;
//	/** Menu for the GUI. */
//	private JMenu menu;
//	/** Text for the File Menu. */
//	private static final String FILE_MENU_TITLE = "File";
//	/** Menu item for creating a new file containing Reqs. */
//	private JMenuItem itemNewCars;
//	/** Menu item for loading a file containing Reqs. */
//	private JMenuItem itemLoadCars;
//	/** Menu item for quitting the program. */
//	private JMenuItem itemQuit;
//	/** Text for the New Req XML menu item. */
//	private static final String NEW_CAR_TITLE = "New";
//	/** Text for the Load Req XML menu item. */
//	private static final String LOAD_CAR_TITLE = "Load";
//	/** Text for the Quit menu item. */
//	private static final String QUIT_TITLE = "Quit";
//	/** Title for top of GUI. */
//	private static final String APP_TITLE = "Service Garage Manager";
//	/** Constant to identify AddPanel for {@link CardLayout}. */
//	private static final String GARAGE_PANEL = "GaragePanel";
//	/** Constant to identify EditPanel for {@link CardLayout}. */
//	private static final String EDIT_PANEL = "Edit Vehicle";
//	/** Constant to identify AddPanel for {@link CardLayout}. */
//	private static final String RELEASE_PANEL = "ReleasePanel";
//	/** Add List panel - we only need one instance, so it's final. */
//	private final GaragePanel pnlGarage = new GaragePanel();
//	/** Edit panel - we only need one instance, so it's final. */
//	private final EditPanel pnlEdit = new EditPanel();
//	/** Add List panel - we only need one instance, so it's final. */
//	/** Edit panel - we only need one instance, so it's final. */
//	private final ReleaseBayPanel pnlReleaseBay = new ReleaseBayPanel();
//	/** Reference to {@link CardLayout} for panel.  Stacks all of the panels. */
//	private CardLayout cardLayout;
//	private JTable table;

	
	/**
	 * This is the user interface that is used 
	 */
//	public RepairGarageGUI() { 
//		super();
//
//		//Set up general GUI info
//		setSize(1000, 800);
//		setLocation(50, 50);
//		setTitle(APP_TITLE);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		//setUpMenuBar();
//		
//		//Create JPanel that will hold rest of GUI information.
//		//The JPanel utilizes a CardLayout, which stack several different
//		//JPanels.  User actions lead to switching which "Card" is visible.
//		panel = new JPanel();
//		cardLayout = new CardLayout();
//		panel.setLayout(cardLayout);
//		panel.add(pnlGarage, GARAGE_PANEL);
//		panel.add(pnlEdit, EDIT_PANEL);
//		panel.add(pnlReleaseBay, RELEASE_PANEL);
//		cardLayout.show(panel, GARAGE_PANEL);
//		
//		//Add panel to the container
//		Container c = getContentPane();
//		c.add(panel, BorderLayout.CENTER);
//		
//		//Set the GUI visible
//		c.setVisible(true);
//	}
////	/**
////	 * Makes the GUI Menu bar that contains options for loading a file
////	 * containing requirements or for quitting the application.
////	 */
////	private void setUpMenuBar() {
////		//Construct Menu items
////		menuBar = new JMenuBar();
////		menu = new JMenu(FILE_MENU_TITLE);
////		itemNewCars = new JMenuItem(NEW_CAR_TITLE);
////		itemLoadCars = new JMenuItem(LOAD_CAR_TITLE);
////		itemQuit = new JMenuItem(QUIT_TITLE);
////		itemNewCars.addActionListener(this);
////		itemLoadCars.addActionListener(this);
////		itemQuit.addActionListener(this);
////		
////		
////		//Build Menu and add to GUI
////		menu.add(itemNewCars);
////		menu.add(itemLoadCars);
////		menu.add(itemQuit);
////		menuBar.add(menu);
////		this.setJMenuBar(menuBar);
////	}
//	
//	/**
//	 * Performs an action based on the given {@link ActionEvent}.
//	 * @param e user event that triggers an action.
//	 */
	public void actionPerformed(ActionEvent e) {
		
//		if (e.getSource() == itemNewCars) {
//			//Create a new requirements list list
//			serviceMgr = new ServiceManager();
//			cardLayout.show(panel, GARAGE_PANEL);
//			validate();
//			repaint();			
//		} else if (e.getSource() == itemLoadCars) {
//			//Load an existing requirements list
//			try {
//				serviceMgr = new ServiceManager(new Scanner(new File(getFileName())));
//				waitingList = serviceMgr.printWaitList("");
//				serviceBays = serviceMgr.printServiceBays();
//				cardLayout.show(panel, GARAGE_PANEL);
//				validate();
//				repaint();
//			} catch (IllegalArgumentException exp) {
//				JOptionPane.showMessageDialog(this, "Unable to load requirements file.");
//			} catch (FileNotFoundException exp) {
//				JOptionPane.showMessageDialog(this, "Unable to load requirements file.");
//			}
//		} else if (e.getSource() == itemQuit) {
//			//Quit the program
//			System.exit(0);  //Ignore FindBugs warning here - this is the only place to quit the program!
//
//		}
	}
	
//	/**
//	 * Returns a file name generated through interactions with a {@link JFileChooser}
//	 * object.
//	 * @return the file name selected through {@link JFileChooser}
//	 */
//	private String getFileName() {
//		JFileChooser fc = new JFileChooser("./");  //Open JFileChoose to current working directory
//		fc.setDialogTitle("Garage Load");
//		fc.setApproveButtonText("Select");
//		int returnVal = fc.showOpenDialog(this);
//		if (returnVal != JFileChooser.APPROVE_OPTION) {
//			//Error or user canceled, either way no file name.
//			throw new IllegalStateException();
//		}
//		File gameFile = fc.getSelectedFile();
//		return gameFile.getAbsolutePath();
//	}
//
//	public static void main(String[] args) {
//		new RepairGarageGUI();
//	}
//
//	private class GaragePanel extends JPanel implements ActionListener {
//		/** ID number used for object serialization. */
//		private static final long serialVersionUID = 1L;
//		/** Label for filter */
//		private JLabel lblFilter;
//		/** Text field for filter */
//		private JTextField txtFilter;
//		/** Add action */
//		private JButton btnAdd;
//		/** Edit action */
//		private JButton btnEdit;
//		/** Remove action */
//		private JButton btnRemove;
//		/** Add action */
//		private JButton btnAddBay;
//		/** Edit action */
//		private JButton btnFillBay;
//		/** Remove action */
//		private JButton btnReleaseBay;
//		/** Add action */
//		private JButton btnFilter;
//	    /**
//	     * creating a text area that will be used to output cars
//	     */
//	    private JTextArea displayBox;
//	     /** When too many cars are in displayBox, this allows user to scroll through
//	     * the output display
//	     */
//	    private JTable tableCar;
//	    private CarTableModel carTableModel;
//	    /**
//	     * creating a text area that will be used to fill bays
//	     */
//	    private JTextArea displayBay;
//		public GaragePanel() {
//			try {
//				serviceMgr = new ServiceManager(new Scanner(new File(file)));
//			} catch(FileNotFoundException e) {
//				serviceMgr = new ServiceManager();
//			}
//			lblFilter = new JLabel("Display Filter:");
//			txtFilter = new JTextField(20);
//			btnAdd = new JButton("Add");
//			btnEdit = new JButton("Edit");
//			btnRemove = new JButton("Remove");
//			btnAddBay = new JButton("Add Service Bay");
//			btnFillBay = new JButton("Fill Service Bay");
//			btnReleaseBay = new JButton("Finish Repair of Vehicle");
//			btnFilter = new JButton("Filter");
//			
//			//Set up Directory table
//			carTableModel = new CarTableModel();
//			tableCar = new JTable(carTableModel);
//			tableCar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//			tableCar.setPreferredScrollableViewportSize(new Dimension(500, 500));
//			tableCar.setFillsViewportHeight(true);
//			
//			
//			
//			btnAdd.addActionListener(this);
//			btnEdit.addActionListener(this);
//			btnRemove.addActionListener(this);
//			btnAddBay.addActionListener(this);
//			btnFillBay.addActionListener(this);
//			btnReleaseBay.addActionListener(this);
//			btnFilter.addActionListener(this);
//			
//			setLayout(new GridLayout(2, 1));
//			JPanel pnlData = new JPanel(); 
//			pnlData.add(btnAdd);
//			pnlData.add(btnEdit);
//			pnlData.add(btnRemove);
//			pnlData.add(lblFilter);
//			pnlData.add(txtFilter);
//
//			pnlData.add(btnFilter);
//			add(pnlData);
//			JPanel pnlBtm = new JPanel();
//			setLayout(new GridLayout(2, 2));
//			pnlBtm.add(btnAddBay);
//			pnlBtm.add(btnFillBay);
//			pnlBtm.add(btnReleaseBay);
//			pnlBtm.add(displayBay);
//			add(pnlBtm);
//			
//		}
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			if(e.getSource() == btnAdd) {
//				if (e.getSource().equals(btnAdd)) {
//					UserDialog pane = new UserDialog();
//					pane.setVisible(true);
//					Vehicle v = pane.getNewVehicle();
//					if (v != null) {
//				  			serviceMgr.putOnWaitingList(v);
//					}
//				}
//				
//				displayBox.setText(serviceMgr.printWaitList(""));
//				cardLayout.show(panel, GARAGE_PANEL);
//				RepairGarageGUI.this.repaint();
//				RepairGarageGUI.this.revalidate();
//			}else if(e.getSource() == btnEdit) {
//				cardLayout.show(panel, EDIT_PANEL);
//			}
//			else if(e.getSource() == btnRemove) {
//				
//			}  
//			else if(e.getSource() == btnAddBay){
//				serviceMgr.addNewBay();
//				cardLayout.show(panel, GARAGE_PANEL);
//			}
//			else if(e.getSource() == btnFillBay) {
//				serviceMgr.fillServiceBays();
//				cardLayout.show(panel, GARAGE_PANEL);
//			}
//			else if(e.getSource() == btnReleaseBay) {
//				cardLayout.show(panel, RELEASE_PANEL);
//			}
//		}
//		
//	}
//	
//	/**
//	 * This class is used to edit the GUI
//	 * @author jhnguye4
//	 *
//	 */
//	private class EditPanel extends JPanel implements ActionListener {
//		/** ID number used for object serialization. */
//		private static final long serialVersionUID = 1L;
//		/**
//		 * This method is used to perform actions 
//		 */
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//	}
//
//	private class ReleaseBayPanel extends JPanel implements ActionListener {
//		/** ID number used for object serialization. */
//		private static final long serialVersionUID = 1L;
//		/**field for text area*/
//		private JTextArea instruction;
//		/**field for bayIndex*/
//		private JTextField bayIndex;
//		/**field for garage*/
//		private JTextArea garage;
//		/**button for release*/
//		private JButton btnRelease;
//		/**field to scroll*/
//		private JScrollPane scroll;
//		
//		/**
//		 * method calls the release panel
//		 */
//		public ReleaseBayPanel() {
//			instruction = new JTextArea(50, 50);
//			instruction.setText("Please input a number to release the ServiceBay." 	+ 
//					" Please only input numbers between 1-30 as bay 1 correlates to the bay at the "
//					+ "top of the list and 30 is at the end of the list if all 30 bays are added to the garage.");
//			instruction.setLineWrap(true);
//			instruction.setWrapStyleWord(true);
//			instruction.setEditable(false);
//			bayIndex = new JTextField("", 2);
//			//serviceMgr.printServiceBays()
//			garage = new JTextArea(800, 500);
//			garage.setEditable(false);
//			scroll = new JScrollPane(garage);
//			btnRelease = new JButton("Release");
//
//			btnRelease.addActionListener(this);
//					
//			setLayout(new GridLayout(3, 1));
//			JPanel pnlTop = new JPanel();
//			pnlTop.add(instruction);
//			add(pnlTop);
//			setLayout(new GridLayout(3, 2));
//			JPanel pnlMid = new JPanel();
//			pnlMid.add(bayIndex);
//			pnlMid.add(btnRelease);
//			add(pnlMid);
//			setLayout(new GridLayout(3, 2));
//			JPanel pnlBtm = new JPanel();
//			pnlBtm.add(scroll);
//			add(pnlBtm);
//		}
//		/**
//		 * this method is called upon to do actions
//		 */
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			if(e.getSource() == btnRelease) {
//				String index = bayIndex.getText();
//				serviceMgr.releaseFromService(Integer.valueOf(index));
//				cardLayout.show(panel, GARAGE_PANEL);
//			}
//			
//		}
//	}
//	
//	/**
//	 * {@link StudentDirectoryTableModel} is the object underlying the {@link JTable} object that displays
//	 * the list of Students to the user.
//	 * @author Sarah Heckman
//	 */
//	private class CarTableModel extends AbstractTableModel {
//		
//		/** ID number used for object serialization. */
//		private static final long serialVersionUID = 1L;
//		/** Data stored in the table */
//		private Object [] data;
//		
//		/**
//		 * Constructs the {@link StudentDirectoryTableModel} by requesting the latest information
//		 * from the {@link RequirementTrackerModel}.
//		 */
//		public CarTableModel() {
//			updateData();
//		}
//
//
//		/**
//		 * Returns the number of rows in the table.
//		 * @return the number of rows in the table.
//		 */
//		public int getRowCount() {
//			if (data == null) 
//				return 0;
//			return data.length;
//		}
		

//		/**
//		 * Returns the data at the given {row, col} index.
//		 * @return the data at the given location.
//		 */
//		public Object getValueAt(int row) {
//			if (data == null)
//				return null;
//			return data[row];
//		}
		
		/**
		 * Sets the given value to the given {row, col} location.
		 * @param value Object to modify in the data.
		 * @param row location to modify the data.
		 * @param column location to modify the data.
		 */
//		public void setValueAt(Object value, int row) {
//			data[row] = value;
//			fireTableCellUpdated(row, 0);
//		}
		
//		/**
//		 * Updates the given model with {@link Student} information from the {@link StudentDirectory}.
//		 */
//		public void updateData() {
//			String[] list = null;
//			int count = 0;
//			Scanner waitlist = new Scanner(serviceMgr.printWaitList(""));
//			Scanner waitlist2 = new Scanner(serviceMgr.printWaitList(""));
//			while(waitlist.hasNext()) { 
//				count++;
//			}
//			table = new JTable(0, 2);
//			for(int i = 0; i > count; i++) {
//				list = new String[1];
//				list[0] = waitlist2.nextLine();
//				
//				DefaultTableModel model = (DefaultTableModel)table.getModel();
//				model.addRow(list);
//			}
//			waitlist.close();
//			waitlist2.close();
//			data = new Object[count];
//			data = list;
//		}
//
//
//		@Override
//		public int getColumnCount() {
//			return 0;
//		}
//
//
//		@Override
//		public Object getValueAt(int rowIndex, int columnIndex) {
//			return null;
//		}
//	}

}
