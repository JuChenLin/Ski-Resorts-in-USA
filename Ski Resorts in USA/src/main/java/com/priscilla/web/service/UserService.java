package com.priscilla.web.service;

import com.priscilla.web.entity.skiresort.Address;
import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.entity.user.User;
import com.priscilla.web.exception.NotFoundException;
import com.priscilla.web.parameter.SkiResortQueryParameter;
import com.priscilla.web.parameter.UserQueryParameter;
import com.priscilla.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User request) {
        System.out.println("User Service: " + request);
        User user = new User(request);

        return userRepository.save(user);
    }

    public User updateUser(String id, User request) {
        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new NotFoundException("There's no this user in database."));
        user.setAll(request);

        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new NotFoundException("There's no this user in database."));

        userRepository.delete(user);
    }

    public User getUser(String id) {
        return userRepository.findById(id)
                             .orElseThrow(() -> new NotFoundException("There's no this user resort."));
    }

    public Iterable<User> getUserAll() {
        return userRepository.findAll();
    }

    public List<User> getUsersByQuery(UserQueryParameter parameter) {
        String nameKeyword = Optional.ofNullable(parameter.getNameKeyword()).orElse("");
        String orderBy = parameter.getOrderBy();
        String sortRule = parameter.getSortRule();

        Sort sort = Sort.unsorted();
        if (Objects.nonNull(orderBy) && Objects.nonNull(sortRule)) {
            Sort.Direction direction = Sort.Direction.fromString(sortRule);
            sort = Sort.by(direction, orderBy);
        }

        return userRepository.findByNameContaining(nameKeyword, sort);
    }

}
