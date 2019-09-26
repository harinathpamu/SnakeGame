package com.pamu.snake;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Harinath
 */
public class Main extends JFrame {

    private boolean askFilePath = true;
    private String fileAbsolutePath = null;
    private final SnakeState snake_state = new SnakeState();
    private final ArrayList<Box> snake = new ArrayList<>();
    private final String LEFT = "L";
    private final String RIGHT = "R";
    private final String BOTTOM = "B";
    private final String TOP = "T";

    private final int width = 500;
    private final int height = 500;
    private final int border_width = 10;

    private int snake_speed;
    private String CURR = RIGHT;
    private boolean isGameOver = false;
    private int score = 0;
    private boolean has_boundary = false;
    private final Box food = new Box(100, 100);

    private Thread start_thread = null;

    public Main() {
        initComponents();
    }

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    public void loadState(SnakeState snake_state) {
        isGameOver = false;
        snake_speed = snake_state.getSnake_speed();
        CURR = snake_state.getSnake_direction();
        score = snake_state.getScore();
        has_boundary = snake_state.isHas_boundary();
        HashMap<String, Integer> foodxy = snake_state.getFood_xy();
        food.setX(foodxy.get("X"));
        food.setY(foodxy.get("Y"));
        snake.clear();
        snake.addAll(snake_state.getSnake());
        if (has_boundary) {
            if (snake_panel != null) {
                snake_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 105, 124), 10));
            }
        } else {
            if (snake_panel != null) {
                snake_panel.setBorder(null);
            }
        }
        if (hasBoundary_radio_button != null) {
            hasBoundary_radio_button.setSelected(has_boundary);
            hasBoundary_radio_button.setEnabled(false);
        }
        if (score_label != null) {
            score_label.setText("SCORE: " + score);
        }
        if (snake_panel != null) {
            snake_panel.repaint();
        }
        if (snake_speed_slider != null) {
            snake_speed_slider.setValue(snake_speed);
        }
        if (!start_button.isEnabled()) {
            start_button.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon imageIcon=new ImageIcon("snake.png");
        snake_panel = new SnakePanel();
        controls_panel = new javax.swing.JPanel();
        speed = new java.awt.Label();
        snake_speed_slider = new javax.swing.JSlider();
        start_button = new javax.swing.JButton();
        new_game_button = new javax.swing.JButton();
        score_label = new java.awt.Label();
        hasBoundary_radio_button = new javax.swing.JRadioButton();
        save_game_button = new javax.swing.JButton();
        load_game_button = new javax.swing.JButton();
        pause_button = new javax.swing.JButton();
        label1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snake");
        setIconImage(imageIcon.getImage());
        setLocationByPlatform(true);
        setMaximumSize(null);
        setMinimumSize(null);
        setName("main"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));

        snake_panel.setAlignmentX(0.0F);
        snake_panel.setAlignmentY(0.0F);
        snake_panel.setMaximumSize(null);
        snake_panel.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout snake_panelLayout = new javax.swing.GroupLayout(snake_panel);
        snake_panel.setLayout(snake_panelLayout);
        snake_panelLayout.setHorizontalGroup(
            snake_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        snake_panelLayout.setVerticalGroup(
            snake_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        controls_panel.setBackground(new java.awt.Color(68, 106, 126));
        controls_panel.setMaximumSize(null);
        controls_panel.setPreferredSize(new java.awt.Dimension(200, 500));

        speed.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        speed.setForeground(new java.awt.Color(255, 255, 255));
        speed.setText("Speed");

        snake_speed_slider.setMajorTickSpacing(1);
        snake_speed_slider.setMaximum(500);
        snake_speed_slider.setMinimum(25);
        snake_speed_slider.setMinorTickSpacing(1);
        snake_speed_slider.setValue(250);
        snake_speed_slider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        snake_speed_slider.setFocusable(false);
        snake_speed_slider.setInverted(true);
        snake_speed=snake_speed_slider.getValue();
        snake_speed_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                int value = snake_speed_slider.getValue();
                snake_speed=value;
                snake_state.setSnake_speed(snake_speed);
            }
        });

        start_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        start_button.setText("START");
        start_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        start_button.setFocusable(false);
        start_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_buttonActionPerformed(evt);
            }
        });

        new_game_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        new_game_button.setText("NEW GAME");
        new_game_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        new_game_button.setEnabled(false);
        new_game_button.setFocusable(false);
        new_game_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_game_buttonActionPerformed(evt);
            }
        });

        score_label.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        score_label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        score_label.setForeground(new java.awt.Color(255, 255, 255));
        score_label.setName("points"); // NOI18N
        score_label.setText("SCORE : 0");

        hasBoundary_radio_button.setForeground(new java.awt.Color(255, 255, 255));
        hasBoundary_radio_button.setText("Boundary ");
        hasBoundary_radio_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hasBoundary_radio_button.setFocusable(false);
        hasBoundary_radio_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hasBoundary_radio_buttonActionPerformed(evt);
            }
        });

        save_game_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        save_game_button.setText("SAVE GAME");
        save_game_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_game_button.setEnabled(false);
        save_game_button.setFocusable(false);
        save_game_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_game_buttonActionPerformed(evt);
            }
        });

        load_game_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        load_game_button.setText("LOAD GAME");
        load_game_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        load_game_button.setFocusable(false);
        load_game_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                load_game_buttonActionPerformed(evt);
            }
        });

        pause_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pause_button.setText("PAUSE");
        pause_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pause_button.setEnabled(false);
        pause_button.setFocusable(false);
        pause_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pause_buttonActionPerformed(evt);
            }
        });

        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Have Fun  : )   🎉");

        javax.swing.GroupLayout controls_panelLayout = new javax.swing.GroupLayout(controls_panel);
        controls_panel.setLayout(controls_panelLayout);
        controls_panelLayout.setHorizontalGroup(
            controls_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controls_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controls_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(score_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controls_panelLayout.createSequentialGroup()
                        .addGroup(controls_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(new_game_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(start_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(save_game_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(snake_speed_slider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(hasBoundary_radio_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(load_game_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(pause_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(controls_panelLayout.createSequentialGroup()
                        .addGroup(controls_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(speed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        controls_panelLayout.setVerticalGroup(
            controls_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controls_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(new_game_button)
                .addGap(2, 2, 2)
                .addComponent(start_button)
                .addGap(2, 2, 2)
                .addComponent(pause_button)
                .addGap(2, 2, 2)
                .addComponent(save_game_button)
                .addGap(2, 2, 2)
                .addComponent(speed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(snake_speed_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hasBoundary_radio_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(score_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(load_game_button)
                .addContainerGap())
        );

        start_button.getAccessibleContext().setAccessibleName("NEW GAME");
        score_label.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(snake_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(controls_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(controls_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(snake_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void start_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_buttonActionPerformed
        if (start_thread != null) {
            if (!start_thread.isAlive()) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        start_thread.start();
                        start_button.setEnabled(false);
                        new_game_button.setEnabled(true);
                        hasBoundary_radio_button.setEnabled(false);
                        pause_button.setEnabled(true);
                        pause_button.setActionCommand("PAUSE");
                        pause_button.setText("PAUSE");
                    }
                }).start();
            }
        }

    }//GEN-LAST:event_start_buttonActionPerformed

    private void new_game_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_game_buttonActionPerformed
        if (start_thread != null) {
            if (start_thread.getState() == Thread.State.TIMED_WAITING || start_thread.isAlive() || start_thread.getState() == Thread.State.TERMINATED) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (start_thread.getState() != Thread.State.TERMINATED) {
                            start_thread.stop();
                        }
                        start_thread = null;
                        askFilePath = true;
                        hasBoundary_radio_button.setEnabled(true);
                        start_button.setEnabled(true);
                        new_game_button.setEnabled(false);
                        pause_button.setEnabled(false);
                        save_game_button.setText("SAVE GAME");
                        save_game_button.setEnabled(false);
                        snake_panel.initLooper();
                    }
                }).start();
            }
        }

    }//GEN-LAST:event_new_game_buttonActionPerformed

    private void hasBoundary_radio_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hasBoundary_radio_buttonActionPerformed
        if (hasBoundary_radio_button.isSelected()) {
            snake_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 105, 124), 10));
            has_boundary = true;
        } else {
            snake_panel.setBorder(null);
            has_boundary = false;
        }
        snake_state.setHas_boundary(has_boundary);
    }//GEN-LAST:event_hasBoundary_radio_buttonActionPerformed

    private void save_game_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_game_buttonActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (askFilePath) {
                    final JFileChooser fc = new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fc.setAcceptAllFileFilterUsed(false);
                    fc.setFileView(new DotSerFileView());
                    fc.addChoosableFileFilter(new DotSerFileFilter());
                    int returnVal = fc.showSaveDialog(Main.this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = fc.getSelectedFile();
                        if (file != null) {
                            fileAbsolutePath = file.getAbsolutePath();
                            String ext = Main.getExtension(file);
                            if (ext == null) {
                                fileAbsolutePath += ".ser";
                            }
                        }
                        askFilePath = false;
                    }
                }
                if (fileAbsolutePath != null) {
                    try {
                        FileOutputStream fileStream = new FileOutputStream(fileAbsolutePath);
                        ObjectOutputStream os = new ObjectOutputStream(fileStream);
                        os.writeObject(snake_state);
                        os.close();
                        save_game_button.setText("GAME SAVED");
                        save_game_button.setEnabled(false);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ).start();
    }//GEN-LAST:event_save_game_buttonActionPerformed

    private void load_game_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_game_buttonActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                final JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                fc.setAcceptAllFileFilterUsed(false);
                fc.setFileView(new DotSerFileView());
                fc.addChoosableFileFilter(new DotSerFileFilter());
                int returnVal = fc.showOpenDialog(Main.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    if (file != null) {
                        String Path = file.getAbsolutePath();
                        String ext = Main.getExtension(file);
                        if (ext == null) {
                            Path += ".ser";
                        }
                        try {
                            FileInputStream fileStream = new FileInputStream(Path);
                            ObjectInputStream os = new ObjectInputStream(fileStream);
                            SnakeState snake_state = (SnakeState) os.readObject();
                            loadState(snake_state);

                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }
            }
        }).start();
    }//GEN-LAST:event_load_game_buttonActionPerformed

    private void pause_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pause_buttonActionPerformed
        if (pause_button.getActionCommand().equals("PAUSE")) {
            if (start_thread != null) {
                if (start_thread.isAlive()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            start_thread.suspend();
                            pause_button.setActionCommand("RESUME");
                            pause_button.setText("RESUME");
                            save_game_button.setEnabled(true);
                        }
                    }).start();

                }
            }
        } else if (pause_button.getActionCommand().equals("RESUME")) {
            if (start_thread != null) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        start_thread.resume();
                        pause_button.setActionCommand("PAUSE");
                        pause_button.setText("PAUSE");
                        save_game_button.setEnabled(false);
                        save_game_button.setText("SAVE GAME");
                    }
                }).start();
            }
        }
    }//GEN-LAST:event_pause_buttonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Thread.currentThread().setName("SWING UI THREAD");
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                Main main = new Main();
                main.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controls_panel;
    private javax.swing.JRadioButton hasBoundary_radio_button;
    private java.awt.Label label1;
    private javax.swing.JButton load_game_button;
    private javax.swing.JButton new_game_button;
    private javax.swing.JButton pause_button;
    private javax.swing.JButton save_game_button;
    private java.awt.Label score_label;
    private SnakePanel snake_panel;
    private javax.swing.JSlider snake_speed_slider;
    private java.awt.Label speed;
    private javax.swing.JButton start_button;
    // End of variables declaration//GEN-END:variables

    protected final class SnakePanel extends JPanel {

        private HashMap<String, Integer> food_xy = new HashMap<>();
        private final Random random = new Random();
        private AttributedString a = new AttributedString("😒😒😒");
        private Font boldFont = new Font("monospace", Font.PLAIN, 24);
        private AttributedCharacterIterator aci = null;

        public SnakePanel() {
            addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent input) {
                    changeSnakeDirection(input);
                }
            });
            setFocusable(true);
            initSnake();
            initLooper();
            a.addAttribute(TextAttribute.FONT, boldFont);
            aci = a.getIterator();
        }

        public void initSnake() {
            score = 0;
            CURR = RIGHT;
            isGameOver = false;
            if (score_label != null) {
                score_label.setText("SCORE: " + score);
            }
            if (snake != null) {
                snake.clear();
                snake.add(new Box(10, 10));
                snake.add(new Box(20, 10));
                snake.add(new Box(30, 10));
            }
            repaint();
        }

        public void increaseSnake(Box first) {
            snake.add(0, new Box(first.getX(), first.getY()));
            score += 1;
            snake_state.setScore(score);
            score_label.setText("SCORE: " + score);
        }

        public boolean checkBodyHit() {
            Box head = snake.get(snake.size() - 1);
            for (int i = snake.size() - 2; i >= 0; i--) {
                if (head.getX() >= snake.get(i).getX() && head.getX() <= snake.get(i).getX() + 9 && head.getY() >= snake.get(i).getY() && head.getY() <= snake.get(i).getY() + 9) {
                    return true;
                }
            }
            return false;
        }

        public boolean checkFoodHit() {
            Box head = snake.get(snake.size() - 1);
            return head.getX() >= food.getX() && head.getX() <= food.getX() + 9 && head.getY() >= food.getY() && head.getY() <= food.getY() + 9;
        }

        public boolean checkWallHit(boolean has_boundary) {
            Box head = snake.get(snake.size() - 1);
            if (has_boundary) {
                if (CURR.equals(RIGHT) ? head.getX() + border_width >= (width - border_width) : head.getX() >= (width - border_width)
                        || (CURR.equals(LEFT) ? head.getX() + border_width <= (border_width * 2) : head.getX() <= border_width - 1)
                        || (CURR.equals(TOP) ? head.getY() + border_width <= (border_width * 2) : head.getY() <= border_width - 1)
                        || (CURR.equals(BOTTOM) ? head.getY() >= (height - border_width * 2) : head.getY() >= (height + border_width - 1))) {

                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (!snake.isEmpty()) {
                for (int i = 0; i < snake.size(); i++) {
                    Box b = snake.get(i);
                    if (i == snake.size() - 1) {
                        g.fillOval(b.getX(), b.getY(), 10, 10);
                    }
                    g.drawOval(b.getX(), b.getY(), 10, 10);
                }
                if (checkFoodHit()) {
                    int x = random.nextInt(45) * 10;
                    int y = random.nextInt(45) * 10;
                    while (true) {
                        if (x <= 10 || y <= 10) {
                            x = random.nextInt(45) * 10;
                            y = random.nextInt(45) * 10;
                        } else {
                            break;
                        }
                    }
                    food_xy.put("X", x);
                    food_xy.put("Y", y);
                    snake_state.setFood_xy(food_xy);
                    food.setX(x);
                    food.setY(y);
                    increaseSnake(snake.get(0));
                    snake_state.setSnake(snake);
                }
                g.fillRect(food.getX(), food.getY(), 10, 10);
                if (isGameOver) {
                    g.drawString(aci, (int) (width / 2.3), (int) (height / 2.1));
                }
            }
        }

        public void initLooper() {
            initSnake();
            start_thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (checkBodyHit()) {
                            isGameOver = true;
                            start_button.setEnabled(false);
                            pause_button.setEnabled(false);
                            repaint();
                            break;
                        }
                        if (checkWallHit(has_boundary)) {
                            isGameOver = true;
                            start_button.setEnabled(false);
                            pause_button.setEnabled(false);
                            repaint();
                            break;
                        } else {
                            Box head = snake.get(snake.size() - 1);
                            if (null != CURR) {
                                switch (CURR) {
                                    case RIGHT:
                                        if (head.getX() >= width) {
                                            head.setX(0);
                                        }
                                        break;
                                    case LEFT:
                                        if (head.getX() <= 0) {
                                            head.setX(width);
                                        }
                                        break;
                                    case BOTTOM:
                                        if (head.getY() >= height) {
                                            head.setY(0);
                                        }
                                        break;
                                    case TOP:
                                        if (head.getY() <= 0) {
                                            head.setY(height);
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        buildSnake();
                        repaint();
                        try {
                            Thread.sleep(snake_speed);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        }

        private void buildSnake() {
            Box head = snake.get(snake.size() - 1);
            switch (CURR) {
                case RIGHT:
                    snake.add(new Box(head.getX() + 10, head.getY()));
                    break;
                case BOTTOM:
                    snake.add(new Box(head.getX(), head.getY() + 10));
                    break;
                case TOP:
                    snake.add(new Box(head.getX(), head.getY() - 10));
                    break;
                case LEFT:
                    snake.add(new Box(head.getX() - 10, head.getY()));
                    break;
                default:
                    break;
            }
            snake.remove(0);
        }

        private void changeSnakeDirection(java.awt.event.KeyEvent input) {
            switch (input.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    if (CURR.equals(RIGHT) || CURR.equals(LEFT)) {
                        CURR = BOTTOM;
                        snake_state.setSnake_direction(CURR);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (CURR.equals(RIGHT) || CURR.equals(LEFT)) {
                        CURR = TOP;
                        snake_state.setSnake_direction(CURR);
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (CURR.equals(BOTTOM) || CURR.equals(TOP)) {
                        CURR = LEFT;
                        snake_state.setSnake_direction(CURR);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (CURR.equals(BOTTOM) || CURR.equals(TOP)) {
                        CURR = RIGHT;
                        snake_state.setSnake_direction(CURR);
                    }
                    break;
                default:
                    CURR = RIGHT;
                    snake_state.setSnake_direction(CURR);
                    break;
            }
        }
    }
}
