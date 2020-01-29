package com.taquangtu.gamebaucua;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Random;

public class Shaker {
    public Shaker(){

    }
    public int[] shake(int without){
        int results[] = new int[3];
        int res =  0;
        for(int i=0;i<3;i++){
            do{
                res = new Random().nextInt(6);
                results[i] = res;
            }while (res==without);
        }
        return results;
    }
}
