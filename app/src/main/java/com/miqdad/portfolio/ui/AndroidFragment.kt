package com.miqdad.portfolio.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.miqdad.portfolio.R
import com.miqdad.portfolio.adapter.RVAndroidAdapter
import com.miqdad.portfolio.data.PortfolioData
import com.miqdad.portfolio.databinding.FragmentAndroidBinding

const val PORTOFOLIO_LINK = "https://https.com.miqdad.portfolio"

class AndroidFragment : Fragment() {

    private var _binding: FragmentAndroidBinding? = null
    private val binding: FragmentAndroidBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAndroidBinding.inflate(inflater, container, false)
        return binding.root

        // Inflate the layout for this fragme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val androidAdapter = RVAndroidAdapter()
        androidAdapter.setData(PortfolioData.listAppAndroid)

        androidAdapter.onItemClicked = { selectedData ->
            CustomTabsIntent.Builder().build()
                .launchUrl(requireContext(), Uri.parse(selectedData.link))
        }

        with(binding.rvAndroid) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = androidAdapter
        }
        binding.btnAndroid.text = getString(
            R.string.app_android_btn,
            PortfolioData.listAppAndroid.size.toString()
        )

        binding.txtDokumentasi.setOnClickListener {
            CustomTabsIntent.Builder().build()
                .launchUrl(requireContext(), Uri.parse(PORTOFOLIO_LINK))
        }

    }
}