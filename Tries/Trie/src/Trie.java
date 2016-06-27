import java.util.ArrayList;
/**
 * Trie class.
 */

/**
 * @author rakshith
 *
 */
public class Trie {
	
	private TrieNode root;

	/**
	 * Default constructor
	 */
	public Trie() {
		this.root = new TrieNode();
	}
	
	 /**
	  * Adds a word to the Trie
	  * @param word
	  */
	 public ArrayList addWord(String prefix){
		 TrieNode lastNode = root;
		 for(int i=0; i<prefix.length();i++){
			 lastNode = lastNode.getNode(prefix.charAt(i));
		 }
		 if(lastNode == null){
			 return new ArrayList();
		 }
		 
		 return lastNode.getWords();
	 }
}
