package com.retailhub.productmanagementservice.service;

import com.retailhub.productmanagementservice.exception.InvalidUserException;
import com.retailhub.productmanagementservice.model.UserDetail;
import com.retailhub.productmanagementservice.repository.UserDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserDetailService {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    public UserDetail authenticateUser(String userName, String password) {
        List<UserDetail> userDetails = userDetailsRepository.retrieveUserDetails();
        Optional<UserDetail> optionalUserDetail = userDetails.stream()
                .filter(userDetail -> userDetail.getUserName().equals(userName) && userDetail.getPassword().equals(password))
                .findFirst();

        return checkIfUserIsNewOrOld(optionalUserDetail);
    }

    private static UserDetail checkIfUserIsNewOrOld(Optional<UserDetail> optionalUserDetail) {
        if (optionalUserDetail.isPresent()) {
            return optionalUserDetail.get();
        } else {
            throw new InvalidUserException("Invalid Username or password");
        }
    }
}
