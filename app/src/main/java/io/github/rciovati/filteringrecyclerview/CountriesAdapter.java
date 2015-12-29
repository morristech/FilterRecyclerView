package io.github.rciovati.filteringrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.rciovati.filteringrecyclerview.databinding.ItemCountryBinding;

public class CountriesAdapter extends SimpleArrayAdapter<Country, CountriesAdapter.CountryViewHolder> {

    public CountriesAdapter(List<Country> countries) {
        super(countries);
        setHasStableIds(true);
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View itemView = inflater.inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {

        ItemCountryBinding mBinding;

        public CountryViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        public void bind(Country country) {
            mBinding.setCountry(country);
        }
    }
}
