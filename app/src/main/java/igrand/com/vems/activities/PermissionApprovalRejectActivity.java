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

public class PermissionApprovalRejectActivity extends AppCompatActivity {
    TextView mLabelPermissionApprovalRejectDate,mLabelPermissionApprovalRejectTime,mLabelPermissionApprovalRejectStudenTName,
            mLabelPermissionApprovalRejectStudenTRollNo,mLabelPermissionApprovalRejectClass,mLabelPermissionApprovalRejectReason,
            mLabelPermissionApprovalRejectDescription;
    CircleImageView mImageStudentImage;
    Button mBtnPermissionApprovalRejectApprove,mBtnPermissionApprovalRejectReject;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_approval_reject);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.green_back_btn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));
        initVIews();
    }
    private void initVIews()
    {
        mLabelPermissionApprovalRejectDate=(TextView)findViewById(R.id.permission_approval_reject_label_date);
        mLabelPermissionApprovalRejectTime=(TextView)findViewById(R.id.permission_approval_reject_label_time);
        mLabelPermissionApprovalRejectStudenTName=(TextView)findViewById(R.id.permission_approval_reject_label_student_name);
        mLabelPermissionApprovalRejectStudenTRollNo=(TextView)findViewById(R.id.permission_approval_reject_label_roll_no);
        mLabelPermissionApprovalRejectClass=(TextView)findViewById(R.id.permission_approval_reject_label_student_class);
        mLabelPermissionApprovalRejectReason=(TextView)findViewById(R.id.permission_approval_reject_label_reason);
        mLabelPermissionApprovalRejectDescription=(TextView)findViewById(R.id.permission_approval_reject_label_description);
        mImageStudentImage=(CircleImageView)findViewById(R.id.leave_approve_reject_image_student_image);
        mBtnPermissionApprovalRejectApprove=(Button)findViewById(R.id.permission_approval_reject_btn_approve);
        mBtnPermissionApprovalRejectReject=(Button)findViewById(R.id.permission_approval_reject_btn_reject);

        mBtnPermissionApprovalRejectApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PermissionApprovalRejectActivity.this, "Permission Approved", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(PermissionApprovalRejectActivity.this,AdminDashboardActivity.class));
            }
        });

        mBtnPermissionApprovalRejectReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PermissionApprovalRejectActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(PermissionApprovalRejectActivity.this,AdminDashboardActivity.class));
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
