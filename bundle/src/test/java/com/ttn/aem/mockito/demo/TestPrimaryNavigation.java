package com.ttn.aem.mockito.demo;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.ttn.aem.mockito.demo.components.primarynavigation.PrimaryNavConstants;
import com.ttn.aem.mockito.demo.components.primarynavigation.PrimaryNavigation;
import org.apache.sling.api.resource.ResourceResolver;

import org.apache.sling.commons.json.JSONException;

import org.junit.Before;

import org.junit.Rule;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.Mock;

import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import com.day.cq.wcm.api.Page;

import com.day.cq.wcm.api.PageManager;

import com.day.cq.wcm.api.designer.Style;

import com.google.common.collect.ImmutableMap;

import io.wcm.testing.mock.aem.junit.AemContext;


@RunWith(MockitoJUnitRunner.class)

public class TestPrimaryNavigation {

	/** The mocked properties. */

	@Mock

	Style currentStyle;

	/** The res resolver obj. */

	@Mock

	ResourceResolver resResolverObj;

	/** The page manager. */

	@Mock

	PageManager pageManager;

	/** The page. */

	@Mock

	Page page;

	/** The primary nav obj. */



	//Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)


	private PrimaryNavigation primaryNavObj = new PrimaryNavigation() {

		public Style getCurrentStyle() {

			return currentStyle;

		};

		public ResourceResolver getResourceResolver() {

			return resResolverObj;

		};

	};

	/** The mocked AEM context. */

	@Rule

	public final AemContext context = new AemContext();

	/**
	 * 
	 * Setup.
	 * 
	 */

	@Before

	public void setup() {

		//currentStyle = Mockito.mock(Style.class);

		when(currentStyle.get(PrimaryNavConstants.NAV_DIALOG_NAME, String[].class))

		.thenReturn(setUpAndReturnData());


	}

	/**
	 * 
	 * This method is used to test getMenuItems() with null links.
	 *
	 * 
	 * 
	 * @throws JSONException
	 *             the JSON exception
	 * 
	 */

	@Test

	public void testGetMenuItemsWithNullLinks() throws JSONException {

		assertEquals(0, primaryNavObj.getMenuItems(null).size());

	}

	/**
	 * Test activate with nav title.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test

	public void testActivateWithNavTitle() throws Exception {

		Page mockPage = context.create().page("/content/geometrixx-outdoors-mobile/en", "template", "test");

		Page childPage = context.create().page("/content/geometrixx-outdoors-mobile/en/Mens", "template",

		ImmutableMap.<String, Object> builder().put("title", "Title").put("navTitle", "nTitle").build());

		PageManager mockPageManager = context.pageManager();

		when(resResolverObj.adaptTo(PageManager.class)).thenReturn(mockPageManager);

		when(page.getNavigationTitle()).thenReturn("TestNavigationTitle");

		primaryNavObj.activate();

		assertNotNull(page.getNavigationTitle());

		assertNotNull(primaryNavObj.getMenuList());

		assertTrue(primaryNavObj.getMenuList().size() > 0);

		assertEquals(1, primaryNavObj.getMenuItems(setUpAndReturnData()).size());

	}

	/**
	 * 
	 * Test child links with title.
	 *
	 * 
	 * 
	 * @throws Exception
	 *             the exception
	 * 
	 */

	@Test

	public void testChildLinksWithTitle() throws Exception

	{
		Page mockPage = context.create().page("/content/geometrixx-outdoors-mobile/en", "template", "test");

		Page childPage = context.create().page("/content/geometrixx-outdoors-mobile/en/Mens", "template",

		ImmutableMap.<String, Object> builder().put("title", "Title").build());

		Page childPage1 = context.create().page("/content/geometrixx-outdoors-mobile/en/Womens", "template",

				ImmutableMap.<String, Object> builder().put("title", "newTitle").build());

		PageManager mockPageManager = context.pageManager();

		when(resResolverObj.adaptTo(PageManager.class)).thenReturn(mockPageManager);

		Iterator<Page> iterator = Mockito.mock(Iterator.class);
		/*when(iterator.hasNext()).thenReturn(true,true);
		when(iterator.next()).thenReturn(childPage).thenReturn(childPage1);
		when(mockPage.listChildren()).thenReturn(iterator);
		assertEquals(primaryNavObj.getChildLinks("/content/geometrixx-outdoors-mobile/en"),2);*/
		assertEquals(1, primaryNavObj.getMenuItems(setUpAndReturnData()).size());
		//verify(primaryNavObj, atLeastOnce(primaryNavObj.getMenuItems(setUpAndReturnData()));

	}

	/**
	 * 
	 * Sets the up and return data.
	 *
	 * 
	 * 
	 * @return the string[]
	 * 
	 */

	private String[] setUpAndReturnData() {

		return new String[] { "{menuItem:\"/content/geometrixx-outdoors-mobile/en\", flyout:\"true\" , "

				+ "overviewLinkText: \"ABC\",featuredProductImage:\"\",featuredAreaTitle:\"\","

				+ "featuredAreaDescription:\"\", callToAction:\"\", callToActionText:\"\"}" };
	};

}