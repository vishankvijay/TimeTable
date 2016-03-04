package com.example.timetable;

import java.lang.ref.WeakReference;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.EventLogTags.Description;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class FragmentMonday extends Fragment implements OnItemClickListener,
        OnItemLongClickListener {

    Activity activity;
    ListView subjectListView;
    ArrayList<SubjectParcel> subParcels;

    SubjectListAdapter subjectListAdapter;
    private SubjectDAO subjectDAO;
    private GetEmpTask task;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        subjectDAO = new SubjectDAO(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater
                .inflate(R.layout.fragment_monday, container, false);
        subjectListView = (ListView) view.findViewById(R.id.listViewMonday);
        subjectListView.setOnItemClickListener(this);
        subjectListView.setOnItemLongClickListener(this);

        task = new GetEmpTask(activity);
        task.execute((Void) null);

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public class GetEmpTask extends
            AsyncTask<Void, Void, ArrayList<SubjectParcel>> {

        private final WeakReference<Activity> activityWeakRef;

        public GetEmpTask(Activity context) {
            this.activityWeakRef = new WeakReference<Activity>(context);
        }

        @Override
        protected ArrayList<SubjectParcel> doInBackground(Void... arg0) {
            ArrayList<SubjectParcel> subjectList = subjectDAO
                    .getAllMondaySubjects();

            return subjectList;
        }

        @Override
        protected void onPostExecute(ArrayList<SubjectParcel> empList) {
            if (activityWeakRef.get() != null
                    && !activityWeakRef.get().isFinishing()) {
                subParcels = empList;
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("array", subParcels);
                if (empList != null) {
                    if (empList.size() != 0) {
                        subjectListAdapter = new SubjectListAdapter(activity,
                                empList);
                        subjectListView.setAdapter(subjectListAdapter);
                    } else {

                    }
                }

            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        SubjectParcel subjectParcel = (SubjectParcel) parent
                .getItemAtPosition(position);

        Intent intent = new Intent(getActivity(), UpdateActivity.class);

        Bundle bundle = new Bundle();
        bundle.putInt("Day", 0);
        bundle.putParcelable("All", subjectParcel);

        intent.putExtras(bundle);

        startActivity(intent);
        getActivity().finish();


    }

    public boolean onItemLongClick(AdapterView<?> parent, View view,
                                   int position, long arg3) {

        final SubjectParcel employee = (SubjectParcel) parent
                .getItemAtPosition(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Wait!!");

        builder.setMessage("Delete the Selected Subject");

        builder.setNegativeButton("Cancel", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.cancel();

            }
        });

        builder.setPositiveButton("Delete", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub

                // Use AsyncTask to delete from database
                subjectDAO.deleteMondayEntry(employee);
                subjectListAdapter.remove(employee);
                Toast.makeText(getActivity(), "Subject Deleted",
                        Toast.LENGTH_SHORT).show();

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        // Use AsyncTask to delete from database

        return true;
    }

}
