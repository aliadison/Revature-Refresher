package org.example;

public class reverseEveryOtherWord {
	public static void main(String[] args) {
		String s = "Somebody once told me";
		
		System.out.println(alternateWord(s));
	}

	public static String alternateWord(String s) {
		String [] strArr = s.split(" ");
		String newStr = "";
		for(int i = 1;i<=strArr.length;i++) {
			if(i%2 ==0) {
				String reverseWord = "";
				for(int j = strArr[i-1].length()-1; j>=0;j--) {
					reverseWord += strArr[i-1].charAt(j);
				}
				newStr += reverseWord +" ";
			}else newStr += strArr[i-1] + " ";
		}
		return newStr;
	}
}
