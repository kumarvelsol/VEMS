package igrand.com.vems.fragments.teacherfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import igrand.com.vems.R;
import igrand.com.vems.fragments.adminfragments.AdminAttendanceFragment;
import igrand.com.vems.fragments.adminfragments.AdminMessagesFragment;
import igrand.com.vems.fragments.adminfragments.AssignmentsFragment;
import igrand.com.vems.fragments.adminfragments.ClassRoutinesFragment;
import igrand.com.vems.fragments.adminfragments.LeavesFragment;
import igrand.com.vems.fragments.adminfragments.PermissionsFragment;
import igrand.com.vems.fragments.adminfragments.StudentsListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeacherHomeFragment extends Fragment {
    LinearLayout mLayoutTeacherHomeStudents,mLayoutTeacherHomeClassRoutines,mLayoutTeacherHomeLeaves,mLayoutTeacherHomeAssignments,
            mLayoutTeacherHomeMessages,mLayoutTeacherHomePermissions,mLayoutTeacherHomeGallery,mLayoutTeacherHomeAttendance;
    TextView mLabelTeacherHomeCountStudents,mLabelTeacherHomeCountClassRoutines,mLabelTeacherHomeCountLeaves,mLabelTeacherHomeCountAssignments,
            mLabelTeacherHomeCountMessages,mLabelTeacherHomeCountPermissions,mLabelTeacherHomeCountGallery,mLabelTeacherHomeCountAttendance;


    public TeacherHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_teacher_home, container, false);
        initViews(v);
        return v;
    }

    private void initViews(View v)
    {
        mLayoutTeacherHomeStudents=(LinearLayout)v.findViewById(R.id.teachers_dashboard_menu_students_layout);
        mLayoutTeacherHomeClassRoutines=(LinearLayout)v.findViewById(R.id.teachers_dashboard_menu_class_routines_layout);
        mLayoutTeacherHomeLeaves=(LinearLayout)v.findViewById(R.id.teachers_dashboard_menu_leaves_layout);
        mLayoutTeacherHomeAssignments=(LinearLayout)v.findViewById(R.id.teachers_dashboard_menu_assignments_layout);
        mLayoutTeacherHomeMessages=(LinearLayout)v.findViewById(R.id.teachers_dashboard_menu_messages_layout);
        mLayoutTeacherHomePermissions=(LinearLayout)v.findViewById(R.id.teachers_dashboard_menu_permissions_layout);
        mLayoutTeacherHomeAttendance=(LinearLayout)v.findViewById(R.id.teachers_dashboard_menu_attendance_layout);
        mLayoutTeacherHomeGallery=(LinearLayout)v.findViewById(R.id.teachers_dashboard_menu_gallery_layout);

        mLabelTeacherHomeCountStudents=(TextView)v.findViewById(R.id.teacher_home_students_count_label);
        mLabelTeacherHomeCountClassRoutines=(TextView)v.findViewById(R.id.teacher_home_class_routines_count_label);
        mLabelTeacherHomeCountLeaves=(TextView)v.findViewById(R.id.teacher_home_leaves_count_label);
        mLabelTeacherHomeCountAssignments=(TextView)v.findViewById(R.id.teacher_home_assignments_count_label);
        mLabelTeacherHomeCountMessages=(TextView)v.findViewById(R.id.teacher_home_messages_count_label);
        mLabelTeacherHomeCountPermissions=(TextView)v.findViewById(R.id.teacher_home_permissions_count_label);
        mLabelTeacherHomeCountGallery=(TextView)v.findViewById(R.id.teacher_home_activity_gallery_count_label);
        mLabelTeacherHomeCountAttendance=(TextView)v.findViewById(R.id.teacher_home_activity_attendance_count_label);

        mLayoutTeacherHomeStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new StudentsListFragment());

            }
        });

        mLayoutTeacherHomeClassRoutines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new ClassRoutinesFragment());

            }
        });
        mLayoutTeacherHomeLeaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new LeavesFragment());

            }
        });
        mLayoutTeacherHomeAssignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AssignmentsFragment());

            }
        });
        mLayoutTeacherHomeMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AdminMessagesFragment());

            }
        });
        mLayoutTeacherHomePermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new PermissionsFragment());

            }
        });
        mLayoutTeacherHomeGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mLayoutTeacherHomeAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void assignCountsToLabels(String students,String classRoutines,String leaves, String assigments,
                                      String messages,String permissions, String gallery, String attendance){
        mLabelTeacherHomeCountStudents.setText(students);
        mLabelTeacherHomeCountClassRoutines.setText(classRoutines);
        mLabelTeacherHomeCountLeaves.setText(leaves);
        mLabelTeacherHomeCountAssignments.setText(assigments);
        mLabelTeacherHomeCountMessages.setText(messages);
        mLabelTeacherHomeCountPermissions.setText(permissions);
        mLabelTeacherHomeCountGallery.setText(gallery);
        mLabelTeacherHomeCountAttendance.setText(attendance);
    }
    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction fm=getFragmentManager().beginTransaction();
        fm.replace(R.id.teacher_home_frame_layout,fragment);
        fm.commit();
    }

}
