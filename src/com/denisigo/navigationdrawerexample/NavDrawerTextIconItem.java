package com.denisigo.navigationdrawerexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A bit more complicated item - it contains icon and text.
 */
public class NavDrawerTextIconItem extends NavDrawerBaseItem {

	private int mIcon;
	private String mText;

	public NavDrawerTextIconItem(int id, String text, int icon) {
		super(id);
		setText(text);
		setIcon(icon);
		setLayoutId(R.layout.navdrawer_texticon_item);
	}

	/**
	 * Setter for the item text
	 * @param text String text
	 */
	public void setText(String text){
		mText = text;
	}
	
	/**
	 * Getter for the item text
	 * @return String text
	 */
	public String getText(){
		return mText;
	}

	/**
	 * Setter for icon resource id
	 * @param icon int resource id
	 */
	public void setIcon(int icon) {
		mIcon = icon;
	}
	
	/**
	 * Getter for icon resource id.
	 * @return int icon recource id
	 */
	public int getIcon(){
		return mIcon;
	}
	

	/**
	 * Final implementation of the getView method. I just calls super to prepare
	 * view and then fills it with appropriate data.
	 */
	@Override
	public View getView(LayoutInflater inflater, View convertView,
			ViewGroup root) {
		// Call super class to give us usable view
		convertView = super.getView(inflater, convertView, root);
		
		// Now we can fill in the layout data
		((TextView) convertView.findViewById(R.id.text)).setText(getText());

		((ImageView) convertView.findViewById(R.id.icon))
		.setImageResource(mIcon);

		return convertView;
	}

}
