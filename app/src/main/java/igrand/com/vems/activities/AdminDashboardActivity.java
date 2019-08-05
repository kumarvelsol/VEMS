package igrand.com.vems.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
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
import android.view.Menu;
import android.widget.FrameLayout;

import igrand.com.vems.R;
import igrand.com.vems.apppreferences.ApplicationPreferences;
import igrand.com.vems.dialogs.AttendanceSelectionFragment;
import igrand.com.vems.dialogs.LeavesSelectionFragment;
import igrand.com.vems.dialogs.PermissionsSelectinFragment;
import igrand.com.vems.fragments.adminfragments.AdminHomeFragment;
import igrand.com.vems.fragments.adminfragments.AdminMessagesFragment;
import igrand.com.vems.fragments.adminfragments.AssignmentsFragment;
import igrand.com.vems.fragments.adminfragments.ClassRoutinesFragment;
import igrand.com.vems.fragments.adminfragments.GalleryFragment;
import igrand.com.vems.fragments.adminfragments.StudentsListFragment;
import igrand.com.vems.fragments.adminfragments.TeachersListFragment;

public class AdminDashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FrameLayout mLayotAdminHomeFrame;
    ApplicationPreferences preferences;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(android.R.color.transparent);
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
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));
        mLayotAdminHomeFrame=(FrameLayout)findViewById(R.id.admin_home_frame_layout);
        AdminHomeFragment fragment=new AdminHomeFragment();
        loadFragment(fragment);
        preferences=new ApplicationPreferences(this);
        //getSupportActionBar().hide();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id==R.id.admin_nav_home)
        {
            loadFragment(new AdminHomeFragment());
        }
        else  if (id == R.id.admin_nav_menu_students) {
            loadFragment(new StudentsListFragment());

            // Handle the camera action
        }
       else if (id==R.id.admin_nav_menu_teachers)
        {
            loadFragment(new TeachersListFragment());
        }
        else if (id == R.id.admin_nav_menu_class_routines)
        {
            loadFragment(new ClassRoutinesFragment());
        }
        else if (id == R.id.admin_nav_menu_attendance) {
            AttendanceSelectionFragment fragment=new AttendanceSelectionFragment();
            fragment.show(getSupportFragmentManager(),"Attendance Selection");
        }
        else if (id == R.id.admin_nav_menu_leaves) {
            LeavesSelectionFragment fragment=new LeavesSelectionFragment();
            fragment.show(getSupportFragmentManager(),"Leaves Fragment");

        }
        else if (id == R.id.admin_nav_menu_permissions) {
            PermissionsSelectinFragment fragment=new PermissionsSelectinFragment();
            fragment.show(getSupportFragmentManager(),"Permissions Fragment");

        }
        else if (id == R.id.admin_nav_menu_messages) {
            loadFragment(new AdminMessagesFragment());

        } else if (id == R.id.admin_nav_menu_assignments) {
            loadFragment(new AssignmentsFragment());

        }
        else if (id == R.id.admin_nav_menu_activity_gallery) {
            loadFragment(new GalleryFragment());

        } else if (id == R.id.admin_nav_menu_logut) {
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
                .replace(R.id.admin_home_frame_layout, fragment, "")
                .commit();
    }
    private void savePreferences(String username,String password)
    {
        preferences.saveUserName(username);
        preferences.saveUserName(password);
    }
}
