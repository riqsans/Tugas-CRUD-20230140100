package com.example.tugas_crud_20230140100.service;

import com.example.tugas_crud_20230140100.entity.KtpEntity;
import java.util.List;

public interface KtpService {
    List<KtpEntity> getAllKtp();
    KtpEntity getKtpById(Integer id);
    KtpEntity createKtp(KtpEntity ktp);
    KtpEntity updateKtp(Integer id, KtpEntity ktp);
    void deleteKtp(Integer id);
}
