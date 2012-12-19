
public class Main {

	public static void main(String[] args) {

		int[] dummy_keys = {0,1,2,3,4,5,6,7};
		int[] dummy_values = {4321,22,5432,-6543,-7654,-8765,9876,-987};
		/*
		 * we construct a tree structure as below
		 * 
		 *           0
		 *          / \
		 *         1   2
		 *            / \
		 *           3   4
		 *          / \   \
		 *         5   6   7
		 *         
		 * this example will find shared parent of node 5 and node 7 (the correct answer is node 2)
		 */
		
		Node node0 = new Node(dummy_keys[0],dummy_values[0]);
		Node node1 = new Node(node0,dummy_keys[1],dummy_values[1]);
		Node node2 = new Node(node0,dummy_keys[2],dummy_values[2]);
		Node node3 = new Node(node2,dummy_keys[3],dummy_values[3]);
		Node node4 = new Node(node2,dummy_keys[4],dummy_values[4]);
		Node node5 = new Node(node3,dummy_keys[5],dummy_values[5]);
		Node node6 = new Node(node3,dummy_keys[6],dummy_values[6]);
		Node node7 = new Node(node4,dummy_keys[7],dummy_values[7]);
		
		Finder f = new Finder();
		
		Node sharedParent = f.findSharedParent(node5,node7);

		System.out.println(sharedParent.prettyPrint());
		System.out.println("This is node2: " + (sharedParent == node2));
		
	}

}
