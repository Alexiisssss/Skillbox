import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
@Table(name = "subscriptions")
public class Subscription {

  @EmbeddedId
  private Id id;

  @ManyToOne
  @JoinColumn(name = "student_id", updatable = false, insertable = false)
  private Student student;

  @ManyToOne
  @JoinColumn(name = "course_id", updatable = false, insertable = false)
  private Course course;

  @Column(name = "subscription_date")
  private Date subscriptionDate;

  public Subscription() {
  }

  public Subscription(Id id, Student student, Course course, Date subscriptionDate) {
    this.id = id;
    this.student = student;
    this.course = course;
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

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Id that = (Id) o;
      return studentId == that.studentId &&
          courseId == that.courseId;
    }

    @Override
    public int hashCode() {
      return Objects.hash(studentId, courseId);
    }
  }
}