package models;

import java.util.ArrayList;
/**
 * class for creating a new movie database that can store movies
 * @author Thom Bilton 15904009
 *
 */
public class MovieDatabase 
{
	private ArrayList<Movie> movies = new ArrayList<Movie>();
	
	/**
	 * converts the array list in
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public Movie[] toList()
	{
		Movie[] moviesList = new Movie[this.movies.size()];
		for(int i = 0;i<moviesList.length;i++)
		{			
			moviesList[i] = this.movies.get(i);
		}

		return moviesList;
	}

	/**
	 * adds a movie to the arrayList
	 * @param movie
	 * @author Thom Bilton 15904009
	 */
	public void add(Movie movie) 
	{
	this.movies.add(movie);	
	}
	
	/**
	 *removes a movie from the arrayList
	 * @param selected
	 * @author Thom Bilton 15904009
	 */
	public void removeMovie(Movie selected)
	{
		this.movies.remove(selected);
	}
	
	/**
	 * gets the number of movies in an array list
	 * @return movies.size
	 * @author Thom Bilton 15904009
	 */
	public int getNoOfMovies()
	{
		return this.movies.size();
	}
	
	/**
	 * gets the entire movie database
	 * @return movies
	 * @author Thom Bilton 15904009
	 */
	public ArrayList<Movie> getMovieDatabase()
	{
		return this.movies;
	}
	
	/**
	 * gets a specific movie in the database
	 * @param i
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public Movie getDatabaseEntry(int i)
	{
		return movies.get(i);
	}
	
	/**
	 * gets the title of a specific movie in the database
	 * @param i
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public String getMovieTitle(int i)
	{
		return movies.get(i).getTitle();
	}
	
	
}
