package top.jonakls.cgmedic.api.util;

import java.util.Base64;

public final class PasswordUtil {

    private static final Base64.Encoder ENCODER = Base64.getEncoder();
    private static final Base64.Decoder DECODER = Base64.getDecoder();

    private PasswordUtil() {
    }

    public static String encode(String password) {
        return ENCODER.encodeToString(password.getBytes());
    }

    public static String decode(String password) {
        return new String(DECODER.decode(password));
    }

    public static boolean compare(String password, String encodedPassword) {
        return password.equals(decode(encodedPassword));
    }
}
