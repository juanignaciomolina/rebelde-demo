package ar.com.wolox.kotlintest.screens.home

import android.content.Context
import android.widget.LinearLayout
import ar.com.wolox.kotlintest.screens.detail.DetailScreen
import com.wealthfront.magellan.BaseScreenView
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

class HomeView(context: Context) : BaseScreenView<HomeScreen>(context) {

    init {
        addView(object : RenderableView(context) {
            override fun view() {
                linearLayout {
                    size(MATCH, MATCH)
                    padding(dip(8))
                    orientation(LinearLayout.VERTICAL)

                    textView {
                        size(MATCH, 0)
                        weight(1f)
                        gravity(CENTER)
                        textSize(sip(32f))
                        text("Times: " + screen.store.state.counter)
                    }

                    button {
                        size(MATCH, WRAP)
                        text("Go to detail")
                        layoutGravity(CENTER)
                        onClick { v ->
                            screen.store.dispatch(HomeReducer.INCREMENT)
                            screen.navigator.goTo(DetailScreen())
                        }
                    }
                }
            }
        })
    }

}