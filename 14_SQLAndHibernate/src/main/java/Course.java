import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private int duration;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum")
  private CourseType type;
  private String description;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "teacher_id")
  private Teacher teacher;

  @Column(name = "students_count", nullable = true)
  private Integer studentCount;

  private int price;

  @Column(name = "price_per_hour")
  private Float pricePerHour;

  @OneToMany(mappedBy = "course")
  private List<Subscription> subscriptions;

  @OneToMany(mappedBy = "course")
  private List<StudentsCourses> studentsCourses;
}


