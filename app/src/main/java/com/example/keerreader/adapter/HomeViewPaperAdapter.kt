package com.example.keerreader.adapter


import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.keerreader.ui.viewpaper.BookshelfFragment
import com.example.keerreader.ui.viewpaper.LibraryFragment
import com.example.keerreader.ui.viewpaper.SettingsFragment
import java.lang.IndexOutOfBoundsException

const val BOOKSHELF_INDEX = 0
const val LIBRARY_INDEX = 1
const val SETTINGS_INDEX = 2

class HomeViewPaperAdapter(fragment:Fragment) :FragmentStateAdapter(fragment) {

    private val fragmentMap: Map<Int,() -> Fragment> = mapOf(
        BOOKSHELF_INDEX to { BookshelfFragment() },
        LIBRARY_INDEX to { LibraryFragment() },
        SETTINGS_INDEX to { SettingsFragment() }
    )

    override fun getItemCount(): Int {
        return fragmentMap.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentMap[position]?.invoke() ?:throw IndexOutOfBoundsException()
    }
}