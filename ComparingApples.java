import java.util.*;
public class ComparingApples {
	
	public static void main(String... s) {
		Apple a1;
		Apple a2;
		Apple a3;
		Apple a4;
		a1 = new Apple(1);
		a1.setColour("green");
		a2 = new Apple(2);
		a2.setColour("red");
		a3 = new Apple(3);
		a3.setColour("green");
		a4 = new Apple(4);
		a4.setColour("yellow");
		List<Apple> inventory = new ArrayList<>();
		inventory.add(a3);
		inventory.add(a2);
		inventory.add(a1);
		inventory.add(a4);
		System.out.println(inventory.toString());
		System.out.println("=====sorting======");
		Collections.sort(inventory, new Comparator<Apple>() {
						public int compare(Apple a1, Apple a2){
							return a1.compareTo(a2); }
						});
		System.out.println(inventory.toString());
		System.out.println("=====filtering======");
		System.out.println((AppleFilter.filterApple(inventory,new AppleYellowAndHeavyPredicate()).toString()));
		System.out.println("=====filtering with lambda======");
		List<Apple> result = AppleFilter.filterApple(inventory,(Apple a)->"green".equals(a.getColour()));
		System.out.println(result.toString());
		System.out.println("=====filtering with lambda and predicate======");
		result = PredicateFilter.predicateFilter(inventory,(Apple a)->"red".equals(a.getColour()));
		System.out.println(result.toString());
		System.out.println("=====filtering with lambda and predicate but not apples======");
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5); 
		System.out.println(intList.toString());
		List<Integer> resultInt = PredicateFilter.predicateFilter(intList,(Integer i) -> i % 2 == 0);
		System.out.println(resultInt.toString());
		System.out.println("=====printing======");
		AppleFilter.prettyPrintApple(inventory, new ApplePrinterHeavyOrLight());
	}

}

class Apple implements Comparable<Apple> {
	private int weight;
	private String colour;

	public String getColour(){
		return this.colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getWeight(){
		return weight;
	}

	public void setWeight(int inWeight){
		this.weight = inWeight;
		System.out.println("New apple created, wt.:" + this.weight);
	}

	public Apple(int weight){
		this.weight = weight;
		System.out.println("New apple created, wt.:" + this.weight);
	}	

	public String toString(){
		String appleString = new String("Apple of wt.:" + weight + " and colour: " + colour);
		return appleString;
	}

	public int compareTo(Apple other) {
	    return Integer.compare(this.weight, other.weight);
	}
		
}
