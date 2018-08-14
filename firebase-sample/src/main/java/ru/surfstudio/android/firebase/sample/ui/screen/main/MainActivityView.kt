package ru.surfstudio.android.firebase.sample.ui.screen.main

import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.IdRes
import kotlinx.android.synthetic.main.activity_main.*
import ru.surfstudio.android.core.mvp.activity.BaseRenderableActivityView
import ru.surfstudio.android.core.mvp.presenter.CorePresenter
import ru.surfstudio.android.firebase.sample.R
import ru.surfstudio.android.firebase.sample.ui.base.configurator.ActivityScreenConfigurator
import ru.surfstudio.android.notification.ui.notification.PushHandlingActivity
import javax.inject.Inject

/**
 * Вью главного экрана
 */
class MainActivityView : BaseRenderableActivityView<MainScreenModel>(), PushHandlingActivity {
    override fun getScreenName(): String  = "MainActivity"

    @Inject
    internal lateinit var presenter: MainPresenter

    @IdRes
    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun renderInternal(screenModel: MainScreenModel) {}

    override fun getPresenters(): Array<CorePresenter<*>> {
        return arrayOf(presenter)
    }

    override fun createConfigurator(): ActivityScreenConfigurator {
        return MainScreenConfigurator(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?,
                          persistentState: PersistableBundle?,
                          viewRecreated: Boolean) {
        super.onCreate(savedInstanceState, persistentState, viewRecreated)
        send_event_btn.setOnClickListener { presenter.sendEvent(event_text_et.text.toString()) }
    }
}
