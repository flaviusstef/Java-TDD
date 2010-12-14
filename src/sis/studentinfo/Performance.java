package sis.studentinfo;

public class Performance {

	private int[] grades;

	public void setNumberOfTests(int number) {
		grades = new int[number];
	}

	public void set(int position, int grade) {
		grades[position] = grade;
	}

	public int get(int pos) {
		return grades[pos];
	}

	public double average() {
		double result = 0;
		for (int grade: grades) {
			result += grade;
		}
		return result/grades.length;
	}

	public void setScores(int i, int j, int k, int l) {
		grades = new int[] {i, j, k, l};
	}

}
