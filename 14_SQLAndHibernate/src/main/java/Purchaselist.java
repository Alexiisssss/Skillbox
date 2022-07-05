import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "purchaselist")
public class Purchaselist {

  @EmbeddedId
  Id id;

  @Column(name = "student_name", updatable = false, insertable = false)
  private String studentName;

  @Column(name = "course_name", updatable = false, insertable = false)
  private String courseName;

  @Column(name = "price")
  private int price;

  @Column(name = "subscription_date")
  private Date subscriptionDate;


  @Embeddable
  private static class Id implements Serializable {

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;


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
      Id id = (Id) o;
      return Objects.equals(studentName, id.studentName) &&
          Objects.equals(courseName, id.courseName);
    }

    @Override
    public int hashCode() {
      return Objects.hash(studentName, courseName);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Purchaselist that = (Purchaselist) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
