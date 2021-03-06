package andronerds.com.contestapp;

import android.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import andronerds.com.contestapp.fragments.insurance.InsuranceVehicleListFragment;
import andronerds.com.contestapp.navDrawer.NavDrawerActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version ContestApp v1.0
 * @since 2/19/15
 */
public class InsuranceInfoActivity extends NavDrawerActivity
{
    private CharSequence mTitle = "Insurance";

    @InjectView(R.id.insurance_info_toolbar)Toolbar mToolbar;

    @Override
    protected Toolbar init()
    {
        setContentView(R.layout.activity_insurance_info);
        ButterKnife.inject(this);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        InsuranceVehicleListFragment vehicleListFragment = new InsuranceVehicleListFragment();
        fragmentTransaction.replace(R.id.insurance_info_fragment_container, vehicleListFragment);
        fragmentTransaction.commit();

        //mToolbar.showOverflowMenu();
        mToolbar.setTitle(mTitle);
        setSupportActionBar(mToolbar);

        return mToolbar;
    }
}
