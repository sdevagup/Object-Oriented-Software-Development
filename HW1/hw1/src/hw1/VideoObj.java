package hw1;
// TODO:  complete the methods
/**
 * Immutable Data Class for video objects.
 * Comprises a triple: title, year, director.
 *
 * @objecttype Immutable Data Class
 * @objectinvariant
 *   Title is non-null, no leading or final spaces, not empty string.
 * @objectinvariant
 *   Year is greater than 1800, less than 5000.
 * @objectinvariant
 *   Director is non-null, no leading or final spaces, not empty string.
 */
final class VideoObj implements Comparable {
  /** @invariant non-null, no leading or final spaces, not empty string */
  private final String _title;
  /** @invariant greater than 1800, less than 5000 */
  private final int    _year;
  /** @invariant non-null, no leading or final spaces, not empty string */
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if any object invariant is violated.
   */
  VideoObj(String title, int year, String director) {
    // TODO  
	  if (title == null || title == "" || title == " ")
          throw new IllegalArgumentException("title can't be null or empty or spaces");
	  else
		  _title = title.trim();
	  
	  if (year <= 1800 ||  year >= 5000)
          throw new IllegalArgumentException("year can't be less than 1800 or bigger than 5000");
	  else
		  _year = year;
	  
	  if (director == null || director == "" || director == " ")
          throw new IllegalArgumentException("director can't be null or empty or spaces");
	  else
		  _director = director.trim();
     
  }

  /**
   * Return the value of the attribute.
   */
  public String director() {
    // TODO  
    return _director;
  }

  /**
   * Return the value of the attribute.
   */
  public String title() {
    // TODO  
    return _title;
  }

  /**
   * Return the value of the attribute.
   */
  public int year() {
    // TODO  
    return _year;
  }

  /**
   * Compare the attributes of this object with those of thatObject.
   * @param thatObject the Object to be compared.
   * @return deep equality test between this and thatObject.
   */
  public boolean equals(Object thatObject) {
    // TODO  
	  if (this == thatObject)
	      return true;
	  if (!(this.getClass().equals(thatObject.getClass())))
	      return false;
	  
	  VideoObj that = (VideoObj) thatObject;
	  return _director.equals(that.director()) && _title.equals(that.title()) && _year == that.year();
  }

  /**
   * Return a hash code value for this object using the algorithm from Bloch:
   * fields are added in the following order: title, year, director.
   */
  private int hcode;
  public int hashCode() {
    // TODO  
	  
	  if (hcode == 0) {
		  hcode = 17;
	      hcode = 37*hcode + _title.hashCode();
	      hcode = 37*hcode + _year;
	      hcode = 37*hcode + _director.hashCode();
	    }
	    return hcode;
  }

  /**
   * Compares the attributes of this object with those of thatObject, in
   * the following order: title, year, director.
   * @param thatObject the Object to be compared.
   * @return a negative integer, zero, or a positive integer as this
   *  object is less than, equal to, or greater thatObject.
   * @throws ClassCastException if thatObject has an incompatible type.
   */
  public int compareTo(Object thatObject) {
    // TODO  
	  if (this == thatObject)
	      return 0;
	  
	  VideoObj that = (VideoObj) thatObject;
	  
	  int titleResult = _title.compareTo(that.title());
	  boolean yearResult = _year == that.year();
	  int directorResult = _director.compareTo(that.director());
	  
	    if (titleResult != 0)
	    	return titleResult;
	    else if(!yearResult)
	    	return -1;
	    else 
	    	return directorResult;
  }

  /**
   * Return a string representation of the object in the following format:
   * <code>"title (year) : director"</code>.
   */
  public String toString() {
    // TODO  
    return _title + " (" + _year + ") : " + _director;
  }
}
