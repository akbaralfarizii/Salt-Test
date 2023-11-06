package com.example.salt.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "konsumen")
@Data
@NoArgsConstructor
public class Konsumen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 255, message = "Nama harus punya maksimal 255 karakter")
    @NotBlank(message = "Nama tidak boleh kosong")
    private String nama;

    @Size(max = 255, message = "Alamat harus punya maksimal 255 karakter")
    @NotBlank(message = "Alamat tidak boleh kosong")
    private String alamat;

    @Size(min = 1, max = 100, message = "Provinsi harus diisi 100 karakter saja")
    @NotBlank(message = "Kota tidak boleh kosong")
    private String kota;

    @Size(min = 1, max = 100, message = "Provinsi harus diisi 100 karakter saja")
    @NotBlank(message = "Kota tidak boleh kosong")
    private String provinsi;

    private LocalDateTime tgl_registrasi = LocalDateTime.now();

    @Size(min = 1, max = 1, message = "Status harus diisi 1 karakter saja")
    @NotBlank(message = "Status tidak boleh kosong")
    @Pattern(regexp = "[01]", message = "Hanya angka 0 atau 1 yang diperbolehkan untuk status")
    private String status;
}
