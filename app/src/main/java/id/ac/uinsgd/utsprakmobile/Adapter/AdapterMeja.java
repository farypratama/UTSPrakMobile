package id.ac.uinsgd.utsprakmobile.Adapter;

/**
 * Created by Fary & Rafa on 26/10/2016.
 */

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import id.ac.uinsgd.utsprakmobile.BookingFragment;
import id.ac.uinsgd.utsprakmobile.R;

public class AdapterMeja extends ArrayAdapter<String> {

    public final Activity context;
    public final String[] item;
    ArrayList<String> tersedia = new ArrayList<String>();

    public AdapterMeja(Activity context, String[] item, ArrayList tersedia)
    {
        super(context, R.layout.list1,item);

        this.context=context;
        this.item=item;
        this.tersedia=tersedia;


    }
    public View getView(final int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list2,null,true);

        TextView nama=(TextView) rowView.findViewById(R.id.txt_meja);
        TextView sedia=(TextView) rowView.findViewById(R.id.txt_sedia);
        CheckBox cekbox=(CheckBox)rowView.findViewById((R.id.cek_meja)) ;


        nama.setText(item[position]);
        if(tersedia.get(position).equals("Tersedia"))
        {
            sedia.setTextColor(Color.GREEN);
            sedia.setText(tersedia.get(position));
            cekbox.setChecked(false);
        }
        else
        {
            sedia.setTextColor(Color.RED);
            sedia.setText(tersedia.get(position));
            cekbox.setChecked(true);
        }


        cekbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {
                    BookingFragment.ketersediaan.set(position,"Tidak Tersedia");
                    Toast.makeText(getContext(),item[position] + " Di Booking",Toast.LENGTH_SHORT ).show();
                }
                else
                {
                    BookingFragment.ketersediaan.set(position,"Tersedia");
                    Toast.makeText(getContext(),item[position] + " Tersedia",Toast.LENGTH_SHORT ).show();
                }
                notifyDataSetChanged();
            }
        });





        /*else
        {
            sedia.setText(tersedia[position]);
            sedia.setTextColor(Color.RED);
            cekbox.setChecked(true);

        }**/



        return rowView;
    }
}
