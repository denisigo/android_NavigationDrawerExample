package com.denisigo.navigationdrawerexample;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity implements
		ListView.OnItemClickListener {

	// Navigation drawer items ids for handling clicks
	private final static int NAVDRAWER_SIGNIN = 0;
	private final static int NAVDRAWER_LEADERBOARD = 1;
	private final static int NAVDRAWER_SHAREAPP = 2;
	private final static int NAVDRAWER_ACHIEVEMENTS = 3;

	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private ListView mDrawerList;
	private NavDrawerAdapter mDrawerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		// Set shadow for our drawer. We want it to look nice, aren't we? =)
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);

		// Create special object which responsible for handling navigation
		// drawer icon on the action bar and notifying us about drawer state
		// changes
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);

				// Usually you have to hide action bar items here
				// and change its title to application's one
			}

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);

				// Usually you have to restore action bar items and title here
			}
		};

		// Set the drawer toggle as the DrawerListener
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		// Required to enable drawer icon on action bar
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerList = (ListView) mDrawerLayout.findViewById(R.id.drawer_list);

		// Create list for storing drawer items
		ArrayList<NavDrawerItem> drawerItems = new ArrayList<NavDrawerItem>(0);

		// And populate it with various items
		drawerItems.add(new NavDrawerTextIconItem(NAVDRAWER_SIGNIN,
				getString(R.string.sign_in), R.drawable.ic_gplus));
		drawerItems.add(new NavDrawerTextIconItem(NAVDRAWER_LEADERBOARD,
				getString(R.string.leaderboard), R.drawable.ic_leaderboard));
		drawerItems.add(new NavDrawerTextIconItem(NAVDRAWER_ACHIEVEMENTS,
				getString(R.string.achievements), R.drawable.ic_achievements));
		drawerItems.add(new NavDrawerTextIconItem(NAVDRAWER_SHAREAPP,
				getString(R.string.share_app), R.drawable.ic_action_share));

		// Create adapter and initialize it with our list
		mDrawerAdapter = new NavDrawerAdapter(this, drawerItems);

		// Set adapter for ListView
		mDrawerList.setAdapter(mDrawerAdapter);
		// and assign activity as a listener for clicks
		mDrawerList.setOnItemClickListener(this);
	}

	/**
	 * On drawer items click
	 */
	@Override
	public void onItemClick(AdapterView<?> adapterView, View view,
			int position, long id) {
		if (id == NAVDRAWER_SIGNIN) {
			// Begin sign in
		} else if (id == NAVDRAWER_LEADERBOARD) {
			// Show leaderboard
		} else if (id == NAVDRAWER_ACHIEVEMENTS) {
			// Show achievements
		} else if (id == NAVDRAWER_SHAREAPP) {
			// Show share dialog
		}

		mDrawerLayout.closeDrawer(mDrawerList);
	}

	/**
	 * Several methods needed to handle configuration changes and activity state
	 * changes
	 */
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Pass the event to ActionBarDrawerToggle, if it returns
		// true, then it has handled the app icon touch event
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
