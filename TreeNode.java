/**
 * This is the generic data element TreeNode class for the linked tree structure
 * @param <T>
 * @author vanessa
 *
 */
public class TreeNode <T> {
	public TreeNode<T> left, right;
	private T data;
	
	// Getters and Setters
	public TreeNode<T> getLeft() {
		return left;
		}
	public void setLeft(TreeNode<T> left) {
		this.left = left;
		}
	public TreeNode<T> getRight() {
		return right;
		}
	public void setRight(TreeNode<T> right) {
		this.right = right;
		}
	public void setData(T data) {
		this.data = data;
		}
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode the data to be stored in the node
	 */
	public TreeNode(T dataNode) {
		left = null;
		right = null;
		data = dataNode;
	}
	
	
	/**
	 * Creates a new TreeNode which is a deep copy of the given parameter
	 * @param node the node to be copied
	 */
	public TreeNode(TreeNode<T> node) {
		left = node.left;
		right= node.right;
		data = node.getData();
	}
	
	/**
	 * Returns the data within the TreeNode
	 * @return the data within the node
	 */
	public T getData() {
		return data;
	}

}
