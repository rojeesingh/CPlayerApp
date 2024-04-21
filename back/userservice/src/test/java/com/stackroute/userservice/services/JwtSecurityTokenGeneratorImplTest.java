package com.stackroute.userservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.stackroute.userservice.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtSecurityTokenGeneratorImpl.class})
@ExtendWith(SpringExtension.class)
class JwtSecurityTokenGeneratorImplTest {
    @Autowired
    private JwtSecurityTokenGeneratorImpl jwtSecurityTokenGeneratorImpl;

    /**
     * Method under test: {@link JwtSecurityTokenGeneratorImpl#generateToken(User)}
     */
    @Test
    void testGenerateToken() {
        User user = new User();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setUserId("42");
        Map<String, String> actualGenerateTokenResult = jwtSecurityTokenGeneratorImpl.generateToken(user);
        assertEquals(2, actualGenerateTokenResult.size());
        assertEquals("User successfully logged in", actualGenerateTokenResult.get("message"));
    }
}

