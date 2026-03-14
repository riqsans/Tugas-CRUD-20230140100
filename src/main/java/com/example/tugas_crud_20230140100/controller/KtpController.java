package com.example.tugas_crud_20230140100.controller;

import com.example.tugas_crud_20230140100.dto.KtpDto;
import com.example.tugas_crud_20230140100.entity.KtpEntity;
import com.example.tugas_crud_20230140100.mapper.KtpMapper;
import com.example.tugas_crud_20230140100.service.KtpService;
import com.example.tugas_crud_20230140100.util.ResponHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*")
public class KtpController {
    @Autowired
    private KtpService ktpService;
    @Autowired private KtpMapper ktpMapper;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody KtpDto ktpDto) {
        try {
            KtpEntity entity = ktpMapper.toEntity(ktpDto);
            KtpEntity saved = ktpService.createKtp(entity);
            return ResponHandler.generateResponse("Berhasil simpan!", HttpStatus.CREATED, ktpMapper.toDto(saved));
        } catch (Exception e) {
            return ResponHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<KtpDto> list = ktpService.getAllKtp().stream()
                .map(ktpMapper::toDto)
                .collect(Collectors.toList());
        return ResponHandler.generateResponse("Data ditemukan", HttpStatus.OK, list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        try {
            KtpEntity entity = ktpService.getKtpById(id);
            return ResponHandler.generateResponse("Success", HttpStatus.OK, ktpMapper.toDto(entity));
        } catch (Exception e) {
            return ResponHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody KtpDto ktpDto) {
        try {
            KtpEntity entity = ktpMapper.toEntity(ktpDto);
            KtpEntity updated = ktpService.updateKtp(id, entity);
            return ResponHandler.generateResponse("Berhasil update!", HttpStatus.OK, ktpMapper.toDto(updated));
        } catch (Exception e) {
            return ResponHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            ktpService.deleteKtp(id);
            return ResponHandler.generateResponse("Data berhasil dihapus", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
