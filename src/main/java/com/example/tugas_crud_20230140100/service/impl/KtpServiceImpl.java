package com.example.tugas_crud_20230140100.service.impl;

import com.example.tugas_crud_20230140100.entity.KtpEntity;
import com.example.tugas_crud_20230140100.repository.KtpRepository;
import com.example.tugas_crud_20230140100.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Override
    public List<KtpEntity> getAllKtp() {
        return ktpRepository.findAll();
    }

    @Override
    public KtpEntity createKtp(KtpEntity ktp) {
        // Validasi: Cek apakah nomor KTP sudah ada
        if (ktpRepository.findByNomorKtp(ktp.getNomorKtp()).isPresent()) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }
        return ktpRepository.save(ktp);
    }

    @Override
    public KtpEntity getKtpById(Integer id) {
        return ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
    }

    @Override
    public KtpEntity updateKtp(Integer id, KtpEntity ktp) {
        KtpEntity existingKtp = getKtpById(id);
        existingKtp.setNamaLengkap(ktp.getNamaLengkap());
        existingKtp.setAlamat(ktp.getAlamat());
        existingKtp.setTanggalLahir(ktp.getTanggalLahir());
        existingKtp.setJenisKelamin(ktp.getJenisKelamin());
        return ktpRepository.save(existingKtp);
    }

    @Override
    public void deleteKtp(Integer id) {
        ktpRepository.deleteById(id);
    }
}
