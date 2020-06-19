package hw1;

import junit.framework.Assert;
import junit.framework.TestCase;

// TODO:  complete the tests
public class VideoTEST extends TestCase {
  public VideoTEST(String name) {
    super(name);
  }
  public void testConstructorAndAttributes() {
    String title1 = "XX";
    String director1 = "XY";
    String title2 = " XX ";
    String director2 = " XY ";
    int year = 2002;

    VideoObj v1 = new VideoObj(title1, year, director1);
    Assert.assertSame(title1, v1.title());
    Assert.assertEquals(year, v1.year());
    Assert.assertSame(director1, v1.director());

    VideoObj v2 = new VideoObj(title2, year, director2);
    Assert.assertEquals(title1, v2.title());
    Assert.assertEquals(director1, v2.director());
  }

  public void testConstructorExceptionYear() {
    try {
      new VideoObj("X", 1800, "Y");
      Assert.fail();
    } catch (IllegalArgumentException e) { }
    try {
      new VideoObj("X", 5000, "Y");
      Assert.fail();
    } catch (IllegalArgumentException e) { }
    try {
      new VideoObj("X", 1801, "Y");
      new VideoObj("X", 4999, "Y");
    } catch (IllegalArgumentException e) {
      Assert.fail();
    }
  }

  public void testConstructorExceptionTitle() {
    try {
      new VideoObj(null, 2002, "Y");
      Assert.fail();
    } catch (IllegalArgumentException e) { }
    try {
      new VideoObj("", 2002, "Y");
      Assert.fail();
    } catch (IllegalArgumentException e) { }
    try {
      new VideoObj(" ", 2002, "Y");
      Assert.fail();
    } catch (IllegalArgumentException e) { }
  }

  public void testConstructorExceptionDirector() {
    // TODO  
	  try {
		  new VideoObj("X", 2000,null);
		  Assert.fail();
	  } catch (IllegalArgumentException e) {}
	  
	  // Test if giving an empty string will throw IllegalArgumentException
	  try {
		  new VideoObj("X", 2000,"");
		  Assert.fail();
	  } catch (IllegalArgumentException e) {}
	  
	  // Test if empty string is detected after trimming the leading and trailing white spaces
	  try {
		  new VideoObj("X", 2000," ");
		  Assert.fail();
	  } catch (IllegalArgumentException e) {}
	  
  }
  public void testHashCode() {
    Assert.assertEquals
      (-875826552,
       new VideoObj("None", 2009, "Zebra").hashCode());
    Assert.assertEquals
      (-1391078111,
       new VideoObj("Blah", 1954, "Cante").hashCode());
  }

  public void testEquals() { 
    // TODO      
	  	VideoObj p1 = new VideoObj("PRAVALLIKA", 2009, "DSS");
	    VideoObj p2 = new VideoObj("PRAVALLIKA", 2009, "DSS");
	    VideoObj p3 = new VideoObj("ADAM", 2019, "EVE");
	    VideoObj p4 = new VideoObj("JAMES", 2109, "BOND");
	   	
	    Assert.assertTrue(p1.equals(p1));
	    Assert.assertTrue(p1.equals(p2));
	    Assert.assertFalse(p1.equals(p3));
	    Assert.assertFalse(p1.equals(p4));
  }

  public void testCompareTo() { 
    // TODO  
		VideoObj p1 = new VideoObj("PRAVALLIKA", 2009, "DSS");
	    VideoObj p2 = new VideoObj("PRAVALLIKA", 2009, "DSS");
	    VideoObj p3 = new VideoObj("ADAM", 2019, "EVE");
	    VideoObj p4 = new VideoObj("JAMES", 2109, "BOND");
	   	

	    Assert.assertTrue(0 == p1.compareTo(p1));
	    Assert.assertTrue(0 == p1.compareTo(p2));
	    Assert.assertTrue(0 > p1.compareTo(p3));
	    Assert.assertTrue(0 > p1.compareTo(p4));
	    Assert.assertTrue(0 > p4.compareTo(p3));
	    Assert.assertTrue(0 < p3.compareTo(p4));
	    Assert.assertTrue(0 == p2.compareTo(p1));
  }

  public void testToString() { 
    // TODO  
	  VideoObj p = new VideoObj("PRAVALLIKA", 2009, "DSS");
	    Assert.assertEquals("PRAVALLIKA (2009) : DSS", p.toString());
  }
}
