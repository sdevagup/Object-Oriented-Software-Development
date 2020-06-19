package hw1;

import java.util.Collection;
import junit.framework.Assert;
import junit.framework.TestCase;

// TODO:  completed
public class InventoryTEST extends TestCase {
  public InventoryTEST(String name) {
    super(name);
  }

  // TODO  
  InventorySet is = new InventorySet();
  public void testSize() {
    // TODO  
	  String title1 = "XX";
	  String director1 = "XY";
	  String title2 = "XXx";
	  String director2 = "XYy";
	  int year = 2002;
	  
	  VideoObj v1 = new VideoObj(title1, year, director1);
	  is.addNumOwned(v1, 1);
	  Assert.assertEquals(1, is.size());
	  
	  VideoObj v2 = new VideoObj(title2, year, director2);
	  is.addNumOwned(v2, 1);
	  Assert.assertEquals(2, is.size());
	  
  }

  public void testAddNumOwned() {
    // TODO  
	  String title1 = "XX";
	  String director1 = "XY";
	  int year = 2002;
	  
	  try {
		  is.addNumOwned(null, 1);
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	  
	  try {
		  VideoObj v1 = new VideoObj(title1, year, director1);
		  is.addNumOwned(v1, 0);
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	  
	    try {
	    	VideoObj v1 = new VideoObj(title1, year, director1);
	  	  	is.addNumOwned(v1, 1);
	    } catch (IllegalArgumentException e) {
	      Assert.fail();
	    }
  }

  public void testCheckOutCheckIn() {
    // TODO  
	  String title1 = "XX";
	  String director1 = "XY";
	  int year = 2002;
	  
	  
	  try {
		  VideoObj v1 = new VideoObj(title1, year, director1);
		  is.checkOut(v1);
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	  
	  try {
		  VideoObj v1 = new VideoObj(title1, year, director1);
		  is.checkIn(v1);//checking in without adding first
	      // constructor should have thrown exception
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	  
	  try {
		  VideoObj v1 = new VideoObj(title1, year, director1);
		  is.addNumOwned(v1, 1);
		  is.checkIn(v1);
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	  
	  try {
		  VideoObj v1 = new VideoObj(title1, year, director1);
		  is.addNumOwned(v1, 1);
		  is.checkOut(v1);
		  is.checkOut(v1);
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	  
	  try {
	    	VideoObj v1 = new VideoObj(title1, year, director1);
	  	  	is.addNumOwned(v1, 1);
			is.checkOut(v1);
			is.checkIn(v1);
	    } catch (IllegalArgumentException e) {
	      Assert.fail();
	    }
  }

  public void testClear() {
    // TODO  
	  String title1 = "XX";
	  String director1 = "XY";
	  int year = 2002;
	  
	  VideoObj v1 = new VideoObj(title1, year, director1);
	  is.addNumOwned(v1, 1);
	  Assert.assertEquals(1, is.size());
	  is.clear();
	  Assert.assertEquals(0, is.size());
  }

  public void testGet() {
    // TODO  
	  String title1 = "XX";
	  String director1 = "XY";
	  int year = 2002;
	  int change = 1;
	  
	  VideoObj v1 = new VideoObj(title1, year, director1);
	  Record a = new Record(v1,change,0,0);
	  is.addNumOwned(v1, change);
	  Assert.assertNotSame(a, is.get(v1));
	  Assert.assertSame(a, a);
	  Assert.assertSame(is.get(v1), is.get(v1));
  }

  public void testToCollection() {
        // TODO  
	  String title1 = "XX";
	  String director1 = "XY";
	  String title2 = "XXx";
	  String director2 = "XYx";
	  int year = 2002;
	  int change = 1;
	  
	  VideoObj v1 = new VideoObj(title1, year, director1);
	  is.addNumOwned(v1, change);
	  

	  Collection a = is.toCollection();
	  VideoObj v2 = new VideoObj(title2, year, director2);
	  a.add(v2);
	  Assert.assertNotSame(a.size(), is.size());
  }
}
