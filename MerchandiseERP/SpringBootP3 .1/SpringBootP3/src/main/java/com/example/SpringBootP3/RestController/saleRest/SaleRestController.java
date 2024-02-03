package com.example.SpringBootP3.RestController.saleRest;

import com.example.SpringBootP3.model.sale.Size;
import com.example.SpringBootP3.model.sale.Style;
import com.example.SpringBootP3.model.sale.StyleCategories;
import com.example.SpringBootP3.repository.sale.ISizeRepo;
import com.example.SpringBootP3.repository.sale.IStyleCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
@CrossOrigin("*")
public class SaleRestController {

    @Autowired
    private IStyleCategories styleCatApiRepo;
    @Autowired
    private ISizeRepo iSizeRepo;




    //    swagger link: http://localhost:8098/swagger-ui/index.html#/

    //    api StyleCategories start

    @GetMapping("/style-categories")
    private List<StyleCategories> styleCategoriesList(){
        return styleCatApiRepo.findAll();
    }

    @DeleteMapping("/style-categories/{id}")
    public void deleteStyleCate(@PathVariable("id")int id){
        boolean exist=styleCatApiRepo.existsById(id);
        if (exist){
            styleCatApiRepo.deleteById(id);

        }
    }

    @PostMapping("/style-categories")
    public ResponseEntity<StyleCategories> styleCatSave(@RequestBody StyleCategories styleCategories){
        styleCatApiRepo.save(styleCategories);
        return ResponseEntity.ok(styleCategories);

    }

    @PutMapping("/style-categories/{id}")
    public ResponseEntity<StyleCategories> styleCatupdate(@RequestBody StyleCategories styleCategories,
                                                          @PathVariable("id") int id){
        boolean exist=styleCatApiRepo.existsById(id);
        if (exist) {

            StyleCategories categories=styleCatApiRepo.findById(id).get();
            categories.setName(styleCategories.getName());
            styleCatApiRepo.save(categories);
            return ResponseEntity.ok(categories);
        }
        return ResponseEntity.notFound().build();
    }

    //    api StyleCategories end
    //    api Size start

    @GetMapping("/size")
    private List<Size> sizeList(){
        return iSizeRepo.findAll();
    }

    @DeleteMapping("/size/{id}")
    public void deleteSize(@PathVariable("id")int id){
        boolean exist= iSizeRepo.existsById(id);
        if (exist){
            iSizeRepo.deleteById(id);

        }
    }

    @PostMapping("/size")
    public ResponseEntity<Size> sizeSave(@RequestBody Size size){
        iSizeRepo.save(size);
        return ResponseEntity.ok(size);

    }

    @PutMapping("/size/{id}")
    public ResponseEntity<Size> sizeupdate(@RequestBody Size size,
                                                          @PathVariable("id") int id){
        boolean exist=iSizeRepo.existsById(id);
        if (exist) {

            Size size1=iSizeRepo.findById(id).get();
            size1.setName(size.getName());
            iSizeRepo.save(size1);
            return ResponseEntity.ok(size1);
        }
        return ResponseEntity.notFound().build();
    }

    //    api Size end

    }





