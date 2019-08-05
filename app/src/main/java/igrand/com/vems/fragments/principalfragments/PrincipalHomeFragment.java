package igrand.com.vems.fragments.principalfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import igrand.com.vems.R;
import igrand.com.vems.dialogs.AttendanceSelectionFragment;
import igrand.com.vems.dialogs.LeavesSelectionFragment;
import igrand.com.vems.dialogs.PermissionsSelectinFragment;
import igrand.com.vems.fragments.adminfragments.ClassRoutinesFragment;
import igrand.com.vems.fragments.adminfragments.GalleryFragment;
import igrand.com.vems.fragments.adminfragments.StudentsListFragment;
import igrand.com.vems.fragments.adminfragments.TeachersListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalHomeFragment extends Fragment {
    LinearLayout mLayoutTeachers,mLayoutStudents,mLayoutClassRoutines,mLayoutLeaves,mLayoutAattendance,mLayoutPermissions,mLayoutGallery;
    TextView mLabelTecahers,mLabelStudents,mLabelClassRoutines,mLabelLEaves,mLabelAttendance,mLabelPermissions,mLabelGallery;


    public PrincipalHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_principal_home, container, false);
        initViews(v);
        return v;
    }

    private void initViews(View v) {
        mLayoutTeachers=(LinearLayout)v.findViewById(R.id.principal_home_teachers_layout);
        mLayoutStudents=(LinearLayout)v.findViewById(R.id.principal_home_students_layout);
        mLayoutClassRoutines=(LinearLayout)v.findViewById(R.id.principal_home_class_routines_layout);
        mLayoutLeaves=(LinearLayout)v.findViewById(R.id.principal_home_leaves_layout);
        mLayoutAattendance=(LinearLayout)v.findViewById(R.id.principal_home_attendance_layout);
        mLayoutPermissions=(LinearLayout)v.findViewById(R.id.principal_home_permissions_layout);
        mLayoutGallery=(LinearLayout)v.findViewById(R.id.principal_home_activity_gallery_layout);

        mLabelTecahers=(TextView)v.findViewById(R.id.principal_home_activity_teachers_count_label);
        mLabelStudents=(TextView)v.findViewById(R.id.principal_home_activity_student_count_label);
        mLabelClassRoutines=(TextView)v.findViewById(R.id.principal_home_activity_class_routines_count_label);
        mLabelLEaves=(TextView)v.findViewById(R.id.principal_home_activity_leaves_count_label);
        mLabelAttendance=(TextView)v.findViewById(R.id.principal_home_activity_attendance_count_label);
        mLabelPermissions=(TextView)v.findViewById(R.id.principal_home_activity_permissions_count_label);
        mLabelGallery=(TextView)v.findViewById(R.id.principal_home_activity_activity_gallery_count_label);

        mLayoutTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new TeachersListFragment());

            }
        });

        mLayoutStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new StudentsListFragment());

            }
        });
        mLayoutClassRoutines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new ClassRoutinesFragment());

            }
        });
        mLayoutLeaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LeavesSelectionFragment fragment=new LeavesSelectionFragment();
                fragment.show(getFragmentManager(),"Leaves Fragment");

            }
        });
        mLayoutAattendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AttendanceSelectionFragment fragment=new AttendanceSelectionFragment();
                fragment.show(getFragmentManager(),"Attendance Selection");

            }
        });

        mLayoutPermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissionsSelectinFragment fragment=new PermissionsSelectinFragment();
                fragment.show(getFragmentManager(),"Permissions Fragment");

            }
        });

        mLayoutGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new GalleryFragment());
            }
        });
    }

    private void assignCountsToLabels(String teachers,String students,String classRoutines,String leaves,String atendance,String permissions,String gallery)
    {
        mLabelTecahers.setText(teachers);
        mLabelStudents.setText(students);
        mLabelClassRoutines.setText(classRoutines);
        mLabelLEaves.setText(leaves);
        mLabelAttendance.setText(atendance);
        mLabelPermissions.setText(permissions);
        mLabelGallery.setText(gallery);
    }

    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction fm=getFragmentManager().beginTransaction();
        fm.replace(R.id.principal_home_frame_layout,fragment);
        fm.commit();
    }

}
