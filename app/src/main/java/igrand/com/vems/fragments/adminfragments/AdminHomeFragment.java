package igrand.com.vems.fragments.adminfragments;


import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import igrand.com.vems.R;
import igrand.com.vems.dialogs.AttendanceSelectionFragment;
import igrand.com.vems.dialogs.LeavesSelectionFragment;
import igrand.com.vems.dialogs.PermissionsSelectinFragment;
import igrand.com.vems.responses.Counts;
import igrand.com.vems.responses.HomeScreenCountResponse;
import igrand.com.vems.services.ApiService;
import igrand.com.vems.services.ServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminHomeFragment extends Fragment  {
    LinearLayout mLayoutTeachers,mLayoutStudents,mLayoutClassRoutines,mLayoutAssignments,mLayoutLeaves,mLayoutPermssions,
    mLayoutMessages,mLayoutAttendance,mLayoutActivityGallery;
    TextView mLabelTeachersCount,mLabelStudentsCount,mLabelClassRoutinesCount,mLabelAssignmentsCount,mLabelLeavesCount,mLabelPermssionsCount,
            mLabelMessagesCount,mLabelAttendanceCount,mLabelGalleryCount;
    ProgressDialog pd;


    public AdminHomeFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_admin_home, container, false);
        initViews(v);
        getCountsForDashBoard();
        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initViews(View v)
    {
        pd=new ProgressDialog(getActivity());
        pd.setTitle("Data Laoding");
        pd.setMessage("Please Wait...................!");
        pd.create();
        mLayoutTeachers=(LinearLayout)v.findViewById(R.id.admin_home_techers_layout);
        mLayoutStudents=(LinearLayout)v.findViewById(R.id.admin_home_students_layout);
        mLayoutClassRoutines=(LinearLayout)v.findViewById(R.id.admin_home_class_routines_layout);
        mLayoutAssignments=(LinearLayout)v.findViewById(R.id.admin_home_assignmets_layout);
        mLayoutLeaves=(LinearLayout)v.findViewById(R.id.admin_home_leaves_layout);
        mLayoutPermssions=(LinearLayout)v.findViewById(R.id.admin_home_permissions_layout);
        mLayoutMessages=(LinearLayout)v.findViewById(R.id.admin_home_messages_layout);
        mLayoutAttendance=(LinearLayout)v.findViewById(R.id.admin_home_attendance_layout);
        mLayoutActivityGallery=(LinearLayout)v.findViewById(R.id.admin_home_activity_gallery_layout);

        mLabelTeachersCount=(TextView)v.findViewById(R.id.admin_home_activity_teachers_count_label);
        mLabelStudentsCount=(TextView)v.findViewById(R.id.admin_home_activity_students_count_label);
        mLabelClassRoutinesCount=(TextView)v.findViewById(R.id.admin_home_activity_class_routines_count_label);
        mLabelAssignmentsCount=(TextView)v.findViewById(R.id.admin_home_activity_assignments_count_label);
        mLabelLeavesCount=(TextView)v.findViewById(R.id.admin_home_activity_leaves_count_label);
        mLabelPermssionsCount=(TextView)v.findViewById(R.id.admin_home_activity_permssions_count_label);
        mLabelMessagesCount=(TextView)v.findViewById(R.id.admin_home_activity_messages_count_label);
        mLabelAttendanceCount=(TextView)v.findViewById(R.id.admin_home_activity_attendance_label);
        mLabelGalleryCount=(TextView)v.findViewById(R.id.admin_home_activity_gallery_count_label);

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
        mLayoutAssignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AssignmentsFragment());

            }
        });
        mLayoutLeaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LeavesSelectionFragment fragment=new LeavesSelectionFragment();
                fragment.show(getFragmentManager(),"Leaves Fragment");
            }
        });
        mLayoutPermssions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissionsSelectinFragment fragment=new PermissionsSelectinFragment();
                fragment.show(getFragmentManager(),"Permissions Fragment");

            }
        });
        mLayoutMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    loadFragment(new AdminMessagesFragment());
            }
        });
        mLayoutAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AttendanceSelectionFragment fragment=new AttendanceSelectionFragment();
                fragment.show(getFragmentManager(),"Attendance Selection");
            }
        });
        mLayoutActivityGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new GalleryFragment());

            }
        });

    }
    private void setCountsForDashboard(String teachersCount,String studentsCount,String classRountines,String assignments,String leaves,
                                       String permissions,String messages,String attendance,String activityGallery)
    {
        mLabelStudentsCount.setText(studentsCount);
        mLabelTeachersCount.setText(teachersCount);
        mLabelLeavesCount.setText(leaves);
        mLabelPermssionsCount.setText(permissions);
        mLabelAssignmentsCount.setText(assignments);
        mLabelClassRoutinesCount.setText(classRountines);
        mLabelAttendanceCount.setText(attendance);
        mLabelMessagesCount.setText(messages);
        mLabelGalleryCount.setText(activityGallery);
    }
    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction fm=getFragmentManager().beginTransaction();
        fm.replace(R.id.admin_home_frame_layout,fragment);
        fm.commit();
    }

    private void getCountsForDashBoard(){
        pd.show();
        ServiceClient.getApiClient().create(ApiService.class).getHomeScreenCounts()
                .enqueue(new Callback<HomeScreenCountResponse>() {
                    @Override
                    public void onResponse(Call<HomeScreenCountResponse> call, Response<HomeScreenCountResponse> response) {
                        if (response.isSuccessful())
                        {
                            if (response.body().getStatus()==1){
                               //Counts counts= response.body().getData().getCounts();

                               setCountsForDashboard(response.body().getData().getCounts().getCountTeachers(),response.body().getData().getCounts().getCountStudents(),
                                       response.body().getData().getCounts().getCountClasses(),"00",response.body().getData().getCounts().getCountLeaves(),
                                       response.body().getData().getCounts().getCounPermissions(),"00",response.body().getData().getCounts().getCountAttendance(),"00");
                               pd.dismiss();
                            }
                            else {
                                pd.dismiss();
                                Toast.makeText(getActivity(), "Falied to fetch the Data", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            pd.dismiss();
                            Toast.makeText(getActivity(), "Something Away", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<HomeScreenCountResponse> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(getActivity(), "Something Went Wrong", Toast.LENGTH_SHORT).show();

                    }
                });
    }



}
