package com.zhixing.staffid.ui.presenter;

import com.zhixing.staffid.app.StaffIDApplication;
import com.zhixing.staffid.dao.NoteDao;
import com.zhixing.staffid.entity.Note;
import com.zhixing.staffid.ui.BaseMvpActivity;

import java.util.List;

/**
 * Created by zhaobiying
 * 2018/4/2.
 */

public class LoadDataTestPresenter extends MvpPresenter<BaseMvpActivity> {
    private NoteDao noteDao;

    private Note note;

    public LoadDataTestPresenter(BaseMvpActivity view) {
        super(view);
    }


    public void loadData() {
        noteDao = StaffIDApplication.getDbInstance().getSession().getNoteDao();
//        note = new Note((long) 1, "2", "3", new Date());
//        noteDao.insert(note);
        List<Note> notes = noteDao.loadAll();
        String noteString = "";
        for (int i = 0; i < notes.size(); i++) {
            noteString += notes.get(i).getDate() + ",";
        }
        super.getView().showdata(noteString);
    }




}
