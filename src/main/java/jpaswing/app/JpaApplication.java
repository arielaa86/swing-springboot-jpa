/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaswing.app;

import javax.swing.JRootPane;
import jpaswing.app.servicio.TrabajadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author ariel
 */
@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(
                JpaApplication.class).headless(false).run(args);

        Principal principal = context.getBean(Principal.class);

        principal.setResizable(false);
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);

    }

}
