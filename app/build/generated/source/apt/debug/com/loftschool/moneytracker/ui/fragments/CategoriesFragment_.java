//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.1.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.loftschool.moneytracker.ui.fragments;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.loftschool.moneytracker.R;
import org.androidannotations.api.BackgroundExecutor;
import org.androidannotations.api.builder.FragmentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class CategoriesFragment_
    extends com.loftschool.moneytracker.ui.fragments.CategoriesFragment
    implements HasViews, OnViewChangedListener
{
    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    private View contentView_;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
    }

    @Override
    public View findViewById(int id) {
        if (contentView_ == null) {
            return null;
        }
        return contentView_.findViewById(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView_ = super.onCreateView(inflater, container, savedInstanceState);
        if (contentView_ == null) {
            contentView_ = inflater.inflate(R.layout.categories_fragment, container, false);
        }
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentView_ = null;
        rootLayout = null;
        recyclerView = null;
        fab = null;
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static CategoriesFragment_.FragmentBuilder_ builder() {
        return new CategoriesFragment_.FragmentBuilder_();
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        this.rootLayout = ((CoordinatorLayout) hasViews.findViewById(R.id.categories_fragment_root_layout));
        this.recyclerView = ((RecyclerView) hasViews.findViewById(R.id.list_of_categories));
        this.fab = ((FloatingActionButton) hasViews.findViewById(R.id.categories_fab));
        if (this.fab!= null) {
            this.fab.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    CategoriesFragment_.this.fabCategoriesOnClickListener();
                }
            }
            );
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        this.menuItem = menu.findItem(R.id.search_action);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void queryCategory(final String query) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("search_query_id", 600L, "") {

            @Override
            public void execute() {
                try {
                    CategoriesFragment_.super.queryCategory(query);
                } catch (final Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
        }
        );
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<CategoriesFragment_.FragmentBuilder_, com.loftschool.moneytracker.ui.fragments.CategoriesFragment>
    {

        @Override
        public com.loftschool.moneytracker.ui.fragments.CategoriesFragment build() {
            CategoriesFragment_ fragment_ = new CategoriesFragment_();
            fragment_.setArguments(args);
            return fragment_;
        }
    }
}
