/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamu.snake;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Harinath
 */
public class SnakeState implements Serializable {

    private int score;
    private int snake_speed;
    private boolean has_boundary;
    private HashMap<String,Integer> food_xy;
    private ArrayList<Box> snake;
    private String snake_direction;

    public String getSnake_direction() {
        return snake_direction;
    }

    public void setSnake_direction(String snake_direction) {
        this.snake_direction = snake_direction;
    }

    public int getSnake_speed() {
        return snake_speed;
    }

    public boolean isHas_boundary() {
        return has_boundary;
    }
    
    public ArrayList<Box> getSnake() {
        return snake;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public int getScore() {
       return score;
    }
    
    public HashMap<String, Integer> getFood_xy() {
        return food_xy;
    }

    public void setFood_xy(HashMap<String, Integer> food_xy) {
        this.food_xy = food_xy;
    }

    public void setSnake_speed(int snake_speed) {
        this.snake_speed = snake_speed;
    }

    public void setHas_boundary(boolean has_boundary) {
        this.has_boundary = has_boundary;
    }

    public void setSnake(ArrayList<Box> snake) {
        this.snake = snake;
    }
}
