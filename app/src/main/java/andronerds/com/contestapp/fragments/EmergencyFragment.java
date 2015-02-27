package andronerds.com.contestapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import andronerds.com.contestapp.R;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version ContestApp v0.1A
 * @since 2/15/15
 */
public class EmergencyFragment extends Fragment
{
    @InjectView(R.id.emergency_icon)ImageView mEmergencyIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_emergency, container, false);
        ButterKnife.inject(this, view);

        Picasso.with(this.getActivity())
                .load(R.drawable.ic_emergency)
                .fit()
                .into(mEmergencyIcon);

        return view;
    }
}