package entity;

import java.util.Random;

class ID {
    private final String randomString;
    ID(int length){
        this.randomString = generateRandomString(length);
    }
    private String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        StringBuilder id = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            id.append(chars.charAt(index));
        }
        return id.toString();
    }
}
