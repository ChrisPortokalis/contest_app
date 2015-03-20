package andronerds.com.contestapp.fragments.trips;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import andronerds.com.contestapp.R;
import andronerds.com.contestapp.cards.MyTripsTripCard;
import andronerds.com.contestapp.data.Trip;
import butterknife.ButterKnife;
import butterknife.InjectView;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

/**
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version ContestApp v0.1A
 * @since 2/15/15
 */
public class MyTripsFragment extends Fragment implements Card.OnCardClickListener
{
    private static final String MAP_URI_PREFIX = "http://maps.google.com/maps/api/staticmap?center=";
    private static final String MAP_URI_POSTFIX = "&zoom=15&size=200x200&sensor=false";

    @InjectView(R.id.trips_grid_view)CardListView mTripsListView;

    private ArrayList<Card> mTripCardsList = new ArrayList<>();
    private ArrayList<Trip> mTripsList = new ArrayList<>();
    private CardArrayAdapter mTripsAdapter;
    private Trip mCurrentTrip;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        for(int i = 0; i < 3; i++)
        {
            Trip trip = new Trip();
            if(i < 1)
            {
                trip.setmTripMap(R.drawable.pc_map);
                trip.setmTripStart("Oklahoma City, OK");
                trip.setmTripEnd("Stillwater, OK");
                trip.setPoints(73);
                trip.setTripMileageCount(112);
                trip.setHarshAccelCount(2);
                trip.setHarshBrakeCount(3);
                trip.setHarshTurnCount(1);
                trip.setSpeedingCount(6);
                trip.setmTripStartLat(35.4822);
                trip.setmTripStartLong(-97.5350);
                trip.setmTripEndLat(36.1157);
                trip.setmTripEndLong(-97.0586);
            }
            else
            {
                trip.setmTripMap(R.drawable.pc_map);
                trip.setmTripStart("Stillwater, OK");
                trip.setmTripEnd("Owasso, OK");
                trip.setPoints(18);
                trip.setTripMileageCount(23);
                trip.setHarshAccelCount(1);
                trip.setHarshBrakeCount(0);
                trip.setHarshTurnCount(2);
                trip.setSpeedingCount(1);
                trip.setmTripStartLat(36.1157);
                trip.setmTripStartLong(-97.0586);
                trip.setmTripEndLat(36.2903);
                trip.setmTripEndLong(-95.8286);
            }
            mTripsList.add(trip);
            MyTripsTripCard card = new MyTripsTripCard(getActivity(), mTripsList.get(i));
            card.setClickable(true);
            card.setOnClickListener(this);
            mTripCardsList.add(card);
        }

        mTripsAdapter = new CardArrayAdapter(getActivity(), mTripCardsList);
        mTripsAdapter.setCardListView(mTripsListView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_my_trips, container, false);
        ButterKnife.inject(this, view);
        mTripsListView.setAdapter(mTripsAdapter);
        return view;
    }

    @Override
    public void onClick(Card card, View view)
    {
        Log.d("TRIP SELECTED", "You have selected a new trip");
        MyTripsTripCard tripCard = (MyTripsTripCard) card;
        Bundle args = new Bundle();
        Trip trip = tripCard.getTrip();
        //args.putSerializable(Intent.EXTRA_TEXT, trip);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        TripInfoFragment infoFragment = new TripInfoFragment();
        infoFragment.setArguments(args);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.replace(R.id.my_trips_fragment_container, infoFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
