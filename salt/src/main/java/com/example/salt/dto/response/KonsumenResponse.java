package com.example.salt.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class KonsumenResponse {
    private Integer id;
    private String nama;
    private String alamat;
    private String kota;
    private String provinsi;
    private LocalDateTime tgl_registrasi;
    private String status;
}
