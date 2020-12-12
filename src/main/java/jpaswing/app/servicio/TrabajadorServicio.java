/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaswing.app.servicio;

import java.awt.Color;
import java.util.List;
import java.util.Optional;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jiconfont.icons.font_awesome.FontAwesome;

import jpaswing.app.model.Trabajador;
import jpaswing.app.repositorio.TrabajadorRepositorio;
import jpaswing.app.utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class TrabajadorServicio {

    @Autowired
    TrabajadorRepositorio trabajadorRepositorio;

    public void guardar(Trabajador trabajador) throws Exception {
        trabajadorRepositorio.save(trabajador);
    }

    public void actualizar(Trabajador trabajador){
        trabajadorRepositorio.save(trabajador);
    }

    public Trabajador obtener(Long id) {

        Optional<Trabajador> resultado = trabajadorRepositorio.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        }

        return null;
    }

    public void borrar(Long id) {
        trabajadorRepositorio.deleteById(id);
    }

    public void llenarTabla(JTable tabla) {

        List<Trabajador> lista = (List<Trabajador>) trabajadorRepositorio.findAll();

        String[] cabecera = {"Id", "Nombre", "Apellidos", "DNI", "", ""};

        DefaultTableModel modelo = new DefaultTableModel(cabecera, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
            
        };

        for (Trabajador trabajador : lista) {

            Object[] fila = new Object[6];

            fila[0] = trabajador.getId();
            fila[1] = trabajador.getNombre();
            fila[2] = trabajador.getApellidos();
            fila[3] = trabajador.getDni();

            JButton modificar = new JButton(Utiles.cambiarIcono(FontAwesome.PENCIL, Color.LIGHT_GRAY, 16));
            JButton eliminar = new JButton(Utiles.cambiarIcono(FontAwesome.TRASH, Color.LIGHT_GRAY, 16));
         
            fila[4] = modificar;
            fila[5] = eliminar;

            modelo.addRow(fila);

        }

        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);

        tabla.getColumnModel().getColumn(4).setMinWidth(28);
        tabla.getColumnModel().getColumn(4).setMaxWidth(28);

        tabla.getColumnModel().getColumn(5).setMinWidth(28);
        tabla.getColumnModel().getColumn(5).setMaxWidth(28);

    }

 

}
