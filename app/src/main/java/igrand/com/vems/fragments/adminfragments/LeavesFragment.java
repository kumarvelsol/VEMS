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
import igrand.com.vems.adapters.LeaveRecycleAdapter;
import igrand.com.vems.samplemodelclasses.AdminLeavesList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeavesFragment extends Fragment {
    RecyclerView mRecycleLeavesLis;
    List<AdminLeavesList> adminLeavesLists;

    public LeavesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_leaves, container, false);
        initVIews(v);
        getLeavesList();
        return v;
    }

    private void initVIews(View v)
    {
        mRecycleLeavesLis=(RecyclerView)v.findViewById(R.id.admin_leaves_list_recycle);
        adminLeavesLists=new ArrayList<>();
    }
    private void getLeavesList()
    {
        adminLeavesLists.add(new AdminLeavesList("Veerabadhar","","24 Apr","1 day","4th Class","Rejected"));
        adminLeavesLists.add(new AdminLeavesList("Veerabadhar","","24 Apr","1 day","4th Class","Rejected"));
        adminLeavesLists.add(new AdminLeavesList("Veerabadhar","","24 Apr","1 day","4th Class","Rejected"));
        adminLeavesLists.add(new AdminLeavesList("Veerabadhar","","24 Apr","1 day","4th Class","Rejected"));
        adminLeavesLists.add(new AdminLeavesList("Veerabadhar","","24 Apr","1 day","4th Class","Rejected"));
        adminLeavesLists.add(new AdminLeavesList("Veerabadhar","","24 Apr","1 day","4th Class","Rejected"));
        adminLeavesLists.add(new AdminLeavesList("Veerabadhar","","24 Apr","1 day","4th Class","Rejected"));
        adminLeavesLists.add(new AdminLeavesList("Veerabadhar","","24 Apr","1 day","4th Class","Rejected"));
        adminLeavesLists.add(new AdminLeavesList("Veerabadhar","","24 Apr","1 day","4th Class","Rejected"));
        adminLeavesLists.add(new AdminLeavesList("Veerabadhar","","24 Apr","1 day","4th Class","Rejected"));
        adminLeavesLists.add(new AdminLeavesList("Veerabadhar","","24 Apr","1 day","4th Class","Rejected"));
        loadDataToRecycle(adminLeavesLists);
    }

    private void loadDataToRecycle(List<AdminLeavesList> adminLeavesLists1) {
        mRecycleLeavesLis.setLayoutManager(new LinearLayoutManager(getActivity()));
        LeaveRecycleAdapter adapter=new LeaveRecycleAdapter(getActivity(),adminLeavesLists1);
        mRecycleLeavesLis.setAdapter(adapter);
    }

}
