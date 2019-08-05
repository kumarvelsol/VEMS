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

import java.util.ArrayList;
import java.util.List;

import igrand.com.vems.R;
import igrand.com.vems.activities.MessageApprovalRejectActivity;
import igrand.com.vems.samplemodelclasses.AdminTeachersList;
import igrand.com.vems.samplemodelclasses.MessageModel;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.MessageListViewHolder> implements Filterable
{
    Context mCtx;
    List<MessageModel> messageModelList;
    List<MessageModel> messageModelsFiltered;
    TextView mLabelMessageDate,mLabelMessageTime,mLabelMessageName,mLabelMessageClass,mLabelMessageContent;
    LinearLayout mLayoutMessageListItem;

    public MessageListAdapter(Context mCtx, List<MessageModel> messageModelList) {
        this.mCtx = mCtx;
        this.messageModelList = messageModelList;
        this.messageModelsFiltered=messageModelList;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    messageModelsFiltered = messageModelList;
                } else {
                    List<MessageModel> filteredList = new ArrayList<>();
                    for (MessageModel row : messageModelList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getMessageName().toLowerCase().contains(charString.toLowerCase()) || row.getMessageDate().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    messageModelsFiltered = messageModelList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = messageModelList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                messageModelsFiltered = (ArrayList<MessageModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MessageListViewHolder extends RecyclerView.ViewHolder
    {
        public MessageListViewHolder(@NonNull View itemView) {
            super(itemView);
            mLabelMessageDate=(TextView)itemView.findViewById(R.id.messages_list_item_label_message_date);
            mLabelMessageTime=(TextView)itemView.findViewById(R.id.messages_list_item_label_message_time);
            mLabelMessageName=(TextView)itemView.findViewById(R.id.messages_list_item_label_message_name);
            mLabelMessageClass=(TextView)itemView.findViewById(R.id.messages_list_item_label_message_person_class);
            mLabelMessageContent=(TextView)itemView.findViewById(R.id.messages_list_item_label_message_content);
            mLayoutMessageListItem=(LinearLayout)itemView.findViewById(R.id.message_list_item);
        }
    }
    @NonNull
    @Override
    public MessageListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MessageListViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.messages_list_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageListViewHolder messageListViewHolder, int i) {
        mLabelMessageDate.setText(messageModelList.get(i).getMessageDate());
        mLabelMessageTime.setText(messageModelList.get(i).getMessageTime());
        mLabelMessageName.setText(messageModelList.get(i).getMessageName());
        mLabelMessageClass.setText(messageModelList.get(i).getMessageClass());
        mLabelMessageContent.setText(messageModelList.get(i).getMessageContent());
        mLayoutMessageListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCtx.startActivity(new Intent(mCtx, MessageApprovalRejectActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return messageModelList.size();
    }


}
