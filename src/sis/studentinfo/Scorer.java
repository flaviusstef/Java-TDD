package sis.studentinfo;

public class Scorer {
	public int score(String s) {
		return Integer.parseInt(s);
	}

	public boolean isValid(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
