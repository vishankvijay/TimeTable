package com.example.timetable;


import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.Toast;

public class CustomUpdateDialog extends DialogFragment {
    public static final String ARG_ITEM_ID = "employee_list";
    private SubjectParcel subjectParcel;
    int day;
    private SubjectListAdapter subjectListAdapter;
    private SubjectDAO subjectDAO;
    ArrayList<SubjectParcel> subParcels;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        subjectDAO = new SubjectDAO(getActivity());
        subjectListAdapter = new SubjectListAdapter(getActivity(), subParcels);

        Bundle bundle = this.getArguments();
        subjectParcel = bundle.getParcelable("selectedEmployee");
        subParcels = bundle.getParcelableArrayList("array");

        //day = bundle.getInt("day");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Wait!");
        builder.setMessage("Delete the Selected Event??");

        builder.setCancelable(false);
        builder.setNegativeButton("Cancel", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();

            }
        });

        builder.setPositiveButton("Delete", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub


                subjectDAO.deleteMondayEntry(subjectParcel);
                subjectListAdapter.remove(subjectParcel);

            }
        });


        AlertDialog alertDialog = builder.create();


        return alertDialog;
    }

}
