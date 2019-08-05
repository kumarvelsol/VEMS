package igrand.com.vems.fragments.parentfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import igrand.com.vems.R;
import igrand.com.vems.fragments.adminfragments.AdminMessagesFragment;
import igrand.com.vems.fragments.adminfragments.AssignmentsFragment;
import igrand.com.vems.fragments.adminfragments.ClassRoutinesFragment;
import igrand.com.vems.fragments.adminfragments.LeavesFragment;
import igrand.com.vems.fragments.adminfragments.PermissionsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParentHomeFragment extends Fragment {
    LinearLayout mLayoutParentHomeProfile,mLayoutParentHomeClassRoutines,mLayoutParentHomeLeaves,mLayoutParentHomeAssignments,
            mLayoutParentHomeMessage,mLayoutParentHomePermissions,mLayoutParentHomeGallery,mLayoutParentHomeAttendance,
            mLayoutParentHomeFees,mLayoutParentHomeREsults;
    TextView mLabelParentHomeClassRoutine,mLabelParentHomeLeaves,mLabelParentHomeAssignments,mLabelParentHomeMessages,
            mLabelParentHomePermissions,mLabelParentHomeGallery,mLabelParentHomeAttendance,mLabelParentHomeStudentFee,mLabelParentHomeResults;



    public ParentHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_parent_home, container, false);
        initvIews(v);
        return v;
    }

    private void initvIews(View v) {
        mLayoutParentHomeProfile=(LinearLayout)v.findViewById(R.id.parent_dashboard_layout_profile);
        mLayoutParentHomeClassRoutines=(LinearLayout)v.findViewById(R.id.parent_dashboard_layout_class_routines);
        mLayoutParentHomeLeaves=(LinearLayout)v.findViewById(R.id.parent_dashboard_layout_leaves);
        mLayoutParentHomeAssignments=(LinearLayout)v.findViewById(R.id.parent_dashboard_layout_assignments);
        mLayoutParentHomeMessage=(LinearLayout)v.findViewById(R.id.parent_dashboard_layout_messages);
        mLayoutParentHomePermissions=(LinearLayout)v.findViewById(R.id.parent_dashboard_layout_permissions);
        mLayoutParentHomeGallery=(LinearLayout)v.findViewById(R.id.parent_dashboard_layout_gallery);
        mLayoutParentHomeAttendance=(LinearLayout)v.findViewById(R.id.parent_dashboard_layout_attendance);
        mLayoutParentHomeFees=(LinearLayout)v.findViewById(R.id.parent_dashboard_layout_student_fee);
        mLayoutParentHomeREsults=(LinearLayout)v.findViewById(R.id.parent_dashboard_layout_results);

        mLabelParentHomeClassRoutine=(TextView)v.findViewById(R.id.parent_home_dashboard_count_label_class_routines);
        mLabelParentHomeLeaves=(TextView)v.findViewById(R.id.parent_home_dashboard_count_label_leaves);
        mLabelParentHomeAssignments=(TextView)v.findViewById(R.id.parent_home_dashboard_count_label_assignments);
        mLabelParentHomeMessages=(TextView)v.findViewById(R.id.parent_home_dashboard_count_label_messages);
        mLabelParentHomePermissions=(TextView)v.findViewById(R.id.parent_home_dashboard_count_label_permissions);
        mLabelParentHomeGallery=(TextView)v.findViewById(R.id.parent_home_dashboard_count_label_gallery);
        mLabelParentHomeAttendance=(TextView)v.findViewById(R.id.parent_home_dashboard_count_label_attendance);
        mLabelParentHomeStudentFee=(TextView)v.findViewById(R.id.parent_home_dashboard_count_label_fee);
        mLabelParentHomeResults=(TextView)v.findViewById(R.id.parent_home_dashboard_count_label_results);

        mLayoutParentHomeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mLayoutParentHomeClassRoutines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new ClassRoutinesFragment());

            }
        });
        mLayoutParentHomeLeaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new LeavesFragment());

            }
        });
        mLayoutParentHomeAssignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AssignmentsFragment());

            }
        });
        mLayoutParentHomeMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AdminMessagesFragment());

            }
        });
        mLayoutParentHomePermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new PermissionsFragment());

            }
        });
        mLayoutParentHomeGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mLayoutParentHomeAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mLayoutParentHomeFees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mLayoutParentHomeREsults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction fm=getFragmentManager().beginTransaction();
        fm.replace(R.id.parent_home_frame_layout,fragment);
        fm.commit();
    }

}
