package id.ac.uinsgd.utsprakmobile;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import id.ac.uinsgd.utsprakmobile.Adapter.AdapterPesanan;


public class PesananFragment extends Fragment{

    public PesananFragment() {
        // Required empty public constructor
    }

    public static final String intent_nama = "nama";
    public static final String intent_deskripsi = "deskripsi";
    public static final Integer intent_image = 0;
    public static ArrayList<String> datacheckbox = new ArrayList<String>();
    public static ArrayList<Integer> datajumlah = new ArrayList<Integer>();
    public static ArrayList<Double> dataharga = new ArrayList<Double>();


    String[] namamakanan ={
            "Nasi Goreng",
            "Mie Goreng",
            "Kentang Goreng",
            "Jengkol",
            "Lotek"
    };

    Integer[] imgid={
            R.drawable.nasgor,
            R.drawable.miegoreng,
            R.drawable.kentang,
            R.drawable.jengkol,
            R.drawable.lotek
    };

    String [] deskripsi=
            {
                    "Nasi Goreng ini terbuat dari bahan-bahan terbaik yang disajikan dengan piring terbaik yang dibuat oleh koki terbaik",
                    "Mi Goreng ini terbuat dari gandum yang diproduksi oleh Indomie karena lebih mudah dimasak kalau pake indomie",
                    "Kentang goreng ini disajikan dengan sambal, dan juga dioleh dari kentang terbaik menggunakan lahan orang lain",
                    "Jengkol ini sangat enak apabila anda ingin mulut anda berbau tidak enak ketika mengobrol dengan orang lain",
                    "lotek ini terbuat dari bumbu kacang yang diberika ke sekumpulan sayur dengan kualitas terbaik"

            };
    double [] harga =
            {
                    13000,
                    7000,
                    7000,
                    50000,
                    100000
            };


    LinearLayout view;
    ListView list;
    Button btn_pesan;
    CheckBox checkBox;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = (LinearLayout) inflater.inflate(R.layout.fragment_pesanan, container, false);
        btn_pesan=(Button) view.findViewById(R.id.btn_pesan);
        checkBox = (CheckBox)view.findViewById(R.id.checkBox);
        getActivity().setTitle("Pesanan");

        AdapterPesanan adapter=new AdapterPesanan(getActivity(),namamakanan,harga,imgid);
        list=(ListView) view.findViewById(R.id.listpesanan);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getActivity(), DetailPesananActivity.class);
                intent.putExtra(intent_nama,namamakanan[position]);
                intent.putExtra(intent_deskripsi,deskripsi[position]);
                intent.putExtra(String.valueOf(intent_image), imgid[position]);

                startActivity(intent);

            }
        });


        btn_pesan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub


                Intent i = new Intent(getActivity(), PembayaranActivity.class);
                startActivity(i);

                //Toast.makeText(getActivity(),"Yang dipilih = "+ datacheckbox,Toast.LENGTH_SHORT).show();




            }
        });


        return view;
    }


}
