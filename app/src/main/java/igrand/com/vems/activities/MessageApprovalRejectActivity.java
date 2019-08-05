package igrand.com.vems.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
import igrand.com.vems.R;

public class MessageApprovalRejectActivity extends AppCompatActivity {
    TextView mLabelMessageApproveRejectStudenTName,mLabelMessageApproveRejectStudentRollno,mLabelMessageApproveRejectStudenTClass,
            mLabelMessageApproveRejectMessageContent;
    CircleImageView mImageStudentImage;
    Button mBtnMessageApprove,mBtnMessageReject;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_approval_reject);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.pink_back_btn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));
        initViews();
    }
    private void initViews()
    {
        mLabelMessageApproveRejectStudenTName=(TextView)findViewById(R.id.message_approval_reject_label_student_name);
        mLabelMessageApproveRejectStudentRollno=(TextView)findViewById(R.id.message_approval_reject_label_roll_no);
        mLabelMessageApproveRejectStudenTClass=(TextView)findViewById(R.id.message_approval_reject_label_student_class);
        mLabelMessageApproveRejectMessageContent=(TextView)findViewById(R.id.message_approval_reject_label_content);

        mImageStudentImage=(CircleImageView)findViewById(R.id.message_approval_reject_image_student_image);

        mBtnMessageApprove=(Button)findViewById(R.id.message_approval_reject_btn_approve);
        mBtnMessageReject=(Button)findViewById(R.id.message_approval_reject_btn_reject);

        mBtnMessageReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MessageApprovalRejectActivity.this, "Message Request Approved", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(MessageApprovalRejectActivity.this,AdminDashboardActivity.class));

            }
        });
        mBtnMessageApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MessageApprovalRejectActivity.this, "Message Request Denied", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(MessageApprovalRejectActivity.this,AdminDashboardActivity.class));
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                super.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
