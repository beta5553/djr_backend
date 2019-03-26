package com.qbtrance.djrank.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BiographyTest {

    private static final Logger logger = LoggerFactory.getLogger(BiographyTest.class);

    @Autowired
    BiographyRepository bioRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void createBioTest() {
        logger.info("testBiographyInsert starts");
        Biography bio = new Biography();
        bio.setUserId(1);
        bio.setLang("EN");
        bio.setBiography("Biography here");
        bioRepository.save(bio);
        logger.info("testBiographyInsert saved.");
    }

    @Test
    public void createUserWithOneBioTest() {
        logger.info("insertUserWithOneBio starts");
        User user = new User();
        user.setFirstName("Israel-test4");
        user.setLastName("Morales-test4");
        Biography bio = new Biography();
        bio.setLang("SP");
        bio.setBiography("Esta es mi bio en sp");
        user.addBiography(bio);
        userRepository.save(user);
        logger.info("User saved");
    }

    @Test
    public void updateBiographyTest() {
        Optional<Biography> bio = Optional.of(new Biography());
        bio = bioRepository.findById(21);
        bio.get().setBiography("Bio updated");
        bioRepository.save(bio.get());
    }

    /**
     * TODO: Delete is not working due the relationship with its parent USER,
     *
     * he problem seems to be that you are using cascade=CascadeType.ALL, which also includes CascadeType.PERSIST.
     * CascadeType.PERSIST means that the child entity is completely managed by the parent and you cannot delete it directly.
     * In order to delete you just need to remove it from the parent.
     *
     * You could just add the other CascadeTypes instead of all. e.g CascadeType.REMOVE, if the only thing you would want is
     * to remove the child if the parent is removed.
     *
     * More info:
     * https://stackoverflow.com/questions/29172313/spring-data-repository-does-not-delete-manytoone-entity
     *
     */
    @Test
    public void deleteBiographyTest() {
        logger.info("deleteBiographyTest start");
        List <Biography> bios =  bioRepository.findByUserId(31);

        if (bios != null) {
            for (Biography bio : bios) {
                logger.info("Deleting biography id: " + bio.getBiographyId());
                bioRepository.delete(bio);
            }
        }

        logger.info("deleteBiographyTest finish");
    }

    @Test
    public void findByUserIDTest() {
        logger.info("findAllBiographies Start");
        List<Biography> bioList = null;
        bioList = bioRepository.findByUserId(36);
        System.out.println("Hola find all bios - izzy");

        if (bioList != null) {
            for (Biography bio : bioList) {
                System.out.println(bio.toString());
                System.out.println(bio.getUserId());
                System.out.println(bio.getLang());
                System.out.println(bio.getBiography());
            }
        }

        logger.info("findAllBiographies End");
    }

    @Test
    public void findAllBiosTest(){
        logger.info("findAllBiosTest start");
        List<Biography> bios = (List<Biography>) bioRepository.findAll();

        if(bios != null)
        for(Biography bio : bios){
            System.out.println("user id" + bio.getUserId());
        }
        logger.info("findAllBiosTest finish");
    }

}
