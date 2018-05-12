package views;

import java.awt.Font;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import models.Movie;
import models.MovieDatabase;
/**
 * sets the visible layout for the main window
 * @author Thom
 *
 */
public class View extends JPanel
{
	private MovieDatabase dataBase;
	private JButton addButton;
	private JButton removeButton;
	private JList movieList;
	private JScrollPane ScrollPane;
	private JLabel titleM;
	private JTextField titleIn;
	private JLabel directorM;
	private JTextField directorIn;
	private JLabel raitingM;
	private JTextField raitingIn;
	private JLabel leadM;
	private JTextField leadIn;
	private JLabel castM;
	private JTextField castIn;
	private JList<Movie> moviesList;
	private JLabel releaseM;
	private JTextField releaseIn;
	private JButton updateButton;
	private JButton searchButton;
	private JButton clearSelection;
	private JButton clearSearchButton;
	
	/**
	 * gets AddButton
	 * @return addButton
	 * @author Thom Bilton 15904009
	 */
	public JButton getAddButton() 
	{
		return addButton;
	}

	/**
	 * gets remove button
	 * @return removeButton
	 * @author Thom Bilton 15904009
	 */
	public JButton getRemoveButton() {
		return removeButton;
	}
	
	/**
	 * gets movie List
	 * @return movieList
	 * @author Thom Bilton 15904009
	 */
	public JList getMovieList()
	{
		return movieList;
	}

	/**
	 * gets title in field
	 * @return titleIn
	 * @author Thom Bilton 15904009
	 */
	public JTextField getTitleIn() {
		return titleIn;
	}

	/**
	 * gets director in
	 * @return directorIn
	 * @author Thom Bilton 15904009
	 */
	public JTextField getDirectorIn() {
		return directorIn;
	}

	/**
	 * gets raiting in
	 * @return raitingIn
	 * @author Thom Bilton 15904009
	 */
	public JTextField getRaitingIn() {
		return raitingIn;
	}

	/**
	 * gets lead in
	 * @return leadIn
	 * @author Thom Bilton 15904009
	 */
	public JTextField getLeadIn() {
		return leadIn;
	}

	/**
	 * gets cast in field
	 * @return castIn
	 * @author Thom Bilton 15904009
	 */
	public JTextField getCastIn() {
		return castIn;
	}
	
	/**
	 * gets release in data
	 * @return releaseIn
	 * @author Thom Bilton 15904009
	 */
	public JTextField getReleaseIn() {
		return releaseIn;
	}
	
	/**
	 * gets update button
	 * @return updateButton
	 * @author Thom Bilton 15904009
	 */
	public JButton getUpdateButton(){
		return this.updateButton;
	}
	/**
	 * gets search button
	 * @return searchButton
	 * @author Thom Bilton 15904009
	 */
	public JButton getSearchButton(){
		return this.searchButton;
	}
	
	/**
	 * gets save button
	 * @return clearSelection
	 * @author Thom Bilton 15904009
	 */
	public JButton getClearSelection()
	{
		return this.clearSelection;
	}
	
	/**
	 * gets clearSearchButton
	 * @return clearSearchButton
	 * @author Thom Bilton 15904009
	 */
	public JButton getClearSearchButton()
	{
		return this.clearSearchButton;
	}
	
	/**
	 * constructor for the view. sets the size and location of the buttons and inputs.
	 * @param database
	 * @author Thom Bilton 15904009
	 */
	public View(MovieDatabase database)
	{
		this.setLayout(null);
		
		this.dataBase = database;
		
		//Add Button
		this.addButton = new JButton("Add");
		addButton.setSize(95, 30);
		addButton.setLocation(10, 250);
		add(addButton);
		
		//Remove Button
		this.removeButton = new JButton("Remove");
		removeButton.setSize(95, 30);
		removeButton.setLocation(115, 250);
		add(removeButton);
		
		this.updateButton = new JButton("Update Entry");
		updateButton.setSize(195, 30);
		updateButton.setLocation(320, 250);
		add(updateButton);
		
		this.searchButton = new JButton("Search");
		searchButton.setSize(95, 30);
		searchButton.setLocation(320, 280);
		add(searchButton);
		
		this.clearSelection = new JButton("Clear Selection");
		clearSelection.setSize(200, 30);
		clearSelection.setLocation(10, 280);
		add(clearSelection);
		
		this.clearSearchButton = new JButton("Clear");
		clearSearchButton.setSize(95, 30);
		clearSearchButton.setLocation(420, 280);
		add(clearSearchButton);
		
		movieList = new JList<Movie>();
		//add(movieList);
		this.movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.ScrollPane = new JScrollPane(this.movieList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ScrollPane.setLocation(15,10);
		ScrollPane.setSize(190,230);
		add(ScrollPane);
		
		titleM = new JLabel("Title");
		titleM.setLocation(240, 10);
		titleM.setSize(100, 30);
		add(titleM);
		
		titleIn = new JTextField("");
		titleIn.setLocation(330, 10);
		titleIn.setSize(180, 30);
		add(titleIn);
		
		directorM = new JLabel("Director");
		directorM.setLocation(240, 50);
		directorM.setSize(100, 30);
		add(directorM);
		
		directorIn = new JTextField("");
		directorIn.setLocation(330, 50);
		directorIn.setSize(180, 30);
		add(directorIn);
		
		raitingM = new JLabel("Star Raiting");
		raitingM.setLocation(240, 90);
		raitingM.setSize(100, 30);
		add(raitingM);
		
		raitingIn = new JTextField("");
		raitingIn.setLocation(330, 90);
		raitingIn.setSize(180, 30);
		add(raitingIn);
		
		leadM = new JLabel("Genre");
		leadM.setLocation(240, 130);
		leadM.setSize(100, 30);
		add(leadM);
		
		leadIn = new JTextField("");
		leadIn.setLocation(330, 130);
		leadIn.setSize(180, 30);
		add(leadIn);
		
		castM = new JLabel("Cast");
		castM.setLocation(240, 170);
		castM.setSize(100, 30);
		add(castM);
		
		castIn = new JTextField("");
		castIn.setLocation(330, 170);
		castIn.setSize(180, 30);
		add(castIn);
		
		releaseM = new JLabel("Release");
		releaseM.setLocation(240, 210);
		releaseM.setSize(100, 30);
		add(releaseM);
		
		releaseIn = new JTextField("");
		releaseIn.setLocation(330, 210);
		releaseIn.setSize(180, 30);
		add(releaseIn);	
	}
	
	/**
	 * method that updates the view pannel when called
	 * @author Thom Bilton 15904009
	 */
	public void update()
	{
		this.getRemoveButton().setEnabled((this.dataBase.getNoOfMovies()>0));
		this.movieList.setListData(this.dataBase.toList());
	}
}

