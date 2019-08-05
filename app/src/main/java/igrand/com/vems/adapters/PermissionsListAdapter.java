package igrand.com.vems.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import igrand.com.vems.R;
import igrand.com.vems.activities.PermissionApprovalRejectActivity;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.samplemodelclasses.AdminTeachersList;
import igrand.com.vems.samplemodelclasses.PermissionModel;

public class PermissionsListAdapter extends RecyclerView.Adapter<PermissionsListAdapter.PermissionViewHolder> implements Filterable
{
    Context mCtx;
    List<PermissionModel> permissionModels;
    List<PermissionModel> permissionModelsFilterable;
    TextView mLabelPermssionDate,mLabelPermissionTime,mLabelPermissionStudentName,mLabelPermissionStudentClass,
            mLabelPermissionDuration,mLabelPermissionStatus,mLabelPermissionData;
    LinearLayout mLayoutPermissionListItem;
    ApplicationPreferences preferences;

    public PermissionsListAdapter(Context mCtx, List<PermissionModel> permissionModels) {
        this.mCtx = mCtx;
        this.permissionModels = permissionModels;
        this.permissionModelsFilterable=permissionModels;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    permissionModelsFilterable = permissionModels;
                } else {
                    List<PermissionModel> filteredList = new ArrayList<>();
                    for (PermissionModel row : permissionModels) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getPermissionStudentName().toLowerCase().contains(charString.toLowerCase()) || row.getPermissionStudentClass().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    permissionModelsFilterable = permissionModels;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = permissionModels;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                permissionModelsFilterable = (ArrayList<PermissionModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class PermissionViewHolder extends RecyclerView.ViewHolder
    {

        public PermissionViewHolder(@NonNull View itemView) {
            super(itemView);
            mLabelPermssionDate=(TextView)itemView.findViewById(R.id.permission_list_recycle_item_label_permission_date);
            mLabelPermissionTime=(TextView)itemView.findViewById(R.id.permission_list_recycle_item_label_permission_time);
            mLabelPermissionStudentName=(TextView)itemView.findViewById(R.id.permission_list_recycle_item_label_student_name);
            mLabelPermissionStudentClass=(TextView)itemView.findViewById(R.id.permission_list_recycle_item_label_class);
            mLabelPermissionDuration=(TextView)itemView.findViewById(R.id.permission_list_recycle_item_label_permission_duration);
            mLabelPermissionStatus=(TextView)itemView.findViewById(R.id.permission_list_recycle_item_label_status);
            mLabelPermissionData=(TextView)itemView.findViewById(R.id.permission_list_recycle_item_label_data);
            mLayoutPermissionListItem=(LinearLayout)itemView.findViewById(R.id.permission_list_item_layout);
        }
    }
    @NonNull
    @Override
    public PermissionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PermissionViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.permissions_list_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PermissionViewHolder permissionViewHolder, int i) {
        mLabelPermssionDate.setText(permissionModels.get(i).getPermissionDate());
        mLabelPermissionTime.setText(permissionModels.get(i).getPermissionTime());
        mLabelPermissionStudentName.setText(permissionModels.get(i).getPermissionStudentName());
        mLabelPermissionStudentClass.setText(permissionModels.get(i).getPermissionStudentClass());
        mLabelPermissionDuration.setText(permissionModels.get(i).getPermissionDuration());
        mLabelPermissionStatus.setText(permissionModels.get(i).getPermissionStatus());
        mLabelPermissionData.setText(permissionModels.get(i).getPermissionData());
        mLayoutPermissionListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences=new ApplicationPreferences(mCtx);
                if (preferences.getLoginTYpe().equalsIgnoreCase(ApplicationPreferences.ADMIN_LOGIN)) {
                    mCtx.startActivity(new Intent(mCtx, PermissionApprovalRejectActivity.class));
                }
                else {
                    Toast.makeText(mCtx, "", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return permissionModels.size();
    }


}
