package hw3;
import org.junit.Assert;
import junit.framework.TestCase;
import java.util.*;
import java.util.function.Predicate;
import java.util.Comparator;


public class fpTest extends TestCase{
	fp f = new fp();
	
	/* 
	 
	 
	@Test
	void testMap() {
		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0; i < 10; i++) l.addFirst(i+1);
		List<Integer> u = fp.map(l, (Integer x) -> {return x+1;});
	}
	
	 */
	public void testMap() {
		
		
		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0; i < 10; i++) l.addFirst(i+1);
		List<Integer> u = fp.map(l, (Integer x) -> {return x;});
		Assert.assertTrue(l.equals(u));

		
		
		List<String> l1 = Arrays.asList("Mary","Tom","Jerry");
		List l2 = new ArrayList();
		for (Object o : l1) {
			l2.add(o.hashCode());
		}
		Assert.assertTrue(l2.equals(fp.map(l1, s -> s.hashCode())));
		
		
		
		
	}
	
	
	
	public void testFoldLeft() {
		
		
		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0; i < 10; i++) l.addFirst(i+1);
		System.out.println(fp.foldLeft(0, l, (Integer x, Integer y) -> {return x+y;}));
		assertTrue(55 == fp.foldLeft(0, l, (Integer x, Integer y) -> {return x+y;}));
	
		LinkedList<String> l1 = new LinkedList<>();
		l1.add("Mary");
		l1.add("Tom");
		l1.add("Jerry");
		Assert.assertTrue(fp.foldLeft("", l1, (x,y)-> x + y).equals("MaryTomJerry"));
		
		
		
	}
	
	
	
	
	/*
	 
	@Test
	void testFoldRight() {
		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0; i < 10; i++) l.addFirst(i+1);
		assertTrue(55 == 
fp.foldRight(0, l, (Integer x, Integer y) -> {return x+y;}));
	}
	 
	 
	 */
	
	
	
	public void testFoldRight() {
		
		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0; i < 10; i++) l.addFirst(i+1);
		assertTrue(55 == fp.foldRight(0, l, (Integer x, Integer y) -> {return x+y;}));
	

		LinkedList<String> l1 = new LinkedList<>();
		l1.add("Mary");
		l1.add("Tom");
		l1.add("Jerry");
		Assert.assertTrue(fp.foldLeft("", l1, (x,y)-> y + x).equals("JerryTomMary"));
		}
	
	/*
	 
	 	@Test
	void testFilter() {
		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0; i < 10; i++) l.addFirst(i+1);
		
		Iterable<Integer>i = fp.filter(l, (Integer x ) -> {return x%2 == 0;}); 
		int u = 0;
		for (Integer a: i) u++;
		assertTrue(u==5);
	}	 
	 */

	
	
	
	
	public void testFilter() {
		
		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0; i < 10; i++) l.addFirst(i+1);
		Iterable<Integer>i = fp.filter(l, (Integer x ) -> {return x%2 == 0;}); 
		int u = 0;
		for (Integer a: i) u++;
		assertTrue(u==5);
		
		
		List<Person> List = new ArrayList();
		List.add(new Person(750000,"Mary"));
		List.add(new Person(100000,"Tom"));
		List.add(new Person(20000,"Jerry"));
		Predicate<Person> salary = n -> n.salary > 100000;
		Iterable<Person> personResult = fp.filter(List, salary);
		for (Person p : personResult) {
			Assert.assertTrue(p.name.equals("Mary") || p.name.equals("Jerry"));
		}
		
	}
	
	/*

	@Test
	void testMinVal() {
		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0; i < 10; i++) l.addFirst(i+1);
		
		assertTrue(1==fp.minVal(l, (Integer x, Integer y) -> {return x-y;} ));
	}	
	
	
	*/
	
	public void testMinVal() {
		List<Integer> l1 = Arrays.asList(1,2,3,4,5);
		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0; i < 10; i++) l.addFirst(i+1);
		
		assertTrue(1==fp.minVal(l, (Integer x, Integer y) -> {return x-y;} ));
		
		Comparator<Integer> max = new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				return x > y ? -1 : 1;
			}
		};
		Comparator<Integer> min = new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				return x < y ? -1 : 1;
			}
		};
		
		
		
		Assert.assertTrue(1==fp.minVal(l1, min));
		
	}
	
	
	/*
	 	@Test
	void testMinPos() {
		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0; i < 10; i++) l.addFirst(i+1);
		
		assertTrue(9==fp.minPos(l));
	}
	 	 */
	

	public void testMinPos() {

		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0; i < 10; i++) l.addFirst(i+1);
		assertTrue(9==fp.minPos(l));
		
		List<String> l1 = Arrays.asList("C","B","A");
		Assert.assertTrue(2 == fp.minPos(l1));

		
		
	}
}
