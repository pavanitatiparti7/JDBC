import java.util.Vector;

public class SimpleVectorExample {
	public static void main(String[] args) {
		
		//Create a vector of strings
		Vector<String> names = new Vector<>();
		
		//Adding elements
		names.add("Krishna");
		names.add("rama");
		names.add("ravi");
		
		//Printing all elements
		System.out.println("Names in the Vector : "+names);
		
		//Accessing element at index 1
		System.out.println("Element at index 1 : "+names.get(1));
		
		//Removing element
		names.remove("rama");
		System.out.println("After removing rama : "+names);
		
		//Iterating through elements
		System.out.println("Iterating over Vector : ");
		for(String name : names) {
			System.out.println(name);
		}		
	}
}
