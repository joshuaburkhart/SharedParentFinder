import java.util.ArrayList;
import java.util.List;

public class Node {

	Node parent;
	List<Node> children;
	int key;
	int value;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.children = new ArrayList<Node>();
	}

	public Node(Node parent, int key, int value) {
		this.parent = parent;
		if (null != this.parent) {
			this.parent.addChild(this);
		}
		this.key = key;
		this.value = value;
		this.children = new ArrayList<Node>();
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void addChild(Node child) {
		this.children.add(child);
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String prettyPrint() {
		return "Key: " + this.key + ", Value: " + this.value;
	}

}