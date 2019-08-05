package igrand.com.vems.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import igrand.com.vems.R;

public class NewPasswordCreationFragment extends BottomSheetDialogFragment
{
    TextInputEditText mInputPassword,mInputConfirmPassword;
    Button mBtnSubmit;
    public NewPasswordCreationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View v= inflater.inflate(R.layout.new_password_creation_fragment,container,false);
         initViews(v);
         return v;
    }
    private void initViews(View v)
    {
        mInputPassword=(TextInputEditText)v.findViewById(R.id.password_creation_password_input);
        mInputConfirmPassword=(TextInputEditText)v.findViewById(R.id.password_creation_confirm_password_input);
        mBtnSubmit=(Button)v.findViewById(R.id.password_creation_submit_btn);
        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass=mInputPassword.getText().toString().trim();
                String cPass=mInputConfirmPassword.getText().toString().trim();

                if (pass.isEmpty())
                {
                    mInputPassword.setError("Empty");
                    mInputPassword.requestFocus();
                }
                else if (cPass.isEmpty())
                {
                    mInputConfirmPassword.setError("Empty");
                    mInputConfirmPassword.requestFocus();
                }
                else if (!pass.equals(cPass))
                {
                    Toast.makeText(getActivity(), "Passwords must be same", Toast.LENGTH_SHORT).show();
                }
                else {

                }
            }
        });
    }

}
