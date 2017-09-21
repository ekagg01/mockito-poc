package com.ttn.aem.mockito.demo.components.primarynavigation;

import java.util.List;

/**
 * MenuItem class stores the properties of Menus.
 *
 * @author Ekta Aggarwal
 * @version 1.0
 * @since 2015-08-20
 */

public class LinkItems {

	/** The menu item. */
	private String menuItem;
	
	/** The flyout. */
	private boolean flyout;
	
	/** The overview link text. */
	private String overviewLinkText;
	
	/** The featured product image. */
	private String featuredProductImage;
	
	/** The featured area title. */
	private String featuredAreaTitle;
	
	/** The featured area description. */
	private String featuredAreaDescription;
	
	/** The call to action. */
	private String callToAction;
	
	/** The call to action text. */
	private String callToActionText;
	
	/** The child. */
	private List<ChildPage> child;

	/**
	 * Gets the menu item.
	 *
	 * @return the menu item
	 */
	public String getMenuItem() {
		return menuItem;
	}

	/**
	 * Sets the menu item.
	 *
	 * @param menuItem the new menu item
	 */
	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}

	/**
	 * Checks if is flyout.
	 *
	 * @return true, if is flyout
	 */
	public boolean isFlyout() {
		return flyout;
	}

	/**
	 * Sets the flyout.
	 *
	 * @param flyout the new flyout
	 */
	public void setFlyout(boolean flyout) {
		this.flyout = flyout;
	}

	/**
	 * Gets the overview link text.
	 *
	 * @return the overview link text
	 */
	public String getOverviewLinkText() {
		return overviewLinkText;
	}

	/**
	 * Sets the overview link text.
	 *
	 * @param overviewLinkText the new overview link text
	 */
	public void setOverviewLinkText(String overviewLinkText) {
		this.overviewLinkText = overviewLinkText;
	}

	/**
	 * Gets the featured product image.
	 *
	 * @return the featured product image
	 */
	public String getFeaturedProductImage() {
		return featuredProductImage;
	}

	/**
	 * Sets the featured product image.
	 *
	 * @param featuredProductImage the new featured product image
	 */
	public void setFeaturedProductImage(String featuredProductImage) {
		this.featuredProductImage = featuredProductImage;
	}

	/**
	 * Gets the featured area title.
	 *
	 * @return the featured area title
	 */
	public String getFeaturedAreaTitle() {
		return featuredAreaTitle;
	}

	/**
	 * Sets the featured area title.
	 *
	 * @param featuredAreaTitle the new featured area title
	 */
	public void setFeaturedAreaTitle(String featuredAreaTitle) {
		this.featuredAreaTitle = featuredAreaTitle;
	}

	/**
	 * Gets the featured area description.
	 *
	 * @return the featured area description
	 */
	public String getFeaturedAreaDescription() {
		return featuredAreaDescription;
	}

	/**
	 * Sets the featured area description.
	 *
	 * @param featuredAreaDescription the new featured area description
	 */
	public void setFeaturedAreaDescription(String featuredAreaDescription) {
		this.featuredAreaDescription = featuredAreaDescription;
	}

	/**
	 * Gets the call to action.
	 *
	 * @return the call to action
	 */
	public String getCallToAction() {
		return callToAction;
	}

	/**
	 * Sets the call to action.
	 *
	 * @param callToAction the new call to action
	 */
	public void setCallToAction(String callToAction) {
		this.callToAction = callToAction;
	}

	/**
	 * Gets the call to action text.
	 *
	 * @return the call to action text
	 */
	public String getCallToActionText() {
		return callToActionText;
	}

	/**
	 * Sets the call to action text.
	 *
	 * @param callToActionText the new call to action text
	 */
	public void setCallToActionText(String callToActionText) {
		this.callToActionText = callToActionText;
	}

	/**
	 * Gets the child.
	 *
	 * @return the child
	 */
	public List<ChildPage> getChild() {
		return child;
	}

	/**
	 * Sets the child.
	 *
	 * @param child the new child
	 */
	public void setChild(List<ChildPage> child) {
		this.child = child;
	}

}
