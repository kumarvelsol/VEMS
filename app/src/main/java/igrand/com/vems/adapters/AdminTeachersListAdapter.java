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
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import igrand.com.vems.R;
import igrand.com.vems.activities.admin.AddTeacherActivty;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.helpers.AppConstants;
import igrand.com.vems.responses.Data;
import igrand.com.vems.samplemodelclasses.AdminTeachersList;

public class AdminTeachersListAdapter extends RecyclerView.Adapter<AdminTeachersListAdapter.AdminTeachersListViewHolder> implements Filterable
{
    List<Data> adminTeachersListList;
    Context mCtx;
    TextView mLabelTeacherId,mLabelTeacherName,mLabelTeacherJoingDate,mLabelTeacherQly,mLabelTeacherMobile,mLabelTeacherTimings;
    CircleImageView mImageTeacherImage;
    ImageButton mImBtnEdit;
    List<Data> adminTeachersListsFiltered;
    String login_type;
    Data adminTeacherData;

    public AdminTeachersListAdapter(List<Data> adminTeachersListList, Context mCtx,String login_type) {
        this.adminTeachersListList = adminTeachersListList;
        this.adminTeachersListsFiltered=adminTeachersListList;
        this.mCtx = mCtx;
        this.login_type=login_type;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    adminTeachersListsFiltered = adminTeachersListList;
                } else {
                    List<Data> filteredList = new ArrayList<>();
                    for (Data row : adminTeachersListList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getId().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    adminTeachersListsFiltered = adminTeachersListList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = adminTeachersListList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                adminTeachersListsFiltered = (ArrayList<Data>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class AdminTeachersListViewHolder extends RecyclerView.ViewHolder
    {
        public AdminTeachersListViewHolder(@NonNull View itemView) {
            super(itemView);
            mLabelTeacherJoingDate=(TextView)itemView.findViewById(R.id.tecaher_list_recycle_item_label_joining_date);
            mLabelTeacherId=(TextView)itemView.findViewById(R.id.tecaher_list_recycle_item_label_teacher_id);
            mLabelTeacherName=(TextView)itemView.findViewById(R.id.tecaher_list_recycle_item_label_teacher_name);
            mLabelTeacherQly=(TextView)itemView.findViewById(R.id.tecaher_list_recycle_item_label_qualification);
            mLabelTeacherTimings=(TextView)itemView.findViewById(R.id.tecaher_list_recycle_item_label_timings);
            mLabelTeacherMobile=(TextView)itemView.findViewById(R.id.tecaher_list_recycle_item_label_mobile);

            mImageTeacherImage=(CircleImageView)itemView.findViewById(R.id.tecaher_list_recycle_item_circleImageView_teacher_image);
            mImBtnEdit=(ImageButton)itemView.findViewById(R.id.tecaher_list_recycle_item_image_button_edit);

            if (login_type.equals(ApplicationPreferences.ADMIN_LOGIN))
            {
                mImBtnEdit.setVisibility(View.VISIBLE);
            }
            else {
                mImBtnEdit.setVisibility(View.GONE);
            }

        }
    }
    @NonNull
    @Override
    public AdminTeachersListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AdminTeachersListViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.admin_teachers_list,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdminTeachersListViewHolder adminTeachersListViewHolder, final int i) {
        mLabelTeacherId.setText(adminTeachersListList.get(i).getId());
        mLabelTeacherJoingDate.setText(adminTeachersListList.get(i).getJoin_date());
        mLabelTeacherMobile.setText(adminTeachersListList.get(i).getMobile1());
        mLabelTeacherQly.setText(adminTeachersListList.get(i).getQualification());
        mLabelTeacherName.setText(adminTeachersListList.get(i).getName());
        mImBtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adminTeacherData=adminTeachersListList.get(i);
                Intent adminTeacherDataIntent=new Intent(mCtx, AddTeacherActivty.class);
                adminTeacherDataIntent.putExtra(AppConstants.TEACHER_DATA_INTENT_KEY,adminTeachersListList.get(i));
                adminTeacherDataIntent.putExtra(AppConstants.TEACHER_DATA_PASSED_OR_NOT,true);
                mCtx.startActivity(adminTeacherDataIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return adminTeachersListList.size();
    }

    @Override
    public long getItemId(int position) {
       return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
