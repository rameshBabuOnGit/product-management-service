package com.retailhub.productmanagementservice.service;

import com.retailhub.productmanagementservice.exception.InvalidUserException;
import com.retailhub.productmanagementservice.model.UserDetail;
import com.retailhub.productmanagementservice.repository.UserDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserDetailService {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    public String authenticateUser(String userName, String password) {
        List<UserDetail> userDetails = userDetailsRepository.retrieveUserDetails();
        boolean checkIfUserExists = userDetails.stream()
                .anyMatch(userDetail -> userDetail.getUserName().equals(userName) && userDetail.getPassword().equals(password));

        return checkIfUserIsNewOrOld(checkIfUserExists);
    }

    private static String checkIfUserIsNewOrOld(boolean checkIfUserExists) {
        if (checkIfUserExists) {
            return "User Exists";
        } else {
            throw new InvalidUserException("Invalid Username or password");
        }
    }
}
