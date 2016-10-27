package id.ac.uinsgd.utsprakmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Fary & Rafa on 26/10/2016.
 */
public class DetailPesananActivity extends AppCompatActivity{
    private TextView textnama;
    private TextView textdeskripsi;
    private ImageView imgview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_pesanan);

        //Initializing Views
        textnama = (TextView) findViewById(R.id.txt_nama);
        textdeskripsi = (TextView) findViewById(R.id.txt_deskripsi);
        imgview = (ImageView) findViewById(R.id.img_makan);

        //Getting intent
        Intent intent = getIntent();

        //Displaying values by fetching from intent
        textnama.setText(intent.getStringExtra(PesananFragment.intent_nama));
        textdeskripsi.setText(intent.getStringExtra(PesananFragment.intent_deskripsi));
        imgview.setImageResource(intent.getIntExtra(String.valueOf(PesananFragment.intent_image),0));

    }
}
