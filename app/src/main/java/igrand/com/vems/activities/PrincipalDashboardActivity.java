package igrand.com.vems.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import igrand.com.vems.R;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.dialogs.AttendanceSelectionFragment;
import igrand.com.vems.dialogs.LeavesSelectionFragment;
import igrand.com.vems.dialogs.PermissionsSelectinFragment;
import igrand.com.vems.fragments.adminfragments.ClassRoutinesFragment;
import igrand.com.vems.fragments.adminfragments.GalleryFragment;
import igrand.com.vems.fragments.adminfragments.StudentsListFragment;
import igrand.com.vems.fragments.adminfragments.TeachersListFragment;
import igrand.com.vems.fragments.principalfragments.PrincipalHomeFragment;

public class PrincipalDashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FrameLayout mLayoutPrincipalHome;
    ApplicationPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.nav_draw_icon);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        mLayoutPrincipalHome=(FrameLayout)findViewById(R.id.principal_home_frame_layout);
        preferences=new ApplicationPreferences(this);
        loadFragment(new PrincipalHomeFragment());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.principal_nav_home) {
            loadFragment(new PrincipalHomeFragment());
            // Handle the camera action
        } else if (id == R.id.principal_nav_menu_students) {
            loadFragment(new StudentsListFragment());

        } else if (id == R.id.principal_nav_menu_teachers) {
            loadFragment(new TeachersListFragment());

        } else if (id == R.id.principal_nav_menu_class_routines) {
            loadFragment(new ClassRoutinesFragment());

        } else if (id == R.id.principal_nav_menu_attendance) {
            AttendanceSelectionFragment fragment=new AttendanceSelectionFragment();
            fragment.show(getSupportFragmentManager(),"Attendance Selection");

        } else if (id == R.id.principal_nav_menu_leaves) {
            LeavesSelectionFragment fragment=new LeavesSelectionFragment();
            fragment.show(getSupportFragmentManager(),"Leaves Fragment");

        }
        else if (id == R.id.principal_nav_menu_permissions) {
            PermissionsSelectinFragment fragment=new PermissionsSelectinFragment();
            fragment.show(getSupportFragmentManager(),"Permissions Fragment");

        } else if (id == R.id.principal_nav_menu_activity_gallery) {
            loadFragment(new GalleryFragment());

        }
        else if (id==R.id.principal_nav_menu_logut)
        {
            savePreferences("","");
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void loadFragment(Fragment fragment)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.principal_home_frame_layout, fragment, "")
                .commit();
    }
    private void savePreferences(String username,String password)
    {
        preferences.saveUserName(username);
        preferences.saveUserName(password);
    }
}
