package com.vanniktech.espresso.core.utils;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.viewpager.widget.ViewPager;
import org.hamcrest.Description;

public final class CurrentItemMatcher extends BoundedMatcher<View, ViewPager> {
  /**
   * Matches that the expected currentItem is being displayed.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withCurrentItem(0)));</code>
   */
  @CheckResult public static CurrentItemMatcher withCurrentItem(final int currentItem) {
    return new CurrentItemMatcher(currentItem);
  }

  private final int currentItem;

  private CurrentItemMatcher(final int currentItem) {
    super(ViewPager.class);

    this.currentItem = currentItem;
  }

  @Override protected boolean matchesSafely(final ViewPager currentItemBar) {
    return currentItemBar.getCurrentItem() == currentItem;
  }

  @Override public void describeTo(final Description description) {
    description.appendText("has currentItem: ").appendValue(currentItem);
  }
}
