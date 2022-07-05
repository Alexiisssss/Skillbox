import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student_courses")
public class StudentsCourses {

  @EmbeddedId
  private Id id;

  @ManyToOne
  @JoinColumn(name = "student_id", updatable = false, insertable = false)
  private Student student;

  @ManyToOne
  @JoinColumn(name = "course_id", updatable = false, insertable = false)
  private Course course;

  @Column(name = "price")
  private Integer price;

  @Column(name = "subscription_date")
  private Date subscriptionDate;

  public StudentsCourses() {
  }


  public StudentsCourses(Id id, Student student, Course course, int price,
      Date subscriptionDate) {
    this.id = id;
    this.student = student;
    this.course = course;
    this.price = price;
    this.subscriptionDate = subscriptionDate;
  }

  @Embeddable
  public static class Id implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    public Id() {
    }

    public Id(int studentId, int courseId) {
      this.studentId = studentId;
      this.courseId = courseId;
    }
  }
}