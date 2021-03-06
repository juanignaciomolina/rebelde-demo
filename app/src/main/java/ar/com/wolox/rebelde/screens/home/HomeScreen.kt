package ar.com.wolox.rebelde.screens.home

import android.content.Context
import com.brianegan.bansa.BaseStore
import com.wealthfront.magellan.Screen
import trikita.anvil.Anvil


class HomeScreen : Screen<HomeView>() {

    //Store
    val store = BaseStore(HomeState(), HomeReducer().reducer)

    // View layer
    override fun createView(context: Context): HomeView {
        store.subscribe { Anvil.render() }
        return HomeView(context)
    }

}
