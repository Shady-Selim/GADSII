package com.example.gadsii.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsii.R
import com.example.gadsii.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class PlaceholderFragment : Fragment() {

    private val viewModel: PageViewModel by viewModel()


/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        *//*pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }*//*

    }*/

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        /*
        val textView: TextView = root.findViewById(R.id.section_label)
        pageViewModel.text.observe(this, Observer<String> {
            textView.text = it
        })
        */

        viewModel.getData(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1).observe(viewLifecycleOwner, {
            rvData.layoutManager = LinearLayoutManager(context)
            rvData.addItemDecoration(
                DividerItemDecoration(
                    rvData.context,
                    DividerItemDecoration.VERTICAL
                )
            )
            rvData.adapter = MainFragmentAdapter(it)
        })

        val binding =
            DataBindingUtil.inflate<FragmentMainBinding>(
                inflater,
                R.layout.fragment_main,
                container,
                false
            )
        binding.viewModel = viewModel
        binding.mainFragment = this@PlaceholderFragment
        binding.lifecycleOwner = this@PlaceholderFragment
        return  binding.root
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}