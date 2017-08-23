package wang.xiaop.movieplay

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initToolBar()
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
            actionBar!!.setDisplayHomeAsUpEnabled(true)  // 给左上角图标的左边加上一个返回的图标 。对应id为Android.R.id.home，对应ActionBar.DISPLAY_HOME_AS_UP
            actionBar!!.setDisplayShowHomeEnabled(false)  //使左上角图标是否显示，如果设成false，则没有程序图标.对应id为Android.R.id.home，对应ActionBar.DISPLAY_SHOW_HOME
            actionBar!!.setDisplayShowTitleEnabled(false)  //是否显示title。（title在左边！）对应ActionBar.DISPLAY_SHOW_TITLE。
            actionBar!!.setDisplayShowCustomEnabled(false)  // 使自定义的普通View能在title栏显示，即actionBar.setCustomView能起作用，对应ActionBar.DISPLAY_SHOW_CUSTOM
            //其中setHomeButtonEnabled和setDisplayShowHomeEnabled共同起作用，
            // 如果setHomeButtonEnabled设成false，
            // 即使setDisplayShowHomeEnabled设成true，图标也不能点击
        }
    }
}
