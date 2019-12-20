package com.businesssolutionslabtestapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.businesssolutionslabtestapp.injection.initKodein
import com.businesssolutionslabtestapp.injection.module.appModule
import com.businesssolutionslabtestapp.injection.module.netModule
import com.businesssolutionslabtestapp.injection.module.picassoModule
import com.squareup.picasso.Picasso
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class BSLabTestApp : Application(), KodeinAware {

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    override val kodein: Kodein = Kodein.lazy {

        import(appModule(this@BSLabTestApp))
        import(netModule())
        import(picassoModule())
    }

    override fun onCreate() {
        super.onCreate()

        initKodein(this)
        val picasso: Picasso by kodein.instance()
        Picasso.setSingletonInstance(picasso)
    }
}