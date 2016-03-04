package com.example.timetable;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class SubjectParcel implements Parcelable {

    private int id;
    private String subject_name;
    private String description;
    private String roomNo;
    private String currentHourTextStart;
    private String currentMinuteTextStart;
    private String currentHourTextEnd;
    private String currentMinuteTextEnd;
    private int color;

    public SubjectParcel() {
        super();
    }

    private SubjectParcel(Parcel in) {
        super();
        this.id = in.readInt();
        this.subject_name = in.readString();
        this.roomNo = in.readString();
        this.currentHourTextStart = in.readString();
        this.currentMinuteTextStart = in.readString();
        this.currentHourTextEnd = in.readString();
        this.currentMinuteTextEnd = in.readString();
        this.description = in.readString();
        this.color = in.readInt();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subject_name;
    }

    public void setSubjectName(String name) {
        this.subject_name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String descrip) {
        this.description = descrip;
    }

    public String getRoomNO() {
        return roomNo;
    }

    public void setRoomNo(String room) {
        this.roomNo = room;
    }

    public String getCurrentHourTextStart() {
        return currentHourTextStart;
    }

    public void setCurrentHourTextStart(String currentHourTextStart) {
        this.currentHourTextStart = currentHourTextStart;
    }

    public String getCurrentMinuteTextStart() {
        return currentMinuteTextStart;
    }

    public void setCurrentMinuteTextStart(String currentMinuteTextStart) {
        this.currentMinuteTextStart = currentMinuteTextStart;
    }

    public String getCurrentHourTextEnd() {
        return currentHourTextEnd;
    }

    public void setCurrentHourTextEnd(String currentHourTextEnd) {
        this.currentHourTextEnd = currentHourTextEnd;
    }

    public String getCurrentMinuteTextEnd() {
        return currentMinuteTextEnd;
    }

    public void setCurrentMinuteTextEnd(String currentMinuteTextEnd) {
        this.currentMinuteTextEnd = currentMinuteTextEnd;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", subject_name=" + subject_name
                + ", description=" + description + ", roomNo=" + roomNo
                + ", currentHourTextStart=" + currentHourTextStart
                + ", currentMinuteTextStart=" + currentMinuteTextStart
                + ", currentHourTextEnd=" + currentHourTextEnd + ", currentMinuteTextEnd=" + currentMinuteTextEnd + ", color=" + color + "]";
    }




    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SubjectParcel other = (SubjectParcel) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel pacel, int flags) {
        // TODO Auto-generated method stub
        pacel.writeInt(getId());
        pacel.writeString(getSubjectName());
        pacel.writeString(getRoomNO());
        pacel.writeString(getCurrentHourTextStart());
        pacel.writeString(getCurrentMinuteTextStart());
        pacel.writeString(getCurrentHourTextEnd());
        pacel.writeString(getCurrentMinuteTextEnd());
        pacel.writeString(getDescription());
        pacel.writeInt(getColor());

    }

    public static final Parcelable.Creator<SubjectParcel> CREATOR = new Parcelable.Creator<SubjectParcel>() {
        public SubjectParcel createFromParcel(Parcel in) {
            return new SubjectParcel(in);
        }

        public SubjectParcel[] newArray(int size) {
            return new SubjectParcel[size];
        }
    };

}
