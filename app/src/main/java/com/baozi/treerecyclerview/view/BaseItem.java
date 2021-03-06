package com.baozi.treerecyclerview.view;

import android.content.res.Resources;
import android.support.annotation.Nullable;

import com.baozi.treerecyclerview.adpater.ViewHolder;

/**
 * 组合模式
 */
public abstract class BaseItem<D extends ItemData> {

    protected ItemGroup parentItem;
    /**
     * 当前item的数据
     */
    protected D data;
    /**
     * 布局资源id
     */
    private int layoutId;
    /**
     * item在每行中的spansize
     * 默认为0,如果为0则占满一行
     * 不建议连续的两级,都设置该数值
     *
     * @return 所占值
     */
    private int spanSize;


    public BaseItem() {

    }

    public int getLayoutId() {
        layoutId = initLayoutId();
        if (layoutId == 0) {
            throw new Resources.NotFoundException("请设置布局Id");
        }
        return layoutId;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public void setParentItem(ItemGroup parentItem) {
        this.parentItem = parentItem;
    }
    /**
     * 获取当前item的父级
     *
     * @return
     */
    @Nullable
    public ItemGroup getParentItem() {
        return parentItem;
    }



    /**
     * 该条目的布局id
     *
     * @return 布局id
     */
    protected abstract int initLayoutId();

    /**
     * 抽象holder的绑定
     *
     * @param holder ViewHolder
     */
    public abstract void onBindViewHolder(ViewHolder holder);



    public void onClick(int position) {

    }
}
