package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_count__down.view.*
import kotlinx.android.synthetic.main.fragment_count_up.*
import kotlinx.android.synthetic.main.fragment_count_up.view.*
import kotlinx.android.synthetic.main.fragment_count_up.view.button
import kotlinx.android.synthetic.main.fragment_count_up.view.textView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CountUp.newInstance] factory method to
 * create an instance of this fragment.
 */
class CountUp : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var count:Int=0
        // Inflate the layout for this fragment
        val view1= inflater.inflate(R.layout.fragment_count_up, container, false)
        val argument=arguments?.getString("KEY") ?: "Default"
        view1.increaseCount.text=argument
        view1.button.setOnClickListener {
            count++
            view1.textView.text=count.toString()
        }
        return view1
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CountUp.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CountUp().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}