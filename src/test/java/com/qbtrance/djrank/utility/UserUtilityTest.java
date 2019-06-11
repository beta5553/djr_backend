package com.qbtrance.djrank.utility;

import com.qbtrance.djrank.dao.User;
import com.qbtrance.djrank.dao.UserRepository;
import com.qbtrance.djrank.utilities.UserUtilities;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserUtilityTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void printUserFileSystemInconsistencyTest() {
        List<User> userList = (List<User>) userRepository.findAll();
        UserUtilities.printUserFileSystemInconsistency(userList);
    }
}
