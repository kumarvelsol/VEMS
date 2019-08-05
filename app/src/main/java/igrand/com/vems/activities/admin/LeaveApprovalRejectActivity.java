package igrand.com.vems.activities.admin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
import igrand.com.vems.R;
import igrand.com.vems.activities.AdminDashboardActivity;

public class LeaveApprovalRejectActivity extends AppCompatActivity {
    CircleImageView mImageStudent;
    TextView mLabelLeaveApproveRejectStudentName,mLabelLeaveApproveRejectStudentRollNo,mLabelLeaveApproveRejectStudentClass,
            mLabelLeaveApproveRejectReason,mLabelLeaveApproveRejectFromDate,mLabelLeaveApproveRejectTodate,mLabelLeaveApproveRejectDescription;
    Button mBtnLeaveApproveRejectApprove,mBtnLeaveApproveRejectReject;
    private RelativeLayout errorLayout;
    private ImageView errorImage;
    private TextView errorTitle,errorMessage;
    Button btnRetry;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_approval_reject);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.blue_back_btn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));
        initViews();
    }
    private void initViews()
    {
        mImageStudent=(CircleImageView)findViewById(R.id.leave_approve_reject_image_student_image);
        mLabelLeaveApproveRejectStudentName=(TextView)findViewById(R.id.leave_approve_reject_leabel_student_name);
        mLabelLeaveApproveRejectStudentRollNo=(TextView)findViewById(R.id.leave_approve_reject_leabel_student_rollno);
        mLabelLeaveApproveRejectStudentClass=(TextView)findViewById(R.id.leave_approve_reject_leabel_student_class);
        mLabelLeaveApproveRejectFromDate=(TextView)findViewById(R.id.leave_approve_reject_leabel_from_date);
        mLabelLeaveApproveRejectTodate=(TextView)findViewById(R.id.leave_approve_reject_leabel_to_date);
        mLabelLeaveApproveRejectReason=(TextView)findViewById(R.id.leave_approve_reject_leabel_reason);
        mLabelLeaveApproveRejectDescription=(TextView)findViewById(R.id.leave_approve_reject_leabel_description);
        mBtnLeaveApproveRejectApprove=(Button)findViewById(R.id.leave_approve_reject_btn_approve);
        mBtnLeaveApproveRejectReject=(Button)findViewById(R.id.leave_approve_reject_btn_reject);
        errorLayout=(RelativeLayout)findViewById(R.id.errorLayout);
        errorImage=(ImageView)findViewById(R.id.errorImage);
        errorTitle=(TextView)findViewById(R.id.errorTitle);
        errorMessage=(TextView)findViewById(R.id.errorMessage);
        btnRetry=(Button)findViewById(R.id.btnRetry);

        mBtnLeaveApproveRejectApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LeaveApprovalRejectActivity.this, "Leave Approved", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(LeaveApprovalRejectActivity.this, AdminDashboardActivity.class));

            }
        });
        mBtnLeaveApproveRejectReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LeaveApprovalRejectActivity.this, "Leave Rejected", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(LeaveApprovalRejectActivity.this,AdminDashboardActivity.class));

            }
        });
    }
    private void assignValues()
    {

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
    private void showErrorMessage(int imageView, String title,String message)
    {
        if (errorLayout.getVisibility()==View.GONE)
        {
            errorLayout.setVisibility(View.VISIBLE);
        }
        errorImage.setImageResource(imageView);
        errorTitle.setText(title);
        errorMessage.setText(message);

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
