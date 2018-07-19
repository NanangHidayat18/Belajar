package com.example.hp.approvallatihan1;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<UserModel> mlListUser;
    private Context mContext1;

    public UserAdapter(List<UserModel> mlListUser, Context mContext1){
        this.mlListUser= mlListUser;
        this.mContext1= mContext1;
    }
    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserModel user = mlListUser.get(position);

        holder.tvUserName.setText("User Name : " + user.getName() + "\n" + "User Age : " + user.getAge());

    }
    @Override
    public int getItemCount(){
        return mlListUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvUserName;

        public ViewHolder(View itemView){
            super(itemView);
            tvUserName=(TextView) itemView.findViewById(R.id.text_view_user_name);
        }
    }
}
