/** Driver program for Intersection, Union, Set Difference program
 * Finds the elements that appears in both the lists, 
 * Runs in time O(n+m), where n, m are no of elements in two sorted lists
 * 
 * @param a : Sorted List.  Precondition: A is sorted.
 * @param b : Sorted List.  Precondition: B is sorted.
 * If A,B is/are not sorted, behavior of procedure is arbitrary
 * @param out : The intersection is stored in this List in a sorted order
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

class Driver_MergeLists {

	public static void main(String[] args) {
		SortedSet<Integer> set1 = new TreeSet<>();
		SortedSet<Integer> set2 = new TreeSet<>();
		int n = 1000000;
		for (int i = 1; i <= n; i++) {
			set1.add(i);
			set2.add(i);
		}
		
		List<Integer> list1 = new ArrayList<Integer>(set1);
		List<Integer> list2 = new ArrayList<Integer>(set2);
		List<Integer> list3 = new ArrayList<Integer>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1-Intersection 2-Union 3-Set Difference");
		try {
			int choice=Integer.parseInt(br.readLine());
			long start = System.currentTimeMillis();
			switch(choice){
			case 1:
				MergeLists.intersection(list1, list2, list3);
				break;
			case 2 : 
				MergeLists.Union(list1, list2, list3);
				break;
			case 3: 
				MergeLists.setDifference(list1, list2, list3);
				break;
			}
			
			long end = System.currentTimeMillis();
			System.out.println("Running Time is: " + (end - start)+" ms");
			//System.out.println(list3);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
