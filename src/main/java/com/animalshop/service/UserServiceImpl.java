package com.animalshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.animalshop.exception.UserAlreadyExistsException;
import com.animalshop.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) throws UserAlreadyExistsException {

        Criteria criteria = new Criteria().orOperator(//
            Criteria.where("username").is(user.getUsername()), //
            Criteria.where("email").is(user.getEmail())//
        );

        User existingUser = mongoOperations.findOne(new Query(criteria), User.class);
        if (existingUser != null) {
            throw new UserAlreadyExistsException(user.getUsername(), user.getEmail());
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        mongoOperations.insert(user);
    }

    @Override
    public User getUser(String username) {
        return mongoOperations.findOne(new Query(Criteria.where("username").is(username)), User.class);
    }
}
