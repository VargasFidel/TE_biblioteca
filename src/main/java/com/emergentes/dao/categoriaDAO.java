/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.modelo.categorias;
import java.util.List;

/**
 *
 * @author FIDEL
 */
public interface categoriaDAO {
    public void insert(categorias categorias) throws Exception;
    public void update(categorias categorias) throws Exception;
    public void delete(int id) throws Exception;
    public categorias getById(int id) throws Exception;
    public List<categorias> getAll() throws Exception;
}
