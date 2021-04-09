package util;

public class Main {
    public static void main(String[] args) {
        String pass = "hugorei";
        System.out.println(Security.getHash(pass));
    }
}
