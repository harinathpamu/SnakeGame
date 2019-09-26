/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamu.snake;

import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileView;

/**
 *
 * @author Harinath
 */
public class DotSerFileView extends FileView {
    ImageIcon jpgIcon = new ImageIcon("snake.png");
    public String getTypeDescription(File f) {
        String ext = Main.getExtension(f);
        String type = null;
        if (ext != null) {
            if (ext.equals("ser")) {
                type = "ser";
            }
        }
        return type;
    }
    
    public Icon getIcon(File f) {
        String ext = Main.getExtension(f);
        Icon icon = null;
        if (ext != null) {
            if (ext.equals("ser")) {
                icon = jpgIcon;
            }
        }
        return icon;
    }
}
