package wang.xiaop.movieplay.act.main

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.Toast
import wang.xiaop.movieplay.R
import wang.xiaop.movieplay.base.BaseActivity.retrofitUtil
import wang.xiaop.movieplay.bean.MainBean
import wang.xiaop.movieplay.network.entity.ListDayDiscount
import wang.xiaop.movieplay.network.http.ProgressSubscriber
import wang.xiaop.movieplay.network.http.SubscriberOnNextListener


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initToolBar()
        initView()
    }

    lateinit var recycler: RecyclerView
    lateinit var adapter: MainAdapter
    private fun initView() {
        recycler = findViewById(R.id.second_recycler) as RecyclerView
        recycler.layoutManager = LinearLayoutManager(this)
        var data = mutableListOf(MainBean("111", "1111"), MainBean("222", "2222"), MainBean("222", "2222"), MainBean("222", "2222"), MainBean("222", "2222"), MainBean("222", "2222"), MainBean("222", "2222"), MainBean("333", "3333"))

        adapter = MainAdapter(data)
        recycler.adapter = adapter

        request()
    }

    private var getResultOnNext: SubscriberOnNextListener<*>? = null
    private fun request() {
        retrofitUtil.setUseCache(false)
        retrofitUtil.getDayDiscountPost(ProgressSubscriber(getResultOnNext, this@SecondActivity, true), "{\"pageIndex\":1,\"pageSize\":10,\"version\":1}")
        getResultOnNext = object : SubscriberOnNextListener<ListDayDiscount> {
            override fun onNext(result: ListDayDiscount?) {
                val sb = StringBuilder()
                if (result != null) {
                    for (bean in result.listDayDiscount) {
                        sb.append(bean.team_Title).append("||")
                    }
                }
            }

            override fun onError(code: Int, message: String) {
                Toast.makeText(this@SecondActivity, code.toString() + "||" + message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    var toolbar: Toolbar? = null // Toolbar
    var actionBar: ActionBar? = null// ActionBar

    /**
     * 初始化toolbar
     */
    private fun initToolBar() {
        toolbar = findViewById(R.id.toolbar) as Toolbar?
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            actionBar = supportActionBar
            actionBar!!.setDisplayHomeAsUpEnabled(false)  // 给左上角图标的左边加上一个返回的图标 。对应id为Android.R.id.home，对应ActionBar.DISPLAY_HOME_AS_UP
            actionBar!!.setDisplayShowHomeEnabled(false)  //使左上角图标是否显示，如果设成false，则没有程序图标.对应id为Android.R.id.home，对应ActionBar.DISPLAY_SHOW_HOME
            actionBar!!.setDisplayShowTitleEnabled(false)  //是否显示title。（title在左边！）对应ActionBar.DISPLAY_SHOW_TITLE。
            actionBar!!.setDisplayShowCustomEnabled(false)  // 使自定义的普通View能在title栏显示，即actionBar.setCustomView能起作用，对应ActionBar.DISPLAY_SHOW_CUSTOM
            //其中setHomeButtonEnabled和setDisplayShowHomeEnabled共同起作用，
            // 如果setHomeButtonEnabled设成false，
            // 即使setDisplayShowHomeEnabled设成true，图标也不能点击
        }
    }
}
