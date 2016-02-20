package com.example.bernie.postalcalculator;


import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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

    public void tearDown() throws Exception
    {
        activity.finish();
    }

    @UiThreadTest
    public void testNotEnoughParams()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // US or International
        country.setSelection(position);

    }


}
