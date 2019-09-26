/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamu.snake;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Harinath
 */
public class DotSerFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isFile()) {
            String ext = Main.getExtension(f);
            if (ext != null) {
                if (ext.equals("ser")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public String getDescription() {
        return "*.ser";
    }

}
