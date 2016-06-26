import java.util.ArrayList;
/**
 * TrieNode class
 */

/**
 * @author rakshith
 *
 */
public class TrieNode {
	
	private TrieNode parent;
	private TrieNode[] children;
	private boolean isLeaf;
	private boolean isWord;
	private char character;
	
	/**
	 * Constructor to create a TrieNode.
	 */
	public TrieNode() {
		this.children = new TrieNode[26];
		this.isLeaf = true;
		this.isWord = false;
	}

	/**
	 * @param character
	 */
	public TrieNode(char character) {
		this();
		this.character = character;
	}
	
	/**
	 * Adds a word to this node. This method is called recursively and
	 * adds child nodes for each successive letter in the word, therefore
	 * recursive calls will be made with partial words.
	 * @param word the word to add
	 */
	
	protected void addWord(String word){
		this.isLeaf = false;
		int charPosition = word.charAt(0) - 'a';
		
		if(children[charPosition] == null){
			children[charPosition] = new TrieNode(word.charAt(0));
			children[charPosition].parent = this;
		}
		
		if(word.length() > 1){
			children[charPosition].addWord(word.substring(1));
		}else{
			children[charPosition].isWord = true;
		}
	}
	
	/**
	 * Returns the child TrieNode representing the given char,
	 * or null if no node exists.
	 * @param c
	 * @return
	 */
	protected TrieNode getNode(char c){
		return children[c-'a'];
	}
	
	/**
	 * Returns a List of String objects which are lower in the
	 * hierarchy that this node.
	 * @return
	 */
	protected ArrayList getWords(){
		ArrayList list = new ArrayList();
		
		if(this.isWord){
			list.add(this.toString());
		}
		
		if(!this.isLeaf){
			for(int i=0; i<26; i++){
				if(children[i] != null){
					list.addAll(children[i].getWords());
				}
			}
		}
		return list;
	}
	
	/**
	* Gets the String that this node represents.
	* For example, if this node represents the character t, whose parent
	* represents the charater a, whose parent represents the character
	* c, then the String would be "cat".
	* @return
	*/
	public String toString(){
		if(this.parent == null){
			return "";
		}else{
			return parent.toString()+ Character.toString(this.character);
		}
	}
}
