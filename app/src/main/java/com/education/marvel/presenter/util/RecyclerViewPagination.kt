package com.education.marvel.presenter.util

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

object RecyclerViewPagination {

    @Suppress("DEPRECATION")
    fun scroll(
        recyclerView: RecyclerView,
        pagedAdapter: RecyclerView.Adapter<*>,
        offset: Int = 0,
        isEndOfPagination: Boolean,
        onScrolled: () -> Unit
    ) = if (!isEndOfPagination) {
        recyclerView.setOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val adapter = recyclerView.adapter
                val layoutManager = recyclerView.layoutManager
                if (adapter != pagedAdapter || layoutManager == null) {
                    recyclerView.setOnScrollListener(null)
                    return
                }

                val lastVisibleItemPosition = getLastVisibleItemPosition(layoutManager)
                val updatePosition = adapter.itemCount - 1 - offset
                if (lastVisibleItemPosition >= updatePosition) {
                    recyclerView.setOnScrollListener(null)
                    onScrolled()
                }
            }
        })
    } else {
        recyclerView.setOnScrollListener(null)
    }

    private fun getLastVisibleItemPosition(layoutManager: RecyclerView.LayoutManager): Int {
        if (layoutManager is GridLayoutManager) {
            return layoutManager.findLastVisibleItemPosition()
        }
        throw RuntimeException("Unknown LayoutManager class: ${layoutManager::class.java.simpleName}")
    }

}