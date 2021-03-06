package com.dadaabs.mhealth.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dadaabs.mhealth.Models.GeneralHealthModel;
import com.dadaabs.mhealth.Models.HygeneTipsModel;
import com.dadaabs.mhealth.R;
import com.dadaabs.mhealth.ShowHealthDetails;
import com.dadaabs.mhealth.ShowHygeneTipsDetails;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HygeneTips extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_POSITION = "position";
    private int position;

    private OnHomeTabFragListener mListener;
    //private NewsModel newModel = NewsModel.getInstance();


    // Set grid view items titles and images
    DatabaseReference dbref;
    FirebaseRecyclerAdapter<HygeneTipsModel,HygeneTips.HygeneTipsModelVH> firebasenewsRecycleAdapter ;
    RecyclerView newsrecyclerView;
    LinearLayoutManager nwlinearLayoutManager;
    ProgressBar newsprogressBar;

    public static class HygeneTipsModelVH extends RecyclerView.ViewHolder{

        public final TextView newsHead, newsBody;
        View mView;

        public HygeneTipsModelVH(View itemView) {
            super(itemView);
            this.mView = itemView;
            this.newsHead = (TextView) mView.findViewById(R.id.lv_title);
            this.newsBody = (TextView) mView.findViewById(R.id.lv_description);



        }

    }// End NewsModelVH class

    public static final String NEWS= "HygeneTipsModel";




    public HygeneTips() { // Required empty public constructor
    }

    public static HygeneTips newInstance(int position) {
        HygeneTips fragment = new HygeneTips();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION,position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_POSITION);
        }
    }

    public void setListener(OnHomeTabFragListener listener){ mListener = listener; }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_hygene_tips_rv, container, false);
        newsrecyclerView =(RecyclerView) rootView.findViewById(R.id.rv_noticeboard);
        nwlinearLayoutManager = new LinearLayoutManager(getActivity());
        nwlinearLayoutManager.setStackFromEnd(true);

        dbref = FirebaseDatabase.getInstance().getReference();
        newsprogressBar = (ProgressBar) rootView.findViewById(R.id.newsprogress_bar);
        newsprogressBar.setVisibility(View.VISIBLE);

        firebasenewsRecycleAdapter = new FirebaseRecyclerAdapter<HygeneTipsModel, HygeneTipsModelVH>(
                HygeneTipsModel.class,
                R.layout.fragment_hygene_tips_cv,
                HygeneTipsModelVH.class,
                dbref.child(NEWS)) {
            //NewsModel dbModel = NewsModel. .getInstance();
            @Override
            protected void populateViewHolder(HygeneTipsModelVH viewHolder, final HygeneTipsModel model, final int position) {
                viewHolder.newsHead.setText(model.getTitle());
                viewHolder.newsBody.setText(model.getTitleBody());
                newsprogressBar.setVisibility(View.GONE);
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //firebasenewsRecycleAdapter.getRef(position).removeValue();
                        openNewsDetailActivity(model.getTitle(), model.getTitleBody());
                    }
                });
            }

            private void openNewsDetailActivity(String...details) {
                Intent newsIntent = new Intent(getActivity(), ShowHygeneTipsDetails.class);
                newsIntent.putExtra("TTTLE_KEY", details[0]);
                newsIntent.putExtra("DESC_KEY", details[1]);
                //newsIntent.putExtra("ORG_KEY", details[2]);

                startActivity(newsIntent);
            }
        };
        newsrecyclerView.setLayoutManager(nwlinearLayoutManager);
        newsrecyclerView.setAdapter(firebasenewsRecycleAdapter);

        return rootView;



    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnHomeTabFragListener) {
            mListener = (OnHomeTabFragListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }


    public static interface OnHomeTabFragListener {
        // TODO: Update argument type and name
        void itemClicked(int p,long id);
    }
}