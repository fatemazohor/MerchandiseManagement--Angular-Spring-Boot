package com.example.SpringBootP3.RestController.saleRest;

import com.example.SpringBootP3.model.UOM;
import com.example.SpringBootP3.model.Vendors;
import com.example.SpringBootP3.model.bom.Department;
import com.example.SpringBootP3.model.bom.LaborCost;
import com.example.SpringBootP3.model.sale.*;
import com.example.SpringBootP3.repository.bom.IDepartmentRepo;
import com.example.SpringBootP3.repository.bom.ILaborCost;
import com.example.SpringBootP3.repository.other.IUOMRepo;
import com.example.SpringBootP3.repository.other.IVendorRepo;
import com.example.SpringBootP3.repository.sale.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
@CrossOrigin("*")
@RequiredArgsConstructor
public class SaleRestController {

    private final IStyleCategories styleCatApiRepo;
    private final ISizeRepo iSizeRepo;
    private final ITrim trimRepo;
    private final IFabricName fabricRepo;
    private final IRawMaterialCat materialCatRepo;
    private final IStyle styleRepo;
    private final IMeasurementDetailsRepo detailsRepo;
    private final IRawMaterialRepo rawMaterialRepo;
    private final IVendorRepo vendorRepo;
    private final IUOMRepo iuomRepo;
    private final IDepartmentRepo departmentRepo;
    private final ILaborCost costRepo;

//    public SaleRestController(IMeasurementDetailsRepo detailsRepo, IStyleCategories styleCatApiRepo, ISizeRepo iSizeRepo, ITrim trimRepo, IFabricName fabricRepo, IRawMaterialCat materialCatRepo, IStyle styleRepo, IRawMaterialRepo rawMaterialRepo, IVendorRepo vendorRepo, ILaborCost costRepo, IUOMRepo iuomRepo, IDepartmentRepo departmentRepo) {
//        this.detailsRepo = detailsRepo;
//        this.styleCatApiRepo = styleCatApiRepo;
//        this.iSizeRepo = iSizeRepo;
//        this.trimRepo = trimRepo;
//        this.fabricRepo = fabricRepo;
//        this.materialCatRepo = materialCatRepo;
//        this.styleRepo = styleRepo;
//        this.rawMaterialRepo = rawMaterialRepo;
//        this.vendorRepo = vendorRepo;
//        this.costRepo = costRepo;
//        this.iuomRepo = iuomRepo;
//        this.departmentRepo = departmentRepo;
//    }


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
//        boolean exist=styleCatApiRepo.existsById(id);
        boolean exist=styleCatApiRepo.findById(id).isPresent();
        if (exist) {
//            if(styleCatApiRepo.findById(id).isPresent()){
//                StyleCategories categories=styleCatApiRepo.findById(id).get();
//                categories.setName(styleCategories.getName());
//                styleCatApiRepo.save(categories);
//                return ResponseEntity.ok(categories);
//            }

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
        boolean exist=iSizeRepo.findById(id).isPresent();
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
        boolean exist=trimRepo.findById(id).isPresent();
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
        boolean exist=fabricRepo.findById(id).isPresent();
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
        String categoryName=style.categoriesId.getName();
        StyleCategories category=styleCatApiRepo.findByName(categoryName);
        style.setCategoriesId(category);
        styleRepo.save(style);
        return ResponseEntity.ok(style);

    }

//    @PutMapping("/style/{id}")
//    public void styleUpdate(@RequestBody Style style,
//                                           @PathVariable("id") int id){
//        boolean exist=styleRepo.existsById(id);
//        if (exist) {
//
//            Style style1=styleRepo.findById(id).get();
//            style1.setCode(style.getCode());
//            style1.setDescription(style.getDescription());
//
//            style category
//            String categoryName=style.categoriesId.getName();
//            int categoryId=style.categoriesId.getId();
//
//            StyleCategories category=styleCatApiRepo.findByName(categoryName);
//            StyleCategories category2=styleCatApiRepo.findById(categoryId).get();
//            style1.setCategoriesId(category);
//
//            styleRepo.save(style1);
//            return ResponseEntity.ok(style1);
//        }
//        return ResponseEntity.notFound().build();
//    }



    @PutMapping("/style/{id}")
    public ResponseEntity<Style> styleUpdate(@RequestBody Style style,
                                           @PathVariable("id") int id){
        boolean exist=styleRepo.existsById(id);
        if (exist) {

            Style style1=styleRepo.findById(id).get();
            style1.setCode(style.getCode());
            style1.setDescription(style.getDescription());

            //style category
            String categoryName=style.categoriesId.getName();
            StyleCategories category=styleCatApiRepo.findByName(categoryName);
            style1.setCategoriesId(category);

            styleRepo.save(style1);
            return ResponseEntity.ok(style1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Style end
    // api Measurement Details start

    @GetMapping("/measurement_details")
    private List<MeasurementDetails> measurementDetailsList(){
        return detailsRepo.findAll();
    }


    @DeleteMapping("/measurement_details/{id}")
    public void deleteMeasurementDetails(@PathVariable("id")int id){
        boolean exist=detailsRepo.existsById(id);
        if (exist){
            detailsRepo.deleteById(id);
        }
    }
    @PostMapping("/measurement_details")
    public ResponseEntity<MeasurementDetails> mdetailsSave(@RequestBody MeasurementDetails details){
        String styleCode=details.getStyleId().getCode();
        Style code=styleRepo.findByCode(styleCode);
        details.setStyleId(code);
        detailsRepo.save(details);
        return ResponseEntity.ok(details);
    }
    @PutMapping("/measurement_details/{id}")
    public ResponseEntity<MeasurementDetails> mDetailsUpdate(@RequestBody MeasurementDetails details,
                                                             @PathVariable("id") int id){
        boolean exist=detailsRepo.existsById(id);
        if (exist){
            MeasurementDetails measurementDetails=detailsRepo.findById(id).get();
            measurementDetails.setDescription(details.getDescription());
            measurementDetails.setTolerance(details.getTolerance());
            measurementDetails.setSmall(details.getSmall());
            measurementDetails.setMedium(details.getMedium());
            measurementDetails.setLarge(details.getLarge());
            //style code set
            String styleCode=details.getStyleId().getCode();
            Style code=styleRepo.findByCode(styleCode);
            measurementDetails.setStyleId(code);
            detailsRepo.save(measurementDetails);
            return ResponseEntity.ok(measurementDetails);
        }
        return ResponseEntity.notFound().build();
    }

    // api Measurement Details end
    // api Measurement Attachment start
    // api Raw Material start

    @GetMapping("/raw_material")
    private List<RawMaterial> rawMaterialsList(){
        return rawMaterialRepo.findAll();
    }


    @DeleteMapping("/raw_material/{id}")
    public void deleteRawMaterial(@PathVariable("id")int id){
        boolean exist=rawMaterialRepo.existsById(id);
        if (exist){
            rawMaterialRepo.deleteById(id);
        }
    }

    // api Raw Material end
    // api Raw Material Attachment start
    // api Style Attachment start
    // api Style Material Quantity start






//---------------------------------------- Inventory Table-------------------------------
  // api Warehouse start
  // api Purchase Status start
    // api Stock Adjustment start
  // api Adjustment Material start
  // api Purchase start
  // api Stock start

//---------------------------------------- Other Table-----------------------------------
    // api Vendors start

    @GetMapping("/vendors")
    private List<Vendors> vendorsList(){
        return vendorRepo.findAll();
    }

    @DeleteMapping("/vendors/{id}")
    public void deleteVendor(@PathVariable("id")int id){
        boolean exist=vendorRepo.existsById(id);
        if (exist){
            vendorRepo.deleteById(id);
        }
    }
    @PostMapping("/vendors")
    public ResponseEntity<Vendors> vendorsSave(@RequestBody Vendors vendors){
        vendorRepo.save(vendors);
        return ResponseEntity.ok(vendors);
    }
    @PutMapping("/vendors/{id}")
    public ResponseEntity<Vendors> vendorsUpdate(@RequestBody Vendors vendors,@PathVariable("id")int id){
        boolean exist=vendorRepo.existsById(id);
        if(exist){
            Vendors vendors1=vendorRepo.findById(id).get();
            vendors1.setCompany(vendors.getCompany());
            vendors1.setContactPerson(vendors.getContactPerson());
            vendors1.setCell(vendors.getCell());
            vendors1.setEmail(vendors.getEmail());
            vendors1.setAddress(vendors.getAddress());
            vendorRepo.save(vendors1);
            return ResponseEntity.ok(vendors1);
        }
        return ResponseEntity.notFound().build();
    }


    // api Vendors end
    // api Unit of Measurement start

    @GetMapping("/uom")
    private List<UOM> uomList(){
        return iuomRepo.findAll();
    }

    @DeleteMapping("/uom/{id}")
    public void deleteUom(@PathVariable("id")int id){
        boolean exist=iuomRepo.existsById(id);
        if (exist){
            iuomRepo.deleteById(id);
        }
    }
    @PostMapping("/uom")
    public ResponseEntity<UOM> uomSave(@RequestBody UOM uom){
        iuomRepo.save(uom);
        return ResponseEntity.ok(uom);
    }
    @PutMapping("/uom/{id}")
    public ResponseEntity<UOM> uomUpdate(@RequestBody UOM uom,@PathVariable("id")int id){
        boolean exist=iuomRepo.existsById(id);
        if(exist){
            UOM uom1=iuomRepo.findById(id).get();
            uom1.setName(uom.getName());


            iuomRepo.save(uom1);
            return ResponseEntity.ok(uom1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Unit of Measurement end
//---------------------------------------- BOM Table----------------------------------
    // api Department start

    @GetMapping("/department")
    private List<Department> departmentsList(){
        return departmentRepo.findAll();
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartments(@PathVariable("id")int id){
        boolean exist=departmentRepo.existsById(id);
        if (exist){
            departmentRepo.deleteById(id);
        }
    }
    @PostMapping("/department")
    public ResponseEntity<Department> departmentSave(@RequestBody Department department){
        departmentRepo.save(department);
        return ResponseEntity.ok(department);
    }
    @PutMapping("/department/{id}")
    public ResponseEntity<Department> departmentUpdate(@RequestBody Department department,@PathVariable("id")int id){
        boolean exist=departmentRepo.existsById(id);
        if(exist){
            Department department1=departmentRepo.findById(id).get();
            department1.setName(department.getName());

            departmentRepo.save(department1);
            return ResponseEntity.ok(department1);
        }
        return ResponseEntity.notFound().build();
    }
    // api Department end
    // api Labor Cost start
    @GetMapping("/labor_cost")
    private List<LaborCost> laborCostList(){
        return costRepo.findAll();
    }

    @DeleteMapping("/labor_cost/{id}")
    public void deleteLaborCost(@PathVariable("id")int id){
        boolean exist=costRepo.existsById(id);
        if (exist){
            costRepo.deleteById(id);
        }
    }

    @PostMapping("/labor_cost")
    public ResponseEntity<LaborCost> laborCostSave(@RequestBody LaborCost cost){
        // department set
        String dept=cost.getDepartmentId().getName();
        Department department=departmentRepo.findByName(dept);
        cost.setDepartmentId(department);
        //style code set
        String styleCode=cost.getStyleId().getCode();
        Style code=styleRepo.findByCode(styleCode);
        cost.setStyleId(code);
        costRepo.save(cost);
        return ResponseEntity.ok(cost);
    }
    @PutMapping("/labor_cost/{id}")
    public ResponseEntity<LaborCost> departmentUpdate(@RequestBody LaborCost cost,@PathVariable("id")int id){
        boolean exist=costRepo.existsById(id);
        if(exist){
            LaborCost cost1=costRepo.findById(id).get();
            cost1.setUnitCost(cost.getUnitCost());
            cost1.setHour(cost.getHour());
            // department set
            String dept=cost.getDepartmentId().getName();
            Department department=departmentRepo.findByName(dept);
            cost1.setDepartmentId(department);
            //style code set
            String styleCode=cost.getStyleId().getCode();
            Style code=styleRepo.findByCode(styleCode);
            cost1.setStyleId(code);
            costRepo.save(cost1);
            return ResponseEntity.ok(cost1);
        }
        return ResponseEntity.notFound().build();
    }
    // api Labor Cost end
//---------------------------------------- Buyers Table----------------------------------
    // api Buyers start
    // api Task start
    // api Orders Status start
    // api Orders start
    // api Time Action start
//---------------------------------------- Report Table----------------------------------
    }
