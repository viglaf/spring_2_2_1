package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @Transactional
   public User getCarOwner(String model, int series) {
      String hql = "FROM User WHERE car.model = :paramModel AND car.series = :paramSeries";
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("paramModel", model);
      query.setParameter("paramSeries", series);
      return  query.getResultList().get(0);
   }


   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
