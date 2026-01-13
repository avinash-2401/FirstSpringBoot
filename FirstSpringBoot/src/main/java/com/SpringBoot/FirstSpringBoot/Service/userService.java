package com.SpringBoot.FirstSpringBoot.Service;



import com.SpringBoot.FirstSpringBoot.ExceptionHandling.userNotFoundException;
import com.SpringBoot.FirstSpringBoot.Model.user;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class userService {

    static Map<Integer, user> userdb = new HashMap<>();

    public static user createUser(user user) {
        System.out.println(user.getGamil());
        userdb.put(user.getId(), user);
        return user;
    }

    public static user updateUser(user user)  {
        if (!userdb.containsKey(user.getId()))
          throw new userNotFoundException("user with this id " + user.getId()+"not exits ");
           userdb.put(user.getId(), user);
           return user;
    }


    public static boolean DeleteUser(int id) {
        if(!userdb.containsKey(id))
           throw new userNotFoundException("no user found in database");
        userdb.remove(id);
        return true;
    }

    public static List<user> getAllUser() {
        if(userdb.isEmpty())
            throw new NullPointerException();
        return new ArrayList<>(userdb.values());
    }


}
