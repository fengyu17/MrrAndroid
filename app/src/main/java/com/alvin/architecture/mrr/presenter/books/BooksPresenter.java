package com.alvin.architecture.mrr.presenter.books;

import com.alvin.architecture.mrr.api.books.IBooksService;
import com.alvin.architecture.mrr.model.Book;
import com.alvin.architecture.mrr.presenter.Presenter;
import com.alvin.architecture.mrr.ui.view.IView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2017/8/24.
 */

public class BooksPresenter extends Presenter {

    private IView view;
    private IBooksService apiService;

    public BooksPresenter(IView view, IBooksService apiService) {
        this.view = view;
        this.apiService = apiService;
    }


    /**
     * 获取图书列表
     *
     * @param name  图书
     * @param tag   标签
     * @param start
     * @param count 请求条数
     */
    public void getSearchBooks(String name, String tag, int start, int count) {
        apiService.searchBooks(name, tag, start, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Book book) {
                        if (book != null) {
                            view.onSuccess(book.getBooks());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        view.onComplete();
                    }
                });
    }

}
