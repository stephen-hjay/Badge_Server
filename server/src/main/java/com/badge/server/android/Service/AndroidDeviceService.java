package com.badge.server.android.Service;


import com.badge.server.android.Entity.Pojo.NearMacs;
import com.badge.server.android.Entity.rawdata.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public interface AndroidDeviceService {
    /**
     * Login through Badge
     */
    public boolean login(MetaData metaData, ServletContext servletContext);

    /**
     * save movement
     */
    public void saveMovement(Accelerator accelerator, HttpSession httpSession);

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
