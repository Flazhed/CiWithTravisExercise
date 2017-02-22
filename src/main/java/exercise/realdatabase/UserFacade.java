package exercise.realdatabase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import exercise.LoginStatus;
import exercise.IUserFacade;


public class UserFacade implements IUserFacade {

  EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_users");
  
  @Override
  public LoginStatus verifyUser(String userName, String pw) {
    EntityManager em = emf.createEntityManager();
    try{
      SystemUser user = em.find(SystemUser.class, userName);
      if(user == null){
        return LoginStatus.UNKNOWN_USER;
      }
       return user.getPassword().equals(pw) ? LoginStatus.OK : LoginStatus.INVALID_PASSWORD;
    }finally{
      em.close();
    }
  }
  
}
