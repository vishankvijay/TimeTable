package com.example.timetable;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import android.R.anim;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class SujectEntryActivity extends Activity {

    ArrayList<String> list ;

    SubjectParcel subjectParcel = new SubjectParcel();
    private SubjectDAO subjectDAO;
    private AddEmpTask task;
    Context context = this;

    private AutoCompleteTextView subjectNameAutoCompleteTextView;
    private EditText descriptionEditText;
    private EditText roomNoEditText;
    Button startTimeButton;
    Button endTimeButton;
    Button selectColorButton;
    public String currentHourTextStart;
    public String currentMinuteTextStart;
    public String currentHourTextEnd;
    public String currentMinuteTextEnd;
    public String color;
    // EditText editTextTitle;

    int posVal;

    ActionBar actionBar;


    //String c[] = {"Vishank", "Shrehyu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suject_entry);
        list = new ArrayList<String>();

        Bundle bundlepassBundle = getIntent().getExtras();

        if (bundlepassBundle!= null){
            //list = bundlepassBundle.getStringArrayList("List");
        }




        list.add("Mom");


        subjectDAO = new SubjectDAO(this);
        Intent intent = getIntent();
        posVal = intent.getIntExtra("Position", 0);

        subjectNameAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.AutoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, list);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        subjectNameAutoCompleteTextView.setThreshold(1);
        subjectNameAutoCompleteTextView.setAdapter(adapter);

        descriptionEditText = (EditText) findViewById(R.id.editText2);
        roomNoEditText = (EditText) findViewById(R.id.editText3);
        startTimeButton = (Button) findViewById(R.id.button2);
        endTimeButton = (Button) findViewById(R.id.button3);
        selectColorButton = (Button) findViewById(R.id.selectColorButton);

        // addAutoCompleteTextView();

        // editTextTitle = (EditText) findViewById(R.id.editText1);

        actionBar = getActionBar();
        actionBar.setTitle("");
        actionBar.setIcon(android.R.color.transparent);
        // Intent intent=getIntent();
        // posVal=intent.getIntExtra("Position", 0);


        selectColorButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.color_picker);
                dialog.setTitle("        Select Color");

                Button redDarkButton = (Button) dialog.findViewById(R.id.button_red_dark);

                Button orangeDarkButton = (Button) dialog.findViewById( R.id.button_orange_dark);



                redDarkButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SujectEntryActivity.this , "WoW" , Toast.LENGTH_SHORT).show();

                        selectColorButton.setBackgroundColor(0xffF44336);
                        subjectParcel.setColor(0xffF44336);
                        dialog.dismiss();
                        //vishank(v);
                    }
                });

                orangeDarkButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectColorButton.setBackgroundColor(0xffFF9800);
                        subjectParcel.setColor(0xffFF9800);

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });



        // Listener of StartButton.
        startTimeButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                @SuppressWarnings("unused")
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.picker_time, null, false);

                final TimePicker myTimePicker = (TimePicker) view
                        .findViewById(R.id.timePicker1);

                new AlertDialog.Builder(SujectEntryActivity.this)
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

                                        currentHourTextStart = myTimePicker
                                                .getCurrentHour().toString();
                                        currentMinuteTextStart = myTimePicker
                                                .getCurrentMinute().toString();
                                        dialog.cancel();
                                        startTimeButton.setText("Starts\n"
                                                + currentHourTextStart + ":"
                                                + currentMinuteTextStart);

                                    }
                                }).show();

            }
        });

        // Listener of EndButton.
        endTimeButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                @SuppressWarnings("unused")
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.picker_time, null, false);

                final TimePicker myTimePicker = (TimePicker) view
                        .findViewById(R.id.timePicker1);

                new AlertDialog.Builder(SujectEntryActivity.this)
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

                                        currentHourTextEnd = myTimePicker
                                                .getCurrentHour().toString();
                                        currentMinuteTextEnd = myTimePicker
                                                .getCurrentMinute().toString();

                                        dialog.cancel();
                                        endTimeButton.setText("Ends\n"
                                                + currentHourTextEnd + ":"
                                                + currentMinuteTextEnd);

                                    }
                                }).show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.suject_entry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        int id = item.getItemId();
        if (item.getItemId() == R.id.cancel) {
            // Toast.makeText(this, ""+endTimeButton.getText(), 1000).show();
            Intent i = new Intent(this, ScrollActivity.class);
            // Intent intent=getIntent();
            // posVal=intent.getIntExtra("Position", 0);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("List", list);
            i.putExtras(bundle);
            i.putExtra("Position", posVal);
            i.putExtra("TrueVal", true);
            startActivity(i);
            finish();
        }

        if (item.getItemId() == R.id.save) {
            if (subjectNameAutoCompleteTextView.getText().toString().isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder = builder.setTitle("oops!!");
                builder.setMessage("You Must Enter a title before saving this event");

                builder.setNeutralButton("Ok",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                // TODO Auto-generated method stub
                                Log.d("VISHANKKKKKKKKK", "onClickkkkkkk");
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }

            else {
                setSubject();
                task = new AddEmpTask(this);
                task.execute((Void) null);
                Intent i = new Intent(this, ScrollActivity.class);
                i.putExtra("Position", posVal);
                i.putExtra("TrueVal", true);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("List", list);
                i.putExtras(i);
                //ScrollActivity scrollActivity = new ScrollActivity();
                //scrollActivity.setArguments(bundle);
                startActivity(i);


                finish();
            }

        }

        return super.onOptionsItemSelected(item);
    }

    private void setSubject() {

       // subjectParcel = new SubjectParcel();

        subjectParcel.setSubjectName(subjectNameAutoCompleteTextView.getText()
                .toString());
        list.add("subjectNameAutoCompleteTextView.getText().toString()");
        Log.d("Vishankkkkkk", "Working fine mom");

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //	android.R.layout.simple_dropdown_item_1line, list);
        //adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //subjectNameAutoCompleteTextView.setThreshold(1);
        //subjectNameAutoCompleteTextView.setAdapter(adapter);

        subjectParcel.setDescription(descriptionEditText.getText().toString());
        subjectParcel.setRoomNo(roomNoEditText.getText().toString());
        if (currentHourTextStart == null) {
            subjectParcel.setCurrentHourTextStart("10");
        } else {
            subjectParcel.setCurrentHourTextStart(currentHourTextStart
                    .toString());
        }

        if (currentMinuteTextStart == null) {
            subjectParcel.setCurrentMinuteTextStart("30");
        } else {
            subjectParcel.setCurrentMinuteTextStart(currentMinuteTextStart
                    .toString());
        }

        if (currentHourTextEnd == null) {
            subjectParcel.setCurrentHourTextEnd("11");
        } else {
            subjectParcel.setCurrentHourTextEnd(currentHourTextEnd.toString());
        }

        if (currentMinuteTextEnd == null) {
            subjectParcel.setCurrentMinuteTextEnd("30");
        } else {
            subjectParcel.setCurrentMinuteTextEnd(currentMinuteTextEnd
                    .toString());
        }

    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        // super.onBackPressed();
        Intent i = new Intent(this, ScrollActivity.class);
        i.putExtra("Position", posVal);
        i.putExtra("TrueVal", true);
        startActivity(i);
        finish();

    }

    public void addAutoCompleteTextView() {

    }

    public class AddEmpTask extends AsyncTask<Void, Void, Long> {

        private final WeakReference<Activity> activityWeakRef;

        public AddEmpTask(Activity context) {
            this.activityWeakRef = new WeakReference<Activity>(context);
        }

        @Override
        protected Long doInBackground(Void... arg0) {
            long result = 0;
            if (posVal == 0) {
                result = subjectDAO.saveMondaySubjects(subjectParcel);
            } else if (posVal == 1) {
                result = subjectDAO.saveTuesdaySubjects(subjectParcel);
            }

            else if (posVal == 2) {
                result = subjectDAO.saveWednesdaySubjects(subjectParcel);
            }

            else if (posVal == 3) {
                result = subjectDAO.saveThursdaySubjects(subjectParcel);
            }

            else if (posVal == 4) {
                result = subjectDAO.saveFridaySubjects(subjectParcel);
            }

            else if (posVal == 5) {
                result = subjectDAO.saveSaturdaySubjects(subjectParcel);
            }

            else if (posVal == 6) {
                result = subjectDAO.saveSundaySubjects(subjectParcel);
            }
            return result;
        }

        @Override
        protected void onPostExecute(Long result) {
            if (activityWeakRef.get() != null
                    && !activityWeakRef.get().isFinishing()) {
                if (result != -1)
                    Toast.makeText(activityWeakRef.get(), "Entry Saved",
                            Toast.LENGTH_LONG).show();
            }
        }
    }

}
