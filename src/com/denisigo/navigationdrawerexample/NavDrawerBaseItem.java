package com.denisigo.navigationdrawerexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Base implementation for NavDrawer item.
 */
public abstract class NavDrawerBaseItem implements NavDrawerItem {
	// Id of the item
	private int mId = -1;
	// Layout id used by the item
	private int mLayoutId;

	public NavDrawerBaseItem() {
	}
	
	public NavDrawerBaseItem(int id) {
		setId(id);
	}

	public int getId() {
		return mId;
	}

	public void setId(int id) {
		mId = id;
	}

	public int getLayoutId() {
		return mLayoutId;
	}

	protected void setLayoutId(int id) {
		mLayoutId = id;
	}
	
	public boolean isEnabled(){
		return true;
	}

	/**
	 * This base implementation of getView adds handy check to ensure that 
	 * provided convertView is reusable.
	 * Successors should call super(inflater, convertView, root) and use result
	 * as already inflated view ready to fill particular data into it.
	 */
	public View getView(LayoutInflater inflater, View convertView,
			ViewGroup root) {
		// We want to reuse only suitable views
		if (convertView != null && convertView.getId() != getLayoutId())
			convertView = null;

		// Create a new view if there is no suitable convertView
		if (convertView == null)
			convertView = inflater.inflate(getLayoutId(), root, false);

		return convertView;
	}

}
