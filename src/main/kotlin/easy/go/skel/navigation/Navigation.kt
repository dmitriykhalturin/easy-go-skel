package easy.go.skel.navigation

import android.content.Intent
import android.os.Bundle
import androidx.annotation.ColorRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for easy_go_skel on 06.04.20 21:10.
 */
interface Navigation {

  fun startRootActivity(activityClass: Class<out FragmentActivity>, bundle: Bundle? = null)
  fun startIntentActivity(intent: Intent, bundle: Bundle? = null)
  fun startIntentResolvedActivity(intent: Intent): Boolean

  fun addRootFragment(fragmentClass: Class<out Fragment>, arguments: Bundle? = null)
  fun addFragment(fragmentClass: Class<out Fragment>, arguments: Bundle? = null)
  fun back()

  fun showDialogFragment(dialogFragment: DialogFragment)

  fun openUrlInInternalBrowser(url: String, @ColorRes customTabsColor: Int)
}
