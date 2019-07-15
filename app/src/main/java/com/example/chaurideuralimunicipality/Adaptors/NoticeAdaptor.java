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

import com.example.chaurideuralimunicipality.Activities.Notice_details;
import com.example.chaurideuralimunicipality.R;
import com.example.chaurideuralimunicipality.model.Notice;

import java.io.Serializable;
import java.util.List;

public class NoticeAdaptor extends RecyclerView.Adapter<NoticeAdaptor.NoticeViewHolder> implements Serializable{

    private Context mcontext;
    private List<Notice> mlist;

    public NoticeAdaptor(Context mcontext, List<Notice> mlist) {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

//        LayoutInflater inflater = LayoutInflater.from(mcontext);
//        View view = inflater.inflate(R.layout.list_item,null);
//
        View view = LayoutInflater.from(mcontext).inflate(R.layout.list_item,null);
        return new NoticeViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder noticeViewHolder, int position) {

        //keeping data of each notice in position (i) of mlist
        final Notice notice = mlist.get(position);
        noticeViewHolder.title.setText(notice.getTitle());
        noticeViewHolder.pubdate.setText(notice.getDate());

        //giving card item listener while clicking
        noticeViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, Notice_details.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("notice", notice);
                mcontext.startActivity(intent);




                //yesbata notice ko object pathaera arko details activity ma  object tanni and getTitle getbody garera display garauni
            }
        });

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder{

        TextView title,pubdate;
        LinearLayout linearLayout;
        public NoticeViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            pubdate = itemView.findViewById(R.id.pub_date);
            linearLayout = itemView.findViewById(R.id.item_list );
        }
    }
}
