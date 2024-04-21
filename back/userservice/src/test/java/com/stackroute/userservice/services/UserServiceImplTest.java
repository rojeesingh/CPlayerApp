package com.stackroute.userservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.stackroute.userservice.exception.UserAlreadyExsitsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserServiceImpl#saveUser(User)}
     */
    @Test
    void testSaveUser() throws UserAlreadyExsitsException {
        User user = new User();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setUserId("42");

        User user1 = new User();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setCreatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setUserId("42");
        Optional<User> ofResult = Optional.of(user1);
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findById((String) any())).thenReturn(ofResult);

        User user2 = new User();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setUserId("42");
        assertThrows(UserAlreadyExsitsException.class, () -> userServiceImpl.saveUser(user2));
        verify(userRepository).findById((String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#saveUser(User)}
     */
    @Test
    void testSaveUser2() throws UserAlreadyExsitsException {
        User user = new User();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setUserId("42");
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findById((String) any())).thenReturn(Optional.empty());

        User user1 = new User();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setCreatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setUserId("42");
        assertTrue(userServiceImpl.saveUser(user1));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#findByUserIdAndPassword(String, String)}
     */
    @Test
    void testFindByUserIdAndPassword() throws UserNotFoundException {
        User user = new User();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setUserId("42");
        when(userRepository.findByUserIdAndPassword((String) any(), (String) any())).thenReturn(user);
        assertSame(user, userServiceImpl.findByUserIdAndPassword("42", "iloveyou"));
        verify(userRepository).findByUserIdAndPassword((String) any(), (String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#upadteUser(String, User)}
     */
    @Test
    void testUpadteUser() throws UserNotFoundException {
        User user = new User();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setUserId("42");
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setCreatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setUserId("42");
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((String) any())).thenReturn(ofResult);

        User user2 = new User();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setUserId("42");
        User actualUpadteUserResult = userServiceImpl.upadteUser("42", user2);
        assertSame(user, actualUpadteUserResult);
        assertEquals("42", actualUpadteUserResult.getUserId());
        assertEquals("iloveyou", actualUpadteUserResult.getPassword());
        assertEquals("Doe", actualUpadteUserResult.getLastName());
        assertEquals("Jane", actualUpadteUserResult.getFirstName());
        assertEquals("jane.doe@example.org", actualUpadteUserResult.getEmail());
        verify(userRepository).save((User) any());
        verify(userRepository).findById((String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#upadteUser(String, User)}
     */
    @Test
    void testUpadteUser2() throws UserNotFoundException {
        User user = new User();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setUserId("42");
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findById((String) any())).thenReturn(Optional.empty());

        User user1 = new User();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setCreatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setUserId("42");
        assertThrows(UserNotFoundException.class, () -> userServiceImpl.upadteUser("42", user1));
        verify(userRepository).findById((String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getUserById(String)}
     */
    @Test
    void testGetUserById() throws UserNotFoundException {
        User user = new User();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setUserId("42");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById((String) any())).thenReturn(ofResult);
        assertSame(user, userServiceImpl.getUserById("42"));
        verify(userRepository).findById((String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getUserById(String)}
     */

    @Disabled("TODO: Complete this test")
    void testGetUserById2() throws UserNotFoundException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.get()" because the return value of "com.stackroute.userservice.repository.UserRepository.findById(Object)" is null
        //       at com.stackroute.userservice.services.UserServiceImpl.getUserById(UserServiceImpl.java:67)
        //   In order to prevent getUserById(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getUserById(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(userRepository.findById((String) any())).thenReturn(null);
        userServiceImpl.getUserById("42");
    }
}

