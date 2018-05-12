package models;

import java.util.ArrayList;

public class SearchDatabase 
{
	private ArrayList<Movie> searchMovies = new ArrayList<Movie>();

	public void add(Movie movie) 
	{
	this.searchMovies.add(movie);	
	}
	
	public void removeMovie(Movie selected)
	{
		this.searchMovies.remove(selected);
	}

}
