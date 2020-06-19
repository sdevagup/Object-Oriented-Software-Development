package shop.data;

/**
 * Implementation of Video interface.
 * @see Data
 */
final class VideoObj implements Video {
  private final String _title;
  private final int    _year;
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if object invariant violated.
   */
  VideoObj(String title, int year, String director) {
 	  
	  _title = title;
    _director = director;
    _year = year;
  }

  public String director() {
    // TODO
    return _director;
  }

  public String title() {
    // TODO
    return _title;
  }

  public int year() {
    // TODO
    return _year;
  }

  public boolean equals(Object thatObject) {
    // TODO
	 if (!(thatObject instanceof Video)) {
			return false;
		}
		Video that = (Video) thatObject;
		return _title.equals(that.title())
				&& (_year == that.year())
				&& _director.equals(that.director());
	}

	  
	  
	  
  public int hashCode() {
    // TODO
	  int r = 17;
		r = 37*r + _title.hashCode();
		r = 37*r + _year;
		r = 37*r + _director.hashCode();
		return r;
	}

  public int compareTo(Video that) {
    // TODO
	  int titleDiff = _title.compareTo(that.title());
		if (titleDiff != 0) {
			return titleDiff;
		}
		int yearDiff = _year - that.year();
		if (yearDiff != 0) {
			return yearDiff;
		}
		int directorDiff = _director.compareTo(that.director());
		if (directorDiff != 0) {
			return directorDiff;
		}
		return 0;
	}
  
  
  
  

  public String toString() {
    // TODO
	  return _title.trim() + " (" + Integer.toString(_year) + ") : " + _director.trim();


  }
}
