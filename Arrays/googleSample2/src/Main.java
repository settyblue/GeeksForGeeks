import java.util.Arrays;
import java.util.Stack;

/**
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif\n directorytest\n  file.jpeg";
		String[] lines = s.split("\n");
		String root = "/";
		int maxLen = 0;
		int curLen = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		int prevSpaces = 0;
		int curDirLen = 0;
		for(String line:lines){
			int numberOfSpaces = getSpaces(line);
			line = line.trim();
			System.out.println(line + " "+numberOfSpaces);
			if(prevSpaces == numberOfSpaces){
				boolean isFile = false;
				if(line.indexOf(".") != -1){
					isFile = true;
				}
				if(isFile){
					int dot = line.indexOf('.');
					String ext = line.substring(dot+1,line.length());
					if(ext.equals("jpeg") || ext.equals("png") || ext.equals("gif")){
						maxLen = Math.max(maxLen,curLen);
					}
				}else{
					curDirLen = line.length();
				}
			}else if(prevSpaces < numberOfSpaces){
				stack.push(curDirLen+1);
				curLen += curDirLen+1;
				boolean isFile = false;
				if(line.indexOf(".") != -1){
					isFile = true;
				}
				if(isFile){
					int dot = line.indexOf('.');
					String ext = line.substring(dot+1,line.length());
					if(ext.equals("jpeg") || ext.equals("png") || ext.equals("gif")){
						maxLen = Math.max(maxLen,curLen);
					}
				}else{
					curDirLen = line.length();
				}
			}else{
				int diff = prevSpaces-numberOfSpaces;
				for(int i=0; i<diff; i++){
					curLen -= stack.pop();
				}
				boolean isFile = false;
				if(line.indexOf(".") != -1){
					isFile = true;
				}
				if(isFile){
					int dot = line.indexOf('.');
					String ext = line.substring(dot+1,line.length());
					if(ext.equals("jpeg") || ext.equals("png") || ext.equals("gif")){
						maxLen = Math.max(maxLen,curLen);
					}
				}else{
					curDirLen = line.length();
				}
			}
			System.out.println(stack.toString() + " " + maxLen + " " + curLen);
			prevSpaces = numberOfSpaces;
		}
	}

	private static int getSpaces(String line) {
		String copy = line;
		copy = copy.trim();
		return line.length()-copy.length();
	}

	
}
