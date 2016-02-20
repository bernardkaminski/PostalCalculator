package com.example.bernie.postalcalculator;

/**
 * Created by Bernie on 19/02/2016.
 */
public enum ItemType {
    StampsInBookletsCoilsPanes("Stamps in booklets/coils/panes"),
    MeterPostalIndicia("Meter or Postal Indicia"),
    SingleStamp("Stamp(s)");

    private String text;
    private ItemType(String text){
        this.text=text;
    }
    @Override
    public String toString() {
        return text;
    }
}
