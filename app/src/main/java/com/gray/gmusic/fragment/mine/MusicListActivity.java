package com.gray.gmusic.fragment.mine;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.gray.gmusic.R;
import com.gray.gmusic.adapter.MyMusicAdapter;

import java.io.File;
import java.util.ArrayList;

public class MusicListActivity extends AppCompatActivity {

    private ListView listViewMusicList;
    private ArrayList<String> musicList = null;
    private File musicDir;
    private File[] musicsNameArray;
    MyMusicAdapter myMusicAdapter;

    private void setupView() {
        listViewMusicList = (ListView) findViewById(R.id.lv_music_list);
        musicList = new ArrayList<String>();
        musicDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        musicsNameArray = musicDir.listFiles();

    }
    private void getAllMusicFromMusicDir(){
        if (musicsNameArray != null) {
            for (int i = 0; i < musicsNameArray.length; i++) {
                musicList.add(musicsNameArray[i].getName());
            }
        }
        myMusicAdapter = new MyMusicAdapter(musicList, this);
        listViewMusicList.setAdapter(myMusicAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);

        setupView();
        getAllMusicFromMusicDir();
    }
}
