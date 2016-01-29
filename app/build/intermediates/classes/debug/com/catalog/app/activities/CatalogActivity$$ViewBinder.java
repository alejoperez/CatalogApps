// Generated code from Butter Knife. Do not modify!
package com.catalog.app.activities;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CatalogActivity$$ViewBinder<T extends com.catalog.app.activities.CatalogActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492972, "field 'viewPager'");
    target.viewPager = finder.castView(view, 2131492972, "field 'viewPager'");
    view = finder.findRequiredView(source, 2131492971, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131492971, "field 'toolbar'");
  }

  @Override public void unbind(T target) {
    target.viewPager = null;
    target.toolbar = null;
  }
}
