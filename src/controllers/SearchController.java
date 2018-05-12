package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;

import models.Movie;
import models.MovieDatabase;
import views.View;

/**
 * Controller for the Search window
 * @author Thom Bilton 15904009
 *
 */
public class SearchController extends JFrame
{ 
	private MovieDatabase searchableDatabase;
	private MovieDatabase searchResults;
	private MovieDatabase removedEnteries;
	private Movie selectedMovie;
	private views.SearchView SearchView;
	private View mainView;
	public models.Movie newSearch;
	public Controller mainWindow;
	
	/**
	 * constructor for the search controller
	 * @param title
	 * @param movieDatabase
	 * @param removedEnteries
	 * @param mainWindow
	 * @author Thom Bilton 15904009
	 */
	public SearchController(String title, MovieDatabase movieDatabase, MovieDatabase removedEnteries, Controller mainWindow, View mainView)
	{
		this.searchableDatabase = movieDatabase;
		this.searchResults = movieDatabase;
		this.removedEnteries = removedEnteries;
		this.mainWindow = mainWindow;
		this.SearchView = new views.SearchView(searchableDatabase);
		this.setMainView(mainView);
		getContentPane().add(this.SearchView);
		setSize(300,360);
		setLocation(550, 0);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);	
		
		SearchView.getSearchButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandlerSearchButton();	
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent event) {
	        	eventHandlerCloseButton();	
	        }
	    });
		
		SearchView.getCloseButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandlerCloseButton();	
			}
		});
	}
	
	/**
	 * event handler for when the search button is pressed. Compares the data entered against that in the database and
	 * removes those entries that do not satisfy the criteria.
	 * @author Thom Bilton 15904009
	 */
	private void eventHandlerCloseButton()
	{
		mainWindow.setEnabled(true);
		this.dispose();
	}
	
	private void eventHandlerSearchButton()
	{
		String title = SearchView.getTitleIn().getText();
		String director = SearchView.getDirectorIn().getText();
		String raitingFirst = SearchView.getRaitingFirstIn().getText();
		if(raitingFirst.equals(""))
		{
			raitingFirst = null;
		}
		String raitingSecond = SearchView.getRaitingSecondIn().getText();
		if(raitingSecond.equals(""))
		{
			raitingSecond = null;
		}
		String lead = SearchView.getLeadIn().getText();
		String cast = SearchView.getCastIn().getText();
		String releaseFirst = null;
		releaseFirst = SearchView.getReleaseFirstIn().getText();
		System.out.println(releaseFirst);
		if(releaseFirst.equals(""))
		{
			releaseFirst = null;
		}
		String releaseSecond = null;
		releaseSecond = SearchView.getReleaseSecondIn().getText();
		if(releaseSecond.equals(""))
		{
			releaseSecond = null;
		}
		System.out.println(releaseSecond);
		System.out.println(searchResults.getMovieDatabase().toString());
		
		for(int r = 0; r< 2; r++)
		{
			for(int i = 0; i< searchableDatabase.getMovieDatabase().size(); i++)
			{
				if((!title.equals("")) && (!(searchableDatabase.getDatabaseEntry(i).getTitle().contains(title))))
				{
					System.out.println(searchableDatabase.getMovieTitle(i));
					System.out.println(searchableDatabase.getDatabaseEntry(i).getuID());
					//Iterate through existing database deleting UID's that do not match from database that will be displayed
					for(int s = 0; s< searchableDatabase.getMovieDatabase().size(); s++)
					{
						if(searchableDatabase.getDatabaseEntry(i).getuID() == searchResults.getDatabaseEntry(s).getuID())
						{
							removedEnteries.getMovieDatabase().add(searchResults.getDatabaseEntry(s));
							searchResults.getMovieDatabase().remove(s);
							System.out.println(searchResults.getMovieDatabase().toString());
							s=0;
							i=0;
						}
					}
				}
			}
			
			for(int i = 0; i< searchableDatabase.getMovieDatabase().size(); i++)
			{
				if((!director.equals("")) && (!(searchableDatabase.getDatabaseEntry(i).getDirector().contains(director))))
				{
					System.out.println(searchableDatabase.getDatabaseEntry(i).getDirector());
					System.out.println(searchableDatabase.getDatabaseEntry(i).getuID());
					//Iterate through existing database deleting UID's that do not match from database that will be displayed
					for(int s = 0; s< searchableDatabase.getMovieDatabase().size(); s++)
					{
						if(searchableDatabase.getDatabaseEntry(i).getuID() == searchResults.getDatabaseEntry(s).getuID())
						{
							removedEnteries.getMovieDatabase().add(searchResults.getDatabaseEntry(s));
							searchResults.getMovieDatabase().remove(s);
							System.out.println(searchResults.getMovieDatabase().toString());
							s=0;
							i=0;
						}
					}
				}
			}
			
			for(int i = 0; i< searchableDatabase.getMovieDatabase().size(); i++)
			{
				if(raitingFirst !=null && raitingSecond != null)
				{	
				if((!(Integer.parseInt(searchableDatabase.getDatabaseEntry(i).getRaiting())>= Double.parseDouble(raitingFirst))) || (!(Integer.parseInt(searchableDatabase.getDatabaseEntry(i).getRaiting())<= Double.parseDouble(raitingSecond))))
				{
					System.out.println(searchableDatabase.getDatabaseEntry(i).getRaiting());
					System.out.println(searchableDatabase.getDatabaseEntry(i).getuID());
					//Iterate through existing database deleting UID's that do not match from database that will be displayed
					for(int s = 0; s< searchableDatabase.getMovieDatabase().size(); s++)
					{
						if(searchableDatabase.getDatabaseEntry(i).getuID() == searchResults.getDatabaseEntry(s).getuID())
						{
							removedEnteries.getMovieDatabase().add(searchResults.getDatabaseEntry(s));
							searchResults.getMovieDatabase().remove(s);
							System.out.println(searchResults.getMovieDatabase().toString());
							s=0;
							i=0;
						}
					}
				}
				}
			}
			
			for(int i = 0; i< searchableDatabase.getMovieDatabase().size(); i++)
			{
				if((!lead.equals("")) && (!(searchableDatabase.getDatabaseEntry(i).getLeadActor().contains(lead))))
				{
					System.out.println(searchableDatabase.getDatabaseEntry(i).getLeadActor());
					System.out.println(searchableDatabase.getDatabaseEntry(i).getuID());
					//Iterate through existing database deleting UID's that do not match from database that will be displayed
					for(int s = 0; s< searchableDatabase.getMovieDatabase().size(); s++)
					{
						if(searchableDatabase.getDatabaseEntry(i).getuID() == searchResults.getDatabaseEntry(s).getuID())
						{
							removedEnteries.getMovieDatabase().add(searchResults.getDatabaseEntry(s));
							searchResults.getMovieDatabase().remove(s);
							System.out.println(searchResults.getMovieDatabase().toString());
							s=0;
							i=0;
						}
					}
				}
			}
			
			for(int i = 0; i< searchableDatabase.getMovieDatabase().size(); i++)
			{
				if((!cast.equals("")) && (!(searchableDatabase.getDatabaseEntry(i).getCastMembers().contains(cast))))
				{
					System.out.println(searchableDatabase.getDatabaseEntry(i).getCastMembers());
					System.out.println(searchableDatabase.getDatabaseEntry(i).getuID());
					//Iterate through existing database deleting UID's that do not match from database that will be displayed
					for(int s = 0; s< searchableDatabase.getMovieDatabase().size(); s++)
					{
						if(searchableDatabase.getDatabaseEntry(i).getuID() == searchResults.getDatabaseEntry(s).getuID())
						{
							removedEnteries.getMovieDatabase().add(searchResults.getDatabaseEntry(s));
							searchResults.getMovieDatabase().remove(s);
							System.out.println(searchResults.getMovieDatabase().toString());
							s=0;
							i=0;
						}
					}
				}
			}
			
			for(int i = 0; i< searchableDatabase.getMovieDatabase().size(); i++)
			{
				if(releaseFirst !=null && releaseSecond != null)
				{
				if((!(Integer.parseInt(searchableDatabase.getDatabaseEntry(i).getReleaseYear())>= Integer.parseInt(releaseFirst))) || (!(Integer.parseInt(searchableDatabase.getDatabaseEntry(i).getReleaseYear())<= Integer.parseInt(releaseSecond))))
				{
					System.out.println(searchableDatabase.getDatabaseEntry(i).getCastMembers());
					System.out.println(searchableDatabase.getDatabaseEntry(i).getuID());
					//Iterate through existing database deleting UID's that do not match from database that will be displayed
					for(int s = 0; s< searchableDatabase.getMovieDatabase().size(); s++)
					{
						if(searchableDatabase.getDatabaseEntry(i).getuID() == searchResults.getDatabaseEntry(s).getuID())
						{
							removedEnteries.getMovieDatabase().add(searchResults.getDatabaseEntry(s));
							searchResults.getMovieDatabase().remove(s);
							System.out.println(searchResults.getMovieDatabase().toString());
							s=0;
							i=0;
						}
					}
				}
				}
			}
		}
		
		System.out.println("results" +searchResults.getMovieDatabase().toString());
		System.out.println("database" +removedEnteries.getMovieDatabase().toString());
		mainWindow.updateAll();
		mainView.getSearchButton().setEnabled(true);
		mainWindow.setEnabled(true);
		this.dispose();
		
		
	}

	/**
	 * gets view data from main
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public View getMainView() {
		return mainView;
	}

	/**
	 * sets main view
	 * @param mainView
	 * @author Thom Bilton 15904009
	 */
	public void setMainView(View mainView) {
		this.mainView = mainView;
	}
	
}
