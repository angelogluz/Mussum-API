package local.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {


    public static String generate(String pass) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return (encoder.encode(pass));
    }

}

