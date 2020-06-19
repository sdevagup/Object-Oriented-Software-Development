package hw4.shop.data;

/**
 * Implementation of Video interface.
 * @see Data
 */
final class VideoObj implements Video {
  private final String _title;
  private final int    _year;
  private final String _director;
  private int hcode;
  /**
   * Initialize all object attributes.
   */
  VideoObj(String title, int year, String director) {
	  if (director == null || director == "" || director == " ")
          throw new IllegalArgumentException();
	  else
		  _director = director.trim();
	  if (year <= 1800 ||  year >= 5000)
          throw new IllegalArgumentException();
	  else
		  _year = year;
  
	  if (title == null || title == "" || title == " ")
          throw new IllegalArgumentException();
	  else
		  _title = title.trim();}  

  public String director() {
    // TODO
	
	  
	//return "director"  
	return _director;

  }

  public String title() {
    // TODO
    //return "title";
	  return _title;
  }

  public int year() {
    // TODO
    //return -1;
	return _year;  
  }

  public boolean equals(Object thatObject) {
    // TODO
	  if(thatObject != null) {
	  if (this == thatObject)  {return true;}
		  if (!(this.getClass().equals(thatObject.getClass()))) 
		      return false;
		  VideoObj that = (VideoObj) thatObject;
		  return _director.equals(that.director()) && _title.equals(that.title()) && _year == that.year(); }
	  else  
	return false;
  }

  public int hashCode() {
    // TODO
	  if (hcode == 0) {
		  hcode = 17;hcode = 37*hcode + _title.hashCode();hcode = 37*hcode + _year;hcode = 37*hcode + _director.hashCode();
	}
	return hcode;
  }

  public int compareTo(Video that) {
    // TODO
	  int yResult;
	  if (this == that)
	      return 0;
	  VideoObj thatO = (VideoObj) that;
	  int tResult = _title.compareTo(thatO.title());
	  if (_year == thatO.year()) {
		  yResult = 0;
	  }else if (_year < thatO.year()) {
		  yResult = -1;
	  }else {
		  yResult = 1;
	  }int dResult = _director.compareTo(thatO.director());
	  if (tResult != 0)
	    	return tResult;
	    else if(yResult!= 0)
	    	return yResult;
	    else 
	    	return dResult;
  }
  

  public String toString() {
    // TODO
    return _title + " (" + _year + ") : " + _director;
  }
}
