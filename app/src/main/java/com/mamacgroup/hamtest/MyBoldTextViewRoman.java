package com.mamacgroup.hamtest;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class MyBoldTextViewRoman extends android.widget.TextView {

    public MyBoldTextViewRoman(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
        appearance();
    }

    public MyBoldTextViewRoman(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyBoldTextViewRoman(Context context) {
        super(context);
        init(context);
    }
    public void  appearance(){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        this.setLayoutParams(params);
//        this.setTextSize(getResources().getDimension(R.dimen.material_micro_text_size));
        this.setLineSpacing(-10,1);
//        this.setGravity(Gravity.CENTER_VERTICAL);
//        this.setTextColor(getResources().getColor(R.color.white));
//        this.setText("Not Started");
    }
    private void init(Context context) {

        if (!isInEditMode()) {

                Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/helvetica-black-semibold.ttf");
                setTypeface(tf);
            }

    }




}