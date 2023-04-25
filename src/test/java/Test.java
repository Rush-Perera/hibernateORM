import com.jiat.orm.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
//        Need to add the following snippet to auto generate the tables in db as in JPA
        configuration.addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

    }
}
