package com.example.salt.service;


import com.example.salt.dto.request.KonsumenRequest;
import com.example.salt.dto.response.KonsumenResponse;
import com.example.salt.model.Konsumen;
import com.example.salt.repository.KonsumenRepository;
import com.google.firebase.database.DatabaseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KonsumenService {
    @Lazy
    @Autowired
    private KonsumenRepository konsumenRepository;

    @Lazy
    @Autowired
    private ModelMapper modelMapper;

    public List<KonsumenResponse> getAllKonsumen() {
        try {
            List<Konsumen> konsumens = konsumenRepository.findAll();

            List<KonsumenResponse> konsumenResponses = konsumens.stream()
                    .map(konsumen -> modelMapper.map(konsumen, KonsumenResponse.class))
                    .collect(Collectors.toList());

            return konsumenResponses;
        } catch (DataAccessException e) {
            throw new DatabaseException("Kesalahan dalam mengakses basis data.");
        }
    }

    public KonsumenResponse getKonsumenById(Integer id){
        try {
            Optional<Konsumen> optionalKonsumen = konsumenRepository.findById(id);

            if (!optionalKonsumen.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Konsumen not found with ID: " + id);
            }
            Konsumen konsumen = optionalKonsumen.get();
            KonsumenResponse konsumenResponse = modelMapper.map(konsumen, KonsumenResponse.class);
            return konsumenResponse;
        }catch (DataAccessException e) {
            throw new DatabaseException("Kesalahan dalam mengakses basis data.");
        }
    }

    public KonsumenResponse createKonsumen(KonsumenRequest konsumenRequest){
        try {
            Konsumen konsumen = modelMapper.map(konsumenRequest, Konsumen.class);
            Konsumen savedKonsumen = konsumenRepository.save(konsumen);

            return modelMapper.map(savedKonsumen, KonsumenResponse.class);
        }catch (DataAccessException e) {
            throw new DatabaseException("Kesalahan dalam mengakses basis data.");
        }
    }

    public KonsumenResponse updateKonsumen(KonsumenRequest konsumenRequest, Integer id){
        try {
            Optional<Konsumen> existingKonsumen = konsumenRepository.findById(id);
            if (!existingKonsumen.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Konsumen not found with ID: " + id);
            }

            if (konsumenRequest.getNama() != null) {
                existingKonsumen.get().setNama(konsumenRequest.getNama());
            }

            if (konsumenRequest.getAlamat() != null) {
                existingKonsumen.get().setAlamat(konsumenRequest.getAlamat());
            }

            if (konsumenRequest.getProvinsi() != null) {
                existingKonsumen.get().setProvinsi(konsumenRequest.getProvinsi());
            }

            if (konsumenRequest.getKota() != null) {
                existingKonsumen.get().setKota(konsumenRequest.getKota());
            }

            if (konsumenRequest.getStatus() != null) {
                existingKonsumen.get().setStatus(konsumenRequest.getStatus());
            }

            Konsumen updatedKonsumen = konsumenRepository.save(existingKonsumen.get());

            return modelMapper.map(updatedKonsumen, KonsumenResponse.class);
        }catch (DataAccessException e) {
            throw new DatabaseException("Kesalahan dalam mengakses basis data.");
        }
    }

    public void deleteKonsumen(Integer id){
        try{
        Optional<Konsumen> existingKonsumen = konsumenRepository.findById(id);

        if (!existingKonsumen.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Konsumen not found with ID: " + id);
        }
            konsumenRepository.deleteById(id);
        }catch (DataAccessException e) {
            throw new DatabaseException("Kesalahan dalam mengakses basis data.");
        }
    }
}
