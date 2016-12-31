import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/
 * 
 * Given an array of words, print all anagrams together. 
 * For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, 
 * then output may be “cat tac act dog god”.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = {"cat", "tac", "act", "dog", "god"};
		printAnagramWordGroups(array);
	}
	
	private static void printAnagramWordGroups(String[] array) {
		TrieNode root = new TrieNode('*');
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		//root.addWord("abc");
		//root.addWord("ab");
		//root.addWord("abd");
		//root.addWord("acd");
		System.out.println(root);
		System.out.println(root.hasWord("ab"));
		System.out.println(root.hasWord("abc"));
		System.out.println(root.hasWord("ac"));
		System.out.println(root.hasWord("a"));
		
		for(int i=0;i<array.length;i++){
			char[] sarr = array[i].toCharArray();
			Arrays.sort(sarr);
			String s_sorted = String.copyValueOf(sarr);
			if(root.hasWord(s_sorted)){
				map.get(s_sorted).add(array[i]);
			}else{
				root.addWord(s_sorted);
				map.put(s_sorted, new ArrayList<String>());
				map.get(s_sorted).add(array[i]);
			}
		}
		
		System.out.println(root);
		
		for(String key:map.keySet()){
			for(String s:map.get(key)){
				System.out.print(s+" ");
			}
		}
	}

	public static class TrieNode{
		char c;
		boolean isLeaf;
		boolean isWord;
		TrieNode[] children;
		
		TrieNode(char c){
			this.c = c;
			this.isLeaf = true;
			this.isWord = false;
			this.children = new TrieNode[26];
		}
		
		public void addWord(String word){
			if(word.length()==0 && this.c != '*'){
				this.isWord = true;
				return;
			}
			char curChar = word.charAt(0);
			if(this.children[curChar-'a'] == null){
				this.children[curChar-'a'] = new TrieNode(curChar);
				this.children[curChar-'a'].addWord(word.substring(1));
				this.isLeaf = false;
			}else{
				this.children[curChar-'a'].addWord(word.substring(1));
				this.isLeaf = false;
			}
		}
		
		public boolean hasWord(String searchStr){
			if(searchStr.length()==0){
				return this.isWord;
			}else{
				char searchChar = searchStr.charAt(0);
				if(this.children[searchChar-'a'] != null){
					return this.children[searchChar-'a'].hasWord(searchStr.substring(1));
				}else{
					return false;
				}
			}
		}
		
		public String toString(){
			//String answer = ""+this.c+this.isWord+"<";
			String answer = ""+this.c+"<";
			for(int i=0;i<26;i++){
				if(this.children[i] != null){
					answer = answer + this.children[i].toString() + ",";
				}
			}
			answer = answer + ">";
			return answer;
		}
	}
}
