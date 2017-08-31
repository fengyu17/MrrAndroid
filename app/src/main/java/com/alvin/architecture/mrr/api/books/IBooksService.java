package com.alvin.architecture.mrr.api.books;

import com.alvin.architecture.mrr.model.Book;
import com.alvin.architecture.mrr.model.BookDetail;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dell on 2017/8/23.
 */

public interface IBooksService {

    @GET("book/search")
    Observable<Book> searchBooks(@Query("q") String q,
                                 @Query("tag") String tag,
                                 @Query("start") int start,
                                 @Query("count") int count);

    @GET("book/{id}")
    Observable<BookDetail> queryBookInfoById(@Path("id") String id);
}
