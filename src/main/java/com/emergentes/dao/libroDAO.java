
package com.emergentes.dao;

import com.emergentes.modelo.libros;
import java.util.List;

public interface libroDAO {
    public void insert(libros libros) throws Exception;
    public void update(libros libros) throws Exception;
    public void delete(int id) throws Exception;
    public libros getById(int id) throws Exception;
    public List<libros> getAll() throws Exception;
}
