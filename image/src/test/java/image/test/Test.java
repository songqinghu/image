package image.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.math.RandomUtils;

public class Test {

	public static void main(String[] args) {
		
		 boolean find = Pattern.compile("^66\\.249\\..+").matcher("").find();
		
		//Matcher matcher = compile.matcher("11.66.249.11.1");
		
		//boolean find = matcher.find();
		for (int i = 0; i < 30; i++) {
		    System.out.println(RandomUtils.nextInt(10) + ": " + (RandomUtils.nextInt(10)%10) );
        }
		
		
		
	}
}
