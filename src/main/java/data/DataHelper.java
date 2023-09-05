package data;

import com.github.javafaker.Faker;
import lombok.Value;
import java.util.Locale;



public class DataHelper {
   private static final Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }

    public static RegUser getRegisteredUser() {
        return new RegUser("vasya", "qwerty123");
    }

 // public static RegUser getRegisteredUserWithRandomPassword(){
 // return new RegUser("vasya",generateRandomPassword());
  // }


    private static String generateRandomLogin() { return faker.name().username();}

    private static String generateRandomPassword() { return faker.internet().password();}

  public static RegUser generateRandomUser() {
       return new RegUser(generateRandomLogin(), generateRandomPassword());
    }

    public static VerificationCode generateRandomVerificationCode () {
        return new VerificationCode(faker.numerify("####"));
    }

    @Value
    public static class RegUser {
        String login;
        String password;
    }
    @Value
    public static class VerificationCode {
        String code;
    }

}
