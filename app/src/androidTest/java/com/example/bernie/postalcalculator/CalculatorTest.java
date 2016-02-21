package com.example.bernie.postalcalculator;


import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import junit.framework.Assert;

/**
 * Created by Bernie on 19/02/2016.
 */
public class CalculatorTest extends ActivityInstrumentationTestCase2<MainActivity>
{

    Activity activity;

    private EditText weight;
    private EditText width;
    private EditText height;
    private EditText length;
    private Spinner country;
    private Spinner category;
    private Spinner itemType;
    private Button calculateButton;
    private TextView cost;

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
        width = (EditText) activity.findViewById(R.id.width);
        height = (EditText) activity.findViewById(R.id.height);
        length = (EditText) activity.findViewById(R.id.length);
        cost = (TextView) activity.findViewById(R.id.resulting_cost);
    }

    public void tearDown() throws Exception
    {
        activity.finish();
    }

    // This tests invalid inputs for weight. Country, category, and item type have a default value by design
    // so it would be impossible to set it to any other value than the ones present in the drop down
    @UiThreadTest
    public void testInvalidParamsStandardCanada()
    {
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

        weight.setText("-1");
        width.setText("10");
        height.setText("0.3");
        length.setText("20");

        calculateButton.performClick();

        assertEquals(-2.0, Calculator.calcStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid parameters", cost.getText().toString());

    }

    // This tests invalid inputs for weight. Country, category, and item type have a default value by design
    // so it would be impossible to set it to any other value than the ones present in the drop down
    @UiThreadTest
    public void testInvalidParamsNonStandardCanada()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("-1");
        width.setText("10");
        height.setText("0.3");
        length.setText("20.0");

        calculateButton.performClick();

        assertEquals(-2.0, Calculator.calcNonStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid parameters", cost.getText().toString());
    }

    // This tests invalid inputs for weight. Country, category, and item type have a default value by design
    // so it would be impossible to set it to any other value than the ones present in the drop down
    @UiThreadTest
    public void testInvalidParamsLetterPostUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, USA, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("-1");
        width.setText("10");
        height.setText("0.3");
        length.setText("20.0");
        calculateButton.performClick();

        assertEquals(-2.0, Calculator.calcLetterPostInUS(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
    }

    // This tests invalid inputs for weight. Country, category, and item type have a default value by design
    // so it would be impossible to set it to any other value than the ones present in the drop down
    @UiThreadTest
    public void testInvalidParamsOtherPostUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("-1");
        width.setText("10");
        height.setText("0.3");
        length.setText("20.0");

        calculateButton.performClick();

        assertEquals(-2.0, Calculator.calcOtherInUS(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid parameters", cost.getText().toString());
    }

    // This tests invalid inputs for weight. Country, category, and item type have a default value by design
    // so it would be impossible to set it to any other value than the ones present in the drop down
    @UiThreadTest
    public void testInvalidParamsLetterPostInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, USA, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("-1");
        width.setText("10");
        height.setText("0.3");
        length.setText("20.0");

        calculateButton.performClick();

        assertEquals(-2.0, Calculator.calcLetterPostInternational(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid parameters", cost.getText().toString());
    }

    // This tests invalid inputs for weight. Country, category, and item type have a default value by design
    // so it would be impossible to set it to any other value than the ones present in the drop down
    @UiThreadTest
    public void testInvalidParamsOtherPostInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, USA, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("-1");
        width.setText("10");
        height.setText("0.3");
        length.setText("20.0");

        calculateButton.performClick();

        assertEquals(-2.0, Calculator.calcOtherPostInternational(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid parameters", cost.getText().toString());
    }

    @UiThreadTest
    public void testInvalidHeightStandardCanada()
    {
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

        weight.setText("10");
        width.setText("10");
        height.setText("-1");
        length.setText("20");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidHeightNonStandardCanada()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("10");
        height.setText("-1");
        length.setText("20");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcNonStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidHeightStandardUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("10");
        height.setText("-1");
        length.setText("20");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidHeightNonStandardUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("10");
        height.setText("-1");
        length.setText("20");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcOtherInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidHeightStandardInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("10");
        height.setText("-1");
        length.setText("20");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidHeightNonStandardInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("10");
        height.setText("-1");
        length.setText("20");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidWidthStandardCanada()
    {
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

        weight.setText("10");
        width.setText("-1");
        height.setText("0.3");
        length.setText("20");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidWidthNonStandardCanada()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("-1");
        height.setText("0.3");
        length.setText("20");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcNonStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidWidthStandardUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("-1");
        height.setText("0.3");
        length.setText("20");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidWidthNonStandardUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("-1");
        height.setText("0.3");
        length.setText("20");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidWidthStandardInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("-1");
        height.setText("0.3");
        length.setText("20");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }


    @UiThreadTest
    public void testInvalidWidthNonStandardInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("-1");
        height.setText("0.3");
        length.setText("20");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidLengthStandardCanada()
    {
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

        weight.setText("10");
        width.setText("10");
        height.setText("0.3");
        length.setText("-1");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidLengthNonStandardCanada()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("10");
        height.setText("0.3");
        length.setText("-1");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcNonStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidLengthStandardUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("10");
        height.setText("0.3");
        length.setText("-1");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }


    @UiThreadTest
    public void testInvalidLengthNonStandardUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("10");
        height.setText("0.3");
        length.setText("-1");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidLengthStandardInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("10");
        height.setText("0.3");
        length.setText("-1");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testInvalidLengthNonStandardInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        weight.setText("10");
        width.setText("10");
        height.setText("0.3");
        length.setText("-1");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcOtherPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testWeightOutOfRangeStandardCanada()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("10");
        height.setText("0.3");
        length.setText("20.0");
        weight.setText("501");

        calculateButton.performClick();

        assertEquals(-1.0, Calculator.calcStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid parameters", cost.getText().toString());

    }

    @UiThreadTest
    public void testWeightOutOfRangeNonStandardCanada()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        width.setText("10");
        height.setText("0.3");
        length.setText("20.0");
        weight.setText("501");

        calculateButton.performClick();

        assertEquals(-1.0, Calculator.calcNonStandardInCanada(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid parameters", cost.getText().toString());
    }

    @UiThreadTest
    public void testWeightOutOfRangeLetterUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        width.setText("10");
        height.setText("0.3");
        length.setText("20.0");
        weight.setText("501");

        calculateButton.performClick();

        assertEquals(-1.0, Calculator.calcLetterPostInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid parameters", cost.getText().toString());
    }

    @UiThreadTest
    public void testWeightOutOfRangeOtherUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        width.setText("10");
        height.setText("0.3");
        length.setText("20.0");
        weight.setText("501");

        calculateButton.performClick();

        assertEquals(-1.0, Calculator.calcOtherInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid parameters", cost.getText().toString());
    }

    @UiThreadTest
    public void testWeightOutOfRangePostInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        width.setText("10");
        height.setText("0.3");
        length.setText("20.0");
        weight.setText("501");

        calculateButton.performClick();

        assertEquals(-1.0, Calculator.calcLetterPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid parameters", cost.getText().toString());
    }

    @UiThreadTest
    public void testWeightOutOfRangeOtherPostInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        width.setText("10");
        height.setText("0.3");
        length.setText("20.0");
        weight.setText("501");

        calculateButton.performClick();

        assertEquals(-1.0, Calculator.calcOtherPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid parameters", cost.getText().toString());
    }

    @UiThreadTest
    public void testLengthOutOfRangeStandardCanada()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("10");
        height.setText("0.3");
        length.setText("38.2");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid size", cost.getText().toString());
    }

    @UiThreadTest
    public void testLengthOutOfRangeNonStandardCanada()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("10");
        height.setText("0.3");
        length.setText("38.2");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcNonStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testLengthOutOfRangeStandardUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("10");
        height.setText("0.3");
        length.setText("38.2");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testLengthOutOfRangeNonStandardUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("10");
        height.setText("0.3");
        length.setText("38.2");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcOtherInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testLengthOutOfRangeStandardInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("10");
        height.setText("0.3");
        length.setText("38.2");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testLengthOutOfRangeNonStandardInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        width.setText("10");
        height.setText("0.3");
        length.setText("38.2");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcOtherPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());

    }


    @UiThreadTest
    public void testHeightOutOfRangeStandardCanada()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("10");
        height.setText("2.3");
        length.setText("20.0");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testHeightOutOfRangeNonStandardCanada()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("10");
        height.setText("2.3");
        length.setText("20.0");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcNonStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testHeightOutOfRangeStandardUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("10");
        height.setText("2.3");
        length.setText("20.0");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testHeightOutOfRangeNonStandardUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("10");
        height.setText("2.3");
        length.setText("20.0");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcOtherInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testHeightOutOfRangeStandardInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        width.setText("10");
        height.setText("2.3");
        length.setText("20.0");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());
    }

    @UiThreadTest
    public void testHeightOutOfRangeNonStandardInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        width.setText("10");
        height.setText("2.3");
        length.setText("20.0");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcOtherPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());
    }

    @UiThreadTest
    public void testWidthOutOfRangeStandardCanada()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("27.1");
        height.setText("0.3");
        length.setText("20.0");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testWidthOutOfRangeNonStandardCanada()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("Canada"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("27.1");
        height.setText("0.3");
        length.setText("20.0");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcNonStandardInCanada(ItemType.StampsInBookletsCoilsPanes, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testWidthOutOfRangeStandardUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("27.1");
        height.setText("0.3");
        length.setText("20.0");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testWidthOutOfRangeNonStandardUS()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("US"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);


        width.setText("27.1");
        height.setText("0.3");
        length.setText("20.0");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcOtherInUS(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));

        assertEquals("invalid size", cost.getText().toString());

    }

    @UiThreadTest
    public void testWidthOutOfRangeStandardInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Standard Letter-Post"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        width.setText("27.1");
        height.setText("0.3");
        length.setText("20.0");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcLetterPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());
    }

    @UiThreadTest
    public void testWidthOutOfRangeNonStandardInternational()
    {
        // This is how you set the value of a spinner
        ArrayAdapter adapter = (ArrayAdapter) country.getAdapter();
        int position = adapter.getPosition("International"); // Canada, US, or International
        country.setSelection(position);

        ArrayAdapter adapter2 = (ArrayAdapter) category.getAdapter();
        int position2 = adapter2.getPosition("Other"); // Standard Letter-Post or Other
        category.setSelection(position2);

        ArrayAdapter adapter3 = (ArrayAdapter) itemType.getAdapter();
        int position3 = adapter3.getPosition("Stamps in booklets/coils/panes");
        itemType.setSelection(position3);

        width.setText("27.1");
        height.setText("0.3");
        length.setText("20.0");
        weight.setText("10");

        calculateButton.performClick();

        assertEquals(-3.0, Calculator.calcOtherPostInternational(ItemType.SingleStamp, Double.valueOf(weight.getText().toString()),
                Double.valueOf(length.getText().toString()), Double.valueOf(width.getText().toString()), Double.valueOf(height.getText().toString())));
        assertEquals("invalid size", cost.getText().toString());
    }
}
