package com.houtrry.okhttpsamples

/**
 * @author: houtrry
 * @time: 2018/4/24
 * @desc: 数据来自 http://www.wanandroid.com/blog/show/2
 *
 */
data class ResponseResult<T>(var data: T?, var code: Int, var errorMsg: String?)

data class ArticleBean(var apkLink: String, var author: String, var chapterId: Int, var chapterName: String, var collect: Boolean, var courseId: Int, var desc: String,
                       var envelopePic: String, var fresh: Boolean, var id: Int, var link: String, var niceDate: String, var origin: String, var projectLink: String,
                       var publishTime: Long, var superChapterId: Int, var superChapterName: String, var title: String, var type: Int, var visible: Int, var zan: Int, var tags: List<String>)

/**
 * 首页相关
 */
data class ArticleListBean(var curPage: Int, var offset: Int, var over: Boolean, var pageCount: Int, var size: Int, var total: Int, var datas: List<ArticleBean>)