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
import igrand.com.vems.adapters.PermissionsListAdapter;
import igrand.com.vems.samplemodelclasses.PermissionModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class PermissionsFragment extends Fragment {

    RecyclerView mRecyclePermissionsList;
    List<PermissionModel> permissionModelList;
    public PermissionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_permissions, container, false);
        initViews(v);
        getPermissionsData();
        return v;
    }

    private void getPermissionsData()
    {
        permissionModelList.add(new PermissionModel("24-Apr-2019","10:56 Am","Karl Marx",
                "5th Class","3 hrs","Rejected","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        permissionModelList.add(new PermissionModel("24-Apr-2019","10:56 Am","Karl Marx",
                "5th Class","3 hrs","Rejected","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        permissionModelList.add(new PermissionModel("24-Apr-2019","10:56 Am","Karl Marx",
                "5th Class","3 hrs","Rejected","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        permissionModelList.add(new PermissionModel("24-Apr-2019","10:56 Am","Karl Marx",
                "5th Class","3 hrs","Rejected","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        permissionModelList.add(new PermissionModel("24-Apr-2019","10:56 Am","Karl Marx",
                "5th Class","3 hrs","Rejected","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        permissionModelList.add(new PermissionModel("24-Apr-2019","10:56 Am","Karl Marx",
                "5th Class","3 hrs","Rejected","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        permissionModelList.add(new PermissionModel("24-Apr-2019","10:56 Am","Karl Marx",
                "5th Class","3 hrs","Rejected","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        permissionModelList.add(new PermissionModel("24-Apr-2019","10:56 Am","Karl Marx",
                "5th Class","3 hrs","Rejected","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        permissionModelList.add(new PermissionModel("24-Apr-2019","10:56 Am","Karl Marx",
                "5th Class","3 hrs","Rejected","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        permissionModelList.add(new PermissionModel("24-Apr-2019","10:56 Am","Karl Marx",
                "5th Class","3 hrs","Rejected","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        permissionModelList.add(new PermissionModel("24-Apr-2019","10:56 Am","Karl Marx",
                "5th Class","3 hrs","Rejected","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        permissionModelList.add(new PermissionModel("24-Apr-2019","10:56 Am","Karl Marx",
                "5th Class","3 hrs","Rejected","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        permissionModelList.add(new PermissionModel("24-Apr-2019","10:56 Am","Karl Marx",
                "5th Class","3 hrs","Rejected","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));

        loadDataToRecucleView(permissionModelList);

    }

    private void loadDataToRecucleView(List<PermissionModel> permissionModelList)
    {
        mRecyclePermissionsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        PermissionsListAdapter adapter= new PermissionsListAdapter(getActivity(),permissionModelList);
        mRecyclePermissionsList.setAdapter(adapter);
    }

    private void initViews(View v)
    {
        mRecyclePermissionsList=(RecyclerView)v.findViewById(R.id.admin_permission_list_recycle);
        permissionModelList=new ArrayList<>();
    }

}
