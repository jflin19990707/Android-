package com.bytedance.camera.demo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bytedance.camera.demo.utils.Utils;

import java.io.File;

public class ImageActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File imageFile = (File)getIntent().getSerializableExtra("file");
        setContentView(R.layout.activity_image);
        imageView = findViewById(R.id.image_view);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds =true;
        BitmapFactory.decodeFile(imageFile.getAbsolutePath(),options);
        int photoW = options.outWidth;
        int photoH = options.outHeight;
        if(imageView.getWidth()>0&&imageView.getHeight()>0){
            int scaleFactor = Math.min(photoW/imageView.getWidth(),photoH/imageView.getHeight());
            options.inJustDecodeBounds = false;
            options.inSampleSize = scaleFactor;
            options.inPurgeable = true;
        }
        Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
        bitmap = Utils.rotateImage(bitmap,imageFile.getAbsolutePath());
        imageView.setImageBitmap(bitmap);
        Button btnOk,btnCancel;
        btnOk = findViewById(R.id.btn_ok);
        btnCancel = findViewById(R.id.btn_cancel);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}