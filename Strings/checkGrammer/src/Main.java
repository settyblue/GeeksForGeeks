/**
 * http://www.geeksforgeeks.org/check-given-sentence-given-set-simple-grammer-rules/
 * 
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String[] sentences = { "I love cinema.", "The vertex is S.",
                "I am single.", "My name is KG.",
                "I lovE cinema.", "GeeksQuiz. is a quiz site.",
                "I love Geeksquiz and Geeksforgeeks.",
                "  You are my friend.", "I love cinema" };
		checkGrammer(sentences);
	}

	private static void checkGrammer(String[] sentences) {
		for(String s:sentences){
			if(isCorrectSentence(s)){
				System.out.println("\'"+s+"\' is a correct sentence.");
			}else{
				System.out.println("\'"+s+"\' is a not a correct sentence.");
			}
			
		}
	}

	private static boolean isCorrectSentence(String s) {
		int n = s.length();
		
		if(!Character.isUpperCase(s.charAt(0))){
			return false;
		}
		
		if(s.charAt(n-1) != '.'){
			return false;
		}
		
		int curState = 0;
		int prevState = 0;
		//0 -> UpperCase.
		//1 -> Space.
		//2 -> LowerCase.
		//3 -> Dot.
		int curIndex=1;
		
		while(curIndex<n){
			
			if(prevState == 3){
				return false;
			}
			
			if(Character.isUpperCase(s.charAt(curIndex))){
				curState = 0;
			}else if(s.charAt(curIndex)==' '){
				curState = 1;
			}else if(Character.isLowerCase(s.charAt(curIndex))){
				curState = 2;
			}else{
				curState = 3;
			}
			
			if(curState == prevState && curState != 2){
				return false;
			}
			
			if(prevState == 1 && curState == 3){
				return false;
			}
			
			if(prevState == 2 && curState == 0){
				return false;
			}
			
			prevState = curState;
			curIndex++;
		}
		return true;
	}

}
