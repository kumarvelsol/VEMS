package igrand.com.vems.fragments.adminfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import igrand.com.vems.R;
import igrand.com.vems.adapters.TeacherAttendanceListAdapter;
import igrand.com.vems.samplemodelclasses.TeacherAttendanceModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminTeachersAttendanceListFragment extends Fragment {
    RecyclerView mTeachersAttendanceList;
    List<TeacherAttendanceModel> attendanceModelList;


    public AdminTeachersAttendanceListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_admin_teachers_attendance_list, container, false);
        initViews(v);
        retrieveAttendanceDetails();

        return  v;
    }




    private void initViews(View v)
    {
        mTeachersAttendanceList=(RecyclerView)v.findViewById(R.id.teachers_attendance_list);
        attendanceModelList=new ArrayList<>();

    }
    private void retrieveAttendanceDetails()
    {
        attendanceModelList.add(new TeacherAttendanceModel("Prabhakar","Present","10:45 Am","4.45 Pm","7 Hours"));
        attendanceModelList.add(new TeacherAttendanceModel("Prabhakar","Present","10:45 Am","4.45 Pm","7 Hours"));
        attendanceModelList.add(new TeacherAttendanceModel("Prabhakar","Present","10:45 Am","4.45 Pm","7 Hours"));
        attendanceModelList.add(new TeacherAttendanceModel("Prabhakar","Absent","10:45 Am","4.45 Pm","7 Hours"));
        attendanceModelList.add(new TeacherAttendanceModel("Prabhakar","Present","10:45 Am","4.45 Pm","7 Hours"));
        attendanceModelList.add(new TeacherAttendanceModel("Prabhakar","Absent","10:45 Am","4.45 Pm","7 Hours"));
        attendanceModelList.add(new TeacherAttendanceModel("Prabhakar","Present","10:45 Am","4.45 Pm","7 Hours"));
        assignValuesToRecycleList(attendanceModelList);
    }
    private void assignValuesToRecycleList(List<TeacherAttendanceModel> teacherAttendanceModels)
    {
        TeacherAttendanceListAdapter attendanceListAdapter=new TeacherAttendanceListAdapter(getActivity(),teacherAttendanceModels);
        mTeachersAttendanceList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTeachersAttendanceList.setItemAnimator(new DefaultItemAnimator());
        mTeachersAttendanceList.setHasFixedSize(true);
        mTeachersAttendanceList.setAdapter(attendanceListAdapter);


    }

}
