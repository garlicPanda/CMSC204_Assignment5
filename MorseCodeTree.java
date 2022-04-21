/**
 * This is the data structure MorseCodeTree class
 * Creates a binary linked tree consisting of the alphabet organized according to morse code
 * @author vanessa
 *
 */
import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	private TreeNode<String> root;
	/**
	 * Constructs a new MorseCodeTree using the buildTree method
	 */
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}
	
	@Override
	/**
	 * Return a reference to the root of the tree
	 * @return reference to root
	 */
	public TreeNode<String> getRoot(){
		return root;
	}
	
	@Override
	/**
	 * Sets the root of the tree
	 * @param newNode a copy of this TreeNode will be the new root
	 */
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	
	@Override
	/**
	 * Adds new element to correct position on tree using addNode method
	 * @param code the morse code for the new element such as '..-'
	 * @param letter the corresponding letter for the morse code such as 'u'
	 * @return the current MorseCodeTree with the new element added
	 */
	public void insert(String code, String result) {
		addNode(root, code, result);
	}
	
	
	
	@Override
	/**
	 * Recursive method to add the a new element in the right position based on code
	 * '.'means to traverse to left, '-' means to traverse to right
	 * @param root the root of the tree for this recursive instance of addNode
	 * @param code the code for this recursive instance of addNode
	 * @param letter the data of the TreeNode to be added
	 */
	public void addNode(TreeNode<String>root, String code, String letter) {
		TreeNode<String> add=new TreeNode<String>(letter);
		if(code.length()==1){
			
			if(code.charAt(0)=='.'){
				
				if(root.left==null){
					
					root.left=add;
				}
			}
			else if(code.charAt(0)=='-'){
				
				if(root.right==null){
					
					root.right=add;
				}
			}
		}
		if(code.length()>1){
			
			String hold=code.substring(1);
        	if(code.charAt(0)=='.'){
        		
        		addNode(root.left, hold,letter);
        	}
        	else if(code.charAt(0)=='-'){
        		
        		addNode(root.right, hold,letter);
        	}
		}
	}
	
	@Override
	/**
	 * Fetch the data in the tree based on the given code
	 * @param code the code that describes the traversals to retrieve the data
	 * @return the string that corresponds to the code
	 */
	public String fetch(String code) {
		return fetchNode(root, code);
	}
	
	
	@Override
	/**
	 * Recursive method to fetch an element from the right position based on the code
	 * '.'means to traverse to left. '-' means to traverse right
	 * @param root the root of the tree for this recursive instance of fetchNode
	 * @param code the code code for this recursive instance of fetchNode
	 * @return the string that corresponds to the code
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		String fetch="";
        if(code.length()==1){
        	
        	if(code.charAt(0)=='.'){
        		
        		return root.left.getData();
        	}
        	else if(code.charAt(0)=='-'){
        		
        		return root.right.getData();
        	}
        }
        if(code.length()>1){
        	
        	String hold=code.substring(1);
        	if(code.charAt(0)=='.'){
        		
        		fetch=fetchNode(root.left, hold);
        	}
        	else if(code.charAt(0)=='-'){
        		
        		fetch=fetchNode(root.right, hold);
        	}
        }
        return fetch;
	}
	
	
	@Override
	/**
	 * This operation is not supported by the MorseCodeTree
	 * @param data the data to be deleted
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> delete(String data)  throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	@Override
	/**
	 * This operation is not support by the MorseCodeTree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> update()throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	@Override
	/**
	 * Builds the MorseCodeTree by inserting TreeNodes based on the alphabet in the correct order
	 * Morse Code translation of letter determines the level of tree and when it is inserted
	 */
	public void buildTree() {
		
		//Level 1
		insert(".", "e");
		insert("-", "t");
		
		//Level 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		//Level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		//Level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		
	}
	
	@Override
	/**
	 * Returns an ArrayList of the letters in the tree in LNR traversal order
	 * Used to test if tree is built correctly
	 * @return an ArrayList of strings
	 */
	public ArrayList<String> toArrayList(){
		ArrayList<String> toArray = new ArrayList<>();
		LNRoutputTraversal(root, toArray);
		return toArray;
	}
	
	@Override
	/**
	 * Recursive method to put letters in tree into ArrayList in LNR order
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root != null) {
			LNRoutputTraversal(root.left,list);
			list.add(root.getData());
			LNRoutputTraversal(root.right,list);
		}
	}
}
