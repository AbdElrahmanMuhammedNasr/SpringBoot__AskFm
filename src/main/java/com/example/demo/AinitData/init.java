package com.example.demo.AinitData;

import com.example.demo.BConfigurationSecurity.UserInfo.UserAuth;
import com.example.demo.BConfigurationSecurity.UserInfo.UserAuthRepo;
import com.example.demo.XReposotry.*;
import com.example.demo.ZModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


@Component
public class init implements CommandLineRunner {


    @Autowired
    private FriendsRepo friendsRepo;
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private QuestionsAnswerRepo questionsAnswerRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserAuthRepo userAuthRepo;
    @Autowired
    private UserSettingRepo userSettingRepo;
    @Autowired
    private BlockListRepo blockListRepo;


    @Override
    public void run(String... args) throws Exception {
        try {


            UserAuth userAuth = new UserAuth();
            userAuth.setEmail("abdo@abdo.com");
            userAuth.setPassword("123A");
            userAuthRepo.save(userAuth);

            UserAuth userAuth2 = new UserAuth();
            userAuth2.setEmail("ali@abdo.com");
            userAuth2.setPassword("123B");
            userAuthRepo.save(userAuth2);



            User user1 = new User();
            user1.setEmail("abdo@abdo.com");
            user1.setFullName("AbdElrahman");

//             user1.saveImageFile("/media/abo/01D4C88B86503600/Photo/2.jpg");

            User user2 = new User();
            user2.setEmail("Hassan@Hassan.com");
            user2.setFullName("Hassan");

            BlockList blockList = new BlockList();
            blockList.setEmail("Tamer@gmail.com");
            blockList.setUser(user1);

            BlockList blockList2 = new BlockList();
            blockList2.setEmail("T@gmail.com");
            blockList2.setUser(user1);



            Questions questions1 = new Questions();
            questions1.setQuestion("how are you");
            questions1.setEmail("ahmed@ahmed.com");
            questions1.setTime(new Time(new Date(1900,1,1).getTime()));
            questions1.setUser(user1);

            Questions questions2 = new Questions();
            questions2.setQuestion("how old");
            questions2.setEmail("tamer@temer.com");
            questions2.setTime(new Time(new Date(1900,1,1).getTime()));
            questions2.setUser(user1);


            Questions questions3 = new Questions();
            questions3.setQuestion("how old");
            questions3.setEmail("tamer@temer.com");
            questions3.setTime(new Time(new Date(1900,1,1).getTime()));
            questions3.setUser(user2);


            UserSetting userSetting = new UserSetting();
            userSetting.setBio("i am developer");
            userSetting.setAnotherWebSites(new String[]{"www.youtube.com","www.facebook.com","www.instigram.com"});
            userSetting.setHashTags("GoHome");
            userSetting.setUserName("ABDO");
            userSetting.setDateOfBirth(new Date(0,0,0));
            userSetting.setGender("Male");
            userSetting.setLocation("Cairo");
            userSetting.setPrivacyQuestion(new boolean[]{true,false,false,true});
       //  userSetting.setUser(user1);

            QuestionsAnswer questionsAnswer1 = new QuestionsAnswer();
            questionsAnswer1.setQuestion("HI");
            questionsAnswer1.setEmail("ahmed@ahmed.com");
            questionsAnswer1.setAnswer("HEY");
            questionsAnswer1.setDate((new Timestamp(new Date(1998,8,8).getTime())));
            questionsAnswer1.setUser(user1);

            QuestionsAnswer questionsAnswer2 = new QuestionsAnswer();
            questionsAnswer2.setQuestion("Good Day");
            questionsAnswer2.setEmail("Ali@Ali.com");
            questionsAnswer2.setAnswer("thanks");
            questionsAnswer2.setDate( ( new Timestamp(new Date(1998,8,8).getTime())) );
            questionsAnswer2.setUser(user1);

            Friends friends1 = new Friends();
            friends1.setEmail("Ali@Ali.com");
            friends1.setUser(user1);

            Friends friends2 = new Friends();
            friends2.setEmail("Ali@Ali.com");
            friends2.setUser(user1);

            UserProfile userProfile = new UserProfile();
            userProfile.setFollowers(12000);
            userProfile.setActive(true);
//         userProfile.setUser(user1);

            user1.setUserSetting(userSetting);
            user1.setUserProfile(userProfile);

          //  userProfileRepo.save(userProfile);


            userRepo.save(user1);
            userRepo.save(user2);
            userSettingRepo.save(userSetting);
            blockListRepo.save(blockList);
            blockListRepo.save(blockList2);



            friendsRepo.save(friends1);
            friendsRepo.save(friends2);

            questionRepo.save(questions1);
            questionRepo.save(questions2);
            questionRepo.save(questions3);

            questionsAnswerRepo.save(questionsAnswer1);
            questionsAnswerRepo.save(questionsAnswer2);

        } catch(Exception x){
            System.out.println(x.getMessage());
        }





    }
}
