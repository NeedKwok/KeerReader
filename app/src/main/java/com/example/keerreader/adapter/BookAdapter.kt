package com.example.keerreader.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.keerreader.data.Book
import com.example.keerreader.databinding.ItemBookBinding

/**
 * BookshelfFragment界面的recyclerview的adapter
 */

class BookAdapter() : ListAdapter<Book, RecyclerView.ViewHolder>(BookDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BookViewHolder(ItemBookBinding.inflate(
            LayoutInflater.from(parent.context) , parent , false
        ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val bookItem = getItem(position)
        (holder as BookViewHolder).bind(bookItem)
    }

    class BookViewHolder(
        private val binding: ItemBookBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.book?.let { book ->
                   // navigateToReadBook(BookItem, it)
                    Log.d("BookItemAdapter", ":clicked " + book.name)
                }
            }
        }

//        private fun navigateToReadBook(
//            bookItem:BookItem,
//            view: View
//        ) {
//            val direction =
//                HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(
//                    plant.plantId
//                )
//            view.findNavController().navigate(direction)
//        }

        fun bind(item: Book) {
            binding.apply {
                book = item
                executePendingBindings()
            }
        }
    }

}

private class BookDiffCallback : DiffUtil.ItemCallback<Book>() {

    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem.id == newItem.id //kotlin == 和 equals() 在字符串比较上功能相同
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }
}