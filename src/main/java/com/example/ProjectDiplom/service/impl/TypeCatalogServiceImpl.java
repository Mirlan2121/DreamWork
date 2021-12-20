package com.example.ProjectDiplom.service.impl;

import com.example.ProjectDiplom.entity.TypeCatalog;
import com.example.ProjectDiplom.model.TypeCatalogModel;
import com.example.ProjectDiplom.repository.TypeCatalogRepository;
import com.example.ProjectDiplom.service.TypeCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCatalogServiceImpl implements TypeCatalogService {

    @Autowired
    private TypeCatalogRepository typeCatalogRepository;


    @Override
    public TypeCatalog createType(TypeCatalogModel typeCatalogModel) {
        TypeCatalog typeCatalog = new TypeCatalog();
        typeCatalog.setName(typeCatalogModel.getName());
        return typeCatalogRepository.save(typeCatalog) ;
    }

    @Override
    public List<TypeCatalog> getAllTypes() {
        return typeCatalogRepository.findAll();
    }

    @Override
    public TypeCatalog deleteType(Long id) {
        TypeCatalog typeCatalog = typeCatalogRepository.findById(id).orElse(null);
        typeCatalogRepository.deleteById(id);
        return typeCatalog;
    }

    @Override
    public TypeCatalog getByName(String name) {
        return typeCatalogRepository.findByName(name).orElse(null);
    }

    @Override
    public TypeCatalog getByTypeId(Long id) {
        return typeCatalogRepository.findById(id).orElse(null);
    }

    @Override
    public TypeCatalog updateType(TypeCatalogModel typeCatalogModel) {
        TypeCatalog typeCatalog = typeCatalogRepository.findById(typeCatalogModel.getId()).orElse(null);
        typeCatalog.setName(typeCatalogModel.getName());
        return typeCatalogRepository.save(typeCatalog);
    }
}
