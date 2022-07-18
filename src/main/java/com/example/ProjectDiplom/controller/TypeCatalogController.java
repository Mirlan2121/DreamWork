package com.example.ProjectDiplom.controller;


import com.example.ProjectDiplom.entity.TypeCatalog;
import com.example.ProjectDiplom.model.Type.TypeCatalogModel;
import com.example.ProjectDiplom.service.TypeCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeCatalogController {

    @Autowired
    private TypeCatalogService catalogService;

    @PostMapping("/create")
    public TypeCatalog createTypeCatalog(@RequestBody TypeCatalogModel typeCatalogModel){
        return catalogService.createType(typeCatalogModel);
    }

    @GetMapping("/getAllType")
    public List<TypeCatalog> getAllType(){
        return catalogService.getAllTypes();
    }

    @GetMapping("/getByTypeId/{id}")
    public TypeCatalog getByTypeId(@PathVariable Long id){
        return catalogService.getByTypeId(id);
    }

    @GetMapping("/getByTypeName/{name}")
    public TypeCatalog getByTypeName(@PathVariable String name){
        return catalogService.getByName(name);
    }

    @PostMapping("/updateTypeCatalog")
    public TypeCatalog updateTypeCatalog(@RequestBody TypeCatalogModel typeCatalogModel){
        return catalogService.updateType(typeCatalogModel);
    }

    @DeleteMapping("/deleteTypeCatalog/{id}")
    public TypeCatalog deleteType(@PathVariable Long id){
        return catalogService.deleteType(id);
    }
}
