package au.edu.unsw.infs3634.SydRestaurant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResAdapter extends RecyclerView.Adapter<ResAdapter.RestaurantViewHolder> {
    private MainActivity mParentActivity;
    private ArrayList<Restaurant> mRes;
    private boolean mTwoPane;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Restaurant restaurant = (Restaurant) v.getTag();
            if(mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(DetailFragment.ARG_ITEM_ID, restaurant.getName());
                DetailFragment fragment = new DetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.detail_container, fragment).commit();
            } else {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailFragment.ARG_ITEM_ID, restaurant.getName());
                context.startActivity(intent);
            }
        }
    };

    public ResAdapter(MainActivity parent, ArrayList<Restaurant> res, boolean twoPane) {
        mParentActivity = parent;
        mRes = res;
        mTwoPane = twoPane;
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder  {
        public TextView name, value, change;
        public ImageView art;

        public RestaurantViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.tvName);
            value = v.findViewById(R.id.tvValue);
            change = v.findViewById(R.id.tvChange);
            art = v.findViewById(R.id.ivArt);
        }
    }

    @Override
    public ResAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.coin_list_row, parent, false);
        return new RestaurantViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {
        Restaurant res = mRes.get(position);
        holder.art.setImageResource(res.getImage());
        holder.name.setText(res.getName());
        holder.value.setText(res.getType());
        holder.change.setText(String.valueOf(res.getRating()));
        holder.itemView.setTag(res);
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mRes.size();
    }

}

