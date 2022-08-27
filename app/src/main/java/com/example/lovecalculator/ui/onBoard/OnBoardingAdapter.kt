package com.example.lesson41.ui.onBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemBoardingBinding
import com.example.lovecalculator.ui.onBoard.BoardModel

class BoardingAdapter(private val onStartClick: () -> Unit) :
    RecyclerView.Adapter<BoardingAdapter.ViewHolder>() {

    val arrayList = arrayListOf<BoardModel>(
        BoardModel("Check your compatibility", R.raw.cat1),
        BoardModel("Enter your names", R.raw.cat2),
        BoardModel("And look for result", R.raw.jellyfish),
        BoardModel("All the best", R.raw.koala)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = arrayList.size

    inner class ViewHolder(private val binding: ItemBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.tvTitle.text = arrayList[adapterPosition].title
            binding.lottieMain.setAnimation(arrayList[adapterPosition].lottie)
            binding.btnStart.isVisible = adapterPosition == arrayList.lastIndex
            binding.btnStart.setOnClickListener {
                onStartClick()
            }
        }
    }
}