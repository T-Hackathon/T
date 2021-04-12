package util;

import java.math.BigInteger;
        import java.security.MessageDigest;
        import java.security.NoSuchAlgorithmException;

public class Security {

    public final static String ALGORITHM = "SHA-1";
    public static final String FORMAT_SPECIFIER = "%040x";

    public static String getHash(String text) {

        try {

            MessageDigest md = MessageDigest.getInstance(ALGORITHM);

            // obtain a new hash
            md.reset();
            md.update(text.getBytes());
            byte[] digest = md.digest();

            // convert hash bytes into string
            BigInteger bigInt = new BigInteger(1, digest);
            return String.format(FORMAT_SPECIFIER, bigInt);

        } catch (NoSuchAlgorithmException ex) {
            return text;
        }

    }

}
