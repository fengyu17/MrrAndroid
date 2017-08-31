package com.alvin.architecture.mrr.ui.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alvin.architecture.mrr.R;
import com.alvin.architecture.mrr.api.books.IBooksService;
import com.alvin.architecture.mrr.model.Book;
import com.alvin.architecture.mrr.presenter.books.BooksPresenter;
import com.alvin.architecture.mrr.ui.BaseActivity;
import com.alvin.architecture.mrr.ui.adapter.BooksRecyclerviewAda;
import com.alvin.architecture.mrr.ui.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/8/29.
 */

public class BookListActivity extends BaseActivity implements IView {

    private SwipeRefreshLayout layout_books_refresh;
    private RecyclerView rv_books_content;
    private BooksRecyclerviewAda booksRecyclerviewAda;
    private ArrayList<Book.BooksBean> mData = new ArrayList<>();
    private BooksPresenter mBookPresenter = null;
    private int pageIndex = 0;
    private boolean isLoading;

    @Override
    protected int layoutId() {
        return R.layout.activity_books;
    }

    @Override
    protected void initData() {
        mBookPresenter = new BooksPresenter(this, retrofit.create(IBooksService.class));
    }

    @Override
    protected void initView() {
        layout_books_refresh = (SwipeRefreshLayout) findViewById(R.id.layout_books_refresh);
        rv_books_content = (RecyclerView) findViewById(R.id.rv_books_content);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rv_books_content.setLayoutManager(layoutManager);
        rv_books_content.setItemAnimator(new DefaultItemAnimator());
        rv_books_content.setHasFixedSize(true);
        booksRecyclerviewAda = new BooksRecyclerviewAda(this, mData);
        booksRecyclerviewAda.setLisenter(new BooksRecyclerviewAda.OnItemClickLisenter() {
            @Override
            public void onClick(int pos) {
                String id = mData.get(pos).getId();
                Intent intent = new Intent(BookListActivity.this, BookDetailActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        rv_books_content.setAdapter(booksRecyclerviewAda);
        layout_books_refresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimaryDark));
        layout_books_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
        rv_books_content.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition + 1 == booksRecyclerviewAda.getItemCount()) {

                    boolean isRefreshing = layout_books_refresh.isRefreshing();
                    if (isRefreshing) {
                        booksRecyclerviewAda.notifyItemRemoved(booksRecyclerviewAda.getItemCount());
                        return;
                    }
                    if (!isLoading) {
                        isLoading = true;
                        pageIndex++;
                        mBookPresenter.getSearchBooks("图书", null, pageIndex, 15);
                    }

                }
            }
        });
    }

    @Override
    protected void loadData() {
        mBookPresenter.getSearchBooks("图书", null, 0, 15);
    }


    @Override
    public void onSuccess(Object o) {
        List<Book.BooksBean> list = (List<Book.BooksBean>) o;
        mData.addAll(list);
        booksRecyclerviewAda.notifyDataSetChanged();
        if (layout_books_refresh.isRefreshing()) {
            layout_books_refresh.setRefreshing(false);
        }
        isLoading = false;
    }

    @Override
    public void onError(String msg) {
        isLoading = false;
        Toast.makeText(BookListActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete() {
        isLoading = false;
    }
}
