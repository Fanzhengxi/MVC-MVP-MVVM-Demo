package com.example.mvvm.recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.R;
import com.example.mvvm.databinding.RecycleItemBinding;
import com.example.mvvm.util.TextUtils;

import org.w3c.dom.Text;

import java.util.List;
import java.util.PrimitiveIterator;

/**
 * Created by fan.zx
 * Date: 2020/12/24 16:29
 * Describe:
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleHolder> {
    private Context context;
    private List<TestBean> list;

    public RecycleAdapter(Context context, List<TestBean> data) {
        this.context = context;
        this.list = data;
    }

    /**
     * 绑定recycle view的Item布局
     */
    @NonNull
    @Override
    public RecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //使用recycleItemBinding来绑定recycle的View ,类似ActivityMainActivityBinding
        RecycleItemBinding recycleItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.recycle_item, parent, false);
        RecycleHolder holder=new RecycleHolder(recycleItemBinding.getRoot());
        holder.setRecycleItemBinding(recycleItemBinding);
        return holder;
    }
//显示数据
    @Override
    public void onBindViewHolder(@NonNull RecycleHolder holder, int position) {
         TestBean testBean=list.get(position);
         holder.recycleItemBinding.setTestBean(testBean);
         holder.recycleItemBinding.executePendingBindings();//绑定数据时更新UI
//        holder.tvName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"findViewById:"+testBean.getName(),Toast.LENGTH_SHORT).show();
//            }
//        });
        holder.recycleItemBinding.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"recycleItemBinding.name:"+testBean.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecycleHolder extends RecyclerView.ViewHolder {
        private RecycleItemBinding recycleItemBinding;
        private TextView tvName;
        public RecycleHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.name);
        }

        public RecycleItemBinding getRecycleItemBinding() {
            return recycleItemBinding;
        }

        public void setRecycleItemBinding(RecycleItemBinding recycleItemBinding) {
            this.recycleItemBinding = recycleItemBinding;
        }
    }
}
