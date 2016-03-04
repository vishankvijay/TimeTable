package com.example.timetable;

import java.text.ParseException;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

public class SubjectDAO extends SubjectDBDAO {

    private static final String WHERE_ID_EQUALS = DataBaseHelper.ID_COLUMN
            + " =?";

    public SubjectDAO(Context context) {

        super(context);

    }

    // Saving all the entries in Monday table in DataBase
    public long saveMondaySubjects(SubjectParcel subjectParcel) {

        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        return database.insert(DataBaseHelper.MONDAY_FRAGMENT_TABLE, null,
                values);
    }

    // Saving all the entries in Tuesday table in DataBase
    public long saveTuesdaySubjects(SubjectParcel subjectParcel) {

        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        return database.insert(DataBaseHelper.TUESDAY_FRAGMENT_TABLE, null,
                values);
    }

    // Saving all the entries in Wednesday table in DataBase
    public long saveWednesdaySubjects(SubjectParcel subjectParcel) {

        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        return database.insert(DataBaseHelper.WEDNESDAY_FRAGMENT_TABLE, null,
                values);
    }

    // Saving all the entries in Thursday table in DataBase
    public long saveThursdaySubjects(SubjectParcel subjectParcel) {

        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        return database.insert(DataBaseHelper.THURSDAY_FRAGMENT_TABLE, null,
                values);
    }

    // Saving all the entries in Friday table in DataBase
    public long saveFridaySubjects(SubjectParcel subjectParcel) {

        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        return database.insert(DataBaseHelper.FRIDAY_FRAGMENT_TABLE, null,
                values);
    }

    // Saving all the entries in Saturday table in DataBase
    public long saveSaturdaySubjects(SubjectParcel subjectParcel) {

        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        return database.insert(DataBaseHelper.SATURDAY_FRAGMENT_TABLE, null,
                values);
    }

    // Saving all the entries in Sunday table in DataBase
    public long saveSundaySubjects(SubjectParcel subjectParcel) {

        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        return database.insert(DataBaseHelper.SUNDAY_FRAGMENT_TABLE, null,
                values);
    }

    // Updating Monday Entry.
    public long updateMondayEntry(SubjectParcel subjectParcel) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        long result = database.update(DataBaseHelper.MONDAY_FRAGMENT_TABLE,
                values, WHERE_ID_EQUALS,
                new String[] { String.valueOf(subjectParcel.getId()) });
        return result;

    }

    // Updating Tuesday Entry.
    public long updateTuesdayEntry(SubjectParcel subjectParcel) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        long result = database.update(DataBaseHelper.TUESDAY_FRAGMENT_TABLE,
                values, WHERE_ID_EQUALS,
                new String[] { String.valueOf(subjectParcel.getId()) });
        return result;

    }

    // Updating Wednesday Entry.
    public long updateWednesdayEntry(SubjectParcel subjectParcel) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        long result = database.update(DataBaseHelper.WEDNESDAY_FRAGMENT_TABLE,
                values, WHERE_ID_EQUALS,
                new String[] { String.valueOf(subjectParcel.getId()) });
        return result;

    }

    // Updating Thursday Entry.
    public long updateThursdayEntry(SubjectParcel subjectParcel) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        long result = database.update(DataBaseHelper.THURSDAY_FRAGMENT_TABLE,
                values, WHERE_ID_EQUALS,
                new String[] { String.valueOf(subjectParcel.getId()) });
        return result;

    }

    // Updating Friday Entry.
    public long updateFridayEntry(SubjectParcel subjectParcel) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        long result = database.update(DataBaseHelper.FRIDAY_FRAGMENT_TABLE,
                values, WHERE_ID_EQUALS,
                new String[] { String.valueOf(subjectParcel.getId()) });
        return result;

    }

    // Updating Saturday Entry.
    public long updateSaturdayEntry(SubjectParcel subjectParcel) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        long result = database.update(DataBaseHelper.SATURDAY_FRAGMENT_TABLE,
                values, WHERE_ID_EQUALS,
                new String[] { String.valueOf(subjectParcel.getId()) });
        return result;

    }

    // Updating Sunday Entry.
    public long updateSundayEntry(SubjectParcel subjectParcel) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.SUBJECT_NAME, subjectParcel.getSubjectName());
        values.put(DataBaseHelper.DESCRIPTION, subjectParcel.getDescription());
        values.put(DataBaseHelper.ROOM_NO, subjectParcel.getRoomNO());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_START,
                subjectParcel.getCurrentHourTextStart());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                subjectParcel.getCurrentMinuteTextStart());
        values.put(DataBaseHelper.CURRENT_HOUR_TEXT_END,
                subjectParcel.getCurrentHourTextEnd());
        values.put(DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                subjectParcel.getCurrentMinuteTextEnd());
        values.put(DataBaseHelper.COLOR, subjectParcel.getColor());


        long result = database.update(DataBaseHelper.SUNDAY_FRAGMENT_TABLE,
                values, WHERE_ID_EQUALS,
                new String[] { String.valueOf(subjectParcel.getId()) });
        return result;

    }

    public int deleteMondayEntry(SubjectParcel subjectParcel) {
        return database.delete(DataBaseHelper.MONDAY_FRAGMENT_TABLE,
                WHERE_ID_EQUALS, new String[] { subjectParcel.getId() + "" });
    }

    public int deleteTuesdayEntry(SubjectParcel subjectParcel) {
        return database.delete(DataBaseHelper.TUESDAY_FRAGMENT_TABLE,
                WHERE_ID_EQUALS, new String[] { subjectParcel.getId() + "" });
    }

    public int deleteWednesdayEntry(SubjectParcel subjectParcel) {
        return database.delete(DataBaseHelper.WEDNESDAY_FRAGMENT_TABLE,
                WHERE_ID_EQUALS, new String[] { subjectParcel.getId() + "" });
    }

    public int deleteThursdayEntry(SubjectParcel subjectParcel) {
        return database.delete(DataBaseHelper.THURSDAY_FRAGMENT_TABLE,
                WHERE_ID_EQUALS, new String[] { subjectParcel.getId() + "" });
    }

    public int deleteFridayEntry(SubjectParcel subjectParcel) {
        return database.delete(DataBaseHelper.FRIDAY_FRAGMENT_TABLE,
                WHERE_ID_EQUALS, new String[] { subjectParcel.getId() + "" });
    }

    public int deleteSaturdayEntry(SubjectParcel subjectParcel) {
        return database.delete(DataBaseHelper.SATURDAY_FRAGMENT_TABLE,
                WHERE_ID_EQUALS, new String[] { subjectParcel.getId() + "" });
    }

    public int deleteSundayEntry(SubjectParcel subjectParcel) {
        return database.delete(DataBaseHelper.SUNDAY_FRAGMENT_TABLE,
                WHERE_ID_EQUALS, new String[] { subjectParcel.getId() + "" });
    }

    // Retrieving All Entries from Monday Table
    public ArrayList<SubjectParcel> getAllMondaySubjects() {
        ArrayList<SubjectParcel> subjectParcel1 = new ArrayList<SubjectParcel>();

        Cursor cursor = database.query(DataBaseHelper.MONDAY_FRAGMENT_TABLE,
                new String[] { DataBaseHelper.ID_COLUMN,
                        DataBaseHelper.SUBJECT_NAME,
                        DataBaseHelper.DESCRIPTION, DataBaseHelper.ROOM_NO,
                        DataBaseHelper.CURRENT_HOUR_TEXT_START,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                        DataBaseHelper.CURRENT_HOUR_TEXT_END,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_END, DataBaseHelper.COLOR }, null, null,
                null, null, DataBaseHelper.CURRENT_MINUTE_TEXT_START+" ASC");


        while (cursor.moveToNext()) {
            SubjectParcel subjectParcel2 = new SubjectParcel();
            subjectParcel2.setId(cursor.getInt(0));
            subjectParcel2.setSubjectName(cursor.getString(1));
            subjectParcel2.setDescription(cursor.getString(2));
            subjectParcel2.setRoomNo(cursor.getString(3));
            subjectParcel2.setCurrentHourTextStart(cursor.getString(4));
            subjectParcel2.setCurrentMinuteTextStart(cursor.getString(5));
            subjectParcel2.setCurrentHourTextEnd(cursor.getString(6));
            subjectParcel2.setCurrentMinuteTextEnd(cursor.getString(7));
            subjectParcel2.setColor(cursor.getInt(8));

            subjectParcel1.add(subjectParcel2);
        }
        return subjectParcel1;
    }

    // Retrieving All Entries from Tuesday Table
    public ArrayList<SubjectParcel> getAllTuesdaySubjects() {
        ArrayList<SubjectParcel> subjectParcel1 = new ArrayList<SubjectParcel>();

        Cursor cursor = database.query(DataBaseHelper.TUESDAY_FRAGMENT_TABLE,
                new String[] { DataBaseHelper.ID_COLUMN,
                        DataBaseHelper.SUBJECT_NAME,
                        DataBaseHelper.DESCRIPTION, DataBaseHelper.ROOM_NO,
                        DataBaseHelper.CURRENT_HOUR_TEXT_START,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                        DataBaseHelper.CURRENT_HOUR_TEXT_END,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_END,
                        DataBaseHelper.COLOR }, null, null,
                null, null, null);

        while (cursor.moveToNext()) {
            SubjectParcel subjectParcel2 = new SubjectParcel();
            subjectParcel2.setId(cursor.getInt(0));
            subjectParcel2.setSubjectName(cursor.getString(1));
            subjectParcel2.setDescription(cursor.getString(2));
            subjectParcel2.setRoomNo(cursor.getString(3));
            subjectParcel2.setCurrentHourTextStart(cursor.getString(4));
            subjectParcel2.setCurrentMinuteTextStart(cursor.getString(5));
            subjectParcel2.setCurrentHourTextEnd(cursor.getString(6));
            subjectParcel2.setCurrentMinuteTextEnd(cursor.getString(7));
            subjectParcel2.setColor(cursor.getInt(8));

            subjectParcel1.add(subjectParcel2);
        }
        return subjectParcel1;
    }

    // Retrieving All Entries from Wednesday Table
    public ArrayList<SubjectParcel> getAllWednesdaySubjects() {
        ArrayList<SubjectParcel> subjectParcel1 = new ArrayList<SubjectParcel>();

        Cursor cursor = database.query(DataBaseHelper.WEDNESDAY_FRAGMENT_TABLE,
                new String[] { DataBaseHelper.ID_COLUMN,
                        DataBaseHelper.SUBJECT_NAME,
                        DataBaseHelper.DESCRIPTION, DataBaseHelper.ROOM_NO,
                        DataBaseHelper.CURRENT_HOUR_TEXT_START,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                        DataBaseHelper.CURRENT_HOUR_TEXT_END,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_END, DataBaseHelper.COLOR }, null, null,
                null, null, null);

        while (cursor.moveToNext()) {
            SubjectParcel subjectParcel2 = new SubjectParcel();
            subjectParcel2.setId(cursor.getInt(0));

            subjectParcel2.setSubjectName(cursor.getString(1));
            subjectParcel2.setDescription(cursor.getString(2));
            subjectParcel2.setRoomNo(cursor.getString(3));
            subjectParcel2.setCurrentHourTextStart(cursor.getString(4));
            subjectParcel2.setCurrentMinuteTextStart(cursor.getString(5));
            subjectParcel2.setCurrentHourTextEnd(cursor.getString(6));
            subjectParcel2.setCurrentMinuteTextEnd(cursor.getString(7));
            subjectParcel2.setColor(cursor.getInt(8));

            subjectParcel1.add(subjectParcel2);
        }
        return subjectParcel1;
    }

    // Retrieving All Entries from Thursday Table
    public ArrayList<SubjectParcel> getAllThursdaySubjects() {
        ArrayList<SubjectParcel> subjectParcel1 = new ArrayList<SubjectParcel>();

        Cursor cursor = database.query(DataBaseHelper.THURSDAY_FRAGMENT_TABLE,
                new String[] { DataBaseHelper.ID_COLUMN,
                        DataBaseHelper.SUBJECT_NAME,
                        DataBaseHelper.DESCRIPTION, DataBaseHelper.ROOM_NO,
                        DataBaseHelper.CURRENT_HOUR_TEXT_START,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                        DataBaseHelper.CURRENT_HOUR_TEXT_END,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_END, DataBaseHelper.COLOR }, null, null,
                null, null, null);

        while (cursor.moveToNext()) {
            SubjectParcel subjectParcel2 = new SubjectParcel();
            subjectParcel2.setId(cursor.getInt(0));
            subjectParcel2.setSubjectName(cursor.getString(1));
            subjectParcel2.setDescription(cursor.getString(2));
            subjectParcel2.setRoomNo(cursor.getString(3));
            subjectParcel2.setCurrentHourTextStart(cursor.getString(4));
            subjectParcel2.setCurrentMinuteTextStart(cursor.getString(5));
            subjectParcel2.setCurrentHourTextEnd(cursor.getString(6));
            subjectParcel2.setCurrentMinuteTextEnd(cursor.getString(7));
            subjectParcel2.setColor(cursor.getInt(8));

            subjectParcel1.add(subjectParcel2);
        }
        return subjectParcel1;
    }

    // Retrieving All Entries from Friday Table
    public ArrayList<SubjectParcel> getAllFridaySubjects() {
        ArrayList<SubjectParcel> subjectParcel1 = new ArrayList<SubjectParcel>();

        Cursor cursor = database.query(DataBaseHelper.FRIDAY_FRAGMENT_TABLE,
                new String[] { DataBaseHelper.ID_COLUMN,
                        DataBaseHelper.SUBJECT_NAME,
                        DataBaseHelper.DESCRIPTION, DataBaseHelper.ROOM_NO,
                        DataBaseHelper.CURRENT_HOUR_TEXT_START,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                        DataBaseHelper.CURRENT_HOUR_TEXT_END,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_END, DataBaseHelper.COLOR }, null, null,
                null, null, null);

        while (cursor.moveToNext()) {
            SubjectParcel subjectParcel2 = new SubjectParcel();
            subjectParcel2.setId(cursor.getInt(0));
            subjectParcel2.setSubjectName(cursor.getString(1));
            subjectParcel2.setDescription(cursor.getString(2));
            subjectParcel2.setRoomNo(cursor.getString(3));
            subjectParcel2.setCurrentHourTextStart(cursor.getString(4));
            subjectParcel2.setCurrentMinuteTextStart(cursor.getString(5));
            subjectParcel2.setCurrentHourTextEnd(cursor.getString(6));
            subjectParcel2.setCurrentMinuteTextEnd(cursor.getString(7));
            subjectParcel2.setColor(cursor.getInt(8));

            subjectParcel1.add(subjectParcel2);
        }
        return subjectParcel1;
    }

    // Retrieving All Entries from Saturday Table
    public ArrayList<SubjectParcel> getAllSaturdaySubjects() {
        ArrayList<SubjectParcel> subjectParcel1 = new ArrayList<SubjectParcel>();
        Log.d("Vishankkkkkkkkkkkk", "Before");

        Cursor cursor = database.query(DataBaseHelper.SATURDAY_FRAGMENT_TABLE,
                new String[] { DataBaseHelper.ID_COLUMN,
                        DataBaseHelper.SUBJECT_NAME,
                        DataBaseHelper.DESCRIPTION, DataBaseHelper.ROOM_NO,
                        DataBaseHelper.CURRENT_HOUR_TEXT_START,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                        DataBaseHelper.CURRENT_HOUR_TEXT_END,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_END, DataBaseHelper.COLOR }, null, null,
                null, null, null);
        Log.d("Vishankkkkkkkkkkkk", "After");

        while (cursor.moveToNext()) {
            SubjectParcel subjectParcel2 = new SubjectParcel();
            subjectParcel2.setId(cursor.getInt(0));

            subjectParcel2.setSubjectName(cursor.getString(1));
            subjectParcel2.setDescription(cursor.getString(2));
            subjectParcel2.setRoomNo(cursor.getString(3));
            subjectParcel2.setCurrentHourTextStart(cursor.getString(4));
            subjectParcel2.setCurrentMinuteTextStart(cursor.getString(5));
            subjectParcel2.setCurrentHourTextEnd(cursor.getString(6));
            subjectParcel2.setCurrentMinuteTextEnd(cursor.getString(7));
            subjectParcel2.setColor(cursor.getInt(8));

            subjectParcel1.add(subjectParcel2);
        }
        return subjectParcel1;
    }

    // Retrieving All Entries from Sunday Table
    public ArrayList<SubjectParcel> getAllSundaySubjects() {
        ArrayList<SubjectParcel> subjectParcel1 = new ArrayList<SubjectParcel>();

        Cursor cursor = database.query(DataBaseHelper.SUNDAY_FRAGMENT_TABLE,
                new String[] { DataBaseHelper.ID_COLUMN,
                        DataBaseHelper.SUBJECT_NAME,
                        DataBaseHelper.DESCRIPTION, DataBaseHelper.ROOM_NO,
                        DataBaseHelper.CURRENT_HOUR_TEXT_START,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_START,
                        DataBaseHelper.CURRENT_HOUR_TEXT_END,
                        DataBaseHelper.CURRENT_MINUTE_TEXT_END, DataBaseHelper.COLOR }, null, null,
                null, null, null);

        while (cursor.moveToNext()) {
            SubjectParcel subjectParcel2 = new SubjectParcel();
            subjectParcel2.setId(cursor.getInt(0));
            subjectParcel2.setSubjectName(cursor.getString(1));
            subjectParcel2.setDescription(cursor.getString(2));
            subjectParcel2.setRoomNo(cursor.getString(3));
            subjectParcel2.setCurrentHourTextStart(cursor.getString(4));
            subjectParcel2.setCurrentMinuteTextStart(cursor.getString(5));
            subjectParcel2.setCurrentHourTextEnd(cursor.getString(6));
            subjectParcel2.setCurrentMinuteTextEnd(cursor.getString(7));
            subjectParcel2.setColor(cursor.getInt(8));

            subjectParcel1.add(subjectParcel2);
        }
        return subjectParcel1;
    }

    // Retrieves a single Subject record with the given id

    public SubjectParcel getSingleSubject(long id) {
        SubjectParcel subjectParcel = null;

        String sql = "SELECT * FROM " + DataBaseHelper.MONDAY_FRAGMENT_TABLE
                + " WHERE " + DataBaseHelper.ID_COLUMN + " = ?";

        Cursor cursor = database.rawQuery(sql, new String[] { id + "" });

        if (cursor.moveToNext()) {
            subjectParcel = new SubjectParcel();
            subjectParcel.setId(cursor.getInt(0));
            subjectParcel.setSubjectName(cursor.getString(1));
            subjectParcel.setDescription(cursor.getString(2));
            subjectParcel.setRoomNo(cursor.getString(3));
            subjectParcel.setCurrentHourTextStart(cursor.getString(4));
            subjectParcel.setCurrentMinuteTextStart(cursor.getString(5));
            subjectParcel.setCurrentHourTextEnd(cursor.getString(6));
            subjectParcel.setCurrentMinuteTextEnd(cursor.getString(7));


        }
        return subjectParcel;
    }

}
