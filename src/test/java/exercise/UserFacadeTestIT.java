package exercise;

import exercise.realdatabase.UserFacadeRealDB;

/**
 * Created by Flashed on 06-06-2017.
 */
public class UserFacadeTestIT extends UserFacadeTest{

    @Override
    public IUserFacade makeUserFacade() {
        return new UserFacadeRealDB("pu_localDB");
    }

}
