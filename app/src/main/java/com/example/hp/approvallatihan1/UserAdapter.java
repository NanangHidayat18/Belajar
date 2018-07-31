package com.example.hp.approvallatihan1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<UserModel> mlListUser;
    private OnClickItemListener onClickItemListener;

    // persiapan onclick dalam adapter
    interface OnClickItemListener{
        void onClickItem(UserModel usermodel);
    }

    public UserAdapter(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }
    //end persiapan onclick dalam adapter

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView user, cuti, year;
        public LinearLayout llUser;

        public ViewHolder(View view) {
            super(view);
            user = (TextView) view.findViewById(R.id.user);
            cuti = view.findViewById(R.id.cuti);
            year = (TextView) view.findViewById(R.id.year);
            llUser = view.findViewById(R.id.ll_item_user);
        }

        public void bind (UserModel userModel){
            user.setText(userModel.getName());
            cuti.setText(userModel.getCuti());
            year.setText(userModel.getYear());

            llUser.setOnClickListener(view -> {
                if(onClickItemListener!=null){
                    onClickItemListener.onClickItem(userModel);
                }
            });
        }
    }

    public UserAdapter(List<UserModel> mlListUser) {
        this.mlListUser = mlListUser;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserModel userModel = mlListUser.get(position);
        holder.bind(userModel);
    }

    @Override
    public int getItemCount() {
        return mlListUser.size();
    }
}


