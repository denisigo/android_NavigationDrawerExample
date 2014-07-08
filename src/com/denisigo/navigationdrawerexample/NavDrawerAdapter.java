package com.denisigo.navigationdrawerexample;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Custom NavDrawerAdapter for handling our drawer items.
 */
public class NavDrawerAdapter extends BaseAdapter {

	private Context mContext;
	private ArrayList<NavDrawerItem> mItems;
	LayoutInflater mInflater;
	
	public NavDrawerAdapter(Context context) {
		mContext = context;
		init();
	}

	public NavDrawerAdapter(Context context, ArrayList<NavDrawerItem> items) {
		mContext = context;
		mItems = items;
		init();
	}
	
	/**
	 * Set items.
	 * @param items ArrayList of items implementing NavDrawerItem interface
	 */
	public void setItems(ArrayList<NavDrawerItem> items){
		mItems = items;
		notifyDataSetChanged();
	}
	
	/**
	 * Initiate adapter, get layout inflater etc.
	 */
	private void init(){
		mInflater = (LayoutInflater) mContext
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		if (mItems != null)
			return mItems.size();
		return 0;
	}

	@Override
	public Object getItem(int position) {
		if (mItems != null)
			return mItems.get(position);
		return null;
	}

	/**
	 * Get item ID to simplify handling clicks on it.
	 */
	@Override
	public long getItemId(int position) {
		NavDrawerItem item = (NavDrawerItem) getItem(position);
		if (item != null)
			return item.getId();
		return -1;
	}
	
	@Override
	public boolean isEnabled(int position) {
		final NavDrawerItem item = (NavDrawerItem) getItem(position);
		if (item != null)
			return item.isEnabled();
		return false;
	}

	/**
	 * Method to generate view for an item at given position.
	 * Adapter delegate view generation to the items themselves.
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup root) {
		return ((NavDrawerBaseItem) getItem(position)).getView(mInflater, convertView, root);
	}

}
