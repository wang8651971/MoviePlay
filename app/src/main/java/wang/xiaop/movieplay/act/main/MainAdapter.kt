package wang.xiaop.movieplay.act.main

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import wang.xiaop.movieplay.R
import wang.xiaop.movieplay.bean.MainBean

/**
 * Created by 王攀 on 2017/8/24.
 */
class MainAdapter(data: MutableList<MainBean>?) : BaseQuickAdapter<MainBean>(data) {
    init {
        mLayoutResId = R.layout.item_main
    }
    override fun convert(viewHolder: BaseViewHolder?, bean: MainBean?) {
        viewHolder!!.setText(R.id.item_main_txt, bean!!.name)
    }
}