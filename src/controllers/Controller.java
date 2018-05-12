package controllers;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.Movie;
import models.MovieDatabase;
import views.View;
/**
 * 
 * @author Thom Bilton 15904009
 *
 */
public class Controller extends JFrame
{

	private MovieDatabase movieDatabase;
	private MovieDatabase backupDatabase;
	private MovieDatabase removedEnteries;
	private Movie selectedMovie;
	private View view;
	public int uniqueID = 0;


	/**
	 * Works as a controller for the main window, processing button and data inputs
	 * @param title
	 * @throws FileNotFoundException
	 * @author Thom Bilton 15904009
	 */
	public Controller(String title) throws FileNotFoundException
	{
		this.movieDatabase = new MovieDatabase();
		this.view = new View(this.movieDatabase);
		this.removedEnteries = new MovieDatabase();
		this.selectedMovie = null;
		getContentPane().add(this.view);
		setSize(540,360);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		loadSave();
		System.out.println(movieDatabase.getMovieDatabase());
		
	    this.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent event) {
	        	eventHandlerClearSearchButton();
	        	try {
					eventHandlerClose();
				} catch (FileNotFoundException | UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    });
		
		view.getAddButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				eventHandlerAddButton();
			}
		});
		
		view.getRemoveButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandlerRemoveButton();	
			}
		});
		
		view.getUpdateButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandlerUpdateButton();	
			}
		});
		
		view.getSearchButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandlerSearchButton();	
			}
		});
		
		view.getClearSearchButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandlerClearSearchButton();	
			}
		});
		
		view.getClearSelection().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandlerClearSelectionButton();	
			}
		});
		
		view.getMovieList().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				eventHandlerUpdateAllFields();
				 //eventHandlerUpdateButton();	
			}
		});
	}
		
		/**
		 * Controls what happens when the add button is pressed
		 * @author Thom Bilton 15904009
		 */
		private void eventHandlerAddButton()
		{
			backupDatabase = movieDatabase;
			uniqueID++;
			int uID = uniqueID;
			uniqueID++;
			String title = view.getTitleIn().getText().trim();
			String director = view.getDirectorIn().getText().trim();
			String raiting = view.getRaitingIn().getText().trim();
			String lead = view.getLeadIn().getText().trim();
			String cast = view.getCastIn().getText().trim();
			String release = view.getReleaseIn().getText().trim();

			if(!(title.isEmpty()||director.isEmpty() || raiting.isEmpty() || lead.isEmpty() || cast.isEmpty() || release.isEmpty()))
			{
				Movie movie = new Movie(uID, title,director, raiting, release, lead, cast);
				System.out.println(uID);
				this.movieDatabase.add(movie);
				this.clearMovieInputs();
				//Movie blank = new Movie(uID+1, "+ New Movie"," "," "," "," "," ");
				//this.movieDatabase.add(blank);
				view.update();
			}
		}
		
		/**
		 * resets text in input boxes to null for new data entry 
		 * @author Thom Bilton 15904009
		 */
		private void clearMovieInputs()
		{
			this.view.getTitleIn().setText("");
			this.view.getDirectorIn().setText("");
			this.view.getRaitingIn().setText("");
			this.view.getLeadIn().setText("");
			this.view.getCastIn().setText("");
			this.view.getReleaseIn().setText("");
		}
		
		/**
		 * updates the view
		 * @author Thom Bilton 15904009
		 */
		public void updateAll()
		{
			view.update();
		}
		
		/**
		 * updates input boxes dependent on what object is selected in the movie list
		 * @author Thom Bilton 15904009
		 */
		public void eventHandlerUpdateAllFields()
		{

			this.selectedMovie = 
					(Movie) this.view.getMovieList().getSelectedValue();
			 
			
			if(selectedMovie!=null)
			{
				this.view.getTitleIn().setText(selectedMovie.getTitle());
				this.view.getDirectorIn().setText(selectedMovie.getDirector());
				this.view.getRaitingIn().setText(selectedMovie.getRaiting());
				this.view.getCastIn().setText(selectedMovie.getCastMembers());
				this.view.getLeadIn().setText(selectedMovie.getLeadActor());
				this.view.getReleaseIn().setText(selectedMovie.getReleaseYear());
			}
			else{

				clearMovieInputs();
			}
			view.update();
		}
		
		/**
		 * controls what happens when the remove button is pressed
		 * @author Thom Bilton 15904009
		 */
		public void eventHandlerRemoveButton()
		{
			this.movieDatabase.removeMovie(selectedMovie);
			this.selectedMovie = null;
			clearMovieInputs();
			backupDatabase = movieDatabase;
			view.update();
		}
		
		/**
		 * controls what happens when the update button is pressed
		 * @author Thom Bilton 15904009
		 */
		private void eventHandlerUpdateButton()
		{
			eventHandlerAddButton();
			eventHandlerRemoveButton();
			
		}
		
		/**
		 * controls what happens when the search button is pressed, calls search window and disables main window
		 * @author Thom Bilton 15904009
		 */
		private void eventHandlerSearchButton()
		{
			//view.getSearchButton().setEnabled(false);
			this.setEnabled(false);
			SearchController searchFrame;
			System.out.println(movieDatabase.getMovieDatabase());
			searchFrame = new SearchController("Search", movieDatabase, removedEnteries, this, view);
			
			for(int i = 0; i< removedEnteries.getMovieDatabase().size(); i++)
			{
				movieDatabase.getMovieDatabase().add(removedEnteries.getDatabaseEntry(i));
			}
			removedEnteries.getMovieDatabase().clear();
			view.update();
			
			searchFrame.setVisible(true);
			
		}
		
		/**
		 * Controls what happens when the close button is pressed, saves database to text file
		 * @throws FileNotFoundException
		 * @throws UnsupportedEncodingException
		 * @author Thom Bilton 15904009
		 */
		private void eventHandlerClose() throws FileNotFoundException, UnsupportedEncodingException
		{
			eventHandlerSaveButton();
			System.exit(0);
		}

		/**
		 * Controls what happens when the clear clear selection button is pressed.
		 * @author Thom Bilton 15904009
		 */
		private void eventHandlerClearSelectionButton()
		{
			clearMovieInputs();
			view.update();
		}

		/**
		 * controls what happens when the clear search button is pressed, clears all search data
		 * @author Thom Bilton 15904009
		 */
		private void eventHandlerClearSearchButton()
		{
			for(int i = 0; i< removedEnteries.getMovieDatabase().size(); i++)
			{
				movieDatabase.getMovieDatabase().add(removedEnteries.getDatabaseEntry(i));
			}
			removedEnteries.getMovieDatabase().clear();
			view.update();
		}
		
		/**
		 * Controls what happens when the save button is pressed, initiates the writing out to a file
		 * @throws FileNotFoundException
		 * @throws UnsupportedEncodingException
		 * @author Thom Bilton 15904009
		 */
		public void eventHandlerSaveButton() throws FileNotFoundException, UnsupportedEncodingException
		{
			try {


				File file = new File("SaveFile/saveFile.txt");

				// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter toFile = new BufferedWriter(fw);
				
				for(int i=0; i < movieDatabase.getMovieDatabase().size(); i++)
				{
				String uIDString = Integer.toString(movieDatabase.getDatabaseEntry(i).getuID());
				toFile.write("@NEW MOVIE");
				toFile.newLine();
				toFile.write("@UID");
				toFile.newLine();
				toFile.write(uIDString);
				toFile.newLine();
				toFile.write("@TITLE");
				toFile.newLine();
				toFile.write(movieDatabase.getDatabaseEntry(i).getTitle());
				toFile.newLine();
				toFile.write("@DIRECTOR");
				toFile.newLine();
				toFile.write(movieDatabase.getDatabaseEntry(i).getDirector());
				toFile.newLine();
				toFile.write("@RAITING");
				toFile.newLine();
				toFile.write(movieDatabase.getDatabaseEntry(i).getRaiting());
				toFile.newLine();
				toFile.write("@RELEASE");
				toFile.newLine();
				toFile.write(movieDatabase.getDatabaseEntry(i).getReleaseYear());
				toFile.newLine();
				toFile.write("@LEAD");
				toFile.newLine();
				toFile.write(movieDatabase.getDatabaseEntry(i).getLeadActor());
				toFile.newLine();
				toFile.write("@ACTORS");
				toFile.newLine();
				toFile.write(movieDatabase.getDatabaseEntry(i).getCastMembers());
				toFile.newLine();
				toFile.write("@END");
				toFile.newLine();


				}
				toFile.close();

				System.out.println("Done");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * method for loading data in from a save file.
		 * @throws FileNotFoundException
		 * @author Thom Bilton 15904009
		 */
		public void loadSave() throws FileNotFoundException
		{
			String input;
			int uID  = 0;
			String title = null;
			String director = null;
			String raiting = null;
			String lead = null;
			String cast = null;
			String release = null;
			Scanner fileInput;
			fileInput = new Scanner(new File("SaveFile/saveFile.txt"));
			if(fileInput.hasNext())
			{
			do{
				input = fileInput.nextLine();
				if(input.equals("@NEW MOVIE"))
				{
					
				}
				else if(input.equals("@UID"))
				{
					uID = fileInput.nextInt();
					this.uniqueID = uID;
					System.out.println(uID);
				}
				else if(input.equals("@TITLE"))
				{
					title = fileInput.nextLine();
				}
				else if(input.equals("@DIRECTOR"))
				{
					director = fileInput.nextLine();
				}
				else if(input.equals("@RAITING"))
				{
					raiting = fileInput.nextLine();
				}
				else if(input.equals("@LEAD"))
				{
					lead = fileInput.nextLine();
				}
				else if(input.equals("@ACTORS"))
				{
					cast = fileInput.nextLine();
				}
				else if(input.equals("@RELEASE"))
				{
					release = fileInput.nextLine();
				}
				else if(input.equals("@END"))
				{
					if(!(title.isEmpty()||director.isEmpty() || raiting.isEmpty() || lead.isEmpty() || cast.isEmpty() || release.isEmpty()))
					{
					Movie movie = new Movie(uID, title,director, raiting, release, lead, cast);
					this.movieDatabase.add(movie);
					this.clearMovieInputs();
					view.update();	
					System.out.println(title +" loaded");
					}
				}
			}
			while(fileInput.hasNext() == true);
			}
		}
		
		/**
		 * method for getting current movie Database
		 * @return MovieDatbase
		 * @author Thom Bilton 15904009
		 */
		public MovieDatabase getDatabase()
		{
			return this.movieDatabase;
		}
		
		/**
		 * method for getting the backup database
		 * @return backupDatabase
		 * @author Thom Bilton 15904009
		 */
		public MovieDatabase getBackupDatabase()
		{
			return this.backupDatabase;
		}
		
		/**
		 * method for getting the entries that are removed from the database during a search
		 * @return removedEnteries
		 * @author Thom Bilton 15904009
		 */
		public MovieDatabase getRemovedEnteries()
		{
			return this.removedEnteries;
		}



	/**
	 * main, initiates the program	
	 * @param args
	 * @throws FileNotFoundException
	 * @author Thom Bilton 15904009
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		Controller frame;
		frame = new Controller("Movie application");
		frame.setVisible(true);
	}
	

}
