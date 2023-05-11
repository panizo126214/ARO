package Model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aro.stailishapp.PreviewActivity;
import com.aro.stailishapp.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GalleryItemAdapter extends ArrayAdapter<GalleryItem> {
    private Context mContext;
    private int mResource;

    public GalleryItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<GalleryItem> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.ivItemGallery);
        GalleryItem m = getItem(position);
        Picasso.with(getContext()).load(m.getImg_src()).into(imageView);
        return convertView;
    }
}
