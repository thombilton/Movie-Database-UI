package models;
/**
 * Creates the class Movie to store information about movies
 * @author Thom Bilton 15904009
 *
 */
public class Movie 
{
	private int uID;
	private String title;
	private String director;
	private	String rating;
	private	String releaseYear;
	private	String leadActor;
	private	String castMembers;

	public Movie(int uID,String title, String director, String raiting, String releaseYear, String leadActor, String castMembers)
	{
		this.setuID(uID);
		this.setTitle(title);
		this.setDirector(director);
		this.setRating(raiting);
		this.setReleaseYear(releaseYear);
		this.setLeadActor(leadActor);
		this.setCastMembers(castMembers);
	}
	/**
	 * gets title
	 * @return title
	 * @author Thom Bilton 15904009
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * sets title
	 * @param title
	 * @author Thom Bilton 15904009
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * gets director
	 * @return
	 * @author Thom Bilton 15904009
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * gets director
	 * @param director
	 * @author Thom Bilton 15904009
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	
	/**
	 * gets rating
	 * @return raiting
	 * @author Thom Bilton 15904009
	 */
	public String getRaiting() {
		return rating;
	}
	
	/**
	 * sets raiting
	 * @param rating
	 * @author Thom Bilton 15904009
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	/**
	 * gets release year
	 * @return releaseYear
	 * @author Thom Bilton 15904009
	 */
	public String getReleaseYear() {
		return releaseYear;
	}

	/**
	 * sets release year
	 * @param releaseYear
	 * @author Thom Bilton 15904009
	 */
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	/**
	 * gets lead actor
	 * @return leadActor
	 * @author Thom Bilton 15904009
	 */
	public String getLeadActor() {
		return leadActor;
	}

	/**
	 * sets lead actor
	 * @param leadActor
	 * @author Thom Bilton 15904009
	 */
	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}

	/**
	 * gets cast members
	 * @return castMembers
	 * @author Thom Bilton 15904009
	 */
	public String getCastMembers() {
		return castMembers;
	}

	/**
	 * sets cast members
	 * @param castMembers
	 * @author Thom Bilton 15904009
	 */
	public void setCastMembers(String castMembers) {
		this.castMembers = castMembers;
	}

	/**
	 * gets the unique ID of a movie
	 * @return uID
	 * @author Thom Bilton 15904009
	 */
	public int getuID() {
		return uID;
	}

	/**
	 * sets the unique ID of a movie
	 * @param uID
	 * @author Thom Bilton 15904009
	 */
	public void setuID(int uID) {
		this.uID = uID;
	}
	
	/**
	 * to string method for a movie, returns the title
	 * @author Thom Bilton 15904009
	 * @return getTitle
	 */
	public String toString()
	{
		return this.getTitle();
	}
}

