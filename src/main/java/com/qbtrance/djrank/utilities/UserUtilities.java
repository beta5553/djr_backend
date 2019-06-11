package com.qbtrance.djrank.utilities;

import com.qbtrance.djrank.dao.User;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class is intended to contain common utilities for users.
 */

@Slf4j
public class UserUtilities {

    /**
     * This method will create the base user file system and directories so we can store the user data
     * such as music and images in a order fashion. It will create a user structure.
     *
     * ../static/users/user_name/images
     * ../static/users/user_name/music
     *
     * @param user
     */
    public static void createUserFileSystem(User user) {

        String userId = Integer.toString(user.getUserId());
        String dirBasePath = "src/main/resources/static/users/"+userId;
        String dirImagePath = "src/main/resources/static/users/"+userId+"/images/";
        String dirMusicPath = "src/main/resources/static/users/"+userId+"/music/";

        // Check If Directory Already Exists Or Not?
        Path dirPathObj = Paths.get(dirBasePath);
        boolean dirExists = Files.exists(dirPathObj);
        if(dirExists) {
            log.info("! Directory Already Exists !");
        } else {
            try {
                // Creating The New Directory Structure
                Files.createDirectories(dirPathObj);
                Files.createDirectories(Paths.get(dirImagePath));
                Files.createDirectories(Paths.get(dirMusicPath));
                log.info("! New Directory Successfully Created !");
            } catch (IOException ioExceptionObj) {
                log.error("Problem Occured While Creating The Directory Structure= " + ioExceptionObj.getMessage());
            }
        }
    }

    /**
     * This method will create a report of the users that exist in the database but they dont have a file system
     * yet created.
     *
     * Example: user 22 exist in the User table but, it doesn't exist on the file system:
     *
     * src/main/resources/static/users/22/
     * src/main/resources/static/users/22/images/
     * src/main/resources/static/users/22/music/
     *
     * This method will only print the list of occurences, it will not fix them.
     *
     */

    public static void printUserFileSystemInconsistency(List<User> userList) {

        log.info("Starting UserUtilities.printUserFileSystemInconsistency method");
        int nonExistingFoldersCounter = 0;
        int existingFoldersCounter = 0;

        for (User user : userList) {

            String userId = Integer.toString(user.getUserId());
            String dirBasePath = "src/main/resources/static/users/"+userId;
            String dirImagePath = "src/main/resources/static/users/"+userId+"/images/";
            String dirMusicPath = "src/main/resources/static/users/"+userId+"/music/";

            // Check If Directory Already Exists Or Not?
            Path dirPathObj = Paths.get(dirBasePath);
            Path dirPathImage = Paths.get(dirImagePath);
            Path dirPathMusic = Paths.get(dirMusicPath);

            if(!Files.exists(dirPathObj)) {
                nonExistingFoldersCounter++;
                log.info("Directory doesn't Exists:" + dirBasePath + " for user: " + userId);
            } else {

                existingFoldersCounter++;
                System.out.println("user id: " + user.getUserId() + " -OK- ");

                if(!Files.exists(dirPathImage)) {
                    log.info("Directory doesn't Exists:" + dirImagePath + " for user: " + userId);
                }

                if(!Files.exists(dirPathMusic)) {
                    log.info("Directory doesn't Exists:" + dirPathMusic + " for user: " + userId);
                }
            }
        }

        System.out.println("Number of non-existent user directories: " + nonExistingFoldersCounter);
        System.out.println("Number of existing user directories: " + existingFoldersCounter);

    }  
}