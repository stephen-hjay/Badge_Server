//package com.badge.server.android.Utils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DataProcess {
//
//    // helper function:
//    private int getSitStateLastSecond(String datasetID, String badgeID, long currTimeStamp) {
//        long timeStampFrom = currTimeStamp - 1200;  // the value 1200/800 are chosen according to my personal understanding
//        long timeStampTo = currTimeStamp - 800;
//
//        // TODO
//        /*  读表 movement_stable:
//            - dataset_id = datasetID
//            - badge_id = badgeID
//            - time_stamp >= timeStampFrom & time_stamp <= timeStampTo
//            => int[] sitStates: raw_x
//        */
//
//        return sitStates.length == 0 ? 1 : sitStates[0];
//    }
//
//    public int[] getMovementState(String datasetID, String badgeID, long[] timeStamp, float[] ax, float[] ay, float[] az) {
//        int sitState = 0;
//        int moveState = 0;
//        int moveNum = 0;
//        int sitFlag1 = 0;
//        int sitFlag2 = 0;
//        int sit = 0;
//        int moveNumAfterSit = 0;
//        int prevSitState = getSitStateLastSecond(datasetID, badgeID, timeStamp[0]);
//
//        for (int i = 1; i < timeStamp.length; i++) {
//            if ((ax[i] >= 2.5 || ax[i] <= -2.5)
//                    || (az[i] >= 2.5 || az[i] <= -2.5)
//                    || (ay[i] >= 9.8+2.5 || ay[i] <= 9.8-2.5)) {
//                moveNum++;
//            }
//
//            if(ay[i] < 9.8 - 4) {
//                sitFlag1 = 1;
//            }
//            if(sitFlag1 == 1 && ay[i] > 9.8 + 4.5){
//                sitFlag2 = 1;
//            }
//            if(sitFlag2 == 1){
//                if(ay[i] >= 9.8+2.5 || ay[i] <= 9.8-2.5) {
//                    moveNumAfterSit++;
//                }
//            }
//            if(moveNumAfterSit >= 8) {
//                moveNumAfterSit = 0;
//                sitFlag1 = 0;
//                sitFlag2 = 0;
//            }
//        }
//
//        if(moveNum >= 4 * 4) {
//            moveState = 4; // move
//        } else {
//            moveState = 3; // still
//        }
//
//        if(sitFlag2 == 1) {
//            sit = 1;
//        }
//
//        if(sit == 1) {
//            sitState = 0;
//        }else if(moveState == 4){
//            sitState = 1;
//        }else{
//            sitState = prevSitState;
//        }
//
//        return new int[] { sitState, moveState };
//    }
//}
