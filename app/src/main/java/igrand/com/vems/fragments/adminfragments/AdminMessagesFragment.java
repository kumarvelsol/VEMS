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
import igrand.com.vems.adapters.MessageListAdapter;
import igrand.com.vems.samplemodelclasses.MessageModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminMessagesFragment extends Fragment {
    RecyclerView mRecycleMessagesList;
    List<MessageModel> messageModels;


    public AdminMessagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_admin_messages, container, false);

        initvIews(v);
        return v;
    }

    private void initvIews(View v)
    {
        mRecycleMessagesList=(RecyclerView)v.findViewById(R.id.admin_messages_list_recycle);
        messageModels=new ArrayList<>();
        getMessagesData();
    }

    private void getMessagesData()
    {
        messageModels.add(new MessageModel("24.04.2019","5:25 PM","Manoj Kumar","NURSERY","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        messageModels.add(new MessageModel("24.04.2019","5:25 PM","Manoj Kumar","NURSERY","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        messageModels.add(new MessageModel("24.04.2019","5:25 PM","Manoj Kumar","NURSERY","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        messageModels.add(new MessageModel("24.04.2019","5:25 PM","Manoj Kumar","NURSERY","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        messageModels.add(new MessageModel("24.04.2019","5:25 PM","Manoj Kumar","NURSERY","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        messageModels.add(new MessageModel("24.04.2019","5:25 PM","Manoj Kumar","NURSERY","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        messageModels.add(new MessageModel("24.04.2019","5:25 PM","Manoj Kumar","NURSERY","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
            " companies have the digital leave application data format. "));
        messageModels.add(new MessageModel("24.04.2019","5:25 PM","Manoj Kumar","NURSERY","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        messageModels.add(new MessageModel("24.04.2019","5:25 PM","Manoj Kumar","NURSERY","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        messageModels.add(new MessageModel("24.04.2019","5:25 PM","Manoj Kumar","NURSERY","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));
        messageModels.add(new MessageModel("24.04.2019","5:25 PM","Manoj Kumar","NURSERY","Writing a leave application is a good way for requesting leave at work.Nowadays, a lot of\n" +
                " companies have the digital leave application data format. "));

        loadDataToRecycleView(messageModels);

    }

    private void loadDataToRecycleView(List<MessageModel> messageModelsList) {
        MessageListAdapter listAdapter=new MessageListAdapter(getActivity(),messageModelsList);
        mRecycleMessagesList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycleMessagesList.setAdapter(listAdapter);
    }

}
