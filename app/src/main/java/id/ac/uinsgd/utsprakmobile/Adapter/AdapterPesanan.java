package id.ac.uinsgd.utsprakmobile.Adapter;

/**
 * Created by Fary & Rafa on 26/10/2016.
 */

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.uinsgd.utsprakmobile.PesananFragment;
import id.ac.uinsgd.utsprakmobile.R;

public class AdapterPesanan extends ArrayAdapter<String> {

    public final Activity context;
    public final String[] item;
    public final double[] item1;
    public final Integer[] imgid;
    Dialog dialog;
    View dialogView;
    LayoutInflater inflater;
    NumberPicker np;

    TextView nama, subnama, jumlah;
    ImageView gambar;
    public AdapterPesanan(Activity context, String[] item, double[] item1, Integer[] imgid)
    {
        super(context, R.layout.list1,item);

        this.context=context;
        this.item=item;
        this.item1=item1;
        this.imgid=imgid;

    }



    public View getView(final int position, View view, ViewGroup parent)
    {




        inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list1,null,true);

        final CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.checkBox);
        nama=(TextView) rowView.findViewById(R.id.txt_nama);
        subnama=(TextView) rowView.findViewById(R.id.txt_harga);
        jumlah=(TextView) rowView.findViewById(R.id.txt_jumlah);

        ImageView gambar=(ImageView) rowView.findViewById(R.id.img_makanan);


        nama.setText(item[position]);
        subnama.setText("Rp."+String.valueOf(item1[position]));
        gambar.setImageResource(imgid[position]);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    dialog = new Dialog(context);
                    dialog.setContentView(R.layout.numpicker_dialog);
                    dialog.setTitle("Jumlah Pesanan");
                    np = (NumberPicker) dialog.findViewById(R.id.num1);
                    Button b1 = (Button) dialog.findViewById(R.id.button1);
                    Button b2 = (Button) dialog.findViewById(R.id.button2);
                    dialog.setCancelable(false);

                    np.setMinValue(1);
                    np.setMaxValue(10);

                    b1.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v) {
                            PesananFragment.datacheckbox.add(item[position]);
                            PesananFragment.datajumlah.add(np.getValue());
                            PesananFragment.dataharga.add(item1[position]);
                            Toast.makeText(getContext(),item[position]+ " ditambahkan",Toast.LENGTH_SHORT).show();

                            dialog.dismiss();
                        }
                    });
                    b2.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v) {
                            checkBox.setChecked(false);
                            dialog.dismiss();
                        }
                    });



                    dialog.show();

                }else{
                    Toast.makeText(getContext(),item[position]+ " dibatalkan",Toast.LENGTH_SHORT).show();
                    PesananFragment.datacheckbox.remove(PesananFragment.datacheckbox.get(position));
                    PesananFragment.dataharga.remove(PesananFragment.dataharga.get(position));
                    PesananFragment.datajumlah.remove(PesananFragment.datajumlah.get(position));
                    //PesananFragment.datajumlah.remove(np.getValue());

                }






            }
        });

        return rowView;
    }
}