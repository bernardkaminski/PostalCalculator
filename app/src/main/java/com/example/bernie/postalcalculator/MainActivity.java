package com.example.bernie.postalcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerOptionCountry;
    private Spinner spinnerOptionItemType;
    private Spinner spinnerOptionCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        populateSpinners();
    }

    private void populateSpinners () {

        // Grab all the views
        spinnerOptionCountry = (Spinner) findViewById(R.id.spinnerCountry);
        spinnerOptionItemType = (Spinner) findViewById(R.id.spinnerItemType);
        spinnerOptionCategory = (Spinner) findViewById(R.id.spinnerCategory);
        // Use default spinner adapters to populate each spinner with array from strings.xml

        ArrayAdapter<CharSequence> adapterSpinnerCountry = ArrayAdapter.createFromResource(
                this,
                R.array.homescreen_array_options_country, android.R.layout.simple_spinner_item
        );
        adapterSpinnerCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptionCountry.setAdapter(adapterSpinnerCountry);

        ArrayAdapter<CharSequence> adapterSpinnerItemType = ArrayAdapter.createFromResource(
                this,
                R.array.homescreen_array_options_item_type, android.R.layout.simple_spinner_item
        );
        adapterSpinnerItemType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptionItemType.setAdapter(adapterSpinnerItemType);

        ArrayAdapter<CharSequence> adapterSpinnerCatagory = ArrayAdapter.createFromResource(
                this,
                R.array.homescreen_array_options_category, android.R.layout.simple_spinner_item
        );
        adapterSpinnerCatagory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptionCategory.setAdapter(adapterSpinnerCatagory);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCalculateClick(View view)
    {
        spinnerOptionCountry = (Spinner) findViewById(R.id.spinnerCountry);
        spinnerOptionItemType = (Spinner) findViewById(R.id.spinnerItemType);
        spinnerOptionCategory = (Spinner) findViewById(R.id.spinnerCategory);
        String country =spinnerOptionCountry.getSelectedItem().toString();
        String type = spinnerOptionItemType.getSelectedItem().toString();
        String category = spinnerOptionCategory.getSelectedItem().toString();
        double weight = -1;
        EditText ed = (EditText)findViewById(R.id.editText);
        String text =ed.getText().toString();
        if(text.length()>0)
                weight= Double.parseDouble(text);

        double length=0;
        EditText l = (EditText)findViewById(R.id.length);
        String len =l.getText().toString();
        if(len.length()>0)
            length= Double.parseDouble(len);

        double width=0;
        EditText w = (EditText)findViewById(R.id.width);
        String wid =w.getText().toString();
        if(len.length()>0)
            width= Double.parseDouble(wid);

        double height=0;
        EditText h = (EditText)findViewById(R.id.height);
        String hei =h.getText().toString();
        if(len.length()>0)
            height= Double.parseDouble(hei);



        ItemType item=null;
        if(type.equals("Stamps in booklets/coils/panes"))
        {
            item = ItemType.StampsInBookletsCoilsPanes;
        }
        else if(type.equals("Meter or Postal Indicia")){
            item = ItemType.MeterPostalIndicia;
        }
        else if(type.equals("Stamp(s)")){
            item = ItemType.SingleStamp;
        }
        double cost=-1;
        if(category.equals("Standard Letter-Post")){
            if(country.equals("Canada"))
                cost = Calculator.calcStandardInCanada(item,weight,length, width, height);
            if(country.equals("US"))
                cost = Calculator.calcLetterPostInUS(item, weight,length, width, height);
            if(country.equals("International"))
                cost = Calculator.calcLetterPostInternational(item, weight,length, width, height);

        }
        else if(category.equals("Other")){
            if(country.equals("Canada"))
                cost = Calculator.calcNonStandardInCanada(item, weight,length, width, height);
            if(country.equals("US"))
                cost = Calculator.calcOtherInUS(item, weight,length, width, height);
            if(country.equals("International"))
                cost = Calculator.calcOtherPostInternational(item, weight,length, width, height);

        }

        TextView costDisplay = (TextView)findViewById(R.id.resulting_cost);
        if(cost == -1 || cost == -2)
            costDisplay.setText("invalid parameters");
        else if (cost == -3)
            costDisplay.setText("invalid size");
        else
            costDisplay.setText(Double.toString(cost));





    }
}
