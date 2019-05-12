package ua.lpnuai.oop.berdnyk05;

import java.util.regex.Pattern;

public class RegCheck {
	public static final String dataExp = "[0-3][0-9]-[0-1][0-9]-[0-9][0-9][0-9][0-9]";
	public static final String stazhExp = "\\d{1,2}";
	public static final String yeNo = "так|ні";
	public static final String salaryExp = "\\d{1,}";
	public static final String upDown = "вв|вн";
	
	public static boolean checkDataExp(String str) {
		return Pattern.matches(dataExp, str);
	}
	public static boolean checkStazhExp(String str) {
		return Pattern.matches(stazhExp, str);
	}
	public static boolean checkYeNo(String str) {
		return Pattern.matches(yeNo, str);
	}
	public static boolean checkSalary(String str) {
		return Pattern.matches(salaryExp, str);
	}
	public static boolean checkUpDown(String str) {
		return Pattern.matches(upDown, str);
	}
}
