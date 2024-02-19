package com.example.SpringBootP3.RestController.saleRest;

import com.example.SpringBootP3.repository.sale.IRawMaterialRepo;
import com.example.SpringBootP3.repository.sale.ITrim;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/image")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ImageUploadRestController {

    private final IRawMaterialRepo rawMaterialRepo;



}
