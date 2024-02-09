package com.example.SpringBootP3.RestController.saleRest;

import com.example.SpringBootP3.model.sale.*;
import com.example.SpringBootP3.repository.sale.*;
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
    @Autowired
    private ITrim trimRepo;
    @Autowired
    private IFabricName fabricRepo;
    @Autowired
    private IRawMaterialCat materialCatRepo;
    @Autowired
    private IStyle styleRepo;



    //    swagger link: http://localhost:8098/swagger-ui/index.html#/

//----------------------- Sale independent Table----------------------
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
    public ResponseEntity<StyleCategories> styleCatUpdate(@RequestBody StyleCategories styleCategories,
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
    public ResponseEntity<Size> sizeUpdate(@RequestBody Size size,
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
    //    api Trim start

    @GetMapping("/trim")
    private List<Trim> trimList(){
        return trimRepo.findAll();
    }

    @DeleteMapping("/trim/{id}")
    public void deleteTrim(@PathVariable("id")int id){
        boolean exist= trimRepo.existsById(id);
        if (exist){
            trimRepo.deleteById(id);

        }
    }

    @PostMapping("/trim")
    public ResponseEntity<Trim> trimSave(@RequestBody Trim trim){
        trimRepo.save(trim);
        return ResponseEntity.ok(trim);

    }

    @PutMapping("/trim/{id}")
    public ResponseEntity<Trim> trimUpdate(@RequestBody Trim trim,
                                           @PathVariable("id") int id){
        boolean exist=trimRepo.existsById(id);
        if (exist) {

            Trim trim1=trimRepo.findById(id).get();
            trim1.setName(trim.getName());
            trimRepo.save(trim1);
            return ResponseEntity.ok(trim1);
        }
        return ResponseEntity.notFound().build();
    }

    //    api Trim end
    //    api Fabric start (optional)

    @GetMapping("/fabric")
    private List<Fabric> fabricList(){
        return fabricRepo.findAll();
    }

    @DeleteMapping("/fabric/{id}")
    public void deleteFabric(@PathVariable("id")int id){
        boolean exist= fabricRepo.existsById(id);
        if (exist){
            fabricRepo.deleteById(id);

        }
    }

    @PostMapping("/fabric")
    public ResponseEntity<Fabric> fabricSave(@RequestBody Fabric fabric){
        fabricRepo.save(fabric);
        return ResponseEntity.ok(fabric);

    }

    @PutMapping("/fabric/{id}")
    public ResponseEntity<Fabric> fabricUpdate(@RequestBody Fabric fabric,
                                           @PathVariable("id") int id){
        boolean exist=fabricRepo.existsById(id);
        if (exist) {

            Fabric fabric1=fabricRepo.findById(id).get();
            fabric1.setName(fabric.getName());
            fabric1.setDescription(fabric.getDescription());
//            fabric1.setAttachment(fabric.getAttachment());
            fabricRepo.save(fabric1);
            return ResponseEntity.ok(fabric1);
        }
        return ResponseEntity.notFound().build();
    }

    //    api Fabric end
    //    api Raw Material Categories start

    @GetMapping("/raw_material_cate")
    private List<RawMaterialCat> rawMaterialCateList(){
        return materialCatRepo.findAll();
    }

    @DeleteMapping("/raw_material_cate/{id}")
    public void deleteRawMaterialCate(@PathVariable("id")int id){
        boolean exist= materialCatRepo.existsById(id);
        if (exist){
            materialCatRepo.deleteById(id);

        }
    }

    @PostMapping("/raw_material_cate")
    public ResponseEntity<RawMaterialCat> rawMaterialCateSave(@RequestBody RawMaterialCat materialCat){
        materialCatRepo.save(materialCat);
        return ResponseEntity.ok(materialCat);

    }

    @PutMapping("/raw_material_cate/{id}")
    public ResponseEntity<RawMaterialCat> rawMaterialCateUpdate(@RequestBody RawMaterialCat materialCat,
                                           @PathVariable("id") int id){
        boolean exist=materialCatRepo.existsById(id);
        if (exist) {

            RawMaterialCat materialCat1=materialCatRepo.findById(id).get();
            materialCat1.setName(materialCat.getName());
            materialCatRepo.save(materialCat1);
            return ResponseEntity.ok(materialCat1);
        }
        return ResponseEntity.notFound().build();
    }

    //    api Raw Material Categories end
//---------------------------------------- Sale independent Table end------------------------
//---------------------------------------- Sale dependent Table--------------------------
    // api Style start

    @GetMapping("/style")
    private List<Style> styleList(){
        return styleRepo.findAll();
    }

    @DeleteMapping("/style/{id}")
    public void deleteStyle(@PathVariable("id")int id){
        boolean exist= styleRepo.existsById(id);
        if (exist){
            styleRepo.deleteById(id);

        }
    }

    @PostMapping("/style")
    public ResponseEntity<Style> styleSave(@RequestBody Style style){
        styleRepo.save(style);
        return ResponseEntity.ok(style);

    }

    @PutMapping("/style/{id}")
    public ResponseEntity<Style> styleUpdate(@RequestBody Style style,
                                           @PathVariable("id") int id){
        boolean exist=styleRepo.existsById(id);
        if (exist) {

            Style style1=styleRepo.findById(id).get();
            style1.setCode(style.getCode());
            //style category

            styleRepo.save(style1);
            return ResponseEntity.ok(style1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Style end




//---------------------------------------- Inventory Table-------------------------------
//---------------------------------------- Other Table-----------------------------------
//---------------------------------------- Report Table----------------------------------
    }
