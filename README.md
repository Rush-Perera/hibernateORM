# hibernateORM
WEB2 Inclass Project on 2023/(04/19|04/24|04-26|04-27)

04-19:

1.Project created without web

2.hibernate configuration with hibernate.properties files discussed.


04-24:

There are 3 ways to configure hibernate:

1.Using hibernate.properties file:

            InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("res/hibernate-dev.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            configuration.setProperties(properties);
    
2.Using hibernate.cfg.xml file:

This should be located at the root of the classpath.

We can make custom configuration xml file. 

It should be passed as a parameter in the configuration file
            
            configuration.configure("hibernate-dev.cfg.xml");

3.Programmetic Configuration

(Without using any configuration file but passing configuration parameters in the code itself)

        Properties properties = new Properties();
    
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3307/orm_db");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        
        configuration.setProperties(properties);

04-27:

1. Saving a new entity in the database:

Method 1:

        Session session = sessionFactory.getCurrentSession();

        //Transient state
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        //Persistent state
        session.persist(student);

        transaction.commit();
        session.close();

Method 2:

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //Persistent state
        session.save(student);

        session.getTransaction().commit();
        session.close();


2. If the commit is not called, the changes will not be reflected in the database. But table metadata will be created.