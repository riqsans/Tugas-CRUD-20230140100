package com.example.tugas_crud_20230140100.repository;

import com.example.tugas_crud_20230140100.entity.KtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KtpRepository extends JpaRepository<KtpEntity, Integer> {
    Optional<KtpEntity> findByNomorKtp(String nomorKtp);
}
