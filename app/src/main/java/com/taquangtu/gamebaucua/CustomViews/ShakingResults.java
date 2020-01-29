package com.taquangtu.gamebaucua.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.taquangtu.gamebaucua.R;

import java.util.HashMap;

public class ShakingResults extends LinearLayout {
    public static HashMap<Integer,Integer> numberToResourceId;
    static {
        numberToResourceId = new HashMap<>();
        numberToResourceId.put(0,R.drawable.bau);
        numberToResourceId.put(1,R.drawable.cua);
        numberToResourceId.put(2,R.drawable.tom);
        numberToResourceId.put(3,R.drawable.ca);
        numberToResourceId.put(4,R.drawable.ga);
        numberToResourceId.put(5,R.drawable.nai);
    }
    private ImageView mImvRes1, mImvRes2, mImvRes3;
    public ShakingResults(Context context) {
        super(context);
    }
    public ShakingResults(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.view_shaking_results,this);
        mImvRes1 = view.findViewById(R.id.imvFirstResult);
        mImvRes2 = view.findViewById(R.id.imvSecondResult);
        mImvRes3 = view.findViewById(R.id.imvThirdResult);
    }
    public void presentData(int first, int second, int third){
        mImvRes1.setImageResource(numberToResourceId.get(first));
        mImvRes2.setImageResource(numberToResourceId.get(second));
        mImvRes3.setImageResource(numberToResourceId.get(third));
    }
}
