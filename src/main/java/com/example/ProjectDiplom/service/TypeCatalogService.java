package com.example.ProjectDiplom.service;

import com.example.ProjectDiplom.entity.TypeCatalog;
import com.example.ProjectDiplom.model.TypeCatalogModel;

import java.util.List;


public interface TypeCatalogService {

    TypeCatalog createType(TypeCatalogModel typeCatalogModel);

    List<TypeCatalog> getAllTypes();

    TypeCatalog deleteType(Long id);

    TypeCatalog getByName(String name);

    TypeCatalog getByTypeId(Long id);

    TypeCatalog updateType(TypeCatalogModel typeCatalogModel);
}
