package io.github.rciovati.filteringrecyclerview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jakewharton.rxbinding.support.v7.widget.RxSearchView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.rciovati.filteringrecyclerview.databinding.ActivityMainBinding;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private Datasource mDatasource = new Datasource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        final MenuItem menuItem = menu.findItem(R.id.action_search);
        final View actionView = MenuItemCompat.getActionView(menuItem);
        initializeSearchView(((SearchView) actionView));
        return super.onCreateOptionsMenu(menu);
    }

    private void initializeSearchView(SearchView searchView) {
        RxSearchView.queryTextChanges(searchView)
                .debounce(300, TimeUnit.MILLISECONDS)
                .flatMap(mDatasource::countries)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::swapAdapter);
    }

    private void swapAdapter(List<Country> countries) {
        CountriesAdapter adapter = new CountriesAdapter(countries);
        mBinding.recyclerView.swapAdapter(adapter, false);
    }
}
