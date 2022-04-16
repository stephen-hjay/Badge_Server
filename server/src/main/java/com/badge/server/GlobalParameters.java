package com.badge.server;

public class GlobalParameters {

    public static class Encryption{
        public static final String secretKey="This is a random encryption key";
        public static final String algorithm = "SHA-256"; // "MD5"
    }

    public static class MovementProcess{
        public static final int lastSecSampleNum = 10;
    }

    public static final long TIMEOUT = 30 * 1000;
    public static final long PERSIST_TIME = 60 * 1000; // 15s every active history

    public static final long INTERVAL_NUM_BADGE = 60 * 1000; // 60s every active history





    public static final String HOST_IP = "192.168.1.9";

    public static final Object BADGELOCK = new Object();




}
