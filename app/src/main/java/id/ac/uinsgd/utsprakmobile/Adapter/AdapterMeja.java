package id.ac.uinsgd.utsprakmobile.Adapter;

/**
 * Created by Fary & Rafa on 26/10/2016.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import id.ac.uinsgd.utsprakmobile.R;

public class AdapterMeja extends ArrayAdapter<String> {

    public final Activity context;
    public final String[] item;
    public final String[] tersedia;

    public AdapterMeja(Activity context, String[] item, String[] tersedia)
    {
        super(context, R.layout.list1,item);

        this.context=context;
        this.item=item;
        this.tersedia=tersedia;


    }
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list2,null,true);

        TextView nama=(TextView) rowView.findViewById(R.id.txt_meja);
        TextView sedia=(TextView) rowView.findViewById(R.id.txt_sedia);
        CheckBox cekbox=(CheckBox)rowView.findViewById((R.id.cek_meja)) ;
        nama.setText(item[position]);

        cekbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked) {

                    /*(tersedia[position].equals("Tersedia"))
                    {

                        sedia.setText(tersedia[position]);
                        sedia.setTextColor(Color.GREEN);
                        BookingFragment.Ketersediaan
                    }*/

                }

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
