package utils;


import java.util.Date;

public class TestUtility {

	public static void main(String[] args) throws Exception {

		System.out.println("-----------------Out Put--------------------");
		MyUtilityClass.StringToDate("29/02/2020");
		System.out.println(MyUtilityClass.isValidDate(new Date()));
		System.out.println("Date 2 Str: " + MyUtilityClass.DateToString(new Date()));
		System.out.println(MyUtilityClass.calculateAge("26/04/1990"));

	}

}
