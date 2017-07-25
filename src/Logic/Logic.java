package Logic;

import java.util.HashSet;
import java.util.Set;

public class Logic {

	private Integer getHashValue(char[] c,Integer previousHashValue,char previousChar){
		Integer hash=0;
		int length= c.length;
		if(previousHashValue==null){
			for(int i=0;i<length;i++)
			hash=hash+(int)c[i];
		}else
		{
			hash=previousHashValue-(int)previousChar+(int)c[length-1];
		}
		return hash;
		
	}
	
	public Set<Integer> findSubString(String text,String pattern){
		Integer previousHashValue=null;
		char previousChar=' ';
		Set<Integer> foundAt= new HashSet<Integer>();
		Integer hp=getHashValue(pattern.toCharArray(), null, ' ');
		
		for(int i=0;i<=(text.length()-pattern.length());i++){
			char[] subString=text.substring(i, i+pattern.length()).toCharArray();
			Integer hs=getHashValue(subString, previousHashValue, previousChar);
			if(hs.equals(hp)){
				boolean found=compareText(text.toCharArray(),pattern.toCharArray(),i);
				if(found){
					foundAt.add(i);
				}
			}
			previousHashValue=hs;
			previousChar=subString[0];
		}
		
		return foundAt;
	}

	private  boolean compareText(char[] text, char[] pattern, int i) {
		boolean equals=true;
		for(int j=0;j<pattern.length;j++){
			if(pattern[j]!=text[j+i])
				equals=false;
		}
		return equals;
		
		
	}
}
