package views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Movie;
import models.MovieDatabase;
/**
 * Creates the search view
 * @author Thom Bilton 15904009
 *
 */
public class SearchView extends JPanel
{
	private JLabel titleM;
	private JTextField titleIn;
	private JLabel directorM;
	private JTextField directorIn;
	private JLabel raitingM;
	private JTextField raitingFirstIn;
	private JTextField raitingSecondIn;
	private JLabel leadM;
	private JTextField leadIn;
	private JLabel castM;
	private JTextField castIn;
	private JList<Movie> moviesList;
	private JLabel releaseM;
	private JTextField releaseFirstIn;
	private JTextField releaseSecondIn;
	private JButton searchButton;
	private JButton closeButton;
	private MovieDatabase searchDatabase;

	/**
	 * gets the title in
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public JTextField getTitleIn() {
		return titleIn;
	}

	/**
	 * gets director in
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public JTextField getDirectorIn() {
		return directorIn;
	}

	/**
	 * gets raiting First in
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public JTextField getRaitingFirstIn() {
		return raitingFirstIn;
	}
	
	/**
	 * gets raiting Second in
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public JTextField getRaitingSecondIn() {
		return raitingSecondIn;
	}

	/**
	 * gets Lead in
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public JTextField getLeadIn() {
		return leadIn;
	}

	/**
	 * gets cast in
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public JTextField getCastIn() {
		return castIn;
	}
	
	/**
	 * gets the first release field in
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public JTextField getReleaseFirstIn() {
		return releaseFirstIn;
	}
	
	/**
	 * gets the second release field in
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public JTextField getReleaseSecondIn() {
		return releaseSecondIn;
	}
	
	/**
	 * gets the search buton
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public JButton getSearchButton() {
		return searchButton;
	}
	
	/**
	 * gets the close buton
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public JButton getCloseButton() {
		return closeButton;
	}
	
	/**
	 * constructor for the searchWindow
	 * @param searchDatbase
	 * @author Thom Bilton 15904009
	 */
	public SearchView(MovieDatabase searchDatbase)
	{
		this.setLayout(null);
		this.searchDatabase = searchDatabase;
		titleM = new JLabel("Title");
		titleM.setLocation(10, 10);
		titleM.setSize(100, 30);
		add(titleM);
		
		titleIn = new JTextField("");
		titleIn.setLocation(110, 10);
		titleIn.setSize(150, 30);
		add(titleIn);
		
		directorM = new JLabel("Director");
		directorM.setLocation(10, 50);
		directorM.setSize(100, 30);
		add(directorM);
		
		directorIn = new JTextField("");
		directorIn.setLocation(110, 50);
		directorIn.setSize(150, 30);
		add(directorIn);
		
		raitingM = new JLabel("Star Raiting");
		raitingM.setLocation(10, 90);
		raitingM.setSize(100, 30);
		add(raitingM);
		
		raitingFirstIn = new JTextField("");
		raitingFirstIn.setLocation(110, 90);
		raitingFirstIn.setSize(70, 30);
		add(raitingFirstIn);
		
		raitingSecondIn = new JTextField("");
		raitingSecondIn.setLocation(190, 90);
		raitingSecondIn.setSize(70, 30);
		add(raitingSecondIn);
		
		leadM = new JLabel("Genre");
		leadM.setLocation(10, 130);
		leadM.setSize(100, 30);
		add(leadM);
		
		leadIn = new JTextField("");
		leadIn.setLocation(110, 130);
		leadIn.setSize(150, 30);
		add(leadIn);
		
		castM = new JLabel("Cast");
		castM.setLocation(10, 170);
		castM.setSize(100, 30);
		add(castM);
		
		castIn = new JTextField("");
		castIn.setLocation(110, 170);
		castIn.setSize(150, 30);
		add(castIn);
		
		releaseM = new JLabel("Release");
		releaseM.setLocation(10, 210);
		releaseM.setSize(100, 30);
		add(releaseM);
		
		releaseFirstIn = new JTextField("");
		releaseFirstIn.setLocation(110, 210);
		releaseFirstIn.setSize(70, 30);
		add(releaseFirstIn);
		
		releaseSecondIn = new JTextField("");
		releaseSecondIn.setLocation(190, 210);
		releaseSecondIn.setSize(70, 30);
		add(releaseSecondIn);
		
		this.searchButton = new JButton("Search");
		searchButton.setSize(255, 30);
		searchButton.setLocation(10, 260);
		add(searchButton);
		
		this.closeButton = new JButton("Close");
		closeButton.setSize(255, 30);
		closeButton.setLocation(10, 290);
	//	add(closeButton);

	}

	
}
