package com.denisigo.navigationdrawerexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Simple item for NavDrawer. Just have text.
 */
public class NavDrawerTextItem extends NavDrawerBaseItem {

	// Text for the item
	private String mText;
	
	public NavDrawerTextItem(int id, String text) {
		super(id);
		setText(text);
		setLayoutId(R.layout.navdrawer_text_item);
	}
	
	/**
	 * Setter for the item text.
	 * 
	 * @param text
	 *            String
	 */
	public void setText(String text) {
		mText = text;
	}

	/**
	 * Getter for the item text.
	 * 
	 * @return String text
	 */
	public String getText() {
		return mText;
	}

	/**
	 * Final implementation of the getView method. I just calls super to prepare
	 * view and then fills it with appropriate data.
	 */
	@Override
	public View getView(LayoutInflater inflater, View convertView, ViewGroup root) {
		convertView = super.getView(inflater, convertView, root);
		
		// Fill layout data
		((TextView)convertView.findViewById(R.id.text)).setText(getText());
		
		return convertView;
	}
}
