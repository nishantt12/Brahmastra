package nishant.com.brahmastra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by nishant on 16/9/16.
 */
public class ManageFragments {

    public void showFragment(AppCompatActivity context, int layoutId, boolean isAnimation, boolean isAddToBackStack, Fragment fragment, String tag, Bundle args) {

        FragmentManager fragmentManager = context.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (args != null) {
            fragment.setArguments(args);
        }

        initiateFragment(fragmentTransaction, layoutId, isAnimation, isAddToBackStack, fragment, tag);
    }

    public void showFragmentNoEnter(AppCompatActivity context, int layoutId, boolean isAnimation, boolean isAddToBackStack, Fragment fragment, String tag, Bundle args) {

        FragmentManager fragmentManager = context.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (args != null) {
            fragment.setArguments(args);
        }
        initiateFragmentNoEnter(fragmentTransaction, layoutId, isAnimation, isAddToBackStack, fragment, tag);
    }

    private void initiateFragment(FragmentTransaction fragmentTransaction, int layoutId, boolean isAnimation, boolean isAddToBackStack, Fragment fragment, String tag) {
        if (isAnimation) {
            fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        }

        fragmentTransaction.replace(layoutId, fragment, tag);
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack("share");
        }

        fragmentTransaction.commit();
    }

    private void initiateFragmentNoEnter(FragmentTransaction fragmentTransaction, int layoutId, boolean isAnimation, boolean isAddToBackStack, Fragment fragment, String tag) {
        if (isAnimation) {
            fragmentTransaction.setCustomAnimations(0, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        }

        fragmentTransaction.replace(layoutId, fragment, tag);
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }

        fragmentTransaction.commit();
    }

}
