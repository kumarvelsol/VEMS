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
import igrand.com.vems.adapters.StudentAttendanceListAdapter;
import igrand.com.vems.adapters.TeacherAttendanceListAdapter;
import igrand.com.vems.samplemodelclasses.StudentAttendanceModel;
import igrand.com.vems.samplemodelclasses.TeacherAttendanceModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminStudentAttendanceListFragment extends Fragment {
    RecyclerView mRecycleStudentsAttendanceList;
    List<TeacherAttendanceModel> attendanceModelList;



    public AdminStudentAttendanceListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_admin_student_attendance_list, container, false);
        initViews(v);
        return v;
    }
    private void initViews(View v)
    {
        mRecycleStudentsAttendanceList=(RecyclerView)v.findViewById(R.id.admin_students_attendance_list_recycle);
        attendanceModelList=new ArrayList<>();
        retrieveAttendanceDetails();
    }

    private void retrieveAttendanceDetails()
    {
        attendanceModelList.add(new TeacherAttendanceModel("Sanjay","Present","10:45 Am","4.45 Pm","7 Hours"));
        attendanceModelList.add(new TeacherAttendanceModel("Prabhakar","Present","10:45 Am","4.45 Pm","7 Hours"));
        attendanceModelList.add(new TeacherAttendanceModel("Sukumar","Present","10:45 Am","4.45 Pm","7 Hours"));
        attendanceModelList.add(new TeacherAttendanceModel("Prabhakar","Absent","10:45 Am","4.45 Pm","7 Hours"));
        attendanceModelList.add(new TeacherAttendanceModel("Prabhakar","Present","10:45 Am","4.45 Pm","7 Hours"));
        attendanceModelList.add(new TeacherAttendanceModel("Santhosh","Absent","10:45 Am","4.45 Pm","7 Hours"));
        attendanceModelList.add(new TeacherAttendanceModel("Prabhakar","Present","10:45 Am","4.45 Pm","7 Hours"));
        assignValuesToRecycleList(attendanceModelList);
    }
    private void assignValuesToRecycleList(List<TeacherAttendanceModel> teacherAttendanceModels)
    {
        TeacherAttendanceListAdapter attendanceListAdapter=new TeacherAttendanceListAdapter(getActivity(),teacherAttendanceModels);
        mRecycleStudentsAttendanceList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycleStudentsAttendanceList.setItemAnimator(new DefaultItemAnimator());
        mRecycleStudentsAttendanceList.setHasFixedSize(true);
        mRecycleStudentsAttendanceList.setAdapter(attendanceListAdapter);


    }

}
