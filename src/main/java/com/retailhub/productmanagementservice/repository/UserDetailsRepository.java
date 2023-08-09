package com.retailhub.productmanagementservice.repository;

import com.retailhub.productmanagementservice.model.UserDetail;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.apache.logging.log4j.util.Strings.trimToNull;

@Repository
public class UserDetailsRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String USER_DETAILS = "select user_id, username, password, email from userdetails";

    private final RowMapper<UserDetail> userDetailRowMapper = userDetailRowMapper();

    public UserDetailsRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<UserDetail> userDetailRowMapper() {
        return (rs, rowNum) -> UserDetail.builder()
                .userId(rs.getInt("user_id"))
                .userName(trimToNull(rs.getString("username")))
                .password(trimToNull(rs.getString("password")))
                .userEmail(trimToNull(rs.getString("email")))
                .build();
    }

    public List<UserDetail> retrieveUserDetails() {
        return jdbcTemplate.query(USER_DETAILS, userDetailRowMapper);
    }
}
