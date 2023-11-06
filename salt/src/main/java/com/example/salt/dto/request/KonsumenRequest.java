package com.example.salt.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class KonsumenRequest {
    @Size(max = 255, message = "Nama harus punya maksimal 20 karakter")
    @NotBlank(message = "Nama tidak boleh kosong")
    private String nama;

    @Size(max = 255, message = "Alamat harus punya maksimal 20 karakter")
    @NotBlank(message = "Alamat tidak boleh kosong")
    private String alamat;

    @Size(min = 1, max = 100, message = "Kota harus diisi 1 karakter saja")
    @NotBlank(message = "Kota tidak boleh kosong")
    private String kota;

    @Size(min = 1, max = 100, message = "Provinsi harus diisi 1 karakter saja")
    @NotBlank(message = "Provinsi tidak boleh kosong")
    private String provinsi;

    @Size(min = 1, max = 1, message = "Status harus diisi 1 karakter saja")
    @NotBlank(message = "Status tidak boleh kosong")
    @Pattern(regexp = "[01]", message = "Hanya angka 0 atau 1 yang diperbolehkan untuk status")
    private String status;

}
