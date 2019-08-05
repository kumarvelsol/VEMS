package igrand.com.vems.fragments.adminfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import igrand.com.vems.R;
import igrand.com.vems.adapters.ClassRoutineAdapter;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.samplemodelclasses.AdminClassRoutines;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassRoutinesFragment extends Fragment {
    RecyclerView mRecycleClassRoutinesList;
    List<AdminClassRoutines> adminClassRoutines;
    ApplicationPreferences preferences;


    public ClassRoutinesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_class_routines, container, false);
        initViews(v);
        getClassRoutines();
        return v;
    }

    private void initViews(View v)
    {
        mRecycleClassRoutinesList=(RecyclerView)v.findViewById(R.id.admin_class_routines_list_recycle);
        adminClassRoutines=new ArrayList<>();
        preferences=new ApplicationPreferences(getActivity());
    }
    private void getClassRoutines()
    {
        adminClassRoutines.add(new AdminClassRoutines("4th Class","English","1","Tue: 8.40 Am -9.15 Am"));
        adminClassRoutines.add(new AdminClassRoutines("4th Class","English","1","Tue: 8.40 Am -9.15 Am"));
        adminClassRoutines.add(new AdminClassRoutines("4th Class","English","1","Tue: 8.40 Am -9.15 Am"));
        adminClassRoutines.add(new AdminClassRoutines("4th Class","English","1","Tue: 8.40 Am -9.15 Am"));
        adminClassRoutines.add(new AdminClassRoutines("4th Class","English","1","Tue: 8.40 Am -9.15 Am"));
        adminClassRoutines.add(new AdminClassRoutines("4th Class","English","1","Tue: 8.40 Am -9.15 Am"));
        adminClassRoutines.add(new AdminClassRoutines("4th Class","English","1","Tue: 8.40 Am -9.15 Am"));
        adminClassRoutines.add(new AdminClassRoutines("4th Class","English","1","Tue: 8.40 Am -9.15 Am"));
        adminClassRoutines.add(new AdminClassRoutines("4th Class","English","1","Tue: 8.40 Am -9.15 Am"));
        loadToRecycle(adminClassRoutines);
    }
    private void loadToRecycle(List<AdminClassRoutines> adminClassRoutinesList)
    {
        ClassRoutineAdapter routineAdapter=new ClassRoutineAdapter(adminClassRoutinesList,getActivity(),preferences.getLoginTYpe());
        mRecycleClassRoutinesList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycleClassRoutinesList.setAdapter(routineAdapter);
    }

}
