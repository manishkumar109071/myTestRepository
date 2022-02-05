package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyCollectionTest {
	
	public static List<Integer> getCommonKeysFromMap(Map<Integer, String> map1, Map<Integer, String> map2){
		
		List<Integer> listOfCommonKeys = new ArrayList<Integer>();
		List <String> listOfCommonValues = new ArrayList<String>();
		List <Integer> commonList = new ArrayList<Integer>();
		
		map1.forEach((k, v)->{
			if(map2.keySet().contains(k)) {
				commonList.add(k);
			}
		});
		
		listOfCommonKeys = map1.keySet().stream().filter(m1-> map2.keySet()
				.contains(m1))
				.collect(Collectors.toList());
		
		listOfCommonValues = map1.values().stream().filter(m1-> map2.values()
				.contains(m1))
				.collect(Collectors.toList());
		
		System.out.println("Common keys: "+listOfCommonKeys);
		System.out.println("common values"+listOfCommonValues);
		System.out.println("Common"+commonList);
		
		return listOfCommonKeys;
	}

	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(1, "One");
		hashMap.put(2, "Two");
		hashMap.put(3, "Three");
		hashMap.put(4, "Four");
		hashMap.put(5, "Five");
		
		Map<Integer, String> hashMap2 = new HashMap<Integer, String>();
		hashMap2.put(6, "Six");
		hashMap2.put(7, "Seven");
		hashMap2.put(8, "Eight");
		hashMap2.put(4, "Four");
		hashMap2.put(5, "Five");
		
		List<Integer> numberList = new ArrayList<>();
		numberList.add(101);
		numberList.add(105);
		numberList.add(109);
		
//		List<Integer> numberList2 = numberList.stream().filter(number-> number>104).collect(Collectors.toList());
//		
//		List<Integer> numberList3 = hashMap.keySet().stream()
//				.filter(m1-> hashMap2.keySet().contains(m1))
//				.collect(Collectors.toList());
		
		System.out.println("Common Keys: "+getCommonKeysFromMap(hashMap, hashMap2));
		
		//System.out.println("numberList3 "+numberList3);

	}

}
