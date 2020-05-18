package com.dap.lovebirds.meet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.dap.lovebirds.R;
import com.dap.lovebirds.activity.DashboardActivity;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


public class MeetFragment extends Fragment {
    private FeatureCoverFlow mCoverFlow;
    private MeetFlowAdapter mAdapter;
    private ArrayList<MeetImageDTO> mData = new ArrayList<>(0);
    private TextSwitcher mTitle;
    DashboardActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (DashboardActivity) getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_meet, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_coverflow_activity,menu);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mData.add(new MeetImageDTO(R.drawable.img, R.string.img));
        mData.add(new MeetImageDTO(R.drawable.img, R.string.img));
        mData.add(new MeetImageDTO(R.drawable.img, R.string.img));
        mData.add(new MeetImageDTO(R.drawable.img, R.string.img));
        mData.add(new MeetImageDTO(R.drawable.img, R.string.img));
        mData.add(new MeetImageDTO(R.drawable.img, R.string.img));
        mData.add(new MeetImageDTO(R.drawable.img, R.string.img));

        mTitle =  getView().findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(activity);
                TextView textView = (TextView) inflater.inflate(R.layout.item_title, null);
                return textView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(activity, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(activity, R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);


        mAdapter = new MeetFlowAdapter(activity);
        mAdapter.setData(mData);
        mCoverFlow = getView().findViewById(R.id.coverflow);
        mCoverFlow.setAdapter(mAdapter);

        mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(activity, getResources().getString(mData.get(position).titleResId),
                        Toast.LENGTH_SHORT).show();


            }
        });

        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(getResources().getString(mData.get(position).titleResId));
            }

            @Override
            public void onScrolling() {
                mTitle.setText("");
            }
        });

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
