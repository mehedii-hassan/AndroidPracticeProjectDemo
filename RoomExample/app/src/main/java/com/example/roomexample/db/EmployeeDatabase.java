package com.example.roomexample.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomexample.daos.EmployeeDao;
import com.example.roomexample.entities.Employee;

@Database(entities = {Employee.class}, version = 1)
public abstract class EmployeeDatabase extends RoomDatabase {

    private static EmployeeDatabase db;

    public abstract EmployeeDao getEmployeeDao();

    public static EmployeeDatabase getDb(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context, EmployeeDatabase.class, "employee_db")
                    .allowMainThreadQueries()
                    .build();
            return db;
        }
        return db;
    }

}
