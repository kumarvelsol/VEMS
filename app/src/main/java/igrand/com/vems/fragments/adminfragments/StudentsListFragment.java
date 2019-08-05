package igrand.com.vems.fragments.adminfragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import igrand.com.vems.R;
import igrand.com.vems.adapters.AdminStudentsListAdapter;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.samplemodelclasses.AdminStudentsList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentsListFragment extends Fragment  {
    RecyclerView mListRecycleStudents;
    List<AdminStudentsList> adminStudentsLists;
    SearchView mSearchStudentList;
    AdminStudentsListAdapter adminStudentsListAdapter;
    FloatingActionButton mFABAddStudent;
    ApplicationPreferences preferences;


    public StudentsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_students_list, container, false);
        initViews(v);
        adminStudentsLists=new ArrayList<>();
       getFilteredList();
        getStudentsListData();
        return v;
    }

    @SuppressLint("RestrictedApi")
    private void initViews(View v)
    {
        mListRecycleStudents=(RecyclerView)v.findViewById(R.id.admin_students_list_recycle);
        mSearchStudentList=(SearchView)v.findViewById(R.id.student_list_search_view);
        preferences=new ApplicationPreferences(getContext());
        mFABAddStudent=(FloatingActionButton)v.findViewById(R.id.students_list_fragment_add_teacher_btn);
        if (preferences.getLoginTYpe().equals(ApplicationPreferences.ADMIN_LOGIN))
        {
            mFABAddStudent.setVisibility(View.VISIBLE);
        }
        mFABAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (preferences.getLoginTYpe().equals(ApplicationPreferences.ADMIN_LOGIN)) {
//                    getActivity().finish();
//                   startActivity(new Intent(getActivity(), AddStudentActivity.class));
                    loadFragment(new AddStudentFragment());
                }
            }
        });
    }
    private void getStudentsListData()
    {
        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
//        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
//        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
//        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
//        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
//        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
//        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
//        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
//        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
//        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
//        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
//        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Ramesh Chandra","","Male","Suresh Chandra","909966333","4th Class"));
        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Arun Chandra","","Male","Suresh Chandra","909966333","4th Class"));
        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Arjun Chandra","","Male","Suresh Chandra","909966333","4th Class"));
        adminStudentsLists.add(new AdminStudentsList("RDD111","C1","Aruun Chandra","","Male","Suresh Chandra","909966333","4th Class"));

        bindDataToRecycle(adminStudentsLists);
    }
    private void bindDataToRecycle(final List<AdminStudentsList> adminStudentsLists1)
    {
        adminStudentsListAdapter=new AdminStudentsListAdapter(adminStudentsLists,getActivity(),preferences.getLoginTYpe());
        mListRecycleStudents.setLayoutManager(new LinearLayoutManager(getActivity()));
        mListRecycleStudents.setItemAnimator(new DefaultItemAnimator());
        mListRecycleStudents.setHasFixedSize(true);
        mListRecycleStudents.setAdapter(adminStudentsListAdapter);
//        mListRecycleStudents.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), mListRecycleStudents, new RecyclerTouchListener.ClickListener() {
//            @Override
//            public void onClick(View view, int position)
//            {
//                Toast.makeText(getActivity(), "Seleced Student:"+adminStudentsLists1.get(position).getStudentName(), Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));

    }
    private void getFilteredList()
    {
        mSearchStudentList.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                adminStudentsListAdapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adminStudentsListAdapter.getFilter().filter(s);
                return false;
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
