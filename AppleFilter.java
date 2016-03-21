import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
public class AppleFilter {
	public static List<Apple> filterApple(List<Apple> inventory, Predicate<Apple> p){
		List<Apple> filteredList = new ArrayList<Apple>();
		for(Apple apple : inventory) {
			if(p.test(apple)) {
				filteredList.add(apple);
			}
		}
		return filteredList;
	}

	public static void prettyPrintApple(List<Apple> inventory, Function<Apple,String> p){
		for(Apple apple : inventory) {
			System.out.println(p.apply(apple));
		}
	}
}
interface ApplePredicate { 
	boolean test (Apple apple);
}
class AppleRedAndHeavyPredicate implements Predicate<Apple> {
	public boolean test(Apple apple){
		return "red".equals(apple.getColour()) && apple.getWeight() > 2;
	}
}
class AppleYellowAndHeavyPredicate implements Predicate<Apple> {
	public boolean test(Apple apple){
		return "yellow".equals(apple.getColour()) && apple.getWeight() > 2;
	}
}

interface ApplePrinter {
	public String print (Apple apple);
}

class ApplePrinterWeight implements Function<Apple, String> {

	@Override
	public String apply(Apple apple) {
		return "The weight of the apple is:" + apple.getWeight();
	}
}

class ApplePrinterHeavyOrLight implements Function<Apple, String> {

	@Override
	public String apply(Apple apple) {
		return apple.getWeight() > 2 ? "this apple is heavy" : "this apple is light";
	}
}