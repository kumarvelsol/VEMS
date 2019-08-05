package igrand.com.vems.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import igrand.com.vems.R;
import igrand.com.vems.activities.ShowGalleryImage;
import igrand.com.vems.samplemodelclasses.GalleryModel;

public class CustomGalleryAdapter extends BaseAdapter {
    public Context GalleryGridFragment;
    List<GalleryModel> GalleryModel;

    public CustomGalleryAdapter(List<GalleryModel> GalleryModel, Context galleryGridFragment)
    {
        this.GalleryModel = GalleryModel;
        GalleryGridFragment = galleryGridFragment;
    }
    @Override
    public int getCount()
    {
        return GalleryModel.size();
    }
    @Override
    public Object getItem(int i)
    {
        return GalleryModel.get(i);
    }
    @Override
    public long getItemId(int i)
    {
        return 0;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup)
    {
        View grid;
        LayoutInflater inflater = (LayoutInflater) GalleryGridFragment.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            grid = new View(GalleryGridFragment);
            grid = inflater.inflate(R.layout.gallery_screen,null);

            final ImageView image=(ImageView)grid.findViewById(R.id.gallery);
            image.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View view)
                {
                    String url = GalleryModel.get(i).getImage();
                    Intent gallery_image_showing_intent = new Intent (GalleryGridFragment, ShowGalleryImage.class);
                    gallery_image_showing_intent.putExtra( "url",url);
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) GalleryGridFragment, (View)image, "galleryimage");
                    GalleryGridFragment.startActivity(gallery_image_showing_intent,options.toBundle());
                }
            });
            //Picasso.with(GalleryGridFragment).load(GalleryModel.get(i).getImage()).into(image);
            Picasso.get().load(GalleryModel.get(i).getImage()).into(image);
        }
        else
        {
            grid = (View) view;
        }
        return grid;
    }
}
