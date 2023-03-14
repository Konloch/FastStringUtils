package com.konloch.util;

import java.util.ArrayList;

/**
 * A collection of zero dependency pure Java String utilities.
 *
 * @author Konloch
 * @since 2/15/2011
 */
public class FastStringUtils
{
	private static final String DIGITS = "0123456789";
	
	/**
	 * A fast non-strict check if the String can represent null.
	 *
	 * @param s any String
	 * @return true if the String can represent null.
	 */
	public static boolean isNull(String s)
	{
		return (s == null) || (s.equalsIgnoreCase("null"));
	}
	
	/**
	 * A fast non-strict check if the String can represent boolean values.
	 *
	 * @param s any String
	 * @return true if the String can represent boolean values.
	 */
	public static boolean isBoolean(String s)
	{
		return (s != null && (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("false")));
	}
	
	/**
	 * A fast non-strict check if the String can represent an integer.
	 *
	 * @param s any String
	 * @return true if the String can represent an integer.
	 */
	public static boolean isInteger(String s)
	{
		return isDigitAnd(s, "+-");
	}
	
	/**
	 * A fast non-strict check if the String can represent a short.
	 *
	 * @param s any String
	 * @return true if the String can represent a short.
	 */
	public static boolean isShort(String s)
	{
		return isDigitAnd(s, "sS");
	}
	
	/**
	 * A fast non-strict check if the String can represent a long.
	 *
	 * @param s any String
	 * @return true if the String can represent a long.
	 */
	public static boolean isLong(String s)
	{
		return isDigitAnd(s, "lL");
	}
	
	/**
	 * A fast non-strict check if the String can represent a float.
	 *
	 * @param s any String
	 * @return true if the String can represent a float.
	 */
	public static boolean isFloat(String s)
	{
		return isDigitAnd(s, ".fF+-");
	}
	
	/**
	 * A fast non-strict check if the String can represent a double.
	 *
	 * @param s any String
	 * @return true if the String can represent a double.
	 */
	public static boolean isDouble(String s)
	{
		return isDigitAnd(s, ".dD+-");
	}
	
	/**
	 *
	 * A fast non-strict check if the String can represent a digit and a supplied charset.
	 *
	 * @param s any String
	 * @param charset any String as charset
	 * @return true if the String can represent a digit and the supplied charset.
	 */
	private static boolean isDigitAnd(String s, String charset)
	{
		if (s == null || s.isEmpty())
			return false;
		
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			
			if (!contains(DIGITS, c))
			{
				if (!contains(charset, c))
					return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Returns true if the character is found inside the String
	 *
	 * @param s any String
	 * @param c any character
	 * @return true if the character is inside the String
	 */
	public static boolean contains(String s, char c)
	{
		for (int i = 0; i < s.length(); i++)
		{
			char c2 = s.charAt(i);
			
			if (c == c2)
				return true;
		}
		
		return false;
	}
	
	/**
	 * Splits a String with a specified separator String without using regex.
	 *
	 * @param s any String
	 * @param separator any String
	 * @return a String array split on the separator supplied
	 */
	public static String[] split(String s, String separator)
	{
		return split(s, separator, -1);
	}
	
	/**
	 * Splits a String with a specified separator String without using regex.
	 *
	 * @param s any String
	 * @param separator any String
	 * @param maxAmount -1 for unlimited, or else the maximum size of results returned
	 * @return a String array split on the separator supplied
	 */
	public static String[] split(String s, String separator, int maxAmount)
	{
		return split(s, separator, maxAmount, false);
	}
	
	/**
	 * Splits a String with a specified separator String without using regex.
	 *
	 * @param s any String
	 * @param separator any String
	 * @param maxAmount -1 for unlimited, or else the maximum size of results returned
	 * @param preserveSeparator if true it will include the separator at the end of each split line
	 * @return a String array split on the separator supplied
	 */
	public static String[] split(String s, String separator, int maxAmount, boolean preserveSeparator)
	{
		return split(s, separator, maxAmount, preserveSeparator, true);
	}
	
	/**
	 * Splits a String with a specified separator String without using regex.
	 *
	 * @param s any String
	 * @param separator any String
	 * @param maxAmount -1 for unlimited, or else the maximum size of results returned
	 * @param preserveSeparator if true it will include the separator at the end of each split line
	 * @param allowEmptyResults is true the results will include empty results on repeating search parameters
	 * @return a String array split on the separator supplied
	 */
	public static String[] split(String s, String separator, int maxAmount, boolean preserveSeparator, boolean allowEmptyResults)
	{
		ArrayList<String> results = new ArrayList<>();
		
		StringBuilder buffer = new StringBuilder();
		StringBuilder searchBuffer = new StringBuilder();
		
		char[] lineChars = s.toCharArray();
		char[] sepChars = separator.toCharArray();
		
		boolean isSearching = false;
		int searchIndex = 0;
		
		for(char c : lineChars)
		{
			boolean completedSearch = false;
			
			if(isSearching)
			{
				//if current c isn't found while searching
				if(searchIndex < sepChars.length && c != sepChars[searchIndex++])
				{
					isSearching = false;
					buffer.append(searchBuffer);
					searchBuffer = new StringBuilder();
					searchIndex = 0;
				}
				
				//completely found, search is over, time for next iteration
				if(searchIndex >= sepChars.length)
				{
					completedSearch = true;
					boolean multiCharSearch = searchIndex > 1;
					
					//restart the search for this character since we have ended
					isSearching = false;
					
					if(preserveSeparator)
						buffer.append(searchBuffer);
					
					searchBuffer = new StringBuilder();
					searchIndex = 0;
					
					if(buffer.length() != 0)
						results.add(buffer.toString());
					
					buffer = new StringBuilder();
					
					//TODO multi-line characters search is not fully functional
					if(multiCharSearch)
						continue;
				}
			}
			
			if(!isSearching)
			{
				//if current c isn't found while searching
				if(c != sepChars[searchIndex++])
				{
					buffer.append(c);
					searchIndex = 0;
				}
				else
				{
					if(allowEmptyResults && completedSearch)
						results.add("");
					
					
					isSearching = true;
					
					if(!completedSearch)
						searchBuffer.append(c);
				}
			}
		}
		
		//add whatever is left
		if(buffer.length() > 0)
			results.add(buffer.toString());
		
		//trim amount found
		if(maxAmount > 0 && results.size() > maxAmount)
		{
			ArrayList<String> trimmedList = new ArrayList<>();
			for(int i = 0; i < maxAmount-1; i++)
				trimmedList.add(results.get(i));
			
			//read the rest of the split content
			StringBuilder sb = new StringBuilder();
			boolean b = false;
			for(int i = maxAmount-1; i < results.size(); i++)
			{
				if(!b)
					b = true;
				else
					sb.append(separator);
				
				sb.append(results.get(i));
			}
			
			trimmedList.add(sb.toString());
			return trimmedList.toArray(new String[0]);
		}
		
		return results.toArray(new String[0]);
	}
	
	/**
	 * Alert that this is a library
	 *
	 * @param args program launch arguments
	 */
	public static void main(String[] args)
	{
		throw new RuntimeException("Incorrect usage - for information on how to use this correctly visit https://konloch.com/FastStringUtils/");
	}
}
