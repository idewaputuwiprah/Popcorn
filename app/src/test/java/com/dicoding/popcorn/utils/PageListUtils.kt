package com.dicoding.popcorn.utils

import androidx.paging.PagedList
import org.mockito.Mockito

object PageListUtils {
    fun <T> mockPagedList(list: List<T>): PagedList<T> {
        val pagedList = Mockito.mock(PagedList::class.java) as PagedList<T>
        Mockito.`when`(pagedList.size).thenReturn(list.size)
        return pagedList
    }
}