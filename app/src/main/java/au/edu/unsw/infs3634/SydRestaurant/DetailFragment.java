package au.edu.unsw.infs3634.SydRestaurant;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.NumberFormat;

public class DetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private Restaurant mRes;

    public DetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments().containsKey(ARG_ITEM_ID)) {
            mRes = Restaurant.getRes(getArguments().getString(ARG_ITEM_ID));
            this.getActivity().setTitle(mRes.getName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        // set textview and imageview to the right sources by useing getter and setter in Restaurant class
        if(mRes != null) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            ((ImageView)rootView.findViewById(R.id.imageView)).setImageResource(mRes.getImage());
            ((TextView) rootView.findViewById(R.id.tvName)).setText(mRes.getName());
            ((TextView) rootView.findViewById(R.id.tvRatingField)).setText(String.valueOf(mRes.getRating()));
            ((TextView) rootView.findViewById(R.id.tvLocationField)).setText(String.valueOf(mRes.getLocation()));
            ((TextView) rootView.findViewById(R.id.tvCostField)).setText(String.valueOf(mRes.getCost()));
            ((TextView) rootView.findViewById(R.id.tvTypeField)).setText(String.valueOf(mRes.getType()));
            ((ImageView) rootView.findViewById(R.id.ivSearch)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchCoin(mRes.getName());
                }
            });
        }

        return rootView;
    }

    private void searchCoin(String name) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
        startActivity(intent);
    }
}
