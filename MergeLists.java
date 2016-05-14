
/** Implementation of Union, Intersection, and Set Difference on Lists(Generic)
 *  @author G25 
 */
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MergeLists {

	/** Procedure that finds the intersection of elements between two sorted lists
     * Finds the elements that appears in both the lists, 
     * Runs in time O(n+m), where n, m are no of elements in two sorted lists
     * 
     * @param a : Sorted List.  Precondition: A is sorted.
     * @param b : Sorted List.  Precondition: B is sorted.
     * If A,B is/are not sorted, behavior of procedure is arbitrary
     * @param out : The intersection is stored in this List in a sorted order
     * 
     */
	static <T extends Comparable<? super T>> void intersection(List<T> a, List<T> b, List<T> out) {
		ListIterator<T> aIterator = a.listIterator();
		ListIterator<T> bIterator = b.listIterator();
		ListIterator<T> outIterator = out.listIterator();

		try {
			T aTemp = next(aIterator);
			T bTemp = next(bIterator);

			while (aTemp != null && bTemp != null) {
				//When element in two lists pointed by the iterators are equal, adding to the output
				if (aTemp.compareTo(bTemp) == 0) {
					outIterator.add(aTemp);
					aTemp = next(aIterator);
					bTemp = next(bIterator);
				} 
				//When element in List a is lesser than List b
				else if (aTemp.compareTo(bTemp) < 0) {
					aTemp = next(aIterator);
				} 
				//When element in List b is lesser than List a
				else {
					bTemp = next(bIterator);
				}

			}

		} catch (NullPointerException ex) {
			System.out.println("The input array(s) is/are empty. Please check!!");
		}

	}

	/** Procedure that finds the set difference between two sorted lists, 
	 * i.e Elements in List a but not in List b.
     * Runs in time O(n+m), where n, m are no of elements in two sorted lists
     * 
     * @param a : Sorted List.  Precondition: A is sorted.
     * @param b : Sorted List.  Precondition: B is sorted.
     * If A,B is/are not sorted, behavior of procedure is arbitrary
     * @param out : The set difference is stored in this List in a sorted order
     * 
     */
	static <T extends Comparable<? super T>> void setDifference(List<T> a, List<T> b, List<T> out) {
		ListIterator<T> aIterator = a.listIterator();
		ListIterator<T> bIterator = b.listIterator();

		try {
			T aTemp = next(aIterator);
			T bTemp = next(bIterator);
			//When element in two lists pointed by the iterators are equal, skipping them
			while (aTemp != null) {
				if (aTemp.compareTo(bTemp) == 0) {
					aTemp = next(aIterator);
					bTemp = next(bIterator);
				}
		//When element in List A is lesser than B, adding element of List A to output
				else if (aTemp.compareTo(bTemp) < 0) {
					out.add(aTemp);
					aTemp = next(aIterator);

				} 
				//otherwise skipping to the next iterator element	
				else {
					bTemp = next(bIterator);
				}

				//Condition when List b runs to null, and remaining elements
				//of List a copied to the Output
				if (bTemp == null) {
					while (aTemp != null) {
						{
							out.add(aTemp);
							aTemp = next(aIterator);
						}

					}
				}

			}

		} catch (NullPointerException ex) {
			System.out.println("The input array(s) is/are empty. Please check!!");
		}

	}
	/** Procedure that finds the union of two sorted lists, 
	 * i.e Elements in List a and in List b without duplicates.
     * Runs in time O(n+m), where n, m are no of elements in two sorted lists
     * 
     * @param a : Sorted List.  Precondition: A is sorted.
     * @param b : Sorted List.  Precondition: B is sorted.
     * If A,B is/are not sorted, behavior of procedure is arbitrary
     * @param out : The union is ouput to this List in a sorted order
     * 
     */
	static <T extends Comparable<? super T>> void Union(List<T> a, List<T> b, List<T> out) {

		ListIterator<T> aIterator = a.listIterator();
		ListIterator<T> bIterator = b.listIterator();
		ListIterator<T> outIterator = out.listIterator();

		T aTemp = next(aIterator);
		T bTemp = next(bIterator);

		//Condition that checks if the lists are null
		if (aTemp == null && bTemp == null) {
			// If either of the lists is empty then return null
			return;
		} 
		
		//Below two conditions are triggered when only one among the lists is empty.
		//Populates and returns the other non empty list.
		else if (aTemp == null) {
			while (bTemp != null) {
				outIterator.add(bTemp);
				bTemp = next(bIterator);
			}
			return;
		} else if (bTemp == null) {
			while (aTemp != null) {
				outIterator.add(aTemp);
				aTemp = next(aIterator);
			}
			return;
		}

	
		while (aTemp != null && bTemp != null) {
			
		//When elements in List A and B by the iterator are equal , 
		//adding only element of List A to output
			if (aTemp.compareTo(bTemp) == 0) {
				outIterator.add(aTemp);
				aTemp = next(aIterator);
				bTemp = next(bIterator);
			} 
		// When element in List A is lesser than B, adding element of List A to the output	
			else if (aTemp.compareTo(bTemp) < 0) {
				outIterator.add(aTemp);
				aTemp = next(aIterator);
			} 
		// 	otherwise, i.e When element in List B is lesser than A, 
		//adding element of List A to the output	
			else {
				outIterator.add(bTemp);
				bTemp = next(bIterator);
			}
		}

		//If List B is traversed fully, then adding all elements of A to the output
		if (aTemp != null) {
			while (aTemp != null) {
				outIterator.add(aTemp);
				aTemp = next(aIterator);
			}
		}
		//If List A is traversed fully, then adding all elements of B to the output
		if (bTemp != null) {
			while (bTemp != null) {
				outIterator.add(bTemp);
				bTemp = next(bIterator);
			}
		}

	}

	/**
	 * Helper function that returns the next element of an iterator if present,
	 * false otherwise
	 * 
	 * @param iterator
	 *            : the iterator whos elements are to be inspected
	 * @return true if there exists a next element in iterator, and false
	 *         otherwise
	 */
	static <T extends Comparable<? super T>> T next(Iterator<T> iterator) {
		if (iterator.hasNext())
			return iterator.next();
		else
			return null;
	}
}
