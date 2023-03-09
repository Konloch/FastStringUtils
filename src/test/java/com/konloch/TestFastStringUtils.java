package com.konloch;

import com.konloch.util.FastStringUtils;

/**
 * @author Konloch
 * @since 2/15/2023
 */
public class TestFastStringUtils
{
	public static void main(String[] args)
	{
		boolean isNull = FastStringUtils.isNull("null");
		boolean isBoolean = FastStringUtils.isBoolean("false");
		boolean isInteger = FastStringUtils.isInteger("1");
		boolean isDouble = FastStringUtils.isDouble("1D");
		boolean isFloat = FastStringUtils.isFloat("1.0F");
		
		System.out.println("Null: " + isNull + ", Boolean: " + isBoolean
				+ ", Int: " + isInteger + ", Double: " + isDouble + ", Float: " + isFloat);
		System.out.println();
		
		
		String[] testSplit = FastStringUtils.split("A B C D E F", " ", 2);
		
		assert testSplit.length == 2;
		
		assert testSplit[0].equals("A");
		
		assert testSplit[1].equals("B C D E F");
		
		testSplit = FastStringUtils.split("A B C D E F", " ", 3);
		
		assert testSplit.length == 3;
		
		assert testSplit[0].equals("A");
		
		assert testSplit[1].equals("B");
		
		assert testSplit[2].equals("C D E F");
		
		System.out.println("Test-0: `" + testSplit[0] + "`");
		System.out.println("Test-1: `" + testSplit[1] + "`");
		System.out.println("Test-2: `" + testSplit[2] + "`");
		System.out.println();
		
		testSplit = FastStringUtils.split("testing words removal", " words ", -1, false);
		
		assert testSplit[0].equals("testing");
		
		assert testSplit[1].equals("removal");
		
		System.out.println("Test-0: `" + testSplit[0] + "`");
		System.out.println("Test-1: `" + testSplit[1] + "`");
		System.out.println();
		
		testSplit = FastStringUtils.split("uniquewordremoval", "word", -1, false);
		
		assert testSplit[0].equals("unique");
		
		assert testSplit[1].equals("removal");
		
		System.out.println("Test-0: `" + testSplit[0] + "`");
		System.out.println("Test-1: `" + testSplit[1] + "`");
		System.out.println();
	}
}
