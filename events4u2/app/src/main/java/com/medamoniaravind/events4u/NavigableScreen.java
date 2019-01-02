package com.medamoniaravind.events4u;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.medamoniaravind.events4u.Fragments.AboutUs;
import com.medamoniaravind.events4u.Fragments.Contact;
import com.medamoniaravind.events4u.Fragments.HomeFragment;
import com.medamoniaravind.events4u.Fragments.LocationFrag;
import com.medamoniaravind.events4u.Fragments.TermsnCond;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NavigableScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
  //  TextView nvgtv1,nvgtv2;
  //
  String Tokenid,usrid;
  String url="http://vdtlabs.com/eventzapp/api.php?";
  int numbercode=0;
  NavigationView navigationView;
  SharedPreferences sharedPreferences,spreferences;
  String nv_token;
  SharedPreferences.Editor editor;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    spreferences=getSharedPreferences("aravnd",MODE_PRIVATE);
    sharedPreferences=getSharedPreferences("abhi",MODE_PRIVATE);
    nv_token=spreferences.getString("token",null);
    setContentView(R.layout.activity_navigable_screen);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    HomeFragment homeFragment=new HomeFragment();
    getSupportFragmentManager().beginTransaction().replace(R.id.nav_frame,homeFragment).commit();
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
      }
    });

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setCheckedItem(R.id.nav_home);
    //navigationView.getHeaderView(0).findViewById(R.id.nvtxvw);

    navigationView.setNavigationItemSelectedListener(this);


    sendTokenToServer(nv_token);
  }

  private void sendTokenToServer(String token) {
    StringRequest stringRequest;
    stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {
        try {
          JSONObject jsonObject=new JSONObject(response);
          String status=jsonObject.getString("error");
          String msg=jsonObject.getString("msg");
          if (status.equals("FALSE")){
            Toast.makeText(NavigableScreen.this,msg, Toast.LENGTH_SHORT).show();

          }else {
            Toast.makeText(NavigableScreen.this,msg, Toast.LENGTH_SHORT).show();
          }

        } catch (JSONException e) {
          e.printStackTrace();
        }

      }
    }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {

      }
    }){
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        HashMap<String,String> hashMap=new HashMap<String,String>();
        hashMap.put("token",Tokenid);
        hashMap.put("id",usrid);

        return hashMap;
      }
    };
    RequestQueue requestQueue= Volley.newRequestQueue(NavigableScreen.this);
    requestQueue.add(stringRequest);


  }



  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    }else if (!(numbercode==0)){
      numbercode=0;
      navigationView.setCheckedItem(R.id.nav_home);
      HomeFragment homeFragment=new HomeFragment();
      getSupportFragmentManager().beginTransaction().replace(R.id.nav_frame,homeFragment).commit();

    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.navigable_screen, menu);
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
    }else {
        startActivity(new Intent(NavigableScreen.this,EditScreen.class));
    }

    return super.onOptionsItemSelected(item);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_home){
      numbercode=0;
    replaceFragment(new HomeFragment());
      // Handle the camera action
    } else if (id == R.id.nav_mytickets) {
      numbercode=1;

    } else if (id == R.id.nav_contact) {
      numbercode=2;
      replaceFragment(new Contact());

    } else if (id == R.id.nav_aboutus) {
      numbercode=3;
     replaceFragment(new AboutUs());
    } else if (id==R.id.nav_rateus) {
      Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName()));
      startActivity(intent);

    } else if (id == R.id.nav_share) {
      Intent intent=new Intent((Intent.ACTION_SEND));
      intent.setType("text/plain");
      intent.putExtra(Intent.EXTRA_SUBJECT, "Install the app");
      intent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id="+getPackageName());
      startActivity(Intent.createChooser(intent,"choose one"));

    } else if (id== R.id.nav_trmsncond){
      numbercode=4;
     replaceFragment(new TermsnCond());
    } else if (id==R.id.nav_location){
      numbercode=5;
      replaceFragment(new LocationFrag());
    }

      else if (id==R.id.nav_logout){
      AlertDialog.Builder alertDialog=new AlertDialog.Builder(NavigableScreen.this);
      alertDialog.setTitle("alert Message");
      alertDialog.setMessage("are you want to logout");
      alertDialog.setCancelable(true);
      alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          startActivity(new Intent(NavigableScreen.this,LoginScreen.class));
          Toast.makeText(NavigableScreen.this, "Successfully Logout", Toast.LENGTH_SHORT).show();
        }
      });
      alertDialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          Toast.makeText(NavigableScreen.this, "your Logout cancelled", Toast.LENGTH_SHORT).show();
        }
      });
      alertDialog.show();
      editor=sharedPreferences.edit();
      editor.putString("mobile","null");
      editor.putString("password","null");
      editor.commit();

    }


    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }


  public void replaceFragment(Fragment fragment){
    getSupportFragmentManager().beginTransaction().replace(R.id.nav_frame,fragment).commit();
  }



}
