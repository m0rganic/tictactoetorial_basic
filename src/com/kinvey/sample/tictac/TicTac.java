package com.kinvey.sample.tictac;

import java.util.logging.Level;
import java.util.logging.Logger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.api.client.http.HttpTransport;
import com.kinvey.sample.tictac.fragments.MenuFragment;

public class TicTac extends SherlockFragmentActivity {

	public static final String TAG = "TicTac";

	public static final String Collection = "GameResults";

	public static final int REQUEST_LOGIN = 0;

	private boolean showMenu = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        Logger.getLogger(HttpTransport.class.getName()).setLevel(Level.FINEST);

		showMenu();
	}

	@Override
	protected void onResume() {
		super.onResume();

		if (showMenu) {
			showMenu();

		}

	}

	private void showMenu() {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(android.R.id.content, new MenuFragment());
		ft.commit();
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.activity_tic_tac, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		default:
			return super.onOptionsItemSelected(item);
		}
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == REQUEST_LOGIN) {
			showMenu = true;
		}

	}
}
