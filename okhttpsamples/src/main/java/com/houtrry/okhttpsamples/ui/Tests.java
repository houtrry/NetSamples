package com.houtrry.okhttpsamples.ui;

import com.houtrry.okhttpsamples.bean.ArticleListBean;
import com.houtrry.okhttpsamples.bean.ResponseResult;

/**
 * @author: houtrry
 * @time: 2018/4/26
 * @desc: ${TODO}
 */
public class Tests {


    public void doo() {
        Tests tests = new Tests();
        tests.setListener(true, new ICallback<ResponseResult<ArticleListBean>>() {
            @Override
            public void doGet(ResponseResult<ArticleListBean> articleListBeanResponseResult) {

            }

            @Override
            public ResponseResult<ArticleListBean> doPost() {
                return null;
            }
        });
    }


    public <T> void setListener(boolean doGet, ICallback<T> callback) {
        if (doGet) {
            T t = null;
            callback.doGet(t);
        } else {
            callback.doPost();
        }
    }


    public interface ICallback<T> {
        void doGet(T t);
        T doPost();
    }
}
