package hust.soict.dsai.aims.screen;

import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class StoreManagerScreen extends JFrame {

	private Store store;
	
	public StoreManagerScreen(Store store) {
		this.store = store;

		store.print();

        Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024,768);
		setLocationRelativeTo(null);
        setVisible(true);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu updateStore = new JMenu("Update Store");

		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(e -> {
			new AddBookToStoreScreen(this.store);
			dispose();
		});
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(e -> {
			new AddCDToStoreScreen(this.store);
			dispose();
		});		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(e -> {
			new AddDVDToStoreScreen(this.store);
			dispose();
		});

        updateStore.add(addBook);
        updateStore.add(addDVD);
		updateStore.add(addCD);

		JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
			new StoreManagerScreen(store);
			dispose();
		});

		JMenuItem logOut = new JMenuItem("Log out");
		logOut.addActionListener(e -> {
			new LoginScreen(store);
			dispose();
		});

		menu.add(updateStore);
		menu.add(viewStore);
        menu.add(logOut);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
				
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}

    JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (Media media: mediaInStore) {
			MediaStore cell = new MediaStore(media);
			center.add(cell);
		}
		
		return center;
	}	

}
