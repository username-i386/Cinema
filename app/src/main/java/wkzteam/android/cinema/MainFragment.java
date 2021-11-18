package wkzteam.android.cinema;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MainFragment extends Fragment {

    RecyclerView list;
    Adapter adapter;
    NavController controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ArrayList<String> videoNameList = new ArrayList<>();
        videoNameList.add("Котики");
        videoNameList.add("Жирафики");
        videoNameList.add("Тюлень чихает");
        videoNameList.add("Cлоники");
        videoNameList.add("Пончики");
        videoNameList.add("Змейки");

        ArrayList<Integer> imgList = new ArrayList<>();
        imgList.add(R.drawable.cat);
        imgList.add(R.drawable.giraffe);
        imgList.add(R.drawable.seal);
        imgList.add(R.drawable.elephants);
        imgList.add(R.drawable.cackes);
        imgList.add(R.drawable.sneake);

        list = view.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(videoNameList, imgList);
        list.setAdapter(adapter);

        return view;
    }

    class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        List<String> dateList;
        List<Integer> imgList;

        Adapter(List<String> data, List<Integer> imgList) {
            this.dateList = data;
            this.imgList = imgList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.recycler_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MainFragment.Adapter.ViewHolder holder, int position) {
            holder.text.setText(dateList.get(position));
            holder.imageView.setImageResource(imgList.get(position));
            holder.cl.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                controller = Navigation.findNavController(requireActivity(), R.id.container);
                controller.navigate(R.id.videoPlayerFragment, bundle);
            });
        }

        @Override
        public int getItemCount() {
            return dateList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView text;
            ConstraintLayout cl;
            ImageView imageView;
            public ViewHolder(View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.name);
                cl = itemView.findViewById(R.id.recyclerItem);
                imageView = itemView.findViewById(R.id.avatar);
            }
        }
    }
}