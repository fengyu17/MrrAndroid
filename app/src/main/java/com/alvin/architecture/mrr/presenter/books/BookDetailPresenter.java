package com.alvin.architecture.mrr.presenter.books;

import com.alvin.architecture.mrr.api.books.IBooksService;
import com.alvin.architecture.mrr.model.BookDetail;
import com.alvin.architecture.mrr.presenter.Presenter;
import com.alvin.architecture.mrr.ui.view.IView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2017/8/24.
 */

public class BookDetailPresenter extends Presenter {

    private IView view;
    private IBooksService apiService;

    public BookDetailPresenter(IView view, IBooksService apiService) {
        this.view = view;
        this.apiService = apiService;
    }

    /**
     * 获取图书详情
     *
     * @param id
     */
    public void queryBookInfoById(String id) {
        apiService.queryBookInfoById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookDetail>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BookDetail bookDetail) {
                        if (bookDetail != null) {
                            view.onSuccess(bookDetail);
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
