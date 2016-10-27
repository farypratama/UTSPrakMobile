package id.ac.uinsgd.utsprakmobile;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

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

    public String[] Ketersediaan=
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = (LinearLayout) inflater.inflate(R.layout.fragment_booking, container, false);
        getActivity().setTitle("Booking Meja");

        AdapterMeja adapter=new AdapterMeja(getActivity(),ListMeja, Ketersediaan);
        list=(ListView) view.findViewById(R.id.list_meja);
        list.setAdapter(adapter);



        return view;
    }





}
