package wkzteam.android.cinema;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Objects;

public class VideoPlayerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_player, container, false);

        TextView name = view.findViewById(R.id.nameVideo);

        int arg = getArguments().getInt("position");

        String catVideoPath      = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.cats;
        String giraffeVideoPath  = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.giraffe;
        String sealVideoPath     = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.seal;
        String elephantVideoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.elephants;
        String cakeVideoPath     = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.cake;
        String sneakVideoPath    = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.sneak;

        VideoView videoView = view.findViewById(R.id.videoView);
        Uri myVideoUri= Uri.parse(catVideoPath);
        switch (arg) {
            case 0:
                myVideoUri = Uri.parse(catVideoPath);
                name.setText("Котики");
                break;
            case 1:
                myVideoUri = Uri.parse(giraffeVideoPath);
                name.setText("Жирафики");
                break;
            case 2:
                myVideoUri = Uri.parse(sealVideoPath);
                name.setText("Тюлень чихает");
                break;
            case 3:
                myVideoUri = Uri.parse(elephantVideoPath);
                name.setText("Слоники");
                break;
            case 4:
                myVideoUri = Uri.parse(cakeVideoPath);
                name.setText("Пончики");
                break;
            case 5:
                myVideoUri = Uri.parse(sneakVideoPath);
                name.setText("Змейки");
                break;
            default:break;
        }
        videoView.setVideoURI(myVideoUri);
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        return view;
    }
}