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
		
		String[] test = FastStringUtils.split("Testing Split", " ");
		
		for(int i = 0; i < test.length; i++)
			System.out.println("Split Results: "+i+"=" + test[i]);

		System.out.println();
		test = FastStringUtils.split("Testing Split With Many Instances", " ");
		
		for(int i = 0; i < test.length; i++)
			System.out.println("Split Results: "+i+"=" + test[i]);
		
		System.out.println();
		test = FastStringUtils.split("Testing Split With A Limiter", " ", 2);
		
		for(int i = 0; i < test.length; i++)
			System.out.println("Split Results: "+i+"=" + test[i]);
		
		System.out.println();
		test = FastStringUtils.split("Testing Split With A Longer Limiter", " ", 4);
		
		for(int i = 0; i < test.length; i++)
			System.out.println("Split Results: "+i+"=" + test[i]);
	}
}
