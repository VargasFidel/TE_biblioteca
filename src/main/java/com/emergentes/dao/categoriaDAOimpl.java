
package com.emergentes.dao;

import com.emergentes.modelo.categorias;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class categoriaDAOimpl extends ConexionDB implements categoriaDAO {

    @Override
    public void insert(categorias categorias) throws Exception {
        try{
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(" insert into categorias (categoria) values (?)");
        ps.setString(1, categorias.getCategoria());
        ps.executeUpdate();
        }
        catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(categorias categorias) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("update categorias set categoria =? where id = ?");
            ps.setString(4, categorias.getCategoria());
            ps.setInt(5, categorias.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try{
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("delete from categorias where id = ? ");
        ps.setInt(1, id);
        ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public categorias getById(int id) throws Exception {
        categorias li = new categorias();
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from categorias where id=? limit 1");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                li.setId(rs.getInt("id"));
                li.setCategoria(rs.getString("categoria"));
            }
        }catch (Exception e){
              throw e; 
        }finally{
             this.desconectar();
        }
        return li;
    }

    @Override
    public List<categorias> getAll() throws Exception {
        List<categorias> lista = null;
        try{
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("select * from categorias");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<categorias>();
            while(rs.next()){
                categorias li = new categorias();
                li.setId(rs.getInt("id"));
                li.setCategoria(rs.getString("categoria"));
                lista.add(li);
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;
    }
    
}
