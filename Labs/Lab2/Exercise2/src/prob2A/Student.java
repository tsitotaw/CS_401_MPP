package prob2A;

/**
 * a 1 to 1 relationship between Student and GradeReport
 */
public class Student {

    private Long id;
    private String firstName;
    private String lastName;

    private GradeReport gradeReport;

    public Student(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeReport = new GradeReport(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GradeReport getGradeReport() {
        return gradeReport;
    }

    public void setGradeReport(GradeReport gradeReport) {
        this.gradeReport = gradeReport;
    }

    @Override
    public String toString() {
        return "Student{" +
                "first Name = '" + firstName + '\'' +
                ", last Name = '" + lastName + '\'' +
                ", Course Taken = " + gradeReport.getCourseName() +
                ", Grade Result = " + gradeReport.getGrade() +
                '}';
    }
}
