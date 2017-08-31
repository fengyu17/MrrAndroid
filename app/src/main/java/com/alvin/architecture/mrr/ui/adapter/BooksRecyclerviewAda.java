package com.alvin.architecture.mrr.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alvin.architecture.mrr.R;
import com.alvin.architecture.mrr.model.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dell on 2017/8/29.
 */

public class BooksRecyclerviewAda extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<Book.BooksBean> mList;

    public BooksRecyclerviewAda(Context context, ArrayList<Book.BooksBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_books_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        Book.BooksBean book = mList.get(position);
        Picasso.with(mContext).load(book.getImages().getLarge()).into(viewHolder.icon);
        viewHolder.title.setText(book.getTitle());
        viewHolder.rate.setText(book.getRating().getMax() + "");
        viewHolder.author.setText(book.getAuthor().size() > 0 ? book.getAuthor().get(0) : book.getAuthor().toString());
        viewHolder.copyright.setText(book.getPublisher());
        viewHolder.summary.setText(book.getSummary());
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLisenter != null) {
                    mLisenter.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView layout;
        ImageView icon;
        TextView title, rate, author, copyright, summary;

        public MyViewHolder(View view) {
            super(view);
            layout = (CardView) view.findViewById(R.id.cv_books_layout);
            icon = (ImageView) view.findViewById(R.id.iv_books_ic);
            title = (TextView) view.findViewById(R.id.iv_books_title);
            rate = (TextView) view.findViewById(R.id.iv_books_rate);
            author = (TextView) view.findViewById(R.id.iv_books_author);
            copyright = (TextView) view.findViewById(R.id.iv_books_copyright);
            summary = (TextView) view.findViewById(R.id.tv_books_summary);
        }
    }

    private OnItemClickLisenter mLisenter;

    public void setLisenter(OnItemClickLisenter lisenter) {
        this.mLisenter = lisenter;
    }

    public interface OnItemClickLisenter {
        void onClick(int pos);
    }
}
