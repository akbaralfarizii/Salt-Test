package com.example.salt.controller;

import com.example.salt.dto.response.KonsumenResponse;
import com.example.salt.model.Konsumen;
import com.example.salt.service.KonsumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class KonsumenViewController {
    @Autowired
    private KonsumenService konsumenService;

    @GetMapping
    public String ViewHomePage(Model model) {
        List<KonsumenResponse> konsumenResponses = konsumenService.getAllKonsumen();
        model.addAttribute("listKonsumen", konsumenResponses);
        return "index";
    }


}
