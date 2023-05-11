package Model;

import static android.content.ContentValues.TAG;

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

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MensajeAdapter extends ArrayAdapter<Mensaje> {

    private Context mContext;
    private int mResource;

    public MensajeAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Mensaje> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    private class SaveImageTask extends AsyncTask<byte[], Void, String> {
        protected String doInBackground(byte[]... byteArrays) {
            return null;
        }
        protected void onPostExecute(String result) {
            // Aquí puedes actualizar la UI con el resultado
        }
    }

    private String saveImg(byte[]... byteArrays){
        // Convertir el objeto Bitmap a un array de bytes
        return null;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.ivImagenMensajePrompt);
        TextView textView = convertView.findViewById(R.id.tvTextoMensajePrompt);

        Mensaje m = getItem(position);
        Picasso.with(getContext()).load(m.getImg_src()).into(imageView);
        textView.setText(m.getPrompt());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("imagenUrl", m.getImg_src());
                Intent intent = new Intent(mContext, PreviewActivity.class);
                intent.putExtras(bundle);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }
}



