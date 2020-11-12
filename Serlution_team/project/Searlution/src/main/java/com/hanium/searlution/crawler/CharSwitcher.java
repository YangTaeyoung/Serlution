package com.hanium.searlution.crawler;

class CharSwitcher
{
	static public String replaceChar(String str, char ch, int index) {
	    return str.substring(0, index) + ch + str.substring(index+1);
	}
	static public String checkIntegrity(String sentence)
	{
		String tmp = sentence;
		tmp.replaceAll("--", "―");
		tmp.replaceAll("/\\*", "／\\*");
		tmp.replaceAll("\\*/", "\\*／");
		tmp.replaceAll("//", "／／");
		
		int doubleCount = 0;
		int singleCount = 0;
		for(int i = 0; i < tmp.length(); i++)
		{
			if (tmp.charAt(i) == '\"' )
			{
				if(doubleCount == 0)
				{
					tmp = replaceChar(tmp,  '“', i);
					doubleCount++;
				}
				else if(doubleCount == 1)
				{
					tmp = replaceChar(tmp, '”', i);
					doubleCount--;
				}
			}
			else if(tmp.charAt(i) == '\'')
			{
				if(singleCount == 0)
				{
					tmp = replaceChar(tmp, '‘', i);
					singleCount++;
				}
				else if(singleCount == 1)
				{
					tmp = replaceChar(tmp, '’', i);	
					singleCount--;
				}
			}
		}
		return tmp;
	}
}