package com.konloch;

import com.konloch.util.FastStringUtils;

import java.util.Arrays;

/**
 * @author Konloch
 * @since 2/15/2023
 */
public class TestFastStringUtils
{
	public static void main(String[] args)
	{
		String[] testSplit;
		
		boolean isNull = FastStringUtils.isNull("null");
		boolean isBoolean = FastStringUtils.isBoolean("false");
		boolean isInteger = FastStringUtils.isInteger("1");
		boolean isDouble = FastStringUtils.isDouble("1D");
		boolean isFloat = FastStringUtils.isFloat("1.0F");
		
		assert isNull;
		assert isBoolean;
		assert isInteger;
		assert isDouble;
		assert isFloat;
		
		testSplit = FastStringUtils.split("A B C D E F", " ", 2);
		
		assert testSplit.length == 2;
		assert testSplit[0].equals("A");
		assert testSplit[1].equals("B C D E F");
		
		testSplit = FastStringUtils.split("A B C D E F", " ", 3);
		
		assert testSplit.length == 3;
		assert testSplit[0].equals("A");
		assert testSplit[1].equals("B");
		assert testSplit[2].equals("C D E F");
		
		testSplit = FastStringUtils.split("remove>>>>>>>all", ">", -1, false, false);
		
		assert testSplit.length == 2;
		assert testSplit[0].equals("remove");
		assert testSplit[1].equals("all");
		
		testSplit = FastStringUtils.split("testing words removal", " words ", -1, false);
		
		assert testSplit.length == 2;
		assert testSplit[0].equals("testing");
		assert testSplit[1].equals("removal");
		
		testSplit = FastStringUtils.split("uniquewordremoval", "word", -1, false);
		
		assert testSplit.length == 2;
		assert testSplit[0].equals("unique");
		assert testSplit[1].equals("removal");
		
		testSplit = FastStringUtils.split("A:B::C", ":");
		
		assert testSplit.length == 4;
		assert testSplit[0].equals("A");
		assert testSplit[1].equals("B");
		assert testSplit[2].isEmpty();
		assert testSplit[3].equals("C");
		
		//TODO
		/*testSplit = FastStringUtils.split("A::B::::C", "::");
		
		System.out.println("Dump: " + Arrays.toString(testSplit));
		
		assert testSplit.length == 4;
		assert testSplit[0].equals("A");
		assert testSplit[1].equals("B");
		assert testSplit[2].isEmpty();
		assert testSplit[3].equals("C");*/
		
		testSplit = FastStringUtils.parseArguments("A B C D E F", 2);
		
		assert testSplit.length == 2;
		assert testSplit[0].equals("A");
		assert testSplit[1].equals("B C D E F");
		
		testSplit = FastStringUtils.parseArguments("A \"B C D E F\"");
		
		assert testSplit.length == 2;
		assert testSplit[0].equals("A");
		assert testSplit[1].equals("B C D E F");
		
		testSplit = FastStringUtils.parseArguments("A \"B C D E\" F");
		
		assert testSplit.length == 3;
		assert testSplit[0].equals("A");
		assert testSplit[1].equals("B C D E");
		assert testSplit[2].equals("F");
		
		testSplit = FastStringUtils.parseArguments("A \"B C\" \"D E F\"");
		
		assert testSplit.length == 3;
		assert testSplit[0].equals("A");
		assert testSplit[1].equals("B C");
		assert testSplit[2].equals("D E F");
		
		testSplit = FastStringUtils.parseArguments("A \"B C\" \"D E\" F");
		
		assert testSplit.length == 4;
		assert testSplit[0].equals("A");
		assert testSplit[1].equals("B C");
		assert testSplit[2].equals("D E");
		assert testSplit[3].equals("F");
		
		//TODO
		/*testSplit = FastStringUtils.parseArguments("A \"\\\"B C\\\"\" \"D E\" F");
		
		assert testSplit.length == 4;
		assert testSplit[0].equals("A");
		assert testSplit[1].equals("\"B C\"");
		assert testSplit[2].equals("D E");
		assert testSplit[3].equals("F");*/
	}
}
