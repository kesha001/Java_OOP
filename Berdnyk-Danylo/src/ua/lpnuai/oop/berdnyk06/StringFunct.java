package ua.lpnuai.oop.berdnyk06;

public class StringFunct {

	public static int countVow(String[] arr, int l) {
		int indx=0;
		for(int i = 0; i<l;i++) {
			if(arr[i] != null) {
				if(isVowel(arr[i].charAt(0))) {
					indx++;
				}
			}
		}
		return indx;
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
		return indx;
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

		return indx;
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
}
