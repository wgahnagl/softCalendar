package com.example.skyler.softcalendar;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.app.DialogFragment;
import android.app.Dialog;
import java.util.Calendar;
import android.widget.TimePicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    boolean endStart = false;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current time as the default values for the time picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);


        //Create and return a new instance of TimePickerDialog
        return new TimePickerDialog(getActivity(),this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    //onTimeSet() callback method
    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        //Do something with the user chosen time
        //Get reference of host activity (XML Layout File) TextView widget

        if (endStart){
            TextView timeTextView = (TextView) getActivity().findViewById(R.id.textViewStartTime);
            timeTextView.setText(String.valueOf(hourOfDay) + ":" +String.valueOf(minute));
        }
        else{
            TextView timeTextView = (TextView) getActivity().findViewById(R.id.textViewEndTime);
            timeTextView.setText(String.valueOf(hourOfDay) + ":" +String.valueOf(minute));
        }


        //Display the user changed time on TextView
    }
    public void setEndStart (boolean x){
        endStart = x;
    }

}