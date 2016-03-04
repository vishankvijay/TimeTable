package com.example.timetable;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class UpdateActivity extends Activity {

    ActionBar update_actionBar;

    SubjectParcel subjectParcel;

    TextView UpdateAutoCompleteTextView;
    Button UpdateColorButton;
    Button UpdateStartButton;
    Button UpdateEndButton;
    EditText UpdateClassRoomEdittext;
    EditText UpdateDescriptionEdittext;
    int posVal;
    public String updateCurrentHourTextStart;
    public String updateCurrentMinuteTextStart;
    public String updateCurrentHourTextEnd;
    public String updateCurrentMinuteTextEnd;

    SubjectDAO subjectDAO;

    // int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        subjectDAO = new SubjectDAO(this);

        Bundle bundle = getIntent().getExtras();
        subjectParcel = bundle.getParcelable("All");
        posVal = bundle.getInt("Day");

        // Toast.makeText(this, ""+day, 1000).show();

        UpdateAutoCompleteTextView = (TextView) findViewById(R.id.AutoCompleteUpdateTextView);
        UpdateDescriptionEdittext = (EditText) findViewById(R.id.UpdateDescriptionEdittext);
        UpdateClassRoomEdittext = (EditText) findViewById(R.id.UpdateClassRoomEdittext);
        UpdateColorButton = (Button) findViewById(R.id.UpdateColorButton);
        UpdateStartButton = (Button) findViewById(R.id.UpdateStartButton);
        UpdateEndButton = (Button) findViewById(R.id.UpdateEndButton);

        setValue();

        update_actionBar = getActionBar();
        update_actionBar.setTitle("");
        update_actionBar.setIcon(android.R.color.transparent);

        UpdateStartButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                @SuppressWarnings("unused")
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.picker_time, null, false);

                final TimePicker myTimePicker = (TimePicker) view
                        .findViewById(R.id.timePicker1);

                new AlertDialog.Builder(UpdateActivity.this)
                        .setView(view)
                        .setTitle("Choose Start Time")
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        // TODO Auto-generated method stub

                                    }
                                })
                        .setPositiveButton("Set",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        // TODO Auto-generated method stub

                                        subjectParcel
                                                .setCurrentHourTextStart(myTimePicker
                                                        .getCurrentHour()
                                                        .toString());
                                        subjectParcel
                                                .setCurrentMinuteTextStart(myTimePicker
                                                        .getCurrentMinute()
                                                        .toString());
                                        dialog.cancel();
                                        UpdateStartButton.setText("Starts\n"
                                                + subjectParcel
                                                .getCurrentHourTextStart()
                                                + ":"
                                                + subjectParcel
                                                .getCurrentMinuteTextStart());

                                    }
                                }).show();

            }
        });

        // Listener of EndButton.
        UpdateEndButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                @SuppressWarnings("unused")
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.picker_time, null, false);

                final TimePicker myTimePicker = (TimePicker) view
                        .findViewById(R.id.timePicker1);

                new AlertDialog.Builder(UpdateActivity.this)
                        .setView(view)
                        .setTitle("Choose End Time")
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        // TODO Auto-generated method stub

                                    }
                                })
                        .setPositiveButton("Set",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        // TODO Auto-generated method stub

                                        subjectParcel
                                                .setCurrentHourTextEnd(myTimePicker
                                                        .getCurrentHour()
                                                        .toString());
                                        subjectParcel
                                                .setCurrentMinuteTextEnd(myTimePicker
                                                        .getCurrentMinute()
                                                        .toString());

                                        dialog.cancel();
                                        UpdateEndButton.setText("Ends\n"
                                                + subjectParcel
                                                .getCurrentHourTextEnd()
                                                + ":"
                                                + subjectParcel
                                                .getCurrentMinuteTextEnd());

                                    }
                                }).show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        getMenuInflater().inflate(R.menu.update, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        if (item.getItemId() == R.id.cancel) {
            Intent i = new Intent(this, ScrollActivity.class);
            i.putExtra("Position", posVal);
            i.putExtra("TrueVal", true);

            startActivity(i);
            finish();

        }

        if (item.getItemId() == R.id.update) {
            if (UpdateAutoCompleteTextView.getText().toString().isEmpty()) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder = builder.setTitle("oops!!");
                builder.setMessage("You Must Enter a title before saving this event");

                builder.setNeutralButton("Ok",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                // dialog.cancel();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();

            } else {
                subjectParcel.setSubjectName(UpdateAutoCompleteTextView
                        .getText().toString());
                subjectParcel.setRoomNo(UpdateClassRoomEdittext.getText()
                        .toString());
                subjectParcel.setDescription(UpdateDescriptionEdittext
                        .getText().toString());
                long result = 0;
                if (posVal == 0) {
                    result = subjectDAO.updateMondayEntry(subjectParcel);
                }

                else if (posVal == 1) {

                    result = subjectDAO.updateTuesdayEntry(subjectParcel);
                }

                else if (posVal == 2) {

                    result = subjectDAO.updateWednesdayEntry(subjectParcel);
                }

                else if (posVal == 3) {

                    result = subjectDAO.updateThursdayEntry(subjectParcel);
                }

                else if (posVal == 4) {

                    result = subjectDAO.updateFridayEntry(subjectParcel);
                }

                else if (posVal == 5) {

                    result = subjectDAO.updateSaturdayEntry(subjectParcel);
                }

                else if (posVal == 6) {

                    result = subjectDAO.updateSundayEntry(subjectParcel);
                }
                if (result > 0) {

                    Intent i = new Intent(this, ScrollActivity.class);
                    i.putExtra("Position", posVal);
                    i.putExtra("TrueVal", true);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Update Done", 1000)
                            .show();
                    finish();
                }

            }

        }

        return super.onOptionsItemSelected(item);
    }

    private void setValue() {
        if (subjectParcel != null) {

            UpdateDescriptionEdittext.setText(subjectParcel.getDescription()
                    + "");
            UpdateAutoCompleteTextView.setText(subjectParcel.getSubjectName()
                    + "");
            UpdateClassRoomEdittext.setText(subjectParcel.getRoomNO() + "");
            UpdateStartButton.setText("Starts\n"
                    + subjectParcel.getCurrentHourTextStart() + ":"
                    + subjectParcel.getCurrentMinuteTextStart());
            UpdateEndButton.setText("Starts\n"
                    + subjectParcel.getCurrentHourTextEnd() + ":"
                    + subjectParcel.getCurrentMinuteTextEnd());

        }
    }

}
