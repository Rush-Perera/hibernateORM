import com.jiat.orm.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();

////        Using the following line to load the hibernate.cfg.xml file
//        configuration.configure("hibernate-dev.cfg.xml");


//        //Load the properties file
//
//        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("res/hibernate-dev.properties");
//        Properties properties = new Properties();
//        properties.load(inputStream);
//
//        configuration.setProperties(properties);

//        Programmetic configuration
        Properties properties = new Properties();

        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3307/orm_db");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "update");

        configuration.setProperties(properties);

//        Need to add the following snippet to auto generate the tables in db as in JPA
        configuration.addAnnotatedClass(Student.class);
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
        SessionFactory factory = configuration
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

    }
}
