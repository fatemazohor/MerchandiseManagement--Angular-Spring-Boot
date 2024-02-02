package com.example.SpringBootP3.RestController.saleRest;

import com.example.SpringBootP3.model.sale.StyleCategories;
import com.example.SpringBootP3.repository.sale.IStyleCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SaleRestController {

    @Autowired
    private IStyleCategories styleCatApiRepo;




    //    swagger link: http://localhost:8098/swagger-ui/index.html#/

    //    api StyleCategories start

    @GetMapping("/style-categories")
    private List<StyleCategories> styleCategoriesList(){
        return styleCatApiRepo.findAll();
    }

    @DeleteMapping("/style-categories/{id}")
    public void deleteBook(@PathVariable("id")int id){
        boolean exist=styleCatApiRepo.existsById(id);
        if (exist){
            styleCatApiRepo.deleteById(id);

        }
    }



    //    api StyleCategories end
}
