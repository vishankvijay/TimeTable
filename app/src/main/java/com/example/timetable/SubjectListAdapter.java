package com.example.timetable;

import java.util.List;

import com.example.timetable.R.layout;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SubjectListAdapter extends ArrayAdapter<SubjectParcel> {

    private Context context;
    List<SubjectParcel> subjectParcel1;

    public SubjectListAdapter(Context context,
                              List<SubjectParcel> subjectParcel1) {
        super(context, R.layout.list_item, subjectParcel1);
        this.context = context;
        this.subjectParcel1 = subjectParcel1;
    }

    private class ViewHolder {
        TextView subjecTextView;
        TextView descriptionTextView;
        TextView roomNoTextView;
        TextView timeTextView;

        /*TextView currentHourStartTextView;
        TextView currentMinuteStartTextView;
        TextView currentHourEndTextView;
        TextView currentMinuteEndTextView;*/
        View layout;

    }

    @Override
    public int getCount() {
        return subjectParcel1.size();
    }

    @Override
    public SubjectParcel getItem(int position) {
        return subjectParcel1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();

            holder.subjecTextView = (TextView) convertView
                    .findViewById(R.id.subject_name);
            holder.descriptionTextView = (TextView) convertView
                    .findViewById(R.id.description);
            holder.roomNoTextView = (TextView) convertView
                    .findViewById(R.id.room_no);
            holder.timeTextView = (TextView) convertView
                    .findViewById(R.id.timeTextView);
			/*holder.currentHourStartTextView = (TextView) convertView
					.findViewById(R.id.currentHourStartTextView);
			holder.currentMinuteStartTextView = (TextView) convertView
					.findViewById(R.id.currentMinuteStartTextView);
			holder.currentHourEndTextView = (TextView) convertView
					.findViewById(R.id.currentHourEndTextView);
			holder.currentMinuteEndTextView = (TextView) convertView
					.findViewById(R.id.currentMinuteEndTextView);*/

            holder.layout = convertView.findViewById(R.id.layout_item);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        SubjectParcel subjectParcel2 = (SubjectParcel) getItem(position);

        holder.subjecTextView.setText(subjectParcel2.getSubjectName() + "");
        holder.descriptionTextView
                .setText(subjectParcel2.getDescription() + "");
        holder.roomNoTextView.setText(subjectParcel2.getRoomNO() + "");
		/*holder.currentHourStartTextView.setText(subjectParcel2
				.getCurrentHourTextStart() + "");
		holder.currentMinuteStartTextView.setText(subjectParcel2
				.getCurrentMinuteTextStart() + "");
		holder.currentHourEndTextView.setText(subjectParcel2
				.getCurrentHourTextEnd() + "");
		holder.currentMinuteEndTextView.setText(subjectParcel2
				.getCurrentMinuteTextEnd() + "");*/
        holder.timeTextView.setText(subjectParcel2.getCurrentHourTextStart()+":"
                + subjectParcel2.getCurrentMinuteTextStart() + "-"
                + subjectParcel2.getCurrentHourTextEnd()+":"
                + subjectParcel2.getCurrentMinuteTextEnd()+"");

        holder.layout.setBackgroundColor(subjectParcel2.getColor());

        return convertView;
    }

    @Override
    public void add(SubjectParcel subjectParcel2) {
        subjectParcel1.add(subjectParcel2);
        notifyDataSetChanged();
        super.add(subjectParcel2);
    }

    @Override
    public void remove(SubjectParcel subjectParcel2) {
        subjectParcel1.remove(subjectParcel2);
        notifyDataSetChanged();
        super.remove(subjectParcel2);
    }

}
