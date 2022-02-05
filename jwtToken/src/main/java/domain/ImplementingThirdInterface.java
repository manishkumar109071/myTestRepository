package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ImplementingThirdInterface implements ThirdInterface,FourthInterface{

	public static void show() {
		System.out.println("this is Static in class");
	} 
	public static void main(String[] args) {
		ImplementingThirdInterface.show();
		ThirdInterface.show();
		FourthInterface.show();
		List<String> list =new ArrayList<>();
		list.add("sunday");
		list.add("monday");
		list.add("tuesday");
		list.add("wednesday");
		list.forEach(s->{
			System.out.println(s);
		});
	
		Map<String,String> map=new HashMap<>();
		map.put("S", "sunday");
		map.put("M", "monday");
		map.put("T", "tuesday");
		map.forEach((k,v)->{
			System.out.println(k+"        "+v);
		});
		
		map.entrySet().forEach(e->{
			System.out.println(e.getKey()+"------"+e.getValue());
			
		});
		
		Map<String, String> ss =(Map<String, String>)map.entrySet().stream().filter(s-> "M".equals(s.getKey())).collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue()));
		System.out.println(ss.toString());
		
		int numbers[] = {22, 89, 1, 32, 19, 5};
		/* Specifying the start and end index. The start index is
		 * 1 here and the end index is 5. which means the the elements
		 * starting from index 1 till index 5 would be sorted.
		 */
		Arrays.parallelSort(numbers);
		//converting the array to stream and displaying using forEach
		Arrays.stream(numbers).forEach(n->System.out.print(n+" "));

		System.out.println("\n"+Integer.reverse(444666));
	}

}
