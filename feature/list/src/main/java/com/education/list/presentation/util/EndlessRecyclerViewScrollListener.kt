package com.education.list.presentation.util

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EndlessRecyclerViewScrollListener(
    spanCount: Int,
    private val onLoadMore: (page: Int) -> Unit
) : RecyclerView.OnScrollListener() {

    private var visibleThreshold = 4

    init {
        visibleThreshold *= spanCount
    }

    private var currentPage = 1

    private var previousTotalItemCount = 0

    private var loading = true

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        val layoutManager = view.layoutManager as? GridLayoutManager ?: return

        val totalItemCount = layoutManager.itemCount
        val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

        if (loading && totalItemCount > previousTotalItemCount) {
            loading = false
            previousTotalItemCount = totalItemCount
        }


        if (!loading && lastVisibleItemPosition + visibleThreshold > totalItemCount &&
            view.adapter!!.itemCount > visibleThreshold
        ) {
            currentPage++
            onLoadMore(currentPage)
            loading = true
        }
    }

}