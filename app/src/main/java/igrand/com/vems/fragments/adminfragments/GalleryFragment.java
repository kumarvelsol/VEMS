package igrand.com.vems.fragments.adminfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import igrand.com.vems.R;
import igrand.com.vems.adapters.CustomGalleryAdapter;
import igrand.com.vems.samplemodelclasses.GalleryModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {
    public GridView mGalleryGridView;
    LinearLayout mgallery_no_images_popup_layout;
    List<GalleryModel> galleryList;


    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_gallery, container, false);
        mGalleryGridView=(GridView) v.findViewById(R.id.galleryGridView);
        mgallery_no_images_popup_layout = (LinearLayout)v.findViewById(R.id.gallery_no_images_popup_layout);
        galleryList=new ArrayList<>();
        getGalleryImages();
        return v;
    }
    public void getGalleryImages()
    {
        galleryList.clear();
        galleryList.add(new GalleryModel("https://www.gstatic.com/webp/gallery3/2.png"));
        galleryList.add(new GalleryModel("https://www.gstatic.com/webp/gallery3/3.png"));
        galleryList.add(new GalleryModel("https://www.gstatic.com/webp/gallery3/4.png"));
        galleryList.add(new GalleryModel("https://www.gstatic.com/webp/gallery3/5.png"));
        galleryList.add(new GalleryModel("https://www.gstatic.com/webp/gallery3/2.png"));
        galleryList.add(new GalleryModel("https://www.gstatic.com/webp/gallery3/3.png"));
        galleryList.add(new GalleryModel("https://www.gstatic.com/webp/gallery3/4.png"));
        galleryList.add(new GalleryModel("https://www.gstatic.com/webp/gallery3/5.png"));
        CustomGalleryAdapter customgallery=new CustomGalleryAdapter(galleryList,getContext());
        mGalleryGridView.setVisibility(View.VISIBLE);
        mgallery_no_images_popup_layout.setVisibility(View.GONE);
        mGalleryGridView.setAdapter(customgallery);
    }

}
