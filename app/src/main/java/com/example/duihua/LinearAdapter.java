package com.example.duihua;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.duihua.model.UserMessage;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private Context mContext;
    private List<UserMessage> mUserWordMessageList;


    public LinearAdapter(List<UserMessage> userWordMessageList) {
        mUserWordMessageList = userWordMessageList;
    }

    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if (viewType == UserMessage.TYPE_RECEIVE)
//            return new LinearViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_linear_item1, parent, false));
             //        }else{
            return new LinearViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_linear_item2, parent, false));
        }

    @Override
    public void onBindViewHolder(LinearAdapter.LinearViewHolder holder, int position) {
        UserMessage msg = mUserWordMessageList.get(position);
//        if (msg.getType() == UserMessage.TYPE_RECEIVE)
//            holder.tv3.setText(msg.getContent());
//        else
            holder.tv2.setText(msg.getContent());
    }

    @Override
    public int getItemCount() {
        return mUserWordMessageList.size();
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private TextView tv3,tv2;

        public LinearViewHolder(View itemView) {
            super(itemView);
            tv3 = itemView.findViewById(R.id.tv3);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
