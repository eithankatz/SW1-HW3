import java.util.Arrays;

public class StringUtils 
{
	private static int compareLexicographically(String str1, String str2)
	{// Wasn't sure if we are allowed to use "compareTo(String str)" or not, so created similar method
		for (int i = 0; i < str1.length() && i < str2.length(); i++) 
		{
			if ((int)str1.charAt(i) == (int)str2.charAt(i)) 
				continue;
			else 
				return (int)str1.charAt(i) - (int)str2.charAt(i);
		}
		
		// Checks if one string is a substring of the other
		if (str1.length() < str2.length()) 
			return (str1.length()-str2.length());
		else if (str1.length() > str2.length()) 
			return (str1.length()-str2.length());
		
		// Both strings are equal
		else 
			return 0;
	}	
	
	public static String findSortedSequence(String str) 
	{
		String[] words = str.split(" ");
		int max_len = 0;
		int max_start_idx = 0;
		int cnt;
		for(int i = 0; i < words.length; i++)
		{
			cnt = 1;
			for(int j = i; j < words.length-1; j++)
			{
				if(compareLexicographically(words[j], words[j+1]) > 0)
					break;
				cnt++;
			}
			
			if(cnt >= max_len)
			{
				max_len = cnt;
				max_start_idx = i;
			}
		}
		String[] max_substring = Arrays.copyOfRange(words, max_start_idx, max_start_idx + max_len);
		return String.join(" ", max_substring);
	}


	public static boolean isEditDistanceOne(String a, String b)
	{
		// Length difference is more than 1
		if (a.length()-b.length() < -1 || a.length()-b.length() > 1)
			return false;
		
		// Same length, check if there are more than 1 different characters
		else if (a.length() == b.length())
		{
			boolean dist_one = false;
			for (int i = 0; i < a.length(); i++)
				if (a.charAt(i) != b.charAt(i))
				{
					if (dist_one)
						return false; 
					dist_one = true;
				}
		}
		
		// Length difference is 1. Compare characters until the last one
		else
		{
			// Find what word is the short word
			String shorter = a.length() < b.length() ? a : b;
			String longer = shorter == a ? b : a;
			
			int dist_one = 0;
			for (int i = 0; i < longer.length()-1; i++)
				if (shorter.charAt(i-dist_one) != longer.charAt(i))
				{
					if (dist_one == 1)
						return false;
					dist_one++;
				}
			if (dist_one == 0)
					return true;
			else
				return shorter.charAt(shorter.length()-1) == longer.charAt(longer.length()-1);
		}
		return true;
	}
}
