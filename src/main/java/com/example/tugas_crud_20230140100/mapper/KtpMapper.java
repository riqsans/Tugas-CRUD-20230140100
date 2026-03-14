package com.example.tugas_crud_20230140100.mapper;

import com.example.tugas_crud_20230140100.dto.KtpDto;
import com.example.tugas_crud_20230140100.entity.KtpEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class KtpMapper {
    public KtpDto toDto(KtpEntity entity) {
        KtpDto dto = new KtpDto();
        dto.setId(entity.getId());
        dto.setNomorKtp(entity.getNomorKtp());
        dto.setNamaLengkap(entity.getNamaLengkap());
        dto.setAlamat(entity.getAlamat());
        dto.setTanggalLahir(entity.getTanggalLahir().toString());
        dto.setJenisKelamin(entity.getJenisKelamin());
        return dto;
    }

    public KtpEntity toEntity(KtpDto dto) {
        KtpEntity entity = new KtpEntity();
        if (dto.getId() != null) entity.setId(dto.getId());
        entity.setNomorKtp(dto.getNomorKtp());
        entity.setNamaLengkap(dto.getNamaLengkap());
        entity.setAlamat(dto.getAlamat());
        entity.setTanggalLahir(LocalDate.parse(dto.getTanggalLahir()));
        entity.setJenisKelamin(dto.getJenisKelamin());
        return entity;
    }
}

