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
import igrand.com.vems.adapters.AssignmentsRecycleAdapter;
import igrand.com.vems.samplemodelclasses.AssignmentsModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class AssignmentsFragment extends Fragment {
    RecyclerView mRecycleAssignmentsList;
    List<AssignmentsModel> assignmentsModelList;

    public AssignmentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_assignments, container, false);

        initViews(v);
        getAssignemntsData();
        return v;
    }

    private void initViews(View v) {
        mRecycleAssignmentsList=(RecyclerView)v.findViewById(R.id.admin_assignments_list_recycle);
        assignmentsModelList=new ArrayList<>();
    }

    private void getAssignemntsData()
    {
        assignmentsModelList.add(new AssignmentsModel("Assignments-1","Science","4th Class","Prabhakar"));
        assignmentsModelList.add(new AssignmentsModel("Assignments-1","Science","4th Class","Prabhakar"));
        assignmentsModelList.add(new AssignmentsModel("Assignments-1","Science","4th Class","Prabhakar"));
        assignmentsModelList.add(new AssignmentsModel("Assignments-1","Science","4th Class","Prabhakar"));
        assignmentsModelList.add(new AssignmentsModel("Assignments-1","Science","4th Class","Prabhakar"));
        assignmentsModelList.add(new AssignmentsModel("Assignments-1","Science","4th Class","Prabhakar"));
        assignmentsModelList.add(new AssignmentsModel("Assignments-1","Science","4th Class","Prabhakar"));
        assignmentsModelList.add(new AssignmentsModel("Assignments-1","Science","4th Class","Prabhakar"));
        assignmentsModelList.add(new AssignmentsModel("Assignments-1","Science","4th Class","Prabhakar"));
        assignmentsModelList.add(new AssignmentsModel("Assignments-1","Science","4th Class","Prabhakar"));
        assignmentsModelList.add(new AssignmentsModel("Assignments-1","Science","4th Class","Prabhakar"));
        assignmentsModelList.add(new AssignmentsModel("Assignments-1","Science","4th Class","Prabhakar"));
        loadDataToRecycle(assignmentsModelList);
    }

    private void loadDataToRecycle(List<AssignmentsModel> assignmentsModelList)
    {
        mRecycleAssignmentsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        AssignmentsRecycleAdapter recycleAdapter=new AssignmentsRecycleAdapter(getActivity(),assignmentsModelList);
        mRecycleAssignmentsList.setAdapter(recycleAdapter);
    }

}
