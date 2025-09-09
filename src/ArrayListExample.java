import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		//Adding an element
		al.add("Navya");
		System.out.println("ArrayList after adding an element : "+ al);
		
		al.add(0,"Bagathi");
		System.out.println("ArrayList after adding another element at index 0 : "+ al);
		
		ArrayList<String> al2 = new ArrayList<>();
		al2.add("Rama");
		al2.add("Divya");
		
		al.addAll(al2);
		System.out.println("ArrayList after adding another list : "+ al);
		
		//Updating an element
		al.set(2, "Sita");
		System.out.println("ArrayList after updating element at index 2 : "+ al);
	}
}
