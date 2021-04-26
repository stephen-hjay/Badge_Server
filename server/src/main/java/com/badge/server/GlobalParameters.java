package com.badge.server;

public class GlobalParameters {

    public static class Encryption{
        public static final String secretKey="This is a random encryption key";
        public static final String algorithm = "SHA-256"; // "MD5"
    }

    public static class MovementProcess{
        public static final int lastSecSampleNum = 10;
    }

    public static final long timeout = 30 * 1000;
    public static final long persistTime = 1 * 1000;




}
