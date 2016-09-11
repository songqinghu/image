package image.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		
		 boolean find = Pattern.compile("^66\\.249\\..+").matcher("").find();
		
		//Matcher matcher = compile.matcher("11.66.249.11.1");
		
		//boolean find = matcher.find();
		
		System.out.println(find);
		
		
		
	}
}
