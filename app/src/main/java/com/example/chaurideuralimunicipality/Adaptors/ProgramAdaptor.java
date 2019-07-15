package com.example.chaurideuralimunicipality.Adaptors;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chaurideuralimunicipality.Activities.ProgramActivity;
import com.example.chaurideuralimunicipality.Activities.ProgramDetailsActivity;
import com.example.chaurideuralimunicipality.R;
import com.example.chaurideuralimunicipality.model.Program;

import java.io.Serializable;
import java.util.List;

public class ProgramAdaptor extends RecyclerView.Adapter<ProgramAdaptor.ProgramViewHolder> implements Serializable {

    private Context mcontext;
    private List<Program> mlist;

    public ProgramAdaptor(Context mcontext, List<Program> mlist) {
    this.mcontext = mcontext;
    this.mlist = mlist;

    }

    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mcontext).inflate(R.layout.list_item,null);
        return new ProgramViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramViewHolder programViewHolder, int i) {
        final Program program = mlist.get(i);
        programViewHolder.programtitle.setText(program.getTitle());
        programViewHolder.date.setText(program.getDate());

        programViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, ProgramDetailsActivity.class);
                intent.putExtra("programdetails", program);
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ProgramViewHolder extends RecyclerView.ViewHolder{

        TextView programtitle,date;
        LinearLayout linearLayout;
        public ProgramViewHolder(@NonNull View itemView) {
            super(itemView);
            programtitle = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.pub_date);
             linearLayout = itemView.findViewById(R.id.item_list);
        }
    }
}
