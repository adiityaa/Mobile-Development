package com.makara

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.makara.databinding.FragmentDetailFoodBinding

class DetailFoodFragment : Fragment() {
    private lateinit var binding: FragmentDetailFoodBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailFoodBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivBackArrow.setOnClickListener{
            requireActivity().onBackPressed()
        }

        binding.tvLearnMore.setOnClickListener {
            openLearnMoreLink()
        }


        val food = DetailFoodFragmentArgs.fromBundle(arguments as Bundle).food

        if (food != null) {
            binding.ivFood.setImageResource(food.photo)
            binding.tvDescriptionFood.text = food.description
            binding.tvTitleFood.text = food.name
            binding.tvFromFood.text = food.from
        }
    }

    private fun openLearnMoreLink() {
        val food = DetailFoodFragmentArgs.fromBundle(arguments as Bundle).food
        food?.let {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.link))
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}