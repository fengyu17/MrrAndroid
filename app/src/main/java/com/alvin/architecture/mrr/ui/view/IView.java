package com.alvin.architecture.mrr.ui.view;

/**
 * Created by dell on 2016/12/12.
 */

public interface IView<T> {

    void onSuccess(T t);
    void onError(String msg);
    void onComplete();
}
