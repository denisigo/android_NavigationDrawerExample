package com.denisigo.navigationdrawerexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Interface for NavDrawer item.
 */
public interface NavDrawerItem {
	/**
	 * Get id of the view.
	 * 
	 * @return int id of the view
	 */
	public int getId();

	/**
	 * Set id for the view to be able to track clicks on it.
	 * 
	 * @param id
	 */
	public void setId(int id);
	
	/**
	 * Whether item is enabled or not.
	 * @return true if enabled false otherwise.
	 */
	public boolean isEnabled();

	/**
	 * Each item is responsible for inflating its own view.
	 * 
	 * @param inflater
	 *            Inflater service provided by adapter.
	 * @param convertView
	 *            Previously created view which might be reused. Implementors
	 *            MUST check for view.getId() to match id of layout they use.
	 * @param root
	 *            Root view to inflate.
	 * @return View instance.
	 */
	public View getView(LayoutInflater inflater, View convertView,
			ViewGroup root);
}
