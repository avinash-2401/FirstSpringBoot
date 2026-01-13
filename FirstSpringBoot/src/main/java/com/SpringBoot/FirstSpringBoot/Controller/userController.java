package com.SpringBoot.FirstSpringBoot.Controller;

import java.time.LocalDateTime;
import java.util.*;

import com.SpringBoot.FirstSpringBoot.Model.user;
import com.SpringBoot.FirstSpringBoot.Service.userService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {

    userService userServiceervice = new userService();


    public userController(userService userServiceervice) {
        this.userServiceervice = userServiceervice;
    }



    @PostMapping
    public ResponseEntity<user> CreateUser(@RequestBody user user) {

       user createdUser = userService.createUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

    }

    @PutMapping
    public ResponseEntity<user> UpdateUser(@RequestBody user user) {
        user userUpadted  = userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);

    }

    @DeleteMapping("/{id}")

    public ResponseEntity<String> DeleteUser(@PathVariable int id) {
        boolean isDeleted = userService.DeleteUser( id);
       if(!isDeleted)
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<user> GetUser() {
        return userService.getAllUser();
    }



    }







//    @GetMapping("/{id}/orders/{orderID}")
//    public ResponseEntity<user> GetUser(@PathVariable int id , @PathVariable int orderID) {
//        System.out.println("order id :" + orderID);
//
//        if (!userdb.containsKey(id))
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//        return ResponseEntity.status(HttpStatus.OK).body(userdb.get(id));




//    @GetMapping("/search")
//    public ResponseEntity<List<user>> searchuser(
//            @RequestParam (required = false , defaultValue = "toi") String name,
//            @RequestParam (required = false , defaultValue = "email") String email){
//            System.out.println(name);
//            System.out.println(email);
//
//
//        List<user> users = userdb.values().stream()
//                .filter(u->u.getName().equalsIgnoreCase(name))
//                .filter(u->u.getGamil().equalsIgnoreCase(email))
//                .toList();
//        return ResponseEntity.ok(users);
     //}












