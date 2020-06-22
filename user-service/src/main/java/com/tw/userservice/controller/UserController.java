package com.tw.userservice.controller;

import com.tw.userservice.model.User;
import com.tw.userservice.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping
    public Integer createUser(@RequestBody User user) {
        return userService.createUser(user).getId();
    }

    @PutMapping
    public void updateUser(@RequestBody User user) throws Exception {
        userService.updateUser(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/query")
    public Page<User> searchUser(@RequestParam(name = "name", defaultValue = "") String name,
                                 @RequestParam(name = "minAge", defaultValue = "0") Integer minAge,
                                 @RequestParam(name = "maxAge", defaultValue = "999") Integer maxAge,
                                 @RequestParam(name = "pageIndex", defaultValue = "0") Integer pageIndex,
                                 @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {

        return userService.searchUser(name, minAge, maxAge, pageIndex, pageSize);
    }

}
