/* Aaron Horler - s3481341 */

package test3a;

import java.util.*;

public class Movie {
	private String title;
	private String director;
	private int year;
	/* I'm using a Collection of type Actor instead of an ArrayList */
	private Collection<Actor> actors;
	
	public Movie(String title, String director, int year, Collection<Actor> actors){
		this.title = title;
		this.director = director;
		this.year = year;
		this.actors = actors;
	}
	
	/* The task requests get methods, but they're not required my implementation. */
	
	public String toString(){
		return title + ", by " + director + ", " + year + ". Cast: " + actors;
	}
}
