import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.pigwriter.model.Article;

import java.util.Date;

public class HibernateTest {
//    @Test
    public void test() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Article article = new Article();
        article.setCreateDate(new Date());
        article.setTitle("标题");
        article.setContent("内容");
        session.save(article);
        session.getTransaction().commit();
        session.close();
    }
}
