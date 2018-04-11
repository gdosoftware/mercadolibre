/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdosoftware.mercadolibre.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Daniel Gago
 */
public class MLCategory implements Serializable{
    private String id;
    private String name;
    private MLCategory[] path_from_root;
    private MLCategory[] children_categories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MLCategory[] getChildren_categories() {
        return children_categories;
    }

    public void setChildren_categories(MLCategory[] children_categories) {
        this.children_categories = children_categories;
    }

    public MLCategory[] getPath_from_root() {
        return path_from_root;
    }

    public void setPath_from_root(MLCategory[] path_from_root) {
        this.path_from_root = path_from_root;
    }
    
    public List<String> getChildrenCategoriesIds(){
        return Arrays.asList(children_categories).stream()
                                                 .map(MLCategory::getId)
                                                 .collect(Collectors.toList());
    }
    
     public List<String> getParentCategoriesIds(){
        return Arrays.asList(path_from_root).stream()
                                            .map(MLCategory::getId)
                                            .collect(Collectors.toList());
    }
    
}
