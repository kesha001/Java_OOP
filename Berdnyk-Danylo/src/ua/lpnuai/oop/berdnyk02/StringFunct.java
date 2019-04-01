package ua.lpnuai.oop.berdnyk02;

public class StringFunct {

	public static String[] findVow(String[] arr,int counted, int l) {
		
		String[] arrV = new String[counted];
		for(int i = 0,ind = 0; i<arr.length;i++) {
			if(arr[i] != null) {
			if(isVowel(arr[i].charAt(0))) {
				arrV[ind] = arr[i];
				ind++;
			}
			}
		}
		if(Menu.debug) {
			System.out.println("Funct: findVow, variables:");
			System.out.println("array arrV:");
			for(int i = 0; i<arr.length;i++) {
				System.out.println(arr[i]);
			}
		}
		return arrV;
	}
	public static int countVow(String[] arr, int l) {
		int indx=0;
		for(int i = 0; i<l;i++) {
			if(arr[i] != null) {
				if(isVowel(arr[i].charAt(0))) {
					indx++;
				}
			}
		}
		if(Menu.debug)
			System.out.println("Function: countVow, variables: indx = "+indx);
		return indx;
	}
	public static String[] findCons(String[] arr,int counted, int l) {

		String[] arrC = new String[counted];
		for(int i = 0,ind =0; i<arr.length;i++) {
			if(arr[i] != null) {
				if(!isVowel(arr[i].charAt(0)) && !nonLetter(arr[i].charAt(0))) {
					arrC[ind] = arr[i];
					ind++;
				}
			}
		}
		if(Menu.debug) {
			System.out.println("Funct: findCons, variables:");
			System.out.println("array arrC:");
			for(int i = 0; i<arr.length;i++) {
				System.out.println(arr[i]);
			}
		}
		return arrC;
	}
	public static int countCons(String[] arr, int l) {
		int indx=0;
		for(int i = 0; i<l;i++) {
			if(arr[i] != null) {
				if(!isVowel(arr[i].charAt(0)) && !nonLetter(arr[i].charAt(0))) {
					indx++;
				}
			}
		}
		if(Menu.debug)
			System.out.println("Function: countCons, variables: indx = "+indx);
		return indx;
	}
	public static String[] findNon(String[] arr,int counted,int l) {
		String[] arrN = new String[counted];
		for(int i = 0,ind=0; i<arr.length;i++) {
			if(arr[i] != null) {
				if(nonLetter(arr[i].charAt(0))) {
					arrN[ind] = arr[i];
					ind++;
				}
			}
		}
		if(Menu.debug) {
			System.out.println("Funct: findNon, variables:");
			System.out.println("array arrN:");
			for(int i = 0; i<arr.length;i++) {
				System.out.println(arr[i]);
			}
		}
		return arrN;
	}
	public static int countNon(String[] arr, int l) {
		int indx=0;
		for(int i = 0; i<l;i++) {
			if(arr[i] != null) {
				if(nonLetter(arr[i].charAt(0))) {
					indx++;
				}
			}
		}
		if(Menu.debug)
			System.out.println("Function: countNon, variables: indx = "+indx);
		return indx;
	}
	public static String findShortest(String[] arr, int l) {
		int minL = Integer.MAX_VALUE;
		String min = null;
		for(int i = 0; i<l;i++) {
			if(arr[i].length()<minL) {
				min = arr[i];
				minL = arr[i].length();
			}
		}
		if(Menu.debug) {
			System.out.println("Function: findShortest, variables: \nminL = "+minL+" min = "+min);
		}
		return min;
	}
	public static boolean isVowel(char v) {
		if(v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u')
			return true;
	return false;
	}
	public static boolean nonLetter(char l) {
		if (l < 'A' || l > 'z')
			return true;
		return false;
	}
	public static void printStrings(String[] arr1,String[] arr2,String[] arr3 ) {
		System.out.println("Group 1:");
		for(int i = 0; i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("Group 2");
		for(int i = 0; i<arr2.length;i++) {
			System.out.println(arr2[i]);
		}
		System.out.println("Group 3");
		for(int i = 0; i<arr3.length;i++) {
			System.out.println(arr3[i]);
		}
	}
}
