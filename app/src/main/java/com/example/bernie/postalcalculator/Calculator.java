package com.example.bernie.postalcalculator;

/**
 * Created by Bernie on 19/02/2016.
 */
public class Calculator {

    private Calculator()
    {

    }
    public static double calcStandardInCanada(ItemType type, double weight,double length,double width, double height)
    {
        if(!Calculator.isValid(length, width, height, true))
            return -3;
        switch (type){
            case StampsInBookletsCoilsPanes:
                if(weight > 50)
                    return -1;
                if(weight > 30)
                    return 1.20;
                if(weight >0)
                    return .85;
                return -2;
            case MeterPostalIndicia:
                if(weight > 50)
                    return -1;
                if(weight > 30)
                    return 1.19;
                if(weight >0)
                    return .80;
                return -2;
            case SingleStamp:
                if(weight > 50)
                    return -1;
                if(weight > 30)
                    return 1.20;
                if(weight >0)
                    return 1.00;
                return -2;
            default:
                return -2;
        }

    }

    public static double calcNonStandardInCanada(ItemType type, double weight,double length,double width, double height)
    {
        if(!Calculator.isValid(length, width, height, false))
            return -3;
        switch (type){
            case MeterPostalIndicia:
                if(weight > 500)
                    return -1;
                if(weight > 400)
                    return 4.74;
                if(weight >300)
                    return 4.42;
                if(weight >200)
                    return 4.89;
                if(weight >100)
                    return 2.77;
                if(weight >0)
                    return 1.71;
                return -2;
            case SingleStamp:
                if(weight > 500)
                    return -1;
                if(weight > 400)
                    return 5.05;
                if(weight >300)
                    return 4.70;
                if(weight >200)
                    return 4.10;
                if(weight >100)
                    return 2.95;
                if(weight >0)
                    return 1.80;
                return -2;
            default:
                return -2;
        }
    }

    public static double calcLetterPostInUS(ItemType type, double weight,double length,double width, double height)
    {
        if(!Calculator.isValid(length, width, height, true))
            return -3;

        switch (type){

            case MeterPostalIndicia:
                if(weight > 50)
                    return -1;
                if(weight > 30)
                    return 1.72;
                if(weight >0)
                    return 1.19;
                return -2;
            case SingleStamp:
                if(weight > 50)
                    return -1;
                if(weight > 30)
                    return 1.80;
                if(weight >0)
                    return 1.19;
                return -2;
            default:
                return -2;
        }
    }

    public static double calcOtherInUS(ItemType type, double weight,double length,double width, double height)
    {
        if(!Calculator.isValid(length, width, height, false))
            return -3;
        switch (type){
            case MeterPostalIndicia:
                if(weight > 500)
                    return -1;
                if(weight > 200)
                    return 9.69;
                if(weight >100)
                    return 4.85;
                if(weight >0)
                    return 2.68;
                return -2;
            case SingleStamp:
                if(weight > 500)
                    return -1;
                if(weight > 200)
                    return 10.30;
                if(weight >100)
                    return 5.15;
                if(weight >0)
                    return 2.95;
                return -2;
            default:
                return -2;
        }
    }

    public static double calcLetterPostInternational(ItemType type, double weight,double length,double width, double height)
    {
        if(!Calculator.isValid(length, width, height, true))
            return -3;
        switch (type){

            case MeterPostalIndicia:
                if(weight > 50)
                    return -1;
                if(weight > 30)
                    return 3.42;
                if(weight >0)
                    return 2.36;
                return -2;
            case SingleStamp:
                if(weight > 50)
                    return -1;
                if(weight > 30)
                    return 3.60;
                if(weight >0)
                    return 2.50;
                return -2;
            default:
                return -2;
        }

    }

    public static double calcOtherPostInternational(ItemType type, double weight,double length,double width, double height)
    {
        if(!Calculator.isValid(length, width, height, false))
            return -3;
        switch (type){
            case SingleStamp:
                if(weight > 500)
                    return -1;
                if(weight > 200)
                    return 20.60;
                if(weight >100)
                    return 10.30;
                if(weight >0)
                    return 5.90;
                return -2;
            case MeterPostalIndicia:
                if(weight > 500)
                    return -1;
                if(weight > 200)
                    return 19.39;
                if(weight >100)
                    return 9.69;
                if(weight >0)
                    return 5.56;
                return -2;
            default:
                return -2;
        }
    }

    public static boolean isValid(double length,double width, double height, boolean regular )
    {
        if(length<=0 || width <=0 || height <=0 )
            return false;
        if(regular)
        {
            if(length<=24.5 && width <=15.6 && height <= .5 )
                return true;
            else
                return false;
        }
        else
        {
            if(length<=38 && width <=27 && height <= 2 )
                return true;
            else
                return false;
        }
    }
}
