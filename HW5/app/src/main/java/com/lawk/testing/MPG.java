package com.lawk.testing;

import android.content.Context;

import java.text.DecimalFormat;

public class MPG {
    public final static double UNLEADED = 3.85;
    public final static double PLUS = 3.95;
    public final static double PREMIUM = 4.05;

    private int miles;
    private int mpg;


    public MPG(int miles, int mpg){
        if (miles <1) {
            miles = 1;
        }
        if (mpg < 1) {
            mpg = 1;
        }
        this.miles = miles;
        this.mpg = mpg;
    }
    public MPG(Context context) {
        String milesString = context.getString(R.string.miles);
        String mpgString = context.getString(R.string.mpg);

        this.miles = Integer.parseInt(milesString);
        this.mpg = Integer.parseInt(mpgString);

    }
    public int getMiles() {
        return this.miles;
    }
    public int getMPG() {
        return this.mpg;
    }

    public double calculateCost(String octane) {
        double costs;

        if (octane.equals("Unleaded")) {
            costs = (UNLEADED * miles) / mpg;
        } else if (octane.equals("Plus")) {
            costs = (PLUS * miles) / mpg;
        } else {
            costs = (PREMIUM * miles) /mpg;
        }

        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(costs));

    }



}
