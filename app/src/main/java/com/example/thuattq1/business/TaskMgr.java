package com.example.thuattq1.business;

import android.database.Cursor;

import com.example.thuattq1.entity.TaskEntity;
import com.example.thuattq1.entity.TaskEntity_Table;
import com.example.thuattq1.exception.BusinessException;
import com.example.thuattq1.util.CursorUtil;
import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

/**
 * Created by thuattq1 on 2/10/2017.
 */

public class TaskMgr extends AbstractMgr {
    public int getMaxId() throws BusinessException {
        int maxId = 0;
        try{
            Cursor c = SQLite.select(Method.max(TaskEntity_Table.id))
                    .from(TaskEntity.class)
                    .query();

            maxId = CursorUtil.getIntObj(c, 0, 0);
            maxId = maxId > 0 ? maxId + 1 : 1;
        } catch (Exception ex) {
            throw new BusinessException(ex);
        }

        return maxId;
    }

    public TaskEntity getTaskById(int id) throws BusinessException {
        try {
            return SQLite.select()
                    .from(TaskEntity.class)
                    .where(TaskEntity_Table.id.eq(id))
                    .querySingle();
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public List<TaskEntity> getAllTask() throws BusinessException {
        try {
            List<TaskEntity> lst = SQLite.select().
                    from(TaskEntity.class).
                    queryList();
            return lst;
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }
}
