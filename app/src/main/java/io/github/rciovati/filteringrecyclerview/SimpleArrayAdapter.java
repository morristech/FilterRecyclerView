package io.github.rciovati.filteringrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class SimpleArrayAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<T> mItems = new ArrayList<>();

    public SimpleArrayAdapter(@NonNull List<T> items) {
        mItems = items;
    }

    public SimpleArrayAdapter() {
        this(new ArrayList<T>());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public T getItem(int position) {
        return mItems.get(position);
    }

    public void addAll(@NonNull Collection<T> items) {
        int currentIndex = mItems.size();
        for (final T item : items) {
            mItems.add(item);
        }
        notifyItemRangeInserted(currentIndex, mItems.size());
    }

    public void add(T item) {
        int currentIndex = mItems.size();
        mItems.add(item);
        notifyItemInserted(currentIndex);
    }

    public void remove(T item) {
        final int i = mItems.indexOf(item);
        if (i != -1) {
            mItems.remove(i);
            notifyItemRemoved(i);
        }
    }

    public List<T> getItems() {
        return Collections.unmodifiableList(mItems);
    }

    public void clear() {
        int currentIndex = mItems.size();
        mItems.clear();
        notifyItemRangeRemoved(0, currentIndex);
    }
}