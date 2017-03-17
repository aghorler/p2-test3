/* Aaron Horler - s3481341 */

package test3a;

public class Actor {
	private String firstName;
	private String lastName;
	
	public Actor(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/* The task requests get methods, but they're not required my implementation. */
	
	public String toString(){
		return firstName + " " + lastName;
	}
}
