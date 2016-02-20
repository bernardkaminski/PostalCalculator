package com.example.bernie.postalcalculator;


import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import junit.framework.Assert;

/**
 * Created by Bernie on 19/02/2016.
 */
public class CalculatorTest extends ActivityInstrumentationTestCase2<MainActivity>
{

    Activity activity;

    private EditText weight;
    private Spinner country;
    private Spinner category;
    private Spinner itemType;
    private Button calculateButton;

    public CalculatorTest()
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
    }



    // This tests invalid inputs for weight. Country, category, and item type have a default value by design
    // so it would be impossible to set it to any other value than the ones present in the drop down
    @UiThreadTest
    public void testInvalidParams()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // US or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // US or International
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes"); // US or International
        itemType.setSelection(position3);

        weight.setText("-1"); // Set weight to a negative number. Also possible to set it to letters

        calculateButton.performClick();

        assertEquals(-1.0, Calculator.calcStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString())));
    }

        public void tearDown() throws Exception
    {
        activity.finish();
    }


}
