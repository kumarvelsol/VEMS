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

import de.hdodenhof.circleimageview.CircleImageView;
import igrand.com.vems.R;
import igrand.com.vems.activities.admin.LeaveApprovalRejectActivity;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.samplemodelclasses.AdminLeavesList;

public class LeaveRecycleAdapter extends RecyclerView.Adapter<LeaveRecycleAdapter.LeavesViewHolder> implements Filterable {
    Context mCtx;
    List<AdminLeavesList> adminLeavesLists;
    List<AdminLeavesList> adminLeavesListsFiltered;
    CircleImageView mImageStudent;
    TextView mLabelStudentName,mLabelStudentClass,mLabelLeaveDate,mLabelLeaveDays,mLabelLeaveStstus;
    LinearLayout mLayoutLeaveListItem;
    ApplicationPreferences preferences;
    

    public LeaveRecycleAdapter(Context mCtx, List<AdminLeavesList> adminLeavesLists) {
        this.mCtx = mCtx;
        this.adminLeavesLists = adminLeavesLists;
        this.adminLeavesListsFiltered=adminLeavesLists;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    adminLeavesListsFiltered = adminLeavesLists;
                } else {
                    List<AdminLeavesList> filteredList = new ArrayList<>();
                    for (AdminLeavesList row : adminLeavesLists) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getStudentName().toLowerCase().contains(charString.toLowerCase()) || row.getDate().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    adminLeavesListsFiltered = adminLeavesLists;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = adminLeavesLists;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                adminLeavesListsFiltered = (ArrayList<AdminLeavesList>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class LeavesViewHolder extends RecyclerView.ViewHolder
    {

        public LeavesViewHolder(@NonNull View itemView) {
            super(itemView);
            mLabelLeaveStstus=(TextView)itemView.findViewById(R.id.admin_leaves_list_label_status);
            mLabelStudentName=(TextView)itemView.findViewById(R.id.admin_leaves_list_label_student_name);
            mLabelStudentClass=(TextView)itemView.findViewById(R.id.admin_leaves_list_label_class);
            mLabelLeaveDays=(TextView)itemView.findViewById(R.id.admin_leaves_list_label_date_days);
            mLayoutLeaveListItem=(LinearLayout)itemView.findViewById(R.id.leave_list_item_layout);
        }
    }

    @NonNull
    @Override
    public LeavesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new LeavesViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.admin_leaves_list_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LeavesViewHolder leavesViewHolder, int i) {
        mLabelStudentName.setText(adminLeavesLists.get(i).getStudentName());
        mLabelStudentClass.setText(adminLeavesLists.get(i).getStudentClass());
        mLabelLeaveStstus.setText(adminLeavesLists.get(i).getLeaveStatus());
        mLabelLeaveDays.setText(adminLeavesLists.get(i).getDate()+" - "+adminLeavesLists.get(i).getDays());
        mLayoutLeaveListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences=new ApplicationPreferences(mCtx);
                if (preferences.getLoginTYpe().equalsIgnoreCase(ApplicationPreferences.ADMIN_LOGIN)) {
                    mCtx.startActivity(new Intent(mCtx, LeaveApprovalRejectActivity.class));
                }
                else {
                    Toast.makeText(mCtx, "", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return adminLeavesLists.size();
    }



}
