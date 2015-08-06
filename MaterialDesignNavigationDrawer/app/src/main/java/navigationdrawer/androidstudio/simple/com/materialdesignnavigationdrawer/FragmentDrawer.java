package navigationdrawer.androidstudio.simple.com.materialdesignnavigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentDrawer extends Fragment {

    ActionBarDrawerToggle drawerToggle;
    DrawerLayout drawerLayout;
    private boolean userDrawer, savedInstance;
    private static final String MYPRE = "myPr";
    private static final String KEY_LEARN = "key_learn";
private View viewContainer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drawer, container, false);
    }


    public void setUp(DrawerLayout drawerLayout, Toolbar toolbar, int id) {
        viewContainer=getActivity().findViewById(id);
        drawerLayout = drawerLayout;
        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!userDrawer) {
                    userDrawer = true;
                    saveToPreferance(getActivity(), KEY_LEARN, userDrawer + "");
                }
                getActivity().invalidateOptionsMenu();

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();

            }
        };

        if (!userDrawer && !savedInstance) {
            drawerLayout.openDrawer(viewContainer);
        }
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
           drawerToggle.syncState();
            }
        });
        drawerLayout.setDrawerListener(drawerToggle);
    }

    public static void saveToPreferance(Context context, String name, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MYPRE, Context.MODE_APPEND);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(name, value);
        editor.apply();
    }

    public static String readfromPreferance(Context context, String name, String defaultvalue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MYPRE, Context.MODE_APPEND);
        return sharedPreferences.getString(name, defaultvalue);
    }
}
