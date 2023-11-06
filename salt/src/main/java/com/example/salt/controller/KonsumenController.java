package com.example.salt.controller;

import com.example.salt.dto.request.KonsumenRequest;
import com.example.salt.dto.response.KonsumenResponse;
import com.example.salt.service.KonsumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/konsumen")
@Validated
public class KonsumenController {
    @Autowired
    private KonsumenService konsumenService;

    @GetMapping
    public ResponseEntity<List<KonsumenResponse>> getAllKonsumen() {
        List<KonsumenResponse> konsumenResponses = konsumenService.getAllKonsumen();
        return ResponseEntity.status(HttpStatus.OK).body(konsumenResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KonsumenResponse> getKonsumenById(@PathVariable int id){
        KonsumenResponse konsumenResponse = konsumenService.getKonsumenById(id);
        return ResponseEntity.status(HttpStatus.OK).body(konsumenResponse);
    }

    @PostMapping("")
    public ResponseEntity<KonsumenResponse> createKonsumen(@Valid @RequestBody KonsumenRequest konsumenRequest){
        KonsumenResponse konsumenResponse = konsumenService.createKonsumen(konsumenRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(konsumenResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KonsumenResponse> updateKonsumen(@RequestBody KonsumenRequest konsumenRequest, @PathVariable Integer id){
        KonsumenResponse konsumenResponse = konsumenService.updateKonsumen(konsumenRequest,id);
        return ResponseEntity.status(HttpStatus.OK).body(konsumenResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteKonsumen(@PathVariable Integer id) {
        konsumenService.deleteKonsumen(id);
        return ResponseEntity.status(HttpStatus.OK).body("Konsumen dengan ID " + id + " berhasil dihapus.");
    }
}
