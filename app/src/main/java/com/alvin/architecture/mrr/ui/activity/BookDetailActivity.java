package com.alvin.architecture.mrr.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.alvin.architecture.mrr.R;
import com.alvin.architecture.mrr.api.books.IBooksService;
import com.alvin.architecture.mrr.model.BookDetail;
import com.alvin.architecture.mrr.presenter.books.BookDetailPresenter;
import com.alvin.architecture.mrr.ui.BaseActivity;
import com.alvin.architecture.mrr.ui.view.IView;
import com.squareup.picasso.Picasso;

/**
 * Created by dell on 2017/8/29.
 */

public class BookDetailActivity extends BaseActivity implements IView {

    private ImageView iv_book_detail_ic;
    private TextView tv_book_detail_title, tv_book_detail_rate, tv_book_detail_author, tv_book_detail_copyright, tv_book_detail_summary, tv_book_detail_intro;

    private String mBookId;

    private BookDetailPresenter detailPresenter = null;

    @Override
    protected int layoutId() {
        return R.layout.activity_book_detail;
    }

    @Override
    protected void initData() {
        mBookId = getIntent().getStringExtra("id");
        detailPresenter = new BookDetailPresenter(this, retrofit.create(IBooksService.class));
    }

    @Override
    protected void initView() {
        iv_book_detail_ic = (ImageView) findViewById(R.id.iv_book_detail_ic);
        tv_book_detail_title = (TextView) findViewById(R.id.tv_book_detail_title);
        tv_book_detail_rate = (TextView) findViewById(R.id.tv_book_detail_rate);
        tv_book_detail_author = (TextView) findViewById(R.id.tv_book_detail_author);
        tv_book_detail_copyright = (TextView) findViewById(R.id.tv_book_detail_copyright);
        tv_book_detail_summary = (TextView) findViewById(R.id.tv_book_detail_summary);
        tv_book_detail_intro = (TextView) findViewById(R.id.tv_book_detail_intro);
    }

    @Override
    protected void loadData() {
        detailPresenter.queryBookInfoById(mBookId);
    }

    @Override
    public void onSuccess(Object o) {
        BookDetail bookDetail = (BookDetail) o;
        Picasso.with(this).load(bookDetail.getImages().getLarge()).into(iv_book_detail_ic);
        tv_book_detail_title.setText(bookDetail.getTitle());
        tv_book_detail_rate.setText(bookDetail.getRating().getAverage());
        tv_book_detail_author.setText(bookDetail.getAuthor().toString());
        tv_book_detail_copyright.setText(bookDetail.getPublisher());
        tv_book_detail_summary.setText(bookDetail.getSummary());
        tv_book_detail_intro.setText(bookDetail.getAuthor_intro());
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onComplete() {

    }
}
