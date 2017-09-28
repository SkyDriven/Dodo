package com.example.codetribe.firebaselogindemo.Helper;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by codetribe on 9/18/2017.
 */

public class Helper {
    public static  final String NAME = "Name";

    public static  final String EMAIL = "Email";

    public static  final String BIRTHDAY = "Birthday";

    public static  final String PHONE_NUMBER = "Phone Number";

    public static  final String HOBBY_INTEREST = "Hobby & Interest";

    public static  final int SELECT_PICTURE = 2000;

    public static  final boolean isValidEmail( String email){
        if(email.contains("@"))
        {
            return true;
        }
        return false;
    }

    public  static  void displayMessageToast(Context context, String displayMessage)
    {
        Toast.makeText(context,displayMessage,Toast.LENGTH_LONG).show();
    }
}
