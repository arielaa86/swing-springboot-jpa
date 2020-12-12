/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaswing.app.utiles;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import jiconfont.IconCode;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

public class Utiles {

    public static Icon cambiarIcono(IconCode icono, int talla) {

        IconFontSwing.register(FontAwesome.getIconFont());

        Icon icon = IconFontSwing.buildIcon(icono, talla);

        return icon;

    }

    public static Icon cambiarIcono(IconCode icono, Color c) {

        IconFontSwing.register(FontAwesome.getIconFont());

        Icon icon = IconFontSwing.buildIcon(icono, 14, c);
        return icon;

    }

    public static Icon cambiarIcono(IconCode icono, Color c, int talla) {

        IconFontSwing.register(FontAwesome.getIconFont());

        Icon icon = IconFontSwing.buildIcon(icono, talla, c);
        return icon;

    }

    public static ImageIcon escalarImagen(File imagen, int width, int heigth) throws IOException {

        BufferedImage img = null;

        img = ImageIO.read(imagen);

        Image imagenEscalada = img.getScaledInstance(width, heigth,
                Image.SCALE_SMOOTH);
        
        return new ImageIcon(imagenEscalada);
    }

}
