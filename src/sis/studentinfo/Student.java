package sis.studentinfo;

public class Student {
   static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
   static final String IN_STATE = "CO";
   private String name;
   private int credits;
   private String state = "";
   
   public Student(String name) {
      this.name = name;
      credits = 0;
   }

   public String getName() {
      return name;
   }
   
   boolean isFullTime() {
   	return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
   }
   
	int getCredits() {
		return credits;
	}

	void addCredits(int credits) {
		this.credits += credits;
	}

   boolean isInState() {
   	return state.equals(Student.IN_STATE);
   }	

   void setState(String state) {
      this.state = state;
   }
}