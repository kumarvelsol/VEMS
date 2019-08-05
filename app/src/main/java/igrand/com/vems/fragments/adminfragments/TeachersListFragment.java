package igrand.com.vems.fragments.adminfragments;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import igrand.com.vems.R;
import igrand.com.vems.adapters.AdminTeachersListAdapter;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.responses.CommonResponse;
import igrand.com.vems.samplemodelclasses.AdminTeachersList;
import igrand.com.vems.services.ApiService;
import igrand.com.vems.services.ServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class TeachersListFragment extends Fragment {
    RecyclerView mRecycleTeachersList;
    List<AdminTeachersList> adminTeachersLists;
    FloatingActionButton addNewTacherBtn;
    ApplicationPreferences preferences;
    ProgressDialog pd;
    public TeachersListFragment() {
        // Required empty public constructor
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_teachers_list, container, false);

        initViews(v);
        loadValuesToRecycleView();
        return v;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("RestrictedApi")
    private void initViews(View v)
    {
        pd=new ProgressDialog(getActivity());
        pd.setTitle("Data Loading");
        pd.setMessage("Please Wait...............!");
        pd.create();
        mRecycleTeachersList=(RecyclerView)v.findViewById(R.id.admin_teachers_list_recycle);
        addNewTacherBtn=(FloatingActionButton)v.findViewById(R.id.teachers_list_fragment_add_teacher_btn);
        preferences=new ApplicationPreferences(getContext());
        adminTeachersLists=new ArrayList<>();
        if (preferences.getLoginTYpe().equals(ApplicationPreferences.ADMIN_LOGIN))
        {
            addNewTacherBtn.setVisibility(View.VISIBLE);
        }
        addNewTacherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fm=getFragmentManager().beginTransaction();
                if (preferences.getLoginTYpe().equals(ApplicationPreferences.ADMIN_LOGIN)) {
//                    getActivity().finish();
//                    startActivity(new Intent(getActivity(), AddTeacherActivty.class));
                    loadFragment(new AddTeacherFragment());
                }
            }
        });

    }
    private void loadValuesToRecycleView()
    {
        pd.show();
       Call<CommonResponse> teachersListCall= ServiceClient.getApiClient().create(ApiService.class).getTeacheresList();

       teachersListCall.enqueue(new Callback<CommonResponse>() {
           @Override
           public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
               if (response.isSuccessful()){
             AdminTeachersListAdapter adapter= new AdminTeachersListAdapter(response.body().getData(),getActivity(),preferences.getLoginTYpe());
               mRecycleTeachersList.setLayoutManager(new LinearLayoutManager(getContext()));
               mRecycleTeachersList.setHasFixedSize(true);

               mRecycleTeachersList.setAdapter(adapter);
               pd.hide();
               }
               else {
                   pd.hide();
               }
           }
           @Override
           public void onFailure(Call<CommonResponse> call, Throwable t) {
               pd.hide();

           }
       });
    }
    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction fm=getFragmentManager().beginTransaction();
        fm.replace(R.id.admin_home_frame_layout,fragment);
        fm.commit();
    }

}
