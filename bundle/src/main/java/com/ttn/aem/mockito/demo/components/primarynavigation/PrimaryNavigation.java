package com.ttn.aem.mockito.demo.components.primarynavigation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adobe.cq.sightly.WCMUse;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;
import com.day.cq.wcm.api.PageManager;

/**
 * 
 * PrimaryNavigation class is used to: * Fetch data from the PrimaryNavigation
 * 
 * component. Process and return data to the HTML file for displaying.
 * 
 * 
 * 
 * @author Ekta Aggarwal
 * 
 * @version 1.0
 * 
 * @since 2015-08-20
 * 
 */

public class PrimaryNavigation extends WCMUse {

	/** The Constant LOGGER. */

	private static final Logger LOGGER = LoggerFactory

	.getLogger(PrimaryNavigation.class);

	/** The links. */

	private String[] links;

	/** The final menu list. */

	private List<LinkItems> finalMenuList;

	/** The resource res. */

	private ResourceResolver resourceRes;

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * 
	 * 
	 * @see com.adobe.cq.sightly.WCMUse#activate() This method is used to
	 * 
	 * perform the post initialization tasks i.e. getting data from the
	 * 
	 * primaryNavigation dialog and process it.
	 * 
	 * 
	 * 
	 * @return void
	 */

	@Override
	public void activate() throws JSONException {

		LOGGER.info("Start of method activate");

		links = getCurrentStyle().get(PrimaryNavConstants.NAV_DIALOG_NAME,

		String[].class);

		LOGGER.info("menuItems" + links);

		finalMenuList = getMenuItems(links);

	}

	/**
	 * 
	 * This method is returning the menuItems.
	 *
	 * 
	 * 
	 * @param menuItems
	 * 
	 *            the menu items
	 * 
	 * @return the menu items
	 * 
	 * @throws JSONException
	 * 
	 *             the JSON exception
	 * 
	 */

	public List<LinkItems> getMenuItems(String[] menuItems)

	throws JSONException {

		List<LinkItems> menuItemList = new ArrayList<LinkItems>();

		List<ChildPage> childList = new ArrayList<ChildPage>();

		LinkItems menu;

		String finalMenuItem;

		if (menuItems != null && menuItems.length > 0) {

			// Iterating over the menus

			for (int i = 0; i < menuItems.length; i++) {

				menu = new LinkItems();

				JSONObject jsonObject = new JSONObject(menuItems[i]);

				finalMenuItem = (jsonObject.get(PrimaryNavConstants.MENUITEM)

				.toString()) + ".html";

				menu.setMenuItem(finalMenuItem);

				menu.setFlyout(Boolean.valueOf(jsonObject.get("flyout")

				.toString()));

				menu.setOverviewLinkText(jsonObject.get(

				PrimaryNavConstants.OVERVIEWLINKTEXT).toString());

				menu.setCallToAction(jsonObject.get(

				PrimaryNavConstants.CALLTOACTION).toString()

				+ ".html");

				menu.setCallToActionText(jsonObject.get(

				PrimaryNavConstants.CALLTOACTIONTEXT).toString());

				menu.setFeaturedAreaDescription(jsonObject.get(

				PrimaryNavConstants.FEATUREDAREADES).toString());

				menu.setFeaturedAreaTitle(jsonObject.get(

				PrimaryNavConstants.FEATUREDAREATITLE).toString());

				menu.setFeaturedProductImage(jsonObject.get(

				PrimaryNavConstants.FEATUREDPRODUCTIMAGE).toString());

				LOGGER.info("Inside getMenuItems | Menu Item Path :"

				+ jsonObject.get(PrimaryNavConstants.MENUITEM)

				.toString());

				if (null != jsonObject.get(PrimaryNavConstants.MENUITEM)

				|| "" != jsonObject.get(PrimaryNavConstants.MENUITEM)) {

					childList = getChildLinks(jsonObject.get("menuItem")

					.toString());

				}

				if (!(childList.isEmpty())) {

					LOGGER.info("Inside getMenuItems | If child List is not null setting");

					menu.setChild(childList);

				}

				menuItemList.add(menu);

			}

		}

		LOGGER.info("End of method getMenuItems" + menuItemList.size());

		return menuItemList;

	}

	/**
	 * 
	 * This method is returning the child pages list of a page.
	 *
	 * 
	 * 
	 * @param menuItem
	 * 
	 *            the menu item
	 * 
	 * @return the child links
	 * 
	 */

	public List<ChildPage> getChildLinks(String menuItem) {

		LOGGER.info("Start of method getChildLinks" + menuItem);

		List<ChildPage> childPageList = new ArrayList<ChildPage>();

		String parentPath = menuItem;

		resourceRes = getResourceResolver();

		LOGGER.info("Inside getChildLinks | Parent Path :" + parentPath);

		Page parentPage = resourceRes.adaptTo(PageManager.class).getPage(

		parentPath);

		ChildPage childPage;

		if (null != parentPage) {

			Iterator<Page> children = parentPage.listChildren(new PageFilter());

			// Iterating over the child page list

			while (children.hasNext()) {

				Page child = children.next();

				childPage = new ChildPage();

				if (null != child.getNavigationTitle()) {

					childPage.setTitle(child.getNavigationTitle());

				} else {

					childPage.setTitle(child.getTitle());

				}

				childPage.setPath(child.getPath() + ".html");

				childPageList.add(childPage);

			}

			if (!(childPageList.isEmpty()))

				LOGGER.info("Inside getChildLinks | Size of childPageList :"

				+ childPageList.size());

		}

		return childPageList;

	}

	/**
	 * 
	 * This method is returning final list with menus and their child pages.
	 *
	 * 
	 * 
	 * @return ArrayList<MenuItem>
	 * 
	 */

	public List<LinkItems> getMenuList() {

		return finalMenuList;

	}

}
