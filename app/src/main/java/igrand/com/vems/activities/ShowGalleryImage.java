package igrand.com.vems.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.squareup.picasso.Picasso;

import igrand.com.vems.R;

public class ShowGalleryImage extends AppCompatActivity {
    ImageView mselected_image;
    ZoomControls selected_image_zooming;
    ImageButton mcancel_gallery_image_show;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_gallery_images);
        getSupportActionBar().hide();

        mselected_image = (ImageView)findViewById(R.id.gallery_selected_image_preview);
        selected_image_zooming = (ZoomControls)findViewById(R.id.zc1);
        mcancel_gallery_image_show = (ImageButton)findViewById(R.id.cancel_gallery_image_show);
        Bundle getting_selected_image_url = getIntent().getExtras();

        if(getting_selected_image_url == null) {
            Toast.makeText(this,"Something went Wrong", Toast.LENGTH_SHORT).show();
        } else {
            String url= getting_selected_image_url.getString("url");
            Picasso.get().load(url).into(mselected_image);
        }

        mcancel_gallery_image_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        selected_image_zooming.setOnZoomInClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                float x = mselected_image.getScaleX();
                float y = mselected_image.getScaleY();
                if(x<=4 && y<=4) {
                    mselected_image.setScaleX(x + 0.2f);
                    mselected_image.setScaleY(y + 0.2f);
                    selected_image_zooming.setIsZoomOutEnabled(true);
                }
                else{
                    selected_image_zooming.setIsZoomInEnabled(false);
                }
            }
        });
        selected_image_zooming.setOnZoomOutClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                float x = mselected_image.getScaleX();
                float y = mselected_image.getScaleY();

                if(x>=0.5 && y>=0.5)
                {
                    mselected_image.setScaleX(x - 0.2f);
                    mselected_image.setScaleY(y - 0.2f);
                    selected_image_zooming.setIsZoomInEnabled(true);
                }
                else{
                    selected_image_zooming.setIsZoomOutEnabled(false);
                }
            }
        });
    }

}
