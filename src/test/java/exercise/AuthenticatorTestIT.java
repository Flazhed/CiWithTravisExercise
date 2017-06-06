package exercise;

import Utils.Mailer;
import exercise.fakedatabase.UserFacadeFake;
import exercise.realdatabase.UserFacadeRealDB;

import static org.mockito.Mockito.mock;

/**
 * Created by Flashed on 06-06-2017.
 */
public class AuthenticatorTestIT extends AuthenticatorTest {

    @Override
    public Authenticator makeAuthenticator(){
        String connectionString;
        if (System.getenv("TRAVIS") != null) {
            connectionString = "pu_mySql_travis_Integration";
        }else {
            connectionString = "pu_localDB";
        }
        Mailer mailer = mock(Mailer.class);
        return new Authenticator(new UserFacadeRealDB(connectionString), mailer);
    }
}
