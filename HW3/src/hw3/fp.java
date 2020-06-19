package hw3;
import java.util.List;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class fp {
	
	

static <U,V> List<V> map(Iterable<U> l, Function<U,V> f) {
	List<V> array = new ArrayList<V>();
	for (U k : l) {
		array.add(f.apply(k));
	}
	System.out.println(array);
	return array;
}



static <U,V> V foldLeft(V e, Iterable<U>l, BiFunction<V,U,V> f){
	
	if (l == null) return e;
	
	for (U k : l) {
		e = f.apply(e, k);
	}
	return e;
}


static <U,V> V foldRight(V e, Iterable<U>l, BiFunction<U,V,V> f){
	
	if (l == null) return e;
	
	for (U k : l) {
		e = f.apply(k, e);
	}
	return e;
}


static <U> Iterable<U> filter(Iterable<U> l, Predicate<U> p){
	List<U> array = new ArrayList<U>();
	
	for (U k : l) {
		if (p.test(k))
			array.add(k);
	}
	
	return array;
}


static <U> U minVal(Iterable<U> l, Comparator<U> c){
	// write using fold.  No other loops permitted. 
	Iterator<U> i = l.iterator();
	U first = i.next();
	U result = foldLeft(first,l,(x,y) -> c.compare(x, y) < 0 ? x : y);
	
	return result;
}


static <U extends Comparable<U>> int minPos(Iterable<U> l){
	// write using fold.  No other loops permitted.
	BiFunction<Integer,U,Integer> bf = new BiFunction<Integer,U,Integer>(){
		
		public Integer apply(Integer x, U y) {
			ArrayList<U> list = new ArrayList<>();
			l.forEach(list::add);
			if(list.get(x).compareTo(y) < 0)
			{
				return x;
			}
			else if(list.get(x).compareTo(y) > 0)
			{
				return list.indexOf(y);
			}
			else
				return x;
		}
	};
	
	int res = foldLeft(0,l,bf);
	return res;
}

	public static void main(String[] args) {
		// (1) Use map to implement the following behavior (described in Python).  i.e given a List<T> create a List<Integer> of the hashes of the objects.
		// names = ['Mary', 'Isla', 'Sam']
		// for i in range(len(names)):
		       // names[i] = hash(names[i])
		
		// (2) Use foldleft to calculate the sum of a list of integers.
		// i.e write a method: int sum(List<Integer> l)
		
		// (3) Use foldRight to concatenate a list of strings i.e write a method
		// String s (List<String> l)
		
		// (4) consider an array of Persons. Use filter to 
		// print the names of the Persons whose salary is
		// greater than 100000
		
		// (5) Use minVal to calculate the minimum of a List of 
		//       Integers
		
        // (6) Use minVal to calculate the maximum of a List of 
		//       Integers
		
		// (7)  Use minPos to calculate the position of the
		// minimum in  a List of  Integers

		// (8)  Use minPos to calculate the position of the
		// minimum in  a List of  String
	}

}

class Person{
	final int salary;
	final String name;
	
	Person(int salary, String name){
		this.salary = salary;
		this.name = name;
	}
	
	int getSalary() { return salary; }
	String name() { return name;}
	
}