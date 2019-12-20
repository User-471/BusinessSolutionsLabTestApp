package com.businesssolutionslabtestapp.ui.providers

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.businesssolutionslabtestapp.R
import com.businesssolutionslabtestapp.model.GiftCard
import com.businesssolutionslabtestapp.ui.base.BaseFragment
import com.businesssolutionslabtestapp.ui.providers.adapter.ProvidersAdapter
import com.businesssolutionslabtestapp.util.CARD
import com.businesssolutionslabtestapp.util.withColor
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_providers.*


class ProvidersFragment : BaseFragment() {

    private lateinit var adapter: ProvidersAdapter
    private lateinit var viewModel: ProvidersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_providers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ProvidersViewModel::class.java).init(kodein)

        initRecycler()
        setOnClickListeners()
        observeErrorMessage()
        observeLoadingData()
        observeProviders()

        fab_double.startAnimation(AnimationUtils.loadAnimation(activity!!, R.anim.fab_appear))
    }

    private fun setOnClickListeners() {
        fab_double.setOnClickListener {
            adapter.doubleCards()
        }
    }

    private fun initRecycler() {
        adapter = ProvidersAdapter(arrayListOf()) { onCardClicked(it) }

        if(view != null) {
            rv_providers.layoutManager = LinearLayoutManager(activity!!)
            rv_providers.adapter = adapter
        }
    }

    private fun onCardClicked(card: GiftCard) {
        if (view != null) {
            val args = Bundle()
            args.putParcelable(CARD, card)
            Navigation.findNavController(cl_fragment_providers)
                .navigate(R.id.action_providersFragment_to_cardFragment, args)
        }
    }

    private fun observeProviders() {
        viewModel.getProviders().observe(activity!!, Observer {
            it?.let {
                adapter.updateData(it)
            }
        })
    }

    private fun observeLoadingData() {
        viewModel.loadingLiveData.observe(this, Observer {
            if (it != null && it) {
                pb_loading.visibility = View.VISIBLE
            } else {
                pb_loading.visibility = View.GONE
            }
        })
    }

    private fun observeErrorMessage() {
        viewModel.errorMessageData.observe(this, Observer {
            Snackbar.make(
                cl_fragment_providers,
                it.toString(),
                Snackbar.LENGTH_SHORT
            )
                .withColor(resources.getColor(R.color.red))
                .show()
        })
    }
}
