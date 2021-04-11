package com.badge.server.android.DAO;


import com.badge.server.android.Entity.Pojo.Voice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoiceRepository extends JpaRepository<Voice,Long> {
}
