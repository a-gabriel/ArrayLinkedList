package all;

class Item {
	String name;
	int next;
	public Item(String name, int next) {
		this.name = name;
		this.next = next;
	}
	public String toString() {
		return "(" + name + "," + next + ")";
	}
}

public class ArrayLL {

	private Item[] all;
	private int numItems;
	private int front;
	private int[] avail;
	private int numAvail;

	// Constructor, initializes all data fields, to represent 
	// an empty Item array linked list of length maxItems
	public ArrayLL(int maxItems) {

		all = new Item[maxItems];
		avail = new int[maxItems];
		numAvail = maxItems;
		numItems = 0;
		front = -1; 
		
		for (int i = maxItems; i > 0; i--){
			avail[i-1]=i-1;
		}
		
		
	}

	// Adds a name to the front of this array linked list, in worst case O(1) time,
	// and returns true.
	// Returns false if the array is full, in O(1) time
	public boolean addFront(String name) {

		if (numAvail== 0){
			return false;
		}

		else {
			all[avail[numAvail-1]] = new Item(name, front);
			front = avail[numAvail-1];
			numItems++;
			numAvail--;
			
			
			return true;
			
		}

	}

	// Deletes the name that is at the front this array linked list, in worst case O(1) time,
	// and returns the deleted name
	// Returns null if the list is empty, in O(1) time
	public String deleteFront() {
		if (numItems == 0){
			return null;}
		else{
			Item deleted = all[front];
			all[front] = null;
			numItems--;
			numAvail++;
			front = deleted.next;
			return deleted.name;
			
			
	}
		
	}

	// Deletes the given name from this array linked list, and returns true.
	// Returns false if the name is not in the list.
	// Note: If there are n active items in the list, then this method must run in
	// worst case O(n) time, i.e. time must not depend on the length of the all array
	// (since the array might include available space not filled by active items)
	// Also, avail array should be accessed/updated in O(1) time
	public boolean delete(String name) {
if (numItems == 0) {
	return false; 
}
		
		for (int i = 0; i<all.length; i++){
			if (all[i]==null){
				continue;
				
			}
			if (name.equalsIgnoreCase(all[i].name)){
				if (i == front){
					Item deleted = all[front];
					
					all[front] = null;
					numItems--;
					numAvail++;
					front = deleted.next;
					return true;
				}
				
				else{
					
					Item deleted = all[i];
					all[i] = null;
					numItems--;
					numAvail++;
					avail[numAvail-1] = i;
					all[i-1].next=deleted.next;
						
					
				
				
				return true;}
			}
			else{
				continue;
			}
		}

		return false; 
		
	}

	// Checks if the given name is in this array linked list
	// Note: If there are n items in the list, then this method must run in
	// worst case O(n) time, i.e. time does not depend on the length of the all array.
	public boolean contains(String name) {

		for (int i = 0; i<all.length; i++){
		
				if (all[i]==null){
					continue;
					}
				else if (!all[i].name.equalsIgnoreCase(name)){
					continue;
				}
				else {
					return true;
				}
				}
		return false;
				
	}

	// Prints the items in this array linked list in sequence from first to last,
	// in worst case O(n) time where n is the number of items in the linked list
	// The list should be printed in a single line, separated by commas
	// Example: earth,mercury,venus
	// Make sure there aren't any extra commas in your output.
	// If the list is empty, you may print either nothing, or an empty string
	public void printList() {
		if (numItems == 0){
			return;
		}
		if (numItems == 1){
		
			System.out.print(all[front].name);
		}
		
		else {
			
			int next = all[front].next;
			System.out.print(all[front].name);
			for (int i = 0; i<numItems-1; i++){
				
				if (i==numItems-1){
					System.out.print(all[next].name);}
				else{
					System.out.print(","+all[next].name);
					next = all[next].next;
				}
				
			}
			
		}
		
	}

	// Prints all the entries in the main array (including unused spaces)
	// You may fill in this method and use it for debugging
	// This method WILL NOT be graded
	public void printArray() {
		for (int i = 0; i<all.length; i++){
			System.out.println(all[i]);
		}
	}

	// Prints all the entries in the avail array that correspond to
	// available spaces in the main array
	// You may fill in this method and use it for debugging
	// This method WILL NOT be graded
	public void printAvailableSpots() {
		for (int i = 0; i<avail.length; i++){
			System.out.println(avail[i]);
		}
	}
}
