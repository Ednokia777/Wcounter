package com.saturnpro.wcounter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.saturnpro.wcounter.Words;
import com.saturnpro.wcounter.WordViewHolder;

public class WordListAdapter extends ListAdapter<Words, WordViewHolder> {

    public WordListAdapter(@NonNull DiffUtil.ItemCallback<Words> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return WordViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Words current = getItem(position);
        holder.bind(current.getWorld());
    }

    public static class WordDiff extends  DiffUtil.ItemCallback<Words> {
        @Override
        public boolean areItemsTheSame(@NonNull Words oldItem, @NonNull Words newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Words oldItem, @NonNull Words newItem) {
            return oldItem.getWorld().equals(newItem.getWorld());
        }
    }
}
