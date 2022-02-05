package domain;

public class ReverseNumber {
	
	void reverseNumberString(Object obj) {
		if(obj instanceof Integer) {
			int num = Integer.valueOf(obj.toString());
			int rev=0;
			while(num!=0) {
				int dig=num%10;
				rev=rev*10+dig;
				num=num /10;
			}
			System.out.println(rev);
		}else if(obj instanceof String) {
			String str = obj.toString();
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
	}

	public static void main(String[] args) {
		
		
		ReverseNumber rev = new ReverseNumber();
		rev.reverseNumberString("manish");
		
	}

}
