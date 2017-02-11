package com.example.thuattq1.entity;

import com.example.thuattq1.database.TodoDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.parceler.Parcel;

import java.util.Date;

/**
 * Created by thuattq1 on 2/10/2017.
 */

@Table(database = TodoDB.class)
@Parcel(analyze={TaskEntity.class})
public class TaskEntity extends BaseModel {
    @Column
    @PrimaryKey
    public Integer id;
    @Column
    public String taskName;
    @Column
    public Date dueDate;
    @Column
    public String taskNotes;
    @Column
    public Integer level;
    @Column
    public Integer status;

    public TaskEntity() {}
}
