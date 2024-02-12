package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.StyleCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStyleCategories extends JpaRepository<StyleCategories,Integer> {
    StyleCategories findByName(String name);


//    @Query("select s from StyleCategories s where s.id=:id")
//    StyleCategories findByCatId(int id);
}
