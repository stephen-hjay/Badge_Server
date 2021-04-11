package com.badge.server.android.DAO;


import com.badge.server.android.Entity.Pojo.QRCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRCodeRepository extends JpaRepository<QRCode,Long> {
}
