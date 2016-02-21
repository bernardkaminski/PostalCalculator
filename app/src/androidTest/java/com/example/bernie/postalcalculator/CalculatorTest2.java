package com.example.bernie.postalcalculator;


import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class CalculatorTest2 extends ActivityInstrumentationTestCase2<MainActivity> {

    Activity activity;

    private EditText weight;
    private EditText width;
    private EditText height;
    private EditText length;
    private Spinner country;
    private Spinner category;
    private Spinner itemType;
    private Button calculateButton;
    private TextView cost ;

    public CalculatorTest2()
    {
        super(MainActivity.class);
    }

    public void setUp() throws Exception
    {
        super.setUp();
        activity = getActivity();
        calculateButton = (Button) activity.findViewById(R.id.button);
        country = (Spinner) activity.findViewById(R.id.spinnerCountry);
        category = (Spinner) activity.findViewById(R.id.spinnerCategory);
        itemType = (Spinner) activity.findViewById(R.id.spinnerItemType);
        weight = (EditText) activity.findViewById(R.id.editText);
        width = (EditText) activity.findViewById(R.id.width);
        height = (EditText) activity.findViewById(R.id.height);
        length = (EditText) activity.findViewById(R.id.length);
        cost = (TextView) activity.findViewById(R.id.resulting_cost);
    }

    public void tearDown() throws Exception
    {
        activity.finish();
    }


    @UiThreadTest
    public void testValidParamsStandardCanadaBookletUpTo30g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);
        weight.setText("25");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(.85, Calculator.calcStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(.85, costDouble);
    }
    @UiThreadTest
    public void testValidParamsStandardCanadaBookletUpTo50g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);
        weight.setText("50");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(1.2, Calculator.calcStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(1.2, costDouble);
    }

    @UiThreadTest
    public void testValidParamsStandardCanadaMeterUpTo30g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("25");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(.8, Calculator.calcStandardInCanada(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(.8, costDouble);
    }
    @UiThreadTest
    public void testValidParamsStandardCanadaMeterUpTo50g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("50");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(1.19, Calculator.calcStandardInCanada(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(1.19, costDouble);
    }

    @UiThreadTest
    public void testValidParamsStandardCanadaStampsUpTo30g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("25");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(1.0, Calculator.calcStandardInCanada(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(1.0, costDouble);
    }
    @UiThreadTest
    public void testValidParamsStandardCanadaStampsUpTo50g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("50");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(1.2, Calculator.calcStandardInCanada(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(1.2, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardCanadaStampsUpTo100g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("50");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(1.8, Calculator.calcNonStandardInCanada(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(1.8, costDouble);
    }
    @UiThreadTest
    public void testValidParamsNonStandardCanadaStampsUpTo200g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("200");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(2.95, Calculator.calcNonStandardInCanada(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(2.95, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardCanadaStampsUpTo300g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("300");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(4.10, Calculator.calcNonStandardInCanada(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(4.10, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardCanadaStampsUpTo400g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("400");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(4.70, Calculator.calcNonStandardInCanada(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(4.70, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardCanadaStampsUpTo500g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("500");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(5.05, Calculator.calcNonStandardInCanada(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(5.05, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardCanadaMeterUpTo100g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("100");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(1.71, Calculator.calcNonStandardInCanada(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(1.71, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardCanadaMeterUpTo200g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("200");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(2.77, Calculator.calcNonStandardInCanada(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(2.77, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardCanadaMeterUpTo300g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("300");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(3.89, Calculator.calcNonStandardInCanada(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(3.89, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardCanadaMeterUpTo400g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("400");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(4.42, Calculator.calcNonStandardInCanada(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(4.42, costDouble);
    }
    @UiThreadTest
    public void testValidParamsNonStandardCanadaMeterUpTo500g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("500");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(4.74, Calculator.calcNonStandardInCanada(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(4.74, costDouble);
    }

    @UiThreadTest
    public void testValidParamsStandardUSMeterUpTo30g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("25");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(1.19, Calculator.calcLetterPostInUS(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(1.19, costDouble);
    }
    @UiThreadTest
    public void testValidParamsStandardUSMeterUpTo50g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("50");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(1.72, Calculator.calcLetterPostInUS(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(1.72, costDouble);
    }

    @UiThreadTest
    public void testValidParamsStandardUSStampsUpTo30g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("25");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(1.20, Calculator.calcLetterPostInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(1.20, costDouble);
    }
    @UiThreadTest
    public void testValidParamsStandardUSStampsUpTo50g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("50");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(1.80, Calculator.calcLetterPostInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(1.8, costDouble);
    }
    @UiThreadTest
    public void testValidParamsNonStandardUSStampsUpTo100g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // US, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("50");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(2.95, Calculator.calcOtherInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(2.95, costDouble);
    }
    @UiThreadTest
    public void testValidParamsNonStandardUSStampsUpTo200g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // US, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("200");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(5.15, Calculator.calcOtherInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(5.15, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardUSStampsUpTo500g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // US, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("500");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(10.30, Calculator.calcOtherInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(10.30, costDouble);
    }
    @UiThreadTest
    public void testValidParamsNonStandardUSMeterUpTo100g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // US, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("100");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(2.68, Calculator.calcOtherInUS(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(2.68, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardUSMeterUpTo200g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // US, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("200");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(4.85, Calculator.calcOtherInUS(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(4.85, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardUSMeterUpTo500g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // US, US, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("500");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(9.69, Calculator.calcOtherInUS(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(9.69, costDouble);
    }

    ///////
    @UiThreadTest
    public void testValidParamsStandardInternationalMeterUpTo30g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, International, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("25");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(2.36, Calculator.calcLetterPostInternational(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(2.36, costDouble);
    }
    @UiThreadTest
    public void testValidParamsStandardInternationalMeterUpTo50g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, International, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("50");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(3.42, Calculator.calcLetterPostInternational(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(3.42, costDouble);
    }

    @UiThreadTest
    public void testValidParamsStandardInternationalStampsUpTo30g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, International, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("25");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(2.50, Calculator.calcLetterPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(2.50, costDouble);
    }
    @UiThreadTest
    public void testValidParamsStandardInternationalStampsUpTo50g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, International, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("50");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(3.60, Calculator.calcLetterPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(3.60, costDouble);
    }
    @UiThreadTest
    public void testValidParamsNonStandardInternationalStampsUpTo100g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // International, International, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("50");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(5.90, Calculator.calcOtherPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(5.90, costDouble);
    }
    @UiThreadTest
    public void testValidParamsNonStandardInternationalStampsUpTo200g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // International, International, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("200");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(10.30, Calculator.calcOtherPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(10.30, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardInternationalStampsUpTo500g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // International, International, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamp(s)");
        itemType.setSelection(position3);
        weight.setText("500");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(20.60, Calculator.calcOtherPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(20.60, costDouble);
    }
    @UiThreadTest
    public void testValidParamsNonStandardInternationalMeterUpTo100g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // International, International, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("100");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(5.56, Calculator.calcOtherPostInternational(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(5.56, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardInternationalMeterUpTo200g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // International, International, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("200");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(9.69, Calculator.calcOtherPostInternational(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(9.69, costDouble);
    }

    @UiThreadTest
    public void testValidParamsNonStandardInternationalMeterUpTo500g() {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // International, International, International
        country.setSelection(position);
        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);
        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Meter or Postal Indicia");
        itemType.setSelection(position3);
        weight.setText("500");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");
        calculateButton.performClick();
        assertEquals(19.39, Calculator.calcOtherPostInternational(ItemType.MeterPostalIndicia, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        double costDouble=0;
        String costString =cost.getText().toString();
        if(costString.length()>0)
            costDouble= Double.parseDouble(costString);
        assertEquals(19.39, costDouble);
    }


}
