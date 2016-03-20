import java.util.*;
public class AppleFilter {
	public static List<Apple> filterApple(List<Apple> inventory, ApplePredicate p){
		List<Apple> filteredList = new ArrayList<Apple>();
		for(Apple apple : inventory) {
			if(p.test(apple)) {
				filteredList.add(apple);
			}
		}
		return filteredList;
	}

	public static void prettyPrintApple(List<Apple> inventory, ApplePrinter p){
		for(Apple apple : inventory) {
			System.out.println(p.print(apple));
		}
	}
}
interface ApplePredicate { 
	boolean test (Apple apple);
}
class AppleRedAndHeavyPredicate implements ApplePredicate {
	public boolean test(Apple apple){
		return "red".equals(apple.getColour()) && apple.getWeight() > 2;
	}
}
class AppleYellowAndHeavyPredicate implements ApplePredicate {
	public boolean test(Apple apple){
		return "yellow".equals(apple.getColour()) && apple.getWeight() > 2;
	}
}

interface ApplePrinter {
	public String print (Apple apple);
}

class ApplePrinterWeight implements ApplePrinter {

	@Override
	public String print(Apple apple) {
		return "The weight of the apple is:" + apple.getWeight();
	}
}

class ApplePrinterHeavyOrLight implements ApplePrinter {

	@Override
	public String print(Apple apple) {
		return apple.getWeight() > 2 ? "this apple is heavy" : "this apple is light";
	}
}