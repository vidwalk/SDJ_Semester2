package zair.domain.model;

import java.io.Serializable;

/**
 *
 * @author Group 6, ICT Engineering, Semester 2
 * @param userID
 * @param passowrd
 */
public class Credentials implements Serializable
{
   /**
	 *
	 */
	private static final long serialVersionUID = 1L;
private String userId;
   private String password;
/**
 * The constructor sets the value for the class fields
 * @param userId
 * @param password
 */
   public Credentials(String userId, String password)
   {
      this.userId = userId;
      this.password = password;
   }
/**
 * Method used to return the userID
 * @return String with the userID field
 */
   public String getUserId()
   {
      return userId;
   }
/**
 * Method used to return the password
 * @return String with the password field
 */
   public String getPassword()
   {
      return password;
   }
}
