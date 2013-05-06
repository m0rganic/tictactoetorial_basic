package com.kinvey.sample.tictac.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockFragment;
import com.kinvey.sample.tictac.R;

public class MenuFragment extends SherlockFragment implements OnClickListener {

	private Button newGame;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public void onResume() {
		super.onResume();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup group,
			Bundle saved) {
		View v = inflater.inflate(R.layout.fragment_menu, group, false);
		bindViews(v);
		return v;
	}

	private void bindViews(View v) {
		newGame = (Button) v.findViewById(R.id.menu_newgame);
		newGame.setOnClickListener(this);
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onClick(View v) {
		if (v == newGame) {
			FragmentTransaction ft = getSherlockActivity()
					.getSupportFragmentManager().beginTransaction();
			ft.replace(android.R.id.content, new GameFragment());
			ft.addToBackStack("Game");
			ft.commit();
		}
	}

}
