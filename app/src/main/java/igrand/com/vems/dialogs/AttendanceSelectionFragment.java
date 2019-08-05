package igrand.com.vems.dialogs;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.hdodenhof.circleimageview.CircleImageView;
import igrand.com.vems.R;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.fragments.adminfragments.AdminStudentAttendanceListFragment;
import igrand.com.vems.fragments.adminfragments.AdminTeachersAttendanceListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttendanceSelectionFragment extends AppCompatDialogFragment {
    CircleImageView mImageAttendanceSelectionStudent,mImageAttendanceSelectionTeacher;
    ApplicationPreferences preferences;


    public AttendanceSelectionFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder ad=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.fragment_attendance_selection,null);
        ad.setView(view);
        preferences=new ApplicationPreferences(getActivity());
        ad.setTitle("Select Anyone From it");

        mImageAttendanceSelectionStudent=(CircleImageView)view.findViewById(R.id.attendance_selection_fragment_image_student);
        mImageAttendanceSelectionTeacher=(CircleImageView)view.findViewById(R.id.attendance_selection_fragment_image_teacher);

        mImageAttendanceSelectionStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preferences.getLoginTYpe().equalsIgnoreCase(ApplicationPreferences.ADMIN_LOGIN)) {
                    loadFragment(new AdminStudentAttendanceListFragment(), R.id.admin_home_frame_layout);
                }
                else if (preferences.getLoginTYpe().equalsIgnoreCase(ApplicationPreferences.PRINCIPAL_LOGIN))
                {
                    loadFragment(new AdminStudentAttendanceListFragment(), R.id.principal_home_frame_layout);
                }
                dismiss();
            }
        });

        mImageAttendanceSelectionTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preferences.getLoginTYpe().equalsIgnoreCase(ApplicationPreferences.ADMIN_LOGIN)) {
                    loadFragment(new AdminTeachersAttendanceListFragment(), R.id.admin_home_frame_layout);
                }
                else if (preferences.getLoginTYpe().equalsIgnoreCase(ApplicationPreferences.PRINCIPAL_LOGIN))
                {
                    loadFragment(new AdminTeachersAttendanceListFragment(), R.id.principal_home_frame_layout);
                }
                dismiss();
            }
        });
        return ad.create();
    }
    private void loadFragment(Fragment fragment, int layout_id)
    {
        FragmentTransaction fm=getFragmentManager().beginTransaction();
        fm.replace(layout_id,fragment);
        fm.commit();
    }


}
