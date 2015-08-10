package navigationdrawersecond.androidstudio.simple.com.navigationdrawersecond;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    private View viewContainer;
    ActionBarDrawerToggle actionBarDrawerToggle;
    public NavigationDrawerFragment() {
        // Required empty public constructor
    }
    public void setUp(DrawerLayout drawerLayout, final Toolbar toolbar, int id){
    viewContainer=getActivity().findViewById(id);
        this.toolbar=toolbar;
        this.drawerLayout=drawerLayout;
        actionBarDrawerToggle=new ActionBarDrawerToggle(getActivity(),this.drawerLayout,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }
        };
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                actionBarDrawerToggle.syncState();
            }
        });
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragmen_drawer, container, false);
    }


}
