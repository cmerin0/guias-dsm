package com.udb.dsm.apilabphp;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.udb.dsm.apilabphp.databinding.ItemBinding;

public class PersonViewHolder extends RecyclerView.ViewHolder {
    private final ItemBinding itemBinding;

    public PersonViewHolder(View view) {
        super(view);
        itemBinding = ItemBinding.bind(view);
    }

    public void bind(Person repo) {
        itemBinding.tvName.setText(repo.getName());
        itemBinding.tvUid.setText(repo.getUid());
        itemBinding.tvAge.setText(repo.getAge());
        itemBinding.tvNumber.setText(repo.getNumber());
        itemBinding.tvEmail.setText(repo.getEmail());
    }
}
