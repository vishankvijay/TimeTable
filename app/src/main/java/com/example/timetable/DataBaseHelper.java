package com.example.timetable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "timeTableDb23";
    private static final int DATABASE_VERSION = 13;

    public static final String MONDAY_FRAGMENT_TABLE = "monday_fragment_entry";
    public static final String TUESDAY_FRAGMENT_TABLE = "tuesday_fragment_entry";
    public static final String WEDNESDAY_FRAGMENT_TABLE = "wednesday_fragment_entry";
    public static final String THURSDAY_FRAGMENT_TABLE = "thursday_fragment_entry";
    public static final String FRIDAY_FRAGMENT_TABLE = "friday_fragment_entry";
    public static final String SATURDAY_FRAGMENT_TABLE = "saturday_fragment_entry";
    public static final String SUNDAY_FRAGMENT_TABLE = "sunday_fragment_entry";

    public static final String ID_COLUMN = "id";
    public static final String SUBJECT_NAME = "subject_name";
    public static final String ROOM_NO = "room_no";
    public static final String CURRENT_HOUR_TEXT_START = "currentHourTextStart";
    public static final String CURRENT_MINUTE_TEXT_START = "currentMinuteTextStart";
    public static final String CURRENT_HOUR_TEXT_END = "currentHourTextEnd";
    public static final String CURRENT_MINUTE_TEXT_END = "currentMinuteTextEnd";
    public static final String COLOR = "color";

    // public static final String START_TIME = "start_time";
    // public static final String END_TIME = "end_time";
    public static final String DESCRIPTION = "description";

    // For Monday Subject Entry Table
    public static final String CREATE_MONDAY_FRAGMENT_TABLE = "CREATE TABLE "
            + MONDAY_FRAGMENT_TABLE + "(" + ID_COLUMN
            + " INTEGER PRIMARY KEY, " + SUBJECT_NAME + " TEXT, " + DESCRIPTION
            + " TEXT, " + ROOM_NO + " TEXT, " + CURRENT_HOUR_TEXT_START
            + " TEXT, " + CURRENT_MINUTE_TEXT_START + " TEXT, "
            + CURRENT_HOUR_TEXT_END + " TEXT, " + CURRENT_MINUTE_TEXT_END
            + " TEXT, " + COLOR + " INTEGER " + ")";

    // For Tuesday Subject Entry Table
    public static final String CREATE_TUESDAY_FRAGMENT_TABLE = "CREATE TABLE "
            + TUESDAY_FRAGMENT_TABLE + "(" + ID_COLUMN
            + " INTEGER PRIMARY KEY, " + SUBJECT_NAME + " TEXT, " + DESCRIPTION
            + " TEXT, " + ROOM_NO + " TEXT, " + CURRENT_HOUR_TEXT_START
            + " TEXT, " + CURRENT_MINUTE_TEXT_START + " TEXT, "
            + CURRENT_HOUR_TEXT_END + " TEXT, " + CURRENT_MINUTE_TEXT_END
            + " TEXT, " + COLOR + " INTEGER " + ")";

    // For Wednesday Subject Entry Table
    public static final String CREATE_WEDNESDAY_FRAGMENT_TABLE = "CREATE TABLE "
            + WEDNESDAY_FRAGMENT_TABLE
            + "("
            + ID_COLUMN
            + " INTEGER PRIMARY KEY, "
            + SUBJECT_NAME
            + " TEXT, "
            + DESCRIPTION
            + " TEXT, "
            + ROOM_NO
            + " TEXT, "
            + CURRENT_HOUR_TEXT_START
            + " TEXT, "
            + CURRENT_MINUTE_TEXT_START
            + " TEXT, "
            + CURRENT_HOUR_TEXT_END
            + " TEXT, "
            + CURRENT_MINUTE_TEXT_END
            + " TEXT, " + COLOR + " TEXT "  + ")";
    // For Thursday Subject Entry Table
    public static final String CREATE_THURSDAY_FRAGMENT_TABLE = "CREATE TABLE "
            + THURSDAY_FRAGMENT_TABLE + "(" + ID_COLUMN
            + " INTEGER PRIMARY KEY, " + SUBJECT_NAME + " TEXT, " + DESCRIPTION
            + " TEXT, " + ROOM_NO + " TEXT, " + CURRENT_HOUR_TEXT_START
            + " TEXT, " + CURRENT_MINUTE_TEXT_START + " TEXT, "
            + CURRENT_HOUR_TEXT_END + " TEXT, " + CURRENT_MINUTE_TEXT_END
            + " TEXT, " + COLOR + " INTEGER "  + ")";

    // For Friday Subject Entry Table
    public static final String CREATE_FRIDAY_FRAGMENT_TABLE = "CREATE TABLE "
            + FRIDAY_FRAGMENT_TABLE + "(" + ID_COLUMN
            + " INTEGER PRIMARY KEY, " + SUBJECT_NAME + " TEXT, " + DESCRIPTION
            + " TEXT, " + ROOM_NO + " TEXT, " + CURRENT_HOUR_TEXT_START
            + " TEXT, " + CURRENT_MINUTE_TEXT_START + " TEXT, "
            + CURRENT_HOUR_TEXT_END + " TEXT, " + CURRENT_MINUTE_TEXT_END
            + " TEXT, " + COLOR + " INTEGER "  + ")";

    // For Saturday Subject Entry Table
    public static final String CREATE_SATURDAY_FRAGMENT_TABLE = "CREATE TABLE "
            + SATURDAY_FRAGMENT_TABLE + "(" + ID_COLUMN
            + " INTEGER PRIMARY KEY, " + SUBJECT_NAME + " TEXT, " + DESCRIPTION
            + " TEXT, " + ROOM_NO + " TEXT, " + CURRENT_HOUR_TEXT_START
            + " TEXT, " + CURRENT_MINUTE_TEXT_START + " TEXT, "
            + CURRENT_HOUR_TEXT_END + " TEXT, " + CURRENT_MINUTE_TEXT_END
            + " TEXT, " + COLOR + " INTEGER "  + ")";

    // For Sunday Subject Entry Table
    public static final String CREATE_SUNDAY_FRAGMENT_TABLE = "CREATE TABLE "
            + SUNDAY_FRAGMENT_TABLE + "(" + ID_COLUMN
            + " INTEGER PRIMARY KEY, " + SUBJECT_NAME + " TEXT, " + DESCRIPTION
            + " TEXT, " + ROOM_NO + " TEXT, " + CURRENT_HOUR_TEXT_START
            + " TEXT, " + CURRENT_MINUTE_TEXT_START + " TEXT, "
            + CURRENT_HOUR_TEXT_END + " TEXT, " + CURRENT_MINUTE_TEXT_END
            + " TEXT, " + COLOR + " INTEGER "  + ")";

    private static DataBaseHelper instance;

    public static synchronized DataBaseHelper getHelper(Context context) {
        if (instance == null)
            instance = new DataBaseHelper(context);
        return instance;
    }

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MONDAY_FRAGMENT_TABLE); // already created
        db.execSQL(CREATE_FRIDAY_FRAGMENT_TABLE); // already created
        db.execSQL(CREATE_TUESDAY_FRAGMENT_TABLE);
        db.execSQL(CREATE_WEDNESDAY_FRAGMENT_TABLE);
        db.execSQL(CREATE_THURSDAY_FRAGMENT_TABLE);
        db.execSQL(CREATE_SATURDAY_FRAGMENT_TABLE);
        db.execSQL(CREATE_SUNDAY_FRAGMENT_TABLE);
        Log.d("VISHANKssssssssssssssssssss", "All Tables Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // onCreate(db);
    }
}
