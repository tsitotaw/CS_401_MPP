package prob2A;

public class Main {

    public static void main(String[] args) {
	  Student peter = new Student(000001L, "Peter", "Simon");
      Student alex = new Student(000002L, "Alex", "Bongo");

      peter.getGradeReport().setGrade('A');
      alex.getGradeReport().setGrade('B');

      GradeReport alexGrade = alex.getGradeReport();
      alexGrade.setGrade('A');
      alexGrade.setCourseName("MPP");

      GradeReport peterGrade = peter.getGradeReport();
      peterGrade.setGrade('B');
      peterGrade.setCourseName("MPP");

      System.out.println(peter);
      System.out.println(alex);
    }
}
