package com.dap.lovebirds.more;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dap.lovebirds.R;
import com.dap.lovebirds.activity.DashboardActivity;
import com.dap.lovebirds.more.chafunnt.ChatActivity;
import com.dap.lovebirds.more.family.FamilyActivity;
import com.dap.lovebirds.more.friends.FriendActivity;
import com.dap.lovebirds.more.love.LoveActivity;

import de.hdodenhof.circleimageview.CircleImageView;


public class MoreFragment extends Fragment {

    private CircleImageView family, friends, love, chatFunny;

    DashboardActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        family = getView().findViewById(R.id.iv_family);
        friends = getView().findViewById(R.id.iv_friends);
        love = getView().findViewById(R.id.iv_love);
        chatFunny = getView().findViewById(R.id.iv_chats);
        activity = (DashboardActivity) getActivity();

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, FamilyActivity.class);
                startActivity(intent);

            }
        });

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, FriendActivity.class);
                startActivity(intent);
            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, LoveActivity.class);
                startActivity(intent);
            }
        });

        chatFunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ChatActivity.class);
                startActivity(intent);
            }
        });
    }
}
