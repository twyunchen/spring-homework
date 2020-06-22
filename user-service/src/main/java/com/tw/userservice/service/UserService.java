package com.tw.userservice.service;

import com.tw.userservice.model.User;
import com.tw.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Autowired
    private EmailServiceClient emailServiceClient;


    public User createUser(User user) {
        user.setCreateAt(new Date());
        var email = emailServiceClient.getEmail(user.getName());
        user.setEmail(email);
        return userRepository.save(user);
    }

    public void updateUser(User user) throws Exception {
        var dbUserOptional = userRepository.findById(user.getId());

        if (!dbUserOptional.isPresent()) {
            throw new Exception("用户不存在！");
        }

        var dbUser = dbUserOptional.get();

        dbUser.setAge(user.getAge());
        dbUser.setName(user.getName());
        dbUser.setUpdateAt(new Date());

        userRepository.save(dbUser);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public Page<User> searchUser(String name,
                                 Integer minAge,
                                 Integer maxAge,
                                 Integer pageIndex,
                                 Integer pageSize) {

        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        return userRepository.findByNameLikeAndAgeBetween(name, minAge, maxAge, pageable);
    }
}
