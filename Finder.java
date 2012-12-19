import java.util.HashMap;

public class Finder {

	public int findDepth(Node node) {
		Node currentNode = node;
		int depth = 0;
		while (null != currentNode) {
			depth += 1;
			currentNode = currentNode.parent;
		}
		return depth;
	}

	private HashMap<Integer, Integer> findParentKeys(Node shallowNode) {
		Node currentNode = shallowNode;
		HashMap<Integer, Integer> parentKeys = new HashMap<Integer, Integer>();
		while (null != currentNode) {
			parentKeys.put(currentNode.key, currentNode.value);
			currentNode = currentNode.parent;
		}
		return parentKeys;
	}

	public Node matchParentToHash(Node deepNode,
			HashMap<Integer, Integer> parentKeys) {
		Node currentNode = deepNode;
		Node sharedParent = null;
		while (null != currentNode && null == sharedParent) {
			if (parentKeys.containsKey(currentNode.key)) {
				sharedParent = currentNode;
			}
			currentNode = currentNode.parent;
		}
		return sharedParent;
	}

	public Node findSharedParent(Node node1, Node node2) {

		int nodeDepth1 = findDepth(node1);
		int nodeDepth2 = findDepth(node2);
		Node shallowNode = nodeDepth1 < nodeDepth2 ? node1 : node2;
		Node deepNode = shallowNode == node1 ? node2 : node1;
		HashMap<Integer, Integer> parentKeys = findParentKeys(shallowNode);
		Node sharedParent = matchParentToHash(deepNode, parentKeys);
		return sharedParent;
	}

}
