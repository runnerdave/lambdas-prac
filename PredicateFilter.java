import java.util.*;
public class PredicateFilter {

	public static <T> List<T> predicateFilter(List<T> list, Predicate<T> p) {
		List<T> filteredList = new ArrayList<>();
		for(T t : list) {
			if (p.test(t)) {
				filteredList.add(t);
			}
		}
		return filteredList;
	}

} 
interface Predicate<T> {
	public boolean test(T t);
}
