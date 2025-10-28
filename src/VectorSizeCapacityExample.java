import java.util.Vector;

public class VectorSizeCapacityExample {
	public static void main(String[] args) {
		//Initial capacity 2
		Vector<Integer> numbers = new Vector<>(2);
		
		System.out.println("Initial size: "+numbers.size());
		System.out.println("Initial Capacity: "+numbers.capacity());
		
		//Adding elements
		numbers.add(10);
		numbers.add(20);
		
		System.out.println("\nAfter adding 2 elements:");
		System.out.println("Size: "+numbers.size());
		System.out.println("Capacity : "+numbers.capacity());
		
		//Adding 3rd element -> capacity will increase automatically(doubles)
		numbers.add(30);
		
		System.out.println("\nAfter adding 3rd element : ");
		System.out.println("Size : "+numbers.size());
		System.out.println("Capacity : "+numbers.capacity());
		
		//Removing one element
		System.out.println("\nAfter removing element at index 1 : ");
		System.out.println("Size : "+numbers.size());
		System.out.println("Capacity(remains same) : "+numbers.capacity());
	}
}
