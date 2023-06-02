package com.example.to_dolist.onboardings

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.PictureDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.caverock.androidsvg.SVG
import com.caverock.androidsvg.SVGParseException
import com.example.to_dolist.R
import com.example.to_dolist.databinding.FragmentSecondBinding
import com.example.to_dolist.functions.StartActivities
import java.io.InputStream


class SecondFragment : Fragment() {
private lateinit var mBinding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentSecondBinding.inflate(inflater,container,false)

        mBinding.btnSkip.setOnClickListener {
            val home = activity?.let { it1 -> StartActivities(it1) }
            home?.startHome()
            onBoardingFinish()
        }
        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)
        mBinding.btnNext.setOnClickListener {
            viewPager?.currentItem = 2
        }
        try {
            // obtén el archivo SVG desde la carpeta de recursos
            val inputStream: InputStream = resources.openRawResource(R.raw.completetask)
            // crea un objeto SVG desde el archivo
            val svg = SVG.getFromInputStream(inputStream)
            // renderiza el objeto SVG en un Picture
            val picture = svg.renderToPicture()
            // convierte el Picture en un Drawable
            val drawable: Drawable = PictureDrawable(picture)
            mBinding.tvImage.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null)
        } catch (e: SVGParseException) {
            // manejar excepción
        }

        return mBinding.root
    }
    private fun onBoardingFinish(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("finish", true)
        editor.apply()
    }
}