package id.ac.uinsgd.utsprakmobile;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import id.ac.uinsgd.utsprakmobile.Adapter.AdapterMeja;


public class BookingFragment extends Fragment {

    String[] ListMeja ={
            "Meja 1",
            "Meja 2",
            "Meja 3",
            "Meja 4",
            "Meja 5",
            "Meja 6"
    };

    public static ArrayList<String> ketersediaan = new ArrayList<String>();



    public String[] sssKetersediaan=
            {
                    "Tersedia",
                    "Tersedia",
                    "Tersedia",
                    "Tidak Tersedia",
                    "Tersedia",
                    "Tidak Tersedia"
            };



    public BookingFragment() {
    }



    LinearLayout view;
    ListView list;
    Button btn_back;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ketersediaan.add("Tersedia");
        ketersediaan.add("Tersedia");
        ketersediaan.add("Tidak Tersedia");
        ketersediaan.add("Tersedia");
        ketersediaan.add("Tidak Tersedia");
        ketersediaan.add("Tersedia");


        view = (LinearLayout) inflater.inflate(R.layout.fragment_booking, container, false);
        getActivity().setTitle("Booking Meja");


        btn_back=(Button) view.findViewById(R.id.btn_booking);
        AdapterMeja adapter=new AdapterMeja(getActivity(),ListMeja, ketersediaan);
        list=(ListView) view.findViewById(R.id.list_meja);
        list.setAdapter(adapter);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub


                FragmentManager fm = getActivity().getFragmentManager();
                fm.popBackStack();;

                //Toast.makeText(getActivity(),"Yang dipilih = "+ datacheckbox,Toast.LENGTH_SHORT).show();




            }
        });


        return view;
    }





}
