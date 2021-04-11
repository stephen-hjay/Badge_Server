package com.badge.server.android.Service;


import com.badge.server.android.Entity.Pojo.NearMacs;
import com.badge.server.android.Entity.rawdata.*;

import javax.servlet.http.HttpSession;

public interface AndroidDeviceService {
    /**
     * Login through Badge
     */
    public boolean login(MetaData metaData, HttpSession session);

    /**
     * save movement
     */
    public void saveMovement(Accelerator accelerator);

    /**
     * save QR code
     */
    public void saveQRCode(QRCode_raw qrCode_raw);

    /**
     * save voice
     */
    public void saveVoice(Microphone microphone);

    /**
     * save near mobiles
     */
    public void saveNearMacs(MacAddress macAddress);
}
