package com.emergentes.controlador;

import com.emergentes.dao.categoriaDAO;
import com.emergentes.dao.categoriaDAOimpl;
import com.emergentes.dao.libroDAO;
import com.emergentes.dao.libroDAOimpl;
import com.emergentes.modelo.categorias;
import com.emergentes.modelo.libros;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FIDEL
 */
@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //AvisoController? action=add
            libroDAO dao = new libroDAOimpl();
            categoriaDAO dao1 = new categoriaDAOimpl();
            int id;
            libros li = new libros();
            categorias lit = new categorias();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("libros", li);
                    request.getRequestDispatcher("frmlibro.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    li = dao.getById(id);
                    System.out.println(li);
                    request.setAttribute("libros", li);
                    request.getRequestDispatcher("frmlibro.jsp").forward(request, response);
                    break;

                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/Inicio");
                    break;

                case "view":
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;

                case "libro":
                    List<libros> lista = dao.getAll();
                    request.setAttribute("libros", lista);
                    request.getRequestDispatcher("libro.jsp").forward(request, response);
                    break;
                case "categoria":
                    List<categorias> list = dao1.getAll();
                    request.setAttribute("categorias", list);
                    request.getRequestDispatcher("categorias.jsp").forward(request, response);
                    break;
                case "addi":
                    request.setAttribute("categorias", lit);
                    request.getRequestDispatcher("frmcategoria.jsp").forward(request, response);
                    break;
                case "edita":
                    id = Integer.parseInt(request.getParameter("id"));
                    lit = dao1.getById(id);
                    System.out.println(lit);
                    request.setAttribute("categorias", lit);
                    request.getRequestDispatcher("frmcategroia.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String disponible = request.getParameter("disponible");
        String categoria = request.getParameter("categoria");

        libros li = new libros();

        li.setId(id);
        li.setTitulo(titulo);
        li.setAutor(autor);
        li.setDisponible(disponible);
        li.setCategoria(categoria);

        if (id == 0) {
            try {
                libroDAO dao = new libroDAOimpl();
                dao.insert(li);
                response.sendRedirect(request.getContextPath() + "/Inicio");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        } else {
            try {
                libroDAO dao = new libroDAOimpl();
                dao.update(li);
                response.sendRedirect(request.getContextPath() + "/Inicio");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }

        categorias lis = new categorias();
        lis.setId(id);
        lis.setCategoria(categoria);
        if (id == 0) {
            try {
                categoriaDAO daos = new categoriaDAOimpl();
                daos.insert(lis);
                response.sendRedirect(request.getContextPath() + "/Inicio");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        } else {
            try {
                categoriaDAO daos = new categoriaDAOimpl();
                daos.update(lis);
                response.sendRedirect(request.getContextPath() + "/Inicio");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }
    }

}
