package com.example.SpringBootP3.RestController.saleRest;

import com.example.SpringBootP3.model.UOM;
import com.example.SpringBootP3.model.Vendors;
import com.example.SpringBootP3.model.bom.Department;
import com.example.SpringBootP3.model.bom.LaborCost;
import com.example.SpringBootP3.model.buyer.*;
import com.example.SpringBootP3.model.inventory.*;
import com.example.SpringBootP3.model.sale.*;
import com.example.SpringBootP3.repository.bom.IDepartmentRepo;
import com.example.SpringBootP3.repository.bom.ILaborCost;
import com.example.SpringBootP3.repository.buyer.*;
import com.example.SpringBootP3.repository.inventory.*;
import com.example.SpringBootP3.repository.other.IUOMRepo;
import com.example.SpringBootP3.repository.other.IVendorRepo;
import com.example.SpringBootP3.repository.sale.*;
import com.example.SpringBootP3.service.Stock.StockUpdateService;
import com.example.SpringBootP3.service.dashboard.OrderPurchaseRevenueService;
import com.example.SpringBootP3.service.techPack.BillOfMaterialService;
import com.example.SpringBootP3.service.techPack.TechPackService;
import com.example.SpringBootP3.service.techPack.TimeActionService;
import lombok.RequiredArgsConstructor;

import org.hibernate.query.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

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
    private final IWareHouse houseRepo;
    private final IPurchaseStatus purchaseStatusRepo;
    private final IStockAdjustment stockAdjustmentRepo;
    private final IBuyerRepo buyerRepo;
    private final ITask taskRepo;
    private final IOrderStatus statusRepo;
    private final IOrderDetails orderDetailsRepo;
    private final IMeasurementAttachmentRepo measurementAttachmentRepo;
    private final IStyleAttachmentRepo styleAttachmentRepo;
    private final IPurchase purchaseRepo;
    private final StockUpdateService stockUpdateService;

    private final IAdjustmentMaterial adjustmentMaterialRepo;
    private final IStock stockRepo;
    private final IStyleMaterialQuantityRepo styleMaterialQuantityRepo;
    private final ITimeActionRepo timeActionRepo;
    private final BillOfMaterialService billOfMaterialService;
    private final TechPackService packService;
    private final TimeActionService actionService;
    private final OrderPurchaseRevenueService revenueService;

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

//----------------------- Sale independent Table---------------------------------
    //    api StyleCategories start

    @GetMapping("/style-categories")
    private List<StyleCategories> styleCategoriesList() {
        return styleCatApiRepo.findAll();
    }

    @DeleteMapping("/style-categories/{id}")
    public void deleteStyleCate(@PathVariable("id") int id) {
        boolean exist = styleCatApiRepo.existsById(id);
        if (exist) {
            styleCatApiRepo.deleteById(id);

        }
    }

    @PostMapping("/style-categories")
    public ResponseEntity<StyleCategories> styleCatSave(@RequestBody StyleCategories styleCategories) {
        styleCatApiRepo.save(styleCategories);
        return ResponseEntity.ok(styleCategories);

    }

    @PutMapping("/style-categories/{id}")
    public ResponseEntity<StyleCategories> styleCatUpdate(@RequestBody StyleCategories styleCategories,
                                                          @PathVariable("id") int id) {
//        boolean exist=styleCatApiRepo.existsById(id);
        boolean exist = styleCatApiRepo.findById(id).isPresent();
        if (exist) {
//            if(styleCatApiRepo.findById(id).isPresent()){
//                StyleCategories categories=styleCatApiRepo.findById(id).get();
//                categories.setName(styleCategories.getName());
//                styleCatApiRepo.save(categories);
//                return ResponseEntity.ok(categories);
//            }

            StyleCategories categories = styleCatApiRepo.findById(id).get();
            categories.setName(styleCategories.getName());
            styleCatApiRepo.save(categories);
            return ResponseEntity.ok(categories);
        }
        return ResponseEntity.notFound().build();
    }

    //    api StyleCategories end
    //    api Size start

    @GetMapping("/size")
    private List<Size> sizeList() {
        return iSizeRepo.findAll();
    }

    @DeleteMapping("/size/{id}")
    public void deleteSize(@PathVariable("id") int id) {
        boolean exist = iSizeRepo.existsById(id);
        if (exist) {
            iSizeRepo.deleteById(id);

        }
    }

    @PostMapping("/size")
    public ResponseEntity<Size> sizeSave(@RequestBody Size size) {
        iSizeRepo.save(size);
        return ResponseEntity.ok(size);

    }

    @PutMapping("/size/{id}")
    public ResponseEntity<Size> sizeUpdate(@RequestBody Size size,
                                           @PathVariable("id") int id) {
        boolean exist = iSizeRepo.findById(id).isPresent();
        if (exist) {

            Size size1 = iSizeRepo.findById(id).get();
            size1.setName(size.getName());
            iSizeRepo.save(size1);
            return ResponseEntity.ok(size1);
        }
        return ResponseEntity.notFound().build();
    }

    //    api Size end
    //    api Trim start

    @GetMapping("/trim")
    private List<Trim> trimList() {
        return trimRepo.findAll();
    }

    @DeleteMapping("/trim/{id}")
    public void deleteTrim(@PathVariable("id") int id) {
        boolean exist = trimRepo.existsById(id);
        if (exist) {
            trimRepo.deleteById(id);

        }
    }

    @PostMapping("/trim")
    public ResponseEntity<Trim> trimSave(@RequestBody Trim trim) {
        trimRepo.save(trim);
        return ResponseEntity.ok(trim);

    }

    @PutMapping("/trim/{id}")
    public ResponseEntity<Trim> trimUpdate(@RequestBody Trim trim,
                                           @PathVariable("id") int id) {
        boolean exist = trimRepo.findById(id).isPresent();
        if (exist) {

            Trim trim1 = trimRepo.findById(id).get();
            trim1.setName(trim.getName());
            trimRepo.save(trim1);
            return ResponseEntity.ok(trim1);
        }
        return ResponseEntity.notFound().build();
    }

    //    api Trim end
    //    api Fabric start (optional)

    @GetMapping("/fabric")
    private List<Fabric> fabricList() {
        return fabricRepo.findAll();
    }

    @DeleteMapping("/fabric/{id}")
    public void deleteFabric(@PathVariable("id") int id) {
        boolean exist = fabricRepo.existsById(id);
        if (exist) {
            fabricRepo.deleteById(id);

        }
    }

    @PostMapping("/fabric")
    public ResponseEntity<Fabric> fabricSave(@RequestBody Fabric fabric) {
        fabricRepo.save(fabric);
        return ResponseEntity.ok(fabric);

    }

    @PutMapping("/fabric/{id}")
    public ResponseEntity<Fabric> fabricUpdate(@RequestBody Fabric fabric,
                                               @PathVariable("id") int id) {
        boolean exist = fabricRepo.findById(id).isPresent();
        if (exist) {

            Fabric fabric1 = fabricRepo.findById(id).get();
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
    private List<RawMaterialCat> rawMaterialCateList() {
        return materialCatRepo.findAll();
    }

    @DeleteMapping("/raw_material_cate/{id}")
    public void deleteRawMaterialCate(@PathVariable("id") int id) {
        boolean exist = materialCatRepo.existsById(id);
        if (exist) {
            materialCatRepo.deleteById(id);

        }
    }

    @PostMapping("/raw_material_cate")
    public ResponseEntity<RawMaterialCat> rawMaterialCateSave(@RequestBody RawMaterialCat materialCat) {
        materialCatRepo.save(materialCat);
        return ResponseEntity.ok(materialCat);

    }

    @PutMapping("/raw_material_cate/{id}")
    public ResponseEntity<RawMaterialCat> rawMaterialCateUpdate(@RequestBody RawMaterialCat materialCat,
                                                                @PathVariable("id") int id) {
        boolean exist = materialCatRepo.findById(id).isPresent();
        if (exist) {

            RawMaterialCat materialCat1 = materialCatRepo.findById(id).get();
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
    private List<Style> styleList() {
        return styleRepo.findAll();
    }

    @GetMapping("/style/{id}")
    private ResponseEntity<Style> styleById(@PathVariable("id") int id) {
        boolean exist = styleRepo.findById(id).isPresent();
        if (exist) {
            Style st = styleRepo.findById(id).get();
            return ResponseEntity.ok(st);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/style/{id}")
    public void deleteStyle(@PathVariable("id") int id) {
        boolean exist = styleRepo.existsById(id);
        if (exist) {
            styleRepo.deleteById(id);

        }
    }

    @PostMapping("/style")
    public ResponseEntity<Style> styleSave(@RequestBody Style style) {
        String categoryName = style.categoriesId.getName();
        StyleCategories category = styleCatApiRepo.findByName(categoryName);
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
                                             @PathVariable("id") int id) {
        boolean exist = styleRepo.findById(id).isPresent();
        if (exist) {

            Style style1 = styleRepo.findById(id).get();
            style1.setCode(style.getCode());
            style1.setDescription(style.getDescription());

            //style category
            String categoryName = style.categoriesId.getName();
            StyleCategories category = styleCatApiRepo.findByName(categoryName);
            style1.setCategoriesId(category);

            styleRepo.save(style1);
            return ResponseEntity.ok(style1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Style end
    // api Style Attachment start
    @GetMapping("/style_attachment")
    private List<StyleAttachment> styleAttachmentList() {
        return styleAttachmentRepo.findAll();
    }

    //style image display display image
    @GetMapping("/style_attachment/display")
    public ResponseEntity<byte[]> getStyleAttachment(@RequestParam("id") int id)
            throws IOException {
        Optional<StyleAttachment> styleAttachment = styleAttachmentRepo.findById(id);
        if (styleAttachment.isPresent()) {
            StyleAttachment styleImage = styleAttachment.get();
            //select directory
            String uploadDirectory = "src/main/resources/static/assets/image/style_att/";
            String fileName = styleImage.getAttachment();
            String filePath = Path.of(uploadDirectory, fileName).toString();
            try {
                Path path = Path.of(filePath);
                byte[] imageByte = Files.readAllBytes(path);
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline + filename="
                                + path.getFileName().toString())
                        .body(imageByte);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }

        }
        return ResponseEntity.notFound().build();
    }
    //style image display end

    @DeleteMapping("/style_attachment/{id}")
    public void deletestyleAttachment(@PathVariable("id") int id) {
        boolean exist = styleAttachmentRepo.existsById(id);
        if (exist) {
            styleAttachmentRepo.deleteById(id);
        }
    }

    @PostMapping("/style_attachment")
    public ResponseEntity<StyleAttachment> styleAttachmentSave(@RequestBody StyleAttachment attachment) {
        String styleCode = attachment.getStyleId().getCode();
        Style code = styleRepo.findByCode(styleCode);
        attachment.setStyleId(code);
        styleAttachmentRepo.save(attachment);
        return ResponseEntity.ok(attachment);
    }

    @PutMapping("/style_attachment/{id}")
    public ResponseEntity<StyleAttachment> styleAttachmentUpdate(@RequestBody StyleAttachment attachment,
                                                                 @PathVariable("id") int id) {
        boolean exist = styleAttachmentRepo.findById(id).isPresent();
        if (exist) {

            StyleAttachment attachment1 = styleAttachmentRepo.findById(id).get();


            //style code set
            String styleCode = attachment.getStyleId().getCode();
            Style code = styleRepo.findByCode(styleCode);
            attachment1.setStyleId(code);


            styleAttachmentRepo.save(attachment1);
            return ResponseEntity.ok(attachment1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Measurement Details start

    @GetMapping("/measurement_details")
    private List<MeasurementDetails> measurementDetailsList() {
        return detailsRepo.findAll();
    }


    @DeleteMapping("/measurement_details/{id}")
    public void deleteMeasurementDetails(@PathVariable("id") int id) {
        boolean exist = detailsRepo.existsById(id);
        if (exist) {
            detailsRepo.deleteById(id);
        }
    }

    @PostMapping("/measurement_details")
    public ResponseEntity<MeasurementDetails> mdetailsSave(@RequestBody MeasurementDetails details) {
        String styleCode = details.getStyleId().getCode();
        Style code = styleRepo.findByCode(styleCode);
        details.setStyleId(code);
        detailsRepo.save(details);
        return ResponseEntity.ok(details);
    }

    @PutMapping("/measurement_details/{id}")
    public ResponseEntity<MeasurementDetails> mDetailsUpdate(@RequestBody MeasurementDetails details,
                                                             @PathVariable("id") int id) {
        boolean exist = detailsRepo.findById(id).isPresent();
        if (exist) {
            MeasurementDetails measurementDetails = detailsRepo.findById(id).get();
            measurementDetails.setDescription(details.getDescription());
            measurementDetails.setTolerance(details.getTolerance());
            measurementDetails.setSmall(details.getSmall());
            measurementDetails.setMedium(details.getMedium());
            measurementDetails.setLarge(details.getLarge());
            //style code set
            String styleCode = details.getStyleId().getCode();
            Style code = styleRepo.findByCode(styleCode);
            measurementDetails.setStyleId(code);
            detailsRepo.save(measurementDetails);
            return ResponseEntity.ok(measurementDetails);
        }
        return ResponseEntity.notFound().build();
    }

    // api Measurement Details end
    // api Measurement Attachment start
    @GetMapping("/measurement_attachment")
    private List<MeasurementAttachment> mAttachmentList() {
        return measurementAttachmentRepo.findAll();
    }


    //measurement attachment display image
    @GetMapping("/measurement_attachment/display")
    public ResponseEntity<byte[]> getMeasurementAttachment(@RequestParam("id") int id)
            throws IOException {
        Optional<MeasurementAttachment> mattachment = measurementAttachmentRepo.findById(id);
        if (mattachment.isPresent()) {
            MeasurementAttachment attachmentImage = mattachment.get();
            //select directory
            String uploadDirectory = "src/main/resources/static/assets/image/measurement_att/";
            String fileName = attachmentImage.getAttachment();
            String filePath = Path.of(uploadDirectory, fileName).toString();
            try {
                Path path = Path.of(filePath);
                byte[] imageByte = Files.readAllBytes(path);
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline + filename="
                                + path.getFileName().toString())
                        .body(imageByte);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/measurement_attachment/{id}")
    public void deletemeasurementAttachment(@PathVariable("id") int id) {
        boolean exist = measurementAttachmentRepo.existsById(id);
        if (exist) {
            measurementAttachmentRepo.deleteById(id);
        }
    }

    @PostMapping("/measurement_attachment")
    public ResponseEntity<MeasurementAttachment> measurementAttachmentSave(@RequestBody MeasurementAttachment attachment) {

        //style code set
        String styleCode = attachment.getStyleId().getCode();
        Style code = styleRepo.findByCode(styleCode);
        attachment.setStyleId(code);


        measurementAttachmentRepo.save(attachment);
        return ResponseEntity.ok(attachment);
    }

    @PutMapping("/measurement_attachment/{id}")
    public ResponseEntity<MeasurementAttachment> measurementAttachmentUpdate(@RequestBody MeasurementAttachment attachment,
                                                                             @PathVariable("id") int id) {
        boolean exist = measurementAttachmentRepo.findById(id).isPresent();
        if (exist) {

            MeasurementAttachment attachment1 = measurementAttachmentRepo.findById(id).get();
            attachment1.setName(attachment.getName());


            //style code set
            String styleCode = attachment.getStyleId().getCode();
            Style code = styleRepo.findByCode(styleCode);
            attachment1.setStyleId(code);


            measurementAttachmentRepo.save(attachment1);
            return ResponseEntity.ok(attachment1);
        }
        return ResponseEntity.notFound().build();
    }


    // api Raw Material start

    @GetMapping("/raw_material")
    private List<RawMaterial> rawMaterialsList() {
        return rawMaterialRepo.findAll();
    }

    //raw material attachment display image
    @GetMapping("/raw_material/display")
    public ResponseEntity<byte[]> getRawMaterialAttachment(@RequestParam("id") int id)
            throws IOException {
        Optional<RawMaterial> rawAttachment = rawMaterialRepo.findById(id);
        if (rawAttachment.isPresent()) {
            RawMaterial rawImage = rawAttachment.get();
            //select directory
            String uploadDirectory = "src/main/resources/static/assets/image/material_att/";
            String fileName = rawImage.getAttachment();
            String filePath = Path.of(uploadDirectory, fileName).toString();
            try {
                Path path = Path.of(filePath);
                byte[] imageByte = Files.readAllBytes(path);
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline + filename="
                                + path.getFileName().toString())
                        .body(imageByte);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }

        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/raw_material/{id}")
    public void deleteRawMaterial(@PathVariable("id") int id) {
        boolean exist = rawMaterialRepo.existsById(id);
        if (exist) {
            rawMaterialRepo.deleteById(id);
        }
    }

    @PostMapping("/raw_material")
    public ResponseEntity<RawMaterial> RawMaterialSave(@RequestBody RawMaterial rawMaterial) {

        //style code set
        String styleCode = rawMaterial.getStyleId().getCode();
        Style code = styleRepo.findByCode(styleCode);
        rawMaterial.setStyleId(code);
        //raw material Category set
        String rawCategory = rawMaterial.getRawMaterialCatId().getName();
        RawMaterialCat category = materialCatRepo.findByName(rawCategory);
        rawMaterial.setRawMaterialCatId(category);
        //Vendor set
        String vendors = rawMaterial.getVendorId().getCompany();
        Vendors company = vendorRepo.findByCompany(vendors);
        rawMaterial.setVendorId(company);
        //UOM set
        String uom = rawMaterial.getUomId().getName();
        UOM uom1 = iuomRepo.findByName(uom);
        rawMaterial.setUomId(uom1);
        rawMaterialRepo.save(rawMaterial);
        return ResponseEntity.ok(rawMaterial);
    }

    @PutMapping("/raw_material/{id}")
    public ResponseEntity<RawMaterial> RawMaterialUpdate(@RequestBody RawMaterial rawMaterial, @PathVariable("id") int id) {
        boolean exist = rawMaterialRepo.findById(id).isPresent();
        if (exist) {
            RawMaterial rawMaterial1 = rawMaterialRepo.findById(id).get();
            rawMaterial1.setName(rawMaterial.getName());
            rawMaterial1.setDescription(rawMaterial.getDescription());
            rawMaterial1.setUnitPrice(rawMaterial.getUnitPrice());

            //style code set
            String styleCode = rawMaterial.getStyleId().getCode();
            Style code = styleRepo.findByCode(styleCode);
            rawMaterial1.setStyleId(code);
            //raw material Category set
            String rawCategory = rawMaterial.getRawMaterialCatId().getName();
            RawMaterialCat category = materialCatRepo.findByName(rawCategory);
            rawMaterial1.setRawMaterialCatId(category);
            //Vendor set
            String vendors = rawMaterial.getVendorId().getCompany();
            Vendors company = vendorRepo.findByCompany(vendors);
            rawMaterial1.setVendorId(company);
            //UOM set
            String uom = rawMaterial.getUomId().getName();
            UOM uom1 = iuomRepo.findByName(uom);
            rawMaterial1.setUomId(uom1);


            return ResponseEntity.ok(rawMaterial1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Raw Material end


    // api Style Material Quantity start

    @GetMapping("/style_material_qty")
    private List<StyleMaterialQuantity> styleMaterialList() {
        return styleMaterialQuantityRepo.findAll();
    }

    @DeleteMapping("/style_material_qty/{id}")
    public void deleteStyleMaterial(@PathVariable("id") int id) {
        boolean exist = styleMaterialQuantityRepo.existsById(id);
        if (exist) {
            styleMaterialQuantityRepo.deleteById(id);
        }
    }

    @PostMapping("/style_material_qty")
    public ResponseEntity<StyleMaterialQuantity> styleMaterialSave(@RequestBody StyleMaterialQuantity quantity) {

        //Raw material set
        String rawMaterial = quantity.getRawMaterialId().getName();
        RawMaterial mat = rawMaterialRepo.findByName(rawMaterial);
        quantity.setRawMaterialId(mat);
        //Size set
        String size = quantity.getSizeId().getName();
        Size size1 = iSizeRepo.findByName(size);
        quantity.setSizeId(size1);
        //style code set
        String styleCode = quantity.getStyleId().getCode();
        Style code = styleRepo.findByCode(styleCode);
        quantity.setStyleId(code);

        styleMaterialQuantityRepo.save(quantity);
        return ResponseEntity.ok(quantity);
    }

    @PutMapping("/style_material_qty/{id}")
    public ResponseEntity<StyleMaterialQuantity> styleMaterialUpdate(@RequestBody StyleMaterialQuantity quantity, @PathVariable("id") int id) {
        boolean exist = styleMaterialQuantityRepo.findById(id).isPresent();
        if (exist) {
            StyleMaterialQuantity quantity1 = styleMaterialQuantityRepo.findById(id).get();
            quantity1.setQuantity(quantity.getQuantity());

            //Raw material set
            String rawMaterial = quantity.getRawMaterialId().getName();
            RawMaterial mat = rawMaterialRepo.findByName(rawMaterial);
            quantity1.setRawMaterialId(mat);
            //Size set
            String size = quantity.getSizeId().getName();
            Size size1 = iSizeRepo.findByName(size);
            quantity1.setSizeId(size1);
            //style code set
            String styleCode = quantity.getStyleId().getCode();
            Style code = styleRepo.findByCode(styleCode);
            quantity1.setStyleId(code);

            styleMaterialQuantityRepo.save(quantity1);

            return ResponseEntity.ok(quantity1);
        }
        return ResponseEntity.notFound().build();
    }


    //---------------------------------------- Inventory Table-------------------------------
    // api Warehouse start
    @GetMapping("/warehouse")
    private List<WareHouse> warehouseList() {
        return houseRepo.findAll();
    }

    @DeleteMapping("/warehouse/{id}")
    public void deleteWarehouse(@PathVariable("id") int id) {
        boolean exist = houseRepo.existsById(id);
        if (exist) {
            houseRepo.deleteById(id);
        }
    }

    @PostMapping("/warehouse")
    public ResponseEntity<WareHouse> warehouseSave(@RequestBody WareHouse house) {
        houseRepo.save(house);
        return ResponseEntity.ok(house);
    }

    @PutMapping("/warehouse/{id}")
    public ResponseEntity<WareHouse> warehouseUpdate(@RequestBody WareHouse house, @PathVariable("id") int id) {
        boolean exist = houseRepo.findById(id).isPresent();
        if (exist) {
            WareHouse house1 = houseRepo.findById(id).get();
            house1.setName(house.getName());
            house1.setContact(house.getContact());
            house1.setCity(house.getCity());

            return ResponseEntity.ok(house1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Purchase Status start
    @GetMapping("/purchase_status")
    private List<PurchaseStatus> purchaseStatusList() {
        return purchaseStatusRepo.findAll();
    }

    @DeleteMapping("/purchase_status/{id}")
    public void deletePurchaseStatus(@PathVariable("id") int id) {
        boolean exist = purchaseStatusRepo.existsById(id);
        if (exist) {
            purchaseStatusRepo.deleteById(id);
        }
    }

    @PostMapping("/purchase_status")
    public ResponseEntity<PurchaseStatus> purchaseStatusSave(@RequestBody PurchaseStatus status) {
        purchaseStatusRepo.save(status);
        return ResponseEntity.ok(status);
    }

    @PutMapping("/purchase_status/{id}")
    public ResponseEntity<PurchaseStatus> purchaseStatusUpdate(@RequestBody PurchaseStatus status, @PathVariable("id") int id) {
        boolean exist = purchaseStatusRepo.findById(id).isPresent();
        if (exist) {
            PurchaseStatus status1 = purchaseStatusRepo.findById(id).get();
            status1.setName(status.getName());
            purchaseStatusRepo.save(status1);
            return ResponseEntity.ok(status1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Stock Adjustment start
    @GetMapping("/stock_adjustment")
    private List<StockAdjustment> stockAdjustmentsList() {
        return stockAdjustmentRepo.findAll();
    }

    @DeleteMapping("/stock_adjustment/{id}")
    public void deleteStockAdjustment(@PathVariable("id") int id) {
        boolean exist = stockAdjustmentRepo.existsById(id);
        if (exist) {
            stockAdjustmentRepo.deleteById(id);
        }
    }

    @PostMapping("/stock_adjustment")
    public ResponseEntity<StockAdjustment> stockAdjustmentSave(@RequestBody StockAdjustment stockAdjustment) {
        stockAdjustmentRepo.save(stockAdjustment);
        return ResponseEntity.ok(stockAdjustment);
    }

    @PutMapping("/stock_adjustment/{id}")
    public ResponseEntity<StockAdjustment> stockAdjustmentUpdate(@RequestBody StockAdjustment stockAdjustment, @PathVariable("id") int id) {
        boolean exist = stockAdjustmentRepo.findById(id).isPresent();
        if (exist) {
            StockAdjustment stockAdjustment1 = stockAdjustmentRepo.findById(id).get();
            stockAdjustment1.setName(stockAdjustment.getName());
            stockAdjustment1.setFactor(stockAdjustment.getFactor());

            stockAdjustmentRepo.save(stockAdjustment1);
            return ResponseEntity.ok(stockAdjustment1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Adjustment Material start
    @GetMapping("/adjustment_material")
    private List<AdjustmentMaterial> materialsAdjustmentsList() {
        return adjustmentMaterialRepo.findAll();
    }

    @DeleteMapping("/adjustment_material/{id}")
    public void deleteMaterialAdjustment(@PathVariable("id") int id) {
        boolean exist = adjustmentMaterialRepo.existsById(id);
        if (exist) {
            adjustmentMaterialRepo.deleteById(id);
        }
    }

    @PostMapping("/adjustment_material")
    public ResponseEntity<AdjustmentMaterial> materialAdjustmentSave(@RequestBody AdjustmentMaterial material) {

        //Raw material set
        String rawMaterial = material.getRawMaterialId().getName();
        RawMaterial mat = rawMaterialRepo.findByName(rawMaterial);
        material.setRawMaterialId(mat);

        //warehouse set
        String warehouse = material.getWareHouseId().getName();
        WareHouse house = houseRepo.findByName(warehouse);
        material.setWareHouseId(house);

        //Stock Adjustment set
        String stockStatus = material.getStockAdjustmentId().getName();
        StockAdjustment stockAdjustment = stockAdjustmentRepo.findByName(stockStatus);
        material.setStockAdjustmentId(stockAdjustment);

        //Order Details set
//        String order = String.valueOf(material.getOrderDetailsId().getId());
        if (material.getId() != null) {
            int orderId = material.getOrderDetailsId().getId();
            boolean exist1 = orderDetailsRepo.findById(orderId).isPresent();
            OrderDetails orderDetails;
            if (exist1) {
                orderDetails = orderDetailsRepo.findById(orderId).get();
                material.setOrderDetailsId(orderDetails);
                System.out.println("material subtract for Orders");
            }
//            else{
//        OrderDetails orderDetails=orderDetailsRepo.findById(orderId).get();
//            System.out.println("Order id don't exist");
//            material.setOrderDetailsId(null);
//            }
        } else {
            System.out.println("material subtract for damage or other purpose ");
            material.setOrderDetailsId(null);
        }

        //stock subtract
        double myquantity = material.getQuantity();
        int myid = material.getRawMaterialId().getId();
        stockUpdateService.subtractStock(myid, myquantity);
        //stock subtract end
        adjustmentMaterialRepo.save(material);
        return ResponseEntity.ok(material);
    }

    @PutMapping("/adjustment_material/{id}")
    public ResponseEntity<AdjustmentMaterial> materialAdjustmentUpdate(@RequestBody AdjustmentMaterial material, @PathVariable("id") int id) {
        boolean exist = adjustmentMaterialRepo.findById(id).isPresent();
        if (exist) {
            AdjustmentMaterial material1 = adjustmentMaterialRepo.findById(id).get();
            material1.setPrice(material.getPrice());
            material1.setQuantity(material.getQuantity());
            material1.setRemarks(material.getRemarks());

            //Raw material set
            String rawMaterial = material.getRawMaterialId().getName();
            RawMaterial mat = rawMaterialRepo.findByName(rawMaterial);
            material1.setRawMaterialId(mat);

            //warehouse set
            String warehouse = material.getWareHouseId().getName();
            WareHouse house = houseRepo.findByName(warehouse);
            material1.setWareHouseId(house);

            //Stock Adjustment set
            String stockStatus = material.getStockAdjustmentId().getName();
            StockAdjustment stockAdjustment = stockAdjustmentRepo.findByName(stockStatus);
            material1.setStockAdjustmentId(stockAdjustment);

            //Order Details set
            if (material.getId() != null) {
                int orderId = material.getOrderDetailsId().getId();
                boolean exist1 = orderDetailsRepo.findById(orderId).isPresent();
                OrderDetails orderDetails;
                if (exist1) {
                    orderDetails = orderDetailsRepo.findById(orderId).get();
                    material1.setOrderDetailsId(orderDetails);
                    System.out.println("material subtract for Orders");
                }
//        OrderDetails orderDetails=orderDetailsRepo.findById(orderId).get();
                System.out.println("Order id don't exist");
                material1.setOrderDetailsId(null);
            }
            System.out.println("material subtract for damage or other purpose ");
            material1.setOrderDetailsId(null);


            adjustmentMaterialRepo.save(material1);
            return ResponseEntity.ok(material1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Purchase start

    @GetMapping("/purchase")
    private List<Purchase> stockPurchaseList() {
        return purchaseRepo.findAll();
    }

    @GetMapping("/purchase/{id}")
    private ResponseEntity<Purchase> stockPurchaseById(@PathVariable("id") int id) {

        boolean exist = purchaseRepo.findById(id).isPresent();

        if (exist) {
            Purchase purchase = purchaseRepo.findById(id).get();
            return ResponseEntity.ok(purchase);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/purchase/{id}")
    public void deletePurchase(@PathVariable("id") int id) {
        boolean exist = purchaseRepo.existsById(id);
        if (exist) {
            purchaseRepo.deleteById(id);
        }
    }

    @PostMapping("/purchase")
    public ResponseEntity<Purchase> PurchaseSave(@RequestBody Purchase purchase) {
        //Raw material set
        String rawMaterial = purchase.getRawMaterialId().getName();
        RawMaterial material = rawMaterialRepo.findByName(rawMaterial);
        purchase.setRawMaterialId(material);

        //purchase status set
        String status = purchase.getStatusId().getName();
        PurchaseStatus status1 = purchaseStatusRepo.findByName(status);
        purchase.setStatusId(status1);

        //vendor set
        String vendor = purchase.getVendorsId().getCompany();
        Vendors vendors = vendorRepo.findByCompany(vendor);
        purchase.setVendorsId(vendors);

        //warehouse set
        String warehouse = purchase.getWareHouseId().getName();
        WareHouse house = houseRepo.findByName(warehouse);
        purchase.setWareHouseId(house);
        //stock add start
        double myquantity = purchase.getQuantity();
        int myid = purchase.getRawMaterialId().getId();
        stockUpdateService.addStockData(myid, myquantity);
        //stock add end
        purchaseRepo.save(purchase);
        return ResponseEntity.ok(purchase);
    }

    @PutMapping("/purchase/{id}")
    public ResponseEntity<Purchase> PurchaseUpdate(@RequestBody Purchase purchase, @PathVariable("id") int id) {
        boolean exist = purchaseRepo.findById(id).isPresent();
        if (exist) {
            Purchase purchase1 = purchaseRepo.findById(id).get();
            purchase1.setPurchaseDate(purchase.getPurchaseDate());
            purchase1.setDeliveryDate(purchase.getDeliveryDate());
            purchase1.setPrice(purchase.getPrice());
            purchase1.setQuantity(purchase.getQuantity());
            purchase1.setTotal(purchase.getTotal());
            purchase1.setPaid(purchase.getPaid());

            //style code set
            String rawMaterial = purchase.getRawMaterialId().getName();
            RawMaterial material = rawMaterialRepo.findByName(rawMaterial);
            purchase1.setRawMaterialId(material);

            //purchase status set
            String status = purchase.getStatusId().getName();
            PurchaseStatus status1 = purchaseStatusRepo.findByName(status);
            purchase1.setStatusId(status1);

            //vendor set
            String vendor = purchase.getVendorsId().getCompany();
            Vendors vendors = vendorRepo.findByCompany(vendor);
            purchase1.setVendorsId(vendors);

            //warehouse set
            String warehouse = purchase.getWareHouseId().getName();
            WareHouse house = houseRepo.findByName(warehouse);
            purchase1.setWareHouseId(house);

            //stock update
//            double myquantity = purchase1.getQuantity();
//            int myid=purchase1.getRawMaterialId().getId();
//            stockUpdateService.addStockData(myid,myquantity);

            purchaseRepo.save(purchase1);
            return ResponseEntity.ok(purchase1);
        }
        return ResponseEntity.notFound().build();
    }
    // api Stock start

    @GetMapping("/stock")
    private List<Stock> stocksList() {
        return stockRepo.findAll();
    }

//---------------------------------------- Other Table-----------------------------------
    // api Vendors start

    @GetMapping("/vendors")
    private List<Vendors> vendorsList() {
        return vendorRepo.findAll();
    }

    @DeleteMapping("/vendors/{id}")
    public void deleteVendor(@PathVariable("id") int id) {
        boolean exist = vendorRepo.existsById(id);
        if (exist) {
            vendorRepo.deleteById(id);
        }
    }

    @PostMapping("/vendors")
    public ResponseEntity<Vendors> vendorsSave(@RequestBody Vendors vendors) {
        vendorRepo.save(vendors);
        return ResponseEntity.ok(vendors);
    }

    @PutMapping("/vendors/{id}")
    public ResponseEntity<Vendors> vendorsUpdate(@RequestBody Vendors vendors, @PathVariable("id") int id) {
        boolean exist = vendorRepo.findById(id).isPresent();
        if (exist) {
            Vendors vendors1 = vendorRepo.findById(id).get();
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
    private List<UOM> uomList() {
        return iuomRepo.findAll();
    }

    @DeleteMapping("/uom/{id}")
    public void deleteUom(@PathVariable("id") int id) {
        boolean exist = iuomRepo.existsById(id);
        if (exist) {
            iuomRepo.deleteById(id);
        }
    }

    @PostMapping("/uom")
    public ResponseEntity<UOM> uomSave(@RequestBody UOM uom) {
        iuomRepo.save(uom);
        return ResponseEntity.ok(uom);
    }

    @PutMapping("/uom/{id}")
    public ResponseEntity<UOM> uomUpdate(@RequestBody UOM uom, @PathVariable("id") int id) {
        boolean exist = iuomRepo.findById(id).isPresent();
        if (exist) {
            UOM uom1 = iuomRepo.findById(id).get();
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
    private List<Department> departmentsList() {
        return departmentRepo.findAll();
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartments(@PathVariable("id") int id) {
        boolean exist = departmentRepo.existsById(id);
        if (exist) {
            departmentRepo.deleteById(id);
        }
    }

    @PostMapping("/department")
    public ResponseEntity<Department> departmentSave(@RequestBody Department department) {
        departmentRepo.save(department);
        return ResponseEntity.ok(department);
    }

    @PutMapping("/department/{id}")
    public ResponseEntity<Department> departmentUpdate(@RequestBody Department department, @PathVariable("id") int id) {
        boolean exist = departmentRepo.findById(id).isPresent();
        if (exist) {
            Department department1 = departmentRepo.findById(id).get();
            department1.setName(department.getName());

            departmentRepo.save(department1);
            return ResponseEntity.ok(department1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Department end
    // api Labor Cost start
    @GetMapping("/labor_cost")
    private List<LaborCost> laborCostList() {
        return costRepo.findAll();
    }

    @DeleteMapping("/labor_cost/{id}")
    public void deleteLaborCost(@PathVariable("id") int id) {
        boolean exist = costRepo.existsById(id);
        if (exist) {
            costRepo.deleteById(id);
        }
    }

    @PostMapping("/labor_cost")
    public ResponseEntity<LaborCost> laborCostSave(@RequestBody LaborCost cost) {
        // department set
        String dept = cost.getDepartmentId().getName();
        Department department = departmentRepo.findByName(dept);
        cost.setDepartmentId(department);
        //style code set
        String styleCode = cost.getStyleId().getCode();
        Style code = styleRepo.findByCode(styleCode);
        cost.setStyleId(code);
        costRepo.save(cost);
        return ResponseEntity.ok(cost);
    }

    @PutMapping("/labor_cost/{id}")
    public ResponseEntity<LaborCost> departmentUpdate(@RequestBody LaborCost cost, @PathVariable("id") int id) {
        boolean exist = costRepo.findById(id).isPresent();
        if (exist) {
            LaborCost cost1 = costRepo.findById(id).get();
            cost1.setUnitCost(cost.getUnitCost());
            cost1.setHour(cost.getHour());
            // department set
            String dept = cost.getDepartmentId().getName();
            Department department = departmentRepo.findByName(dept);
            cost1.setDepartmentId(department);
            //style code set
            String styleCode = cost.getStyleId().getCode();
            Style code = styleRepo.findByCode(styleCode);
            cost1.setStyleId(code);
            costRepo.save(cost1);
            return ResponseEntity.ok(cost1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Labor Cost end
//---------------------------------------- Buyers Table----------------------------------
    // api Buyers start
    @GetMapping("/buyers")
    private List<Buyers> buyersList() {
        return buyerRepo.findAll();
    }

    @DeleteMapping("/buyers/{id}")
    public void deleteBuyers(@PathVariable("id") int id) {
        boolean exist = buyerRepo.existsById(id);
        if (exist) {
            buyerRepo.deleteById(id);
        }
    }

    @PostMapping("/buyers")
    public ResponseEntity<Buyers> buyersSave(@RequestBody Buyers buyers) {
        buyerRepo.save(buyers);
        return ResponseEntity.ok(buyers);
    }

    @PutMapping("/buyers/{id}")
    public ResponseEntity<Buyers> buyersUpdate(@RequestBody Buyers buyers, @PathVariable("id") int id) {
        boolean exist = buyerRepo.findById(id).isPresent();
        if (exist) {
            Buyers buyers1 = buyerRepo.findById(id).get();
            buyers1.setOrganization(buyers.getOrganization());
            buyers1.setContactPerson(buyers.getContactPerson());
            buyers1.setPhone(buyers.getPhone());
            buyers1.setEmail(buyers.getEmail());
            buyers1.setAddress(buyers.getAddress());
            buyers1.setCountry(buyers.getCountry());

            buyerRepo.save(buyers1);
            return ResponseEntity.ok(buyers1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Task start
    @GetMapping("/task")
    private List<Task> taskList() {
        return taskRepo.findAll();
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable("id") int id) {
        boolean exist = taskRepo.existsById(id);
        if (exist) {
            taskRepo.deleteById(id);
        }
    }

    @PostMapping("/task")
    public ResponseEntity<Task> taskSave(@RequestBody Task task) {
        taskRepo.save(task);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Task> taskUpdate(@RequestBody Task task, @PathVariable("id") int id) {
        boolean exist = taskRepo.findById(id).isPresent();
        if (exist) {
            Task task1 = taskRepo.findById(id).get();
            task1.setName(task.getName());

            taskRepo.save(task1);
            return ResponseEntity.ok(task1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Orders Status start
    @GetMapping("/order_status")
    private List<OrderStatus> orderStatusList() {
        return statusRepo.findAll();
    }

    @DeleteMapping("/order_status/{id}")
    public void deleteOrderStatus(@PathVariable("id") int id) {
        boolean exist = statusRepo.existsById(id);
        if (exist) {
            statusRepo.deleteById(id);
        }
    }

    @PostMapping("/order_status")
    public ResponseEntity<OrderStatus> orderStatusSave(@RequestBody OrderStatus orderStatus) {
        statusRepo.save(orderStatus);
        return ResponseEntity.ok(orderStatus);
    }

    @PutMapping("/order_status/{id}")
    public ResponseEntity<OrderStatus> orderStatusUpdate(@RequestBody OrderStatus orderStatus, @PathVariable("id") int id) {
        boolean exist = statusRepo.findById(id).isPresent();
        if (exist) {
            OrderStatus orderStatus1 = statusRepo.findById(id).get();
            orderStatus1.setName(orderStatus.getName());

            statusRepo.save(orderStatus1);
            return ResponseEntity.ok(orderStatus1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Orders start
    @GetMapping("/orders")
    private List<OrderDetails> orderDetailsList() {
        return orderDetailsRepo.findAll();
    }

    // get order details by id
    @GetMapping("/orders/{id}")
    private ResponseEntity<OrderDetails> orderDetailsById(@PathVariable("id") int id) {

        boolean exist = orderDetailsRepo.findById(id).isPresent();
        if (exist) {
            OrderDetails orderDetails = orderDetailsRepo.findById(id).get();
            return ResponseEntity.ok(orderDetails);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrderDetails(@PathVariable("id") int id) {
        boolean exist = orderDetailsRepo.existsById(id);
        if (exist) {
            orderDetailsRepo.deleteById(id);
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderDetails> orderDetailsSave(@RequestBody OrderDetails orderDetails) {

        //style code set
        String styleCode = orderDetails.getStyleId().getCode();
        Style code = styleRepo.findByCode(styleCode);
        orderDetails.setStyleId(code);
        //buyers set
        String buyers = orderDetails.getBuyersId().getOrganization();
        Buyers buyerId = buyerRepo.findByOrganization(buyers);
        orderDetails.setBuyersId(buyerId);
        //order status set
        String status = orderDetails.getOrStatusId().getName();
        OrderStatus statusId = statusRepo.findByName(status);
        orderDetails.setOrStatusId(statusId);

        orderDetailsRepo.save(orderDetails);
        return ResponseEntity.ok(orderDetails);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<OrderDetails> orderDetailsUpdate(@RequestBody OrderDetails orderDetails, @PathVariable("id") int id) {
        boolean exist = orderDetailsRepo.findById(id).isPresent();
        if (exist) {
            OrderDetails orderDetails1 = orderDetailsRepo.findById(id).get();
            orderDetails1.setShippingAddress(orderDetails.getShippingAddress());
            //style code set
            String styleCode = orderDetails.getStyleId().getCode();
            Style code = styleRepo.findByCode(styleCode);
            orderDetails1.setStyleId(code);
            //buyers set
            String buyers = orderDetails.getBuyersId().getOrganization();
            Buyers buyerId = buyerRepo.findByOrganization(buyers);
            orderDetails1.setBuyersId(buyerId);
            //order status set
            String status = orderDetails.getOrStatusId().getName();
            OrderStatus statusId = statusRepo.findByName(status);
            orderDetails1.setOrStatusId(statusId);

            orderDetails1.setSAmount(orderDetails.getSAmount());
            orderDetails1.setMAmount(orderDetails.getMAmount());
            orderDetails1.setLAmount(orderDetails.getLAmount());
            orderDetails1.setOderDate(orderDetails.getOderDate());
            orderDetails1.setDeliveryDate(orderDetails.getDeliveryDate());
            orderDetails1.setTotalAmount(orderDetails.getTotalAmount());
            orderDetails1.setPaid(orderDetails.getPaid());

            //small size product amount
//            String small=orderDetails.getSAmount();


            orderDetailsRepo.save(orderDetails1);
            return ResponseEntity.ok(orderDetails1);
        }
        return ResponseEntity.notFound().build();
    }


//---------------------------------------- Report Table----------------------------------

    //Time Action Table
    @GetMapping("/time_action")
    private List<TimeAction> timeActionsList() {
        return timeActionRepo.findAll();
    }

    @DeleteMapping("/time_action/{id}")
    public void deleteTimeActions(@PathVariable("id") int id) {
        boolean exist = timeActionRepo.existsById(id);
        if (exist) {
            timeActionRepo.deleteById(id);

        }
    }

    @PostMapping("/time_action")
    public ResponseEntity<TimeAction> timeActionsSave(@RequestBody TimeAction action) {
        //Order Details set
        int orderId = action.getOrderId().getId();
        boolean exist1 = orderDetailsRepo.findById(orderId).isPresent();
        OrderDetails orderDetails;
        if (exist1) {
            orderDetails = orderDetailsRepo.findById(orderId).get();
            action.setOrderId(orderDetails);

        }
        //task set
        String taskId = action.getTaskId().getName();
        Task task = taskRepo.findByName(taskId);
        action.setTaskId(task);


        timeActionRepo.save(action);
        return ResponseEntity.ok(action);

    }

    @PutMapping("/time_action/{id}")
    public ResponseEntity<TimeAction> timeActionsUpdate(@RequestBody TimeAction action,
                                                  @PathVariable("id") int id) {
        boolean exist = timeActionRepo.findById(id).isPresent();
        if (exist) {

            TimeAction action1 = timeActionRepo.findById(id).get();
            action1.setRemarks(action.getRemarks());
            action1.setExpectedStartDate(action.getExpectedStartDate());
            action1.setExpectedEndDate(action.getExpectedEndDate());
            action1.setActualStartDate(action.getActualStartDate());
            action1.setActualEndDate(action.getActualEndDate());
            //Order Details set
            int orderId = action.getOrderId().getId();
            boolean exist1 = orderDetailsRepo.findById(orderId).isPresent();
            OrderDetails orderDetails;
            if (exist1) {
                orderDetails = orderDetailsRepo.findById(orderId).get();
                action1.setOrderId(orderDetails);

            }
            //task set
            String taskId = action.getTaskId().getName();
            Task task = taskRepo.findByName(taskId);
            action1.setTaskId(task);

            timeActionRepo.save(action1);
            return ResponseEntity.ok(action1);
        }
        return ResponseEntity.notFound().build();
    }

    // api Time Action start
    @GetMapping("/time_action_report/{id}")
    private List<TimeAction> timeActionsByOrderIdList(@PathVariable("id") int id) {
        return actionService.getTNA(id);
    }

    // api Bill of Material start
    //style attachment list by style id
    @GetMapping("/bom_attachment/{id}")
    private List<StyleAttachment> stAttachmentByStyleIdList(@PathVariable("id") int id) {
        return billOfMaterialService.getStyleImage(id);
    }

    //style material by size  list by style id
    @GetMapping("/bom_size/{id}/{sizeid}")
    private List<StyleMaterialQuantity> stMaterialByStyleIdList(@PathVariable("id") int id, @PathVariable("sizeid") int sizeid) {
        return billOfMaterialService.getPriceList(sizeid, id);
    }

    //labor cost list by style id
    @GetMapping("/bom_cost/{id}")
    private List<LaborCost> laborCostsByStyleIdList(@PathVariable("id") int id) {
        return costRepo.findCostbyStyleId(id);
    }

    // api TechPage start
    @GetMapping("/techpage_mat/{id}")
    private List<RawMaterial> rawMaterialByStyleIdList(@PathVariable("id") int id) {
        return packService.getTechPack(id);
    }

    @GetMapping("/techpage_measurement/{id}")
    private List<MeasurementDetails> measurementByStyleIdList(@PathVariable("id") int id) {
        return packService.getMeasuermentDetList(id);
    }

    @GetMapping("/techpage_attachment/{id}")
    private List<MeasurementAttachment> measurementAttachmentByStyleIdList(@PathVariable("id") int id) {
        return packService.getMSketchList(id);
    }

    //---------------------------------------- DashBoard -------------------------------------------------------------
    @GetMapping("/dash_order_count")
    private ResponseEntity<String> getOrderCount() {
        int orderCount=orderDetailsRepo.findByOrder();
        int orderCount2= (int) orderDetailsRepo.count();
        System.out.println("order Count "+orderCount2);
        return ResponseEntity.ok(String.valueOf(orderCount));
    }
    @GetMapping("/dash_order_total")
    private ResponseEntity<String> getOrderTotal() {
        //Transaction Order total amount
        double totalOrderSale=orderDetailsRepo.findByTotal();
        return ResponseEntity.ok(String.valueOf(totalOrderSale));
    }
    @GetMapping("/dash_purchase_total")
    private ResponseEntity<String> getPurchaseTotal() {
        //Transaction Purchase total amount
        double totalPurchase=purchaseRepo.findByTotalPurchase();
        return ResponseEntity.ok(String.valueOf(totalPurchase));
    }
    @GetMapping("/dash_revenue")
    private ResponseEntity<String> getRevenue() {
        //Transaction Revenue percentage
        int revenuePercentage=revenueService.revenue();
        return ResponseEntity.ok(String.valueOf(revenuePercentage));
    }
}
