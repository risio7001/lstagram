package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lstagram.R;

import java.util.ArrayList;

public class galleryAdapter extends RecyclerView.Adapter<galleryAdapter.galleryViewHolder> {

    private ArrayList arrayList;
    private Context context;

    public class galleryViewHolder extends RecyclerView.ViewHolder {
        ImageView gallery_image;
        public galleryViewHolder(@NonNull View itemView) {      //  item xml view 연결하기
            super(itemView);
            this.gallery_image = itemView.findViewById(R.id.gallery_image);
        }
    }

    public galleryAdapter(ArrayList arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public galleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  // item View 연결하기
        CardView view = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        galleryViewHolder holder = new galleryViewHolder(view);
        return holder; // BindViewHolder로 반환
    }

    @Override
    public void onBindViewHolder(@NonNull galleryViewHolder holder, int position) {     // 넣을 내용
        holder.gallery_image.setImageBitmap();


    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
