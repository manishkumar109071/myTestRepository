package domain;

import java.util.Arrays;
import java.util.List;

// test
public class MyClass {
	
	String empFirstName;
	String empLastName;
	String mobileNumber;
	String alternateContactNo;
	String emailId;
	String dob;
	
	void reverseString(String str){
		String revString="";
		if (str !=null && str.length()>1) {
			for(int k=str.length()-1;k>=0;k--) {
				revString =revString+str.charAt(k);
			}
		}else {
			System.out.println("String can't be null or length should be greater than 1");
		}
		System.out.println("Original String: "+str.toUpperCase() );
		System.out.println("Reverse String: "+revString.toUpperCase());
	}
	
	void checkAlphabet(char c) {
		if((c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z')) {
			System.out.println("Alphabet");
		}else {
			System.out.println("Not Alphabet");
		}
	}
	
	void reverseNumber(int number) {
		if(number<10) {
			System.out.println(number);
			return;
		}else {
			System.out.print(number%10);
			reverseNumber(number/10);
		}
	}
	
	void reverseNumber2(int num) {
		int rev=0;
		while(num!=0) {
			int dig=num%10;
			rev=rev*10+dig;
			num=num /10;
		}
		System.out.println(rev);
	}
	
	public static void swapTwoString() {
		String str1="manish";
		String str2="kumar";
		
		str1=str1+str2;
		System.out.println("Concatinated String: "+str1);
		str2=str1.substring(0, str1.length()-str2.length());
		str1=str1.substring(str2.length());
		
		System.out.println("str1=:"+str1+"-------"+"str2: "+str2);
		
	}
	
	public static void swapTwoNumber() {
		int a=10;
		int b=20;
		a=a+b;
		b=a-b;
		a=a-b;
		
		System.out.println("a=:"+a+"-------"+"b=:"+b);
		
	}
	
	public static void findMaxNumber() {
		int []number= {1,5,8,3,9,4,7,2,6};
		int largest=number[0];
		for(int k=0;k<number.length;k++) {
			if(largest<number[k]) {
				largest=number[k];
			}
		}
		System.out.println("Largest number in array is :"+largest);
	}


	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		myClass.reverseString("manju"); 
		myClass.checkAlphabet('^');
		myClass.reverseNumber(12345);
		myClass.reverseNumber2(12345);
		swapTwoString();
		swapTwoNumber();
		findMaxNumber();
		String text3 = "line1\s line2\s  sline3 \s";
		System.out.println(text3);
		List<Weeks> week = Arrays.asList(Weeks.values());
		week.forEach((c)-> {
			System.out.println(c);
		});
		
		Runnable r = ()->{
			System.out.println("MyRunnable");
		};
		
		
				
	}

}
