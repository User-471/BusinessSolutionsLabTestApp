package com.businesssolutionslabtestapp.injection

import android.app.Application
import com.businesssolutionslabtestapp.injection.module.appModule
import com.businesssolutionslabtestapp.injection.module.netModule
import com.businesssolutionslabtestapp.injection.module.picassoModule
import org.kodein.di.Kodein

lateinit var di: Kodein

fun initKodein(app: Application) {

    di = Kodein {
        import(appModule(app))
        import(
            netModule()
        )
        import(picassoModule())
    }
}